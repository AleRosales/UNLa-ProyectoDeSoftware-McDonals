package unla.ProyectoSoftware.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import unla.ProyectoSoftware.R;

public class PagarOnlineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar_online);
        double total=getIntent().getFloatExtra("total",0);

        TextView tv_total=findViewById(R.id.tv_total_pagar_online);
        tv_total.setText("Total: $ "+total);


        Spinner sp_tipoIdentificacion=findViewById(R.id.sp_tipo_documento);
        String tipos[]={"DNI","CEDULA","LC","LE","OTRO"};
        sp_tipoIdentificacion.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipos));


    }
}