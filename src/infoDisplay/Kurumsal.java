package infoDisplay;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.BLKBelediye.balikesirbelediye.R;

/**
 * Created by EsatTaha on 30.01.2014.
 */
public class Kurumsal extends Activity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kurumsal_menu);

        lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(new ListAdapter(this ,"Kurumsal"));

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
