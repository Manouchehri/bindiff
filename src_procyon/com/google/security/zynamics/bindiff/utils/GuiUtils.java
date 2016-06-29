package com.google.security.zynamics.bindiff.utils;

import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class GuiUtils
{
    public static JCheckBoxMenuItem buildCheckBoxMenuItem(final String s, final AbstractAction abstractAction) {
        final JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(s);
        checkBoxMenuItem.addActionListener(abstractAction);
        return checkBoxMenuItem;
    }
    
    public static JCheckBoxMenuItem buildCheckBoxMenuItem(final String s, final char mnemonic, final AbstractAction abstractAction) {
        final JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem(s);
        checkBoxMenuItem.setMnemonic(mnemonic);
        checkBoxMenuItem.addActionListener(abstractAction);
        return checkBoxMenuItem;
    }
    
    public static JCheckBoxMenuItem buildCheckBoxMenuItem(final String s, final char c, final int n, final int n2, final AbstractAction abstractAction) {
        final JCheckBoxMenuItem buildCheckBoxMenuItem = buildCheckBoxMenuItem(s, c, abstractAction);
        buildCheckBoxMenuItem.setAccelerator(KeyStroke.getKeyStroke(n, n2));
        return buildCheckBoxMenuItem;
    }
    
    public static JMenu buildMenu(final String s, final char mnemonic) {
        final JMenu menu = new JMenu(s);
        menu.setMnemonic(mnemonic);
        return menu;
    }
    
    public static JMenuItem buildMenuItem(final String s, final AbstractAction abstractAction) {
        return buildMenuItem(s, '\uffff', -1, 0, abstractAction, true);
    }
    
    public static JMenuItem buildMenuItem(final String s, final AbstractAction abstractAction, final boolean b) {
        return buildMenuItem(s, '\uffff', -1, 0, abstractAction, b);
    }
    
    public static JMenuItem buildMenuItem(final String s, final char c, final AbstractAction abstractAction) {
        return buildMenuItem(s, c, -1, 0, abstractAction, true);
    }
    
    public static JMenuItem buildMenuItem(final String s, final char c, final AbstractAction abstractAction, final boolean b) {
        return buildMenuItem(s, c, -1, 0, abstractAction, b);
    }
    
    public static JMenuItem buildMenuItem(final String s, final char c, final char c2, final AbstractAction abstractAction) {
        final JMenuItem buildMenuItem = buildMenuItem(s, c, abstractAction);
        buildMenuItem.setAccelerator(KeyStroke.getKeyStroke(c2));
        return buildMenuItem;
    }
    
    public static JMenuItem buildMenuItem(final String s, final char c, final int n, final int n2, final AbstractAction abstractAction) {
        return buildMenuItem(s, c, n, n2, abstractAction, true);
    }
    
    public static JMenuItem buildMenuItem(final String s, final char c, final int n, final int n2, final AbstractAction abstractAction, final boolean enabled) {
        final JMenuItem menuItem = new JMenuItem(s, c);
        if (n >= 0) {
            menuItem.setAccelerator(KeyStroke.getKeyStroke(n, n2));
        }
        menuItem.setEnabled(enabled);
        menuItem.addActionListener(abstractAction);
        return menuItem;
    }
    
    public static JMenuItem buildMenuItem(final String s, final Icon icon, final AbstractAction abstractAction) {
        final JMenuItem buildMenuItem = buildMenuItem(s, '\uffff', -1, 0, abstractAction, true);
        buildMenuItem.setIcon(icon);
        return buildMenuItem;
    }
    
    public static JMenuItem buildMenuItem(final String s, final int n, final int n2, final AbstractAction abstractAction) {
        return buildMenuItem(s, '\uffff', n, n2, abstractAction, true);
    }
    
    public static JRadioButtonMenuItem buildRadioButtonMenuItem(final String s, final char mnemonic, final AbstractAction abstractAction) {
        final JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem(s);
        radioButtonMenuItem.setMnemonic(mnemonic);
        radioButtonMenuItem.addActionListener(abstractAction);
        return radioButtonMenuItem;
    }
    
    public static JRadioButtonMenuItem buildRadioButtonMenuItem(final String s, final char c, final int n, final int n2, final AbstractAction abstractAction) {
        final JRadioButtonMenuItem buildRadioButtonMenuItem = buildRadioButtonMenuItem(s, c, abstractAction);
        buildRadioButtonMenuItem.setAccelerator(KeyStroke.getKeyStroke(n, n2));
        return buildRadioButtonMenuItem;
    }
    
    public static Component createHorizontalNamedComponent(final JPanel panel, final String s, final Component component, final int n, final int n2, final boolean b) {
        component.setPreferredSize(new Dimension(n, n2));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(0, 2, b ? 2 : 0, 2));
        panel2.add(new JLabel(s), "Center");
        panel2.add(component, "East");
        panel.add(panel2);
        return component;
    }
    
    public static JPanel createHorizontalNamedComponentPanel(final String s, final int n, final JComponent component, final int n2) {
        final JPanel panel = new JPanel(new BorderLayout());
        final JLabel label = new JLabel(s);
        label.setPreferredSize(new Dimension(n, n2));
        component.setPreferredSize(new Dimension(component.getPreferredSize().width, n2));
        panel.add(label, "West");
        panel.add(component, "Center");
        panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, n2));
        return panel;
    }
    
    public static JPanel createHorizontalNamedLabelPanel(final String s, final int n, final JLabel label, final int n2) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(0, 3, 2, 3));
        panel.setBackground(Color.WHITE);
        final JLabel label2 = new JLabel(s);
        label2.setPreferredSize(new Dimension(n, n2));
        panel.setPreferredSize(new Dimension(0, n2));
        label.setForeground(new Color(0, 0, 160));
        label.setMinimumSize(new Dimension(0, 0));
        panel.add(label2, "West");
        panel.add(label, "Center");
        return panel;
    }
    
    public static Component createHorizontalNamedLabelPanel(final String s, final int n, final JTextField textField, final int n2) {
        textField.setEditable(false);
        textField.setBorder(null);
        textField.setForeground(new Color(0, 0, 160));
        textField.setBackground(Color.WHITE);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(0, 3, 2, 3));
        panel.setBackground(Color.WHITE);
        final JLabel label = new JLabel(s);
        label.setPreferredSize(new Dimension(n, n2));
        panel.setPreferredSize(new Dimension(0, n2));
        panel.add(label, "West");
        panel.add(textField, "Center");
        return panel;
    }
    
    public static void setWindowIcons(final Window window, final String s, final String s2, final String s3) {
        final ArrayList<Image> iconImages = new ArrayList<Image>();
        iconImages.add(ImageUtils.getImage(s));
        iconImages.add(ImageUtils.getImage(s2));
        iconImages.add(ImageUtils.getImage(s3));
        window.setIconImages(iconImages);
    }
    
    public static void updateLater(final JComponent component) {
        EventQueue.invokeLater(new GuiUtils$1(component));
    }
}
