package com.simplecash.ui.desktop.component.search;

import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Panel that has the search input on top and results on bottom.
 */
public class SearchPanel extends JPanel {

    private SearchInputPanel searchInputPanel;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ResourceBundle generalResourceBundle = ResourceBundleFactory.getGeneralBundle();

    public SearchPanel() {
        super(new GridBagLayout());
        setUI();
    }

    private void setUI() {
        GridBagConstraints c;

        // Search input
        searchInputPanel = new SearchInputPanel();
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(searchInputPanel, c);

        validate();
    }
}
