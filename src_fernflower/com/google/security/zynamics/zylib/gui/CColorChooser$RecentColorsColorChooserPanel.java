package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CColorChooser;
import com.google.security.zynamics.zylib.gui.CColorChooser$RecentColorsColorChooserPanel$1;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;

class CColorChooser$RecentColorsColorChooserPanel extends AbstractColorChooserPanel {
   // $FF: synthetic field
   final CColorChooser this$0;

   CColorChooser$RecentColorsColorChooserPanel(CColorChooser var1) {
      this.this$0 = var1;
   }

   protected void buildChooser() {
      JPanel var1 = new JPanel();
      var1.setLayout(new GridLayout(this.this$0.m_recentColors.length, 1, 1, 1));
      Color[] var2 = this.this$0.m_recentColors;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Color var5 = var2[var4];
         ColorPanel var6 = new ColorPanel(var5, false, true);
         var6.addMouseListener(new CColorChooser$RecentColorsColorChooserPanel$1(this, var5));
         var6.setPreferredSize(new Dimension(200, 25));
         JPanel var7 = new JPanel();
         var7.setBorder(new EmptyBorder(1, 1, 1, 1));
         var7.add(var6, "First");
         var1.add(var6);
      }

      GridBagConstraints var8 = new GridBagConstraints();
      var8.gridx = 0;
      var8.gridy = 0;
      var8.anchor = 23;
      var8.weightx = 1.0D;
      var8.fill = 2;
      JPanel var9 = new JPanel(new GridBagLayout());
      var9.add(var1, var8);
      JPanel var10 = new JPanel(new BorderLayout());
      var10.add(var9, "North");
      JScrollPane var11 = new JScrollPane(var10);
      var11.setBorder((Border)null);
      var11.setHorizontalScrollBarPolicy(30);
      var11.setVerticalScrollBarPolicy(20);
      this.add(var11, "Center");
   }

   public String getDisplayName() {
      return "Recent Colors";
   }

   public Icon getLargeDisplayIcon() {
      return null;
   }

   public Icon getSmallDisplayIcon() {
      return null;
   }

   public void updateChooser() {
   }
}
