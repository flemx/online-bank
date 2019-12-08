

/*---------------- Defining html elements and objects ------------*/


// The url endpoints
const endpoints = {
    customers : './api/customers',
    customer : id => {return `./api/customers/${id}`},
    accounts : './api/accounts',
    account : id => {return `./api/accounts/${id}`}
}


// The Main content card
const mainCard = document.querySelector('.main-container-template').content.querySelector('.main-container');;


// Related list html element
function relatedLists(icon, title, content) { 
return ` 
    <ul class="collapsible related-list-container">
        <li>
        <div class="collapsible-header">
            <i class="material-icons" style="margin-right:5%;">${icon}</i>
                ${title}
            <i class="material-icons">keyboard_arrow_down</i>
        </div>
        <div class="collapsible-body">
            <!-- CONTENT HERE -->
            ${content}
        </div>
        </li>
    </ul>
    `
}



function detailGoback(onclick){
    return `
        <br>
        <button class="btn waves-effect waves-light" style="background-color:#8588d6;" onclick="${onclick}">go back
        <i class="material-icons left small">arrow_back</i>
        </button>
        <br>
        <br>
`
}




/*----------------  Set event listeners and render some data on initial load  ------------*/


document.addEventListener('DOMContentLoaded', function() {
    console.log(mainCard);
    //Initialise navigation tabs
    var tabs = document.querySelectorAll('.tabs')
    for (var i = 0; i < tabs.length; i++){
        M.Tabs.init(tabs[i]);
    }

    //Initialising modals
    let modalElems = document.querySelectorAll('.modal');
    var modalInstances = M.Modal.init(modalElems);



    //Load customers
    getRequests(endpoints.customers, showAllCustomers)
    document.getElementById('customers').appendChild(mainCard);

    //Add event listeners to table urls
    document.querySelector('.card-content').addEventListener("click", event => {

        switch(event.target.className) {
            case 'customer-table-link':
            getRequests(endpoints.customer(event.target.parentElement.id), showCustomerDetail);
              break;
            case 'customeraccount-table-link':
            getRequests(endpoints.customer(event.target.id), showCustomerDetailAccounts);
              break;
            case 'account-table-link':
            getRequests(endpoints.account(event.target.parentElement.id), showAccountDetail);
               break;
            case 'accountcustomer-table-link':
            getRequests(endpoints.account(event.target.parentElement.id), showAccountDetailCustomer);
                break;
            default:
              // code block  
          }

        
    });


});


//Event listeners for main navigation menu 
function accountListener(){
    getRequests(endpoints.accounts, showAllAccounts);
    document.getElementById('accounts').appendChild(mainCard);
}
function customerListener(){
    getRequests(endpoints.customers, showAllCustomers)
    document.getElementById('customers').appendChild(mainCard);
}

/*----------------  Functions to fetch data  ------------*/



// Run get requests and execute the result in the function given
function getRequests(url, func){
    console.log(`Executing GET request to: ${url}`);
    fetch(url,{
        mode: 'no-cors',
        method : 'GET',
        headers: {
            'Content-Type': 'application/json'
          }})
            .then((resp) => resp.json())
            .then(data => {
                func(data);
                })
            .catch(error => {
                console.error(error);
                showError();
            })
}






/*---------------- Functions to manipulate html elements  ------------*/


function showError(){
    let cardContent = { content : "",
        title : '',
        titleText : `
        <div class="main-404">
            <div class="fof-404">
                    <h1>Error 404</h1>
            </div>
        </div>
        `};

    setMainCard(cardContent);
}



// Set related list on detail page

function createRelatedList(data){
    
    let el = document.createElement('div');
    el.innerHTML = relatedLists('mail_outline', 'Show Accounts', customerAccounts(data.accounts));
    mainCard.querySelector('.main-card-content').appendChild(el);
    //Initialise collapse effect
    M.Collapsible.init(document.querySelectorAll('.collapsible'));
}


// Return details of single Account from customer detail page
function showAccountDetailCustomer(data){
    console.log(data);
    let cardContent = { content : customerAccounts([data]),
        title : 'Account Details',
        titleText : detailGoback(`getRequests(endpoints.customer(${data.customerId}), showCustomerDetail)`)
    };

    setMainCard(cardContent);
    document.querySelector('.accountcustomer-table-link').className = '';
}



// Return details of single Account
function showAccountDetail(data){
    console.log(data);
    let cardContent = { content : accountsPage([data]),
        title : 'Account Details',
        titleText : detailGoback('getRequests(endpoints.accounts, showAllAccounts)')
    };

    setMainCard(cardContent);
    document.querySelector('.account-table-link').className = '';
}




// Return details of single customer from accounts page
function showCustomerDetailAccounts(data){
    console.log(data);
    let cardContent = { content : customerTable([data]),
        title : 'Customer Details',
        titleText : detailGoback('getRequests(endpoints.accounts, showAllAccounts)')
        };

    setMainCard(cardContent);
    document.querySelector('.customer-table-link').className = '';

    createRelatedList(data);
}



// Return details of single customer
function showCustomerDetail(data){
    console.log(data);
    let cardContent = { content : customerTable([data]),
        title : 'Customer Details',
        titleText : detailGoback('getRequests(endpoints.customers, showAllCustomers)')
       };

    setMainCard(cardContent);
    document.querySelector('.customer-table-link').className = '';
    
    createRelatedList(data);
}


/* Generate table with all transactions */
function showAllTransaction(data){


    let titleText =   `
    <div class="search-container">
        <input type="text" class="searchBar" onkeyup="myFunction()" placeholder="Search for transactions.." title="Type in a name">
        <button  data-target="modal1" class="btn waves-effect waves-light main-add-button modal-trigger"  style="background-color:#8588d6;">  Add Customer
        <i class="material-icons left small">add</i>
        </button>
    </div>
        `

    //inner-container
    let cardContent = { content : customerTable(data),
        title : 'Customers',
        titleText : titleText};

    setMainCard(cardContent);
}



/* Generate table with all customers */
function showAllCustomers(data){


    let titleText =   `
    <div class="search-container">
        <input type="text" class="searchBar" onkeyup="myFunction()" placeholder="Search for customers.." title="Type in a name">
        <button  data-target="modal1" class="btn waves-effect waves-light main-add-button modal-trigger"  style="background-color:#8588d6;">  Add Customer
        <i class="material-icons left small">add</i>
        </button>
    </div>
        `

    //inner-container
    let cardContent = { content : customerTable(data),
        title : 'Customers',
        titleText : titleText};

    setMainCard(cardContent);
}


/* Generate table with all accounts */
function showAllAccounts(data){
    let cardContent = { content : accountsPage(data),
        title : 'Accounts',
        titleText : `
        <div class="search-container">
            <input type="text" class="searchBar" onkeyup="myFunction()" placeholder="Search for accounts..">
            <button  data-target="modal2" class="btn waves-effect waves-light main-add-button modal-trigger"  style="background-color:#8588d6;">  Add Account
            <i class="material-icons left small">add</i>
            </button>
        </div>
        `};
    
    setMainCard(cardContent);
}


// Return a table with with transactions data
function customerTable(data){

    const theaders = `
    <th>ID</th>
    <th>amount</th>
    <th>type</th>
    <th>accountNumber</th>
    <th>accountNumber</th>
    <th>type<th>`;

    let tablerows = ``;

    for(let th of data){
        tablerows = tablerows + `
            <tr id="${th.id}">
                <td> ${th.id} </td> 
                <td class="customer-table-link"> ${th.name} </td>
                <td> ${th.address} </td>
                <td> ${th.email} </td> 
                <td> ${th.created} </td> 
            </tr>
            `;
    }
    return generateTable(theaders, tablerows);
}



// Return a table with with customer data
function customerTable(data){

    const theaders = `
    <th>ID</th>
    <th>Name</th>
    <th>Address</th>
    <th>Email</th>
    <th>Created<th>`;

    let tablerows = ``;

    for(let th of data){
        tablerows = tablerows + `
            <tr id="${th.id}">
                <td> ${th.id} </td> 
                <td class="customer-table-link"> ${th.name} </td>
                <td> ${th.address} </td>
                <td> ${th.email} </td> 
                <td> ${th.created} </td> 
            </tr>
            `;
    }
    return generateTable(theaders, tablerows);
}



// Return a table with with account data
function accountTable(data, classname){

    const theaders = `
    <th>Number</th>
    <th>Type</th>
    <th>Balance</th>
    <th>Customer</th>
    <th>Sort Code</th>
    <th>Created<th>`;

    let tablerows = ``;

    for(let th of data){
        tablerows = tablerows + `
            <tr id="${th.accountNumber}">
                <td  class="${classname}"> ${th.accountNumber} </td> 
                <td> ${th.accountType} </td>
                <td> € ${th.balance} </td>
                <td class="customeraccount-table-link" id="${th.customerId}"> ${th.customerName} </td>
                <td> ${th.sortCode} </td> 
                <td> ${th.created} </td> 
            </tr>
            `;
    }
    return generateTable(theaders, tablerows);
}

// Below functions called based on main accounts page or related list
function accountsPage(data){
    return accountTable(data,'account-table-link');
}
function customerAccounts(data){
    return accountTable(data,'accountcustomer-table-link');
}



// Return a table based on theader and tbody input
function generateTable(theaders, tablerows){
        const table = ` 
          <table class="highlight responsive-table">
              <thead>
                <tr>
                    ${theaders}
                </tr>
              </thead>
              <tbody>
                    ${tablerows}
              </tbody>
          </table>
    `;
    return table;
 }
 
 

 // Function to set content of main content card -> use object
function setMainCard(data){
    // Use String
    mainCard.querySelector('.main-card-title').textContent = data.title;
    // Use template string
    mainCard.querySelector('.main-card-title-text').innerHTML = data.titleText;
    // Use template string
    mainCard.querySelector('.main-card-content').innerHTML = data.content

}