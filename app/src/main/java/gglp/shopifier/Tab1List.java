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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gglp.shopifier.Model.Shop;

public class Tab1List extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1list, container, false);

        //ListView myList;

        List<Shop> shop_list = new ArrayList<>();
        shop_list.add(new Shop("L\'Aquila Shop", "Via Fimmina 1", "0858991827", "laquilashop@gmail.com"));
        shop_list.add(new Shop("Roma Shop", "Via Dinari 2", "0798274635", "romashop@gmail.com"));
        shop_list.add(new Shop("Firenze Shop", "Via Capsand 3", "0896251435", "firenzeshop@gmail.com"));
        shop_list.add(new Shop("Ancona Shop", "Via TheNow 4", "0717965748", "anconashop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
        shop_list.add(new Shop("Bari Shop", "Via Pierantonio 5", "0616987939", "barishop@gmail.com"));
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
