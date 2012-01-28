package com.simplecash.ui.desktop;

import com.simplecash.ui.desktop.resourcebundle.ResourceBundleFactory;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * The left panel where the action options are.
 * Note that click events need to be registered outside this class,
 * in order to get the action from a user, do
 * <p><code>leftPanelForm.getTree().addTreeSelectionListener(myTreeSelectionListener);</code>
 */
public class LeftPanel extends JPanel {
    private JTree tree;

    private final ResourceBundle generalResourceBundle = ResourceBundleFactory.getGeneralBundle();

    public LeftPanel() {
        super(new GridBagLayout());
        initialize();
    }

    public JTree getTree() {
        return tree;
    }

    /**
     * Create the selection tree.
     */
    private void initialize() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(
                generalResourceBundle.getString("Selection"));

        // Main page
        DefaultMutableTreeNode main = new DefaultMutableTreeNode(
                generalResourceBundle.getString("MainPage"));
        top.add(main);

        // Clients
        DefaultMutableTreeNode client = new DefaultMutableTreeNode(
                generalResourceBundle.getString("Clients"));
        DefaultMutableTreeNode client_new = new DefaultMutableTreeNode(
                generalResourceBundle.getString("New"));
        client.add(client_new);
        DefaultMutableTreeNode client_list = new DefaultMutableTreeNode(
                generalResourceBundle.getString("List_verb"));
        client.add(client_list);
        top.add(client);

        // Suppliers
        DefaultMutableTreeNode supplier = new DefaultMutableTreeNode(
                generalResourceBundle.getString("Suppliers"));
        DefaultMutableTreeNode supplier_new = new DefaultMutableTreeNode(
                generalResourceBundle.getString("New"));
        supplier.add((supplier_new));
        DefaultMutableTreeNode supplier_list = new DefaultMutableTreeNode(
                generalResourceBundle.getString("List_verb"));
        supplier.add(supplier_list);
        top.add(supplier);

        // Options
        DefaultMutableTreeNode options = new DefaultMutableTreeNode(
                generalResourceBundle.getString("Options"));
        DefaultMutableTreeNode options_interface = new DefaultMutableTreeNode(
                generalResourceBundle.getString("Interface"));
        options.add(options_interface);
        top.add(options);

        tree = new JTree(top);
        tree.setEditable(false);
        tree.setOpaque(false);
        tree.setRootVisible(false);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(2, 1, 0, 0);
        add(tree, c);

        // Bottom component that claims all the remaining vertical space.
        // Acts as a vertical spacer at the bottom, pushing everything else up.
        Component vSpacer = Box.createVerticalGlue();
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 1.0;  // Request any extra vertical space
        c.fill = GridBagConstraints.VERTICAL;
        add(vSpacer, c);
        
        Component hSpacer = Box.createHorizontalGlue();
        c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 1;
        c.gridheight = 2;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(hSpacer, c);

        // Panel properties
        setBackground(Color.WHITE);
    }
}
