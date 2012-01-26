package com.simplecash.ui.desktop;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.util.ResourceBundle;

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
                GeneralResourceBundle.getInstance().getString("Selection"));

        // Clients
        DefaultMutableTreeNode client = new DefaultMutableTreeNode(
                GeneralResourceBundle.getInstance().getString("Clients"));
        DefaultMutableTreeNode client_new = new DefaultMutableTreeNode(
                GeneralResourceBundle.getInstance().getString("New"));
        client.add(client_new);
        DefaultMutableTreeNode client_list = new DefaultMutableTreeNode(
                GeneralResourceBundle.getInstance().getString("List_verb"));
        client.add(client_list);
        top.add(client);

        // Suppliers
        DefaultMutableTreeNode supplier = new DefaultMutableTreeNode(
                GeneralResourceBundle.getInstance().getString("Suppliers"));
        DefaultMutableTreeNode supplier_new = new DefaultMutableTreeNode(
                GeneralResourceBundle.getInstance().getString("New"));
        supplier.add((supplier_new));
        DefaultMutableTreeNode supplier_list = new DefaultMutableTreeNode(
                GeneralResourceBundle.getInstance().getString("List_verb"));
        supplier.add(supplier_list);
        top.add(supplier);

        // Options
        DefaultMutableTreeNode options = new DefaultMutableTreeNode(
                GeneralResourceBundle.getInstance().getString("Options"));
        DefaultMutableTreeNode options_interface = new DefaultMutableTreeNode(
                GeneralResourceBundle.getInstance().getString("Interface"));
        options.add(options_interface);
        top.add(options);

        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }
}
