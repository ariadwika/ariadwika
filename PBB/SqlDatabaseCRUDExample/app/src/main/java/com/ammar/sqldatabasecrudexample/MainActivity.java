package com.ammar.sqldatabasecrudexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Country> countries;
    SQLiteDatabaseHandler db;
    Button btnSubmit;
    PopupWindow pwindo;
    Activity activity;
    ListView listView;
    CustomCountryList customCountryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        db = new SQLiteDatabaseHandler(this);
        listView = (ListView) findViewById(R.id.list);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPopup();
            }
        });
        Log.d("MainActivity ", "Before reading mainActivity");
        countries = (ArrayList) db.getAllCountry();

        for (Country country : countries) {
            String log = "Id: " + country.getId() + " ,Name: " + country.getCountryName()
                    + " ,Population: " + country.getPopulation();
            Log.d("Name: ", log);
        }

        CustomCountryList customCountryList = new CustomCountryList(this, countries, db);
        listView.setAdapter(customCountryList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You Selected " + countries.get(position).getCountryName() + " as Country", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addPopup() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.edit_popup, null);
        dialogBuilder.setView(dialogView);


        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        final EditText countryEdit = (EditText) dialogView.findViewById(R.id.editTextCountry);
        final EditText populationEdit = (EditText) dialogView.findViewById(R.id.editTextPopulation);

        Button save = (Button) dialogView.findViewById(R.id.save_popup);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countryStr = countryEdit.getText().toString();
                String population = populationEdit.getText().toString();
                Country country = new Country(countryStr, Long.parseLong(population));
                db.addCountry(country);
                if (customCountryList == null) {
                    customCountryList = new CustomCountryList(activity, countries, db);
                    listView.setAdapter(customCountryList);
                }
                customCountryList.countries = (ArrayList) db.getAllCountry();
                ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();

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