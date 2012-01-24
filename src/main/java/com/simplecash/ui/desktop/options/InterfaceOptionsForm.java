package com.simplecash.ui.desktop.options;

import com.simplecash.ui.desktop.event.LookAndFeelChangeEvent;
import com.simplecash.ui.desktop.LookAndFeelOption;
import javaEventing.EventManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class InterfaceOptionsForm {
    private JTabbedPane tabbedPane;
    private JPanel panel;
    private JButton buttonApply;
    private JRadioButton metalRadioButton;
    private JRadioButton nimbusRadioButton;
    private JRadioButton cdeMotifRadioButton;
    private JRadioButton windowsRadioButton;
    private JRadioButton windowsClassicRadioButton;

    public InterfaceOptionsForm() {
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LookAndFeelOption lookAndFeelOption = null;
                if (metalRadioButton.isSelected()) {
                    lookAndFeelOption = LookAndFeelOption.Metal;
                } else if (nimbusRadioButton.isSelected()) {
                    lookAndFeelOption = LookAndFeelOption.Nimbus;
                } else if (cdeMotifRadioButton.isSelected()) {
                    lookAndFeelOption = LookAndFeelOption.CdeMotif;
                } else if (windowsRadioButton.isSelected()) {
                    lookAndFeelOption = LookAndFeelOption.Windows;
                } else if (windowsClassicRadioButton.isSelected()) {
                    lookAndFeelOption = LookAndFeelOption.WindowsClassic;
                }

                EventManager.triggerEvent(this, new LookAndFeelChangeEvent(lookAndFeelOption));
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

}
