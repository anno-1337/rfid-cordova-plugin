let exec = require('cordova/exec');

function RfidCordovaPlugin() {
 console.log("RfidCordovaPlugin.js: is created");
}

RfidCordovaPlugin.prototype.showToast = function(aString){
 console.log("RfidCordovaPlugin.js: showToast");

 exec(function(result){
     /*alert("OK" + reply);*/
   },
  function(result){
    /*alert("Error" + reply);*/
  },"RfidCordovaPlugin",aString,[]);
}

 let rfidCordovaPlugin = new RfidCordovaPlugin();
 module.exports = rfidCordovaPlugin;
