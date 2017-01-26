package fr.ul.rollingball;

import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import fr.ul.rollingball.RollingBall;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new RollingBall(), config);
		config.a=8;
		boolean dispo= Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer);
		if (dispo){
			config.useAccelerometer=true;
		}
	}
}
