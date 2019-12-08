

/*---------------- Defining html elements and objects ------------*/


// The url endpoints
const endpoints = {
    customers : 'http://localhost:49000/api/customers',
    customer : id => {return `http://localhost:49000/api/customers/${id}`},
    accounts : 'http://localhost:49000/api/accounts'
}


// The Main content card
const mainCard = document.querySelector('.main-container-template').content.querySelector('.main-container');;



/*----------------  Set event listeners and render some data on initial load  ------------*/


document.addEventListener('DOMContentLoaded', function() {
    console.log(mainCard);
    //Initialise navigation tabs
    var tabs = document.querySelectorAll('.tabs')
    for (var i = 0; i < tabs.length; i++){
        M.Tabs.init(tabs[i]);
    }



    //Load customers
    getRequests(endpoints.customers, showAllCustomers)
    document.getElementById('customers').appendChild(mainCard);

    //Add event listeners to table urls
    document.querySelector('.card-content').addEventListener("click", event => {
        if(event.target.className === 'customer-table-link'){
            //debugger;
            getRequests(endpoints.customer(event.target.parentElement.id), showCustomerDetail);
        }
        if(event.target.className === 'customeraccount-table-link'){
            //debugger;
            getRequests(endpoints.customer(event.target.parentElement.id), showCustomerDetailAccounts);
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
    console.log("getRequests run");
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
            })
}






/*---------------- Functions to manipulate html elements  ------------*/



// >>>>> See how to optimise below functions into one
// Return details of single customer from accounts page
function showCustomerDetailAccounts(data){
    console.log(data);
    let cardContent = { content : customerTable([data]),
        title : 'Customer Details',
        titleText : `
        <br>
        <button class="btn waves-effect waves-light" style="background-color:#8588d6;" onclick="getRequests(endpoints.accounts, showAllAccounts)">go back
        <i class="material-icons left small">arrow_back</i>
        </button>
        <br>
      <br>
        `};

    setMainCard(cardContent);
}



// Return details of single customer
function showCustomerDetail(data){
    console.log(data);
    let cardContent = { content : customerTable([data]),
        title : 'Customer Details',
        titleText : `
        <br>
        <button class="btn waves-effect waves-light" id="go-back-btn" style="background-color:#8588d6;" onclick="getRequests(endpoints.customers, showAllCustomers)">go back
        <i class="material-icons left small">arrow_back</i>
        </button>
        <br>
      <br>
        `};

    setMainCard(cardContent);
}




/* Generate table with all customers */
function showAllCustomers(data){
    
    let cardContent = { content : customerTable(data),
        title : 'Customers',
        titleText : `<p> Show all customers </p>`};

    setMainCard(cardContent);
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


/* Generate table with all accounts */
function showAllAccounts(data){
    let cardContent = { content : accountTable(data),
        title : 'Accounts',
        titleText : `<p> Show all Accounts </p>`};
    
    setMainCard(cardContent);
}



// Return a table with with account data
function accountTable(data){

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
                <td> ${th.accountNumber} </td> 
                <td class="account-table-link"> ${th.accountType} </td>
                <td> € ${th.balance} </td>
                <td class="customeraccount-table-link"> ${th.customerName} </td>
                <td> ${th.sortCode} </td> 
                <td> ${th.created} </td> 
            </tr>
            `;
    }
    return generateTable(theaders, tablerows);
}



// Return a table based on theader and tbody input
function generateTable(theaders, tablerows){
        const table = ` 
          <table class="highlight">
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