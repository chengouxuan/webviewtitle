package com.example.webviewtitle;

import com.nobu_games.android.view.web.TitleBarWebView;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		View view = new View(MainActivity.this) {
//			Paint paint = new TextPaint();
//			@Override
//			protected void onDraw(Canvas canvas) {
////				canvas.clipRect(getLeft(), getTop(), getRight(), getBottom());
////				canvas.drawColor(0xffff0000);
////				paint.setColor(0xffff00);
//
//				canvas.drawText("tilte bar", 0, 0, paint);
//				super.onDraw(canvas);
//			}
//		};
		TextView view = new TextView(this);
		view.setText("1234567 0123456");
		view.setBackgroundColor(0xff0000ff);
		view.setTextColor(0xffffffff);
		view.setMinimumHeight(60);
		view.setMinimumWidth(500);
		view.setLayoutParams(new LayoutParams(500, 60));
//		WebViewWithTitle webViewWithTitle = (WebViewWithTitle)findViewById(R.id.webview);
		TitleBarWebView webViewWithTitle = (TitleBarWebView)findViewById(R.id.webview);
//		webViewWithTitle.setTitle(view);
		webViewWithTitle.setEmbeddedTitleBarCompat(view);
		webViewWithTitle.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		webViewWithTitle.loadUrl("http://www.baidu.com");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
