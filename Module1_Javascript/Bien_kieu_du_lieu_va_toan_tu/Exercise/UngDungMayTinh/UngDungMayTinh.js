function add() {
    let n1 = parseInt(document.getElementById("in1").value);
    let n2 = parseInt(document.getElementById("in2").value);
    let result = document.getElementById("result");
    result.innerText = (n1+n2).toString();
}
function sub() {
    let n1 = document.getElementById("in1").value;
    let n2 = document.getElementById("in2").value;
    let result = document.getElementById("result");
    result.innerText = (n1-n2).toString();
}
function mul() {
    let n1 = document.getElementById("in1").value;
    let n2 = document.getElementById("in2").value;
    let result = document.getElementById("result");
    result.innerText = (n1*n2).toString();
}
function div() {
    let n1 = document.getElementById("in1").value;
    let n2 = document.getElementById("in2").value;
    let result = document.getElementById("result");
    result.innerText = (n1/n2).toString();
}