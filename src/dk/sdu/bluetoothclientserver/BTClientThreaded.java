package dk.sdu.bluetoothclientserver;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;

public class BTClientThreaded {

	private BluetoothAdapter adapter = null;
	private BluetoothDevice device = null;
	private BluetoothSocket btsocket = null;
	private Context context = null;

	private BtThread thread = null;

	public BTClientThreaded(Context context, String mac) {

		this.context = context;
		this.adapter = BluetoothAdapter.getDefaultAdapter();
		this.device = this.adapter.getRemoteDevice(mac);

	}

	private class BtThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
		}

	}

}
