package ch.bbcag.datoria.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import ch.bbcag.datoria.Debt;
import ch.bbcag.datoria.R;

/**
 * Created by bbetti on 02.05.2017.
 */

public class DebtAdapter extends ArrayAdapter<Debt> {

    Context context;
    int layoutResourceId;
    Debt[] data = null;

    public DebtAdapter(Context context, int resource, Debt[] data) {
        super(context, resource, data);

        this.context = context;
        this.layoutResourceId = resource;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        DebtHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            // Get views
            holder = new DebtHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle);

            holder.txtValue = (TextView) row.findViewById(R.id.txtValue);

            row.setTag(holder);
        }
        else
        {
            holder = (DebtHolder)row.getTag();
        }

        Debt debt = data[position];
        holder.txtTitle.setText(debt.getTitle());
        holder.txtValue.setText("CHF " + Double.toString(debt.getValue()));

        return row;
    }


    static class DebtHolder
    {
        TextView txtTitle;
        TextView txtValue;
    }
}
