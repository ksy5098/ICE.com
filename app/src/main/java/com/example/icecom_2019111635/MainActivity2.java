package com.example.icecom_2019111635;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    ImageView mainImageView, mainImageView2;
    TextView product_name, product_price, product_detail, product_explanation, product_website;

    String data1, data2, data3, data4, data5;
    int myImage, myImage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mainImageView = findViewById(R.id.product_img2);
        mainImageView2 = findViewById(R.id.product_img22);
        product_name = findViewById(R.id.product_name2);
        product_price = findViewById(R.id.product_price2);
        product_detail = findViewById(R.id.product_detail2);
        product_explanation = findViewById(R.id.product_detail2);
        product_website = findViewById(R.id.product_website);

        product_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.beginning.kr"));
                startActivity(intent);
            }
        });

        getData();
        setData();



    }

    private void getData(){
        if(getIntent().hasExtra("images") &&
                getIntent().hasExtra("images2") &&
                getIntent().hasExtra("product_name") &&
                getIntent().hasExtra("product_price") &&
                getIntent().hasExtra("product_detail") &&
                getIntent().hasExtra("product_explanation") &&
                getIntent().hasExtra("product_website"))
        {
            data1 = getIntent().getStringExtra("product_name");
            data2 = getIntent().getStringExtra("product_price");
            data3 = getIntent().getStringExtra("product_detail");
            data4 = getIntent().getStringExtra("product_explanation");
            data5 = getIntent().getStringExtra("product_website");
            myImage = getIntent().getIntExtra("images", 1);
            myImage2 = getIntent().getIntExtra("images2", 1);
        } else{
            Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        product_name.setText(data1);
        product_price.setText(data2);
        product_detail.setText(data3);
        product_explanation.setText(data4);
        product_website.setText(data5);
        mainImageView.setImageResource(myImage);
        mainImageView2.setImageResource(myImage2);
    }



}