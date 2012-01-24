package com.simplecash.ui.desktop.event;

import javaEventing.EventObject;

/**
 * Event triggered when the user changes the look and feel of the UI.
 */
public class LookAndFeelChangeEvent extends EventObject {

    public LookAndFeelChangeEvent(Object payload) {
        super(payload);
    }
}
