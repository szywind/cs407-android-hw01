package com.shenzhenyuan.myquiz;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by shenzhenyuan on 2/13/16.
 */
public class ResultActivity extends AppCompatActivity {

    private static final String ARG_PRIOR_RESULT = "prior_results";
    private static ArrayList<String> results = new ArrayList<>();

    private Button mRetryBtn;
    private Button mQuitBtn;
    private ListView mResultListView;
    private ResultViewAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        results = (ArrayList<String>) intent.getSerializableExtra("result");

        mRetryBtn = (Button) findViewById(R.id.restart_button);
        mQuitBtn = (Button) findViewById(R.id.exit_button);

        mResultListView = (ListView) findViewById(R.id.result_listview);
        mAdapter = new ResultViewAdapter(this, results);
        mResultListView.setAdapter(mAdapter);

        mRetryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyQuizActivity.class);
                startActivity(intent);
            }
        });


        mQuitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

}
