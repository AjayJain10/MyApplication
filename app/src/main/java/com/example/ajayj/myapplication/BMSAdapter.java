package com.example.ajayj.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ajayj on 19-06-2017.
 */

public class BMSAdapter extends RecyclerView.Adapter<BMSAdapter.BmsViewHolder> {
    ArrayList<BMSEntites> bmsEntites;


    public BMSAdapter(ArrayList<BMSEntites> abcd){
        this.bmsEntites = abcd;

    }

    @Override
    public BmsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bms,parent,false);

        return new BmsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BmsViewHolder holder, int position) {
        holder.title.setText(bmsEntites.get(position).getTitle());
        holder.language.setText(bmsEntites.get(position).getLanguage());
        holder.cover.setImageResource(bmsEntites.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return bmsEntites.size();
    }


    public static class BmsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView cover;
        Button book;
        TextView title, language;

        public BmsViewHolder(View itemView) {
            super(itemView);

            cover = (ImageView) itemView.findViewById(R.id.bmsimage);
            book = (Button) itemView.findViewById(R.id.bmsbutton1);
            title = (TextView) itemView.findViewById(R.id.id1);
            language = (TextView) itemView.findViewById(R.id.id2);

            cover.setOnClickListener(this);
            book.setOnClickListener(this);
            title.setOnClickListener(this);
            language.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.bmsimage:
                    Toast.makeText(v.getContext()," cover image "+getAdapterPosition()+" " +title.getText().toString(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bmsbutton1:
                    Toast.makeText(v.getContext()," button "+getAdapterPosition()+" " +title.getText().toString(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.id1:
                    Toast.makeText(v.getContext()," title "+getAdapterPosition()+" " +title.getText().toString(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.id2:
                    Toast.makeText(v.getContext()," language "+getAdapterPosition()+" " +title.getText().toString(), Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    }
}
