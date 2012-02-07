package com.simplecash.ui.desktop.component.search;

import com.simplecash.ui.desktop.event.ContactSearchEventListener;
import com.simplecash.ui.desktop.event.SearchEvent;
import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;
import javaEventing.EventManager;
import javaEventing.interfaces.GenericEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * Panel that has the search input on top and results on bottom.
 */
public class SearchPanel extends JPanel {

    /**
     * Search options that show above the search input.
     */
    private JPanel searchInputOptionsPanel;
    private SearchInputPanel searchInputPanel;
    /**
     * Results options that shows below the input and above the results.
     */
    private JPanel searchResultsOptionsPanel;
    private JPanel searchResultsPanel;

    /**
     * A random UUID is created for each instance of SearchPanel so that search events' context belongs
     * to the correct panel.
     * <p>This allows multiple instances of the same type of searches to be visible in the UI and EventManager
     * will know which SearchPanel the event belongs to from the context (uuid).
     */
    private final UUID uuid = UUID.randomUUID();
    private final SearchPanel thisSearchPanel = this;  // Used in the ActionListener inner class

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ResourceBundle generalResourceBundle = ResourceBundleFactory.getGeneralBundle();

    public SearchPanel() {
        super(new GridBagLayout());
        setUI();
    }

    public SearchPanel(GenericEventListener eventListener, final Class<? extends SearchEvent> searchEventClass) {
        super(new GridBagLayout());
        setUI();
        registerSearchEventListener(eventListener, searchEventClass);
    }

    public JPanel getSearchInputOptionsPanel() {
        return searchInputOptionsPanel;
    }

    public void setSearchInputOptionsPanel(JPanel searchInputOptionsPanel) {
        this.searchInputOptionsPanel = searchInputOptionsPanel;
        clearUI();
        setUI();
    }

    public SearchInputPanel getSearchInputPanel() {
        return searchInputPanel;
    }

    public void setSearchInputPanel(SearchInputPanel searchInputPanel) {
        this.searchInputPanel = searchInputPanel;
        clearUI();
        setUI();
    }

    public JPanel getSearchResultsOptionsPanel() {
        return searchResultsOptionsPanel;
    }

    public void setSearchResultsOptionsPanel(JPanel searchResultsOptionsPanel) {
        this.searchResultsOptionsPanel = searchResultsOptionsPanel;
        clearUI();
        setUI();
    }

    public JPanel getSearchResultsPanel() {
        return searchResultsPanel;
    }

    public void setSearchResultsPanel(JPanel searchResultsPanel) {
        this.searchResultsPanel = searchResultsPanel;
        clearUI();
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

    public void registerSearchEventListener(
            GenericEventListener eventListener, final Class<? extends SearchEvent> searchEventClass) {
        EventManager.registerEventListener(uuid, eventListener, searchEventClass);

        searchInputPanel.getButtonSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    EventManager.triggerEvent(thisSearchPanel, searchEventClass.newInstance());
                } catch (InstantiationException ex) {
                    logger.error("Error triggering search event.", ex);
                } catch (IllegalAccessException ex) {
                    logger.error("Error triggering search event.", ex);
                }
            }
        });
    }

    public void unregisterEventListeners() {
        EventManager.unregisterAllEventListenersForContext(uuid);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        unregisterEventListeners();
    }
}
