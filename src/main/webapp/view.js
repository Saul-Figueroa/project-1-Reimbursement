//View 
window.onload= function(){
	viewProfile();
}
function viewProfile(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.responseText){
            let data = JSON.parse(xhr.responseText);
            console.log(data);
            document.getElementById("id").innerHTML = data.id;
            document.getElementById("firstname").innerHTML = data.firstName;
            document.getElementById("lastname").innerHTML = data.lastName;
            document.getElementById("email").innerHTML = data.email;
            document.getElementById("username").innerHTML = data.username;
            document.getElementById("password").innerHTML = data.password;
        }
    }
    xhr.open("GET","viewemployee.do");
    xhr.send();
}

