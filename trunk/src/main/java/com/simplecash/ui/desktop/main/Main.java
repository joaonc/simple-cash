package com.simplecash.ui.desktop.main;

import com.simplecash.dal.RepositoryFactory;
import com.simplecash.ui.desktop.LookAndFeelOption;
import org.slf4j.*;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;

/**
 * Main entry point.
 */
public class Main {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("Application started.");

        // Set properties from file
        String propertiesFile = "config.properties";
        URL propertiesFileUrl =  ClassLoader.getSystemResource(propertiesFile);
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesFileUrl.getFile()));
            
            String locale = properties.getProperty("Locale");
            if (locale != null) {
                Locale.setDefault(new Locale(locale));
            }
            
            String lookAndFeelName = properties.getProperty("LookAndFeel");
            if (lookAndFeelName != null) {
                Class lookAndFeelClass = LookAndFeelOption.getLookAndFeelByName(lookAndFeelName);
                if (lookAndFeelClass != null) {
                    try {
                        UIManager.setLookAndFeel(lookAndFeelClass.getCanonicalName());
                    } catch (Exception e) {
                        logger.error("Error setting LookAndFeel.", e);
                    }
                }
                else {
                    logger.error("LookAndFeel not found: " + lookAndFeelName);
                }
            }
        } catch (IOException e) {
            logger.error(String.format("Properties file not found: %s, going with defaults.", propertiesFile));
        }

        // Instanciate RepositoryFactory, which causes most beans to be instantiated as well
        // Not necessary to do it here, but it will be fail fast if doesn't instanciate properly
//        new RepositoryFactory();

        // Start the main window
        SimpleCashDialog dialog = new SimpleCashDialog();
        dialog.pack();
        dialog.setVisible(true);

        logger.debug("Application ended.");
        System.exit(0);
    }
}
