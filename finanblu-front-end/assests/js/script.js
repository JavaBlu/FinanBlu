// window.onload = function() {

//     alert("FinanBlu is great!!!")
// };

let logar = () =>{

    let email = document.dados.email.value; 
    let emailArr = email.split('');
    
    let cont =0;
    let arroba = [];
    for (let i = emailArr.length; i > 0; i--) {
        cont++
        if(cont <= 11){
            arroba[cont] = emailArr[i];
        }   
    }
    
    if(arroba.reverse().join('') !== "@gmail.com"){
        let element = document.getElementById('element');
        element.innerHTML = '<p style="color:red;">gmail invalido por favor adicionar o @gmail.com</p>' + email

    }
    
    
    let senha = document.dados.senha.value;
    if(senha == ""){
        document.getElementById("msg") .style.display = "block";
    }
    
    return true;
}


//teste
let windowTr = () => {
     window.location.href="http://127.0.0.1:5500/dashboard/";
    
}