import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;

import android.util.Log;
import android.provider.Settings;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zebra.rfid.api3.ACCESS_OPERATION_CODE;
import com.zebra.rfid.api3.ACCESS_OPERATION_STATUS;
import com.zebra.rfid.api3.BEEPER_VOLUME;
import com.zebra.rfid.api3.InvalidUsageException;
import com.zebra.rfid.api3.OperationFailureException;
import com.zebra.rfid.api3.RFIDReader;
import com.zebra.rfid.api3.ReaderDevice;
import com.zebra.rfid.api3.Readers;
import com.zebra.rfid.api3.RfidEventsListener;
import com.zebra.rfid.api3.RfidReadEvents;
import com.zebra.rfid.api3.RfidStatusEvents;
import com.zebra.rfid.api3.TAG_FIELD;
import com.zebra.rfid.api3.TagData;
import com.zebra.rfid.api3.TagStorageSettings;

import java.util.ArrayList;

public class RfidCordovaPlugin extends CordovaPlugin {

    public static final String TAG = "RfidCordovaPlugin";
    public static RFIDReader reader;

    /**
     * Constructor.
     */
    public RfidCordovaPlugin() {
    }

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.v(TAG, "Init RfidCordovaPlugin");
    }

    public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        final int duration = Toast.LENGTH_SHORT;
        Log.i(TAG, "Rfid cordova plugin recieved action: " + action);


        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Toast toast = Toast.makeText(cordova.getActivity().getApplicationContext(), action, duration);
                toast.show();
                Log.i(TAG, "Inside runnable");
                // connectToReader();
            }
        });

        return true;
    }

    private void connectToReader() {
        Log.i(TAG, "Connecting to reader");
        try {
            Readers readers = new Readers();
            ArrayList<ReaderDevice> deviceArrayList = readers.GetAvailableRFIDReaderList();
            ReaderDevice readerDevice = deviceArrayList.get(0);
            reader = readerDevice.getRFIDReader();
            reader.connect();
            reader.Config.setBeeperVolume(BEEPER_VOLUME.QUIET_BEEP);
            reader.Config.saveConfig();
        } catch (InvalidUsageException e) {
            e.printStackTrace();
        } catch (OperationFailureException e) {
            e.printStackTrace();
        }
    }
}
