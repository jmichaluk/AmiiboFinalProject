package com.mobiledev.jordyn.amiibofinalproject.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.mobiledev.jordyn.amiibofinalproject.Activities.SingleItemActivity;
import com.mobiledev.jordyn.amiibofinalproject.ImageLoader;
import com.mobiledev.jordyn.amiibofinalproject.Models.Amiibo;
import com.mobiledev.jordyn.amiibofinalproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jordyn on 2015-11-09.
 */
public class AmiiboAdapter extends BaseAdapter{

    Context context;
    LayoutInflater inflater;
    ImageLoader imageLoader;
    private List<Amiibo> amiiboArrayList = null;
    private ArrayList<Amiibo> arrayList;
    int position;

    public AmiiboAdapter(Context context, List<Amiibo> amiiboArrayList) {
        this.context = context;
        this.amiiboArrayList = amiiboArrayList;
        inflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<Amiibo>();
        this.arrayList.addAll(amiiboArrayList);
        imageLoader = new ImageLoader(context);
    }

    public class ViewHolder {
        ImageView amiibo;
    }

    @Override
    public int getCount() {
        return amiiboArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return amiiboArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        this.position = position;
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.amiibo_list_item, null);
            holder.amiibo = (ImageView) view.findViewById(R.id.img);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        imageLoader.DisplayImage(amiiboArrayList.get(position).getAmiiboImage(), holder.amiibo);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SingleItemActivity.class);

                intent.putExtra("amiiboID", amiiboArrayList.get(position).getAmiiboID());
                intent.putExtra("image", amiiboArrayList.get(position).getAmiiboImage());
                intent.putExtra("name", amiiboArrayList.get(position).getName());
                intent.putExtra("description", amiiboArrayList.get(position).getDescription());
                context.startActivity(intent);
            }
        });
        return view;
    }

}
