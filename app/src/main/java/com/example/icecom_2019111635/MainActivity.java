package com.example.icecom_2019111635;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[], s4[], s5[];

    int images[] = {R.drawable.clothes1, R.drawable.clothes2, R.drawable.clothes3,
            R.drawable.clothes4, R.drawable.clothes5, R.drawable.clothes6,
            R.drawable.clothes7, R.drawable.clothes8, R.drawable.clothes9, R.drawable.clothes10};

    int images2[] = {R.drawable.clothes11, R.drawable.clothes22, R.drawable.clothes33,
            R.drawable.clothes44, R.drawable.clothes55, R.drawable.clothes66,
            R.drawable.clothes77, R.drawable.clothes88, R.drawable.clothes99, R.drawable.clothes1010 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        TextView cs = findViewById(R.id.cs);
        TextView location = findViewById(R.id.location);

        s1 = getResources().getStringArray(R.array.product_name);
        s2 = getResources().getStringArray(R.array.product_price);
        s3 = getResources().getStringArray(R.array.product_detail);
        s4 = getResources().getStringArray(R.array.product_explanation);
        s5 = getResources().getStringArray(R.array.product_website);

        ProductAdapter myAdapter = new ProductAdapter(this, s1, s2, s3, s4, s5, images, images2);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, CustomerService.class);
                startActivity(intent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

//        location.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri=Uri.parse("http://maps.google.com/maps?q="+37.55827+","+126.998425);
//
//                Intent intent= new Intent(Intent.ACTION_VIEW,uri);
//                startActivity(intent);
//            }
//        });
    }
}