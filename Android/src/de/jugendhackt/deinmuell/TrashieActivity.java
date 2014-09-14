package de.jugendhackt.deinmuell;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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
				File image;
				try {
					image = File.createTempFile("Treshies", ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
					Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
					intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,Uri.fromFile(image));
					startActivityForResult(intent, 1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		});
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode,Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    if(requestCode==1  && resultCode==RESULT_OK) {
	        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
	    }
	}
}
