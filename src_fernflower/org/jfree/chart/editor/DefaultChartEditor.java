package org.jfree.chart.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.editor.ChartEditor;
import org.jfree.chart.editor.DefaultPlotEditor;
import org.jfree.chart.editor.DefaultTitleEditor;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.title.TextTitle;
import org.jfree.layout.LCBLayout;
import org.jfree.ui.PaintSample;

class DefaultChartEditor extends JPanel implements ActionListener, ChartEditor {
   private DefaultTitleEditor titleEditor;
   private DefaultPlotEditor plotEditor;
   private JCheckBox antialias;
   private PaintSample background;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");

   public DefaultChartEditor(JFreeChart var1) {
      this.setLayout(new BorderLayout());
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("General")));
      JPanel var4 = new JPanel(new LCBLayout(6));
      var4.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
      this.antialias = new JCheckBox(localizationResources.getString("Draw_anti-aliased"));
      this.antialias.setSelected(var1.getAntiAlias());
      var4.add(this.antialias);
      var4.add(new JLabel(""));
      var4.add(new JLabel(""));
      var4.add(new JLabel(localizationResources.getString("Background_paint")));
      this.background = new PaintSample(var1.getBackgroundPaint());
      var4.add(this.background);
      JButton var5 = new JButton(localizationResources.getString("Select..."));
      var5.setActionCommand("BackgroundPaint");
      var5.addActionListener(this);
      var4.add(var5);
      var4.add(new JLabel(localizationResources.getString("Series_Paint")));
      JTextField var6 = new JTextField(localizationResources.getString("No_editor_implemented"));
      var6.setEnabled(false);
      var4.add(var6);
      var5 = new JButton(localizationResources.getString("Edit..."));
      var5.setEnabled(false);
      var4.add(var5);
      var4.add(new JLabel(localizationResources.getString("Series_Stroke")));
      var6 = new JTextField(localizationResources.getString("No_editor_implemented"));
      var6.setEnabled(false);
      var4.add(var6);
      var5 = new JButton(localizationResources.getString("Edit..."));
      var5.setEnabled(false);
      var4.add(var5);
      var4.add(new JLabel(localizationResources.getString("Series_Outline_Paint")));
      var6 = new JTextField(localizationResources.getString("No_editor_implemented"));
      var6.setEnabled(false);
      var4.add(var6);
      var5 = new JButton(localizationResources.getString("Edit..."));
      var5.setEnabled(false);
      var4.add(var5);
      var4.add(new JLabel(localizationResources.getString("Series_Outline_Stroke")));
      var6 = new JTextField(localizationResources.getString("No_editor_implemented"));
      var6.setEnabled(false);
      var4.add(var6);
      var5 = new JButton(localizationResources.getString("Edit..."));
      var5.setEnabled(false);
      var4.add(var5);
      var3.add(var4, "North");
      var2.add(var3, "North");
      JPanel var7 = new JPanel(new BorderLayout());
      TextTitle var8 = var1.getTitle();
      Plot var9 = var1.getPlot();
      JTabbedPane var10 = new JTabbedPane();
      this.titleEditor = new DefaultTitleEditor(var8);
      this.titleEditor.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
      var10.addTab(localizationResources.getString("Title"), this.titleEditor);
      this.plotEditor = new DefaultPlotEditor(var9);
      this.plotEditor.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
      var10.addTab(localizationResources.getString("Plot"), this.plotEditor);
      var10.add(localizationResources.getString("Other"), var2);
      var7.add(var10, "North");
      this.add(var7);
   }

   public DefaultTitleEditor getTitleEditor() {
      return this.titleEditor;
   }

   public DefaultPlotEditor getPlotEditor() {
      return this.plotEditor;
   }

   public boolean getAntiAlias() {
      return this.antialias.isSelected();
   }

   public Paint getBackgroundPaint() {
      return this.background.getPaint();
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if(var2.equals("BackgroundPaint")) {
         this.attemptModifyBackgroundPaint();
      }

   }

   private void attemptModifyBackgroundPaint() {
      Color var1 = JColorChooser.showDialog(this, localizationResources.getString("Background_Color"), Color.blue);
      if(var1 != null) {
         this.background.setPaint(var1);
      }

   }

   public void updateChart(JFreeChart var1) {
      this.titleEditor.setTitleProperties(var1);
      this.plotEditor.updatePlotProperties(var1.getPlot());
      var1.setAntiAlias(this.getAntiAlias());
      var1.setBackgroundPaint(this.getBackgroundPaint());
   }
}
