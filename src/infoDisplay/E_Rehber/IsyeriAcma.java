package infoDisplay.E_Rehber;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.BLKBelediye.balikesirbelediye.MethodInfoGetter;
import com.BLKBelediye.balikesirbelediye.R;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by EsatTaha on 05.02.2014.
 */
public class IsyeriAcma extends Activity {

    ArrayList<ArrayList> result = new ArrayList<ArrayList>();
    ImageView iv;
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_display_tablet);
        iv = (ImageView) findViewById(R.id.imageView1);
        tx = (TextView) findViewById(R.id.textView1);
        try {
            result = MethodInfoGetter.methodRequest("IsyeriAcmaIslemleriGetir", "", "");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tx.setText("");
        iv.setImageResource(R.drawable.emlak_vergisi);
        tx.setText(result.get(0).get(1).toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
