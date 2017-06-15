
function parent(){
        var a = 100;
        var b = 200;

        // child() 내부 함수 정의
        function child(){
                var b = 300;
                console.log(a);
                console.log(b);
        }

        return  child; //위치를 찾기 때문에 ()가 없다.
}

var inner = parent();
inner();

