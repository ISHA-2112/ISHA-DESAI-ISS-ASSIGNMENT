document.getElementById('finance-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Get form values
    const date = document.getElementById('date').value;
    const description = document.getElementById('description').value;
    const amount = document.getElementById('amount').value;
    const type = document.getElementById('type').value;

    // Create a new table row
    const newRow = document.createElement('tr');

    // Create cells for each value

    const dateCell = document.createElement('td');
    dateCell.textContent = date;
  
    
    newRow.appendChild(dateCell);

    const descriptionCell = document.createElement('td');
    descriptionCell.textContent = description;
    newRow.appendChild(descriptionCell);

    const amountCell = document.createElement('td');
    amountCell.textContent = amount;
    newRow.appendChild(amountCell);

 


    // Add the new row to the table
    if (type == "income"){

    
        document.querySelector('#income-table tbody').appendChild(newRow);
        updateTotalAmount("income-table");
        // Show the table and if it's hidden
        const heading = document.getElementById('Income');
        if (heading.classList.contains('hidden')) {
            heading.classList.remove('hidden');
        }
        const table = document.getElementById('income-table');
        if (table.classList.contains('hidden')) {
            table.classList.remove('hidden');
        }
    }

    else{
        document.querySelector('#expen-table tbody').appendChild(newRow);
        updateTotalAmount("expen-table");
        // Show the table and if it's hidden
        const heading = document.getElementById('Expenditure');
        if (heading.classList.contains('hidden')) {
            heading.classList.remove('hidden');
        }
        const table = document.getElementById('expen-table');
        if (table.classList.contains('hidden')) {
            table.classList.remove('hidden');
        }
    }
    // Clear the form
    document.getElementById('finance-form').reset();
});

function updateTotalAmount(table_name) {
    var inc_exp = "#"+table_name+" tbody tr"
    const rows = document.querySelectorAll(inc_exp);
    let totalAmount = 0;
 
    const table = document.getElementById(table_name);

    // Get all the rows in the tbody
    const rowse = table.getElementsByTagName('tbody')[0].getElementsByTagName('tr');

    // Loop through each row
    for (let i = 0; i < rowse.length; i++) {
        if (i == rowse.length-2){
            continue;
        }
        const row = rowse[i];

        // Loop through each cell in the row
        for (let j = 0; j < row.cells.length; j++) {
            const cell = row.cells[j];
            if (j==2){
       
                totalAmount += parseFloat(cell.textContent)
            }
           
        }
    }

    // Create a new row for total amount
    const totalRow = document.createElement('tr');

    // Create cells for total row
    

    const totalLabelCell = document.createElement('td');
    totalLabelCell.textContent = 'TOTAL:';
    totalRow.appendChild(totalLabelCell);
    const emptyCell = document.createElement('td');
    emptyCell.textContent = '';
    totalRow.appendChild(emptyCell);

    const totalAmountCell = document.createElement('td');
    totalAmountCell.textContent = totalAmount.toFixed(2); // Format total amount to 2 decimal places
    totalRow.appendChild(totalAmountCell);

 

    // Remove previous total row if exists
    const existingTotalRow = document.getElementById(table_name+' total-row');
    if (existingTotalRow) {
        existingTotalRow.remove();
    }
    var inc_exp = "#"+table_name+" tbody"
    // Add the total row to the table
    const tableBody = document.querySelector(inc_exp);
    totalRow.id = table_name+' total-row';
    tableBody.appendChild(totalRow);
    totalRow.style.backgroundColor = '#0E46A3';
    totalRow.style.color = '#ffffff';
    totalRow.style.fontWeight = 'bold'
   
}