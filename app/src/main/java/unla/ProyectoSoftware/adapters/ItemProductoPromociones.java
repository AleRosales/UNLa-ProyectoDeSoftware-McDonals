package unla.ProyectoSoftware.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import unla.ProyectoSoftware.R;

public class ItemProductoPromociones extends BaseAdapter {
    Context contexto;
    String[] nombres;
    String[] precios;

    int[]imagenes;
    LayoutInflater inflater;

    public ItemProductoPromociones(Context contexto, String[] nombres, String[] precios, int[] imagenes) {
        this.contexto = contexto;
        this.nombres = nombres;
        this.precios = precios;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return nombres.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.item_producto_promociones,viewGroup , false);

        TextView tv_nombre = (TextView) itemView.findViewById(R.id.tv_nombre);
        TextView tv_precio = (TextView) itemView.findViewById(R.id.tv_precio);

        ImageView imgImg = (ImageView) itemView.findViewById(R.id.imageView);

        tv_nombre.setText(nombres[position]);
        tv_precio.setText(precios[position]);
        imgImg.setImageResource(imagenes[position]);
        return itemView;
    }
}
