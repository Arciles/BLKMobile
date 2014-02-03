package infoDisplay;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.BLKBelediye.balikesirbelediye.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by EsatTaha on 03.02.2014.
 */


public class DynamicListView extends BaseAdapter {

    ImageLoader imageLoader;
    Context c;
    String[] images= {"http://3.bp.blogspot.com/-Gsj-34Iyiio/ULEiyinE28I/AAAAAAAADPg/ISUQwGzSBMs/s1600/twitter.png",
            "http://a1.mzstatic.com/us/r30/Purple6/v4/99/ee/8e/99ee8e01-f089-d549-f571-1a3797ec660d/icon_256.png" ,
    "http://www.wallsave.com/wallpapers/1920x1080/forces-of-nature/1526282/forces-of-nature-1526282.jpg"};
    String baslik="Bslik bla bla bla bla bla";
    String icerik="Icerik bla bla bla bla bla";
    ArrayList<ListViews> lists = new ArrayList<ListViews>();

    DynamicListView(Context c )
    {
        this.c = c;
      imageLoader = ImageLoader.getInstance();

        for(int i= 0 ; i < 3 ; i++)
        {
            lists.add( new ListViews(images[i],baslik,icerik));
        }
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        myViewHolder holder = null;
        if(row==null)
        {
            LayoutInflater inflate = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);//Butun layout u inflate'in icine aldik
            row = inflate.inflate(R.layout.dynamic_lists , parent , false ); //gerekli islemler
            holder = new myViewHolder(row);
            row.setTag(holder);
        }
        else
        {
            holder = (myViewHolder) row.getTag();
        }

        imageLoader.displayImage(lists.get(position).image,holder.image );
        holder.baslik.setText(lists.get(position).baslik);
        holder.icerik.setText(lists.get(position).icerik);

        return row;
    }



    class myViewHolder
    {
        private ImageView image;
        private TextView baslik;
        private TextView icerik;
        myViewHolder(View v)
        {
            this.image = (ImageView) v.findViewById(R.id.ivDynamic);
            this.baslik = (TextView) v.findViewById(R.id.tvDynamic1);
            this.icerik = (TextView) v.findViewById(R.id.tvDynamic2);
        }
    }


    class ListViews
    {
        ListViews(String image, String baslik, String icerik)
        {
            this.baslik = baslik;
            this.icerik = icerik;
            this.image = image;
        }
        String image;
        String baslik;
        String icerik;
    }
}
