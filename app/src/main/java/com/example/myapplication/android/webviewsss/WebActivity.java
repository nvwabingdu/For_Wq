package com.example.myapplication.android.webviewsss;

import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.android.global.BaseActivity;

import static android.view.KeyEvent.KEYCODE_BACK;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-15
 * Time: 18:41
 */
public class WebActivity extends BaseActivity {


    @Override
    public int LayoutId() {
        return R.layout.actiivity_web;
    }
    WebView webView;
    @Override
    public void initView() {
        TextView textView = findViewById(R.id.web_tv1);
        textView.setText("");


        //获得控件
       webView = (WebView) findViewById(R.id.web);
       webView.loadUrl("www.baidu.com");

//        method(webView,"");

    }


//    private void method(WebView webView,String url) {
//
//        //访问网页
////        webView.loadUrl(url);
//        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
////        webView.setWebViewClient(new WebViewClient() {
////            @Override
////            public boolean shouldOverrideUrlLoading(WebView view, String url) {
////                //使用WebView加载显示url
////                view.loadUrl(url);
////                //返回true
////                return true;
////            }
////        });
//
//        //是否可以后退
//        webView.canGoBack();
//        //后退网页
////        webView.goBack();
//        //是否可以前进
//        webView.canGoForward();
//        //前进网页
////        webView.goForward();
//        //以当前的index为起始点前进或者后退到历史记录中指定的steps
//        //如果steps为负数则为后退，正数则为前进
//        // webView.goBackOrForward(intsteps);
////        webView.goBackOrForward(-1);
//        //清除网页访问留下的缓存
////由于内核缓存是全局的因此这个方法不仅仅针对webview而是针对整个应用程序.
////        webView.clearCache(true);
//
////清除当前webview访问的历史记录
////只会webview访问历史记录里的所有记录除了当前访问记录
////        webView.clearHistory();
//
////这个api仅仅清除自动完成填充的表单数据，并不会清除WebView存储到本地的数据
////        webView.clearFormData();
//
//
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return false;// 返回false
//            }
//        });
//        //baiduboxapp:
//        //webView加载网页后出现ERR_UNKNOWN_URL_SCHEME
//        /*mWebView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                try{
//                    if(url.startsWith("baiduboxapp://")){
//                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                        startActivity(intent);
//                        return true;
//                    }
//                }catch (Exception e){
//                    return false;
//                }
//                mWebView.loadUrl(url);
//                return true;
//            }
//        });*/
//        WebSettings webSettings = webView.getSettings();
//        // 让WebView能够执行javaScript
//        webSettings.setJavaScriptEnabled(true);
//        // 让JavaScript可以自动打开windows
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        // 设置缓存
//        webSettings.setAppCacheEnabled(true);
//        // 设置缓存模式,一共有四种模式
//        webSettings.setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);
//        // 设置缓存路径
////        webSettings.setAppCachePath("");
//        // 支持缩放(适配到当前屏幕)
//        webSettings.setSupportZoom(true);
//        // 将图片调整到合适的大小
//        webSettings.setUseWideViewPort(true);
//        // 支持内容重新布局,一共有四种方式
//        // 默认的是NARROW_COLUMNS
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        // 设置可以被显示的屏幕控制
//        webSettings.setDisplayZoomControls(true);
//        // 设置默认字体大小
//        webSettings.setDefaultFontSize(12);
//
//        // 设置WebView属性，能够执行Javascript脚本
//        // mWebView.getSettings().setJavaScriptEnabled(true);
//        //3、 加载需要显示的网页
//        webView.loadUrl(url);
//        ///4、设置响应超链接，在安卓5.0系统，不使用下面语句超链接也是正常的，但在MIUI中安卓4.4.4中需要使用下面这条语句，才能响应超链接
//        // mWebView.setWebViewClient(new HelloWebViewClient());
//
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
