package com.simplecash.ui.desktop;

import javax.swing.*;
import javax.swing.tree.*;
import java.util.ResourceBundle;

/**
 *
 */
public class LeftPanelForm {
    private JTree tree;
    private JPanel panel;

    public LeftPanelForm() {
    }

    public JPanel getPanel() {
        return panel;
    }

    /**
     * Create the selection tree.
     * Note that in IntelliJ, some settings are overriden in the UI Designer.
     */
    private void createUIComponents() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(
                GeneralResourceBundle.getInstance().getString("Selection"));

        DefaultMutableTreeNode clientTreeNode = new DefaultMutableTreeNode(
                GeneralResourceBundle.getInstance().getString("Clients"));
        top.add(clientTreeNode);

        DefaultMutableTreeNode supplierTreeNode = new DefaultMutableTreeNode(
                GeneralResourceBundle.getInstance().getString("Clients"));
        top.add(supplierTreeNode);

        tree = new JTree(top);
    }
}
