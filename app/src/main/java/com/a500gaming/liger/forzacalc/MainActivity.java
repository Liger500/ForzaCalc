package com.a500gaming.liger.forzacalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Making text views to set text later
    TextView front_rollbar = (TextView)findViewById(R.id.front_rollbar_display);
    TextView rear_rollbar = (TextView)findViewById(R.id.rear_rollbar_display);
    TextView front_spring = (TextView)findViewById(R.id.front_spring_display);
    TextView rear_spring = (TextView)findViewById(R.id.rear_spring_display);
    TextView front_rebound = (TextView)findViewById(R.id.front_rebound_display);
    TextView rear_rebound = (TextView)findViewById(R.id.rear_rebound_diplay);
    //Declaring stuff
    String string1 = " ";
    String string2 = " ";
    Double softest_spring = 1.00 * R.id.softest_spring_input;
    Double hardest_spring = 1.00 * R.id.hardest_spring_input;
    Double a = 0.0;
    Double b = 1.0;
    Double c = 1.00 * R.id.front_percentage_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Makes sure c is in the format I want it in
        if (c >= 1) {
            c = c / 100;
        }
        //Declares more stuff... Might move it
        Double x = 0.0;
        Double x2 = 0.0;
        //Changes the rollbar text view
        rollbars(Double a, Double b, Double c, Double x, Double x2);
        convert(Double x, Double x2, String string1, String string2);
        front_rollbar.setText(string1);
        rear_rollbar.setText(string2);
        //Changes the spring text view
        springs(Double a, Double b, Double c, Double x, Double x2);
        convert(Double x, Double x2, String string1, String string2);
        front_spring.setText(string1);
        rear_spring.setText(string2);
        //Changes the rebound text view
        rebound(Double a, Double b, Double c, Double x, Double x2);
        convert(Double x, Double x2, String string1, String string2);
        front_rebound.setText(string1);
        rear_rebound.setText(string2);
    }
    //Does the math for the rollbar settigns
    public double rollbars(Double a, Double b, Double c, Double x, Double x2) {
        a = 40.00;
        y(Double a, Double b, Double c, Double x);
        return x;
        y2(Double a, Double b, Double c, Double x2);
        return x2;
    }
    //Does the math for the spring settings
    public double springs(Double a, Double b, Double c, Double x, Double x2) {
        a = toDouble(hardest_spring);
        b = toDouble(softest_spring);
        y(Double a, Double b, Double c, Double x);
        return x;
        y2(Double a, Double b, Double c, Double x2);
        return x2;
    }
    //Does the math for the rebound stiffness settings
    public double rebound(Double a, Double b, Double c, Double x, Double x2) {
        a = 12.00;
        y(Double a, Double b, Double c, Double x);
        return x;
        y2(Double a, Double b, Double c, Double x2);
        return x2;
    }
    //Math 1 of 2
    public double y(Double a, Double b, Double c, Double x) {
        x = ( a - b ) * c + 1;
        return x;
    }
    //Math 2 of 2
    public double y2(Double a, Double b, Double c, Double x2) {
        c = 1.00 - c;
        x2 = ( a - b ) * c + 1;
        return x2;
    }
    //Trying to convert the return of Maths to strings for setting
    public String convert(Double x, Double x2, String string1, String string2) {
        string1 = Double.toString(x);
        return string1;
        string2 = Double.toString(x2);
        return string2;
    }

}