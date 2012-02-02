package com.simplecash.ui.desktop;

/**
 * Enum that manages the look and feel for the application
 */
public enum LookAndFeelOption {
    Metal (javax.swing.plaf.metal.MetalLookAndFeel.class),
    Nimbus (com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel.class),
    CdeMotif (com.sun.java.swing.plaf.motif.MotifLookAndFeel.class),
    Windows (com.sun.java.swing.plaf.windows.WindowsLookAndFeel.class),
    WindowsClassic (com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel.class);
    
    private Class lookAndFeel;

    LookAndFeelOption(Class lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }

    public Class getLookAndFeel() {
        return lookAndFeel;
    }

    /**
     * Gets the LookAndFeel class by the enum name.
     * @param name The enum name.
     * @return The LookAndFeel class or null if not found.
     */
    public static Class getLookAndFeelByName(String name) {
        Class lookAndFeelClass = null;

        try {
            LookAndFeelOption lookAndFeel1 = Enum.valueOf(LookAndFeelOption.class, name);
            lookAndFeelClass = lookAndFeel1.getLookAndFeel();
        } catch (Exception e) {
            // do nothing
        }

        return lookAndFeelClass;
    }
}
