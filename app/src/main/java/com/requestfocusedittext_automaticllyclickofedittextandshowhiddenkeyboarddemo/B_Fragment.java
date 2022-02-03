package com.requestfocusedittext_automaticllyclickofedittextandshowhiddenkeyboarddemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class B_Fragment extends Fragment {

    EditText request_focus_textView;
    Button hide_auto_button;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.fragment_b_layout, container, false);

        request_focus_textView = view.findViewById(R.id.request_focus_textView);
        //automatically click of EditText
        request_focus_textView.requestFocus();

        hide_auto_button = view.findViewById(R.id.hide_auto_button);

        //if clicked(Auto focus) on Edittext then show soft keyboard
        if (request_focus_textView.isLayoutRequested()) {
            ((InputMethodManager) (getContext()).getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        }

        //if leave fragment then hide soft keyboard
        hide_auto_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(((Activity) view.getContext()).getCurrentFocus().getWindowToken(), 0);
            }
        });

        return view;
    }
}
