package com.example.icecom_2019111635;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button show_product = findViewById(R.id.show_product);
        TextView call = findViewById(R.id.call);
        TextView email = findViewById(R.id.email);
        TextView location = findViewById(R.id.location);


        show_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01036325098"));
                startActivity(intent);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("plain/text");
                String[] address = {"seoyoung4228@naver.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, address);
                startActivity(intent);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("plain/text");
                String[] address = {"seoyoung4228@naver.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, address);
                startActivity(intent);
            }
        });
    }

}