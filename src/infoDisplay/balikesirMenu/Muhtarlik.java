package infoDisplay.balikesirMenu;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.BLKBelediye.balikesirbelediye.MethodInfoGetter;
import com.BLKBelediye.balikesirbelediye.R;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.BLKBelediye.balikesirbelediye.R;

import infoDisplay.BalikesirTwoDynamic;

/**
 * Created by EsatTaha on 05.02.2014.
 */
public class Muhtarlik extends Activity {

    ListView list;
    ArrayList<ArrayList> result = new ArrayList<ArrayList>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kurumsal_menu);
        list = (ListView) findViewById(R.id.list);

        try {
            result = MethodInfoGetter.methodRequest("EczanelerGetir", "", "");
            Log.i("MainMenu","Result gelis vakti");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        BalikesirTwoDynamic muhtarlik = new BalikesirTwoDynamic(Muhtarlik.this ,result,"Eczaneler");
        list.setAdapter(muhtarlik);



    }

}
