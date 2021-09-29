package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private String units[] = {"Hải lý", "Dặm", "Kilometer", "Lý", "Met", "Yard", "Foot", "Inches"};
    private double[][] ratio = {
            {1.00000000, 1.15077945, 1.8520000, 20.2537183, 1852.0000, 2025.37183, 6076.11549, 72913.38583},
            {0.86897624, 1.00000000, 1.6093440, 17.6000000, 1609.3440, 1760.00000, 5280.00000, 63360.00000},
            {0.53995680, 0.62137119, 1.0000000, 10.9361330, 1000.0000, 1093.61330, 3280.83990, 39370.07874},
            {0.04937365, 0.05681818, 0.0914400, 1.00000000, 91.440000, 100.000000, 300.000000, 3600.000000},
            {0.00053996, 0.00062137, 0.0010000, 0.01093610, 1.0000000, 1.09361000, 3.28084000, 39.37008000},
            {0.00049374, 0.00056818, 0.0009144, 0.01000000, 0.9144000, 1.00000000, 3.00000000, 36.00000000},
            {0.00016458, 0.00018939, 0.0003048, 0.00333330, 0.3048000, 0.33333000, 1.00000000, 12.00000000},
            {0.00001371, 0.00001578, 0.0000254, 0.00027789, 0.0254000, 0.02778000, 0.08333000, 1.000000000}
    };

    EditText txtNumber;
    Spinner spnUnit;
    TextView[] lblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtNumber = (EditText)findViewById(R.id.txt_number2);
        spnUnit = (Spinner) findViewById(R.id.spnUnit2);
        lblResult = new TextView[]{
                (TextView) findViewById(R.id.lbl_HaiLy),
                (TextView) findViewById(R.id.lbl_Dam),
                (TextView) findViewById(R.id.lbl_Km),
                (TextView) findViewById(R.id.lbl_Ly),
                (TextView) findViewById(R.id.lbl_Met),
                (TextView) findViewById(R.id.lbl_Yard),
                (TextView) findViewById(R.id.lbl_Foot),
                (TextView) findViewById(R.id.lbl_Inches)
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity2.this, android.R.layout.simple_spinner_item, units
        );
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spnUnit.setAdapter(adapter);

        spnUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ChangeLengthUnit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        txtNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ChangeLengthUnit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void ChangeLengthUnit(){
        int rowIdx = spnUnit.getSelectedItemPosition();
        if(rowIdx < 0){
            rowIdx = 0;
        }

        String input = txtNumber.getText().toString();
        if(input.isEmpty()){
            input = "0";
        }

        double number = Double.valueOf(input);

        for (int i = 0; i < lblResult.length; i++){
            double temp = number * ratio[rowIdx][i];
            lblResult[i].setText(String.valueOf(temp));
        }
    }
}