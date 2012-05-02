package blue.test;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

public class BluetoothReceiver extends BroadcastReceiver {

	@Override
  	  public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "ENTERED", Toast.LENGTH_LONG);
  	    BluetoothDevice deviceExtra = intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
  	    Parcelable[] uuidExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
  	    //Parse the UUIDs and get the one you are interested in
  	    for(int i=0; i<uuidExtra.length;i++){  	    	
  	    	for(int j=0; j<deviceExtra.getUuids().length;j++){
  	    		Log.e(deviceExtra.getName(),""+deviceExtra.getUuids()[j].getUuid().toString());
  	    	}
  	    }
  	    
  	  }
}
