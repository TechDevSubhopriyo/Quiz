package com.example.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    String text;
    RadioGroup r;
    int ii=0;
    RadioButton a,a1,b1,c1,d1;
    TextView tv;
    Button b,re,ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.question);
        a1=findViewById(R.id.radioButton);
        b1=findViewById(R.id.radioButton2);
        c1=findViewById(R.id.radioButton3);
        d1=findViewById(R.id.radioButton4);
        r=findViewById(R.id.radioGroup);
        b=findViewById(R.id.submit);
        ad=findViewById(R.id.button2);

        FileInputStream fis=null;



        ii=1;
        try {
            fis=openFileInput("Quiz");
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);

            if((text=br.readLine())!=null) {

                tv.setText(text);
                text=br.readLine();
                a1.setText(text);
                text=br.readLine();
                b1.setText(text);
                text=br.readLine();
                c1.setText(text);
                text=br.readLine();
                d1.setText(text);
                text=br.readLine();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }







        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileInputStream fis=null;
                int selectedId=r.getCheckedRadioButtonId();
                a=findViewById(selectedId);
                try {
                    fis=openFileInput("Quiz");
                    InputStreamReader isr=new InputStreamReader(fis);
                    BufferedReader br=new BufferedReader(isr);
                    String text1;
                    int k=1;
                    for( k=1;k<=ii*6;k++) {
                        text1 = br.readLine();

                    }

                            if (a.getText().toString().equals(text)) {
                                tost();
                                r.clearCheck();
                                ii++;
                                if ((text = br.readLine()) != null) {

                                    tv.setText(text);
                                    text = br.readLine();
                                    a1.setText(text);
                                    text = br.readLine();
                                    b1.setText(text);
                                    text = br.readLine();
                                    c1.setText(text);
                                    text = br.readLine();
                                    d1.setText(text);
                                    text = br.readLine();

                                }
                                else{
                                    tv.setText("You Won");
                                    tost();
                                    b.setVisibility(View.INVISIBLE);
                                }

                            } else if (!a.getText().toString().equals(text)) {
                                tost2();
                            }

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        re=findViewById(R.id.r);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setVisibility(View.VISIBLE);
                r.clearCheck();

                FileInputStream fis=null;
                ii=1;
                try {
                    fis=openFileInput("Quiz");
                    InputStreamReader isr=new InputStreamReader(fis);
                    BufferedReader br=new BufferedReader(isr);

                    if((text=br.readLine())!=null) {

                        tv.setText(text);
                        text=br.readLine();
                        a1.setText(text);
                        text=br.readLine();
                        b1.setText(text);
                        text=br.readLine();
                        c1.setText(text);
                        text=br.readLine();
                        d1.setText(text);
                        text=br.readLine();

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Add.class);
                startActivity(i);
            }
        });
    }

    public void tost()
    {
        Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();


    }
    public void tost2()
    {
        Toast.makeText(this,"Wrong", Toast.LENGTH_SHORT).show();
        b.setVisibility(View.INVISIBLE);
        tv.setText("You Lost Badly");
    }




    @Override
    public void onBackPressed() {
        AlertDialog.Builder alt=new AlertDialog.Builder(this);
        alt.setTitle("Attention!")
                .setCancelable(false)
                .setMessage("Are you sure you want to abandon the game?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog a=alt.create();
        a.show();
    }

}
