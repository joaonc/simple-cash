package com.simplecash.ui.desktop.main;

import com.simplecash.dal.SessionManager;
import com.simplecash.dal.implementation.ContactDAO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.*;

/**
 * Main entry point.
 */
public class Main {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("Application started.");

        // Configure Hibernate and create session factory
        // The operation below is not required here, but creates a fail fast in case Hibernate
        // doesn't configure properly.
        new SessionManager();

        // Start the main window
        SimpleCashDialog dialog = new SimpleCashDialog();
        dialog.pack();
        dialog.setVisible(true);

        logger.debug("Application ended.");
        System.exit(0);
    }
}
