var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  //res.render('index_jade_123', { title: 'Express' });
  res.render('index_jade_123');
});

module.exports = router;
