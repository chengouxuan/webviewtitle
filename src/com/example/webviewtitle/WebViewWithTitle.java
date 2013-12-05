package com.example.webviewtitle;

import java.lang.reflect.Method;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

public class WebViewWithTitle extends WebView {

	public WebViewWithTitle(Context context) {
		super(context);
		init();
	}

	public WebViewWithTitle(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public WebViewWithTitle(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

    private static final String LOG_TAG = "WebViewWithTitle";
    private Method setEmbeddedTitleBarMethod = null;

    private void init() {
        try {
            setEmbeddedTitleBarMethod = WebView.class.getMethod("setEmbeddedTitleBar", View.class);
        } catch (Exception ex) {
            Log.e(LOG_TAG, "could not find setEmbeddedTitleBar", ex);
        }
    }

    public void setTitle(View view) {
        if (setEmbeddedTitleBarMethod != null) {
            try {
                setEmbeddedTitleBarMethod.invoke(this, view);
            } catch (Exception ex) {
                Log.e(LOG_TAG, "failed to call setEmbeddedTitleBar", ex);
            }
        }
    }

    public void setTitle(int resId) {
        setTitle(inflate(getContext(), resId, null));
    }

}
