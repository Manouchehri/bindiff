package com.google.security.zynamics.zylib.gui.UrlLabel;

import com.google.security.zynamics.zylib.gui.UrlLabel.UrlLabel$1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class UrlLabel extends JLabel {
   private static final long serialVersionUID = 1L;
   private static MouseListener linker = new UrlLabel$1();
   private URL url;

   public UrlLabel(String var1) {
      super(var1);
      this.setForeground(Color.BLUE);
      this.addMouseListener(linker);
   }

   public UrlLabel(String var1, String var2) {
      this(var1);
      this.setToolTipText(var2);
   }

   public UrlLabel(String var1, String var2, URL var3) {
      this(var1, var3);
      this.setToolTipText(var2);
   }

   public UrlLabel(String var1, URL var2) {
      this(var1);
      this.url = var2;
   }

   public void paint(Graphics var1) {
      super.paint(var1);
      Border var2 = this.getBorder();
      int var3 = 0;
      int var4 = this.getWidth();
      if(var2 != null) {
         Insets var5 = var2.getBorderInsets(this);
         var4 -= var5.right;
         var4 -= var5.left;
         var3 += var5.left;
      }

      var1.drawLine(var3, this.getHeight() - 2, var4, this.getHeight() - 2);
   }

   public void setUrl(URL var1) {
      this.url = var1;
   }

   // $FF: synthetic method
   static URL access$000(UrlLabel var0) {
      return var0.url;
   }
}
