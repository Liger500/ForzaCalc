package com.a500gaming.liger.forzacalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView front_rollbar = (TextView)findViewById(R.id.front_rollbar_display);
    TextView rear_rollbar = (TextView)findViewById(R.id.rear_rollbar_display);
    TextView softest_spring = (TextView)findViewById(R.id.softest_spring_input);
    TextView hardest_spring = (TextView)findViewById(R.id.hardest_spring_input);
    TextView front_spring = (TextView)findViewById(R.id.front_spring_display);
    TextView rear_spring = (TextView)findViewById(R.id.rear_spring_display);
    TextView front_rebound = (TextView)findViewById(R.id.front_rebound_display);
    TextView rear_rebound = (TextView)findViewById(R.id.rear_rebound_diplay);
    String string1 = " ";
    String string2 = " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Double a = 0.0;
        Double b = 1.0;
        Double c = toDouble(R.id.front_percentage_input);
        If (c >= 1) {
            c = c / 100;
        }
        Double x = 0.0;
        Double x2 = 0.0;
        Double z = 0.0;
        rollbars(Double a, Double b, Double c, Double x, Double x2);
        convert(Double x, Double x2, String string1, String string2);
        front_rollbar.setText(string1);
        rear_rollbar.setText(string2);
        springs(Double a, Double b, Double c, Double x, Double x2);
        convert(Double x, Double x2, String string1, String string2);
        front_spring.setText(string1);
        rear_spring.setText(string2);
        rebound(Double a, Double b, Double c, Double x, Double x2);
        convert(Double x, Double x2, String string1, String string2);
        front_rebound.setText(string1);
        rear_rebound.setText(string2);
    }

    public double rollbars(Double a, Double b, Double c, Double x, Double x2) {
        a = 40.00;
        y(Double a, Double b, Double c, Double x);
        return x;
        y2(Double a, Double b, Double c, Double x2);
        return x2;
    }

    public double springs(Double a, Double b, Double c, Double x, Double x2) {
        a = toDouble(hardest_spring);
        b = toDouble(softest_spring);
        y(Double a, Double b, Double c, Double x);
        return x;
        y2(Double a, Double b, Double c, Double x2);
        return x2;
    }

    public double rebound(Double a, Double b, Double c, Double x, Double x2) {
        a = 12.00;
        y(Double a, Double b, Double c, Double x);
        return x;
        y2(Double a, Double b, Double c, Double x2);
        return x2;
    }

    public double y(Double a, Double b, Double c, Double x) {
        x = ( a - b ) * c + 1;
        return x;
    }

    public double y2(Double a, Double b, Double c, Double x2) {
        c = 1.00 - c;
        x2 = ( a - b ) * c + 1;
        return x2;
    }

    public string convert(Double x, Double x2, String string, String string2) {
        string1 = toString(x);
        string2 = toString(x2);
        return string1;
        return string2;
    }


}
