
let promiseObj = new Promise((resolve, reject) => {
    resolve("Success");
});
promiseObj.then((successWsg) => console.log("Da xu ly: " + successWsg), (errorMsg) => console.log("Da xu ly: " + errorMsg));
