var mongoose = require('mongoose');
var db = mongoose.connect('mongodb://localhost/words');
var wordSchema = require('./word_schema.js').wordSchema;
var Words = mongoose.model('Words', wordSchema);
mongoose.connection.once('open', function(){
	var newWord1 = new Words({
		word:'gratification',
		first:'g', last:'n', size:12,
		letters:['g','r','a','t','i','f','c','o','n'],
		stats:{vowels:5, consonants:7}
	});
	console.log('is document new?'+newWord1.isNew);
	newWord1.save(function(err,doc){
		console.log('\nSaved document: '+doc)
	})
//	mongoose.disconnect();
})
