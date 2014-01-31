package infoDisplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

        list = (ListView) findViewById(R.id.listView1);
        list.setAdapter(new ListAdapter(this , "Belikesir"));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0 /*Balikesir tarihi getir*/:
                        break;

                }
            }
         }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

