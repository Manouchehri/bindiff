package com.google.security.zynamics.zylib.gui.comboboxes.memorybox;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.JMemoryBoxModel;
import javax.swing.JComboBox;

public class JMemoryBox extends JComboBox {
   private final JMemoryBoxModel m_model;

   public JMemoryBox(int var1) {
      Preconditions.checkArgument(var1 > 0, "Error: Maximum argument must be positive");
      this.m_model = new JMemoryBoxModel(var1);
      this.setModel(this.m_model);
      this.setEditable(true);
   }

   public void add(String var1) {
      this.m_model.add((String)Preconditions.checkNotNull(var1, "Error: Text argument can not be null"));
   }
}
