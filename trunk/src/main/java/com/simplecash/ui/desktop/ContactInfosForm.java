package com.simplecash.ui.desktop;

import com.simplecash.object.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 *
 */
public class ContactInfosForm {
    private JPanel mainPanel;
    private JButton buttonOk;
    private JButton buttonCancel;
    private JPanel contactInfosPanel;
    private JTextArea textAreaTitle;
    private JScrollPane scrollPane;

    private Set<ContactInfo> contactInfos;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ResourceBundle generalResourceBundle = GeneralResourceBundle.getInstance();

    public ContactInfosForm() {
        super();
        initialize();
    }

    public ContactInfosForm(Set<ContactInfo> contactInfos) {
        super();
        this.contactInfos = contactInfos;
        initialize();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Set<ContactInfo> getContactInfos() {
        return contactInfos;
    }

    public void setContactInfos(Set<ContactInfo> contactInfos) {
        this.contactInfos = contactInfos;
        updateUi();
    }

    protected void initialize() {
        if (contactInfos == null) {
            contactInfos = new LinkedHashSet<ContactInfo>();
        }

        // Event Listeners
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionPerformed_buttonOk_Click(e);
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionPerformed_buttonCancel_Click(e);
            }
        });

        // UI initialization
        textAreaTitle.setOpaque(false);
        textAreaTitle.setText("NOVO");

        // ContactInfos panel properties
        //contactInfosPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        updateUi();
    }

    public void cleanUi() {
    }

    public void updateUi() {
        if (contactInfos == null) {
            // TODO: Clean UI
            return;
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
            JLabel labelType = new JLabel(
                    generalResourceBundle.getString(contactInfoType.toString()));
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = gridy++;
            c.insets = new Insets(2, 0, 4, 0);
            c.anchor = GridBagConstraints.LINE_START;
            contactInfosPanel.add(labelType, c);

            // All the contact information for this type
            for (ContactInfo contactInfo : contactInfosOfType) {
                ContactInfoForm ciForm = new ContactInfoForm(true, contactInfo);
                c = new GridBagConstraints();
                c.gridx = 0;
                c.gridy = gridy++;
                c.weightx = 0.5;
                c.insets = new Insets(4, 5, 0, 0);
                c.fill = GridBagConstraints.HORIZONTAL;
                c.anchor = GridBagConstraints.LINE_START;
                contactInfosPanel.add(ciForm.getPanel(), c);
            }

            // Add button for each ContactInfoType
            JButton buttonAdd = new JButton("+ " + generalResourceBundle.getString(contactInfoType.toString()));
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = gridy++;
            c.insets = new Insets(4, 0, 2, 0);
            c.anchor = GridBagConstraints.LINE_END;
            contactInfosPanel.add(buttonAdd, c);

            buttonAdd.setActionCommand(contactInfoType.toString());
            buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actionPerformed_buttonContactInfoAdd_Click(e);
                }
            });
        }

        // Bottom box that claims all the remaining vertical space,
        // Basically acting as a vertical spacer at the bottom, pushing everything else up.
        Box bottomBox = Box.createHorizontalBox();
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = gridy++;
        c.weighty = 1.0;  // Request any extra vertical space
        c.fill = GridBagConstraints.VERTICAL;
        contactInfosPanel.add(bottomBox, c);

        contactInfosPanel.validate();
    }

    public void actionPerformed_buttonOk_Click(ActionEvent e) {

    }

    public void actionPerformed_buttonCancel_Click(ActionEvent e) {

    }

    public void actionPerformed_buttonContactInfoAdd_Click(ActionEvent e) {
        logger.debug("Add button clicked: " + e.getActionCommand());
    }

    /**
     * Custom creation of UI components.
     * Called before the constructor.
     */
    private void createUIComponents() {
    }
}
