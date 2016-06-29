/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import org.jfree.ui.RefineryUtilities;

public class AboutPanel
extends JPanel {
    public AboutPanel(String string, String string2, String string3, String string4) {
        this(string, string2, string3, string4, null);
    }

    public AboutPanel(String string, String string2, String string3, String string4, Image image) {
        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel(new GridLayout(4, 1, 0, 4));
        JPanel jPanel2 = new JPanel();
        Font font = new Font("Dialog", 1, 14);
        JLabel jLabel = RefineryUtilities.createJLabel(string, font, Color.black);
        jLabel.setHorizontalTextPosition(0);
        jPanel2.add(jLabel);
        JPanel jPanel3 = new JPanel();
        Font font2 = new Font("Dialog", 0, 12);
        JLabel jLabel2 = RefineryUtilities.createJLabel(string2, font2, Color.black);
        jLabel2.setHorizontalTextPosition(0);
        jPanel3.add(jLabel2);
        JPanel jPanel4 = new JPanel();
        JLabel jLabel3 = RefineryUtilities.createJLabel(string3, font2, Color.black);
        jLabel3.setHorizontalTextPosition(0);
        jPanel4.add(jLabel3);
        JPanel jPanel5 = new JPanel();
        JLabel jLabel4 = RefineryUtilities.createJLabel(string4, font2, Color.black);
        jLabel4.setHorizontalTextPosition(0);
        jPanel5.add(jLabel4);
        jPanel.add(jPanel2);
        jPanel.add(jPanel3);
        jPanel.add(jPanel4);
        jPanel.add(jPanel5);
        this.add(jPanel);
        if (image == null) return;
        JPanel jPanel6 = new JPanel(new BorderLayout());
        jPanel6.add(new JLabel(new ImageIcon(image)));
        jPanel6.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel jPanel7 = new JPanel(new BorderLayout());
        jPanel7.add((Component)jPanel6, "North");
        this.add((Component)jPanel7, "West");
    }
}

