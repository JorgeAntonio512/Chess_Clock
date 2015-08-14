package com.georgepazdral.chessclock;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChessClock extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess_clock);

        Button button = (Button) findViewById(R.id.btn_start);
        Button button2 = (Button) findViewById(R.id.button2);

        final TextView mTextField = (TextView) findViewById(R.id.textView);
        final EditText mEditText = (EditText) findViewById(R.id.editText);
        final TextView mTextField2 = (TextView) findViewById(R.id.textView2);
        final EditText mEditText2 = (EditText) findViewById(R.id.editText2);



        /*NumberPicker mNumberPicker = (NumberPicker) findViewById(R.id.numberPicker);

        String[] myStringArray = new String[]{"1","2","3","4","5","6","60"};
        mNumberPicker.setMinValue(0);
        mNumberPicker.setMaxValue(myStringArray.length - 1);
        mNumberPicker.setDisplayedValues(myStringArray);


        final long num = Long.parseLong(myStringArray[mNumberPicker.getValue()]);*/






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long num = Long.parseLong(mEditText.getText().toString());
                new CountDownTimer((num * 60000), 1000) {

                    public void onTick(long millisUntilFinished) {
                        mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        mTextField.setText("done!");
                    }
                }.start();


                Context context = getApplicationContext();
                CharSequence text = "the number selected is " + num;
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long num = Long.parseLong(mEditText2.getText().toString());
                new CountDownTimer((num * 60000), 1000) {

                    public void onTick(long millisUntilFinished) {
                        mTextField2.setText("seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        mTextField2.setText("done!");
                    }
                }.start();


                Context context = getApplicationContext();
                CharSequence text = "the number selected is " + num;
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chess_clock, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}