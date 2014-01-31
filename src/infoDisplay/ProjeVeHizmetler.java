package infoDisplay;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.BLKBelediye.balikesirbelediye.R;

/**
 * Created by EsatTaha on 30.01.2014.
 */
public class ProjeVeHizmetler extends Activity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kurumsal_menu);
        list = (ListView) findViewById(R.id.listView1);
        list.setAdapter( new ListAdapter(this, "Proje"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
