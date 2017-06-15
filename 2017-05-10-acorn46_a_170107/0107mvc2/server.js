var express12 = require('express');
var app12 = express12();

var router = require('./router1/main')(app12);
//var router = require('./router1/main');
//app12.use(router);

app12.set('views', __dirname+'/views');
app12.set('view engine', 'ejs');
app12.engine('html', require('ejs').renderFile);

app12.use(express12.static('public'));

var server = app12.listen(3000, function(){
	console.log('started on port 3000');
})

/*app12.get('/', function(req, res){
	res.send('hello');
});*/
//  https://velopert.com/294
//	https://velopert.com/379
//  https://velopert.com/332
//  https://velopert.com/406
