package com.simplecash.ui.desktop.component.contact;

import com.jjcommon.ui.desktop.ComponentUtils;
import com.simplecash.object.Address;
import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Panel that contains all the addresses.
 */
public class AddressesPanel extends JPanel {

    private Set<Address> addresses;
    boolean editable;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ResourceBundle generalResourceBundle = ResourceBundleFactory.getGeneralBundle();
    private final ResourceBundle messagesResourceBundle = ResourceBundleFactory.getMessagesBundle();

    /**
     * Constraints to use when adding a AddressPanel.
     * <br><code>gridy</code> needs to be changed.
     */
    private final GridBagConstraints addressPanelGridBagConstraints = new GridBagConstraints(
            0, 0, 1, 1, 0.5, 0,
            GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL,
            new Insets(4, 5, 0, 2), 0, 0);

    public AddressesPanel(boolean editable) {
        super(new GridBagLayout());
        this.editable = editable;
        setUI();
    }

    public AddressesPanel(boolean editable, Set<Address> addresses) {
        super(new GridBagLayout());
        this.addresses = addresses;
        this.editable = editable;
        setUI();
    }

    public Set<Address> getAddresses() {
        refreshFromUI();
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
        clearUI ();
        setUI();
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        setUI();
    }

    /**
     * Removes all the UI components.
     */
    private void clearUI() {
        while (getComponents().length > 0) {
            remove(0);
        }
    }

    /**
     * Sets all the UI components from the object represented.
     */
    private void setUI() {
        if (addresses == null) {
            addresses = new LinkedHashSet<Address>();
        }

        int gridy = 0;
        GridBagConstraints c;

        // Label that mentions the contact info type
        JLabel labelType = new JLabel(generalResourceBundle.getString("Addresses"));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = gridy++;
        c.insets = new Insets(2, 0, 4, 0);
        c.anchor = GridBagConstraints.LINE_START;
        add(labelType, c);

        // All addresses
        for (Address address : addresses) {
            AddressPanel addressPanel = new AddressPanel(editable, address);
            c = (GridBagConstraints)addressPanelGridBagConstraints.clone();
            c.gridy = gridy++;
            add(addressPanel, c);

            addressPanel.getButtonDelete().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actionPerformed_buttonAddressDelete_Click(e);
                }
            });
        }

        // Add button
        JButton buttonAdd = new JButton("+ " + generalResourceBundle.getString("Address"));
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = gridy;
        c.insets = new Insets(4, 0, 2, 2);
        c.anchor = GridBagConstraints.LINE_END;
        add(buttonAdd, c);

        buttonAdd.setActionCommand("Address");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionPerformed_buttonContactInfoAdd_Click(e);
            }
        });

        validate();
    }

    public void refreshFromUI() {
        // Refresh with values from UI
        // This panel is made of just AddressPanel panels
        for(Component component : ComponentUtils.filterByClass(getComponents(), AddressPanel.class)) {
            AddressPanel addressPanel = (AddressPanel)component;
            addressPanel.refreshFromUI();
        }
    }

    public void actionPerformed_buttonContactInfoAdd_Click(ActionEvent e) {
        logger.debug("Add button clicked: " + e.getActionCommand());

        JButton button = (JButton)e.getSource();
    }

    public void actionPerformed_buttonAddressDelete_Click(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        AddressPanel addressPanel = (AddressPanel)button.getParent();
        Address address = addressPanel.getAddress();

        String message = String.format(messagesResourceBundle.getString("DeleteAddressConfirmation"), address.getName());
        if (JOptionPane.showConfirmDialog(
                null, message, generalResourceBundle.getString("Confirmation"), JOptionPane.YES_NO_OPTION) ==
                JOptionPane.YES_OPTION) {
            logger.debug("Deleting address: " + address.toString());

            addresses.remove(address);
            remove(addressPanel);
            clearUI();
            setUI();
        }
    }
}
