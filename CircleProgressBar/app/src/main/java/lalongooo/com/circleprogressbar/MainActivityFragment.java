package lalongooo.com.circleprogressbar;

import android.animation.ObjectAnimator;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final ProgressBar pb = (ProgressBar) rootView.findViewById(R.id.yourId);

        rootView.findViewById(R.id.btnStartProgress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animation = ObjectAnimator.ofInt(pb, "progress", 1, 100);
                animation.setDuration(5000); //in milliseconds
                animation.setInterpolator(new DecelerateInterpolator());
                animation.start();
            }
        });

        rootView.findViewById(R.id.btnStartAsyncTask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AsyncTask<Void, Integer, Void>() {

                    @Override
                    protected Void doInBackground(Void... voids) {
                        for (int i = 0; i < 101; i++) {
                            publishProgress(i);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        return null;
                    }

                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        super.onProgressUpdate(values);
                        Log.i("Progress", String.valueOf(values[0]));
                        pb.setProgress(values[0]);
                    }
                }.execute();

            }
        });

        return rootView;
    }
}
