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
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

import gglp.shopifier.Model.Shop;

public class Tab1List extends Fragment {

    private FusedLocationProviderClient mFusedLocationClient;
    private static final int MY_PERMISSIONS_REQUEST_READ_FINE_LOCATION = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                    Toast.makeText(getActivity().getApplicationContext(), grantResults.toString() ,Toast.LENGTH_LONG);
                } else {
                    // Permission not granted
                    Toast.makeText(getActivity().getApplicationContext(), "E' inutile utilizzare quest'applicazione senza abilitare la posizione!", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1list, container, false);
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
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if(location != null)
                                Toast.makeText(getActivity().getApplicationContext(), "Posizione ottenuta: " + location.getLatitude(), Toast.LENGTH_LONG).show();
                        }
                    });
        }

        List<Shop> shop_list = new ArrayList<>();
        shop_list.add(new Shop("L\'Aquila Shop", "Via Fimmina 1", "0858991827", "laquilashop@gmail.com"));
        shop_list.add(new Shop("Roma Shop", "Via Dinari 2", "0798274635", "romashop@gmail.com"));
        shop_list.add(new Shop("Firenze Shop", "Via Capsand 3", "0896251435", "firenzeshop@gmail.com"));
        shop_list.add(new Shop("Ancona Shop", "Via TheNow 4", "0717965748", "anconashop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));

        ArrayAdapter<Shop> adapter = new ArrayAdapter<Shop>(
                getActivity(),
                R.layout.list_item_shop,
                R.id.text_view_shop,
                shop_list
        );

        ListView listView = (ListView)rootView.findViewById(R.id.shop_list_view);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Shop shop = (Shop) parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), ShopDetailActivity.class);
                intent.putExtra("name", shop.getName());
                intent.putExtra("address", shop.getAddress());
                intent.putExtra("tel", shop.getTel());
                intent.putExtra("email", shop.getEmail());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
