db.system.js.save({	//system.js는 사용자 정보를 담고 있는 파일 (이것을 저장하라는 의미)
	_id:"insertDocument", value:function(doc, targetCollection){
		while(1){
			var cursor = targetCollection.find({}, {_id:1}).sort({_id:-1}).limit(1);	//id:-1 거꾸로 sort
			var seq = cursor.hasNext() ? cursor.next()._id + 1 : 1;
			doc._id = seq;
			var results = targetCollection.insert(doc);

			if(results.hasWriteError()){
				if(results.writeError.code == 11000 /*dup key*/) continue;
				else print('unexpected error inserting data: '+tojson(results));
			}break;
		}
	}
})
