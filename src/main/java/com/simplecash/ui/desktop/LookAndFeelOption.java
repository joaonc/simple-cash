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

    public static Class getLookAndFeelByName(String name) {

        LookAndFeelOption lookAndFeel1 = Enum.valueOf(LookAndFeelOption.class, name);
        return lookAndFeel1.getLookAndFeel();
    }
}
