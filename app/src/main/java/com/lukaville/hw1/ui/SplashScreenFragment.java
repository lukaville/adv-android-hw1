package com.lukaville.hw1.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lukaville.hw1.R;

import java.util.concurrent.TimeUnit;

public class SplashScreenFragment extends Fragment {
    private static final int SPLASH_SCREEN_DURATION_SECONDS = 2;

    private OnSplashScreenEndListener mListener;
    private SleepTask mSleepTask;

    public SplashScreenFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSleepTask = new SleepTask();
        mSleepTask.execute();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_screen, container);
    }

    private void onSplashScreenEnd() {
        if (mListener != null) {
            mListener.onSplashScreenEnd();
        }
    }

    /**
     * Not deprecated method onAttach(Context context)
     * only called when using device with API version 23,
     * so we use old method onAttach(Activity activity).
     * This bug fixed in support version of fragment.
      */
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnSplashScreenEndListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnSplashScreenEndListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSleepTask.cancel(true);
    }

    public interface OnSplashScreenEndListener {
        void onSplashScreenEnd();
    }

    private class SleepTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                TimeUnit.SECONDS.sleep(SPLASH_SCREEN_DURATION_SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            onSplashScreenEnd();
        }
    }
}
