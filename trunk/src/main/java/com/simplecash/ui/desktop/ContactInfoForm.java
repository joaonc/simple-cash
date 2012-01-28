package com.simplecash.ui.desktop;

import com.simplecash.object.ContactInfo;

import javax.swing.*;

/**
 *
 */
public class ContactInfoForm {
    private JPanel panel;
    private JLabel labelKey;
    private JTextField textFieldValue;
    private JButton buttonDelete;

    ContactInfo contactInfo;

    public ContactInfoForm(boolean editable, ContactInfo contactInfo) {
        textFieldValue.setEditable(editable);
        setContactInfo(contactInfo);
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

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
        labelKey.setText(contactInfo.getType());
        textFieldValue.setText(contactInfo.getValue());
    }

    public ContactInfo getContactInfo() {
        contactInfo.setType(labelKey.getText());
        contactInfo.setValue(textFieldValue.getText());

        return contactInfo;
    }
}
