var express = require('express');
var cookieParser = require('cookie-parser');
var app = express();
app.use(cookieParser());
app.get('/', function(req, res){
	console.log(req.cookies);
	if(!req.cookies.hasVisited){
		res.cookie('hasVisited', '1',
				{maxAge:60*60*1000,
				 httpOnly:true,
				 path:'/'
				 //secure:true,
				 //encode:encodeURIComponent
				 //domain:'www.naver.com'//디폴드로 app시작
				 //expires:new Date(Date.now()+900000)
	    });
	}
	res.send('Sending Cookie');
});
app.listen(3000);
