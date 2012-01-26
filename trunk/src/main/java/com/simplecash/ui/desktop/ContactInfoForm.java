package com.simplecash.ui.desktop;

import javax.swing.*;

/**
 *
 */
public class ContactInfoForm {
    private JPanel panel;
    private JLabel labelKey;
    private JTextField textFieldValue;

    public ContactInfoForm(boolean editable, String key, String value) {
        labelKey.setText(key);
        textFieldValue.setText(value);
        textFieldValue.setEditable(editable);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTextFieldValue() {
        return textFieldValue;
    }

    public JLabel getLabelKey() {
        return labelKey;
    }
}
