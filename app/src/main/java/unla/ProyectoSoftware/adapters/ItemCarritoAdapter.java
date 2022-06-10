package unla.ProyectoSoftware.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import unla.ProyectoSoftware.R;
import unla.ProyectoSoftware.modelo.ItemCarrito;
import unla.ProyectoSoftware.modelo.Producto;

public class ItemCarritoAdapter extends BaseAdapter {
    Context contexto;

    ArrayList<ItemCarrito> carrito;
    LayoutInflater inflater;

    public ItemCarritoAdapter(Context contexto, ArrayList<ItemCarrito> carrito) {
        this.contexto = contexto;
        this.carrito=carrito;
    }

    @Override
    public int getCount() {
        if(carrito!=null) {
            return carrito.size();
        }else{
            return 0;
        }
    }

    @Override
    public Object getItem(int i) {
        return carrito.get(i);
    }

    @Override
    public long getItemId(int i) {
        return carrito.get(i).getProducto().getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.item_carrito_adapter,viewGroup , false);

        TextView tv_nombre = (TextView) itemView.findViewById(R.id.tv_nombre_carrito);
        TextView tv_precio = (TextView) itemView.findViewById(R.id.tv_precio_carrito);
        TextView tv_cantidad=(TextView) itemView.findViewById(R.id.tv_cantidadProd_item);

        ImageView imgImg = (ImageView) itemView.findViewById(R.id.iv_producto_carrito);

        tv_nombre.setText(carrito.get(position).getProducto().getNombre());
        tv_precio.setText(String.valueOf((carrito.get(position).getProducto().getPrecio()*carrito.get(position).getCantidad())));
        tv_cantidad.setText("Cantidad:"+String.valueOf(carrito.get(position).getCantidad()));
        if(carrito.get(position).getProducto().getFoto()!=null && carrito.get(position).getProducto().getFoto().length()>0) {
            byte[] decodedString = Base64.decode(carrito.get(position).getProducto().getFoto(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            imgImg.setImageBitmap(decodedByte);
        }

        ImageButton imageButton=itemView.findViewById(R.id.iv_eliminar_productos);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carrito.remove(position);
                ItemCarritoAdapter.this.notifyDataSetChanged();
            }
        });
        return itemView;
    }

    public ArrayList<ItemCarrito> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<ItemCarrito> carrito) {
        this.carrito = carrito;
    }
}
