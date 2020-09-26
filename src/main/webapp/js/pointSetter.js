document.addEventListener("DOMContentLoaded",draw);
let pointPlace = document.querySelector(".pointPlace");
function draw() {
    let tableRows = document.querySelectorAll(".row");
    for (let i = 0; i < tableRows.length; i++) {
        let params = getParams(tableRows[i].innerHTML);
        addPoint(computeX(params[0], params[2]), computeY(params[1], params[2]))
    }
}
function addPoint(x,y){
    let str ='<circle color="white" r="5" cx="'+x+'" cy="'+y+'">';
    pointPlace.insertAdjacentHTML("afterbegin",str)
}
function computeX(x,r){
    return 250 + x / r * 200;
}
function computeY(y,r){
    return 250 - y / r * 200;
}
function getParams(row){
    return row.replaceAll("<","").replaceAll(">","").replaceAll("td","").split("/");
}