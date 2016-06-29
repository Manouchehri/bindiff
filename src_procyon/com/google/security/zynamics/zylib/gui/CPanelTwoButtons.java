package com.google.security.zynamics.zylib.gui;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

public class CPanelTwoButtons extends JPanel
{
    private static final long serialVersionUID = -7197559018087702078L;
    private final String m_FirstButtonName;
    private final String m_SecondButtonName;
    private final JButton m_FirstButton;
    private final JButton m_SecondButton;
    private final ActionListener m_listener;
    
    public CPanelTwoButtons(final ActionListener listener, final String firstButtonName, final String secondButtonName) {
        this.m_listener = listener;
        this.m_FirstButtonName = firstButtonName;
        this.m_SecondButtonName = secondButtonName;
        this.setLayout(new BorderLayout());
        this.m_FirstButton = new JButton(this.m_FirstButtonName);
        this.m_SecondButton = new JButton(this.m_SecondButtonName);
        this.m_FirstButton.addActionListener(listener);
        this.m_SecondButton.addActionListener(listener);
        if (this.m_FirstButton.getPreferredSize().width > this.m_SecondButton.getPreferredSize().width) {
            this.m_SecondButton.setPreferredSize(this.m_FirstButton.getPreferredSize());
        }
        else {
            this.m_FirstButton.setPreferredSize(this.m_SecondButton.getPreferredSize());
        }
        final JPanel panel = new JPanel(new GridLayout(1, 2));
        final JPanel panel2 = new JPanel();
        final JPanel panel3 = new JPanel();
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel3.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel2.add(this.m_FirstButton);
        panel3.add(this.m_SecondButton);
        panel.add(panel2);
        panel.add(panel3);
        this.add(panel, "East");
    }
    
    public JButton getFirstButton() {
        return this.m_FirstButton;
    }
    
    public void removeListener() {
        this.m_FirstButton.removeActionListener(this.m_listener);
        this.m_SecondButton.removeActionListener(this.m_listener);
    }
}
