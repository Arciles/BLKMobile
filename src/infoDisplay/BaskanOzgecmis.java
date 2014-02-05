package infoDisplay;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.BLKBelediye.balikesirbelediye.MethodInfoGetter;
import com.BLKBelediye.balikesirbelediye.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by EsatTaha on 05.02.2014.
 */
public class BaskanOzgecmis extends Activity {
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
            result = MethodInfoGetter.methodRequest("BaskanOzgecmisGetir", "", "");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0 ; i <15 ;i++)
        Log.i("Imageloader log",result.get(0).get(2).toString());

    new asTask().execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private class asTask extends AsyncTask<Void , Void ,Void>{
        @Override
        protected Void doInBackground(Void... params) {

            URL url = null;
            try {
                url = new URL(result.get(0).get(2).toString());
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
            tx.setText("");
            tx.setText(result.get(0).get(1).toString());
        }
    }
}
