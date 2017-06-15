//하나씩 증가 $inc, 현재 날짜 입력 $currentDate, 필드 내용 지우기: $unset
////필드 명 바꾸기: $rename
var MongoClient = require("mongodb").MongoClient;

MongoClient.connect('mongodb://localhost/', function(err, db){
	var myDB = db.db('astro');
	myDB.collection('nebulae', function(err, nebulae){
		nebulae.find({type:'planetary'}, function(err, items) {
			items.toArray(function(err, itemArr){
		    	console.log('before update: ');
		        console.log(itemArr);
		        nebulae.update({type:'planetary', $isolated:1}, //한개만 해라
			    {$set:{type:'planetary1111', updated:true}},    //unset은 그 필드를 삭제
	            {upsert:false, multi:true, w:1},//upsert:false 없어도 추가하지 마라, multi:true 같은 게 여러개 있어도 적용/ w:1 권한 부여
			 	   function(err, results){
					   nebulae.find({type:'planetary1111'}, function(err, items){
						   items.toArray(function(err, itemArr){ 
							   console.log('after update: ');	
							   console.log(itemArr);
							   db.close();	
						   });	                                       
					   });                                 
				   });								                                   
            
			});
       	});
    });
});

