package de.jugendhackt.deinmuell;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;




public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn_angry = (Button) findViewById(R.id.angry_btn);
        btn_angry.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(MainActivity.this, MeldenActivity.class));
				
				
			}
		});
        
        Button btn_trashie = (Button) findViewById(R.id.angry_btn4);
        btn_trashie.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(MainActivity.this,TrashieActivity.class));
				
				
			}
		});
    }
        Button angry_btn3 =  (Button) findViewById(R.id.angry_btn3);
        angry_btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg3) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, StatistikenActivity.class));
			}
		});

    
    Button angry_btn2 =  (Button) findViewById(R.id.angry_btn2);
    angry_btn2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View age2) {
			// TODO Auto-generated method stub
			startActivity(new Intent(MainActivity.this, SuchenActivity.class));
		}
	});
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_info) {
        	AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        	dialogBuilder.setTitle("Information");
        	dialogBuilder.setMessage("Vielen Dank für das Nutzen der App");
        	dialogBuilder.setNeutralButton("Okey", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});
        	
        	AlertDialog alertDialog = dialogBuilder.create();
        	alertDialog.show(); 
        	
        }
        return super.onOptionsItemSelected(item);
    }

   
}
