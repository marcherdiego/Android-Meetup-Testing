package com.mercadolibre.android.androidmeetup.testing.ui.mvp.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class Factorial32BitModelTest {

    private Factorial32BitModel factorial32BitModel;

    @Before
    public void setUp() {
        factorial32BitModel = new Factorial32BitModel();
    }

    @Test
    public void test_calculateFactorial_withBaseStep() {
        assertEquals(1, factorial32BitModel.calculateFactorial(0));
    }

    @Test
    public void test_calculateFactorial_withRandomNumber() {
        assertEquals(120, factorial32BitModel.calculateFactorial(5));
    }
}