package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Add extends AppCompatActivity {

    Button s;
    EditText q1,o11,o12,o13,o14,c1o;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        s=findViewById(R.id.button);
        q1=findViewById(R.id.editText);
        o11=findViewById(R.id.editText1);
        o12=findViewById(R.id.editText2);
        o13=findViewById(R.id.editText3);
        o14=findViewById(R.id.editText4);
        c1o=findViewById(R.id.editText5);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q=q1.getText().toString()+"\n";
                String o1=o11.getText().toString()+"\n";
                String o2=o12.getText().toString()+"\n";
                String o3=o13.getText().toString()+"\n";
                String o4=o14.getText().toString()+"\n";
                String c=c1o.getText().toString()+"\n";

                if(!o1.equals("") && !o2.equals("") && !o3.equals("") && !o4.equals("") && !q.equals("") && !c.equals(""))
                {
                    FileOutputStream fos = null;
                    try {
                        fos = openFileOutput("Quiz", MODE_APPEND);
                        fos.write(q.getBytes());
                        fos.write(o1.getBytes());
                        fos.write(o2.getBytes());
                        fos.write(o3.getBytes());
                        fos.write(o4.getBytes());
                        fos.write(c.getBytes());
                    }
                    catch(Exception e){
                        e.printStackTrace();;
                    }
                    finally{
                        if(fos!=null)
                            try {
                                fos.close();
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        o11.getText().clear();
                        o12.getText().clear();
                        o13.getText().clear();
                        o14.getText().clear();
                        q1.getText().clear();
                        c1o.getText().clear();
                    }

                }
                else
                {
                    if(o1.equals(""))
                        o11.setText("Field cannot be Empty");
                    if(o2.equals(""))
                        o12.setText("Field cannot be Empty");
                    if(o3.equals(""))
                        o13.setText("Field cannot be Empty");
                    if(o4.equals(""))
                        o14.setText("Field cannot be Empty");
                    if(q.equals(""))
                        q1.setText("Field cannot be Empty");
                    if(c.equals(""))
                        c1o.setText("Field cannot be Empty");
                }
            }
        });
    }
}
