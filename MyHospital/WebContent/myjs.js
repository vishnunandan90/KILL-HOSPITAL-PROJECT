/**
 * 
 */

function validateForm() {
    var x = document.forms["myForm"]["age"].value;
    if (x<18) {
        alert("age must be greater than equal to 18");
        return false;
    }
}