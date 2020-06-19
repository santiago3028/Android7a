package com.e.carritocompras;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    EditText name, price;
    Button btn, add;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=findViewById(R.id.list);
        name=findViewById(R.id.nameProduct);
        price=findViewById(R.id.price);
        btn=findViewById(R.id.btn);
        add=findViewById(R.id.add);

        final  ArrayList<Products> listaNombres= new ArrayList<Products>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameProd=name.getText().toString().trim();
                String precio=price.getText().toString().trim();
                listaNombres.add(new Products(nameProd,precio));

                ArrayAdapter<Products> adaptador = new ArrayAdapter<Products>(getApplicationContext(),android.R.layout.simple_list_item_1,listaNombres);
                lista.setAdapter(adaptador);
                name.setText("");
                price.setText("");


            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaNombres.clear();
                lista.setAdapter(null);
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
