package com.example.apk1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText editText;
    TextView result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.editTextNumberDecimal2);
        result=(TextView) findViewById(R.id.textView);
        btn=(Button) findViewById(R.id.button2);
        result.setVisibility(View.INVISIBLE);
        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Operators, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                btnx(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }
    void btnx(int position)
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(editText.getText().toString().isEmpty())
                {
                    result.setText("Number field can't be empty");
                }
                else
                {
                    result.setVisibility(View.VISIBLE);
                    String value=editText.getText().toString();
                    Double a=Double.parseDouble(value);
                    if (position == 0)
                    {
                        double r = a*a;
                        result.setText(String.format("Answer= %.2f", r));
                    }
                    if (position == 1)
                    {
                        double r = a*a*a;
                        result.setText(String.format("Answer= %.2f", r));
                    }
                    if (position == 2)
                    {
                        double r =Math.sqrt(a);
                        result.setText(String.format("Answer= %.2f", r));
                    }
                    if (position == 3)
                    {
                        double r =Math.cbrt(a);
                        result.setText(String.format("Answer= %.2f", r));
                    }
                }
            }
        });
    }
}