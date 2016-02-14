package com.shenzhenyuan.myquiz;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by shenzhenyuan on 2/13/16.
 */
public class TextQuestionFragment extends Fragment{

    private static final String ARG_PRIOR_RESULT = "prior_results";
    private static ArrayList<String> results = new ArrayList<>();
    private ArrayList<CheckBox> mCheckBox = new ArrayList<>();
    private Button mSubmitBtn;

    public static TextQuestionFragment newInstance(ArrayList<String> results) {
        TextQuestionFragment fragment = new TextQuestionFragment();
        Bundle args = new Bundle();

        args.putSerializable(ARG_PRIOR_RESULT, results);
        fragment.setArguments(args);
        return fragment;
    }

    public TextQuestionFragment() {
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

        int checkBox[]= {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5};
        for(int i: checkBox){
            CheckBox temp = (CheckBox) view.findViewById(i);
            if (temp.isChecked()) {
                temp.setChecked(false);
            }
            mCheckBox.add(temp);
//            mCheckBox.add((CheckBox) view.findViewById(i));
        }
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

                Intent intent = new Intent(getActivity(), ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("result", results);
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
}
