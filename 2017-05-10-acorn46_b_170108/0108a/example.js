var url = require('url');
var parsedObject1 = url.parse('http://user:pass@host.com:8080/p/a/t/h?query=string#hash');
console.log(parsedObject1); // url 객체 정보 출력
console.log('1번 '+url.format(parsedObject1)); // url 객체를 문자열로 출력

var parsedObject2 = url.parse('http://user:pass@host.com:8080/p/a/t/h?query=string#hash').pathname; 
console.log('2번 '+parsedObject2); // url 객체 정보 출력

var parsedObject3 = url.parse('http://user:pass@host.com:8080/path').pathname;
console.log('3번 '+parsedObject3); // url 객체 정보 출력
