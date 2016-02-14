package com.shenzhenyuan.myquiz;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by shenzhenyuan on 2/13/16.
 */
public class ResultActivity extends Fragment {

    private static final String ARG_PRIOR_RESULT = "prior_results";
    private static ArrayList<String> results = new ArrayList<>();

    private Button mRetryBtn;
    private Button mQuitBtn;

    public static ResultActivity newInstance(ArrayList<String> results) {
        ResultActivity fragment = new ResultActivity();
        Bundle args = new Bundle();

        args.putSerializable(ARG_PRIOR_RESULT, results);
        fragment.setArguments(args);
        return fragment;
    }

    public ResultActivity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            results = (ArrayList<String>)getArguments().getSerializable(ARG_PRIOR_RESULT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = null;
        view = inflater.inflate(R.layout.fragment_text_question, container, false);


        mSubmitBtn = (Button) view.findViewById(R.id.submit_button);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((mCheckBox.get(0).isChecked() == true)&&(mCheckBox.get(1).isChecked() == true)&&
                        (mCheckBox.get(2).isChecked() == true)&&(mCheckBox.get(3).isChecked() == false)&&
                        (mCheckBox.get(4).isChecked() == true)){
                    results.add(getActivity().getResources().getString(R.string.correct));
                }
                else{
                    results.add(getActivity().getResources().getString(R.string.wrong));
                }
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, ResultActivity.newInstance(results))
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
