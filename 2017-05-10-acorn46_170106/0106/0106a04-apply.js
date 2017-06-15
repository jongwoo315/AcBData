function Person(name, age, gender){
	this.name = name;
	this.age = age;
	this.gender = gender;
};

var foo = {};

Person.apply(foo, ['foo', 30, 'man']);	//foo객체에 뒤의 내용을 넣어라
console.dir(foo);
