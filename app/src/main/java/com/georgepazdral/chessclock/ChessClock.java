package com.georgepazdral.chessclock;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
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

        final Button button = (Button) findViewById(R.id.btn_start);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button player1finish = (Button) findViewById(R.id.player1finish);
        final Button player2finish = (Button) findViewById(R.id.player2finish);

        final TextView mTextField = (TextView) findViewById(R.id.textView);
        final EditText mEditText = (EditText) findViewById(R.id.editText);
        final TextView mTextField2 = (TextView) findViewById(R.id.textView2);
        final EditText mEditText2 = (EditText) findViewById(R.id.editText2);
        final EditText mPlayer1setDelay = (EditText) findViewById(R.id.player1setDelay);
        final TextView mPlayer1delay = (TextView) findViewById(R.id.player1delay);
        final EditText mPlayer2setDelay = (EditText) findViewById(R.id.player2setDelay);
        final TextView mPlayer2delay = (TextView) findViewById(R.id.player2delay);



        /*NumberPicker mNumberPicker = (NumberPicker) findViewById(R.id.numberPicker);

        String[] myStringArray = new String[]{"1","2","3","4","5","6","60"};
        mNumberPicker.setMinValue(0);
        mNumberPicker.setMaxValue(myStringArray.length - 1);
        mNumberPicker.setDisplayedValues(myStringArray);


        final long num = Long.parseLong(myStringArray[mNumberPicker.getValue()]);*/






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long nume = Long.parseLong(mPlayer1setDelay.getText().toString());
                new CountDownTimer((nume * 1000), 1000) {

                    public void onTick(long millisUntilFinished) {
                        mPlayer1delay.setText("Delay seconds remaining: " + millisUntilFinished / 1000);
                        player1finish.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                cancel();
                            }
                        });
                    }

                    public void onFinish() {
                        mPlayer1delay.setText("Delay time up!");
                        final long num = Long.parseLong(mEditText.getText().toString());
                        new CountDownTimer((num * 60000), 1000) {

                            public void onTick(long millisUntilFinished) {
                                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                                player1finish.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        cancel();
                                    }
                                });
                            }

                            public void onFinish() {
                                mTextField.setText("done!");
                                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                                r.play();
                            }
                        }.start();


                        Context context = getApplicationContext();
                        CharSequence text = "the number selected is " + num;
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }.start();





            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long numer = Long.parseLong(mPlayer2setDelay.getText().toString());
                new CountDownTimer((numer * 1000), 1000) {

                    public void onTick(long millisUntilFinished) {
                        mPlayer2delay.setText("Delay seconds remaining: " + millisUntilFinished / 1000);
                        player2finish.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                cancel();
                            }
                        });
                    }

                    public void onFinish() {
                        mPlayer2delay.setText("Delay time up!");
                        final long num = Long.parseLong(mEditText2.getText().toString());
                        new CountDownTimer((num * 60000), 1000) {

                            public void onTick(long millisUntilFinished) {
                                mTextField2.setText("seconds remaining: " + millisUntilFinished / 1000);
                                player2finish.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        cancel();
                                    }
                                });
                            }

                            public void onFinish() {
                                mTextField2.setText("done!");
                                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                                r.play();
                            }
                        }.start();
                    }
                }.start();



                Context context = getApplicationContext();
                CharSequence text = "the number selected is " + numer;
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