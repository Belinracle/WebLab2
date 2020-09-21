document.addEventListener("DOMContentLoaded", function() {
    let storage = window.sessionStorage;
    let color = storage.getItem('color');
    document.querySelector('#form').style.background = color;
    let X = storage.getItem('X');
    let R = storage.getItem('R');
    if(window.sessionStorage.getItem('results')){
        document.querySelector('#results').innerHTML = storage.getItem('results');
    }
    document.querySelectorAll('[name=R]').forEach(function (){
        if(this.value===R)this.checked =true;
    })
    document.querySelector('[name=Y]').value = storage.getItem('Y');
    document.querySelector('#point').innerHTML = storage.getItem('point');
    let select = document.querySelector("select");
    for (let i =0; i<select.length;i++ ){
        if(select.options[i].value===X) {
            select.options[i].selected=true;
            break;
        }
    }
});