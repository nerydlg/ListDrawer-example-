package com.example.nerydlg.md_app2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by nerydlg on 15/03/16.
 */
public class DrawerAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    public static final String[] menu = {"Seccion 1", "Seccion 2", "Seccion 3", "Help" };

    public DrawerAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return menu.length;
    }

    @Override
    public Object getItem(int position) {
        return menu[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.row_drawer, null);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.myText);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        setText(holder, position);
        return convertView;
    }

    private void setText(ViewHolder holder, int position) {
        holder.text.setText( (String) getItem(position));
    }



    private class ViewHolder{
        TextView text;
    }
}
