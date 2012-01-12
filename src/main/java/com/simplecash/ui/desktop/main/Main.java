package com.simplecash.ui.desktop.main;

import org.slf4j.*;

/**
 * Main entry point.
 */
public class Main {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("Application started.");

        // Start the main window
        SimpleCashDialog dialog = new SimpleCashDialog();
        dialog.pack();
        dialog.setVisible(true);

        logger.debug("Application ended.");
        System.exit(0);
    }
}
