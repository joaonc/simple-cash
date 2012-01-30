package com.simplecash.ui.desktop.contact;

import com.simplecash.object.Address;
import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Panel that contains all the addresses.
 */
public class AddressesPanel extends JPanel {

    private Set<Address> addresses;
    boolean editable;

    private final ResourceBundle generalResourceBundle = ResourceBundleFactory.getGeneralBundle();

    /**
     * Constraints to use when adding a AddressPanel.
     * gridy needs to be changed.
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
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
        setUI();
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        setUI();
    }

    private void setUI() {
        if (addresses == null) {
            addresses = new LinkedHashSet<Address>();
        }

        int gridy = 0;
        GridBagConstraints c;
        for (Address address : addresses) {
            AddressPanel addressPanel = new AddressPanel(editable, address);
            c = (GridBagConstraints)addressPanelGridBagConstraints.clone();
            c.gridy = gridy++;
            add(addressPanel, c);
        }
    }
}
