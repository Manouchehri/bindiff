package com.google.security.zynamics.zylib.gui;

import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.zylib.general.*;
import java.net.*;
import com.google.security.zynamics.zylib.gui.UrlLabel.*;
import com.google.security.zynamics.zylib.resources.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CDialogAboutEx extends JDialog
{
    private static final long serialVersionUID = -3626217728291899345L;
    
    public CDialogAboutEx(final Window window, final ImageIcon icon, final String s, final String s2, final String s3, final List list) {
        final String s4 = "About ";
        final String value = String.valueOf(s);
        super(window, (value.length() != 0) ? s4.concat(value) : new String(s4), ModalityType.APPLICATION_MODAL);
        new CDialogEscaper(this);
        this.setLayout(new GridBagLayout());
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.gridwidth = 0;
        gridBagConstraints.fill = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.0;
        gridBagConstraints.insets = new Insets(3, 3, 3, 3);
        final JPanel panel = new JPanel();
        final JLabel label = new JLabel();
        label.setIcon(icon);
        panel.add(label);
        gridBagConstraints.gridy = 0;
        this.add(panel, gridBagConstraints);
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(7, 7, 7, 7));
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel2.add(panel3);
        panel3.setBorder(BorderFactory.createLoweredBevelBorder());
        final JTextArea textArea = new JTextArea(s2);
        textArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        textArea.setEditable(false);
        textArea.setBackground(panel3.getBackground());
        panel3.add(textArea);
        gridBagConstraints.gridy = 1;
        this.add(panel2, gridBagConstraints);
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBorder(new EmptyBorder(0, 7, 7, 7));
        final JPanel panel5 = new JPanel(new BorderLayout());
        panel4.add(panel5);
        panel5.setBorder(BorderFactory.createLoweredBevelBorder());
        final JTextArea textArea2 = new JTextArea(s3);
        textArea2.setBorder(new EmptyBorder(5, 5, 5, 5));
        textArea2.setEditable(false);
        textArea2.setBackground(panel5.getBackground());
        panel5.add(textArea2);
        gridBagConstraints.gridy = 2;
        this.add(panel4, gridBagConstraints);
        final JPanel panel6 = new JPanel(new BorderLayout());
        panel6.setBorder(new EmptyBorder(0, 7, 7, 7));
        final JPanel panel7 = new JPanel(new BorderLayout());
        panel6.add(panel7);
        final JPanel panel8 = new JPanel();
        for (final Pair pair : list) {
            final UrlLabel urlLabel = new UrlLabel((String)pair.first(), (URL)pair.second());
            urlLabel.setBorder(new EmptyBorder(0, 0, 0, 5));
            panel8.add(urlLabel);
        }
        panel7.add(panel8, "West");
        final String ok = Constants.OK;
        final JButton button = new JButton(new StringBuilder(10 + String.valueOf(ok).length()).append("     ").append(ok).append("     ").toString());
        final JPanel panel9 = new JPanel(new BorderLayout());
        panel9.setBorder(new EmptyBorder(0, 0, 0, 5));
        panel9.add(button);
        button.addActionListener(new CDialogAboutEx$InternalActionListener(this, null));
        panel7.add(panel9, "East");
        gridBagConstraints.gridy = 3;
        this.add(panel6, gridBagConstraints);
        this.pack();
        this.setResizable(false);
    }
}
