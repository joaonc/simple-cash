package com.simplecash.ui.desktop.options;

import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;

import javax.swing.*;
import java.util.ResourceBundle;

/**
 *
 */
public class AboutForm {
    private JPanel panel;
    private JTextArea textArea;

    private final ResourceBundle generalResourceBundle = ResourceBundleFactory.getGeneralBundle();

    public AboutForm() {
        textArea.setOpaque(false);
        textArea.append("    Simple Cash\n    ");
        textArea.append(generalResourceBundle.getString("Version") + " 1.0");
    }

    public JPanel getPanel() {
        return panel;
    }
}
