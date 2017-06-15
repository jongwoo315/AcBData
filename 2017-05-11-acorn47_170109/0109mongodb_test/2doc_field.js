var MongoClient = require('mongodb').MongoClient;
MongoClient.connect('mongodb://localhost/', function(err, db){
	var myDB = db.db('words');
	myDB.collection('word_stats', limitFields);
	setTimeout(function(){
		db.close();
	}, 3000);
});

function limitFields(err, words){
	words.findOne({word:'the'}, {fields:{charsets:0}}, function(err, item){
		console.log('excluding fields object: ');
		console.log(JSON.stringify(item, null, 2));
		//console.log(JSON.stringify(item, replacer, 2));
	});
	
	words.findOne({word:'the'}, {fields:{word:1, size:1, stats:1}}, function(err, item){
		console.log('including fields object: ');
		console.log(JSON.stringify(item, null, 2)); //null자리에는 특정행위를 하는함수가 들어갈 수 있다.
	});
/*	
	words.findMany({}, {size:1}, function(err, item){
		console.log('size==1');
		console.log(JSON.stringify(item, null, 2));
	});
	
	words.findMany({}, {$or:[{word:1}, {size:3}]}, function(err, item){
		console.log('word==1 & size==3');
		console.log(JSON.stringify(item, null, 2));
	});
*/
}

function replacer(key, value){
	if(typeof value === "string"){
		//return undefined;
		return 'aaa';
	}
	return value;
}

