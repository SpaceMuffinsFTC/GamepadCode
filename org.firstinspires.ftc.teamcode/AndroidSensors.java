package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.hardware.SensorEventListener;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.*;
import android.hardware.Sensor;
import android.widget.Toast;


public class AndroidSensors extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private Sensor gyroSensor;
    private Sensor lightSensor;
    private SensorEventListener accelerometerEventListener;
    private SensorEventListener gyroEventListener;
    private SensorEventListener lightEventListener;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        lightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if(gyroSensor == null){
            Toast.makeText(this, "This phone has no Gyroscope!", Toast.LENGTH_SHORT).show();
            finish();
        }

        if(mAccelerometer == null){
            Toast.makeText(this, "This phone has no Accelerometer!", Toast.LENGTH_SHORT).show();
            finish();
        }

        if(lightSensor == null){
            Toast.makeText(this, "This phone has no light sensor!", Toast.LENGTH_SHORT).show();
            finish();
        }

        gyroEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        accelerometerEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {


            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        lightEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }

    public void onResume(){
        super.onResume();
        mSensorManager.registerListener(gyroEventListener, gyroSensor, SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(accelerometerEventListener, mAccelerometer, SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(lightEventListener, lightSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    public void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(gyroEventListener);
        mSensorManager.unregisterListener(accelerometerEventListener);
        mSensorManager.unregisterListener(lightEventListener);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}
