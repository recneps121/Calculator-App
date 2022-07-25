package com.example.calculator;

import android.content.Context;
import android.view.Gravity;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

public class equationView extends AppCompatEditText {

    public equationView(Context context) {
        super(context);

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(0, 1, 2);
        params.columnSpec = GridLayout.spec(0, 3, 1);

        setLayoutParams(params);
        setTextSize(26);
        setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorWhite, null));
        setGravity(Gravity.CENTER);
        setEnabled(false);
    }
}
