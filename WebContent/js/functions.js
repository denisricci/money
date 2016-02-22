String.prototype.replaceAll = String.prototype.replaceAll || function(needle, replacement) {
    return this.split(needle).join(replacement);
};

String.prototype.replaceAt=function(index, character) {
    return this.substr(0, index) + character + this.substr(index+character.length);
}

function formatDate(dd,mm,yyyy){
    if(dd<10){
        dd='0'+dd
    }
    if(mm<10){
        mm='0'+mm
    }
    return dd+'/'+mm+'/'+yyyy;
}

function currentDate(){
	var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1;
    var yyyy = today.getFullYear();
    return formatDate(dd,mm,yyyy);
}

function firstDateOfMonth(){
    var today = new Date();
    var dd = 1;
    var mm = today.getMonth()+1;
    var yyyy = today.getFullYear();
    return formatDate(dd,mm,yyyy);
}

function lastDateOfMonth(){
    var today = new Date();
    var mm = today.getMonth()+1;
    var yyyy = today.getFullYear();
    var dd = new Date(yyyy, mm, 0);
    return formatDate(dd.getDate(),mm,yyyy);
}
