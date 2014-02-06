package infoDisplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.BLKBelediye.balikesirbelediye.R;

import java.util.ArrayList;

/**
 * Created by EsatTaha on 06.02.2014.
 */
public class BalikesirTwoDynamic extends BaseAdapter {

    Context c;
    ArrayList<String> baslik = new ArrayList<String>() ;
    ArrayList<String> text1 = new ArrayList<String>() ;
    ArrayList<String> text2 = new ArrayList<String>() ;
    ArrayList<Total> list = new ArrayList<Total>();
    String subText1 ;
    String subText2 ;

    public BalikesirTwoDynamic(Context c, ArrayList<ArrayList> list, String tur)
    {

        this.c = c;

        for(int i = 0 ; i < list.size() ;i++)
        {
            baslik.add(list.get(i).get(0).toString());
            text1.add(list.get(i).get(1).toString());
            text2.add(list.get(i).get(2).toString());
        }

        if(tur.equals("Eczaneler"))
        {
            subText1 = "Tel. : ";
            subText2 = "Adres : ";
        }
        else if(tur.equals("OnemliTelefonlar"))
        {
            subText1 = "Tel. : ";
            subText2 = "Fax. : ";
        }
        for(int i = 0 ; i < baslik.size() ; i++)
        {
            list.add( new Total(baslik.get(i), text1.get(i), text2.get(i)) );
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
            row = inflate.inflate(R.layout.balikesir_menu_iki,parent,false); //gerekli islemler
            holder = new myViewHolder(row);
            row.setTag(holder);
        }
        else
        {
            holder = (myViewHolder) row.getTag();
        }


        holder.Baslik.setText(list.get(position).Baslik); //gelen position a gore resim ve text leri set ettik
        holder.text1.setText(subText1 + list.get(position).subText1);
        holder.text2.setText(subText2 + list.get(position).subText2);


        return row; // single row u return ettik
    }



    class myViewHolder
    {
        TextView Baslik;
        TextView text1;
        TextView text2;


        myViewHolder(View v)
        {
            this.Baslik = (TextView) v.findViewById(R.id.textView);
            this.text1 = (TextView) v.findViewById(R.id.textView2);
            this.text2 = (TextView) v.findViewById(R.id.textView3);
        }
    }

}

class Total extends ArrayList {
    String Baslik ;
    String subText1 ;
    String subText2 ;
    Total(String b , String s1 , String s2)
    {
        Baslik = b;
        subText1 = s1 ;
        subText2 = s2 ;
    }
}