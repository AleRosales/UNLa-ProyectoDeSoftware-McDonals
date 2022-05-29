package unla.ProyectoSoftware.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import unla.ProyectoSoftware.R;
import unla.ProyectoSoftware.adapters.ItemCarritoAdapter;
import unla.ProyectoSoftware.modelo.ItemCarrito;

public class CarritoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        ListView lv_carrito=findViewById(R.id.lv_carrito);
        ArrayList carrito=getIntent().getParcelableArrayListExtra("carrito");

        ItemCarritoAdapter adapter=new ItemCarritoAdapter(this,carrito);
        lv_carrito.setAdapter(adapter);

        float total=0;
        for(Object o:carrito){
            ItemCarrito item=((ItemCarrito)o);
            total+=(item.getCantidad()*item.getProducto().getPrecio());
        }

        TextView tv_subTotal=findViewById(R.id.tv_subTotal);
        TextView tv_total=findViewById(R.id.tv_total);
        tv_subTotal.setText("$"+total);
        tv_total.setText("$"+total);


    }
}