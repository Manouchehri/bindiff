package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents;

import javax.swing.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.disassembly.*;
import javax.swing.border.*;
import java.awt.*;

public class AddressRangeFieldPanel extends JPanel
{
    private final JLabel label;
    private final JFormattedTextField textfield;
    private final IAddress defaultAddress;
    
    public AddressRangeFieldPanel(final String s, final IAddress defaultAddress, final int n, final int n2, final int n3) {
        super(new BorderLayout());
        Preconditions.checkNotNull(s);
        Preconditions.checkNotNull(defaultAddress);
        this.defaultAddress = defaultAddress;
        this.label = new JLabel(s);
        (this.textfield = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new CHexFormatter(16))).setText(defaultAddress.toHexString());
        this.label.setPreferredSize(new Dimension(n, n3));
        this.textfield.setPreferredSize(new Dimension(n2, n3));
        this.init();
    }
    
    public IAddress getValue() {
        return new CAddress(this.textfield.getText(), 16);
    }
    
    public void init() {
        this.setBorder(new EmptyBorder(2, 2, 2, 2));
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.label, "West");
        panel.add(this.textfield, "Center");
        this.add(panel, "Center");
    }
    
    public void setDefault() {
        this.textfield.setText(this.defaultAddress.toHexString());
    }
    
    public void setValue(final IAddress address) {
        this.textfield.setValue(address.toHexString());
    }
}
