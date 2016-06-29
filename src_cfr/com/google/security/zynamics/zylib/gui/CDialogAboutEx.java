/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.CDialogAboutEx$1;
import com.google.security.zynamics.zylib.gui.CDialogAboutEx$InternalActionListener;
import com.google.security.zynamics.zylib.gui.CDialogEscaper;
import com.google.security.zynamics.zylib.gui.UrlLabel.UrlLabel;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CDialogAboutEx
extends JDialog {
    private static final long serialVersionUID = -3626217728291899345L;

    public CDialogAboutEx(Window window, ImageIcon imageIcon, String string, String string2, String string3, List list) {
        String string4 = String.valueOf(string);
        super(window, string4.length() != 0 ? "About ".concat(string4) : new String("About "), Dialog.ModalityType.APPLICATION_MODAL);
        new CDialogEscaper(this);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.gridwidth = 0;
        gridBagConstraints.fill = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.0;
        gridBagConstraints.insets = new Insets(3, 3, 3, 3);
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jPanel.add(jLabel);
        gridBagConstraints.gridy = 0;
        this.add((Component)jPanel, gridBagConstraints);
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(7, 7, 7, 7));
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel2.add(jPanel3);
        jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
        JTextArea jTextArea = new JTextArea(string2);
        jTextArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        jTextArea.setEditable(false);
        jTextArea.setBackground(jPanel3.getBackground());
        jPanel3.add(jTextArea);
        gridBagConstraints.gridy = 1;
        this.add((Component)jPanel2, gridBagConstraints);
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setBorder(new EmptyBorder(0, 7, 7, 7));
        JPanel jPanel5 = new JPanel(new BorderLayout());
        jPanel4.add(jPanel5);
        jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
        JTextArea jTextArea2 = new JTextArea(string3);
        jTextArea2.setBorder(new EmptyBorder(5, 5, 5, 5));
        jTextArea2.setEditable(false);
        jTextArea2.setBackground(jPanel5.getBackground());
        jPanel5.add(jTextArea2);
        gridBagConstraints.gridy = 2;
        this.add((Component)jPanel4, gridBagConstraints);
        JPanel jPanel6 = new JPanel(new BorderLayout());
        jPanel6.setBorder(new EmptyBorder(0, 7, 7, 7));
        JPanel jPanel7 = new JPanel(new BorderLayout());
        jPanel6.add(jPanel7);
        JPanel jPanel8 = new JPanel();
        Object object = list.iterator();
        do {
            Object object2;
            if (!object.hasNext()) {
                jPanel7.add((Component)jPanel8, "West");
                object2 = Constants.OK;
                object = new JButton(new StringBuilder(10 + String.valueOf(object2).length()).append("     ").append((String)object2).append("     ").toString());
                object2 = new JPanel(new BorderLayout());
                object2.setBorder(new EmptyBorder(0, 0, 0, 5));
                object2.add((Component)object);
                object.addActionListener(new CDialogAboutEx$InternalActionListener(this, null));
                jPanel7.add((Component)object2, "East");
                gridBagConstraints.gridy = 3;
                this.add((Component)jPanel6, gridBagConstraints);
                this.pack();
                this.setResizable(false);
                return;
            }
            object2 = (Pair)object.next();
            UrlLabel urlLabel = new UrlLabel((String)object2.first(), (URL)object2.second());
            urlLabel.setBorder(new EmptyBorder(0, 0, 0, 5));
            jPanel8.add(urlLabel);
        } while (true);
    }
}

