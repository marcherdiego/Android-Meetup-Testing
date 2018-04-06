package com.mercadolibre.android.androidmeetup.testing.ui.mvp.presenter;

import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.Factorial32BitModel;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.Factorial32BitView;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.Factorial32BitView.FactorialButtonClickEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Factorial32BitPresenterTest {

    private Factorial32BitPresenter presenter;

    @Mock Factorial32BitView view;
    @Mock Factorial32BitModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new Factorial32BitPresenter(view, model);
    }

    @Test
    public void test_onFactorialButtonClick_shouldForwardCalculationToModel() {
        FactorialButtonClickEvent event = new FactorialButtonClickEvent("6");
        presenter.onFactorialButtonClick(event);
        verify(model).calculateFactorial(6);
    }

    @Test
    public void test_onFactorialButtonClick_shouldForwardCalculationResultToView() {
        FactorialButtonClickEvent event = new FactorialButtonClickEvent("6");
        when(model.calculateFactorial(6)).thenReturn(720);
        presenter.onFactorialButtonClick(event);
        verify(view).showFactorialResult(6, 720);
    }

    @Test(expected = NumberFormatException.class)
    public void test_onFactorialButtonClick_shouldThrowNumberFormatException() {
        FactorialButtonClickEvent event = new FactorialButtonClickEvent("");
        presenter.onFactorialButtonClick(event);
    }
}