let textField = document.querySelector("[name=Y]");
let select = document.querySelector("select");
let radios = document.querySelectorAll("[name=R]");
let form = document.querySelector(".form");
let storage = window.localStorage;

document.addEventListener("DOMContentLoaded", validate);

textField.addEventListener("input",validate)
radios.forEach(function (){
    this.addEventListener("click",validate)
})

function validate(){
    if(checkText()&&checkSelect()&&checkRadio()){
        form.style.background = 'rgb(0,153,0)';
        window.sessionStorage.setItem('color', 'rgb(0,153,0)');
        document.querySelector("#sendButton").type ="submit";
    } else {
        window.sessionStorage.setItem('color', 'rgb(197,29,52)');
        form.style.background = 'rgb(197,29,52)';
        document.querySelector("#sendButton").type ="button";
    }
}

function checkText(){
    try {
        let str = textField.value.replace(',','.').trim()
        let num = parseFloat(str);
        storage.setItem("Y",str);
        return (!isNaN(+str)&&!isNaN(num)&&parseFloat(str.substr(0,14))>-5&&parseFloat(str.substr(0,14))<3)
    }catch (e){
        return false
    }
}

function checkSelect(){
    console.log(select.value)
    storage.setItem("X",select.value)
    return true
}

function checkRadio(){
    for (let i=0;i<radios.length;i++){
        if (radios[i].checked===true){
            storage.setItem("R",radios[i].value)
            return true;
        }
    }
    return false;
}