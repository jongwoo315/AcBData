var total = 20;
var results = [0,1];
console.time('Getting Fibonacci Number');
console.log("Let's get Fibonacci Numbers...");

for(var i = 0; i < total; i++){
     if(i >= 2){
          results.push(results[i - 2] + results[i - 1]);
     }
}

console.log("Fibonacci ["+total+"] th number is ["+results[total - 1]+"]");
console.log("All number is["+results+"]");
console.timeEnd('Getting Fibonacci Number');
