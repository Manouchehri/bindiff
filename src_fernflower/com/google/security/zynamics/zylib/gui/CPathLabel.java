package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CPathLabel$1;
import com.google.security.zynamics.zylib.gui.CPathLabel$2;
import com.google.security.zynamics.zylib.gui.CPathLabel$3;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.awt.FontMetrics;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class CPathLabel extends JLabel {
   protected String m_textEllipsis;
   protected JPopupMenu m_popup;

   public CPathLabel() {
      this("", (Icon)null, 10);
   }

   public CPathLabel(Icon var1) {
      this((String)null, var1, 0);
   }

   public CPathLabel(Icon var1, int var2) {
      this((String)null, var1, var2);
   }

   public CPathLabel(String var1) {
      this(var1, (Icon)null, 10);
   }

   public CPathLabel(String var1, Icon var2, int var3) {
      super(var1, var2, var3);
      this.m_textEllipsis = null;
      this.m_popup = new JPopupMenu();
      JMenuItem var4 = new JMenuItem("Copy Path", 67);
      var4.addActionListener(new CPathLabel$1(this));
      this.m_popup.add(var4);
      this.addComponentListener(new CPathLabel$2(this));
      this.addMouseListener(new CPathLabel$3(this));
   }

   public CPathLabel(String var1, int var2) {
      this(var1, (Icon)null, var2);
   }

   protected void updatePathEllipsis() {
      if(this.getGraphics() != null) {
         FontMetrics var1 = this.getGraphics().getFontMetrics();
         this.m_textEllipsis = super.getText();
         int var2 = this.m_textEllipsis.length();
         String var3 = this.m_textEllipsis;

         for(int var4 = this.getWidth(); var2 >= 12 && var1.stringWidth(var3) > var4; --var2) {
            var3 = FileUtils.getPathEllipsis(this.m_textEllipsis, var2);
         }

         this.m_textEllipsis = var3;
      }
   }

   public String getText() {
      return this.m_textEllipsis;
   }

   public void repaint() {
      this.updatePathEllipsis();
      super.repaint();
   }

   // $FF: synthetic method
   static String access$001(CPathLabel var0) {
      return var0.getText();
   }
}
