package unla.ProyectoSoftware.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import unla.ProyectoSoftware.R;
import unla.ProyectoSoftware.adapters.ItemProductoPromociones;
import unla.ProyectoSoftware.modelo.ItemCarrito;
import unla.ProyectoSoftware.modelo.Producto;

public class MainActivity extends AppCompatActivity {

    ArrayList<ItemCarrito> carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carrito=new ArrayList<>();

        List<Producto> productoList=new ArrayList<>();
        for(int i=1;i<10;i++) {
            Producto p = new Producto();
            p.setId(i);
            p.setNombre("Producto "+i);
            p.setDetalle("Detalle del producto numero "+i);
            p.setPrecio(100*i);
            productoList.add(p);
        }



        ListView lv_ProductosPromociones= (ListView) findViewById(R.id.lv_ProductosPromociones);

        Adapter adapter;
        adapter = new ItemProductoPromociones(this,productoList);
        lv_ProductosPromociones.setAdapter((ListAdapter) adapter);

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // There are no request codes
                            Intent data = result.getData();
                            if(data.getSerializableExtra("itemCarrito")!=null) {
                                ItemCarrito itemCarrito = (ItemCarrito) data.getSerializableExtra("itemCarrito");
                                boolean encontrado=false;
                                for(int i=0;i<carrito.size();i++){
                                    if(carrito.get(i).getProducto().getId()==itemCarrito.getProducto().getId()){
                                        encontrado=true;
                                        itemCarrito.setCantidad(itemCarrito.getCantidad()+carrito.get(i).getCantidad());
                                        carrito.set(i,itemCarrito);
                                    }
                                }
                                if(!encontrado) {
                                    carrito.add(itemCarrito);
                                }
                            }
                        }
                    }
                });
        lv_ProductosPromociones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Producto p= (Producto) adapter.getItem(i);
                Intent intent = new Intent(getApplicationContext(), DetalleProductoActivity.class);
                intent.putExtra("producto",p);
                someActivityResultLauncher.launch(intent);
            }
        });

        Button btn_verCarrito=findViewById(R.id.btn_ver_carrito);
        btn_verCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CarritoActivity.class);
                intent.putExtra("carrito",carrito);
                someActivityResultLauncher.launch(intent);
            }
        });
    }
}