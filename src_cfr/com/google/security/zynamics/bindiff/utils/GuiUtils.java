/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.bindiff.utils.GuiUtils$1;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GuiUtils {
    private GuiUtils() {
    }

    public static JCheckBoxMenuItem buildCheckBoxMenuItem(String string, AbstractAction abstractAction) {
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem(string);
        jCheckBoxMenuItem.addActionListener(abstractAction);
        return jCheckBoxMenuItem;
    }

    public static JCheckBoxMenuItem buildCheckBoxMenuItem(String string, char c2, AbstractAction abstractAction) {
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem(string);
        jCheckBoxMenuItem.setMnemonic(c2);
        jCheckBoxMenuItem.addActionListener(abstractAction);
        return jCheckBoxMenuItem;
    }

    public static JCheckBoxMenuItem buildCheckBoxMenuItem(String string, char c2, int n2, int n3, AbstractAction abstractAction) {
        JCheckBoxMenuItem jCheckBoxMenuItem = GuiUtils.buildCheckBoxMenuItem(string, c2, abstractAction);
        jCheckBoxMenuItem.setAccelerator(KeyStroke.getKeyStroke(n2, n3));
        return jCheckBoxMenuItem;
    }

    public static JMenu buildMenu(String string, char c2) {
        JMenu jMenu = new JMenu(string);
        jMenu.setMnemonic(c2);
        return jMenu;
    }

    public static JMenuItem buildMenuItem(String string, AbstractAction abstractAction) {
        return GuiUtils.buildMenuItem(string, '\uffff', -1, 0, abstractAction, true);
    }

    public static JMenuItem buildMenuItem(String string, AbstractAction abstractAction, boolean bl2) {
        return GuiUtils.buildMenuItem(string, '\uffff', -1, 0, abstractAction, bl2);
    }

    public static JMenuItem buildMenuItem(String string, char c2, AbstractAction abstractAction) {
        return GuiUtils.buildMenuItem(string, c2, -1, 0, abstractAction, true);
    }

    public static JMenuItem buildMenuItem(String string, char c2, AbstractAction abstractAction, boolean bl2) {
        return GuiUtils.buildMenuItem(string, c2, -1, 0, abstractAction, bl2);
    }

    public static JMenuItem buildMenuItem(String string, char c2, char c3, AbstractAction abstractAction) {
        JMenuItem jMenuItem = GuiUtils.buildMenuItem(string, c2, abstractAction);
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(c3));
        return jMenuItem;
    }

    public static JMenuItem buildMenuItem(String string, char c2, int n2, int n3, AbstractAction abstractAction) {
        return GuiUtils.buildMenuItem(string, c2, n2, n3, abstractAction, true);
    }

    public static JMenuItem buildMenuItem(String string, char c2, int n2, int n3, AbstractAction abstractAction, boolean bl2) {
        JMenuItem jMenuItem = new JMenuItem(string, c2);
        if (n2 >= 0) {
            jMenuItem.setAccelerator(KeyStroke.getKeyStroke(n2, n3));
        }
        jMenuItem.setEnabled(bl2);
        jMenuItem.addActionListener(abstractAction);
        return jMenuItem;
    }

    public static JMenuItem buildMenuItem(String string, Icon icon, AbstractAction abstractAction) {
        JMenuItem jMenuItem = GuiUtils.buildMenuItem(string, '\uffff', -1, 0, abstractAction, true);
        jMenuItem.setIcon(icon);
        return jMenuItem;
    }

    public static JMenuItem buildMenuItem(String string, int n2, int n3, AbstractAction abstractAction) {
        return GuiUtils.buildMenuItem(string, '\uffff', n2, n3, abstractAction, true);
    }

    public static JRadioButtonMenuItem buildRadioButtonMenuItem(String string, char c2, AbstractAction abstractAction) {
        JRadioButtonMenuItem jRadioButtonMenuItem = new JRadioButtonMenuItem(string);
        jRadioButtonMenuItem.setMnemonic(c2);
        jRadioButtonMenuItem.addActionListener(abstractAction);
        return jRadioButtonMenuItem;
    }

    public static JRadioButtonMenuItem buildRadioButtonMenuItem(String string, char c2, int n2, int n3, AbstractAction abstractAction) {
        JRadioButtonMenuItem jRadioButtonMenuItem = GuiUtils.buildRadioButtonMenuItem(string, c2, abstractAction);
        jRadioButtonMenuItem.setAccelerator(KeyStroke.getKeyStroke(n2, n3));
        return jRadioButtonMenuItem;
    }

    public static Component createHorizontalNamedComponent(JPanel jPanel, String string, Component component, int n2, int n3, boolean bl2) {
        component.setPreferredSize(new Dimension(n2, n3));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(0, 2, bl2 ? 2 : 0, 2));
        jPanel2.add((Component)new JLabel(string), "Center");
        jPanel2.add(component, "East");
        jPanel.add(jPanel2);
        return component;
    }

    public static JPanel createHorizontalNamedComponentPanel(String string, int n2, JComponent jComponent, int n3) {
        JPanel jPanel = new JPanel(new BorderLayout());
        JLabel jLabel = new JLabel(string);
        jLabel.setPreferredSize(new Dimension(n2, n3));
        jComponent.setPreferredSize(new Dimension(jComponent.getPreferredSize().width, n3));
        jPanel.add((Component)jLabel, "West");
        jPanel.add((Component)jComponent, "Center");
        jPanel.setPreferredSize(new Dimension(jPanel.getPreferredSize().width, n3));
        return jPanel;
    }

    public static JPanel createHorizontalNamedLabelPanel(String string, int n2, JLabel jLabel, int n3) {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(0, 3, 2, 3));
        jPanel.setBackground(Color.WHITE);
        JLabel jLabel2 = new JLabel(string);
        jLabel2.setPreferredSize(new Dimension(n2, n3));
        jPanel.setPreferredSize(new Dimension(0, n3));
        jLabel.setForeground(new Color(0, 0, 160));
        jLabel.setMinimumSize(new Dimension(0, 0));
        jPanel.add((Component)jLabel2, "West");
        jPanel.add((Component)jLabel, "Center");
        return jPanel;
    }

    public static Component createHorizontalNamedLabelPanel(String string, int n2, JTextField jTextField, int n3) {
        jTextField.setEditable(false);
        jTextField.setBorder(null);
        jTextField.setForeground(new Color(0, 0, 160));
        jTextField.setBackground(Color.WHITE);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(0, 3, 2, 3));
        jPanel.setBackground(Color.WHITE);
        JLabel jLabel = new JLabel(string);
        jLabel.setPreferredSize(new Dimension(n2, n3));
        jPanel.setPreferredSize(new Dimension(0, n3));
        jPanel.add((Component)jLabel, "West");
        jPanel.add((Component)jTextField, "Center");
        return jPanel;
    }

    public static void setWindowIcons(Window window, String string, String string2, String string3) {
        ArrayList<Image> arrayList = new ArrayList<Image>();
        arrayList.add(ImageUtils.getImage(string));
        arrayList.add(ImageUtils.getImage(string2));
        arrayList.add(ImageUtils.getImage(string3));
        window.setIconImages(arrayList);
    }

    public static void updateLater(JComponent jComponent) {
        EventQueue.invokeLater(new GuiUtils$1(jComponent));
    }
}

