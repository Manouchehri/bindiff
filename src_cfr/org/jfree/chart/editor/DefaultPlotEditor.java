/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.editor;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
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
import javax.swing.border.Border;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.CategoryAxis;
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

class DefaultPlotEditor
extends JPanel
implements ActionListener {
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

    public DefaultPlotEditor(Plot plot) {
        Object object;
        this.plotInsets = plot.getInsets();
        this.backgroundPaintSample = new PaintSample(plot.getBackgroundPaint());
        this.outlineStrokeSample = new StrokeSample(plot.getOutlineStroke());
        this.outlinePaintSample = new PaintSample(plot.getOutlinePaint());
        if (plot instanceof CategoryPlot) {
            this.plotOrientation = ((CategoryPlot)plot).getOrientation();
        } else if (plot instanceof XYPlot) {
            this.plotOrientation = ((XYPlot)plot).getOrientation();
        }
        if (plot instanceof CategoryPlot) {
            object = ((CategoryPlot)plot).getRenderer();
            if (object instanceof LineAndShapeRenderer) {
                LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)object;
                this.drawLines = BooleanUtilities.valueOf(lineAndShapeRenderer.getBaseLinesVisible());
                this.drawShapes = BooleanUtilities.valueOf(lineAndShapeRenderer.getBaseShapesVisible());
            }
        } else if (plot instanceof XYPlot && (object = ((XYPlot)plot).getRenderer()) instanceof StandardXYItemRenderer) {
            StandardXYItemRenderer standardXYItemRenderer = (StandardXYItemRenderer)object;
            this.drawLines = BooleanUtilities.valueOf(standardXYItemRenderer.getPlotLines());
            this.drawShapes = BooleanUtilities.valueOf(standardXYItemRenderer.getBaseShapesVisible());
        }
        this.setLayout(new BorderLayout());
        this.availableStrokeSamples = new StrokeSample[3];
        this.availableStrokeSamples[0] = new StrokeSample(new BasicStroke(1.0f));
        this.availableStrokeSamples[1] = new StrokeSample(new BasicStroke(2.0f));
        this.availableStrokeSamples[2] = new StrokeSample(new BasicStroke(3.0f));
        object = new JPanel(new BorderLayout());
        object.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), new StringBuffer().append(plot.getPlotType()).append(localizationResources.getString(":")).toString()));
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createTitledBorder(localizationResources.getString("General")));
        JPanel jPanel2 = new JPanel(new LCBLayout(7));
        jPanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        jPanel2.add(new JLabel(localizationResources.getString("Outline_stroke")));
        JButton jButton = new JButton(localizationResources.getString("Select..."));
        jButton.setActionCommand("OutlineStroke");
        jButton.addActionListener(this);
        jPanel2.add(this.outlineStrokeSample);
        jPanel2.add(jButton);
        jPanel2.add(new JLabel(localizationResources.getString("Outline_Paint")));
        jButton = new JButton(localizationResources.getString("Select..."));
        jButton.setActionCommand("OutlinePaint");
        jButton.addActionListener(this);
        jPanel2.add(this.outlinePaintSample);
        jPanel2.add(jButton);
        jPanel2.add(new JLabel(localizationResources.getString("Background_paint")));
        jButton = new JButton(localizationResources.getString("Select..."));
        jButton.setActionCommand("BackgroundPaint");
        jButton.addActionListener(this);
        jPanel2.add(this.backgroundPaintSample);
        jPanel2.add(jButton);
        if (this.plotOrientation != null) {
            boolean bl2 = this.plotOrientation.equals(PlotOrientation.VERTICAL);
            int n2 = bl2 ? 0 : 1;
            jPanel2.add(new JLabel(localizationResources.getString("Orientation")));
            this.orientationCombo = new JComboBox<String>(orientationNames);
            this.orientationCombo.setSelectedIndex(n2);
            this.orientationCombo.setActionCommand("Orientation");
            this.orientationCombo.addActionListener(this);
            jPanel2.add(new JPanel());
            jPanel2.add(this.orientationCombo);
        }
        if (this.drawLines != null) {
            jPanel2.add(new JLabel(localizationResources.getString("Draw_lines")));
            this.drawLinesCheckBox = new JCheckBox();
            this.drawLinesCheckBox.setSelected(this.drawLines);
            this.drawLinesCheckBox.setActionCommand("DrawLines");
            this.drawLinesCheckBox.addActionListener(this);
            jPanel2.add(new JPanel());
            jPanel2.add(this.drawLinesCheckBox);
        }
        if (this.drawShapes != null) {
            jPanel2.add(new JLabel(localizationResources.getString("Draw_shapes")));
            this.drawShapesCheckBox = new JCheckBox();
            this.drawShapesCheckBox.setSelected(this.drawShapes);
            this.drawShapesCheckBox.setActionCommand("DrawShapes");
            this.drawShapesCheckBox.addActionListener(this);
            jPanel2.add(new JPanel());
            jPanel2.add(this.drawShapesCheckBox);
        }
        jPanel.add((Component)jPanel2, "North");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel3.add((Component)jPanel, "North");
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        Axis axis = null;
        if (plot instanceof CategoryPlot) {
            axis = ((CategoryPlot)plot).getDomainAxis();
        } else if (plot instanceof XYPlot) {
            axis = ((XYPlot)plot).getDomainAxis();
        }
        this.domainAxisPropertyPanel = DefaultAxisEditor.getInstance(axis);
        if (this.domainAxisPropertyPanel != null) {
            this.domainAxisPropertyPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            jTabbedPane.add(localizationResources.getString("Domain_Axis"), this.domainAxisPropertyPanel);
        }
        ValueAxis valueAxis = null;
        if (plot instanceof CategoryPlot) {
            valueAxis = ((CategoryPlot)plot).getRangeAxis();
        } else if (plot instanceof XYPlot) {
            valueAxis = ((XYPlot)plot).getRangeAxis();
        }
        this.rangeAxisPropertyPanel = DefaultAxisEditor.getInstance(valueAxis);
        if (this.rangeAxisPropertyPanel != null) {
            this.rangeAxisPropertyPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            jTabbedPane.add(localizationResources.getString("Range_Axis"), this.rangeAxisPropertyPanel);
        }
        ColorBar colorBar = null;
        if (plot instanceof ContourPlot) {
            colorBar = ((ContourPlot)plot).getColorBar();
        }
        this.colorBarAxisPropertyPanel = DefaultColorBarEditor.getInstance(colorBar);
        if (this.colorBarAxisPropertyPanel != null) {
            this.colorBarAxisPropertyPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            jTabbedPane.add(localizationResources.getString("Color_Bar"), this.colorBarAxisPropertyPanel);
        }
        jTabbedPane.add(localizationResources.getString("Appearance"), jPanel3);
        object.add(jTabbedPane);
        this.add((Component)object);
    }

    public RectangleInsets getPlotInsets() {
        if (this.plotInsets != null) return this.plotInsets;
        this.plotInsets = new RectangleInsets(0.0, 0.0, 0.0, 0.0);
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("BackgroundPaint")) {
            this.attemptBackgroundPaintSelection();
            return;
        }
        if (string.equals("OutlineStroke")) {
            this.attemptOutlineStrokeSelection();
            return;
        }
        if (string.equals("OutlinePaint")) {
            this.attemptOutlinePaintSelection();
            return;
        }
        if (string.equals("Orientation")) {
            this.attemptOrientationSelection();
            return;
        }
        if (string.equals("DrawLines")) {
            this.attemptDrawLinesSelection();
            return;
        }
        if (!string.equals("DrawShapes")) return;
        this.attemptDrawShapesSelection();
    }

    private void attemptBackgroundPaintSelection() {
        Color color = JColorChooser.showDialog(this, localizationResources.getString("Background_Color"), Color.blue);
        if (color == null) return;
        this.backgroundPaintSample.setPaint(color);
    }

    private void attemptOutlineStrokeSelection() {
        StrokeChooserPanel strokeChooserPanel = new StrokeChooserPanel(null, this.availableStrokeSamples);
        int n2 = JOptionPane.showConfirmDialog(this, strokeChooserPanel, localizationResources.getString("Stroke_Selection"), 2, -1);
        if (n2 != 0) return;
        this.outlineStrokeSample.setStroke(strokeChooserPanel.getSelectedStroke());
    }

    private void attemptOutlinePaintSelection() {
        Color color = JColorChooser.showDialog(this, localizationResources.getString("Outline_Color"), Color.blue);
        if (color == null) return;
        this.outlinePaintSample.setPaint(color);
    }

    private void attemptOrientationSelection() {
        int n2 = this.orientationCombo.getSelectedIndex();
        if (n2 == 0) {
            this.plotOrientation = PlotOrientation.VERTICAL;
            return;
        }
        this.plotOrientation = PlotOrientation.HORIZONTAL;
    }

    private void attemptDrawLinesSelection() {
        this.drawLines = BooleanUtilities.valueOf(this.drawLinesCheckBox.isSelected());
    }

    private void attemptDrawShapesSelection() {
        this.drawShapes = BooleanUtilities.valueOf(this.drawShapesCheckBox.isSelected());
    }

    public void updatePlotProperties(Plot plot) {
        Cloneable cloneable2;
        LegendItemSource legendItemSource2;
        LegendItemSource legendItemSource2;
        Cloneable cloneable2;
        plot.setOutlinePaint(this.getOutlinePaint());
        plot.setOutlineStroke(this.getOutlineStroke());
        plot.setBackgroundPaint(this.getBackgroundPaint());
        plot.setInsets(this.getPlotInsets());
        if (this.domainAxisPropertyPanel != null) {
            cloneable2 = null;
            if (plot instanceof CategoryPlot) {
                legendItemSource2 = (CategoryPlot)plot;
                cloneable2 = legendItemSource2.getDomainAxis();
            } else if (plot instanceof XYPlot) {
                legendItemSource2 = (XYPlot)plot;
                cloneable2 = legendItemSource2.getDomainAxis();
            }
            if (cloneable2 != null) {
                this.domainAxisPropertyPanel.setAxisProperties((Axis)cloneable2);
            }
        }
        if (this.rangeAxisPropertyPanel != null) {
            cloneable2 = null;
            if (plot instanceof CategoryPlot) {
                legendItemSource2 = (CategoryPlot)plot;
                cloneable2 = legendItemSource2.getRangeAxis();
            } else if (plot instanceof XYPlot) {
                legendItemSource2 = (XYPlot)plot;
                cloneable2 = legendItemSource2.getRangeAxis();
            }
            if (cloneable2 != null) {
                this.rangeAxisPropertyPanel.setAxisProperties((Axis)cloneable2);
            }
        }
        if (this.plotOrientation != null) {
            if (plot instanceof CategoryPlot) {
                cloneable2 = (CategoryPlot)plot;
                cloneable2.setOrientation(this.plotOrientation);
            } else if (plot instanceof XYPlot) {
                cloneable2 = (XYPlot)plot;
                cloneable2.setOrientation(this.plotOrientation);
            }
        }
        if (this.drawLines != null) {
            if (plot instanceof CategoryPlot) {
                cloneable2 = (CategoryPlot)plot;
                legendItemSource2 = cloneable2.getRenderer();
                if (legendItemSource2 instanceof LineAndShapeRenderer) {
                    ((LineAndShapeRenderer)legendItemSource2).setLinesVisible((boolean)this.drawLines);
                }
            } else if (plot instanceof XYPlot && (legendItemSource2 = (cloneable2 = (XYPlot)plot).getRenderer()) instanceof StandardXYItemRenderer) {
                ((StandardXYItemRenderer)legendItemSource2).setPlotLines(this.drawLines);
            }
        }
        if (this.drawShapes != null) {
            if (plot instanceof CategoryPlot) {
                cloneable2 = (CategoryPlot)plot;
                legendItemSource2 = cloneable2.getRenderer();
                if (legendItemSource2 instanceof LineAndShapeRenderer) {
                    ((LineAndShapeRenderer)legendItemSource2).setShapesVisible((boolean)this.drawShapes);
                }
            } else if (plot instanceof XYPlot && (legendItemSource2 = (cloneable2 = (XYPlot)plot).getRenderer()) instanceof StandardXYItemRenderer) {
                ((StandardXYItemRenderer)legendItemSource2).setBaseShapesVisible(this.drawShapes);
            }
        }
        if (this.colorBarAxisPropertyPanel == null) return;
        cloneable2 = null;
        if (!(plot instanceof ContourPlot)) return;
        legendItemSource2 = (ContourPlot)plot;
        cloneable2 = legendItemSource2.getColorBar();
        if (cloneable2 == null) return;
        this.colorBarAxisPropertyPanel.setAxisProperties((ColorBar)cloneable2);
    }
}

