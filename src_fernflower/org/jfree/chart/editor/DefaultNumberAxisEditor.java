package org.jfree.chart.editor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.editor.DefaultAxisEditor;
import org.jfree.layout.LCBLayout;
import org.jfree.ui.PaintSample;
import org.jfree.ui.StrokeChooserPanel;
import org.jfree.ui.StrokeSample;

class DefaultNumberAxisEditor extends DefaultAxisEditor implements FocusListener {
   private boolean autoRange;
   private double minimumValue;
   private double maximumValue;
   private JCheckBox autoRangeCheckBox;
   private JTextField minimumRangeValue;
   private JTextField maximumRangeValue;
   private PaintSample gridPaintSample;
   private StrokeSample gridStrokeSample;
   private StrokeSample[] availableStrokeSamples;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");

   public DefaultNumberAxisEditor(NumberAxis var1) {
      super(var1);
      this.autoRange = var1.isAutoRange();
      this.minimumValue = var1.getLowerBound();
      this.maximumValue = var1.getUpperBound();
      this.gridPaintSample = new PaintSample(Color.blue);
      this.gridStrokeSample = new StrokeSample(new BasicStroke(1.0F));
      this.availableStrokeSamples = new StrokeSample[3];
      this.availableStrokeSamples[0] = new StrokeSample(new BasicStroke(1.0F));
      this.availableStrokeSamples[1] = new StrokeSample(new BasicStroke(2.0F));
      this.availableStrokeSamples[2] = new StrokeSample(new BasicStroke(3.0F));
      JTabbedPane var2 = this.getOtherTabs();
      JPanel var3 = new JPanel(new LCBLayout(3));
      var3.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      var3.add(new JPanel());
      this.autoRangeCheckBox = new JCheckBox(localizationResources.getString("Auto-adjust_range"), this.autoRange);
      this.autoRangeCheckBox.setActionCommand("AutoRangeOnOff");
      this.autoRangeCheckBox.addActionListener(this);
      var3.add(this.autoRangeCheckBox);
      var3.add(new JPanel());
      var3.add(new JLabel(localizationResources.getString("Minimum_range_value")));
      this.minimumRangeValue = new JTextField(Double.toString(this.minimumValue));
      this.minimumRangeValue.setEnabled(!this.autoRange);
      this.minimumRangeValue.setActionCommand("MinimumRange");
      this.minimumRangeValue.addActionListener(this);
      this.minimumRangeValue.addFocusListener(this);
      var3.add(this.minimumRangeValue);
      var3.add(new JPanel());
      var3.add(new JLabel(localizationResources.getString("Maximum_range_value")));
      this.maximumRangeValue = new JTextField(Double.toString(this.maximumValue));
      this.maximumRangeValue.setEnabled(!this.autoRange);
      this.maximumRangeValue.setActionCommand("MaximumRange");
      this.maximumRangeValue.addActionListener(this);
      this.maximumRangeValue.addFocusListener(this);
      var3.add(this.maximumRangeValue);
      var3.add(new JPanel());
      var2.add(localizationResources.getString("Range"), var3);
   }

   public boolean isAutoRange() {
      return this.autoRange;
   }

   public double getMinimumValue() {
      return this.minimumValue;
   }

   public double getMaximumValue() {
      return this.maximumValue;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if(var2.equals("GridStroke")) {
         this.attemptGridStrokeSelection();
      } else if(var2.equals("GridPaint")) {
         this.attemptGridPaintSelection();
      } else if(var2.equals("AutoRangeOnOff")) {
         this.toggleAutoRange();
      } else if(var2.equals("MinimumRange")) {
         this.validateMinimum();
      } else if(var2.equals("MaximumRange")) {
         this.validateMaximum();
      } else {
         super.actionPerformed(var1);
      }

   }

   private void attemptGridStrokeSelection() {
      StrokeChooserPanel var1 = new StrokeChooserPanel((StrokeSample)null, this.availableStrokeSamples);
      int var2 = JOptionPane.showConfirmDialog(this, var1, localizationResources.getString("Stroke_Selection"), 2, -1);
      if(var2 == 0) {
         this.gridStrokeSample.setStroke(var1.getSelectedStroke());
      }

   }

   private void attemptGridPaintSelection() {
      Color var1 = JColorChooser.showDialog(this, localizationResources.getString("Grid_Color"), Color.blue);
      if(var1 != null) {
         this.gridPaintSample.setPaint(var1);
      }

   }

   public void focusGained(FocusEvent var1) {
   }

   public void focusLost(FocusEvent var1) {
      if(var1.getSource() == this.minimumRangeValue) {
         this.validateMinimum();
      } else if(var1.getSource() == this.maximumRangeValue) {
         this.validateMaximum();
      }

   }

   public void toggleAutoRange() {
      this.autoRange = this.autoRangeCheckBox.isSelected();
      if(this.autoRange) {
         this.minimumRangeValue.setText(Double.toString(this.minimumValue));
         this.minimumRangeValue.setEnabled(false);
         this.maximumRangeValue.setText(Double.toString(this.maximumValue));
         this.maximumRangeValue.setEnabled(false);
      } else {
         this.minimumRangeValue.setEnabled(true);
         this.maximumRangeValue.setEnabled(true);
      }

   }

   public void validateMinimum() {
      double var1;
      try {
         var1 = Double.parseDouble(this.minimumRangeValue.getText());
         if(var1 >= this.maximumValue) {
            var1 = this.minimumValue;
         }
      } catch (NumberFormatException var4) {
         var1 = this.minimumValue;
      }

      this.minimumValue = var1;
      this.minimumRangeValue.setText(Double.toString(this.minimumValue));
   }

   public void validateMaximum() {
      double var1;
      try {
         var1 = Double.parseDouble(this.maximumRangeValue.getText());
         if(var1 <= this.minimumValue) {
            var1 = this.maximumValue;
         }
      } catch (NumberFormatException var4) {
         var1 = this.maximumValue;
      }

      this.maximumValue = var1;
      this.maximumRangeValue.setText(Double.toString(this.maximumValue));
   }

   public void setAxisProperties(Axis var1) {
      super.setAxisProperties(var1);
      NumberAxis var2 = (NumberAxis)var1;
      var2.setAutoRange(this.autoRange);
      if(!this.autoRange) {
         var2.setRange(this.minimumValue, this.maximumValue);
      }

   }
}
