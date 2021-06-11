package com.example.pas_27_10rpl1;

import android.content.Context;
import android.telecom.Call;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;


import androidx.recyclerview.widget.RecyclerView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MyHolder> {

    private ArrayList<Makanan> datalist;
    int posku;
    View viewku;
    FungsiBalik klik;
    Context c;
    ArrayList<Makanan> models;


    interface FungsiBalik {
        void pasdiClick (int index);
    }

    public MakananAdapter(Context c, ArrayList<Makanan> models, FungsiBalik klik ) {
        this.klik = klik;
        this.c = c;
        this.models = models;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemview, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        myHolder.mTitle.setText(models.get(i).getTitle());
        myHolder.mTmaeView.setImageResource(models.get(i).getImg());

    }


    @Override
    public int getItemCount() {
        models.size();
        return (models != null) ? models.size() : 0;
    }

    //holder
     class MyHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        ImageView mTmaeView;
        TextView mTitle;

        public MyHolder( View itemView) {
            super(itemView);
            viewku = itemView;
            itemView.setOnCreateContextMenuListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    klik.pasdiClick(getAdapterPosition());
                }
            });

            this.mTmaeView = itemView.findViewById(R.id.imageTv);
            this.mTitle = itemView.findViewById(R.id.titleTv);
        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Delete = menu.add(Menu.NONE, 1, 1, "Delete");
            posku = getAdapterPosition();
            Delete.setOnMenuItemClickListener(onlickcontextmenu);
        }
    }



    private final MenuItem.OnMenuItemClickListener onlickcontextmenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch ( (item.getItemId())) {

                case 1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(viewku.getContext());
                    builder.setMessage("Are you sure to delete data")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    models.remove(posku);
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            //set your icon at here
                            .setTitle("Delete data")
                            .setIcon(R.mipmap.ic_launcher);
                    AlertDialog alert = builder.create();
                    alert.show(); //showing the dialog

                    break;
            }
            return false;
        }
    };




}