package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class CheckboxCellEditor extends DefaultCellEditor implements ItemListener {
   private JCheckBox checkbox;

   public CheckboxCellEditor() {
      super(new JCheckBox());
   }

   public Object getCellEditorValue() {
      this.checkbox.removeItemListener(this);
      return this.checkbox;
   }

   public Component getTableCellEditorComponent(JTable var1, Object var2, boolean var3, int var4, int var5) {
      if(var2 == null) {
         return null;
      } else {
         this.checkbox = (JCheckBox)var2;
         this.checkbox.addItemListener(this);
         return (Component)var2;
      }
   }

   public void itemStateChanged(ItemEvent var1) {
      super.fireEditingStopped();
   }
}
