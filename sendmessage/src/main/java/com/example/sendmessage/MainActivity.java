package com.example.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed_linkman,ed_content;
    Button btn_choose,btn_enter;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message);
        InitView();
        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,linkman.class);
               startActivityForResult(intent,1);

            }
        });
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed_linkman.getText().toString().trim().equals(""))
                {
                    Toast.makeText(MainActivity.this,"请输入短信内容",Toast.LENGTH_LONG).show();
                }else if (ed_content.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"请选择联系人",Toast.LENGTH_LONG).show();
                }else{

                    Intent intent = new Intent(MainActivity.this,success.class);
                    intent.putExtra("message",ed_content.getText().toString().trim());
                    startActivity(intent);
                }


            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data!=null){
            if(requestCode==1){
                if(resultCode==1)
                    name = data.getStringExtra("name");
                    ed_linkman.setText(name);

            }
        }
    }

    public void InitView(){
        ed_linkman = (EditText)findViewById(R.id.ed_linkman);
        ed_content = (EditText)findViewById(R.id.ed_content);
        btn_choose = (Button)findViewById(R.id.btn_choose);
        btn_enter = (Button)findViewById(R.id.btn_enter);



    }

}
