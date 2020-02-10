function displayArr (arr) {
    for (let i = 0; i < 5; i++) {
        document.write(arr[i] + "\t");
    }
    document.write("<br>");
}
let nums = [];
for (let i = 0; i < 5; i++) {
    nums[i] = parseInt(prompt("Nhap so thu " + (i+1) + ": "));
}
displayArr(nums);
nums.sort(function (a,b) {
    if (a>b) {
        return 1;
    }
    else {
        return -1;
    }
});
document.write("Mang sau khi sap xep: <br>")
displayArr(nums);
