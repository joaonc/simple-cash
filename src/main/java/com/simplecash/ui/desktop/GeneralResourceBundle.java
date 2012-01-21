package com.simplecash.ui.desktop;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 */
public class GeneralResourceBundle {
    private static final ResourceBundle resourceBundle =
            PropertyResourceBundle.getBundle(GeneralResourceBundle.class.getPackage().getName() + ".General");

    public static ResourceBundle getInstance() {
        return resourceBundle;
    }
}
