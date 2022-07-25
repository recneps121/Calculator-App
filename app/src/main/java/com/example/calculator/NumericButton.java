package com.example.calculator;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;

public class NumericButton extends AppCompatButton {

    public NumericButton(Context context, NumericButtonData numericData) {
        super(context);

        GradientDrawable background = new GradientDrawable();
        background.setCornerRadius(100);

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(numericData.getRow(), 1, 1);
        params.columnSpec = GridLayout.spec(numericData.getColumn(), numericData.getSize(), 1);

        if(numericData.getValue() == "/" || numericData.getValue() == "*" || numericData.getValue() == "-" || numericData.getValue() == "+" || numericData.getValue() == "ENTER") {
            background.setColor(ResourcesCompat.getColor(getResources(), R.color.colorOrange, null));
        } else {
            background.setColor(ResourcesCompat.getColor(getResources(), R.color.darkGray, null));
        }

        setText(numericData.getValue());
        setTextSize(24);
        setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorWhite, null));
        setBackground(background);
        setLayoutParams(params);

    }
}
