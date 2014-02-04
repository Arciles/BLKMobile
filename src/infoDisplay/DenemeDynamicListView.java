package infoDisplay;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.BLKBelediye.balikesirbelediye.MethodInfoGetter;
import com.BLKBelediye.balikesirbelediye.R;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by EsatTaha on 03.02.2014.
 */

public class DenemeDynamicListView extends Activity {

    
    ListView list;
    BaseAdapter adapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.kurumsal_menu);
            ArrayList<ArrayList> result = null ;
            list = (ListView) findViewById(R.id.list);
            list.setOnScrollListener(new EndlessScrollListener());
            try {
                result = MethodInfoGetter.methodRequest("HaberGetir", "", "");
                Log.i("MainMenu", "Result gelis vakti");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (NullPointerException e)
            {
                e.printStackTrace();
                result = null;
            }

            Log.i("Deneme Dynamic",result.toString());
            adapter =new DynamicListView(this, result, "Haberler");

             list.setAdapter(adapter);
    }


}
