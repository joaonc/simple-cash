package com.simplecash.ui.desktop.main;

import com.simplecash.dal.DatabaseManagerDAO;

import com.simplecash.ui.desktop.*;
import org.slf4j.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class SimpleCashDialog extends JDialog implements ActionListener {
    private JPanel contentPane;
    private JSplitPane splitPane;

    final Logger logger = LoggerFactory.getLogger(SimpleCashDialog.class);
    private final ResourceBundle simpleCashDialogResourceBundle =
            PropertyResourceBundle.getBundle(SimpleCashDialog.class.getCanonicalName());
    private final ResourceBundle generalResourceBundle = GeneralResourceBundle.getInstance();

    public SimpleCashDialog() {
        setContentPane(contentPane);
        setModal(true);
        createMenu();

        LeftPanelForm form = new LeftPanelForm();
        splitPane.setLeftComponent(form.getPanel());
    }

    /**
     * Create the menu for the dialog.
     */
    private void createMenu() {
        // http://docs.oracle.com/javase/tutorial/uiswing/components/menu.html

        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu menu_file = new JMenu(simpleCashDialogResourceBundle.getString("menu_file"));
        menu_file.setMnemonic(KeyEvent.VK_F);
        JMenuItem menu_file_login = new JMenuItem(simpleCashDialogResourceBundle.getString("menu_file_login"));
        menu_file_login.setActionCommand(SimpleCashDialogAction.menu_file_login_logout);
        menu_file_login.addActionListener(this);
        menu_file.add(menu_file_login);
        menu_file.addSeparator();
        JMenuItem menu_file_exit = new JMenuItem(simpleCashDialogResourceBundle.getString("menu_file_exit"));
        menu_file_exit.setActionCommand(SimpleCashDialogAction.menu_file_exit);
        menu_file_exit.addActionListener(this);
        menu_file.add(menu_file_exit);
        menuBar.add(menu_file);

        // Admin menu
        JMenu menu_admin = new JMenu(simpleCashDialogResourceBundle.getString("menu_admin"));
        JMenuItem menu_admin_createdb = new JMenuItem(simpleCashDialogResourceBundle.getString("menu_admin_createdb"));
        menu_admin_createdb.setActionCommand(SimpleCashDialogAction.menu_admin_createdb);
        menu_admin_createdb.addActionListener(this);
        menu_admin.add(menu_admin_createdb);
        JMenuItem menu_admin_updatedb = new JMenuItem(simpleCashDialogResourceBundle.getString("menu_admin_updatedb"));
        menu_admin_updatedb.setActionCommand(SimpleCashDialogAction.menu_admin_updatedb);
        menu_admin_updatedb.addActionListener(this);
        menu_admin.add(menu_admin_updatedb);
        JMenuItem menu_admin_populatedb = new JMenuItem(simpleCashDialogResourceBundle.getString("menu_admin_populatedb"));
        menu_admin_populatedb.setActionCommand(SimpleCashDialogAction.menu_admin_populatedb);
        menu_admin_populatedb.addActionListener(this);
        menu_admin.add(menu_admin_populatedb);
        menuBar.add(menu_admin);

        // Client menu
        JMenu menu_clients = new JMenu(generalResourceBundle.getString("Clients"));
        JMenuItem menu_clients_list = new JMenuItem();
        menuBar.add(menu_clients);

        // Supplier menu
        JMenu menu_suppliers = new JMenu(generalResourceBundle.getString("Suppliers"));
        JMenuItem menu_suppliers_list = new JMenuItem();
        menuBar.add(menu_suppliers);

        // Help menu
        menuBar.add(Box.createHorizontalGlue());
        JMenu menu_help = new JMenu(simpleCashDialogResourceBundle.getString("menu_help"));
        JMenuItem menu_help_about = new JMenuItem(simpleCashDialogResourceBundle.getString("menu_help_about"));
        menu_help.add(menu_help_about);
        menuBar.add(menu_help);

        setJMenuBar(menuBar);
    }

    public void actionPerformed(ActionEvent event) {
        if (SimpleCashDialogAction.menu_file_exit.equals(event.getActionCommand())) {
            this.dispose();
        } else if (SimpleCashDialogAction.menu_file_login_logout.equals(event.getActionCommand())) {
            // TODO: log in/out
        } else if (SimpleCashDialogAction.menu_admin_createdb.equals(event.getActionCommand())) {
            DatabaseManagerDAO dbMgr = new DatabaseManagerDAO();
            dbMgr.createDatabaseSchema();
        } else if (SimpleCashDialogAction.menu_admin_updatedb.equals(event.getActionCommand())) {
            DatabaseManagerDAO dbMgr = new DatabaseManagerDAO();
            dbMgr.updateDatabaseSchema();
        } else if (SimpleCashDialogAction.menu_admin_populatedb.equals(event.getActionCommand())) {
            DatabaseManagerDAO dbMgr = new DatabaseManagerDAO();
            dbMgr.populateWithTestData();
        }
    }
}
