package com.example.ar_pc.projectr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AR-PC on 10/19/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.RowHolder>{
    private LayoutInflater inflater;
    private ArrayList<menuItem> menuItems;
    private Context mContext;

    public MenuAdapter(Context context, ArrayList<menuItem> menuItems) {
        this.mContext=context;
        this.inflater = LayoutInflater.from(context);
        this.menuItems = menuItems;
    }

    @Override
    public MenuAdapter.RowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View holder = this.inflater.inflate(R.layout.menu_item, parent, false);
        return new RowHolder(holder);
    }

    @Override
    public void onBindViewHolder(MenuAdapter.RowHolder holder, int position) {
        menuItem mi = this.menuItems.get(position);
        final Intent intent = new Intent(mContext, mi.c);
        holder.button.setText(mi.text);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder{
        private Button button;
        public RowHolder(View itemView) {
            super(itemView);
            this.button = (Button) itemView.findViewById(R.id.btMenu);
        }
    }
}
