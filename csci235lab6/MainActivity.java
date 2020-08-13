package com.example.devon.csci235lab6;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Button button;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.button2);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.conversions, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        final String text = (String) spinner.getSelectedItem();
        EditText simpleEditText = (EditText) findViewById(R.id.editText);
        final String strValue = simpleEditText.getText().toString();
        final Float newF = Float.valueOf(strValue);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //method
                if (text == "FahrenheitToCelsius") {
                    toCelsius(newF);
                } else if (text == "CelsiusToFahrenheit") {
                    toFahrenheit(newF);
                } else if (text == "PoundstoKilograms") {
                    toKilograms(newF);
                } else if (text == "KilogramsToPounds") {
                    toPounds(newF);
                } else if (text == "MilesToKilometers") {
                    toKilometers(newF);
                } else if (text == "KilometersToMiles") {
                    toMiles(newF);
                }
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public static float toFahrenheit(float celsius) {
        float fahrenheit = 9 * (celsius / 5) + 32;
        return fahrenheit;
    }

    public static float toCelsius(float fahrenheit) {
        float celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }

    public static float toMiles(float kilometers) {
        float miles = (float) (kilometers * 0.62137);
        return miles;
    }

    public static float toKilometers(float miles) {
        float kilometers = (float) (miles * 1.6);
        return kilometers;
    }

    public static float toPounds(float kilograms) {
        float pounds = (float) (kilograms * 2.2);
        return pounds;
    }

    public static float toKilograms(float pounds) {
        float kilograms = (float) (pounds * 0.45);
        return kilograms;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}