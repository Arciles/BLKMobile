package infoDisplay;

import com.BLKBelediye.balikesirbelediye.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewer extends ListActivity {

	String[] dummyList = {"Dummy 1", "Dummy 2", "Dummy 3", "Dummy 4", "Dummy 5", "Dummy 6"};
	ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method  stub
		super.onCreate(savedInstanceState);
		lv = getListView();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1 ,dummyList);
		lv.setAdapter(adapter);
			
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}

	
	
}
