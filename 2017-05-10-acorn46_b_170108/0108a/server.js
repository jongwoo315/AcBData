var http = require('http');
var fs = require('fs');
var url = require('url');

//서버 생성
http.createServer(function(request, response){
	//url 뒤에 있는 디렉토리/파일이름 파싱
	var pathname = url.parse(request.url).pathname;
	console.log('request for'+pathname+'received.');

	//파일이름이 비어있다면 index.html로 설정
	if(pathname == '/'){pathname = '/index.html';}

	//파일을 읽기
	fs.readFile(pathname.substr(1), function(err, data){
		if(err){
			console.log(err);
			response.writeHead(404, {'Content-Type':'text/html'});
			//response.write('asdfasdfsadf');
		}else{
			response.writeHead(200, {'Content-Type':'text/html'});
			response.write(data.toString());
			//response.write('hhhhhhhh');
		}
		response.end();
	});
}).listen(8081);

console.log('server at port 8081');
