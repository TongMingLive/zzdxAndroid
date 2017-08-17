package com.example.tong.zzdxandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by tong- on 2017/5/2.
 */

public class Jisuanqi extends AppCompatActivity {
    // 定义九个数字
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;

    private Button dot;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button clear;

    private Button equal;
    private EditText led;

    String num1 = "";
    String num2 = "";
    double num3 = 0;
    String result = "";
    String sign = "+";
    int mark = 0;
    boolean flag = true;
    boolean dotmark = true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jisuanqi);

        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);

        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        clear = (Button) findViewById(R.id.clear);
        led = (EditText) findViewById(R.id.led);
        equal = (Button) findViewById(R.id.equal);
        dot = (Button) findViewById(R.id.dot);

        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mark == 0) {
                    num1 = num1 + "0";
                    led.setText(num1);
                } else if (mark == 1) {
                    num2 = num2 + "0";
                    led.setText(num1 + sign + num2);
                } else {
                    num1 = String.valueOf(num3);
                    num2 = num2 + "0";
                    led.setText(num1 + sign + num2);
                }
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mark == 0) {
                    num1 = num1 + "1";
                    led.setText(num1);
                } else if (mark == 1) {
                    num2 = num2 + "1";
                    led.setText(num1 + sign + num2);
                } else {
                    num1 = String.valueOf(num3);
                    num2 = num2 + "1";
                    led.setText(num1 + sign + num2);
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mark == 0) {
                    num1 = num1 + "2";
                    led.setText(num1);
                } else if (mark == 1) {
                    num2 = num2 + "2";
                    led.setText(num1 + sign + num2);
                } else {
                    num1 = String.valueOf(num3);
                    num2 = num2 + "2";
                    led.setText(num1 + sign + num2);
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mark == 0) {
                    num1 = num1 + "3";
                    led.setText(num1);
                } else if (mark == 1) {
                    num2 = num2 + "3";
                    led.setText(num1 + sign + num2);
                } else {
                    num1 = String.valueOf(num3);
                    num2 = num2 + "3";
                    led.setText(num1 + sign + num2);
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mark == 0) {
                    num1 = num1 + "4";
                    led.setText(num1);
                } else if (mark == 1) {
                    num2 = num2 + "4";
                    led.setText(num1 + sign + num2);
                } else {
                    num1 = String.valueOf(num3);
                    num2 = num2 + "4";
                    led.setText(num1 + sign + num2);
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mark == 0) {
                    num1 = num1 + "5";
                    led.setText(num1);
                } else if (mark == 1) {
                    num2 = num2 + "5";
                    led.setText(num1 + sign + num2);
                } else {
                    num1 = String.valueOf(num3);
                    num2 = num2 + "5";
                    led.setText(num1 + sign + num2);
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mark == 0) {
                    num1 = num1 + "6";
                    led.setText(num1);
                } else if (mark == 1) {
                    num2 = num2 + "6";
                    led.setText(num1 + sign + num2);
                } else {
                    num1 = String.valueOf(num3);
                    num2 = num2 + "6";
                    led.setText(num1 + sign + num2);
                }
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mark == 0) {
                    num1 = num1 + "7";
                    led.setText(num1);
                } else if (mark == 1) {
                    num2 = num2 + "7";
                    led.setText(num1 + sign + num2);
                } else {
                    num1 = String.valueOf(num3);
                    num2 = num2 + "7";
                    led.setText(num1 + sign + num2);
                }
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mark == 0) {
                    num1 = num1 + "8";
                    led.setText(num1);
                } else if (mark == 1) {
                    num2 = num2 + "8";
                    led.setText(num1 + sign + num2);
                } else {
                    num1 = String.valueOf(num3);
                    num2 = num2 + "8";
                    led.setText(num1 + sign + num2);
                }
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mark == 0) {
                    num1 = num1 + "9";
                    led.setText(num1);
                } else if (mark == 1) {
                    num2 = num2 + "9";
                    led.setText(num1 + sign + num2);
                } else {
                    num1 = String.valueOf(num3);
                    num2 = num2 + "9";
                    led.setText(num1 + sign + num2);
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (flag) {
                    sign = "+";
                    mark++;
                    flag = false;
                    dotmark = true;
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (flag) {
                    sign = "-";
                    mark++;
                    flag = false;
                    dotmark = true;
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (flag) {
                    sign = "*";
                    mark++;
                    flag = false;
                    dotmark = true;
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (flag) {
                    sign = "÷";
                    mark++;
                    flag = false;
                    dotmark = true;
                }
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (dotmark) {
                    if (mark == 0) {
                        num1 = num1 + ".";
                        led.setText(num1);
                    } else if (mark == 1) {
                        num2 = num2 + ".";
                        led.setText(num1 + sign + num2);
                    } else {
                        num1 = String.valueOf(num3);
                        num2 = num2 + ".";
                        led.setText(num1 + sign + num2);
                    }
                    dotmark = false;
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() { // 等于时发生的运算
            public void onClick(View v) {
                flag = true;
                dotmark = true;
                if (sign.equals("+")) {
                    double x = Double.parseDouble(num1);
                    double y = Double.parseDouble(num2);
                    num3 = x + y;
                    result = String.valueOf(num3);
                    led.setText(num1 + sign + num2 + "=" + result);
                    num2 = "";
                } else if (sign.equals("-")) {
                    double x = Double.parseDouble(num1);
                    double y = Double.parseDouble(num2);
                    num3 = x - y;
                    result = String.valueOf(num3);
                    led.setText(num1 + sign + num2 + "=" + result);
                    num2 = "";
                } else if (sign.equals("*")) {
                    double x = Double.parseDouble(num1);
                    double y = Double.parseDouble(num2);
                    num3 = x * y;
                    result = String.valueOf(num3);
                    led.setText(num1 + sign + num2 + "=" + result);
                    num2 = "";
                } else if (sign.equals("÷")) {
                    double x = Double.parseDouble(num1);
                    double y = Double.parseDouble(num2);
                    num3 = x / y;
                    result = String.valueOf(num3);
                    led.setText(num1 + sign + num2 + "=" + result);
                    num2 = "";
                } else if (sign.equals("^")) {
                    double x = Double.parseDouble(num1);
                    double y = Double.parseDouble(num2);
                    num3 = Math.pow(x, y);
                    result = String.valueOf(num3);
                    led.setText(num1 + sign + num2 + "=" + result);
                    num2 = "";
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = "";
                num2 = "";
                num3 = 0;
                mark = 0;
                sign = "";
                led.setText("0");
                flag = true;
                dotmark = true;
            }
        });

    }
}
