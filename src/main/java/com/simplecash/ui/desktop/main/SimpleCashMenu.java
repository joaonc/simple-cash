package com.simplecash.ui.desktop.main;

import javax.swing.*;
import org.springframework.context.*;

/**
 *
 */
public class SimpleCashMenu extends JMenuBar {
    private static SimpleCashMenu ourInstance = new SimpleCashMenu();
    //private final ResourceBundle simpleCashDialogResourceBundle = PropertyResourceBundle.getBundle("SimpleCashDialog");
    private ApplicationContext ctx = null;

    public static SimpleCashMenu getInstance() {
        return ourInstance;
    }

    private SimpleCashMenu() {
        //JMenu menu = new JMenu(simpleCashDialogResourceBundle.getString("Menu1"));
        JMenu menu = new JMenu("Menu1");
        JMenuItem item1 = new JMenuItem("ITEM 1");
        menu.add(item1);
        JMenuItem item2 = new JMenuItem("ITEM 2");
        menu.add(item2);

        add(menu);
    }
}
