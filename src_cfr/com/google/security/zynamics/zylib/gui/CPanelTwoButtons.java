/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CPanelTwoButtons
extends JPanel {
    private static final long serialVersionUID = -7197559018087702078L;
    private final String m_FirstButtonName;
    private final String m_SecondButtonName;
    private final JButton m_FirstButton;
    private final JButton m_SecondButton;
    private final ActionListener m_listener;

    public CPanelTwoButtons(ActionListener actionListener, String string, String string2) {
        this.m_listener = actionListener;
        this.m_FirstButtonName = string;
        this.m_SecondButtonName = string2;
        this.setLayout(new BorderLayout());
        this.m_FirstButton = new JButton(this.m_FirstButtonName);
        this.m_SecondButton = new JButton(this.m_SecondButtonName);
        this.m_FirstButton.addActionListener(actionListener);
        this.m_SecondButton.addActionListener(actionListener);
        if (this.m_FirstButton.getPreferredSize().width > this.m_SecondButton.getPreferredSize().width) {
            this.m_SecondButton.setPreferredSize(this.m_FirstButton.getPreferredSize());
        } else {
            this.m_FirstButton.setPreferredSize(this.m_SecondButton.getPreferredSize());
        }
        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        jPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel3.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel2.add(this.m_FirstButton);
        jPanel3.add(this.m_SecondButton);
        jPanel.add(jPanel2);
        jPanel.add(jPanel3);
        this.add((Component)jPanel, "East");
    }

    public JButton getFirstButton() {
        return this.m_FirstButton;
    }

    public void removeListener() {
        this.m_FirstButton.removeActionListener(this.m_listener);
        this.m_SecondButton.removeActionListener(this.m_listener);
    }
}

