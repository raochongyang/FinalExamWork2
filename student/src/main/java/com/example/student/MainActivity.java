package com.example.student;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    StudentSqliteOpenHelper db;
    private SQLiteDatabase sd;
    ListView lv;
    List<Map<String,Object>> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        lv = (ListView)findViewById(R.id.student_lv);
        add_data();
        select();
        create_adapter();
    }
    private void add_data(){
        db = new StudentSqliteOpenHelper(this,"student.db",null,1);
        sd = db.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("sname","iu");
        values.put("sage","14");
        sd.insert("stu",null,values);
        values.clear();
        values.put("sname","gg");
        values.put("sage","19");
        sd.insert("stu",null,values);
        values.clear();
    }
    private void select(){
        String SELECT_SQL = "select * from stu";
        Cursor cursor = sd.rawQuery(SELECT_SQL,null);
        while(cursor.moveToNext()){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("sno",cursor.getInt(0));
            map.put("sname",cursor.getString(1));
            map.put("sage",cursor.getInt(2));
            data.add(map);



        }}

    private void create_adapter(){
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        lv.setAdapter(mAdapter);




    }
    class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.items,parent,false);
                holder = new ViewHolder();
                holder.tv_number = (TextView)convertView.findViewById(R.id.stu_number);
                holder.tv_name = (TextView)convertView.findViewById(R.id.stu_name);
                holder.tv_age = (TextView)convertView.findViewById(R.id.stu_age);
            }else {

                holder = (ViewHolder)convertView.getTag();

            }
            holder.tv_number.setText(data.get(position).get("sno").toString());

            holder.tv_name.setText(data.get(position).get("sname").toString());
            holder.tv_age.setText(data.get(position).get("sage").toString());








            return convertView;

        }

        class ViewHolder{
            TextView tv_number;
            TextView tv_name;
            TextView tv_age;


        }
    }
}
