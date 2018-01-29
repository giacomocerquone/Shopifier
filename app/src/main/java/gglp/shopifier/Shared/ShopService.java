package gglp.shopifier.Shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
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

import java.util.List;

import gglp.shopifier.Model.Shop;
import gglp.shopifier.R;

public class ShopService {
    List<Shop> sList;

    public static void writeShops(String localShops, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.putString("shops", localShops);
        editor.apply();
    }

    public static String readShops(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("shops", "");
    }

    public static void getShops(final Context context, final ArrayAdapter<Shop> adapter, View view) {
        final View progressBar = view.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://shopifier.herokuapp.com/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ShopService.writeShops(response, context);
                        adapter.clear();
                        progressBar.setVisibility(View.GONE);
                        Gson gson = new GsonBuilder().create();
                        Shop[] shops = gson.fromJson(response, Shop[].class);
                        for (Shop shop : shops) {
                            adapter.add(shop);
                        }
                        //Toast.makeText(context, "Dati ottenuti", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                adapter.clear();
                progressBar.setVisibility(View.GONE);
                String jsonShops = ShopService.readShops(context);
                if (!jsonShops.equals("")) {
                    Gson gson = new GsonBuilder().create();
                    Shop[] shops = gson.fromJson(jsonShops, Shop[].class);
                    for (Shop shop : shops) {
                        adapter.add(shop);
                    }
                }
                Toast.makeText(context, "Errore di connessione", Toast.LENGTH_LONG).show();
            }
        });
        queue.add(stringRequest);
    }
}
