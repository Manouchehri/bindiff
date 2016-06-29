package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents;

import com.google.common.base.Preconditions;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FilterComboboxPanel extends JPanel {
   private final JComboBox combobox;
   private final JLabel label;

   public FilterComboboxPanel(String var1, List var2, int var3, int var4, int var5) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.label = new JLabel(var1);
      String[] var6 = new String[var2.size()];
      var2.toArray(var6);
      this.combobox = new JComboBox(var6);
      this.label.setPreferredSize(new Dimension(var3, var5));
      this.combobox.setPreferredSize(new Dimension(var4, var5));
      this.init();
   }

   public String getValue() {
      return this.combobox.getSelectedItem().toString();
   }

   public void init() {
      this.setBorder(new EmptyBorder(1, 2, 2, 2));
      JPanel var1 = new JPanel(new BorderLayout());
      var1.add(this.label, "West");
      var1.add(this.combobox, "Center");
      this.add(var1, "Center");
   }

   public void setValue(String var1) {
      this.combobox.setSelectedItem(var1);
   }
}
