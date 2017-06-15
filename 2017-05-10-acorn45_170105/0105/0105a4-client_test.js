var http = require('http');

var options = {
	hostname: '127.0.0.1',
	port: 3000,
	path: '/',
	method: 'POST'
};

var req = http.request(options, function(res){
	console.log('STATUS:' + res.statusCode);
	console.log('HEADERS:' + JSON.stringify(res.headers));
	res.setEncoding('utf8');
	res.on('data', function(chunk){
		console.log('BODY: '+chunk);
	});
});

req.on('error', function(e){
	console.log('problem with request: '+e.message);
});
req.write('data\n');
req.write('data\n');
req.end();

/*실행결과
STATUS:200
HEADERS:{"content-type":"text/plain",
	"date":"Thu, 05 Jan 2017 08:23:39 GMT",
	"connection":"close",
	"transfer-encoding":"chunked"}
BODY: Hello World*/
