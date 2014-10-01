/**
 * 
 */
package cn.salesuite.mlogcat.app;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cn.salesuite.saf.app.SAFActivity;
import cn.salesuite.saf.inject.Injector;
import cn.salesuite.saf.log.L;

/**
 * 工程的基类Activity
 * @author Tony Shen
 *
 */
public class BaseActivity extends SAFActivity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		L.init(this);
	}
	
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		Injector.injectInto(this);
	}

	
	/**
	 * 防止内部Handler类引起内存泄露
	 * @author Tony Shen
	 *
	 */
    public static class MyHandler extends Handler{
	    private final WeakReference<Activity> mActivity;
	    public MyHandler(Activity activity) {
	        mActivity = new WeakReference<Activity>(activity);
	    }
	    @Override
	    public void handleMessage(Message msg) {
	        if(mActivity.get() == null) {
	            return;
	        }
	    }
	}
}
