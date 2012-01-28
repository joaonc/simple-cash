package com.simplecash.ui.desktop.resourcebundle;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 */
public class ResourceBundleFactory {

    private static final ResourceBundle generalBundle =
            PropertyResourceBundle.getBundle(ResourceBundleFactory.class.getPackage().getName() + ".General");

    private static final ResourceBundle messagesBundle =
            PropertyResourceBundle.getBundle(ResourceBundleFactory.class.getPackage().getName() + ".Messages");

    public static ResourceBundle getGeneralBundle() {
        return generalBundle;
    }

    public static ResourceBundle getMessagesBundle() {
        return messagesBundle;
    }
}
