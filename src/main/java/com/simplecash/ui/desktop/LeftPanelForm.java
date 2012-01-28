package com.simplecash.ui.desktop;

import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;

import javax.swing.*;
import javax.swing.tree.*;

/**
 * The left panel where the action options are.
 * Note that click events need to be registered outside this class,
 * in order to get the action from a user, do
 * <p><code>leftPanelForm.getTree().addTreeSelectionListener(myTreeSelectionListener);</code>
 */
public class LeftPanelForm  {
    private JTree tree;
    private JPanel panel;

    public LeftPanelForm() {
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTree getTree() {
        return tree;
    }

    /**
     * Create the selection tree.
     * Note that in IntelliJ, some settings are overriden in the UI Designer.
     */
    private void createUIComponents() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(
                ResourceBundleFactory.getGeneralBundle().getString("Selection"));

        // Clients
        DefaultMutableTreeNode client = new DefaultMutableTreeNode(
                ResourceBundleFactory.getGeneralBundle().getString("Clients"));
        DefaultMutableTreeNode client_new = new DefaultMutableTreeNode(
                ResourceBundleFactory.getGeneralBundle().getString("New"));
        client.add(client_new);
        DefaultMutableTreeNode client_list = new DefaultMutableTreeNode(
                ResourceBundleFactory.getGeneralBundle().getString("List_verb"));
        client.add(client_list);
        top.add(client);

        // Suppliers
        DefaultMutableTreeNode supplier = new DefaultMutableTreeNode(
                ResourceBundleFactory.getGeneralBundle().getString("Suppliers"));
        DefaultMutableTreeNode supplier_new = new DefaultMutableTreeNode(
                ResourceBundleFactory.getGeneralBundle().getString("New"));
        supplier.add((supplier_new));
        DefaultMutableTreeNode supplier_list = new DefaultMutableTreeNode(
                ResourceBundleFactory.getGeneralBundle().getString("List_verb"));
        supplier.add(supplier_list);
        top.add(supplier);

        // Options
        DefaultMutableTreeNode options = new DefaultMutableTreeNode(
                ResourceBundleFactory.getGeneralBundle().getString("Options"));
        DefaultMutableTreeNode options_interface = new DefaultMutableTreeNode(
                ResourceBundleFactory.getGeneralBundle().getString("Interface"));
        options.add(options_interface);
        top.add(options);

        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }
}
