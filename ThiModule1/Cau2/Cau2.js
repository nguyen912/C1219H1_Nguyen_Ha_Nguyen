function isMainNumber(n) {
    if (n === 0) {
        return false;
    }
    else if (Math.sqrt(n) === parseInt(Math.sqrt(n))) {
        return true;
    }
    else {
        return false;
    }
}
let num = parseInt(prompt("Nhap mot so bat ky:"));
if (isMainNumber(num) === true) {
    alert(num + " la so chinh phuong.");
}
else {
    alert(num + " KHONG phai la so chinh phuong.");
}
