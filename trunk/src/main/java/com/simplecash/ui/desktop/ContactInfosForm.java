package com.simplecash.ui.desktop;

import com.simplecash.object.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Set;

/**
 *
 */
public class ContactInfosForm {
    private JPanel mainPanel;
    private JButton buttonOk;
    private JButton buttonCancel;
    private JPanel contactInfosPanel;

    private Set<ContactInfo> contactInfos;
    private final ResourceBundle generalResourceBundle = GeneralResourceBundle.getInstance();

    public ContactInfosForm() {
        super();
        contactInfos = null;
    }

    public ContactInfosForm(Set<ContactInfo> contactInfos) {
        super();
        this.contactInfos = contactInfos;
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

    public void cleanUi() {
    }

    public void updateUi() {
        if (contactInfos == null) {
            // TODO: Clean UI
            return;
        }

        for(ContactInfoType.Type contactInfoType : ContactInfoType.Type.values()) {
            // Get all by type
            final ContactInfoType.Type contactInfoTypeFinal = contactInfoType;
            Collection<ContactInfo> contactInfosOfType = CollectionUtils.select(contactInfos, new Predicate() {
                @Override
                public boolean evaluate(Object o) {
                    return ((ContactInfo) o).getContactInfoType().equals(contactInfoTypeFinal);
                }
            });
            
            for (ContactInfo contactInfo : contactInfosOfType) {
                ContactInfoForm ciForm = new ContactInfoForm(true, contactInfo.getType(), contactInfo.getValue());
                contactInfosPanel.add(String.format("%s", contactInfo.getId()), ciForm.getPanel());
            }
        }
    }

    public void actionPerformed_buttonOk_Click(ActionEvent e) {

    }

    public void actionPerformed_buttonCancel_Click(ActionEvent e) {

    }
}
