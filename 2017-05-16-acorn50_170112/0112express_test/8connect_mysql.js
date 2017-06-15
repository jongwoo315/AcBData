var mysql = require('mysql');
var crypto = require('crypto');
var connection = mysql.createConnection({
	host:'localhost',
	user:'root',
	password:'123',
	database:'login'
});

var name = 'kim';
var pass = '123';
var hashpass = crypto.createHash('sha512').update(pass).digest('hex').toString();
var insert = 'INSERT INTO user(name, passwd) values(?, ?)';
var select = 'SELECT id, name, passwd FROM user WHERE id=?'
connection.query(insert, [name, hashpass], function(err, info){
	if(err) throw err;
	console.log('[변경된 행수]'+info.affectedRows);
	console.log('[DB저장 ID]'+info.insertId+':info.insertId');
	connection.query(select, [info.insertId], function(err, rows, fields){
		if(err) throw err;
		console.log('정상적으로 저장');
	})
});
