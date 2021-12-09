package com.example.icecom_2019111635;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    String data1[], data2[], data3[], data4[], data5[];
    int images[], images2[];
    Context context;

    public ProductAdapter(Context ct, String s1[], String s2[], String s3[], String s4[], String s5[], int img[], int img2[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        data4 = s4;
        data5 = s5;
        images = img;
        images2 = img2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.text_name.setText(data1[position]);
        holder.text_price.setText(data2[position]);
        holder.text_detail.setText(data3[position]);
        holder.imageView.setImageResource(images[position]);


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MainActivity2.class);
                i.putExtra("product_name",data1[position]);
                i.putExtra("product_price",data2[position]);
                i.putExtra("product_detail",data3[position]);
                i.putExtra("product_explanation",data4[position]);
                i.putExtra("product_website",data5[position]);
                i.putExtra("images",images[position]);
                i.putExtra("images2",images2[position]);

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text_name, text_price, text_detail;
        ImageView imageView;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_name = itemView.findViewById(R.id.product_name);
            text_price = itemView.findViewById(R.id.product_price);
            text_detail = itemView.findViewById(R.id.product_detail);
            imageView = itemView.findViewById(R.id.product_img);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}