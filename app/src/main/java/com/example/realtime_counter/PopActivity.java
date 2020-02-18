package com.example.realtime_counter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PopActivity extends MainActivity {
    Button btn5;
    EditText editText;
    String tex = null;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        btn5 = (Button) findViewById(R.id.btn5);
        editText = (EditText) findViewById(R.id.editText);
        txt1 = (TextView) findViewById(R.id.txt1);

        tex = editText.getText().toString();


        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changetitle();



            }

        });
    }

  public void changetitle() {
        title.setText(tex);
        txt1.setText(tex);
  }
//
//        }
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//
//        getWindow().setLayout((int)(width*.6),(int)(height*.5));
//
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.gravity = Gravity.CENTER;
//        params.x = 0;
//        params.y = -20;
//
//        getWindow().setAttributes(params);
  }

