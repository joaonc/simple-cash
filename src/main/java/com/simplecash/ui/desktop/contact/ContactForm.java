package com.simplecash.ui.desktop.contact;

import com.simplecash.object.ContactInfo;
import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.util.Set;

/**
 *
 */
public class ContactForm {
    private JPanel mainPanel;
    private JButton buttonOk;
    private JButton buttonCancel;
    private JPanel contactInfosPanel;
    private JTextArea textAreaTitle;
    private JScrollPane scrollPane;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ResourceBundle generalResourceBundle = ResourceBundleFactory.getGeneralBundle();

    public ContactForm() {
        super();
        initialize();
    }

    public ContactForm(Set<ContactInfo> contactInfos) {
        super();
        setContactInfos(contactInfos);
        initialize();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Set<ContactInfo> getContactInfos() {
        return ((ContactInfosPanel)contactInfosPanel).getContactInfos();
    }

    public void setContactInfos(Set<ContactInfo> contactInfos) {
        ((ContactInfosPanel)contactInfosPanel).setContactInfos(contactInfos);
    }

    protected void initialize() {

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

        // ContactInfosPanel properties
//        contactInfosPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    /**
     * Custom creation of UI components.
     * Called in super's constructor.
     */
    private void createUIComponents() {
        contactInfosPanel = new ContactInfosPanel();
    }

    public void actionPerformed_buttonOk_Click(ActionEvent e) {

    }

    public void actionPerformed_buttonCancel_Click(ActionEvent e) {

    }
}
