package com.example.a3_mechanicalcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvCurrentCalculation, tvResult;
    private final ArrayList<Calculation> calculationList = new ArrayList<Calculation>();
    private boolean finalized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCurrentCalculation = findViewById(R.id.tvCurrentCalculation);
        tvResult = findViewById(R.id.tvResult);
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnDot = findViewById(R.id.btnDot);
        Button btnClear = findViewById(R.id.btnClear);
        ImageButton btnBackspace = findViewById(R.id.btnBackspace);
        Button btnPercent = findViewById(R.id.btnPercent);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnSubstract = findViewById(R.id.btnSubstract);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnEqual = findViewById(R.id.btnEqual);

        // NUMBER BUTTONS ONCLICKLISTENER
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tvCurrentCalculation.getText().equals("0"))
                    onNumberPressed(((Button) v).getText().toString());
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(((Button) v).getText().toString());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(((Button) v).getText().toString());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(((Button) v).getText().toString());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(((Button) v).getText().toString());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(((Button) v).getText().toString());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(((Button) v).getText().toString());
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(((Button) v).getText().toString());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(((Button) v).getText().toString());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(((Button) v).getText().toString());
            }
        });


        // OPERATOR BUTTONS ONCLICKLISTENER
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(finalized) {
                    calculationList.add(new Calculation("."));
                    showCurrentCalc();

                    tvCurrentCalculation.setTextSize(50);
                    tvCurrentCalculation.setTextColor(getResources().getColor(R.color.black, null));
                    tvResult.setTextSize(35);
                    tvResult.setTextColor(getResources().getColor(R.color.less_black, null));
                    finalized = false;
                } else {
                    if (tvCurrentCalculation.getText().equals("0")) {
                        calculationList.add(new Calculation("."));
                        tvResult.setVisibility(View.VISIBLE);
                    } else {
                        calculationList.get(calculationList.size() - 1).addDot();
                    }
                    showCurrentCalc();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tvCurrentCalculation.getText().equals("0")) {
//                    calculationList.get(calculationList.size() - 1).setCalculationStr("0");
//                    calculationList.get(calculationList.size() - 1).setResult(0);
//                    showCurrentCalc();
                    calculationList.remove(calculationList.size()-1);
                    tvCurrentCalculation.setText("0");
                    tvCurrentCalculation.setTextSize(50);
                    tvCurrentCalculation.setTextColor(getResources().getColor(R.color.black, null));
                    tvResult.setTextSize(35);
                    tvResult.setTextColor(getResources().getColor(R.color.less_black, null));
                    tvResult.setVisibility(View.GONE);
                    finalized = false;
                }
            }
        });
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!finalized) {
                    if (!tvCurrentCalculation.getText().equals("0")) {
                        calculationList.get(calculationList.size() - 1).backspace();
                        if (calculationList.get(calculationList.size() - 1).getCalculationStr().equals("")) {
                            calculationList.remove(calculationList.size() - 1);
                            tvCurrentCalculation.setText("0");
                            tvResult.setVisibility(View.GONE);
                        } else
                            showCurrentCalc();
                    }
                }
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(finalized) {
                    String prevResult = tvResult.getText().toString();
                    Double percentaged = Double.parseDouble(prevResult) * 0.01;
                    calculationList.add(new Calculation(String.valueOf(percentaged)));
                    showCurrentCalc();

                    tvCurrentCalculation.setTextSize(50);
                    tvCurrentCalculation.setTextColor(getResources().getColor(R.color.black, null));
                    tvResult.setTextSize(35);
                    tvResult.setTextColor(getResources().getColor(R.color.less_black, null));
                    finalized = false;
                } else {
                    if (!tvCurrentCalculation.getText().equals("0")) {
                        calculationList.get(calculationList.size() - 1).onPercentPressed();
                        showCurrentCalc();
                    }
                }
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorPressed(((Button)v).getText().toString());
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorPressed(((Button)v).getText().toString());
            }
        });
        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorPressed(((Button)v).getText().toString());
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorPressed(((Button)v).getText().toString());
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvCurrentCalculation.setTextSize(35);
                tvCurrentCalculation.setTextColor(getResources().getColor(R.color.less_black, null));

                tvResult.setTextSize(50);
                tvResult.setTextColor(getResources().getColor(R.color.black, null));
                finalized = true;
            }
        });
    }

    void onNumberPressed(String text) {
        if(finalized) {
            calculationList.add(new Calculation(text));
            showCurrentCalc();

            tvCurrentCalculation.setTextSize(50);
            tvCurrentCalculation.setTextColor(getResources().getColor(R.color.black, null));
            tvResult.setTextSize(35);
            tvResult.setTextColor(getResources().getColor(R.color.less_black, null));
            finalized = false;
        } else {
            if (tvCurrentCalculation.getText().equals("0")) {
                calculationList.add(new Calculation(text));
                tvResult.setVisibility(View.VISIBLE);
            } else {
                calculationList.get(calculationList.size() - 1).addNumber(text);
            }
            showCurrentCalc();
        }
    }

    void onOperatorPressed(String text) {
        if(finalized) {
            String prevResult = tvResult.getText().toString();
            calculationList.add(new Calculation(prevResult.concat(text)));
            showCurrentCalc();

            tvCurrentCalculation.setTextSize(50);
            tvCurrentCalculation.setTextColor(getResources().getColor(R.color.black, null));
            tvResult.setTextSize(35);
            tvResult.setTextColor(getResources().getColor(R.color.less_black, null));
            finalized = false;
        } else {
            if (tvCurrentCalculation.getText().equals("0")) {
                calculationList.add(new Calculation(text));
                tvResult.setVisibility(View.VISIBLE);
            } else {
                calculationList.get(calculationList.size() - 1).addOperator(text);
            }
            showCurrentCalc();
        }
    }

    void showCurrentCalc() {
        tvCurrentCalculation.setText(calculationList.get(calculationList.size()-1).getCalculationStr());
        Double result = calculationList.get(calculationList.size()-1).getResult();
        if(result%1 == 0)
            tvResult.setText(String.valueOf(result));
        else {
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(8);
            tvResult.setText(df.format(result));
        }
    }
}