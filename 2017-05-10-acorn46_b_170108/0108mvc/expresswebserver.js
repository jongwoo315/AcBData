var http = require('http'),
	express = require('express'),
	path = require('path'),
	app = express();

//routes폴더의 내용을 불러온다
var routes = require('./routes1');
// 입력이 '/'로 시작하는 것이 있으면 routes에서 처리하겠다는 의미
app.use('/', routes);
// '/'가 default라는 이야기.
// express를 담당하는 app에서 입력이 '/'로 시작하는 것이 있다면 routes에서 처리하겠다는 의미
// 만약 '/:hahaha'이라고 되어있으면 
// localhost:5000/ppp일 경우, 환영합니다.가 출력된다
// localhost:5000/ppp/abc이 되면 abc환영합니다.가 출력된다.

//app.set('abc', path.join(__dirname, 'abc')); 
app.set('views', path.join(__dirname, 'views'));
//path.join은 abc가 역슬래쉬로 연결되지 않도록 보증하는 명령어
//Node.js provides path.join() to always use the correct slash.
//__dirname은 nodejs서버가 실행되는 위치를 반환하며, 그 하위에 파일이 있다는 것을 알려주는 명령어
//app.set('views', path.join()); 이 줄이 없어도 실행은 잘 된다.

app.set('view engine', 'ejs');

http.createServer(app).listen(5000, 'localhost');
console.log('station.... 5000');
