var exec = require('cordova/exec');

function rfidcordovaplugin() {
 console.log("CoolPlugin.js: is created");
}

rfidcordovaplugin.prototype.showToast = function(aString){
 console.log("CoolPlugin.js: showToast");

 exec(function(result){
     /*alert("OK" + reply);*/
   },
  function(result){
    /*alert("Error" + reply);*/
  },"rfidcordovaplugin",aString,[]);
}

 var rfidcordovaplugin = new rfidcordovaplugin();
 module.exports = rfidcordovaplugin;
