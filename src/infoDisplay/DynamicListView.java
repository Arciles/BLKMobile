package infoDisplay;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
    ArrayList<String> images = new ArrayList<String>();
    ArrayList<String> baslik = new ArrayList<String>() ;
    ArrayList<String> icerik = new ArrayList<String>() ;
    ArrayList<ListViews> lists = new ArrayList<ListViews>();
    ArrayList<ArrayList> list1 = new ArrayList<ArrayList>();
    ArrayList<String> temp = new ArrayList<String>();


    DynamicListView(Context c ,ArrayList<ArrayList> list ,String tur)
    {
        this.c = c;
        this.list1 = list;
        addMoreItems(tur,15);

    }

    public void addMoreItems( String tur,int count) {


        if(tur.equals("Haberler"))
        {
           for(int i = 0; i < count ; i++)
            {
                temp = list1.get(i);

                images.add( temp.get(3) );
                baslik.add( temp.get(0) );
                icerik.add(temp.get(1));

            }
            temp.clear();
        }
        else if(tur.equals("Duyurular"))
        {

        }



        imageLoader = ImageLoader.getInstance();

        for(int i= 0 ; i < count ; i++)
        {
            lists.add( new ListViews( images.get(i), baslik.get(i), icerik.get(i) ) );
        }

        notifyDataSetChanged();
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

        imageLoader.displayImage(lists.get(position).image , holder.image );
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
