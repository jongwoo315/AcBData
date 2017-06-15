var express = require('express');
var router = express.Router();

router.get('/', function(req, res, next) {
  res.send('니들이 게맛을 알아?');
});

//db에서 리스트를 가져온다.
router.get('/studentlist', function(req, res){
	var db = req.db;
    /*
	db.collection('studentcollection').find().toArray(function(err, items){
		res.json(items);
	});
	*/

	var collection = db.get('studentcollection');
	collection.find({}, {}, function(e, items){
		res.json(items);
	});
});

//POST to addstudent
router.post('/addstudent', function(req, res){
	var db = req.db;
	db.collection('studentcollection').insert(req.body, function(err, result){
		res.send(
			(err === null) ? {msg:''} : {msg:err}
		);
	});
});

//POST to updatestudent // 프런트에서 입력한 값을 db로 넘기는 실질적이 기능수행
/*원본*/
router.post('/updatestudent',function(req, res){
	var db = req.db;
	var studentToUpdate = req.params.id;
	db.collection('studentcollection').update({id:studentToUpdate}, req.body, function(err, result){
		res.send(
			(err === null) ? {msg:''} : {msg:err}
		);
	});
});

/*router.post('/updatestudent',function(req, res){
	var db = req.db;
	var studentToUpdate = req.params.id;
	var collection = db.get('studentcollection');
	collection.update({'_id':studentToUpdate}, {$set:req.body}, {safe:true}, function(err, result){
		res.send(
			(err === null) ? {msg:''} : {msg:err}
		);
	});
});*/
/*
router.put('/updatestudent',function(req, res){
	var db = req.db;
	var studentToUpdate = req.params.id;
	var collection = db.get('studentcollection');

	collection.findOne({id:studentToUpdate}, function(err, student){
		res.send(
			(err === null) ? {msg:''} : {msg:err}
		);
		for(prop in req.body){
			student[prop] = req.body[prop];
		}
		student.save(function(err){
			if(err){
				return res.send(err);
			}
		})
	});
});
*/
//POST to deletestudent
/*
router.delete('/deletestudent/:id', function(req, res){
	var db = req.db;
	var studentToDelete = req.params.id;
	db.collection('studentcollection').removeById(studentToDelete, function(err, result){
		res.send((result === 1) ? {msg:''} : {msg:'error: '+err});
	});
});
*/
router.delete('/deletestudent/:id', function(req ,res){
	var db = req.db;
	var collection = db.get('studentcollection');
	var studentToDelete = req.params.id;
	collection.remove({'_id':studentToDelete}, function(err){
		res.send((err === null) ? {msg:''} : {msg:'error: '+err});
	});
});

module.exports = router;
