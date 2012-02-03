package com.simplecash.ui.desktop.component.contact;

import com.simplecash.object.Address;
import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

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

    private final ResourceBundle generalResourceBundle = ResourceBundleFactory.getGeneralBundle();

    /**
     * The amount of columns spanned horizontally.
     */
    private final int gridWidth = 4;

    /**
     * Constraints to use when adding a JTextField.
     * <br><code>gridy</code> needs to be changed.
     */
    private final GridBagConstraints textFieldConstraints = new GridBagConstraints(
            0, 0, gridWidth, 1, 0.5, 0,
            GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL,
            new Insets(5, 0, 0, 2), 0, 0);

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
        refreshFromUI();
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

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = gridy;
        c.anchor = GridBagConstraints.LINE_START;
        add(new JLabel(generalResourceBundle.getString("County")), c);

        textFieldCounty = new JTextField(address.getCounty());
        c = (GridBagConstraints)textFieldConstraints.clone();
        c.gridx = 1;
        c.gridy = gridy++;
        c.gridwidth = gridWidth - 1;
        add(textFieldCounty, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = gridy;
        c.anchor = GridBagConstraints.LINE_START;
        add(new JLabel(generalResourceBundle.getString("PostalCode")), c);

        textFieldPostalCode = new JTextField(address.getPostalCode());
        c = (GridBagConstraints)textFieldConstraints.clone();
        c.gridx = 1;
        c.gridy = gridy;
        c.gridwidth = 1;
        c.weightx = 0.25;
        add(textFieldPostalCode, c);

        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = gridy;
        c.anchor = GridBagConstraints.LINE_START;
        add(new JLabel(generalResourceBundle.getString("State")), c);

        textFieldState = new JTextField(address.getState());
        c = (GridBagConstraints)textFieldConstraints.clone();
        c.gridx = 3;
        c.gridy = gridy++;
        c.gridwidth = 1;
        c.weightx = 0.75;
        add(textFieldState, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = gridy;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel(generalResourceBundle.getString("Note")), c);

        textAreaNotes = new JTextArea(address.getNotes());
        c = (GridBagConstraints)textFieldConstraints.clone();
        c.gridx = 1;
        c.gridy = gridy;
        c.gridwidth = gridWidth - 1;
        add(textAreaNotes, c);
    }

    public void refreshFromUI() {
        address.setAddress1(textFieldAddress1.getText());
        address.setAddress2(textFieldAddress2.getText());
        address.setCounty(textFieldCounty.getText());
        address.setState(textFieldState.getText());
        address.setPostalCode(textFieldPostalCode.getText());
//        address.setRegion(textFieldRegion.getText());
//        address.setCountry(textFieldCountry.getText());
        address.setNotes(textAreaNotes.getText());
    }
}
