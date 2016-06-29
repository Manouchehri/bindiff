/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumPanel$InternalTextListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.KeyListener;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class TextCriteriumPanel
extends JPanel {
    private final JTextField inputField = new JTextField("");
    private final JCheckBox caseSensitiveBox = new JCheckBox("Case Sensitive");
    private final JCheckBox regExBox = new JCheckBox("Regular Expression");
    private final TextCriterium criterium;

    public TextCriteriumPanel(TextCriterium textCriterium) {
        super(new BorderLayout());
        this.criterium = textCriterium;
        this.initPanel();
    }

    private void initPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder("Edit Text Condition"));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.inputField.addKeyListener(new TextCriteriumPanel$InternalTextListener(this, null));
        this.inputField.setPreferredSize(new Dimension(this.inputField.getPreferredSize().width, 23));
        jPanel2.add((Component)this.inputField, "North");
        JPanel jPanel3 = new JPanel(new GridLayout(2, 1));
        jPanel3.setBorder(new EmptyBorder(5, 0, 0, 0));
        jPanel3.add(this.caseSensitiveBox);
        jPanel3.add(this.regExBox);
        jPanel2.add((Component)jPanel3, "Center");
        jPanel.add((Component)jPanel2, "North");
        this.add((Component)jPanel, "Center");
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

    static /* synthetic */ TextCriterium access$100(TextCriteriumPanel textCriteriumPanel) {
        return textCriteriumPanel.criterium;
    }
}

