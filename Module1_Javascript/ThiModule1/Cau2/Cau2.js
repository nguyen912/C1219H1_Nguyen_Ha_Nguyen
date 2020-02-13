function isMainNumber(n) {
   return (Math.pow(Math.sqrt(n),2) === n);
}
let num = prompt("Nhap mot so bat ky:")*1;
if (isMainNumber(num)) {
    alert(num + " la so chinh phuong.");
}
else {
    alert(num + " KHONG phai la so chinh phuong.");
}
