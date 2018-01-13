package gglp.shopifier;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

import gglp.shopifier.Model.Shop;
import gglp.shopifier.Shared.ShopService;

public class Tab2Map extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap googleMap;
    private ArrayAdapter<Shop> adapter;
    private int i=0;


    private FusedLocationProviderClient mFusedLocationClient;
    private static final int MY_PERMISSIONS_REQUEST_READ_FINE_LOCATION = 100;
    private double lat, lon;

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                    Toast.makeText(getActivity().getApplicationContext(), grantResults.toString() ,Toast.LENGTH_SHORT).show();
                } else {
                    // Permission not granted
                    Toast.makeText(getActivity().getApplicationContext(), "E' inutile utilizzare quest'applicazione senza abilitare la posizione!", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2map, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        map.setMapType(map.MAP_TYPE_HYBRID);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity().getApplicationContext());

        // Check if we have permissions
        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Returns true if the app has requested this permission previously and the user denied the request
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(getActivity().getApplicationContext(), "Il permesso di localizzazione è necessario per localizzare gli shops attorno a te!", Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_READ_FINE_LOCATION);
            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_READ_FINE_LOCATION);
            }
        } else {
            mFusedLocationClient.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if(location != null) {
                                lat = location.getLatitude();
                                lon = location.getLongitude();
                                Toast.makeText(getActivity().getApplicationContext(), "Latitudine: " + lat + "\nLongitudine: " + lon, Toast.LENGTH_SHORT).show();
                                LatLng personal = new LatLng(lat, lon);
                                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(personal,13));
                                MarkerOptions markerOptions = new MarkerOptions();
                                markerOptions.position(personal);
                                markerOptions.title("You");
                                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                                Marker marker = googleMap.addMarker(markerOptions);
                            }
                            else Toast.makeText(getActivity().getApplicationContext(),"merda",Toast.LENGTH_SHORT).show();
                        }
                    });
addShops();
            /*//for(i=0;i<adapter.getCount();i++){
                LatLng p = new LatLng(Double.parseDouble(adapter.getItem(i).getLat()),Double.parseDouble(adapter.getItem(i).getLon()));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p,9));
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(p);
                markerOptions.title(adapter.getItem(i).getName());
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                Marker marker = googleMap.addMarker(markerOptions);
           //*/ }
        }


    @Override
    public void setUserVisibleHint(boolean visible) {
        super.setUserVisibleHint(visible);
        if (visible && isResumed()) {
            Toast.makeText(getActivity().getApplicationContext(), "Muss", Toast.LENGTH_SHORT).show();
        }
    }


    public void addShops(){
        /*List<Shop> shop_list = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                getActivity(),
                R.layout.list_item_shop,
                R.id.text_view_shop,
                shop_list
        );
        ListView listView = (ListView) view.findViewById(R.id.shop_list_view);
        listView.setAdapter(adapter);
        ShopService.getShops(getActivity().getApplicationContext(), adapter, view);
        */LatLng p = new LatLng(42.364682,13.342044);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p,11));
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(p);
        markerOptions.title("ranaldo");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        Marker marker = googleMap.addMarker(markerOptions);
        }
}