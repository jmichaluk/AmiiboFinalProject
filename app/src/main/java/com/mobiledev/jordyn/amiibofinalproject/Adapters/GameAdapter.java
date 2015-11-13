package com.mobiledev.jordyn.amiibofinalproject.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobiledev.jordyn.amiibofinalproject.Activities.SingleItemActivity;
import com.mobiledev.jordyn.amiibofinalproject.ImageLoader;
import com.mobiledev.jordyn.amiibofinalproject.Models.Game;
import com.mobiledev.jordyn.amiibofinalproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jordyn on 2015-11-12.
 */
public class GameAdapter extends BaseAdapter {

        Context context;
        LayoutInflater inflater;
        ImageLoader imageLoader;
        private List<Game> gameArrayList = null;
        private ArrayList<Game> arrayList;
        int position;

        public GameAdapter(Context context, List<Game> gameArrayList) {
            this.context = context;
            this.gameArrayList = gameArrayList;
            inflater = LayoutInflater.from(context);
            this.arrayList = new ArrayList<Game>();
            this.arrayList.addAll(gameArrayList);
            imageLoader = new ImageLoader(context);
        }

        public class ViewHolder {
            ImageView image;
            TextView name;
        }

        @Override
        public int getCount() {
            return gameArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return gameArrayList.get(position);
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
                view = inflater.inflate(R.layout.game_list_item, null);
                holder.image = (ImageView) view.findViewById(R.id.img);
                holder.name = (TextView) view.findViewById(R.id.game_name);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            holder.name.setText(gameArrayList.get(position).getName());

            imageLoader.DisplayImage(gameArrayList.get(position).getImage(), holder.image);



            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SingleItemActivity.class);

                    intent.putExtra("image", gameArrayList.get(position).getGameID());
                    intent.putExtra("name", gameArrayList.get(position).getName());
                    intent.putExtra("image", gameArrayList.get(position).getImage());
                    context.startActivity(intent);
                }
            });
            return view;
        }

    }
