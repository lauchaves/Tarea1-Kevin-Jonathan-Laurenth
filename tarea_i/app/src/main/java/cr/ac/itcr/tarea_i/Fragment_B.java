package cr.ac.itcr.tarea_i;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import static cr.ac.itcr.tarea_i.R.id.progressBar;

/**
 * Created by laurens on 01/03/2016.
 */

public class Fragment_B extends Fragment {

    private ProgressBar progressBar1;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.fragment_b, container);


        progressBar1 = (ProgressBar) view.findViewById(progressBar);
        textView = (TextView) view.findViewById(R.id.textView5);
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar1.setProgress(progressStatus);
                            textView.setText(progressStatus + "/" + progressBar1.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();




        return view;
    }
}
