package unla.ProyectoSoftware.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import unla.ProyectoSoftware.R;
import unla.ProyectoSoftware.modelo.Producto;

public class ItemProductoPromociones extends BaseAdapter {
    Context contexto;

    List<Producto> productoList;
    LayoutInflater inflater;

    public ItemProductoPromociones(Context contexto, List<Producto> productoList) {
        this.contexto = contexto;
        this.productoList=productoList;
    }

    @Override
    public int getCount() {
        return productoList.size();
    }

    @Override
    public Object getItem(int i) {
        return productoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return productoList.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.item_producto_promociones,viewGroup , false);

        TextView tv_nombre = (TextView) itemView.findViewById(R.id.tv_nombre);
        TextView tv_precio = (TextView) itemView.findViewById(R.id.tv_precio);

        ImageView imgImg = (ImageView) itemView.findViewById(R.id.imageView);

        tv_nombre.setText(productoList.get(position).getNombre());
        tv_precio.setText(String.valueOf(productoList.get(position).getPrecio()));

        if(productoList.get(position).getFoto()!=null && productoList.get(position).getFoto().length()>0) {
            byte[] decodedString = Base64.decode(productoList.get(position).getFoto(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            imgImg.setImageBitmap(decodedByte);
        }
        return itemView;
    }
}
