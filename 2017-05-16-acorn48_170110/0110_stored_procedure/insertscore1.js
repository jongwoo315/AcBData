db.system.js.save({
	_id:"insertscore1", value:function(doc, targetCollection){
		while(1){
           var cursor = targetCollection.find({}, {_id:1}).sort({_id:-1}).limit(1);
           var seq = cursor.hasNext() ? cursor.next()._id + 1 : 1;
           doc._id = seq;

		   doc.tot = doc.kor + doc.eng + doc.math;
		   doc.avg = doc.tot / 3;
           var results = targetCollection.insert(doc);

  		   if(results.hasWriteError()){
			   if(results.writeError.code == 11000){
			  		 continue;
			   }else print('unexpected error inserting data: '+tojson(results));
		   }break;
		}
	}
})

