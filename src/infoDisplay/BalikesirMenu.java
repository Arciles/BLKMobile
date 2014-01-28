package infoDisplay;

import com.BLKBelediye.balikesirbelediye.R;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;

public class BalikesirMenu extends Activity {

	String[] titles;
	int[] images = {R.drawable.balikesir1,R.drawable.balikesir2 ,R.drawable.balikesir3 ,
				R.drawable.balikesir4 ,R.drawable.balikesir5,
				R.drawable.balikesir6 ,R.drawable.balikesir7 ,
				R.drawable.balikesir8 ,R.drawable.balikesir9};
	ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Resources res = getResources();
		titles = res.getStringArray(R.array.balikesir_menu);
		list = (ListView)findViewById(R.id.listView1);
		
	}
}

