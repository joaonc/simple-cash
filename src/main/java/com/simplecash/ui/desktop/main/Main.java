package com.simplecash.ui.desktop.main;

/**
 * Main entry point.
 */
public class Main {
    public static void main(String[] args) {
        SimpleCashDialog dialog = new SimpleCashDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
