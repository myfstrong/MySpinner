package com.myfstrong.myspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);

        //步骤1：
        //方式一：声明适配器ArrayAdapter，通过List向适配器传送数据
/*        List<String> list = new ArrayList<String>();
        list.add("11111");
        list.add("22222");
        list.add("33333");
        list.add("44444");
        list.add("55555");

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,list);

        spinner.setAdapter(arrayAdapter);*/

        //方式二：声明适配器ArrayAdapter，通过String的ResourceId文件来传送数据
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.test_array,android.R.layout.simple_spinner_item);

        spinner.setAdapter(arrayAdapter);

        //步骤2：
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,id + ":" + position,Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
