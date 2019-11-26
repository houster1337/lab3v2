package com.example.laboration3;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;

import androidx.appcompat.widget.AppCompatEditText;

import com.example.laboration3.R;

public class InteractiveSearcher extends AppCompatEditText {
    EditText inputfield;
    int counter;
    String userinput;
    MyThread myThread;
    int id = 0;
    MyAdapter adapter;
    ListPopupWindow popupWindow;
    View contentView;
    int height;
    int width;


    public InteractiveSearcher(Context context) {
        super(context);
        init();
    }

    public InteractiveSearcher(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InteractiveSearcher(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void init() {
        popupWindow = new ListPopupWindow(this.getContext());
        adapter = new MyAdapter();
        popupWindow.setAdapter(adapter);
        inputfield = (EditText) findViewById(R.id.search_input);
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                id++;
                userinput = inputfield.getText().toString();

                if(userinput.length() != 0) {

                    // popupWindow.show();
                }
                else if(userinput.length() == 0 && popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
                myThread = new MyThread(userinput, id);
                myThread.execute();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
