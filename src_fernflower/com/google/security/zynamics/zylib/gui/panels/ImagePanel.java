package com.google.security.zynamics.zylib.gui.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
   private static final long serialVersionUID = -4190301726730485967L;
   private final Image m_image;

   public ImagePanel(Image var1) {
      this.m_image = var1;
      this.setSize(var1.getWidth((ImageObserver)null), var1.getHeight((ImageObserver)null));
      this.setPreferredSize(this.getSize());
      this.setBackground(Color.RED);
   }

   public void paint(Graphics var1) {
      var1.drawImage(this.m_image, 0, 0, this);
   }
}
