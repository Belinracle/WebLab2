let inputs = document.querySelectorAll("[name = R]");
let selector = document.querySelector('select');
let textField = document.querySelector('[name=Y]');
let form = document.querySelector('#form');
document.querySelector('[name=Y]').addEventListener('input',isValid);
for (let i = 0; i < inputs.length; i++){
    let current = inputs[i];
    current.addEventListener('input', isValid);
}
function isValid() {
    if (radio() && text()) {
        window.sessionStorage.setItem("X",selector.value);
        form.style.background = 'rgb(0,153,0)';
        window.sessionStorage.setItem('color', 'rgb(0,153,0)');
    } else {
        window.sessionStorage.setItem('color', 'rgb(197,29,52)');
        form.style.background = 'rgb(197,29,52)';
    }
}
function radio(){
    for (let i =0;i<inputs.length; i++){
        if (inputs[i].checked===true) {
            window.sessionStorage.setItem("R",inputs[i].value)
            return true;
        }
    }
    return false
}
function text(){
    window.sessionStorage.setItem(textField.name, textField.value);
    let num = filterFloat(textField.value.replace(",",".").trim());
    if (num!=='NaN'){
        return num >= -5 && num <= 3;
    }
    else return false;
}
let filterFloat = function (value) {
    if (value.length>14) return 'NaN';
    if(/^(-|\+)?([0-9]+(\.[0-9]+)?)$/
        .test(value))
        return Number(value);
    return 'NaN';
};