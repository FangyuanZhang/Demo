package com.itheima.orientationsensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
@SuppressWarnings("deprecation")
public class MainActivity extends Activity {

	private SensorManager manager;
	private Sensor orientationSensor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		manager = (SensorManager) getSystemService(SENSOR_SERVICE);
		orientationSensor = manager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		
		manager.registerListener(new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				float degree = event.values[0];
				
				if (degree == 0) {
					System.out.println("正北方向...");
				} else if (degree == 90) {
					System.out.println("正东方向...");
				} else if (degree == 180) {
					System.out.println("正南方向...");
				} else if (degree == 270) {
					System.out.println("正西方向...");
				} else if (degree > 0 && degree < 90) {
					System.out.println("东北方向...");
				} else if (degree > 90 && degree < 180) {
					System.out.println("东南方向...");
				} else if (degree > 180 && degree < 270) {
					System.out.println("西南方向...");
				} else if (degree > 270 && degree < 360) {
					System.out.println("西北方向...");
				}
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
		}, orientationSensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
