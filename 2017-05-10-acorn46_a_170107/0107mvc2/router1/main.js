//직접 만든 모듈이며, 이것을 exports시킨다.
//export시킨 것은 server.js에서 var router안에 저장이 된다.
module.exports = function(app12){	
	app12.get('/', function(req, res){
		res.render('index.html')
	});
	app12.get('/about', function(req, res){
		res.render('about.html');
	});
}
