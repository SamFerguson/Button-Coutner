package howdyfellas.button_counter_ferguson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
Create an app that has three buttons, one for incrementing a counter, one for decrementing the counter,
and one for resetting the counter to 0. The counter must be displayed as a TextView and must retain its state when the
phone is rotated between portrait and landscape modes. There should be no values, such as strings, dimensions,
 etc. hardcoded in the .java files. They should be maintained and accessed from the appropriate resource files.
 */

public class MainActivity extends AppCompatActivity {

    private int counter;
    private TextView count;
    private Button increment;
    private Button decrement;
    private Button reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        increment = (Button) findViewById(R.id.increment);
        decrement = (Button) findViewById(R.id.decrement);
        reset = (Button) findViewById(R.id.reset);
        count = (TextView) findViewById(R.id.count);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                count.setText(getString(R.string.total)+ ": " + counter);
            }
        });
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                count.setText(getString(R.string.total)+": " + counter);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter= 0;
                count.setText(getString(R.string.total)+": " + counter);
            }
        });

    }

}
