package dk.sdu.bluetoothclientserver;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	private Boolean D = true;
	
	private IntentFilter myFilter = null;
	private MyReceiever myreceiver = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myreceiver = new MyReceiever();
		myFilter = new IntentFilter(BTClientThreaded.BT_NEW_RECV_DATA_INTENT);
		
		registerReceiver(myreceiver, myFilter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class MyReceiever extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			
			// do something with received data
			if (D) Log.v(TAG, "Got something." + intent.getStringExtra(BTClientThreaded.BT_NEW_RECV_DATA_INTENT_EXTRA_DATA));
		}
		
	}
}
