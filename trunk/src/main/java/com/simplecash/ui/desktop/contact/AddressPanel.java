package com.simplecash.ui.desktop.contact;

import com.simplecash.object.Address;

import javax.swing.*;
import java.awt.*;

/**
 * Panel that contains an address.
 */
public class AddressPanel extends JPanel {

    private JLabel labelKey;
    private JTextField textFieldAddress1;
    private JTextField textFieldAddress2;
    private JTextField textFieldAddress3;
    private JTextField textFieldCounty;
    private JTextField textFieldState;
    private JTextField textFieldPostalCode;
    private JTextField textFieldRegion;
    private JTextField textFieldCountry;
    private JTextArea textAreaNotes;

    boolean editable;
    Address address;

    private final GridBagConstraints textFieldConstraints = new GridBagConstraints(
            0, 0, 1, 1, 0, 0,
            GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0);

    public AddressPanel(boolean editable) {
        super(new GridBagLayout());
        this.editable = editable;
        setUI();
    }

    public AddressPanel(boolean editable, Address address) {
        super(new GridBagLayout());
        this.editable = editable;
        this.address = address;
        setUI();
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    private void setUI() {
        if (address == null) {
            address = new Address();
        }

        GridBagConstraints c;
        int gridy = 0;

        textFieldAddress1 = new JTextField(address.getAddress1());
        c = (GridBagConstraints)textFieldConstraints.clone();
        c.gridy = gridy++;
        add(textFieldAddress1, c);
        
        textFieldAddress2 = new JTextField(address.getAddress2());
        c = (GridBagConstraints)textFieldConstraints.clone();
        c.gridy = gridy++;
        add(textFieldAddress2, c);
        
        textFieldAddress3 = new JTextField();
        c = (GridBagConstraints)textFieldConstraints.clone();
        c.gridy = gridy++;
        add(textFieldAddress3, c);
        
        textFieldCounty = new JTextField(address.getCounty());
        c = (GridBagConstraints)textFieldConstraints.clone();
        c.gridy = gridy++;
        add(textFieldCounty, c);

        textFieldPostalCode = new JTextField(address.getPostalCode());
        c = (GridBagConstraints)textFieldConstraints.clone();
        c.gridy = gridy++;
        add(textFieldPostalCode, c);

        textFieldState = new JTextField(address.getState());
        c = (GridBagConstraints)textFieldConstraints.clone();
        c.gridy = gridy++;
        add(textFieldState, c);

        textAreaNotes = new JTextArea(address.getNotes());
        c = (GridBagConstraints)textFieldConstraints.clone();
        c.gridy = gridy;
        add(textAreaNotes, c);
    }
}
