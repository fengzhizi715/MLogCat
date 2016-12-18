/**
 * 
 */
package cn.salesuite.mlogcat.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import cn.salesuite.saf.app.SafeHandler;
import cn.salesuite.saf.inject.Injector;
import cn.salesuite.saf.log.L;
import cn.salesuite.saf.utils.ToastUtils;

/**
 * 工程的基类Activity
 * @author Tony Shen
 *
 */
public class BaseActivity extends Activity {
	
	protected Handler mHandler = new SafeHandler(this);
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		L.init(this.getClass());
	}
	
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		Injector.injectInto(this);
	}
	
	/**
	 * @param message toast的内容
	 */
	protected void toast(String message) {
		ToastUtils.showShort(this, message);
	}
	
	/**
	 * @param resId toast的内容来自String.xml
	 */
	protected void toast(int resId) {
		ToastUtils.showShort(this, resId);
	}
}
