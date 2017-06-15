var animals = [
	{species:'Lion', name:'King'},
	{species:'Whale', name:'Fail'}
];

for(var i = 0; i < animals.length; i++){
	(function(i){
		this.print = function(){
			console.log('#' +i+ ' ' +this.species+ ': ' +this.name);
		}//선언과 동시에 실행된다(익명함수) / 사용 후 사라짐
		this.print();
	}).call(animals[i], i); //apply는 call과 동일/ apply는 배열로 들어가고, call은 인수로
}

/*
결과창
#0 Lion: King
#1 Whale: Fail
*/

