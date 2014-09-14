package de.jugendhackt.deinmuell;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.apache.http.entity.SerializableEntity;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SuchenActivity extends Activity {

	private ArrayList<LatLng> arrayList = new ArrayList<LatLng>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_suchen);
		
		XmlPullParserFactory pullParserFactory;
		try {
			pullParserFactory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = pullParserFactory.newPullParser();

		    InputStream in_s = getApplicationContext().getAssets().open("muelleimer_berlin.xml");
	        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseXML(parser);
            
            Button suchen = (Button) findViewById(R.id.angry_btn2);
            suchen.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(SuchenActivity.this, MapsActivity.class);
					Bundle bundle = new Bundle();
					bundle.putSerializable("data",  arrayList);
					intent.putExtras(bundle);
					startActivity(intent);
				}
			});
	            
		} catch (XmlPullParserException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
	{
        int eventType = parser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;
            switch (eventType){
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("node")){
                    	LatLng latlon = new LatLng();
                    	latlon.setLat(Double.parseDouble(parser.getAttributeValue(1)));
                    	latlon.setLon(Double.parseDouble(parser.getAttributeValue(2)));
                        arrayList.add(latlon);
                    } 
                    break;
            }
            eventType = parser.next();
        }
	}
	
}
