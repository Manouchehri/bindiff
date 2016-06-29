package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.bindiff.utils.GuiUtils$1;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GuiUtils {
   public static JCheckBoxMenuItem buildCheckBoxMenuItem(String var0, AbstractAction var1) {
      JCheckBoxMenuItem var2 = new JCheckBoxMenuItem(var0);
      var2.addActionListener(var1);
      return var2;
   }

   public static JCheckBoxMenuItem buildCheckBoxMenuItem(String var0, char var1, AbstractAction var2) {
      JCheckBoxMenuItem var3 = new JCheckBoxMenuItem(var0);
      var3.setMnemonic(var1);
      var3.addActionListener(var2);
      return var3;
   }

   public static JCheckBoxMenuItem buildCheckBoxMenuItem(String var0, char var1, int var2, int var3, AbstractAction var4) {
      JCheckBoxMenuItem var5 = buildCheckBoxMenuItem(var0, var1, var4);
      var5.setAccelerator(KeyStroke.getKeyStroke(var2, var3));
      return var5;
   }

   public static JMenu buildMenu(String var0, char var1) {
      JMenu var2 = new JMenu(var0);
      var2.setMnemonic(var1);
      return var2;
   }

   public static JMenuItem buildMenuItem(String var0, AbstractAction var1) {
      return buildMenuItem(var0, '\uffff', -1, 0, var1, true);
   }

   public static JMenuItem buildMenuItem(String var0, AbstractAction var1, boolean var2) {
      return buildMenuItem(var0, '\uffff', -1, 0, var1, var2);
   }

   public static JMenuItem buildMenuItem(String var0, char var1, AbstractAction var2) {
      return buildMenuItem(var0, var1, -1, 0, var2, true);
   }

   public static JMenuItem buildMenuItem(String var0, char var1, AbstractAction var2, boolean var3) {
      return buildMenuItem(var0, var1, -1, 0, var2, var3);
   }

   public static JMenuItem buildMenuItem(String var0, char var1, char var2, AbstractAction var3) {
      JMenuItem var4 = buildMenuItem(var0, var1, var3);
      var4.setAccelerator(KeyStroke.getKeyStroke(var2));
      return var4;
   }

   public static JMenuItem buildMenuItem(String var0, char var1, int var2, int var3, AbstractAction var4) {
      return buildMenuItem(var0, var1, var2, var3, var4, true);
   }

   public static JMenuItem buildMenuItem(String var0, char var1, int var2, int var3, AbstractAction var4, boolean var5) {
      JMenuItem var6 = new JMenuItem(var0, var1);
      if(var2 >= 0) {
         var6.setAccelerator(KeyStroke.getKeyStroke(var2, var3));
      }

      var6.setEnabled(var5);
      var6.addActionListener(var4);
      return var6;
   }

   public static JMenuItem buildMenuItem(String var0, Icon var1, AbstractAction var2) {
      JMenuItem var3 = buildMenuItem(var0, '\uffff', -1, 0, var2, true);
      var3.setIcon(var1);
      return var3;
   }

   public static JMenuItem buildMenuItem(String var0, int var1, int var2, AbstractAction var3) {
      return buildMenuItem(var0, '\uffff', var1, var2, var3, true);
   }

   public static JRadioButtonMenuItem buildRadioButtonMenuItem(String var0, char var1, AbstractAction var2) {
      JRadioButtonMenuItem var3 = new JRadioButtonMenuItem(var0);
      var3.setMnemonic(var1);
      var3.addActionListener(var2);
      return var3;
   }

   public static JRadioButtonMenuItem buildRadioButtonMenuItem(String var0, char var1, int var2, int var3, AbstractAction var4) {
      JRadioButtonMenuItem var5 = buildRadioButtonMenuItem(var0, var1, var4);
      var5.setAccelerator(KeyStroke.getKeyStroke(var2, var3));
      return var5;
   }

   public static Component createHorizontalNamedComponent(JPanel var0, String var1, Component var2, int var3, int var4, boolean var5) {
      var2.setPreferredSize(new Dimension(var3, var4));
      JPanel var6 = new JPanel(new BorderLayout());
      var6.setBorder(new EmptyBorder(0, 2, var5?2:0, 2));
      var6.add(new JLabel(var1), "Center");
      var6.add(var2, "East");
      var0.add(var6);
      return var2;
   }

   public static JPanel createHorizontalNamedComponentPanel(String var0, int var1, JComponent var2, int var3) {
      JPanel var4 = new JPanel(new BorderLayout());
      JLabel var5 = new JLabel(var0);
      var5.setPreferredSize(new Dimension(var1, var3));
      var2.setPreferredSize(new Dimension(var2.getPreferredSize().width, var3));
      var4.add(var5, "West");
      var4.add(var2, "Center");
      var4.setPreferredSize(new Dimension(var4.getPreferredSize().width, var3));
      return var4;
   }

   public static JPanel createHorizontalNamedLabelPanel(String var0, int var1, JLabel var2, int var3) {
      JPanel var4 = new JPanel(new BorderLayout());
      var4.setBorder(new EmptyBorder(0, 3, 2, 3));
      var4.setBackground(Color.WHITE);
      JLabel var5 = new JLabel(var0);
      var5.setPreferredSize(new Dimension(var1, var3));
      var4.setPreferredSize(new Dimension(0, var3));
      var2.setForeground(new Color(0, 0, 160));
      var2.setMinimumSize(new Dimension(0, 0));
      var4.add(var5, "West");
      var4.add(var2, "Center");
      return var4;
   }

   public static Component createHorizontalNamedLabelPanel(String var0, int var1, JTextField var2, int var3) {
      var2.setEditable(false);
      var2.setBorder((Border)null);
      var2.setForeground(new Color(0, 0, 160));
      var2.setBackground(Color.WHITE);
      JPanel var4 = new JPanel(new BorderLayout());
      var4.setBorder(new EmptyBorder(0, 3, 2, 3));
      var4.setBackground(Color.WHITE);
      JLabel var5 = new JLabel(var0);
      var5.setPreferredSize(new Dimension(var1, var3));
      var4.setPreferredSize(new Dimension(0, var3));
      var4.add(var5, "West");
      var4.add(var2, "Center");
      return var4;
   }

   public static void setWindowIcons(Window var0, String var1, String var2, String var3) {
      ArrayList var4 = new ArrayList();
      var4.add(ImageUtils.getImage(var1));
      var4.add(ImageUtils.getImage(var2));
      var4.add(ImageUtils.getImage(var3));
      var0.setIconImages(var4);
   }

   public static void updateLater(JComponent var0) {
      EventQueue.invokeLater(new GuiUtils$1(var0));
   }
}
