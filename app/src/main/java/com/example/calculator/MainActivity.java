package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Variables to hold the operands and type of calculation
    private double mValueOne, mValueTwo;

    private boolean mAddition, mSubtraction, mMultiplication, mDivision;

    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the TextView element in the layout
        mResultTextView = findViewById(R.id.text_view_result);

        // Set up the listener for the "C" (clear) button
        Button clearButton = findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResultTextView.setText("");
                mValueOne = 0;
                mValueTwo = 0;
                mAddition = false;
                mSubtraction = false;
                mMultiplication = false;
                mDivision = false;
            }
        });

        // Set up the listener for the "±" (negative) button
        Button negativeButton = findViewById(R.id.button_negative);
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mResultTextView.getText().length() > 0) {
                    String currentText = mResultTextView.getText().toString();
                    if (currentText.charAt(0) == '-') {
                        mResultTextView.setText(currentText.substring(1));
                    } else {
                        mResultTextView.setText("-" + currentText);
                    }
                }
            }
        });

        // Set up the listener for the "%" (percent) button
        Button percentButton = findViewById(R.id.button_percent);
        percentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mResultTextView.getText().length() > 0) {
                    // Convert the current text to a double value
                    double value = Double.parseDouble(mResultTextView.getText().toString());
                    // Calculate the percentage of the value
                    double result = value / 100;
                    // Set the result as the new text in the TextView
                    mResultTextView.setText(String.valueOf(result));
                }
            }
        });

        // Set up the listener for the "÷" (divide) button
        Button divideButton = findViewById(R.id.button_divide);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mResultTextView.getText().length() > 0) {
                    mValueOne = Double.parseDouble(mResultTextView.getText().toString());
                    mDivision = true;
                    mResultTextView.setText("");
                }
            }
        });

        // Set up the listener for the "x" (multiply) button
        Button multiplyButton = findViewById(R.id.button_multiply);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mResultTextView.getText().length() > 0) {
                    mValueOne = Double.parseDouble(mResultTextView.getText().toString());
                    mMultiplication = true;
                    mResultTextView.setText("");
                }
            }
        });

        // Set up the listener for the "-" (subtract) button
        /**
         * the subtract doesnt work
         */


        // Set up the listener for the "+" (add) button
        Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mResultTextView.getText().length() > 0) {
                    mValueOne = Double.parseDouble(mResultTextView.getText().toString());
                    mAddition = true;
                    mResultTextView.setText("");
                }
            }
        });

        // Set up the listener for the "=" (equals) button
        Button equalsButton = findViewById(R.id.button_equals);
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mResultTextView.getText().length() > 0) {
                    mValueTwo = Double.parseDouble(mResultTextView.getText().toString());
                }

                if (mAddition) {
                    mResultTextView.setText(String.valueOf(mValueOne + mValueTwo));
                    mAddition = false;
                } else if (mSubtraction) {
                    mResultTextView.setText(String.valueOf(mValueOne - mValueTwo));
                    mSubtraction = false;
                } else if (mMultiplication) {
                    mResultTextView.setText(String.valueOf(mValueOne * mValueTwo));
                    mMultiplication = false;
                } else if (mDivision) {
                    mResultTextView.setText(String.valueOf(mValueOne / mValueTwo));
                    mDivision = false;
                }
            }
        });

    }

    // Method to handle the button clicks for the digits 0-9
    public void onDigitClick(View view) {
        Button button = (Button) view;
        mResultTextView.append(button.getText());
    }

}