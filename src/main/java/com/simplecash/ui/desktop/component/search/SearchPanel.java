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
        c.insets = new Insets(2, 2, 2, 2);
        add(searchInputPanel, c);

        // Horizontal spacer to force panel to expand
        Component hSpacer = Box.createHorizontalGlue();
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(hSpacer, c);

        // Vertical spacer that claims all the remaining vertical space.
        Component vSpacer = Box.createVerticalGlue();
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 1.0;  // Request any extra vertical space
        c.fill = GridBagConstraints.VERTICAL;
        add(vSpacer, c);

        validate();
    }
}
