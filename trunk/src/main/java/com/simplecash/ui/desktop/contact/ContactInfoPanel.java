package com.simplecash.ui.desktop.contact;

import com.simplecash.object.ContactInfo;

import javax.swing.*;
import java.awt.*;

/**
 * Panel that contains the blob of contact information, ex. Email, Telephone, etc.
 */
public class ContactInfoPanel extends JPanel {

    private JLabel labelKey;
    private JTextField textFieldValue;
    private JButton buttonDelete;

    boolean editable;
    ContactInfo contactInfo;

    public ContactInfoPanel(boolean editable, ContactInfo contactInfo) {
        super(new GridBagLayout());
        this.editable = editable;
        this.contactInfo = contactInfo;
        initialize();
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
        refreshUI();
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        refreshUI();
    }

    public JLabel getLabelKey() {
        return labelKey;
    }

    public JTextField getTextFieldValue() {
        return textFieldValue;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }
    
    private void initialize() {
        GridBagConstraints c;
        
        labelKey = new JLabel();
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        add(labelKey, c);
        
        textFieldValue = new JTextField();
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 2, 0, 2);
        add(textFieldValue, c);
        
        buttonDelete = new JButton("x");
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        add(buttonDelete, c);
        
        refreshUI();
    }

    public void refreshUI() {
        if (contactInfo == null) {
            contactInfo = new ContactInfo();
        }
        
        labelKey.setText(contactInfo.getType());
        textFieldValue.setText(contactInfo.getValue());
        textFieldValue.setEditable(editable);
        
        buttonDelete.setVisible(editable);
    }
}
