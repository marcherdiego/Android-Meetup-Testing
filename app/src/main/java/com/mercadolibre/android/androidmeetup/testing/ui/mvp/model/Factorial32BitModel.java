package com.mercadolibre.android.androidmeetup.testing.ui.mvp.model;

import com.nerdscorner.mvplib.events.model.BaseModel;

public class Factorial32BitModel extends BaseModel {
    public int calculateFactorial(int input) {
        if (input == 0) {
            return 1;
        }
        return input * calculateFactorial(input - 1);
    }
}
