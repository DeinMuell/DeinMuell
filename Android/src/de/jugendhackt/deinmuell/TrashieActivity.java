package de.jugendhackt.deinmuell;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrashieActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trashie);

		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				android.hardware.Camera cam = android.hardware.Camera.open();
			}

		});
	}
}
