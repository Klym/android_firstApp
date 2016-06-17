package com.example.myfirstapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class UserAdapter extends SimpleAdapter {
    private List<Map<String, String>> values;
    private Context context;
    private int resource;
    private String[] from;
    private int[] to;

    public UserAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.values = (List<Map<String,String>>) data;
        this.context = context;
        this.resource = resource;
        this.from = from;
        this.to = to;
    }

    @Override
    public Map<String, String> getItem(int position) {
        return this.values.get(position);
    }

    @Override
    public int getCount() {
        return this.values.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(this.resource, parent, false);
        TextView login = (TextView) rowView.findViewById(this.to[0]);
        TextView pass = (TextView) rowView.findViewById(this.to[1]);
        Map<String, String> item = this.getItem(position);
        login.setText(item.get(this.from[0]));
        pass.setText(item.get(this.from[1]));
        if (position % 2 == 0) {
            rowView.setBackgroundColor(Color.argb(50, 180, 170, 170));
        }
        return rowView;
    }
}
