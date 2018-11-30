package com.xzzb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed_name,ed_nation,ed_id,ed_address;
    TextView tv_birth;
    Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.idcard_system);
        InitView();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed_name.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this,"姓名不能为空",Toast.LENGTH_LONG).show();
                }else if(ed_nation.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this,"民族不能为空",Toast.LENGTH_LONG).show();
                }else if(ed_address.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this,"地址不能为空",Toast.LENGTH_LONG).show();
                }else if(ed_id.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this,"身份证号不能为空",Toast.LENGTH_LONG).show();
                }else if(ed_id.getText().toString().length()!=18){
                    Toast.makeText(MainActivity.this,"身份证号必须18位",Toast.LENGTH_LONG).show();
                }else{
                    String id = ed_id.getText().toString().trim();
                    String year = id.substring(6,10);
                    String month = id.substring(10,12);
                    String day = id.substring(12,14);
                    tv_birth.setText(year+"年"+month+"月"+day+"日");
                    Toast.makeText(MainActivity.this,ed_name.getText().toString().trim()+"保存成功",Toast.LENGTH_LONG).show();








                }


            }
        });











    }
    public void InitView(){
        ed_name = (EditText)findViewById(R.id.ed_name);
        ed_nation = (EditText)findViewById(R.id.ed_nation);
        ed_id = (EditText)findViewById(R.id.ed_id);
        ed_address = (EditText)findViewById(R.id.ed_address);
        tv_birth = (TextView)findViewById(R.id.tv_birth);
        btn_save = (Button)findViewById(R.id.btn_save);

    }

}
