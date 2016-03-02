package cr.ac.itcr.tarea_i;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by laurens on 01/03/2016.
 */
public class Fragment_A extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.fragment_a, container);

        final WebView myWebView = (WebView) view.findViewById(R.id.webView);
        myWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Do what you want
                myWebView.loadUrl("https://facebook.com/");
                return false;
            }
        });




        return view;
    }


}
