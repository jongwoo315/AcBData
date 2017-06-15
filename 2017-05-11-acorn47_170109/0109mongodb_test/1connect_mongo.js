var MongoClient = require('mongodb').MongoClient;
MongoClient.connect('mongodb://localhost', function(err, db){
	var myDB = db.db("testdb");
	myDB.collection('sungjuk', limitFields);
	setTimeout(function(){
		db.close();
	}, 3000);
});

function limitFields(err, words){	//words에 collection의 값들이 저장됨
	words.findOne({name:'kim'}, {fields:{charsets:0}},
			function(err, item){
				console.log('excluding fields object: ');
				console.log(JSON.stringify(item, null, 2));
			});
}
