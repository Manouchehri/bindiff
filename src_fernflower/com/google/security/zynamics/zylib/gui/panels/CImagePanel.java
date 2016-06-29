package com.google.security.zynamics.zylib.gui.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CImagePanel extends JPanel {
   private static final long serialVersionUID = 8772470195013064027L;
   private final Image m_image;

   public CImagePanel(Image var1) {
      this.m_image = var1;
      Dimension var2 = new Dimension(var1.getWidth((ImageObserver)null), var1.getHeight((ImageObserver)null));
      this.setPreferredSize(var2);
      this.setMinimumSize(var2);
      this.setMaximumSize(var2);
      this.setSize(var2);
      this.setLayout((LayoutManager)null);
   }

   public CImagePanel(String var1) {
      this((new ImageIcon(var1)).getImage());
   }

   public void paintComponent(Graphics var1) {
      var1.drawImage(this.m_image, 0, 0, (ImageObserver)null);
   }
}
