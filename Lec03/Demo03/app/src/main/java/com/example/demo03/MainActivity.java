package com.example.demo03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    final String TAG = "CONCERT TICKETS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnButton = findViewById(R.id.btnCost);
        final EditText editTextNumTickets = findViewById(R.id.editTextNumTickets);
        final Spinner spinnerConceertType = findViewById(R.id.spinnerConcertType);
        final TextView textViewResults = findViewById(R.id.txtViewResult);
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNumTickets.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, //this is OnClickListner.
                            "Number of tickets cannot be empty.",
                            Toast.LENGTH_SHORT).show();
                    Log.w(TAG,"Number of Tickets is empty");
                } else {
                    try{
                        int numTix = Integer.parseInt(editTextNumTickets.getText().toString());
                        int index = spinnerConcertType.getSelectedItemPosition();
                        double cost = 0;
                        switch (index) {
                            case 0:
                                cost = numTix*79.99;
                                break;
                            case 1:
                                cost = numTix*39.99;
                                break;
                            case 2:
                                cost = numTix*59.99;
                                break;
                            default:
                                cost = 0;
                        }
                        DecimalFormat df = new DecimalFormat("$#.##");
                        String outputStr = "Ticket Type: "
                                + spinnerConcertType.getSelectedItem() + "\n";
                        outputStr += "Number of Tickets: " + numTix + "\n";
                        outputStr += "Total Cost: " + df.format(cost);
                        textViewResults.setText(outputStr);
                    } catch (Exception ex) {
                        Log.w(TAG, ex.getMessage());
                    }
                }
            }
        });
    }
}
