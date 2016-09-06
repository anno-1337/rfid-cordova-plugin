import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.nfc.NfcAdapter;
import android.util.Log;
import android.provider.Settings;
import android.widget.Toast;
import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RfidCordovaPlugin extends CordovaPlugin {

  public static final String TAG = "RfidCordovaPlugin";

  /**
  * Constructor.
  */
  public RfidCordovaPlugin() {}

  /**
  * Sets the context of the Command. This can then be used to do things like
  * get file paths associated with the Activity.
  *
  * @param cordova The context of the main Activity.
  * @param webView The CordovaWebView Cordova is running in.
  */

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    Log.v(TAG,"Init RfidCordovaPlugin");
  }

  public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    Log.v(TAG,"RfidCordovaPlugin received:"+ action);
    cordova.getActivity().runOnUiThread(new Runnable() {
      public void run() {
        Toast.makeText(cordova.getActivity().getApplicationContext(), action, Toast.LENGTH_SHORT).show();
        showNFCStatus();
        readRFID();
      }
    });
    return true;
  }


}
