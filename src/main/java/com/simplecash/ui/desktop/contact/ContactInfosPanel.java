package com.simplecash.ui.desktop.contact;

import com.simplecash.object.ContactInfo;
import com.simplecash.object.ContactInfoType;
import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.slf4j.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Panel that contains the ContactInfo Set.
 * Constituted of several ContactInfoPanel (singular Info).
 */
public class ContactInfosPanel extends JPanel {

    private Set<ContactInfo> contactInfos;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ResourceBundle generalResourceBundle = ResourceBundleFactory.getGeneralBundle();
    private final ResourceBundle messagesResourceBundle = ResourceBundleFactory.getMessagesBundle();

    /**
     * Constraints to use when adding a ContactInfoPanel.
     * gridy needs to be changed.
     */
    private final GridBagConstraints contactInfoPanelGridBagConstraints = new GridBagConstraints(
            0, 0, 1, 1, 0.5, 0,
            GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL,
            new Insets(4, 5, 0, 2), 0, 0);

    public ContactInfosPanel() {
        super(new GridBagLayout());
        setUI();
    }

    public ContactInfosPanel(Set<ContactInfo> contactInfos) {
        super(new GridBagLayout());
        this.contactInfos = contactInfos;
        setUI();
    }

    public Set<ContactInfo> getContactInfos() {
        return contactInfos;
    }

    public void setContactInfos(Set<ContactInfo> contactInfos) {
        this.contactInfos = contactInfos;
        clearUI();
        setUI();
    }

    /**
     * Removes all the UI components.
     */
    private void clearUI () {
        while (getComponents().length > 0) {
            remove(0);
        }
        validate();
        repaint();
    }

    /**
     * Sets all the UI components from the object represented.
     */
    private void setUI() {
        if (contactInfos == null) {
            contactInfos = new LinkedHashSet<ContactInfo>();
        }

        int gridy = 0;
        GridBagConstraints c;
        for(ContactInfoType.Type contactInfoType : ContactInfoType.Type.values()) {
            // Get all by type
            final ContactInfoType.Type contactInfoTypeFinal = contactInfoType;
            Collection<ContactInfo> contactInfosOfType = CollectionUtils.select(contactInfos, new Predicate() {
                @Override
                public boolean evaluate(Object o) {
                    return ((ContactInfo) o).getContactInfoType().equals(contactInfoTypeFinal);
                }
            });

            // Label that mentions the contact info type
            JLabel labelType = new JLabel(generalResourceBundle.getString(contactInfoType.toString()));
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = gridy++;
            c.insets = new Insets(2, 0, 4, 0);
            c.anchor = GridBagConstraints.LINE_START;
            add(labelType, c);

            // All the contact information for this type
            c = (GridBagConstraints)contactInfoPanelGridBagConstraints.clone();
            for (ContactInfo contactInfo : contactInfosOfType) {
                ContactInfoPanel ciPanel = new ContactInfoPanel(true, contactInfo);
                c.gridx = 0;
                c.gridy = gridy++;
                add(ciPanel, c);

                ciPanel.getButtonDelete().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actionPerformed_buttonContactInfoDelete_Click(e);
                    }
                });
            }

            // Add button for each ContactInfoType
            JButton buttonAdd = new JButton("+ " + generalResourceBundle.getString(contactInfoType.toString()));
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = gridy++;
            c.insets = new Insets(4, 0, 2, 2);
            c.anchor = GridBagConstraints.LINE_END;
            add(buttonAdd, c);

            buttonAdd.setActionCommand(contactInfoType.toString());
            buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actionPerformed_buttonContactInfoAdd_Click(e);
                }
            });
        }

        // Bottom component that claims all the remaining vertical space.
        // Acts as a vertical spacer at the bottom, pushing everything else up.
        Component vSpacer = Box.createVerticalGlue();
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = gridy++;
        c.weighty = 1.0;  // Request any extra vertical space
        c.fill = GridBagConstraints.VERTICAL;
        add(vSpacer, c);

        // Bottom component that claims all the horizontal space.
        // Needed for when there are no ContactInfo elements,
        // to force the remaining elements to be correctly distributed horizontally,
        // instead of being aligned in the center, which is the default for GridBagLayout.
        Component hSpacer = Box.createHorizontalGlue();
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = gridy;
        c.weightx = 1.0;  // Request any extra horizontal space
        c.fill = GridBagConstraints.HORIZONTAL;
        add(hSpacer, c);

        validate();
    }

    public void actionPerformed_buttonContactInfoDelete_Click(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        ContactInfoPanel contactInfoPanel = (ContactInfoPanel)button.getParent();
        ContactInfo contactInfo = contactInfoPanel.getContactInfo();
        
        String message = String.format(messagesResourceBundle.getString("DeleteContactInfoConfirmation"),
                generalResourceBundle.getString(contactInfo.getContactInfoType().toString()), contactInfo.getValue());
        if (JOptionPane.showConfirmDialog(
                null, message, generalResourceBundle.getString("Confirmation"), JOptionPane.YES_NO_OPTION) ==
                JOptionPane.YES_OPTION) {
            logger.debug("Deleting contact information: " + contactInfo.toString());

            contactInfos.remove(contactInfo);
            remove(contactInfoPanel);
            clearUI();
            setUI();
        }
    }

    public void actionPerformed_buttonContactInfoAdd_Click(ActionEvent e) {
        logger.debug("Add button clicked: " + e.getActionCommand());

        ContactInfoType.Type contactInfoType = Enum.valueOf(ContactInfoType.Type.class, e.getActionCommand());
        JButton button = (JButton)e.getSource();
    }
}
