package infoDisplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.BLKBelediye.balikesirbelediye.*;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class BalikesirMenu extends Activity {

	ListView list;
    String icerik;
    private static ArrayList<ArrayList> result = new ArrayList<ArrayList>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kurumsal_menu);

        list = (ListView) findViewById(R.id.list);
        list.setAdapter(new ListAdapter(this , "Belikesir"));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id)
            {
                Intent temp ;
                switch (position)
                {
                    case 0:

                        temp = new Intent("android.intent.action.TARIH");
                        startActivity(temp);
                        break;
                    case 1:


                        break;
                    case 2:


                        break;
                    case 3:


                        break;
                    case 4:


                        break;
                    case 5:


                        break;
                    case 6:


                        break;
                    case 7:


                        break;
                    case 8:


                        break;
                }
               // Toast.makeText(getApplicationContext(), "Click ListItem Number " + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

