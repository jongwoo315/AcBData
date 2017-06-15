var score = [
        //{species:'Lion', name:'King'},
        //{species:'Whale', name:'Fail'}
	{kor:99, eng:54, math:100},
	{kor:67, eng:88, math:87}
];

for(var i = 0; i < score.length; i++){
        (function(i){

                this.print = function(){
                        console.log('kor:' +this.kor+ ' eng:' +this.eng+ ' math:' +this.math);
                }//선언과 동시에 실행된다(익명함수) / 사용 후 사라짐

                this.print();
        }).call(score[i], i); //apply는 call과 동일/ apply는 배열로 들어가고, call은 인수로 
}

/*
결과창
#0 Lion: King
#1 Whale: Fail
*/

