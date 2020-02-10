function findMaxScore(arr) {
    let max = arr[0];
    let index;
    for (let i = 1; i < arr.length; i++) {
        if (max <= arr[i]) {
            max = arr[i];
            index = i;
        }
    }
    return "Diem cao nhat: " + max + " o vi tri: " + (index+1);
}
let diem = [10,5,8,9,10];
alert(findMaxScore(diem));