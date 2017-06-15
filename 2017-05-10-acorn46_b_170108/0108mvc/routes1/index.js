var express1 = require('express');
var router123 = express1.Router();

router123.get('/', function(req, res){
	res.render('index1');
});
router123.get('/:userName1', function(req, res){
	//var uName = req.params.userName;
	//res.render('param', {name:uName})
	res.render('param1', {name12:req.params.userName1})
});
module.exports = router123;
