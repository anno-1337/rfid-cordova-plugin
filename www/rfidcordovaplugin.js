var exec = require('cordova/exec');

function rfidCordovaPlugin() {
 console.log("RfidCordovaPlugin.js: is created");
}

rfidCordovaPlugin.prototype.showToast = function(aString){
 console.log("RfidCordovaPlugin.js: showToast");

 exec(function(result){
     /*alert("OK" + reply);*/
   },
  function(result){
    /*alert("Error" + reply);*/
  },"rfidCordovaPlugin",aString,[]);
}

 var rfidCordovaPlugin = new rfidCordovaPlugin();
 module.exports = rfidCordovaPlugin;
