//studentlist data array for filling in info box
var studentListData = [];

//DOM Ready
$(document).ready(function(){
	//populate the student table on initial page load
	populateTable();
});

//Functions =================================================

//Fill table with data
function populateTable(){
	//Empty content string
	var tableContent = '';

	//jQuery AJAX call for JSON
	$.getJSON('/users/studentlist', function(data){
		//For each item in our JSON, add a table row and cells to the content string
		$.each(data, function(){
			tableContent += '<tr>';
			tableContent += '<td>'+this.st_id+'</td>';
			tableContent += '<td><a href="#" class="linkshowstudent" rel="'+this.fullname+'">'+this.fullname+'</a></td>';
			//tableContent += '<td>'+this.email+'</td>';
			tableContent += '<td><a href="#" class="linkdeletestudent" rel="'+this._id+'">delete</a></td>';
			tableContent += '</tr>';
		});
		//stick our user data array into a studentlist variable in the global object
		studentListData = data;
		//inject the whole content string into our existing HTML table
		$('#studentList table tbody').html(tableContent);
	});
};

//show student info(selected information)
function showStudentInfo(event){
	//prevent link from firing
	event.preventDefault();

	//retrieve username from link rel attribute
	var thisStudentName = $(this).attr('rel');

	//get index of object based on id value
	var arrayPosition = studentListData.map(function(arrayItem){return arrayItem.fullname;}).indexOf(thisStudentName);
	//get our student object
	var thisStudentObject = studentListData[arrayPosition];

	//populate info box
	$('#studentInfoName').text(thisStudentObject.fullname);
	//$('#studentInfoAge').text(thisStudentObject.age);
	//$('#studentInfoGender').text(thisStudentObject.gender);
	//$('#studentInfoLocation').text(thisStudentObject.address);
	$('#studentInfoKor').text(thisStudentObject.kor);
	$('#studentInfoEng').text(thisStudentObject.eng);
	$('#studentInfoMath').text(thisStudentObject.math);
	//new code; show student information in textbox
	$('#addStudent fieldset input#inputStudentID').val(thisStudentObject.st_id);
	$('#addStudent fieldset input#inputStudentFullName').val(thisStudentObject.fullname);
	$('#addStudent fieldset input#inputStudentKor').val(thisStudentObject.kor);
	$('#addStudent fieldset input#inputStudentEng').val(thisStudentObject.eng);
	$('#addStudent fieldset input#inputStudentMath').val(thisStudentObject.math);
	//$('#addStudent fieldset input#inputStudentEmail').val(thisStudentObject.email);
};

//student name link click
$('#studentList table tbody').on('click', 'td a.linkshowstudent', showStudentInfo);

//add student
function addStudent(event){
	event.preventDefault();
	//super basic validation - increase errorCount variable if any fields are blank
	var errorCount = 0;
	$('#addStudent input').each(function(index, val){
		if($(this).val() === ''){errorCount++;}
	});
	//check and make sure errorCount's still at zero
	if(errorCount === 0){
		//if it is, compile all student info into one object
		var newStudent = {
			'st_id':$('#addStudent fieldset input#inputStudentID').val(),
			'fullname':$('#addStudent fieldset input#inputStudentFullName').val(),
			//'age':$('#addStudent fieldset input#inputStudentAge').val(),
			'kor':$('#addStudent fieldset input#inputStudentKor').val(),
			'eng':$('#addStudent fieldset input#inputStudentEng').val(),
			'math':$('#addStudent fieldset input#inputStudentMath').val()
		}
		//use AJAX to post the object to our addStudent service
		$.ajax({
			type:'POST',
			data:newStudent,
			url:'/users/addstudent',
			dataType:'JSON'
		}).done(function(response){
			//check for successful (blank) response
			if(response.msg === ''){
				//clear the form inputs
				$('#addStudent fieldset input').val('');
				//Update the table
				populateTable();
			}
			else{
				//if something goes wrong, alert the error message that our service returned
				alert('Error: '+response.msg);
			}
		});
	}
	else{
		//if errorCount is more than 0, error popsup
		alert('please fill in all fields');
		return false;
	}
};
//add student button click
$('#btnAddStudent').on('click', addStudent);

//update student
function updateStudent(event){
	event.preventDefault();
	var errorCount = 0;
	$('#addStudent input').each(function(index, val){
		if($(this).val() === ''){errorCount++;}
	});
	if(errorCount === 0){
		var modifiedStudent ={
			'st_id':$('#addStudent fieldset input#inputStudentID').val(),
			'fullname':$('#addStudent fieldset input#inputStudentFullName').val(),
			//'age':$('#addStudent fieldset input#inputStudentAge').val(),
			'kor':$('#addStudent fieldset input#inputStudentKor').val(),
			'eng':$('#addStudent fieldset input#inputStudentEng').val(),
			'math':$('#addStudent fieldset input#inputStudentMath').val()
		}
		$.ajax({
			type:'POST',
			data:modifiedStudent,
			url:'/users/updatestudent',
			dataType:'JSON'
		}).done(function(response){
			if(response.msg === ''){
				//clear the form inputs
				$('#addStudent fieldset input').val('');
				//update the table
				populateTable();
			}
			else{
				alert('Error: '+response.msg);
			}
		});
	}
	else{
		//if errorCount is more than 0, error out
		alert('please fill in all fields');
		return false;
	}
};
//update student button click
$('#btnUpdateStudent').on('click', updateStudent);

//delete studentlist
function deleteStudent(event){
	event.preventDefault();
	var confirmation = confirm('are you sure you want to delete this user?');
	if(confirmation === true){
		$.ajax({
			type:'DELETE',
			url:'/users/deletestudent/'+$(this).attr('rel')
		}).done(function(response){
			if(response.msg === ''){
			}
			else{
				alert('Error: '+response.msg);
			}
			populateTable();
		});
	}
	else{
		return false;
	}
}

$('#studentList table tbody').on('click', 'td a.linkdeletestudent', deleteStudent);

