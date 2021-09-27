package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    //declare fields
    private TextView display;

    //for calculation
    private double oldValue;
    private double newValue;

    private String textDisplay = "";
    private String operation = "";


    //number buttons
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button num0;

    //operation buttons
    private Button add;
    private Button subt;
    private Button mult;
    private Button div;
    private Button pow;
    private Button neg;
    private Button clear;
    private Button equals;
    private Button decimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //map buttons
        num1 = findViewById(R.id.button1);
        num2 = findViewById(R.id.button2);
        num3 = findViewById(R.id.button3);
        num4 = findViewById(R.id.button4);
        num5 = findViewById(R.id.button5);
        num6 = findViewById(R.id.button6);
        num7 = findViewById(R.id.button7);
        num8 = findViewById(R.id.button8);
        num9 = findViewById(R.id.button9);
        num0 = findViewById(R.id.button0);

        add = findViewById(R.id.addition);
        subt = findViewById(R.id.subtraction);
        mult = findViewById(R.id.multiply);
        div = findViewById(R.id.divide);
        pow = findViewById(R.id.power);
        neg = findViewById(R.id.negate);
        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);
        decimal = findViewById(R.id.decimal);

        display = findViewById(R.id.display);



        //updates the button display
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDisplay = textDisplay + convertForStringInt(1);
                display.setText(textDisplay);
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDisplay = textDisplay + convertForStringInt(2);
                display.setText(textDisplay);
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDisplay = textDisplay + convertForStringInt(3);
                display.setText(textDisplay);
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDisplay = textDisplay + convertForStringInt(4);
                display.setText(textDisplay);
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDisplay = textDisplay + convertForStringInt(5);
                display.setText(textDisplay);
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDisplay = textDisplay + convertForStringInt(6);
                display.setText(textDisplay);
            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDisplay = textDisplay + convertForStringInt(7);
                display.setText(textDisplay);
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDisplay = textDisplay + convertForStringInt(8);
                display.setText(textDisplay);
            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDisplay = textDisplay + convertForStringInt(9);
                display.setText(textDisplay);
            }
        });

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDisplay = textDisplay + convertForStringInt(0);
                display.setText(textDisplay);
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDisplay = textDisplay + ".";
                display.setText(textDisplay);
            }
        });


        //operation functions
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                operation = "+";
                display.setText(format(oldValue));
                textDisplay = "";
            }
        });

        subt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                operation = "-";
                display.setText(format(oldValue));
                textDisplay = "";
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                operation = "m";
                display.setText(format(oldValue));
                textDisplay = "";
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                operation = "d";
                display.setText(format(oldValue));
                textDisplay = "";
            }
        });

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                operation = "p";
                display.setText(format(oldValue));
                textDisplay = "";
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");
                //oldValue = 0.0;
                operation = "";
                textDisplay = "";
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                display.setText(format(oldValue));
                textDisplay = format(oldValue);
                operation = "";
            }
        });

        //negates the display
        neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //is more like the number buttons

                //check if it is positive or negative
                if(textDisplay.charAt(0) == '-'){
                    textDisplay = textDisplay.substring(1);
                }else {
                    textDisplay = "-" + textDisplay;
                }
                display.setText(textDisplay);
            }
        });
    }

    //provides for the functionality of the calculator
    protected void calculate(){
        if(!operation.equals("")) {
           newValue = getNum();
           Log.v("DTB", String.valueOf(newValue));

           if (operation.equals("+")) {
               oldValue = oldValue + newValue;
           } else if (operation.equals("-")) {
               oldValue = oldValue - newValue;
           } else if (operation.equals("m")) {
               oldValue = oldValue * newValue;
           } else if (operation.equals("d")) {
               oldValue = oldValue / newValue;
           } else if (operation.equals("p")) {
               oldValue = Math.pow(oldValue, newValue);
           }else if(operation.equals("n")){
               //Do nothing, it was a negate call
           }
       }else{
            oldValue = getNum();
        }
    }

    //converts value of an int to a String for display
    protected String convertForStringInt(int input){
        return String.valueOf(input);
    }

//    protected String convertForStringDouble(double input){
//        return String.valueOf(input);
//    }
//
//    protected  double convertForDub(String input){
//        return Double.parseDouble(input);
//    }

    //parses the number from the display
    protected Double getNum(){
        return Double.parseDouble(String.valueOf(display.getText()));
    }

    //removes trailing zeros from the double and makes it a string
    protected String format(double input){
        if(input == (long) input){
            return String.format("%d", (long) input);
        }else {
            return String.format("%s", input);
        }
    }
}