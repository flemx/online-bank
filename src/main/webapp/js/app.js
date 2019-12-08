

/*  Defining html elements and objects */


// The url endpoints
const endpoints = {
    customers : 'http://localhost:49000/api/customers'
}


// The Main content card
const mainCard = document.querySelector('.main-container-template').content.querySelector('.main-container');;



document.addEventListener('DOMContentLoaded', function() {
    
    console.log(mainCard);

    //Initialise navigation tabs
    var tabs = document.querySelectorAll('.tabs')
    for (var i = 0; i < tabs.length; i++){
        M.Tabs.init(tabs[i]);
    }

    //Load customers
    getRequests(endpoints.customers, customerTable)
    document.getElementById('customers').appendChild(mainCard);

});



/* Functions to fetch data */


// Run get requests and execute the result in the function given
function getRequests(url, func){
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




/*  Functions to manipulate html elements  */

function customerTable(data){
    console.log(data);

    const theaders = `
    <th>ID</th>
    <th>Name</th>
    <th>Address</th>
    <th>Email</th>
    <th>Created<th>`;


    let tablerows = ``;

    for(let th of data){
        tablerows = tablerows + `
            <tr>
                <td> ${th.id} </td> 
                <td> ${th.name} </td>
                <td> ${th.address} </td>
                <td> ${th.email} </td> 
                <td> ${th.created} </td> 
            </tr>
            `;
    }



    let cardContent = { content : generateTable(theaders, tablerows),
                        title : 'Customers',
                        titleText : `<p> Show all customers </p>`};
    
    setMainCard(cardContent);

}



function generateTable(theaders, tablerows){
        //console.log(data);

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