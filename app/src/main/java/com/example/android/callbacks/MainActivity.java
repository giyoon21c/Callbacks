package com.example.android.callbacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    private ScrollView mScroll;
    private TextView mLog;
    private Button mButtonRun, mButtonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the logging component
        mScroll = (ScrollView) findViewById(R.id.scrollLog);
        mLog = (TextView) findViewById(R.id.tvLog);
        mLog.setText("");

        mButtonRun = (Button) findViewById(R.id.btnRun);
        mButtonClear = (Button) findViewById(R.id.btnClear);

        mButtonRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMessage("Running code");
            }
        });

        mButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLog.setText("");
                mScroll.scrollTo(0, mScroll.getBottom());
            }
        });

        displayMessage("onCreate");
    }

    public void onRunBtnClick(View v) {
        displayMessage("Running code");
    }

    public void onClearBtnClick(View v) {
        mLog.setText("");
        mScroll.scrollTo(0, mScroll.getBottom());
    }

    public void displayMessage(String message) {
        mLog.append(message + "\n");
        mScroll.scrollTo(0, mScroll.getBottom());
    }

    @Override
    protected void onPause() {
        super.onPause();
        displayMessage("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayMessage("onResume");
    }

    @Override
    public void onFragmentInteraction() {
        ActivityHelper.log(this, mLog, "Fragment button pressed!", true);
    }

}
