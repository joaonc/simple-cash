package com.simplecash.ui.desktop.component.search;

import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * Panel that has the search input text field and Search/Clear buttons.
 */
public class SearchInputPanel extends JPanel {
    
    private JTextField textFieldSearch;
    private JButton buttonSearch;
    private JButton buttonClear;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ResourceBundle generalResourceBundle = ResourceBundleFactory.getGeneralBundle();

    public SearchInputPanel() {
        super(new GridBagLayout());
        setUI();
    }

    private void setUI() {
        GridBagConstraints c;

        // Search text field
        textFieldSearch = new JTextField();
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textFieldSearch, c);
        
        // Search button
        buttonSearch = new JButton(generalResourceBundle.getString("Search_verb"));
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        add(buttonSearch, c);

        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionPerformed_buttonSearch_Click(e);
            }
        });

        // Clear button
        buttonClear = new JButton(generalResourceBundle.getString("Clear"));
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        add(buttonSearch, c);

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionPerformed_buttonClear_Click(e);
            }
        });
    }

    public void actionPerformed_buttonClear_Click(ActionEvent e) {
        logger.debug("Clear search button clicked.");

        textFieldSearch.setText("");
    }

    public void actionPerformed_buttonSearch_Click(ActionEvent e) {
        logger.debug("Search search button clicked.");
    }
}
