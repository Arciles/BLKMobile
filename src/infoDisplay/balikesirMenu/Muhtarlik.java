package infoDisplay.balikesirMenu;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.BLKBelediye.balikesirbelediye.MethodInfoGetter;
import com.BLKBelediye.balikesirbelediye.R;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.BLKBelediye.balikesirbelediye.R;
/**
 * Created by EsatTaha on 05.02.2014.
 */
public class Muhtarlik extends Activity {
    ArrayList<ArrayList> result = new ArrayList<ArrayList>();
    ImageView iv;
    TextView tx;
    Bitmap bmp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_display_tablet);
        iv = (ImageView) findViewById(R.id.imageView1);
        tx = (TextView) findViewById(R.id.textView1);
        try {
            result = MethodInfoGetter.methodRequest("BalikesirTarihiGetir", "", "");
            Log.i("Balikesir tarihi log denemesi",result.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new asTask().execute();
    }

    private class asTask extends AsyncTask<Void , Void ,Void> {
        @Override
        protected Void doInBackground(Void... params) {

            URL url = null;
            try {
                url = new URL("http://balikesir.bel.tr/Balikesir_Tarihi/Resim_b_1.jpg");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            iv.setImageBitmap(bmp);
            tx.clearComposingText();
            tx.setText(result.get(0).get(1).toString());
        }
    }

}
