function say(word){
	console.log(word);
}

function execute(a, bbb){
	a(bbb);
}

execute(say, 'hee');

execute(function(word){console.log(word)}, 'heelo');

//say(aaa);

