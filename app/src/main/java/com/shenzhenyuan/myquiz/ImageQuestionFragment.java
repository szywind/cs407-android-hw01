package com.shenzhenyuan.myquiz;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by shenzhenyuan on 2/13/16.
 */
public class ImageQuestionFragment extends Fragment {

    private EditText mAnswer;
    private Button mSubmitBtn;

    public ImageQuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState){
        View view = null;
        view = inflater.inflate(R.layout.fragment_image_question, container, false);

        mAnswer = (EditText) view.findViewById(R.id.answer1);
        mSubmitBtn = (Button) view.findViewById(R.id.submit_button);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = mAnswer.getText().toString().toLowerCase();
                if (answer.isEmpty()) {
                    Toast.makeText(getActivity(), "Please type your answer first.", Toast.LENGTH_SHORT).show();
                } else {
                    ArrayList<String> feedback = new ArrayList<String>();
                    if(answer.equals("italy")){
                        feedback.add(getActivity().getResources().getString(R.string.correct));
                    }else{
                        feedback.add(getActivity().getResources().getString(R.string.wrong));
                    }

                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_fragment_container, TextQuestionFragment.newInstance(feedback))
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

    }
}
