package unla.ProyectoSoftware.activities;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import unla.ProyectoSoftware.R;
import unla.ProyectoSoftware.adapters.ItemCarritoAdapter;
import unla.ProyectoSoftware.modelo.ItemCarrito;

public class CarritoActivity extends AppCompatActivity {

    ItemCarritoAdapter adapter;
    TextView tv_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        ListView lv_carrito=findViewById(R.id.lv_carrito);
        ArrayList carrito=getIntent().getParcelableArrayListExtra("carrito");

        adapter=new ItemCarritoAdapter(this,carrito);
        lv_carrito.setAdapter(adapter);
        lv_carrito.setFocusable(false);
        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                CalcularTotal();
            }
        });
        tv_total=findViewById(R.id.tv_total);
        CalcularTotal();

        OnBackPressedCallback callback = new OnBackPressedCallback(true ) {
            @Override
            public void handleOnBackPressed() {
                Intent i = getIntent();
                i.putExtra("carrito", adapter.getCarrito());
                setResult(RESULT_OK, i);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);


        Button btn_pagar=findViewById(R.id.btn_pagar);
        btn_pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PagarOnlineActivity.class);
                intent.putExtra("total",CalcularTotal());
                startActivity(intent);
            }
        });
    }

    private float CalcularTotal(){
        float total=0;
        if(adapter.getCarrito()!=null && adapter.getCarrito().size()>0) {
            for (Object o : adapter.getCarrito()) {
                ItemCarrito item = ((ItemCarrito) o);
                total += (item.getCantidad() * item.getProducto().getPrecio());
            }
        }
        tv_total.setText("$"+total);
        return total;
    }
}