package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.CHexFormatter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddressRangeFieldPanel extends JPanel {
   private final JLabel label;
   private final JFormattedTextField textfield;
   private final IAddress defaultAddress;

   public AddressRangeFieldPanel(String var1, IAddress var2, int var3, int var4, int var5) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.defaultAddress = var2;
      this.label = new JLabel(var1);
      this.textfield = new JFormattedTextField(new CHexFormatter(16));
      this.textfield.setText(var2.toHexString());
      this.label.setPreferredSize(new Dimension(var3, var5));
      this.textfield.setPreferredSize(new Dimension(var4, var5));
      this.init();
   }

   public IAddress getValue() {
      return new CAddress(this.textfield.getText(), 16);
   }

   public void init() {
      this.setBorder(new EmptyBorder(2, 2, 2, 2));
      JPanel var1 = new JPanel(new BorderLayout());
      var1.add(this.label, "West");
      var1.add(this.textfield, "Center");
      this.add(var1, "Center");
   }

   public void setDefault() {
      this.textfield.setText(this.defaultAddress.toHexString());
   }

   public void setValue(IAddress var1) {
      this.textfield.setValue(var1.toHexString());
   }
}
