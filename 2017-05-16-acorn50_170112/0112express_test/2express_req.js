var express = require('express');
var app = express();
app.listen(3000);
app.get('/user/:userid', function(req, res){
	console.log('url:\t '+req.originalUrl);
	console.log('protocol: '+req.protocol);
	console.log('ip:\t '+req.ip);
	console.log('path:\t '+req.path);
	console.log('host:\t '+req.hostname);
	console.log('method:\t '+req.method);
	console.log('query:\t '+JSON.stringify(req.query));
	console.log('fresh:\t '+req.fresh);
	console.log('stale:\t '+req.stale);
	console.log('secure:\t '+req.secure);
	console.log('UTF8:\t '+req.acceptsCharsets('utf8'));
	console.log('connection:\t '+req.get('connection'));
	console.log('headers: '+JSON.stringify(req.headers, null, 2));
	res.send('user request');
})

// localhost/user/4983?name=Brad
