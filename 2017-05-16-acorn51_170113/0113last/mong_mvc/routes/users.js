var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/userlist', function(req, res) {
	var db = req.db;
	var collection = db.get('userlist');
	collection.find({}, {}, function(e, doc){
		res.json(doc);
	});
});

router.post('/adduser', function(req, res){
	var db = req.db;
	var collection = db.get('userlist');
	collection.insert(req.body, function(err, result){
		res.send(
			(err === null) ? {msg:''} : {msg:err}
		);
	});
});

router.delete('/deleteuser/:id', function(req, res){
	var db = req.db;
	var collection = db.get('userlist');
	var userToDelete = req.params.id;
	collection.remove({'_id':userToDelete}, function(err){
		res.send((err === null) ? {msg:''} : {msg:'error: '+err});
	});
});
router.put('/users/updateuser/:id', function(req, res){
	var db =req.db;
	var collection = db.get('userlist');
	var userToUpdate = req.params.id;
	var dbusername = req.params.name;
	var dbemail = req.params.email;
	var dbfullname = req.params.fullname;
	var dbage = req.params.age;
	var dblocation = req.params.location;
	var dbgender = req.params.gender;
	collection.save({'_id':userToUpdate, 'username':dbusername+'1', 'email':dbemail+'1', 'fullname':dbfullname+'1', 'age':dbage+'1', 'location':dblocation+'1', 'gender':dbgender+'1'}, function(err){
		res.send((err === null) ? {msg:''} : {msg:'error: '+err});
	});
});

module.exports = router;
