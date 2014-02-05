package infoDisplay;



import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import com.BLKBelediye.balikesirbelediye.MethodInfoGetter;
import com.BLKBelediye.balikesirbelediye.R;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by EsatTaha on 05.02.2014.
 */


public class HaberlerDynamic extends ListFragment implements AbsListView.OnScrollListener {

    private final int AUTOLOAD_THRESHOLD = 4;
    private final int MAXIMUM_ITEMS = 52;
    private DynamicListView mAdapter;
    private View mFooterView;
    private Handler mHandler;
    private boolean mIsLoading = false;
    private boolean mMoreDataAvailable = true;
    private boolean mWasLoading = false;

    private Runnable mAddItemsRunnable = new Runnable() {
        @Override
        public void run() {
            mAdapter.addMoreItems("Haberler",10);
            mIsLoading = false;
        }
    };

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Context context = getActivity();
        ArrayList<ArrayList> result = new ArrayList<ArrayList>();

        try {
            result = MethodInfoGetter.methodRequest("BaskanOzgecmisGetir", "", "");
            Log.i("MainMenu","Result gelis vakti");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        mHandler = new Handler();
        mAdapter = new DynamicListView(context, result ,"Haberler" );
        mFooterView = LayoutInflater.from(context).inflate(R.layout.footerview, null);
        getListView().addFooterView(mFooterView, null, false);
        setListAdapter(mAdapter);
        getListView().setOnScrollListener(this);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        if (!mIsLoading && mMoreDataAvailable) {
            if (totalItemCount >= MAXIMUM_ITEMS) {
                mMoreDataAvailable = false;
                getListView().removeFooterView(mFooterView);
            } else if (totalItemCount - AUTOLOAD_THRESHOLD <= firstVisibleItem + visibleItemCount) {
                mIsLoading = true;
                mHandler.postDelayed(mAddItemsRunnable, 1000);
            }
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // Ignore
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mWasLoading) {
            mWasLoading = false;
            mIsLoading = true;
            mHandler.postDelayed(mAddItemsRunnable, 1000);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mAddItemsRunnable);
        mWasLoading = mIsLoading;
        mIsLoading = false;
    }
}
