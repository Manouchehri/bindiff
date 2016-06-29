/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.CHexFormatter;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class AddressRangeFieldPanel
extends JPanel {
    private final JLabel label;
    private final JFormattedTextField textfield;
    private final IAddress defaultAddress;

    public AddressRangeFieldPanel(String string, IAddress iAddress, int n2, int n3, int n4) {
        super(new BorderLayout());
        Preconditions.checkNotNull(string);
        Preconditions.checkNotNull(iAddress);
        this.defaultAddress = iAddress;
        this.label = new JLabel(string);
        this.textfield = new JFormattedTextField(new CHexFormatter(16));
        this.textfield.setText(iAddress.toHexString());
        this.label.setPreferredSize(new Dimension(n2, n4));
        this.textfield.setPreferredSize(new Dimension(n3, n4));
        this.init();
    }

    public IAddress getValue() {
        return new CAddress(this.textfield.getText(), 16);
    }

    public void init() {
        this.setBorder(new EmptyBorder(2, 2, 2, 2));
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)this.label, "West");
        jPanel.add((Component)this.textfield, "Center");
        this.add((Component)jPanel, "Center");
    }

    public void setDefault() {
        this.textfield.setText(this.defaultAddress.toHexString());
    }

    public void setValue(IAddress iAddress) {
        this.textfield.setValue(iAddress.toHexString());
    }
}

