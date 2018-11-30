package com.example.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class linkman extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lv;
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linkman);
        lv = (ListView)findViewById(R.id.lv);
        lv.setAdapter(new MyBaseAdapter());
        lv.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = lv.getItemAtPosition(position)+"";
        intent.putExtra("name",name);

        setResult(1,intent);
        finish();

    }

    class MyBaseAdapter extends BaseAdapter{
        String[] names = {"张三","李四","王五"};
        String[] numbers = {"123","456","789"};
        Intent intent = new Intent();
        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                holder =new ViewHolder();
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.linkman_items,parent,false);
                holder.tv_name = (TextView)convertView.findViewById(R.id.name);
                holder.tv_number = (TextView)convertView.findViewById(R.id.number);
                holder.tv_name.setText(names[position]);
                holder.tv_number.setText(numbers[position]);










                }else {
                holder = (ViewHolder)convertView.getTag();
            }



            return convertView;
        }
        class ViewHolder{
            TextView tv_name;
            TextView tv_number;



        }
    }
}
