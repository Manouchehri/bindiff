package com.google.security.zynamics.zylib.gui.JHint;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;

public class JHintDialog extends JDialog
{
    private static final long serialVersionUID = -6233942484161880642L;
    
    public JHintDialog(final Window window, final String s) {
        super(window);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new LineBorder(Color.BLACK));
        final JTextArea textArea = new JTextArea(s);
        textArea.setEditable(false);
        panel.add(textArea);
        this.add(panel);
        this.pack();
    }
}
