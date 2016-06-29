package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class FontChooserPanel extends JPanel {
   public static final String[] SIZES = new String[]{"9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "28", "36", "48", "72"};
   private JList fontlist;
   private JList sizelist;
   private JCheckBox bold;
   private JCheckBox italic;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");

   public FontChooserPanel(Font var1) {
      GraphicsEnvironment var2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
      String[] var3 = var2.getAvailableFontFamilyNames();
      this.setLayout(new BorderLayout());
      JPanel var4 = new JPanel(new BorderLayout());
      JPanel var5 = new JPanel(new BorderLayout());
      var5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("Font")));
      this.fontlist = new JList(var3);
      JScrollPane var6 = new JScrollPane(this.fontlist);
      var6.setBorder(BorderFactory.createEtchedBorder());
      var5.add(var6);
      this.add(var5);
      JPanel var7 = new JPanel(new BorderLayout());
      var7.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("Size")));
      this.sizelist = new JList(SIZES);
      JScrollPane var8 = new JScrollPane(this.sizelist);
      var8.setBorder(BorderFactory.createEtchedBorder());
      var7.add(var8);
      JPanel var9 = new JPanel(new GridLayout(1, 2));
      this.bold = new JCheckBox(localizationResources.getString("Bold"));
      this.italic = new JCheckBox(localizationResources.getString("Italic"));
      var9.add(this.bold);
      var9.add(this.italic);
      var9.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("Attributes")));
      var4.add(var7, "Center");
      var4.add(var9, "South");
      this.add(var4, "East");
      this.setSelectedFont(var1);
   }

   public Font getSelectedFont() {
      return new Font(this.getSelectedName(), this.getSelectedStyle(), this.getSelectedSize());
   }

   public String getSelectedName() {
      return (String)this.fontlist.getSelectedValue();
   }

   public int getSelectedStyle() {
      return this.bold.isSelected() && this.italic.isSelected()?3:(this.bold.isSelected()?1:(this.italic.isSelected()?2:0));
   }

   public int getSelectedSize() {
      String var1 = (String)this.sizelist.getSelectedValue();
      return var1 != null?Integer.parseInt(var1):10;
   }

   public void setSelectedFont(Font var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bold.setSelected(var1.isBold());
         this.italic.setSelected(var1.isItalic());
         String var2 = var1.getName();
         ListModel var3 = this.fontlist.getModel();
         this.fontlist.clearSelection();

         for(int var4 = 0; var4 < var3.getSize(); ++var4) {
            if(var2.equals(var3.getElementAt(var4))) {
               this.fontlist.setSelectedIndex(var4);
               break;
            }
         }

         String var6 = String.valueOf(var1.getSize());
         var3 = this.sizelist.getModel();
         this.sizelist.clearSelection();

         for(int var5 = 0; var5 < var3.getSize(); ++var5) {
            if(var6.equals(var3.getElementAt(var5))) {
               this.sizelist.setSelectedIndex(var5);
               break;
            }
         }

      }
   }
}
