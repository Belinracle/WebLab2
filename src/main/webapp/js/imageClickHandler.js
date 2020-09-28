let svg = document.querySelector("svg");
document.querySelector(".image").addEventListener("click", function (event) {
    if (checkRadio()) {
        let r = getR();
        let pt = svg.createSVGPoint();
        pt.x = event.clientX;
        pt.y = event.clientY;
        let globalPoint = pt.matrixTransform(svg.getScreenCTM().inverse())
        textField.value = (((-1) * (globalPoint.y - 250)) / 200 * r).toString();
        if(checkText()) {
            select.insertAdjacentHTML("afterbegin", "<option selected>" + (globalPoint.x - 250) / 200 * r + "</option>");
            sendButton.click();
        }
    }
    else{
        alert("Для того, чтобы работал выбор координат по клику на картинке, необходимо выбрать R")
    }
})

function getR() {
    for (let i = 0; i < radios.length; i++) {
        if (radios[i].checked === true) {
            return radios[i].value;
        }
    }
}