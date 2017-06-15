var MongoClient = require("mongodb").MongoClient;
var input1 = require('prompt');
var menu1 = require('prompt');
var ask1 = require('prompt');

/*
function database(err, db){
	 db.db('astro');
}*/
//var myDB = MongoClient.connect('mongodb://localhost/*').database;

//var myDB = db.db('astro');
//input();
menu();

function input(){
	input1.get(['name', 'kor', 'eng', 'math', 'rep'], function(err, result){

		MongoClient.connect('mongodb://localhost/*', function(err, db){
			var myDB = db.db('astro');
			myDB.createCollection('scorebook', function(err, scorebook){	
				kor = parseInt(result.kor);
				eng = parseInt(result.eng);
				math = parseInt(result.math);
				tot = kor + eng + math;
				avg = tot / 3;
				addObject(scorebook, {name:result.name, kor:kor, eng:eng, math:math, total:tot, average:avg});
			});
		
			setTimeout(function(){db.close();}, 500);
			
			if(result.rep === 'n'){
				menu();
			}else input();
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

function show(){
	MongoClient.connect('mongodb://localhost/*', function(err, db){
		var myDB = db.db('astro');
		myDB.collection('scorebook', function(err, scorebook){
			scorebook.find(function(err, items){
				items.toArray(function(err, itemArr){
					console.log(itemArr);
					menu();
				});
			});
		});
	});
}

function menu(){
	console.log('menu 시작');
	menu1.start();
	menu1.get(['select_action'], function(err, choice){
		if(choice.select_action == 'input'){
			input();
		}else if(choice.select_action == 'show'){
			show();
		}else if(choice.select_action == 'delete'){

		}else if(choice.select_action == 'update'){

		}
		else{
			console.log('done');
		}
	})
}
