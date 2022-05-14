package unla.ProyectoSoftware.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import unla.ProyectoSoftware.R;
import unla.ProyectoSoftware.adapters.ItemProductoPromociones;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nombres[]={"nombre1","nombre2"};
        String precios[]={"50$","25$"};
        int imagenes[]={R.mipmap.ic_launcher,R.mipmap.ic_launcher};
        ListView lv_ProductosPromociones= (ListView) findViewById(R.id.lv_ProductosPromociones);

        Adapter adapter;
        adapter = new ItemProductoPromociones(this,nombres,precios,imagenes);
        lv_ProductosPromociones.setAdapter((ListAdapter) adapter);
    }
}