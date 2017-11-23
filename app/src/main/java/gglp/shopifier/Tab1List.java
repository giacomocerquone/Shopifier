package gglp.shopifier;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import gglp.shopifier.Model.Shop;
import gglp.shopifier.Shared.ShopService;

public class Tab1List extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1list, container, false);

        List<Shop> shop_list = new ArrayList<>();
        shop_list.add(new Shop("L\'Aquila Shop", "Via Fimmina 1", "0858991827", "laquilashop@gmail.com"));
        shop_list.add(new Shop("Roma Shop", "Via Dinari 2", "0798274635", "romashop@gmail.com"));
        shop_list.add(new Shop("Firenze Shop", "Via Capsand 3", "0896251435", "firenzeshop@gmail.com"));
        shop_list.add(new Shop("Ancona Shop", "Via TheNow 4", "0717965748", "anconashop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio FINE", "0616987939", "barishop@gmail.com"));

        final ArrayAdapter<Shop> adapter = new ArrayAdapter<>(
                getActivity(),
                R.layout.list_item_shop,
                R.id.text_view_shop,
                shop_list
        );

        ListView listView = (ListView) rootView.findViewById(R.id.shop_list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Shop shop = (Shop) parent.getItemAtPosition(position);
                Intent intent = new Intent(Tab1List.this.getContext(), ShopDetailActivity.class);
                intent.putExtra("name", shop.getName());
                intent.putExtra("address", shop.getAddress());
                intent.putExtra("tel", shop.getTel());
                intent.putExtra("email", shop.getEmail());
                startActivity(intent);
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this.getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://shopifier.herokuapp.com/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new GsonBuilder().create();
                        Shop[] shops = gson.fromJson(response, Shop[].class);
                        ShopService.shops = shops;
                        adapter.clear();
                        for(Shop shop : shops) {
                            adapter.add(shop);
                        }
                        Toast.makeText(getContext(), "Tutto regolare", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Errore di connessione", Toast.LENGTH_LONG).show();
            }
        });
        queue.add(stringRequest);

        return rootView;
    }

}
