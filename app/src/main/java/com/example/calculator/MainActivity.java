package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.widget.GridLayout;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<NumericButtonData> numericButtonData = new ArrayList<NumericButtonData>() {
        {
            add(new NumericButtonData("7", 1, 0, 1));
            add(new NumericButtonData("4", 2, 0, 1));
            add(new NumericButtonData("1", 3, 0, 1));
            add(new NumericButtonData("0", 4, 0, 1));
            add(new NumericButtonData("8", 1, 1, 1));
            add(new NumericButtonData("5", 2, 1, 1));
            add(new NumericButtonData("2", 3, 1, 1));
            add(new NumericButtonData(".", 4, 1, 1));
            add(new NumericButtonData("9", 1, 2, 1));
            add(new NumericButtonData("6", 2, 2, 1));
            add(new NumericButtonData("3", 3, 2, 1));
            add(new NumericButtonData("C", 4, 2, 1));
            add(new NumericButtonData("/", 1, 3, 1));
            add(new NumericButtonData("*", 2, 3, 1));
            add(new NumericButtonData("-", 3, 3, 1));
            add(new NumericButtonData("+", 4, 3, 1));
            add(new NumericButtonData("Enter", 5, 1, 3));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        organizeLayout();
        fillLayout();
    }

    private void organizeLayout() {
        GridLayout mainLayout = new GridLayout(this);
        mainLayout.setId(R.id.mainView);
        mainLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.midnightBlue, null));
        mainLayout.setColumnCount(4);
        setContentView(mainLayout);
    }

    private void fillLayout() {
        GridLayout mainLayout = findViewById(R.id.mainView);
        equationView equationView = new equationView(this);

        mainLayout.addView(equationView);
        numericButtonData.forEach(numericData -> {
            NumericButton button = new NumericButton(this, numericData);
            mainLayout.addView(button);
            button.setOnClickListener(view -> {
                if(button.getText() == "C") {
                    equationView.setText("");
                } else if (button.getText() == "Enter") {
                    equationView.setText(javaScriptMathEval(equationView.getText().toString()));
                } else {
                    equationView.setText(equationView.getText().toString() + button.getText());
                }
            });
        });

    }

    private String javaScriptMathEval(String expression) {
        Context scriptContext = Context.enter();
        Context.getCurrentContext().setOptimizationLevel(-1);
        ScriptableObject scope = scriptContext.initStandardObjects();
        Object result = scriptContext.evaluateString(scope, expression, "expression", 0, null);
        Context.exit();
        return result.toString();
    }
}