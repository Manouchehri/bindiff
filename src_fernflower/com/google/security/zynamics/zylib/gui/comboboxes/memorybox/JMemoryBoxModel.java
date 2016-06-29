package com.google.security.zynamics.zylib.gui.comboboxes.memorybox;

import javax.swing.DefaultComboBoxModel;

public class JMemoryBoxModel extends DefaultComboBoxModel {
   private final int m_maximum;

   public JMemoryBoxModel(int var1) {
      this.m_maximum = var1;
   }

   public void add(String var1) {
      this.removeElement(var1);
      this.insertElementAt(var1, 0);

      while(this.getSize() > this.m_maximum) {
         this.removeElementAt(this.m_maximum);
      }

      this.setSelectedItem(var1);
   }
}
