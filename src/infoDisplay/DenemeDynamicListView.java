package infoDisplay;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.BLKBelediye.balikesirbelediye.R;

import java.util.ArrayList;

/**
 * Created by EsatTaha on 03.02.2014.
 */
public class DenemeDynamicListView extends Activity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kurumsal_menu);
        list = (ListView) findViewById(R.id.listView1);
        list.setAdapter(new DynamicListView(this));
    }
}
