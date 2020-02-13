function convert() {
    let money = document.getElementById("money").value;
    let fromCur = document.getElementById("fromCur").value;
    let toCur = document.getElementById("toCur").value;
    let result = document.getElementById("result");
    if (fromCur == "US" && toCur == "VN")
        result.innerText = "Result " + (money * 23000) + "VND";
    if (fromCur == "VN" && toCur == "US")
        result.innerText = "Result " + (money / 23000) + "USD";
}

