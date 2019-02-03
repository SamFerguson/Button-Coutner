package howdyfellas.button_counter_ferguson;

import android.media.AudioAttributes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.SoundPool;

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
    private String hooey = "key";
    private SoundPool sound;
    private int kick, hat, snare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if(savedInstanceState != null){
                savedInstanceState.getInt(hooey);
            }
            setContentView(R.layout.activity_main);

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            sound = new SoundPool.Builder()
                    .setMaxStreams(3)
                    .setAudioAttributes(audioAttributes)
                    .build();
            kick = sound.load(this, R.raw.kick, 1);
            hat = sound.load(this, R.raw.hat, 1);
            snare = sound.load(this, R.raw.snare, 1);

            increment = (Button) findViewById(R.id.increment);
            decrement = (Button) findViewById(R.id.decrement);
            reset = (Button) findViewById(R.id.reset);
            count = (TextView) findViewById(R.id.count);


            increment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counter++;
                    sound.play(kick, 1,1,0,0,1);
                    count.setText(getString(R.string.total)+ ": " + counter);
                }
            });
            decrement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counter--;
                    sound.play(hat, 1,1,0,0,1);
                    count.setText(getString(R.string.total)+": " + counter);
                }
            });
            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sound.play(snare, 1, 1, 1, 0,1);
                    counter= 0;
                    count.setText(getString(R.string.total)+": " + counter);
                }
            });
        }

    /*
    annoyingly enough whenever you tilt the screen it clears all of my stuff
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(hooey, counter);
    }

}
