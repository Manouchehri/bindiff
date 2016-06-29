package com.google.security.zynamics.zylib.gui.imagecombobox;

import javax.swing.ImageIcon;

public class ImageElement {
   private final Object m_object;
   private final ImageIcon m_icon;

   public ImageElement(Object var1, ImageIcon var2) {
      this.m_object = var1;
      this.m_icon = var2;
   }

   public ImageIcon getIcon() {
      return this.m_icon;
   }

   public Object getObject() {
      return this.m_object;
   }
}
