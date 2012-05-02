package blue.test;

import java.io.*;
import java.util.Set;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.*;
import android.content.*;
import android.os.*;
import android.util.Log;

public class BlueIRTestActivity extends Activity {
	
	BluetoothServerSocket mmServerSocket = null;
	BluetoothAdapter mBluetoothAdapter=null;
	private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
	//private static final UUID MY_UUID = UUID.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");
	private static final String NAME="BlueIR";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //start the test
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
	    // If there are paired devices
        Log.e("TEST","TEST");
        
	    if (pairedDevices.size() > 0) {
	        // Loop through paired devices
	        for (BluetoothDevice device : pairedDevices) {
	            device.fetchUuidsWithSdp();
	            // Add the name and address to an array adapter to show in a ListView
	            Log.e("NAME",device.getName() + " - " + device.getAddress()+
	            		" - "+device.getUuids()[0]);
	        }
	    }
	    
	    try{
			mmServerSocket=mBluetoothAdapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
		}
		catch (IOException ioe) {
			Log.e("IOEXCEPTION", ioe.getMessage());
		}
	    Thread thr=new Thread(){
	    	public void run(){
	    		BluetoothSocket socket = null;
	    		while (true) {
	                try {
	                	Log.e("S-STATE","Opening the server...");
	                    socket = mmServerSocket.accept();
		                // If a connection was accepted
		                if (socket != null) {
		                	Log.e("S-STATE","Server received data...");
		                	byte[] buffer = new byte[1024];  // buffer store for the stream
		                    int bytes; // bytes returned from read()
		                    // Do work to manage the connection (in a separate thread)
		                    InputStream is=socket.getInputStream();
		                    bytes = is.read(buffer);
		                    mmServerSocket.close();
		                    Log.e("S-STATE","Server closed...");
		                    String shortMessage=new String(buffer);
		    				String debug="MESSAGE RECEIVED "+shortMessage;
		    				Log.e("RECEIVED","MESSAGE RECEIVED: "+shortMessage);
		                    break;
		                }
	                } catch (IOException ioe) {
	                	Log.e("THR-IOEXCEPTION", ioe.getMessage());
	                    break;
	                }
	            }
	    	}
	    };
	    thr.start();
    }
}