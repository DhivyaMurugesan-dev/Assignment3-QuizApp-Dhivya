package com.example.assignment3_quizapp_dhivya;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class QuizFragment extends Fragment {
    public QuizFragment(){}
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String Quest_ID = "questId";
//    private static final String Color_ID = "colorId";
//
//    // TODO: Rename and change types of parameters
//    private String questId;
//    private String colorId;
//
//    public QuizFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment QuizFragment.
//     */
//   //TODO: Rename and change types and number of parameters

    public static QuizFragment newInstance(int questId, int colorId) {
        QuizFragment fragment = new QuizFragment();
        Bundle quizbundle = new Bundle();
        quizbundle.putInt("Questid", questId);
        quizbundle.putInt("Colorid", colorId);
        fragment.setArguments(quizbundle);
        return fragment;
    }
    //    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            Questid = getArguments().getInt(questId);
//            Colorid = getArguments().getInt(colorId);
//        }
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_fragment, container, false);
        TextView quest_text = (TextView) view.findViewById(R.id.question_text);
        // quest_text.setOnClickListener(new View.OnClickListener() {

        //  quest_text=(TextView) view.findViewById(R.id.quest_text);
        assert getArguments() != null;
        quest_text.setText(getArguments().getInt("Questid"));
        quest_text.setBackgroundColor(getArguments().getInt("Colorid"));
        return view;
        //  }
        //public void onClick(View v) { return v;}
    }
}

