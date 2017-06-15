var express = require('express');
var router = express.Router();

/* GET home page. */
// 미들웨어로 작업한 것을 .get에서 가져온다//
// html을 직접 컨트를할 때 render를 사용(jade컨트롤)
// res.send()는 값만 전달
/*router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });	//'index'는 jade로 넘긴다
});*/

router.get('/', function(req, res, next) {
  res.render('index', {title:'Express'});	
});
//res.render에서 index.jade의 부분을 통째로 넘긴다.

module.exports = router;	//app.js로 넘겨주는 부분 //
