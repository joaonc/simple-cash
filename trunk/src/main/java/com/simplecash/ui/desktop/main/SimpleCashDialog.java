package com.simplecash.ui.desktop.main;

import javax.swing.*;

public class SimpleCashDialog extends JDialog {
    private JPanel contentPane;

    public SimpleCashDialog() {
        setContentPane(contentPane);
        setModal(true);

        setJMenuBar(SimpleCashMenu.getInstance());
    }

    public static void main(String[] args) {
        SimpleCashDialog dialog = new SimpleCashDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
