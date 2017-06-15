var userListData = [];
$(document).ready(function(){
	populateTable();
});

function populateTable(){	//h2 User List 부분
	var tableContent = '';
	$.getJSON('http://localhost:3000/users/userlist', function(data){
	    userListData = data;
		$.each(data, function(){
			tableContent += '<tr>';
			tableContent += '<td><a href="#" class="linkshowuser" rel="'+this.username+'">'+this.username+'</a></td>';
			tableContent += '<td>'+this.email+'</td>';
			tableContent += '<td><a href="#" class="linkdeleteuser" rel="'+this._id+'">delete</a></td>';
			tableContent += '</tr>';
		});
		$('#userList table tbody').html(tableContent);
	});
};

function showUserInfo(event){
	event.preventDefault();
	var thisUserName = $(this).attr('rel');
	var arrayPosition = userListData.map(function(arrayItem){return arrayItem.username;}).indexOf(thisUserName);
	var thisUserObject = userListData[arrayPosition];
	$('#userInfoName').text(thisUserObject.fullname);
	$('#userInfoAge').text(thisUserObject.age);
	$('#userInfoGender').text(thisUserObject.gender);
	$('#userInfoLocation').text(thisUserObject.location);
};
$('#userList table tbody').on('click', 'td a.linkshowuser', showUserInfo);

function addUser(event){
	event.preventDefault();
	var errorCount = 0;
	$('#addUser input').each(function(index, val){
		if($(this).val() === ''){errorCount++;}
	});

	if(errorCount === 0){
		var newUser = {
			'username': $('#addUser fieldset input#inputUserName').val(),
			'email': $('#addUser fieldset input#inputUserEmail').val(),
			'fullname': $('#addUser fieldset input#inputUserFullname').val(),
			'age': $('#addUser fieldset input#inputUserAge').val(),
			'location': $('#addUser fieldset input#inputUserLocation').val(),
			'gender': $('#addUser fieldset input#inputUserGender').val()
		}

		$.ajax({
			type:'POST',
			data:newUser,
			url:'/users/adduser',
			dataType:'JSON'
		}).done(function(response){
			if(response.msg === ''){
				$('#addUser fieldset input').val('');
				populateTable();
			}
			else{
				alert('Error: '+response.msg);
			}
		});
	}
	else{
		alert('Please fill in all fields');
		return false;
	}
}

function deleteUser(event){
	event.preventDefault();
	var confirmation = confirm('are you sure you want to delete this user?');
	if(confirmation === true){
		$.ajax({
			type: 'DELETE',
			url: '/users/deleteuser/'+$(this).attr('rel')
		}).done(function(response){
			if(response.msg === ''){
			}else{
				alert('Error: '+response.msg);
			}
			populateTable();
		});
	}
	else{
		return false;
	}
};

function updateUser(event){
	event.preventDefault();
	$.ajax({
		type: 'PUT',
		url: '/users/updateuser/'+$(this).attr('rel')
	}).done(function(response){
		populateTable();
	});
};
$('#btnUpdateStudent').on('click', updateStudent);
$('#btnAddUser').on('click', addUser);
$('#userList table tbody').on('click', 'td a.linkdeleteuser', deleteUser);
$('#userList table tbody').on('click', 'td a.linkupdateuser', updateUser);
