package de.jugendhackt.deinmuell;

import java.io.File;
import java.io.IOException;
<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.Date;
=======
>>>>>>> dcd0aef9afe6268de3ad5509be75d4437fe66095

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
<<<<<<< HEAD
import android.provider.MediaStore;
=======
>>>>>>> dcd0aef9afe6268de3ad5509be75d4437fe66095
import android.view.View;
import android.widget.Button;

public class TrashieActivity extends Activity {
<<<<<<< HEAD
	
	String mCurrentPhotoPath;

	private File createImageFile() throws IOException {
	    // Create an image file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String imageFileName = "JPEG_" + timeStamp + "_";
	    File storageDir = Environment.getExternalStoragePublicDirectory(
	            Environment.DIRECTORY_PICTURES);
	    File image = File.createTempFile(
	        imageFileName,  /* prefix */
	        ".jpg",         /* suffix */
	        storageDir      /* directory */
	    );

	    // Save a file: path for use with ACTION_VIEW intents
	    mCurrentPhotoPath = "file:" + image.getAbsolutePath();
	    return image;
	}
=======
>>>>>>> dcd0aef9afe6268de3ad5509be75d4437fe66095

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trashie);

		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
<<<<<<< HEAD
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			    // Ensure that there's a camera activity to handle the intent
			    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
			        // Create the File where the photo should go
			        File photoFile = null;
			        try {
			            photoFile = createImageFile();
			        } catch (IOException ex) {
			            // Error occurred while creating the File
			        	
			        }
			        // Continue only if the File was successfully created
			        if (photoFile != null) {
			            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
			                    Uri.fromFile(photoFile));
			            startActivityForResult(takePictureIntent, 1);
			        }
			    }

			}

		});
		
	}
	
//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//	    if (requestCode == 1 && resultCode == RESULT_OK) {
//	        Bundle extras = data.getExtras();
//	        Bitmap imageBitmap = (Bitmap) extras.get("data");
////	        galleryAddPic();
//	    }
//	}
	
	private void galleryAddPic() {
	    Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
	    File f = new File(mCurrentPhotoPath);
	    Uri contentUri = Uri.fromFile(f);
	    mediaScanIntent.setData(contentUri);
	    this.sendBroadcast(mediaScanIntent);
=======
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
>>>>>>> dcd0aef9afe6268de3ad5509be75d4437fe66095
	}
}
