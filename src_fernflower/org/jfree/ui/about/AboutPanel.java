package org.jfree.ui.about;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.ui.RefineryUtilities;

public class AboutPanel extends JPanel {
   public AboutPanel(String var1, String var2, String var3, String var4) {
      this(var1, var2, var3, var4, (Image)null);
   }

   public AboutPanel(String var1, String var2, String var3, String var4, Image var5) {
      this.setLayout(new BorderLayout());
      JPanel var6 = new JPanel(new GridLayout(4, 1, 0, 4));
      JPanel var7 = new JPanel();
      Font var8 = new Font("Dialog", 1, 14);
      JLabel var9 = RefineryUtilities.createJLabel(var1, var8, Color.black);
      var9.setHorizontalTextPosition(0);
      var7.add(var9);
      JPanel var10 = new JPanel();
      Font var11 = new Font("Dialog", 0, 12);
      JLabel var12 = RefineryUtilities.createJLabel(var2, var11, Color.black);
      var12.setHorizontalTextPosition(0);
      var10.add(var12);
      JPanel var13 = new JPanel();
      JLabel var14 = RefineryUtilities.createJLabel(var3, var11, Color.black);
      var14.setHorizontalTextPosition(0);
      var13.add(var14);
      JPanel var15 = new JPanel();
      JLabel var16 = RefineryUtilities.createJLabel(var4, var11, Color.black);
      var16.setHorizontalTextPosition(0);
      var15.add(var16);
      var6.add(var7);
      var6.add(var10);
      var6.add(var13);
      var6.add(var15);
      this.add(var6);
      if(var5 != null) {
         JPanel var17 = new JPanel(new BorderLayout());
         var17.add(new JLabel(new ImageIcon(var5)));
         var17.setBorder(BorderFactory.createLineBorder(Color.black));
         JPanel var18 = new JPanel(new BorderLayout());
         var18.add(var17, "North");
         this.add(var18, "West");
      }

   }
}
