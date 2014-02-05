package infoDisplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.BLKBelediye.balikesirbelediye.R;

/**
 * Created by EsatTaha on 30.01.2014.
 */
public class ERehber extends Activity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kurumsal_menu);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(new ListAdapter( this , "E_rehber"));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id)
            {
                Intent temp ;
                switch (position)
                {
                    case 0:
                            temp = new Intent("android.intent.action.CEVRE");
                        startActivity(temp);

                        break;
                    case 1:
                        temp = new Intent("android.intent.action.INSAAT");
                        startActivity(temp);
                        break;
                    case 2:
                        temp = new Intent("android.intent.action.EVLENDIRME");
                        startActivity(temp);

                        break;
                    case 3:
                        temp = new Intent("android.intent.action.SUVEKANAL");
                        startActivity(temp);

                        break;
                    case 4:
                        temp = new Intent("android.intent.action.ISYERI");
                        startActivity(temp);

                        break;
                    case 5:
                        temp = new Intent("android.intent.action.ISKAN");
                        startActivity(temp);

                        break;
                    case 6:
                        temp = new Intent("android.intent.action.EMLAK");
                        startActivity(temp);

                        break;
                }
                // Toast.makeText(getApplicationContext(), "Click ListItem Number " + position, Toast.LENGTH_LONG).show();
            }
        });

    }
}
