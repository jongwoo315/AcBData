var MongoClient = require("mongodb").MongoClient;
var input1 = require('prompt');

function input(){
	input1.get(['name', 'kor', 'eng', 'math', 'rep'], function(err, result){

		MongoClient.connect('mongodb://localhost/*', function(err, db){
			var myDB = db.db('test');
			myDB.createCollection('abc', function(err, scorebook){	
				kor = parseInt(result.kor);
				eng = parseInt(result.eng);
				math = parseInt(result.math);
				tot = kor + eng + math;
				avg = tot / 3;
				addObject(scorebook, {name:result.name, kor:kor, eng:eng, math:math, total:tot, average:avg});
			});
												
			setTimeout(function(){db.close();}, 500);
																	
			/*if(result.rep === 'n'){
				menu();						
			}else input();*/
																
		});
			
	});

}

function addObject(collec, obj1){
	collec.insert(obj1, function(err, result){
		if(!err){
			console.log('Inserted: *, succeed!');
			//console.log(result);			
		}		
	});
}

input();
