package com.mercadolibre.android.androidmeetup.testing.ui.mvp.view;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mercadolibre.android.androidmeetup.testing.R;
import com.nerdscorner.mvplib.events.activity.BaseActivity;
import com.nerdscorner.mvplib.events.view.BaseActivityView;

import static android.support.annotation.VisibleForTesting.PACKAGE_PRIVATE;

public class Factorial32BitView extends BaseActivityView {
    private EditText numberInput;
    private Button factorialBtn;
    private TextView factorialResult;

    public Factorial32BitView(@NonNull BaseActivity activity) {
        super(activity);

        numberInput = activity.findViewById(R.id.number_input);
        factorialBtn = activity.findViewById(R.id.factorial_btn);
        factorialResult = activity.findViewById(R.id.factorial_result);

        factorialBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                bus.post(new FactorialButtonClickEvent(numberInput.getText().toString()));
            }
        });
    }

    @SuppressLint("DefaultLocale")
    public void showFactorialResult(int input, int result) {
        factorialResult.setText(String.format("%d! = %d", input, result));
    }

    public static class FactorialButtonClickEvent {
        public String input;

        @VisibleForTesting(otherwise = PACKAGE_PRIVATE)
        public FactorialButtonClickEvent(String input) {
            this.input = input;
        }
    }
}
