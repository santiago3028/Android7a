package com.example.carritodecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name, price;
    ListView list;
    Button btn1, add2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.nameProduct);
        btn1=findViewById(R.id.buttadd);
        price=findViewById(R.id.price);
        list =findViewById(R.id.list);
        add2=findViewById(R.id.add);

        final  ArrayList<Products> listNam= new ArrayList<Products>();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameProd=name.getText().toString().trim();
                String precious=price.getText().toString().trim();
                listNam.add(new Products(nameProd,precious));

                ArrayAdapter<Products> adapted = new ArrayAdapter<Products>
                        (getApplicationContext(),
                                android.R.layout.simple_list_item_1,listNam);
                list.setAdapter(adapted);
                name.setText("");
                price.setText("");
            }
        });
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listNam.clear();
                list.setAdapter(null);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
