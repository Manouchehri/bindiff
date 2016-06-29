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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.editor.DefaultNumberAxisEditor;
import org.jfree.layout.LCBLayout;
import org.jfree.ui.FontChooserPanel;
import org.jfree.ui.FontDisplayField;
import org.jfree.ui.PaintSample;
import org.jfree.ui.RectangleInsets;

class DefaultAxisEditor extends JPanel implements ActionListener {
   private JTextField label;
   private Font labelFont;
   private PaintSample labelPaintSample;
   private JTextField labelFontField;
   private Font tickLabelFont;
   private JTextField tickLabelFontField;
   private PaintSample tickLabelPaintSample;
   private JPanel slot1;
   private JPanel slot2;
   private JCheckBox showTickLabelsCheckBox;
   private JCheckBox showTickMarksCheckBox;
   private RectangleInsets tickLabelInsets;
   private RectangleInsets labelInsets;
   private JTabbedPane otherTabs;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");

   public static DefaultAxisEditor getInstance(Axis var0) {
      return (DefaultAxisEditor)(var0 != null?(var0 instanceof NumberAxis?new DefaultNumberAxisEditor((NumberAxis)var0):new DefaultAxisEditor(var0)):null);
   }

   public DefaultAxisEditor(Axis var1) {
      this.labelFont = var1.getLabelFont();
      this.labelPaintSample = new PaintSample(var1.getLabelPaint());
      this.tickLabelFont = var1.getTickLabelFont();
      this.tickLabelPaintSample = new PaintSample(var1.getTickLabelPaint());
      this.tickLabelInsets = var1.getTickLabelInsets();
      this.labelInsets = var1.getLabelInsets();
      this.setLayout(new BorderLayout());
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("General")));
      JPanel var3 = new JPanel(new LCBLayout(5));
      var3.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
      var3.add(new JLabel(localizationResources.getString("Label")));
      this.label = new JTextField(var1.getLabel());
      var3.add(this.label);
      var3.add(new JPanel());
      var3.add(new JLabel(localizationResources.getString("Font")));
      this.labelFontField = new FontDisplayField(this.labelFont);
      var3.add(this.labelFontField);
      JButton var4 = new JButton(localizationResources.getString("Select..."));
      var4.setActionCommand("SelectLabelFont");
      var4.addActionListener(this);
      var3.add(var4);
      var3.add(new JLabel(localizationResources.getString("Paint")));
      var3.add(this.labelPaintSample);
      var4 = new JButton(localizationResources.getString("Select..."));
      var4.setActionCommand("SelectLabelPaint");
      var4.addActionListener(this);
      var3.add(var4);
      var2.add(var3);
      this.add(var2, "North");
      this.slot1 = new JPanel(new BorderLayout());
      JPanel var5 = new JPanel(new BorderLayout());
      var5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("Other")));
      this.otherTabs = new JTabbedPane();
      this.otherTabs.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
      JPanel var6 = new JPanel(new LCBLayout(3));
      var6.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      this.showTickLabelsCheckBox = new JCheckBox(localizationResources.getString("Show_tick_labels"), var1.isTickLabelsVisible());
      var6.add(this.showTickLabelsCheckBox);
      var6.add(new JPanel());
      var6.add(new JPanel());
      var6.add(new JLabel(localizationResources.getString("Tick_label_font")));
      this.tickLabelFontField = new FontDisplayField(this.tickLabelFont);
      var6.add(this.tickLabelFontField);
      var4 = new JButton(localizationResources.getString("Select..."));
      var4.setActionCommand("SelectTickLabelFont");
      var4.addActionListener(this);
      var6.add(var4);
      this.showTickMarksCheckBox = new JCheckBox(localizationResources.getString("Show_tick_marks"), var1.isTickMarksVisible());
      var6.add(this.showTickMarksCheckBox);
      var6.add(new JPanel());
      var6.add(new JPanel());
      this.otherTabs.add(localizationResources.getString("Ticks"), var6);
      var5.add(this.otherTabs);
      this.slot1.add(var5);
      this.slot2 = new JPanel(new BorderLayout());
      this.slot2.add(this.slot1, "North");
      this.add(this.slot2);
   }

   public String getLabel() {
      return this.label.getText();
   }

   public Font getLabelFont() {
      return this.labelFont;
   }

   public Paint getLabelPaint() {
      return this.labelPaintSample.getPaint();
   }

   public boolean isTickLabelsVisible() {
      return this.showTickLabelsCheckBox.isSelected();
   }

   public Font getTickLabelFont() {
      return this.tickLabelFont;
   }

   public Paint getTickLabelPaint() {
      return this.tickLabelPaintSample.getPaint();
   }

   public boolean isTickMarksVisible() {
      return this.showTickMarksCheckBox.isSelected();
   }

   public RectangleInsets getTickLabelInsets() {
      return this.tickLabelInsets == null?new RectangleInsets(0.0D, 0.0D, 0.0D, 0.0D):this.tickLabelInsets;
   }

   public RectangleInsets getLabelInsets() {
      return this.labelInsets == null?new RectangleInsets(0.0D, 0.0D, 0.0D, 0.0D):this.labelInsets;
   }

   public JTabbedPane getOtherTabs() {
      return this.otherTabs;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if(var2.equals("SelectLabelFont")) {
         this.attemptLabelFontSelection();
      } else if(var2.equals("SelectLabelPaint")) {
         this.attemptModifyLabelPaint();
      } else if(var2.equals("SelectTickLabelFont")) {
         this.attemptTickLabelFontSelection();
      }

   }

   private void attemptLabelFontSelection() {
      FontChooserPanel var1 = new FontChooserPanel(this.labelFont);
      int var2 = JOptionPane.showConfirmDialog(this, var1, localizationResources.getString("Font_Selection"), 2, -1);
      if(var2 == 0) {
         this.labelFont = var1.getSelectedFont();
         this.labelFontField.setText(this.labelFont.getFontName() + " " + this.labelFont.getSize());
      }

   }

   private void attemptModifyLabelPaint() {
      Color var1 = JColorChooser.showDialog(this, localizationResources.getString("Label_Color"), Color.blue);
      if(var1 != null) {
         this.labelPaintSample.setPaint(var1);
      }

   }

   public void attemptTickLabelFontSelection() {
      FontChooserPanel var1 = new FontChooserPanel(this.tickLabelFont);
      int var2 = JOptionPane.showConfirmDialog(this, var1, localizationResources.getString("Font_Selection"), 2, -1);
      if(var2 == 0) {
         this.tickLabelFont = var1.getSelectedFont();
         this.tickLabelFontField.setText(this.tickLabelFont.getFontName() + " " + this.tickLabelFont.getSize());
      }

   }

   public void setAxisProperties(Axis var1) {
      var1.setLabel(this.getLabel());
      var1.setLabelFont(this.getLabelFont());
      var1.setLabelPaint(this.getLabelPaint());
      var1.setTickMarksVisible(this.isTickMarksVisible());
      var1.setTickLabelsVisible(this.isTickLabelsVisible());
      var1.setTickLabelFont(this.getTickLabelFont());
      var1.setTickLabelPaint(this.getTickLabelPaint());
      var1.setTickLabelInsets(this.getTickLabelInsets());
      var1.setLabelInsets(this.getLabelInsets());
   }
}
