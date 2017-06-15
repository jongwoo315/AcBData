var MongoClient = require('mongodb').MongoClient;

MongoClient.connect('mongodb://localhost/', function(err ,db){
	var myDB = db.db('astro');
	
	myDB.collection('nebulae', function(err, nebulae){
        
		nebulae.find(function(err, items){
			items.sort();
			items.toArray(function(err, itemArr){
		        console.log('===== 1. Document Array ===== ');
		        console.log(itemArr);
		        console.log(itemArr[2]);
			});
		});
				        
		nebulae.find(function(err, items){
			items.each(function(err, item){
				if(item){
		 	       console.log('===== 2. singular document ====== ');
			       console.log(item);
 				}	
			});	        
		});
				        
		nebulae.findOne({type:'planetary'}, function(err, item){
		    console.log('===== 3. found one ===== ');
		    console.log(item);
 		});

		console.log(items.map(function(u){return u.ngc;}));

	});
    setTimeout(function(){db.close();}, 3000);
});
