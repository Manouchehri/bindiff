/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public abstract class AbstractOperatorPanel
extends JPanel {
    private final JTextArea infoField = new JTextArea();

    public AbstractOperatorPanel() {
        super(new BorderLayout());
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder(this.getBorderTitle()));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.infoField.setBackground(jPanel2.getBackground());
        this.infoField.setLineWrap(true);
        this.infoField.setWrapStyleWord(true);
        this.infoField.setEditable(false);
        jPanel2.add((Component)this.infoField, "Center");
        jPanel.add((Component)jPanel2, "Center");
        this.add((Component)jPanel, "Center");
    }

    public abstract String getBorderTitle();

    public JTextArea getInfoField() {
        return this.infoField;
    }

    public abstract String getInvalidInfoString();

    public abstract String getValidInfoString();
}

