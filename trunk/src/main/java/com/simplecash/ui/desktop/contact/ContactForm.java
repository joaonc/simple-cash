package com.simplecash.ui.desktop.contact;

import com.simplecash.object.Contact;
import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 *
 */
public class ContactForm {
    private JPanel mainPanel;
    private JButton buttonOk;
    private JButton buttonCancel;
    private JTextArea textAreaTitle;
    private JScrollPane scrollPane;
    private JPanel contactPanel;
    private JPanel contactInfosPanel;
    private JPanel addressesPanel;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ResourceBundle generalResourceBundle = ResourceBundleFactory.getGeneralBundle();

    private Contact contact;
    
    public ContactForm() {
        super();
        setUI();
    }

    public ContactForm(Contact contact) {
        super();
        this.contact = contact;
        setUI();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
        setUI();
    }

    protected void setUI() {
        ((ContactInfosPanel)contactInfosPanel).setContactInfos(contact.getContactInfos());
        ((AddressesPanel)addressesPanel).setAddresses(contact.getAddresses());

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
        addressesPanel = new AddressesPanel(false);
    }

    public void actionPerformed_buttonOk_Click(ActionEvent e) {

    }

    public void actionPerformed_buttonCancel_Click(ActionEvent e) {

    }
}
