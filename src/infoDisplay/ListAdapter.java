package infoDisplay;

import android.Manifest;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.BLKBelediye.balikesirbelediye.R;

import java.util.ArrayList;


public  class ListAdapter extends BaseAdapter {

    String[] titles;
    int[] images;
    ArrayList<SingleRow> listMembers ;
    Context c;

    ListAdapter(Context c,String choice)
    {
        this.c = c;
        listMembers = new ArrayList<SingleRow>();
        if(choice.equals("Belikesir"))
        {

            Resources res = c.getResources();
            titles = res.getStringArray(R.array.balikesir_menu);
            images = new int[]{R.drawable.balikesir1, R.drawable.balikesir2,
                    R.drawable.balikesir3, R.drawable.balikesir4, R.drawable.balikesir5,
                    R.drawable.balikesir6, R.drawable.balikesir7, R.drawable.balikesir8, R.drawable.balikesir9};
            for(int i = 0; i < titles.length ; i++)
            {
                listMembers.add(new SingleRow(titles[i],images[i]));
            }

        }
        else if(choice.equals("Kurumsal"))
        {
            Resources res = c.getResources();
            titles = res.getStringArray(R.array.Kurumsal);
            images = new int[]{R.drawable.lists};
            for(int i = 0 ; i < titles.length ; i++)
            {
                listMembers.add(new SingleRow(titles[i] , images[0]));
            }

        }
        else if(choice.equals("E_belediye"))
        {
            Resources res = c.getResources();
            titles = res.getStringArray(R.array.e_belediye);
            images = new int[]{R.drawable.ebelediye1,R.drawable.ebelediye2,R.drawable.ebelediye4,R.drawable.ebelediye4};
            for(int i = 0 ; i < titles.length ; i++)
            {
                listMembers.add(new SingleRow(titles[i] , images[i]));
            }

        }
        else if(choice.equals("E_rehber"))
        {
            Resources res = c.getResources();
            titles = res.getStringArray(R.array.e_Rehber);
            images = new int[]{R.drawable.erehber1,R.drawable.erehber2,R.drawable.erehber3,
                    R.drawable.erehber4,R.drawable.erehber5,R.drawable.erehber6,R.drawable.erehber7};
            for(int i = 0 ; i < titles.length ; i++)
            {
                listMembers.add(new SingleRow(titles[i] ,images[i]));
            }

        }
        else if(choice.equals("Proje_ve_hizmetler"))
        {
            Resources res = c.getResources();
            titles = res.getStringArray(R.array.Proje_ve_hizmetler);
            images = new int[]{R.drawable.proje1,R.drawable.proje2,R.drawable.proje3,
                    R.drawable.proje4,R.drawable.proje5,R.drawable.proje6,R.drawable.proje7,
                    R.drawable.proje8,R.drawable.proje9,R.drawable.proje10};
            for(int i = 0 ; i < titles.length ; i++)
            {
               listMembers.add(new SingleRow(titles[i] ,images[i]));
            }
        }

    }

    @Override
    public int getCount() {
        return listMembers.size();
    }

    @Override
    public Object getItem(int position) {
        return listMembers.get(position);
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
            row = inflate.inflate(R.layout.multible_image_row,parent,false); //gerekli islemler
            holder = new myViewHolder(row);
            row.setTag(holder);
        }
        else
        {
            holder = (myViewHolder) row.getTag();
        }

        holder.text.setText(listMembers.get(position).title); //gelen position a gore resim ve text leri set ettik
        holder.image.setImageResource(listMembers.get(position).image);

        return row; // single row u return ettik
    }


    class myViewHolder
    {
        ImageView image;
        TextView text;
        myViewHolder(View v)
        {
            this.image = (ImageView) v.findViewById(R.id.ivMultiple);
            this.text = (TextView) v.findViewById(R.id.tvMultiole);
        }
    }

}

