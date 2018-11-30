package com.example.tel;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed_number;
    Button btn_tel,btn_msg;
    String number = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tel);
        InitView();

        btn_tel.setOnClickListener(this);
        btn_msg.setOnClickListener(this);
    }




    public void InitView(){
        ed_number = (EditText)findViewById(R.id.ed_number);
        btn_tel = (Button)findViewById(R.id.btn_tel);
        btn_msg = (Button)findViewById(R.id.btn_msg);
    }

    @Override
    public void onClick(View v) {
        number = ed_number.getText().toString().trim();
        switch (v.getId()){
            case R.id.btn_tel:
                if(number.length()>11){
                    Toast.makeText(MainActivity.this,"请输入正确的电话号码",Toast.LENGTH_LONG).show();
                }else{
                    diallPhone(number);
                }
                break;
            case R.id.btn_msg:
                if(number.length()>11){
                        Toast.makeText(MainActivity.this,"请输入正确的电话号码",Toast.LENGTH_LONG).show();
                    }else{
                        sendmessage(number);
                    }



                break;
            default:
                break;

        }
    }
    public void diallPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }
    public void sendmessage(String phoneNum){
        Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:"+phoneNum));
        intent.putExtra("sms_body","sdsadsa");
        startActivity(intent);



    }

}
