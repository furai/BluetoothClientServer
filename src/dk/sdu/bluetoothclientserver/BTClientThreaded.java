package dk.sdu.bluetoothclientserver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;

public class BTClientThreaded {

	private static final UUID RFCOMM_UUID = UUID
			.fromString("00001101-0000-1000-8000-00805F9B34FB");
	private BluetoothAdapter adapter = null;
	private BluetoothDevice device = null;
	private BluetoothSocket btsocket = null;
	private Context context = null;

	private BtThread thread = null;

	public BTClientThreaded(Context context, String mac) {

		this.context = context;
		this.adapter = BluetoothAdapter.getDefaultAdapter();
		this.device = this.adapter.getRemoteDevice(mac);

		try {
			this.btsocket = device
					.createInsecureRfcommSocketToServiceRecord(RFCOMM_UUID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private class BtThread extends Thread {

		private Boolean runFlag = true;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			InputStream inputstream = null;
			String line = null;

			try {
				btsocket.connect();
				inputstream = btsocket.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}

			BufferedReader bufferedreader = new BufferedReader(
					new InputStreamReader(inputstream));

			try {
				while (runFlag)
					line = bufferedreader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// do something with data

		}

	}

}
