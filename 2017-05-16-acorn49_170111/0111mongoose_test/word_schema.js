var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var wordSchema = new Schema({ //collation을 이용하여 데이터 검증
	word:{type:String, index:1, required:true, unique:true},
	first:{type:String, index:1},
	last:String,
	size:Number,
	letters:[String],	//배열로 생성. 여러 값을 넣을 수 있다.
	stats:{vowels:Number, consonants:Number},
	charsets:[{type:String, chars:[String]}]	
}, {collection: 'word_stats'});

wordSchema.methods.startWith = function(letter){
	return this.first === letter;
};

exports.wordSchema = wordSchema;

//Schema를 이용해 model을 만들고, 그를 바탕으로 query를 날린다.
