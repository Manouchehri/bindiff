package org.jfree.chart.editor;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.ColorBar;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.editor.DefaultAxisEditor;
import org.jfree.chart.editor.DefaultColorBarEditor;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.ContourPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.layout.LCBLayout;
import org.jfree.ui.PaintSample;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.StrokeChooserPanel;
import org.jfree.ui.StrokeSample;
import org.jfree.util.BooleanUtilities;

class DefaultPlotEditor extends JPanel implements ActionListener {
   private static final String[] orientationNames = new String[]{"Vertical", "Horizontal"};
   private static final int ORIENTATION_VERTICAL = 0;
   private static final int ORIENTATION_HORIZONTAL = 1;
   private PaintSample backgroundPaintSample;
   private StrokeSample outlineStrokeSample;
   private PaintSample outlinePaintSample;
   private DefaultAxisEditor domainAxisPropertyPanel;
   private DefaultAxisEditor rangeAxisPropertyPanel;
   private DefaultColorBarEditor colorBarAxisPropertyPanel;
   private StrokeSample[] availableStrokeSamples;
   private RectangleInsets plotInsets;
   private PlotOrientation plotOrientation;
   private JComboBox orientationCombo;
   private Boolean drawLines;
   private JCheckBox drawLinesCheckBox;
   private Boolean drawShapes;
   private JCheckBox drawShapesCheckBox;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");

   public DefaultPlotEditor(Plot var1) {
      this.plotInsets = var1.getInsets();
      this.backgroundPaintSample = new PaintSample(var1.getBackgroundPaint());
      this.outlineStrokeSample = new StrokeSample(var1.getOutlineStroke());
      this.outlinePaintSample = new PaintSample(var1.getOutlinePaint());
      if(var1 instanceof CategoryPlot) {
         this.plotOrientation = ((CategoryPlot)var1).getOrientation();
      } else if(var1 instanceof XYPlot) {
         this.plotOrientation = ((XYPlot)var1).getOrientation();
      }

      if(var1 instanceof CategoryPlot) {
         CategoryItemRenderer var2 = ((CategoryPlot)var1).getRenderer();
         if(var2 instanceof LineAndShapeRenderer) {
            LineAndShapeRenderer var3 = (LineAndShapeRenderer)var2;
            this.drawLines = BooleanUtilities.valueOf(var3.getBaseLinesVisible());
            this.drawShapes = BooleanUtilities.valueOf(var3.getBaseShapesVisible());
         }
      } else if(var1 instanceof XYPlot) {
         XYItemRenderer var11 = ((XYPlot)var1).getRenderer();
         if(var11 instanceof StandardXYItemRenderer) {
            StandardXYItemRenderer var13 = (StandardXYItemRenderer)var11;
            this.drawLines = BooleanUtilities.valueOf(var13.getPlotLines());
            this.drawShapes = BooleanUtilities.valueOf(var13.getBaseShapesVisible());
         }
      }

      this.setLayout(new BorderLayout());
      this.availableStrokeSamples = new StrokeSample[3];
      this.availableStrokeSamples[0] = new StrokeSample(new BasicStroke(1.0F));
      this.availableStrokeSamples[1] = new StrokeSample(new BasicStroke(2.0F));
      this.availableStrokeSamples[2] = new StrokeSample(new BasicStroke(3.0F));
      JPanel var12 = new JPanel(new BorderLayout());
      var12.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), var1.getPlotType() + localizationResources.getString(":")));
      JPanel var14 = new JPanel(new BorderLayout());
      var14.setBorder(BorderFactory.createTitledBorder(localizationResources.getString("General")));
      JPanel var4 = new JPanel(new LCBLayout(7));
      var4.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
      var4.add(new JLabel(localizationResources.getString("Outline_stroke")));
      JButton var5 = new JButton(localizationResources.getString("Select..."));
      var5.setActionCommand("OutlineStroke");
      var5.addActionListener(this);
      var4.add(this.outlineStrokeSample);
      var4.add(var5);
      var4.add(new JLabel(localizationResources.getString("Outline_Paint")));
      var5 = new JButton(localizationResources.getString("Select..."));
      var5.setActionCommand("OutlinePaint");
      var5.addActionListener(this);
      var4.add(this.outlinePaintSample);
      var4.add(var5);
      var4.add(new JLabel(localizationResources.getString("Background_paint")));
      var5 = new JButton(localizationResources.getString("Select..."));
      var5.setActionCommand("BackgroundPaint");
      var5.addActionListener(this);
      var4.add(this.backgroundPaintSample);
      var4.add(var5);
      if(this.plotOrientation != null) {
         boolean var6 = this.plotOrientation.equals(PlotOrientation.VERTICAL);
         int var7 = var6?0:1;
         var4.add(new JLabel(localizationResources.getString("Orientation")));
         this.orientationCombo = new JComboBox(orientationNames);
         this.orientationCombo.setSelectedIndex(var7);
         this.orientationCombo.setActionCommand("Orientation");
         this.orientationCombo.addActionListener(this);
         var4.add(new JPanel());
         var4.add(this.orientationCombo);
      }

      if(this.drawLines != null) {
         var4.add(new JLabel(localizationResources.getString("Draw_lines")));
         this.drawLinesCheckBox = new JCheckBox();
         this.drawLinesCheckBox.setSelected(this.drawLines.booleanValue());
         this.drawLinesCheckBox.setActionCommand("DrawLines");
         this.drawLinesCheckBox.addActionListener(this);
         var4.add(new JPanel());
         var4.add(this.drawLinesCheckBox);
      }

      if(this.drawShapes != null) {
         var4.add(new JLabel(localizationResources.getString("Draw_shapes")));
         this.drawShapesCheckBox = new JCheckBox();
         this.drawShapesCheckBox.setSelected(this.drawShapes.booleanValue());
         this.drawShapesCheckBox.setActionCommand("DrawShapes");
         this.drawShapesCheckBox.addActionListener(this);
         var4.add(new JPanel());
         var4.add(this.drawShapesCheckBox);
      }

      var14.add(var4, "North");
      JPanel var15 = new JPanel(new BorderLayout());
      var15.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
      var15.add(var14, "North");
      JTabbedPane var16 = new JTabbedPane();
      var16.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
      Object var8 = null;
      if(var1 instanceof CategoryPlot) {
         var8 = ((CategoryPlot)var1).getDomainAxis();
      } else if(var1 instanceof XYPlot) {
         var8 = ((XYPlot)var1).getDomainAxis();
      }

      this.domainAxisPropertyPanel = DefaultAxisEditor.getInstance((Axis)var8);
      if(this.domainAxisPropertyPanel != null) {
         this.domainAxisPropertyPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
         var16.add(localizationResources.getString("Domain_Axis"), this.domainAxisPropertyPanel);
      }

      ValueAxis var9 = null;
      if(var1 instanceof CategoryPlot) {
         var9 = ((CategoryPlot)var1).getRangeAxis();
      } else if(var1 instanceof XYPlot) {
         var9 = ((XYPlot)var1).getRangeAxis();
      }

      this.rangeAxisPropertyPanel = DefaultAxisEditor.getInstance(var9);
      if(this.rangeAxisPropertyPanel != null) {
         this.rangeAxisPropertyPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
         var16.add(localizationResources.getString("Range_Axis"), this.rangeAxisPropertyPanel);
      }

      ColorBar var10 = null;
      if(var1 instanceof ContourPlot) {
         var10 = ((ContourPlot)var1).getColorBar();
      }

      this.colorBarAxisPropertyPanel = DefaultColorBarEditor.getInstance(var10);
      if(this.colorBarAxisPropertyPanel != null) {
         this.colorBarAxisPropertyPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
         var16.add(localizationResources.getString("Color_Bar"), this.colorBarAxisPropertyPanel);
      }

      var16.add(localizationResources.getString("Appearance"), var15);
      var12.add(var16);
      this.add(var12);
   }

   public RectangleInsets getPlotInsets() {
      if(this.plotInsets == null) {
         this.plotInsets = new RectangleInsets(0.0D, 0.0D, 0.0D, 0.0D);
      }

      return this.plotInsets;
   }

   public Paint getBackgroundPaint() {
      return this.backgroundPaintSample.getPaint();
   }

   public Stroke getOutlineStroke() {
      return this.outlineStrokeSample.getStroke();
   }

   public Paint getOutlinePaint() {
      return this.outlinePaintSample.getPaint();
   }

   public DefaultAxisEditor getDomainAxisPropertyEditPanel() {
      return this.domainAxisPropertyPanel;
   }

   public DefaultAxisEditor getRangeAxisPropertyEditPanel() {
      return this.rangeAxisPropertyPanel;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if(var2.equals("BackgroundPaint")) {
         this.attemptBackgroundPaintSelection();
      } else if(var2.equals("OutlineStroke")) {
         this.attemptOutlineStrokeSelection();
      } else if(var2.equals("OutlinePaint")) {
         this.attemptOutlinePaintSelection();
      } else if(var2.equals("Orientation")) {
         this.attemptOrientationSelection();
      } else if(var2.equals("DrawLines")) {
         this.attemptDrawLinesSelection();
      } else if(var2.equals("DrawShapes")) {
         this.attemptDrawShapesSelection();
      }

   }

   private void attemptBackgroundPaintSelection() {
      Color var1 = JColorChooser.showDialog(this, localizationResources.getString("Background_Color"), Color.blue);
      if(var1 != null) {
         this.backgroundPaintSample.setPaint(var1);
      }

   }

   private void attemptOutlineStrokeSelection() {
      StrokeChooserPanel var1 = new StrokeChooserPanel((StrokeSample)null, this.availableStrokeSamples);
      int var2 = JOptionPane.showConfirmDialog(this, var1, localizationResources.getString("Stroke_Selection"), 2, -1);
      if(var2 == 0) {
         this.outlineStrokeSample.setStroke(var1.getSelectedStroke());
      }

   }

   private void attemptOutlinePaintSelection() {
      Color var1 = JColorChooser.showDialog(this, localizationResources.getString("Outline_Color"), Color.blue);
      if(var1 != null) {
         this.outlinePaintSample.setPaint(var1);
      }

   }

   private void attemptOrientationSelection() {
      int var1 = this.orientationCombo.getSelectedIndex();
      if(var1 == 0) {
         this.plotOrientation = PlotOrientation.VERTICAL;
      } else {
         this.plotOrientation = PlotOrientation.HORIZONTAL;
      }

   }

   private void attemptDrawLinesSelection() {
      this.drawLines = BooleanUtilities.valueOf(this.drawLinesCheckBox.isSelected());
   }

   private void attemptDrawShapesSelection() {
      this.drawShapes = BooleanUtilities.valueOf(this.drawShapesCheckBox.isSelected());
   }

   public void updatePlotProperties(Plot var1) {
      var1.setOutlinePaint(this.getOutlinePaint());
      var1.setOutlineStroke(this.getOutlineStroke());
      var1.setBackgroundPaint(this.getBackgroundPaint());
      var1.setInsets(this.getPlotInsets());
      CategoryPlot var3;
      XYPlot var5;
      if(this.domainAxisPropertyPanel != null) {
         Object var2 = null;
         if(var1 instanceof CategoryPlot) {
            var3 = (CategoryPlot)var1;
            var2 = var3.getDomainAxis();
         } else if(var1 instanceof XYPlot) {
            var5 = (XYPlot)var1;
            var2 = var5.getDomainAxis();
         }

         if(var2 != null) {
            this.domainAxisPropertyPanel.setAxisProperties((Axis)var2);
         }
      }

      if(this.rangeAxisPropertyPanel != null) {
         ValueAxis var4 = null;
         if(var1 instanceof CategoryPlot) {
            var3 = (CategoryPlot)var1;
            var4 = var3.getRangeAxis();
         } else if(var1 instanceof XYPlot) {
            var5 = (XYPlot)var1;
            var4 = var5.getRangeAxis();
         }

         if(var4 != null) {
            this.rangeAxisPropertyPanel.setAxisProperties(var4);
         }
      }

      CategoryPlot var7;
      XYPlot var9;
      if(this.plotOrientation != null) {
         if(var1 instanceof CategoryPlot) {
            var7 = (CategoryPlot)var1;
            var7.setOrientation(this.plotOrientation);
         } else if(var1 instanceof XYPlot) {
            var9 = (XYPlot)var1;
            var9.setOrientation(this.plotOrientation);
         }
      }

      CategoryItemRenderer var6;
      XYItemRenderer var8;
      if(this.drawLines != null) {
         if(var1 instanceof CategoryPlot) {
            var7 = (CategoryPlot)var1;
            var6 = var7.getRenderer();
            if(var6 instanceof LineAndShapeRenderer) {
               ((LineAndShapeRenderer)var6).setLinesVisible(this.drawLines.booleanValue());
            }
         } else if(var1 instanceof XYPlot) {
            var9 = (XYPlot)var1;
            var8 = var9.getRenderer();
            if(var8 instanceof StandardXYItemRenderer) {
               ((StandardXYItemRenderer)var8).setPlotLines(this.drawLines.booleanValue());
            }
         }
      }

      if(this.drawShapes != null) {
         if(var1 instanceof CategoryPlot) {
            var7 = (CategoryPlot)var1;
            var6 = var7.getRenderer();
            if(var6 instanceof LineAndShapeRenderer) {
               ((LineAndShapeRenderer)var6).setShapesVisible(this.drawShapes.booleanValue());
            }
         } else if(var1 instanceof XYPlot) {
            var9 = (XYPlot)var1;
            var8 = var9.getRenderer();
            if(var8 instanceof StandardXYItemRenderer) {
               ((StandardXYItemRenderer)var8).setBaseShapesVisible(this.drawShapes.booleanValue());
            }
         }
      }

      if(this.colorBarAxisPropertyPanel != null) {
         ColorBar var11 = null;
         if(var1 instanceof ContourPlot) {
            ContourPlot var10 = (ContourPlot)var1;
            var11 = var10.getColorBar();
         }

         if(var11 != null) {
            this.colorBarAxisPropertyPanel.setAxisProperties(var11);
         }
      }

   }
}
