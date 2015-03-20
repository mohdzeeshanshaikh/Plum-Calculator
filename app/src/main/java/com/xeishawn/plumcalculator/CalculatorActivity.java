package com.xeishawn.plumcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends Activity {

    Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven;
    Button buttonEight, buttonNine, buttonZero, buttonPlus, buttonMinus, buttonEqual, buttonClear;
    TextView textView;
    Integer operand1 = 0, operand2 = 0, result = 0;
    String operator = "";
    String temp = "";
    boolean hide = true;

    /*This method scrutinizes the textView and digits before appending.
    The scrutiny discards the leading 0's and ensures that only 7 digits are entered.*/
    private void scrutinyAppend(String digit){
        if(hide){
            textView.setText("");
            hide=false;
        }
        textView.append(digit);
        discardLeadingZeros();
        keepOnlySevenDigits();
    }

    /*This method discards all the leading 0's by simply converting the
    value in the textView to an integer and displaying back as a string.*/
    private void discardLeadingZeros(){
        Integer zee = Integer.valueOf(textView.getText().toString());
        textView.setText(zee.toString());
    }

    /*As expected, this method ensures that the
    entered value is only up to 7 digits.*/
    private void keepOnlySevenDigits(){
        Integer zee = Integer.valueOf(textView.getText().toString());
        if(zee>9999999 || zee<-9999999)
            zee = zee/10;
        textView.setText(zee.toString());
    }

    /*This method updates and displays the value of operand1 on
    the textView whenever plus or minus buttons are pressed.*/
    private void operate(){
        temp = textView.getText().toString();
        if (!temp.equals("") && !hide){
            if(operator.equals("+"))
                operand1=operand1+Integer.valueOf(temp);
            else if(operator.equals("-"))
                operand1=operand1-Integer.valueOf(temp);
            else
                operand1=Integer.valueOf(temp);
        }
        textView.setText(String.valueOf(operand1));
        hide = true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textView = (TextView) findViewById(R.id.textView);

        buttonOne = (Button) findViewById(R.id.buttonOne);
        buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonThree = (Button) findViewById(R.id.buttonThree);
        buttonFour = (Button) findViewById(R.id.buttonFour);
        buttonFive = (Button) findViewById(R.id.buttonFive);
        buttonSix = (Button) findViewById(R.id.buttonSix);
        buttonSeven = (Button) findViewById(R.id.buttonSeven);
        buttonEight = (Button) findViewById(R.id.buttonEight);
        buttonNine = (Button) findViewById(R.id.buttonNine);
        buttonZero = (Button) findViewById(R.id.buttonZero);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrutinyAppend("1");
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrutinyAppend("2");
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrutinyAppend("3");
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrutinyAppend("4");
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrutinyAppend("5");
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrutinyAppend("6");
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrutinyAppend("7");
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrutinyAppend("8");
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrutinyAppend("9");
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrutinyAppend("0");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            //This method sets the operator to '+' and handles multiple operations in a sequence.
            @Override
            public void onClick(View v) {
                operate();
                operator = "+";
            }
        });


        buttonMinus.setOnClickListener(new View.OnClickListener() {
            //This method sets the operator to '-' and handles multiple operations in a sequence.
            @Override
            public void onClick(View v) {
                operate();
                operator = "-";
            }
        });


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            /*This method performs the appropriate operation and displays the result on the textView.
            If the result is greater than '99999999' or less than '-9999999' it resets the result to '0'*/
            @Override
            public void onClick(View v) {
                temp = textView.getText().toString();
                if (!temp.equals("") && !hide) {
                    operand2 = Integer.valueOf(temp);
                    if (operator.equals("+"))
                        result = operand1 + operand2;
                    else if (operator.equals("-"))
                        result = operand1 - operand2;
                    else
                        result = operand2;
                    if(result>99999999 || result<-9999999)
                        result=0;
                    textView.setText(result.toString());
                }
                else{
                    textView.setText(String.valueOf(operand1));
                    hide=true;
                }
                operand1 = 0;
                operand2 = 0;
                operator = "";
            }
        });


        buttonClear.setOnClickListener(new View.OnClickListener() {
            //This method resets all variables along with the textView.
            @Override
            public void onClick(View v) {
                textView.setText("");
                operand1 = 0;
                operand2 = 0;
                result = 0;
                operator = "";
                temp = "";
            }
        });
    }
}