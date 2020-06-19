package com.example.carrito;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuInflater;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    EditText name, price;
    Button btn, add;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=findViewById(R.id.lv1);
        name=findViewById(R.id.name);
        price=findViewById(R.id.precio);
        btn=findViewById(R.id.add);
        add=findViewById(R.id.buy);

        final  ArrayList<Productos> listaNombres= new ArrayList<Productos>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameProd=name.getText().toString().trim();
                String precio=price.getText().toString().trim();
                listaNombres.add(new Productos(nameProd,precio));

                ArrayAdapter<Productos> adaptador = new ArrayAdapter<Productos>(getApplicationContext(),android.R.layout.simple_list_item_1,listaNombres);
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
