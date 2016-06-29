package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public abstract class AbstractOperatorPanel extends JPanel
{
    private final JTextArea infoField;
    
    public AbstractOperatorPanel() {
        super(new BorderLayout());
        this.infoField = new JTextArea();
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(this.getBorderTitle()));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.infoField.setBackground(panel2.getBackground());
        this.infoField.setLineWrap(true);
        this.infoField.setWrapStyleWord(true);
        this.infoField.setEditable(false);
        panel2.add(this.infoField, "Center");
        panel.add(panel2, "Center");
        this.add(panel, "Center");
    }
    
    public abstract String getBorderTitle();
    
    public JTextArea getInfoField() {
        return this.infoField;
    }
    
    public abstract String getInvalidInfoString();
    
    public abstract String getValidInfoString();
}
