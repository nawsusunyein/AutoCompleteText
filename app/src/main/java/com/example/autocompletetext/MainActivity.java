package com.example.autocompletetext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] countries = {"India", "USA", "Australia", "UK", "Italy", "Ireland", "Africa"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,countries);
        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.txtAutoComplete);
        acTextView.setThreshold(1);
        acTextView.setAdapter(arrayAdapter);
        acTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Selected Item: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
