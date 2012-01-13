package com.simplecash.ui.desktop.main;

import com.simplecash.dal.RepositoryFactory;
import org.slf4j.*;

/**
 * Main entry point.
 */
public class Main {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("Application started.");

        // Instantiate RepositoryFactory, which causes most beans to be instantiated as well
        // Not necessary to do it here, but it will be fail fast
        // if doesn't instanciate properly
        new RepositoryFactory();

        // Start the main window
        SimpleCashDialog dialog = new SimpleCashDialog();
        dialog.pack();
        dialog.setVisible(true);

        RepositoryFactory.flush();

        logger.debug("Application ended.");
        System.exit(0);
    }
}
