package com.google.security.zynamics.zylib.gui.FileChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class FileChooserPanel extends JPanel {
   private final JTextField inputField;
   private final JButton browseButton;

   public FileChooserPanel(String var1, ActionListener var2) {
      this(var1, var2, "...", 0, 0, 0);
   }

   public FileChooserPanel(String var1, ActionListener var2, String var3) {
      this(var1, var2, var3, 0, 0, 0);
   }

   public FileChooserPanel(String var1, ActionListener var2, String var3, int var4, int var5, int var6) {
      super(new BorderLayout());
      this.setBorder(new LineBorder(Color.GRAY));
      this.inputField = new JTextField(var1);
      this.inputField.setEditable(false);
      if(var4 > 0 || var5 > 0) {
         this.setPreferredSize(new Dimension(var4, var5));
      }

      JPanel var7 = new JPanel(new BorderLayout());
      this.browseButton = new JButton(var3);
      this.browseButton.setBorder(new MatteBorder(0, 1, 0, 0, Color.GRAY));
      Dimension var8 = this.browseButton.getPreferredSize();
      this.browseButton.setPreferredSize(new Dimension(var8.width + 15, var8.height));
      if(var6 > 0) {
         this.browseButton.setPreferredSize(new Dimension(var6, var5));
      }

      var7.add(this.browseButton, "Center");
      this.browseButton.setFocusable(false);
      this.add(this.inputField, "Center");
      this.add(var7, "East");
      this.browseButton.addActionListener(var2);
      ToolTipManager.sharedInstance().registerComponent(this.inputField);
      this.inputField.setToolTipText(this.getText());
   }

   public JButton getButton() {
      return this.browseButton;
   }

   public String getText() {
      return this.inputField.getText();
   }

   public void setEnabled(boolean var1) {
      this.browseButton.setEnabled(var1);
      super.setEnabled(var1);
   }

   public void setText(String var1) {
      this.inputField.setText(var1);
   }
}
