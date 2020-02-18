package com.example.realtime_counter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public  class MainActivity extends Activity  {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    TextView intro;
    TextView count;
    TextView title;

    public static final String SHARED_PREFS = "SharedPrefs";
    public static final String  COUNT= "0";
    private String count1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        intro = (TextView) findViewById(R.id.intro);
        count = (TextView) findViewById(R.id.count);
        title = (TextView) findViewById(R.id.title);
        intro.setText("COUNTER");

        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addcount();
            }
        });
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                subcount();
            }
        });
        btn3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                resetcount();
            }
        });
        btn4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata();
            }
        });
        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
//                Intent i = new Intent(MainActivity.this,PopActivity.class);
//                startActivity(i);
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("New Title");

                final EditText newtitle = new EditText(MainActivity.this);
                newtitle.setInputType(InputType.TYPE_CLASS_TEXT);
                mydialog.setView(newtitle);
                mydialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intro.setText(newtitle.getText().toString());
                        Toast.makeText(MainActivity.this,"title set", Toast.LENGTH_SHORT).show();
                    }
                });
                mydialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                mydialog.show();


            }
        });
        title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,PopActivity.class);
//                startActivity(i);
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("New Title");

                final EditText newtitle = new EditText(MainActivity.this);
                newtitle.setInputType(InputType.TYPE_CLASS_TEXT);
                mydialog.setView(newtitle);
                mydialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        title.setText(newtitle.getText().toString());
                        Toast.makeText(MainActivity.this,"title set", Toast.LENGTH_SHORT).show();
                    }
                });
                mydialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                    }
                });
                mydialog.show();
            }
        });
        loaddata();
        updateviews();



    }
    public void savedata(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(COUNT,count.getText().toString());
        editor.apply();
        Toast.makeText(this,"data saved",Toast.LENGTH_SHORT).show();
    }

    public void addcount(){
        String counter = count.getText().toString();
        int currentcount= Integer.parseInt(counter);
        currentcount=currentcount+1;
        counter = Integer.toString(currentcount);
        count.setText(counter);

    }
    public void subcount(){
        String counter = count.getText().toString();
        int currentcount= Integer.parseInt(counter);
        currentcount=currentcount-1;
        counter = Integer.toString(currentcount);
        count.setText(counter);

    }
    public void resetcount(){
        String counter = count.getText().toString();
        int currentcount= Integer.parseInt(counter);
        currentcount=0;
        counter = Integer.toString(currentcount);
        count.setText(counter);

    }

    public void loaddata(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        count1 = sharedPreferences.getString(COUNT,"0");

    }

    public void updateviews(){
        count.setText(count1);


    }

    public void onClick(View view) {
        switch (view.getId())
        {

        }
    }
}

