package com.simplecash.ui.desktop;

import javax.swing.*;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 *
 */
public class WelcomeForm {
    private JPanel panel;
    private JTextArea textArea;

    private final ResourceBundle generalResourceBundle = GeneralResourceBundle.getInstance();

    public WelcomeForm() {
        textArea.setOpaque(false);
        textArea.append("    Simple Cash\n    ");
        textArea.append(generalResourceBundle.getString("Version") + " 1.0");
    }

    public JPanel getPanel() {
        return panel;
    }
}
