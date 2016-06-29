package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CColorChooser$RecentColorsColorChooserPanel;
import com.google.security.zynamics.zylib.gui.CColorChooser$SelectedColorActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.colorchooser.DefaultColorSelectionModel;

public class CColorChooser extends JColorChooser {
   final Color[] m_recentColors;

   public CColorChooser() {
      this((ColorSelectionModel)(new DefaultColorSelectionModel(Color.WHITE)), (Color[])null);
   }

   public CColorChooser(Color var1) {
      this((ColorSelectionModel)(new DefaultColorSelectionModel(var1)), (Color[])null);
   }

   public CColorChooser(Color var1, Color[] var2) {
      this((ColorSelectionModel)(new DefaultColorSelectionModel(var1)), var2);
   }

   public CColorChooser(ColorSelectionModel var1) {
      this((ColorSelectionModel)var1, (Color[])null);
   }

   public CColorChooser(ColorSelectionModel var1, Color[] var2) {
      super(var1);
      AbstractColorChooserPanel[] var3 = this.getChooserPanels();
      if(var3.length > 0) {
         this.removeChooserPanel(var3[0]);
      }

      this.m_recentColors = var2;
      if(this.m_recentColors != null) {
         this.addChooserPanel(new CColorChooser$RecentColorsColorChooserPanel(this));
      }

   }

   public static JDialog createDialog(Component var0, String var1, boolean var2, CColorChooser var3, ActionListener var4, ActionListener var5) {
      return JColorChooser.createDialog(var0, var1, var2, var3, var4, var5);
   }

   public static Color showDialog(Component var0, String var1, Color var2) {
      return showDialog(var0, var1, var2, (Color[])null);
   }

   public static Color showDialog(Component var0, String var1, Color var2, Color[] var3) {
      CColorChooser var4 = new CColorChooser(var2, var3);
      var4.getClass();
      CColorChooser$SelectedColorActionListener var5 = new CColorChooser$SelectedColorActionListener(var4);
      JDialog var6 = createDialog(var0, var1, true, var4, var5, (ActionListener)null);
      var6.setVisible(true);
      var6.dispose();
      return var5.getColor();
   }
}
