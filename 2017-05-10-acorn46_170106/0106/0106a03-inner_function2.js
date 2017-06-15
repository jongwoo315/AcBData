
function parent(){
        var a = 100;
        var b = 200;

        // child() 내부 함수 정의
        function child(){
                var b = 300;
                //console.log(a);
                //console.log(b);
		a += 1;
		//b += 1;
		console.log(a);
        }

        //return child;

	function count(){
		//a += 1;
		//b += 1;
		console.log(a);
	}
	//return count;
	return [child, count];
};

var abc = parent();
var Zchild = abc[0];
var Zcount = abc[1];

Zchild();
Zcount();
//var inner[] = parent();
//var inner.count = parent();
//inner();
//inner2();
//inner();
//inner[0];
//inner[1];
