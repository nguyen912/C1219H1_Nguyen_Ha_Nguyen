var promiseObj = new Promise(function (resolve, reject) {
    resolve("Success");
    reject("Fail");
});
promiseObj.then(function (successWsg) { return console.log("Da xu ly: " + successWsg); }, function (errorMsg) { return console.log("Da xu ly: " + errorMsg); });
