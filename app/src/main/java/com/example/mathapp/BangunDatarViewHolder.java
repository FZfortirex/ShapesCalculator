package com.example.mathapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class BangunDatarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView nameView;
    ImageView imageView;
    CardView cardView;
    private Context context;
    private Items currentItem;
    private int Param;



    public BangunDatarViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.tvNameBangunDatar);
        imageView = itemView.findViewById(R.id.imageView);
        cardView = itemView.findViewById(R.id.cardView);
        context = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bind(Items item){
        currentItem = item;
        nameView.setText(item.getName());
        Glide.with(itemView.getContext())
                .load(item.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
        Param = item.getParam();
    }


    @Override
    public void onClick(View v) {
        switch (Param){
            case 1:
                Intent intent1 = new Intent(context, Calculator1Param.class);

                intent1.putExtra("name", currentItem.getName());
                intent1.putExtra("image", currentItem.getImage());

                context.startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(context, Calculator2Param.class);

                intent2.putExtra("name", currentItem.getName());
                intent2.putExtra("image", currentItem.getImage());

                context.startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(context, Calculator3Param.class);

                intent3.putExtra("name", currentItem.getName());
                intent3.putExtra("image", currentItem.getImage());

                context.startActivity(intent3);
                break;
            default:
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
