package unla.ProyectoSoftware.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import unla.ProyectoSoftware.R;
import unla.ProyectoSoftware.modelo.ItemCarrito;
import unla.ProyectoSoftware.modelo.Producto;

public class DetalleProductoActivity extends AppCompatActivity {

    Producto p;
    int cantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        p= (Producto) getIntent().getSerializableExtra("producto");
        cantidad=1;
        if(p!=null) {
            TextView tv_nombre = findViewById(R.id.tv_nombre_detalle_prod);
            TextView tv_precio = findViewById(R.id.tv_precio_detalle_prod);
            TextView tv_detalle_prod = findViewById(R.id.tv_detalle_prod);
            tv_nombre.setText(p.getNombre());
            tv_precio.setText("$"+p.getPrecio());
            tv_detalle_prod.setText(p.getDetalle());
        }
        TextView tv_cantidad=findViewById(R.id.tv_cantidadProd);
        tv_cantidad.setText(String.valueOf(cantidad));

        Button btn_aceptar=(Button) findViewById(R.id.btn_aceptar_detalle_prod);
        ImageButton btn_sumar=(ImageButton) findViewById(R.id.btn_sumarProductos);
        ImageButton btn_restar=(ImageButton) findViewById(R.id.btn_restarProductos);
        btn_sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad++;
                tv_cantidad.setText(String.valueOf(cantidad));
            }
        });
        btn_restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cantidad>1) {
                    cantidad--;
                    tv_cantidad.setText(String.valueOf(cantidad));
                }
            }
        });

        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemCarrito item=new ItemCarrito();
                item.setProducto(p);
                item.setCantidad(cantidad);
                Intent i = getIntent();
                i.putExtra("itemCarrito", item);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}