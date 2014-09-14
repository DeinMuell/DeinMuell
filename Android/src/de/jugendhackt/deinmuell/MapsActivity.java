package de.jugendhackt.deinmuell;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends Activity {

	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);

		ArrayList<de.jugendhackt.deinmuell.LatLng> data = (ArrayList<de.jugendhackt.deinmuell.LatLng>) getIntent()
				.getExtras().getSerializable("data");

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		map.addMarker(new MarkerOptions().position(
				new LatLng(52.518611, 13.408333)).title("Berlin"));

		for (de.jugendhackt.deinmuell.LatLng koordinaten : data) {
			map.addMarker(new MarkerOptions()
					.position(
							new LatLng(koordinaten.getLat(), koordinaten
									.getLon()))
					.title("Müll")
					.snippet("Hier ist ein Mülleimer")
					.icon(BitmapDescriptorFactory
							.fromResource(R.drawable.ic_launcher)));
		}

		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(52.518611,
				13.408333), 15));

		// Zoom in, animating the camera.
		map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
	}

}
