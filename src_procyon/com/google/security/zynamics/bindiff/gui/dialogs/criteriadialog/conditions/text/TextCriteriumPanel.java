package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class TextCriteriumPanel extends JPanel
{
    private final JTextField inputField;
    private final JCheckBox caseSensitiveBox;
    private final JCheckBox regExBox;
    private final TextCriterium criterium;
    
    public TextCriteriumPanel(final TextCriterium criterium) {
        super(new BorderLayout());
        this.inputField = new JTextField("");
        this.caseSensitiveBox = new JCheckBox("Case Sensitive");
        this.regExBox = new JCheckBox("Regular Expression");
        this.criterium = criterium;
        this.initPanel();
    }
    
    private void initPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Edit Text Condition"));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.inputField.addKeyListener(new TextCriteriumPanel$InternalTextListener(this, null));
        this.inputField.setPreferredSize(new Dimension(this.inputField.getPreferredSize().width, 23));
        panel2.add(this.inputField, "North");
        final JPanel panel3 = new JPanel(new GridLayout(2, 1));
        panel3.setBorder(new EmptyBorder(5, 0, 0, 0));
        panel3.add(this.caseSensitiveBox);
        panel3.add(this.regExBox);
        panel2.add(panel3, "Center");
        panel.add(panel2, "North");
        this.add(panel, "Center");
    }
    
    public String getText() {
        return this.inputField.getText();
    }
    
    public boolean isCaseSensitive() {
        return this.caseSensitiveBox.isSelected();
    }
    
    public boolean isRegularExpression() {
        return this.regExBox.isSelected();
    }
}
