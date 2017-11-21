package gglp.shopifier;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShopDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_detail_activity);

        TextView name = (TextView) findViewById(R.id.details_name);
        TextView address = (TextView) findViewById(R.id.details_address);
        TextView tel = (TextView) findViewById(R.id.details_tel);
        TextView email = (TextView) findViewById(R.id.details_email);

        String n = getIntent().getStringExtra("name");
        String a = getIntent().getStringExtra("address");
        String t = getIntent().getStringExtra("tel");
        String e = getIntent().getStringExtra("email");

        if(n != null) name.setText(n);
        if(a != null) address.setText(a);
        if(t != null) tel.setText(t);
        if(e != null) email.setText(e);
    }
}