package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.Button;

class ButtonTests {
    public void isButtonExist (Button button) {
        // Check that the button
        assertNotNull(button);
    }
    public void compareContentOfButtons (String message, Button button) {
        assertEquals(message, button.getText().toString());
    }

}