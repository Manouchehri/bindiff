package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.date.DateHelpers;
import com.google.security.zynamics.zylib.gui.CDialogEscaper;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.license.CExpiryDialog$InternalButtonListener;
import com.google.security.zynamics.zylib.gui.license.CLicenseFile;
import com.google.security.zynamics.zylib.gui.license.CLicenseFileHelpers;
import com.google.security.zynamics.zylib.gui.panels.CImagePanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public final class CExpiryDialog extends JDialog {
   private static final long serialVersionUID = -1435517664620963264L;
   private static final String COMPANY_NAME = "Google Inc.";
   private final JCheckBox m_checkBox;

   public CExpiryDialog(JFrame var1, String var2, Image var3, Image var4, String var5, CLicenseFile var6, int var7, boolean var8) {
      super(var1, var2);
      new CDialogEscaper(this);
      this.setModal(true);
      this.setIconImage(var3);
      this.m_checkBox = new JCheckBox("Do not show this message again", false);
      this.createDialog(var4, var5, var6, var7, var8);
      this.pack();
      this.setResizable(false);
      GuiHelper.centerChildToParent(var1, this, true);
   }

   private JPanel createButtonPanel(boolean var1) {
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(5, 5, 5, 5));
      JButton var3 = new JButton(new CExpiryDialog$InternalButtonListener(this));
      this.getRootPane().setDefaultButton(var3);
      var3.setSize(var3.getPreferredSize());
      if(var1) {
         var2.add(this.m_checkBox, "West");
         var2.add(var3, "East");
      } else {
         JPanel var4 = new JPanel();
         var4.add(var3);
         var2.add(var4, "Center");
      }

      return var2;
   }

   private void createDialog(Image var1, String var2, CLicenseFile var3, int var4, boolean var5) {
      JPanel var6 = new JPanel(new BorderLayout());
      var6.setBorder(new EmptyBorder(5, 5, 5, 5));
      JPanel var7 = new JPanel(new BorderLayout());
      var7.setBorder(new TitledBorder(""));
      JPanel var8 = this.createHeadPanel(var1, var2);
      JPanel var9 = this.createTablePanel(var3);
      JPanel var10 = this.createSupportStatePanel(var3, var4);
      var7.add(var8, "North");
      var7.add(var9, "Center");
      var7.add(var10, "South");
      JPanel var11 = this.createButtonPanel(var5);
      var6.add(var7, "Center");
      var6.add(var11, "South");
      this.add(var6, "Center");
   }

   private JPanel createHeadPanel(Image var1, String var2) {
      JPanel var3 = new JPanel(new GridBagLayout());
      var3.setBackground(Color.WHITE);
      var3.setBorder(new LineBorder(Color.GRAY));
      int var4 = this.getFontMetrics(this.getFont()).stringWidth((new StringBuilder(6 + String.valueOf(var2).length())).append("   ").append(var2).append("   ").toString());
      int var5 = this.getFontMetrics(this.getFont()).stringWidth("   Google Inc.   ");
      JLabel var6 = new JLabel((new StringBuilder(6 + String.valueOf(var2).length())).append("   ").append(var2).append("   ").toString(), 4);
      var6.setBackground(Color.WHITE);
      JLabel var7 = new JLabel("   Google Inc.   ", 2);
      var7.setBackground(Color.WHITE);
      Font var8 = var6.getFont();
      Font var9 = new Font(var8.getName(), 1, var8.getSize());
      var6.setFont(var9);
      var7.setFont(var9);
      GridBagConstraints var10 = new GridBagConstraints();
      var10.fill = 1;
      var10.gridy = 0;
      var10.gridx = 1;
      var10.weightx = 0.5D;
      var10.weighty = 0.5D;
      if(var5 > var4) {
         var10.ipadx = var5 - var4;
      }

      JPanel var11 = new JPanel(new BorderLayout());
      var11.setBackground(Color.WHITE);
      var11.add(var6, "Center");
      var3.add(var11, var10);
      var10.ipadx = 0;
      var10.gridx = 2;
      var10.weightx = 0.0D;
      var10.weighty = 0.0D;
      CImagePanel var12 = new CImagePanel(var1);
      var3.add(var12, var10);
      var10.gridx = 3;
      var10.weightx = 0.5D;
      var10.weighty = 0.5D;
      if(var4 > var5) {
         var10.ipadx = var4 - var5;
      }

      JPanel var13 = new JPanel(new BorderLayout());
      var13.setBackground(Color.WHITE);
      var13.add(var7, "Center");
      var3.add(var13, var10);
      return var3;
   }

   private JPanel createSupportStatePanel(CLicenseFile var1, int var2) {
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new EmptyBorder(10, 0, 0, 0));
      String var4 = "";
      String var5 = "";
      String var6 = var1.getValue("SupportExpiryDate");
      Date var7 = DateHelpers.getCurrentDate();
      Date var8 = DateHelpers.getDate(var6, "YYYY-MM-DD");
      if(var7.getTime() > var8.getTime()) {
         var4 = "Your support and update plan has expired.";
         var5 = "To renew, purchase another license from our web site.";
      } else {
         long var9 = (long)CLicenseFileHelpers.calculateRemainingDays(var1);
         if(var9 <= (long)var2) {
            var4 = (new StringBuilder(66)).append("Your support and update plan expires in ").append(var9).append(" days.").toString();
            var5 = "To renew, purchase another license from our web site.";
         } else {
            var4 = "Your support and update plan is up to date.";
            var5 = "Please check our web site for updates.";
         }
      }

      JLabel var13 = new JLabel(var4, 0);
      JLabel var10 = new JLabel(var5, 0);
      var13.setBackground(new Color(250, 250, 250));
      var10.setBackground(new Color(250, 250, 250));
      JPanel var11 = new JPanel(new BorderLayout());
      var11.setBorder(new EmptyBorder(5, 5, 5, 5));
      var11.setBackground(new Color(245, 245, 245));
      JPanel var12 = new JPanel(new GridLayout(2, 1, 0, 0));
      var12.setBorder(new EmptyBorder(5, 5, 5, 5));
      var12.setBackground(new Color(245, 245, 245));
      var12.add(var13, "Center");
      var12.add(var10, "Center");
      var3.add(var12, "Center");
      return var3;
   }

   private JPanel createTablePanel(CLicenseFile var1) {
      String var2 = var1.getValue("CustomerName");
      String var3 = var1.getValue("CustomerCompany");
      String var4 = var1.getValue("PurchaseDate");
      String var5 = var1.getValue("SupportExpiryDate");
      JPanel var6 = new JPanel(new GridLayout(5, 2, 20, 5));
      var6.setBorder(new EmptyBorder(10, 0, 0, 0));
      var6.add(new JLabel("Licensed to:", 4));
      var6.add(new JLabel(var2, 2));
      var6.add(new JLabel("Organization:", 4));
      var6.add(new JLabel(var3 != null?var3:"-", 2));
      Date var7 = DateHelpers.getDate(var4, "YYYY-MM-DD");
      Date var8 = DateHelpers.getDate(var5, "YYYY-MM-DD");
      var6.add(new JLabel("Purchase date:", 4));
      var6.add(new JLabel(DateHelpers.formatDate(var7), 2));
      var6.add(new JLabel("Support period expires:", 4));
      var6.add(new JLabel(DateHelpers.formatDate(var8), 2));
      return var6;
   }

   public boolean getCheckboxSelection() {
      return this.m_checkBox.isSelected();
   }
}
