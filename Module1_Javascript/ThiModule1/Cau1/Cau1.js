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
// nums.sort(function (a,b) {
//     if (a>b) {
//         return 1;
//     }
//     else {
//         return -1;
//     }
// });
let temp;
for (let i = 0; i < 4; i++) {
    for (let j = i+1; j < 5; j++) {
        if (nums[i] > nums[j]) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
document.write("Mang sau khi sap xep: <br>")
displayArr(nums);
