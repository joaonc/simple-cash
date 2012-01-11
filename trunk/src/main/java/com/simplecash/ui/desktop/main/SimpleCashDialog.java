package com.simplecash.ui.desktop.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.awt.event.*;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class SimpleCashDialog extends JDialog implements ActionListener {
    private JPanel contentPane;
    private final ResourceBundle simpleCashDialogResourceBundle =
            PropertyResourceBundle.getBundle(SimpleCashDialog.class.getCanonicalName());

    public SimpleCashDialog() {
        setContentPane(contentPane);
        setModal(true);
        createMenu();

        Configuration hibernateConfig = new Configuration();
        hibernateConfig.configure();
        SessionFactory factory = hibernateConfig.buildSessionFactory();
    }

    /**
     * Create the menu for the dialog.
     */
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        // http://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
        // http://www.exampledepot.com/egs/javax.swing/menu.html
        // http://www.jetbrains.com/idea/features/i18n_support.html

        // File menu
        JMenu menu_file = new JMenu(simpleCashDialogResourceBundle.getString("menu_file"));
        menu_file.setMnemonic(KeyEvent.VK_F);
        JMenuItem menu_file_login = new JMenuItem(simpleCashDialogResourceBundle.getString("menu_file_login"));
        menu_file_login.setActionCommand(SimpleCashDialogAction.menu_file_login_logout);
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
        menu_admin.add(menu_admin_createdb);
        menuBar.add(menu_admin);

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

        }
    }
}
