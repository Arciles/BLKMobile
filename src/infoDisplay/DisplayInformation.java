package infoDisplay;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.BLKBelediye.balikesirbelediye.MethodInfoGetter;
import com.BLKBelediye.balikesirbelediye.R;
import com.BLKBelediye.balikesirbelediye.RequestSoap;


public class DisplayInformation extends Activity {
	ImageView InfoImage ;
	TextView InfoText ;
	private static ArrayList<ArrayList> information = new ArrayList<ArrayList>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		InfoText = (TextView) findViewById(R.id.tvInfoText);
		
	}
	
	

}
