package com.nazicrosoft.nazicrosoftinterwebexploder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        EditText editText = (EditText)findViewById(R.id.editText);
        TextView textView = (TextView)findViewById(R.id.textView);

        WebView mWebView;
        mWebView = (WebView) findViewById(R.id.webView);//xml 자바코드 연결
        //mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://google.com");
        mWebView.setWebChromeClient(new WebChromeClient());
        class WebViewClientClass extends WebViewClient {//페이지 이동
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("check URL",url);
                view.loadUrl(url);
                return true;
            }
        }

        mWebView.setWebViewClient(new WebViewClientClass());
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {//버튼 이벤트 처리
            @Override
            public void onClick(View view) {
                textView.setText(String.valueOf(editText.getText()));
                mWebView.loadUrl(String.valueOf(editText.getText()));
                //Toast.makeText(getApplicationContext(),"버튼 클릭 성공", Toast.LENGTH_SHORT).show();
                //버튼 클릭시 Toast 메세지"버튼 클릭 성공" 출력
            }
        });

    }
    @Override
    public void onBackPressed() {
        WebView mWebView;
        mWebView = (WebView) findViewById(R.id.webView);//xml 자바코드 연결
        //mWebView.getSettings().setJavaScriptEnabled(true);

        if(mWebView.canGoBack()){
            mWebView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}