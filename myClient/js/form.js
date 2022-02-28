document.addEventListener('DOMContentLoaded', function () {
    var btnSubmit = document.getElementById("btn-submit");
    var txtLoanAmount = document.forms['add-form']['loanAmount'];
    var txtTenure = document.forms['add-form'][''];
    var txtRate = document.forms['add-form']['rate'];

    btnSubmit.onclick = function (){
        var loanAmount = txtLoanAmount.value;
        var tenure = txtTenure.value;
        var rate = txtRate.value;
        var dataToSend = {
            "loanAmount": loanAmount,
            "tenure": tenure,
            "rate": rate
        }
        var xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.onreadystatechange = function () {
            if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 201) {
                alert('Create product success!');
                window.location.href = "/myClient/list.html";
            }
        }
        xmlHttpRequest.open('post', 'http://localhost:8080/api/v1/products', false);
        xmlHttpRequest.setRequestHeader('Content-Type', 'application/json');
        xmlHttpRequest.send(JSON.stringify(dataToSend));
    }
})
