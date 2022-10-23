package com.ammar.sqldatabasecrudexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomCountryList extends BaseAdapter {
    private Activity context;
    ArrayList<Country> countries;
    SQLiteDatabaseHandler db;
    BaseAdapter ba;

    public CustomCountryList(Activity context, ArrayList<Country> countries, SQLiteDatabaseHandler db) {
        this.context = context;
        this.countries = countries;
        this.db = db;
    }

    public static class ViewHolder {
        TextView textViewId;
        TextView textViewCountry;
        TextView textViewPopulation;
        Button editButton;
        Button deleteButton;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder();
            row = inflater.inflate(R.layout.row_item, null, true);

            vh.textViewId = (TextView) row.findViewById(R.id.textViewId);
            vh.textViewCountry = (TextView) row.findViewById(R.id.textViewCountry);
            vh.textViewPopulation = (TextView) row.findViewById(R.id.textViewPopulation);
            vh.editButton = (Button) row.findViewById(R.id.edit);
            vh.deleteButton = (Button) row.findViewById(R.id.delete);

            //store the holder with the view
            row.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.textViewCountry.setText(countries.get(position).getCountryName());
        vh.textViewPopulation.setText("" + countries.get(position).getPopulation());
        vh.textViewId.setText("" + countries.get(position).getId());
        final int positionPopup = position;
        vh.editButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("Save: ", "" + positionPopup);
                editPopup(positionPopup);
            }
        });

        vh.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Last Index", "" + positionPopup);
                //integer index
                db.deleteCountry(countries.get(positionPopup));

                countries = (ArrayList) db.getAllCountry();
                Log.d("Country Size", "" + countries.size());
                notifyDataSetChanged();
            }
        });
        return row;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    public void editPopup(final int positionPopup) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = context.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.edit_popup, null);
        dialogBuilder.setView(dialogView);


        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        final EditText countryEdit = (EditText) dialogView.findViewById(R.id.editTextCountry);
        final EditText populationEdit = (EditText) dialogView.findViewById(R.id.editTextPopulation);
        countryEdit.setText(countries.get(positionPopup).getCountryName());
        populationEdit.setText("" + countries.get(positionPopup).getPopulation());
        Log.d("Name ", "" + countries.get(positionPopup).getPopulation());
        Button save = (Button) dialogView.findViewById(R.id.save_popup);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countryStr = countryEdit.getText().toString();
                String population = populationEdit.getText().toString();
                Country country = countries.get(positionPopup);
                country.setCountryName(countryStr);
                country.setPopulation(Long.parseLong(population));
                db.updateCountry(country);
                countries = (ArrayList) db.getAllCountry();
                notifyDataSetChanged();
                for (Country country1 : countries) {
                    String log = "Id: " + country1.getId() + " ,Name: " + country1.getCountryName() +
                            " ,Population: " + country1.getPopulation();

                    //Writing country to log
                    Log.d("Name: ", log);
                }
                alertDialog.dismiss();
            }
        });

    }
}
