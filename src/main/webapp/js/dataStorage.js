document.addEventListener("DOMContentLoaded", function() {
    let storage = window.localStorage;
    document.querySelector('.form').style.background = storage.getItem('color');
    let X = storage.getItem('X');
    let R = storage.getItem('R');
    document.querySelectorAll('[name=R]').forEach(function (){
        if(this.value===R)this.checked =true;
    })
    document.querySelector('input[name=Y]').value = storage.getItem('Y');
    let select = document.querySelector("select");
    for (let i =0; i<select.length;i++ ){
        if(select.options[i].value===X) {
            select.options[i].selected=true;
            break;
        }
    }
});