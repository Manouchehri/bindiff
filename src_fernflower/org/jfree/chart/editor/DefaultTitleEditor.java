package org.jfree.chart.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.layout.LCBLayout;
import org.jfree.ui.FontChooserPanel;
import org.jfree.ui.FontDisplayField;
import org.jfree.ui.PaintSample;

class DefaultTitleEditor extends JPanel implements ActionListener {
   private boolean showTitle;
   private JCheckBox showTitleCheckBox;
   private JTextField titleField;
   private Font titleFont;
   private JTextField fontfield;
   private JButton selectFontButton;
   private PaintSample titlePaint;
   private JButton selectPaintButton;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");

   public DefaultTitleEditor(Title var1) {
      TextTitle var2 = var1 != null?(TextTitle)var1:new TextTitle(localizationResources.getString("Title"));
      this.showTitle = var1 != null;
      this.titleFont = var2.getFont();
      this.titleField = new JTextField(var2.getText());
      this.titlePaint = new PaintSample(var2.getPaint());
      this.setLayout(new BorderLayout());
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("General")));
      JPanel var4 = new JPanel(new LCBLayout(4));
      var4.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
      var4.add(new JLabel(localizationResources.getString("Show_Title")));
      this.showTitleCheckBox = new JCheckBox();
      this.showTitleCheckBox.setSelected(this.showTitle);
      this.showTitleCheckBox.setActionCommand("ShowTitle");
      this.showTitleCheckBox.addActionListener(this);
      var4.add(new JPanel());
      var4.add(this.showTitleCheckBox);
      JLabel var5 = new JLabel(localizationResources.getString("Text"));
      var4.add(var5);
      var4.add(this.titleField);
      var4.add(new JPanel());
      JLabel var6 = new JLabel(localizationResources.getString("Font"));
      this.fontfield = new FontDisplayField(this.titleFont);
      this.selectFontButton = new JButton(localizationResources.getString("Select..."));
      this.selectFontButton.setActionCommand("SelectFont");
      this.selectFontButton.addActionListener(this);
      var4.add(var6);
      var4.add(this.fontfield);
      var4.add(this.selectFontButton);
      JLabel var7 = new JLabel(localizationResources.getString("Color"));
      this.selectPaintButton = new JButton(localizationResources.getString("Select..."));
      this.selectPaintButton.setActionCommand("SelectPaint");
      this.selectPaintButton.addActionListener(this);
      var4.add(var7);
      var4.add(this.titlePaint);
      var4.add(this.selectPaintButton);
      this.enableOrDisableControls();
      var3.add(var4);
      this.add(var3, "North");
   }

   public String getTitleText() {
      return this.titleField.getText();
   }

   public Font getTitleFont() {
      return this.titleFont;
   }

   public Paint getTitlePaint() {
      return this.titlePaint.getPaint();
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if(var2.equals("SelectFont")) {
         this.attemptFontSelection();
      } else if(var2.equals("SelectPaint")) {
         this.attemptPaintSelection();
      } else if(var2.equals("ShowTitle")) {
         this.attemptModifyShowTitle();
      }

   }

   public void attemptFontSelection() {
      FontChooserPanel var1 = new FontChooserPanel(this.titleFont);
      int var2 = JOptionPane.showConfirmDialog(this, var1, localizationResources.getString("Font_Selection"), 2, -1);
      if(var2 == 0) {
         this.titleFont = var1.getSelectedFont();
         this.fontfield.setText(this.titleFont.getFontName() + " " + this.titleFont.getSize());
      }

   }

   public void attemptPaintSelection() {
      Paint var1 = this.titlePaint.getPaint();
      Color var2 = var1 instanceof Color?(Color)var1:Color.blue;
      Color var3 = JColorChooser.showDialog(this, localizationResources.getString("Title_Color"), var2);
      if(var3 != null) {
         this.titlePaint.setPaint(var3);
      }

   }

   private void attemptModifyShowTitle() {
      this.showTitle = this.showTitleCheckBox.isSelected();
      this.enableOrDisableControls();
   }

   private void enableOrDisableControls() {
      boolean var1 = this.showTitle;
      this.titleField.setEnabled(var1);
      this.selectFontButton.setEnabled(var1);
      this.selectPaintButton.setEnabled(var1);
   }

   public void setTitleProperties(JFreeChart var1) {
      if(this.showTitle) {
         TextTitle var2 = var1.getTitle();
         if(var2 == null) {
            var2 = new TextTitle();
            var1.setTitle(var2);
         }

         var2.setText(this.getTitleText());
         var2.setFont(this.getTitleFont());
         var2.setPaint(this.getTitlePaint());
      } else {
         var1.setTitle((TextTitle)null);
      }

   }
}
