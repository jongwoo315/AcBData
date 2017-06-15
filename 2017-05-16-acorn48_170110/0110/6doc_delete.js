var MongoClient = require("mongodb").MongoClient;
MongoClient.connect('mongodb://localhost/', function(err, db){
	var myDB = db.db('astro');
	myDB.collection('nebulae', function(err, nebulae){
		nebulae.find(function(err, items){
			items.toArray(function(err, itemArr){
                console.log('before delete: ');
	            console.log(itemArr);
				nebulae.remove({type:'planetary'}, function(err, results){
                    console.log('delete:\n'+results);
					nebulae.find(function(err, items){
						items.toArray(function(err, itemArr){
                            console.log('===== after delete =====');
                            console.log(itemArr);
                            db.close();
                        });
	                });
	            });
	        });
        });
    });
});
