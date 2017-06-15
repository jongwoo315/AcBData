var http12 = require('http');

http12.createServer(function(req, res){
	
	//writeHead:응답 헤더 작성, 200:응답 성공
	res.writeHead( 200, {'Content-Type':'text/plain'} );

	//end:응답본문
	res.end('Hello World\n');
}).listen(3000, '127.0.0.1');

// req: 웹으로 요청을 하는 것
// res: 웹에서 응답하는 것

console.log('Server running at http://127.0.0.1:3000/');

