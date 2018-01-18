package gglp.shopifier;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ShopDetailActivity extends AppCompatActivity {

    private static final String TAG = "asd";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_detail_activity);

        TextView name = (TextView) findViewById(R.id.details_name);
        TextView address = (TextView) findViewById(R.id.details_address);
        TextView phone = (TextView) findViewById(R.id.details_phone);
        TextView descr = (TextView) findViewById(R.id.details_descr);
        TextView email = (TextView) findViewById(R.id.details_email);
        ImageView imageView = (ImageView)this.findViewById(R.id.image_view_shop);

        String name_text = getIntent().getStringExtra("name");
        String address_text = getIntent().getStringExtra("address");
        String phone_text = getIntent().getStringExtra("phone");
        String descr_text = getIntent().getStringExtra("descr");
        String email_text = getIntent().getStringExtra("email");
        String image_url = getIntent().getStringExtra("image");
        Picasso.with(this).load("http://shopifier.herokuapp.com/"+image_url).into(imageView);

        if(name_text != null) name.setText(name_text);
        if(address_text != null) address.setText(address_text);
        if(phone_text != null) phone.setText(phone_text);
        if(descr_text != null) descr.setText(descr_text);
        if(email_text != null) email.setText(email_text);
    }

    public void call_shop(View v) {
        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+getIntent().getStringExtra("phone")));
            startActivity(callIntent);
        } catch (ActivityNotFoundException activityException) {
            Log.e("Calling a Phone Number", "Call failed", activityException);
        }
    }

    public void send_email_shop(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",getIntent().getStringExtra("email"), null));
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    public void open_gmap(View v) {
        Log.i(TAG, "LAT: "+getIntent().getStringExtra("lat"));
        Log.i(TAG, "LON: "+getIntent().getStringExtra("lon"));
        Intent gmapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("geo:%s,%s", getIntent().getStringExtra("lat"), getIntent().getStringExtra("lon"))));
        startActivity(gmapIntent);
    }
}
