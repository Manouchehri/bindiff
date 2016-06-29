package org.jfree.chart.editor;

import java.util.*;
import org.jfree.util.*;
import javax.swing.border.*;
import org.jfree.layout.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.renderer.xy.*;
import org.jfree.chart.axis.*;
import java.awt.event.*;
import java.awt.*;
import org.jfree.ui.*;
import javax.swing.*;

class DefaultPlotEditor extends JPanel implements ActionListener
{
    private static final String[] orientationNames;
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
    protected static ResourceBundle localizationResources;
    
    public DefaultPlotEditor(final Plot plot) {
        this.plotInsets = plot.getInsets();
        this.backgroundPaintSample = new PaintSample(plot.getBackgroundPaint());
        this.outlineStrokeSample = new StrokeSample(plot.getOutlineStroke());
        this.outlinePaintSample = new PaintSample(plot.getOutlinePaint());
        if (plot instanceof CategoryPlot) {
            this.plotOrientation = ((CategoryPlot)plot).getOrientation();
        }
        else if (plot instanceof XYPlot) {
            this.plotOrientation = ((XYPlot)plot).getOrientation();
        }
        if (plot instanceof CategoryPlot) {
            final CategoryItemRenderer renderer = ((CategoryPlot)plot).getRenderer();
            if (renderer instanceof LineAndShapeRenderer) {
                final LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)renderer;
                this.drawLines = BooleanUtilities.valueOf(lineAndShapeRenderer.getBaseLinesVisible());
                this.drawShapes = BooleanUtilities.valueOf(lineAndShapeRenderer.getBaseShapesVisible());
            }
        }
        else if (plot instanceof XYPlot) {
            final XYItemRenderer renderer2 = ((XYPlot)plot).getRenderer();
            if (renderer2 instanceof StandardXYItemRenderer) {
                final StandardXYItemRenderer standardXYItemRenderer = (StandardXYItemRenderer)renderer2;
                this.drawLines = BooleanUtilities.valueOf(standardXYItemRenderer.getPlotLines());
                this.drawShapes = BooleanUtilities.valueOf(standardXYItemRenderer.getBaseShapesVisible());
            }
        }
        this.setLayout(new BorderLayout());
        (this.availableStrokeSamples = new StrokeSample[3])[0] = new StrokeSample(new BasicStroke(1.0f));
        this.availableStrokeSamples[1] = new StrokeSample(new BasicStroke(2.0f));
        this.availableStrokeSamples[2] = new StrokeSample(new BasicStroke(3.0f));
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), plot.getPlotType() + DefaultPlotEditor.localizationResources.getString(":")));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(BorderFactory.createTitledBorder(DefaultPlotEditor.localizationResources.getString("General")));
        final JPanel panel3 = new JPanel(new LCBLayout(7));
        panel3.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        panel3.add(new JLabel(DefaultPlotEditor.localizationResources.getString("Outline_stroke")));
        final JButton button = new JButton(DefaultPlotEditor.localizationResources.getString("Select..."));
        button.setActionCommand("OutlineStroke");
        button.addActionListener(this);
        panel3.add(this.outlineStrokeSample);
        panel3.add(button);
        panel3.add(new JLabel(DefaultPlotEditor.localizationResources.getString("Outline_Paint")));
        final JButton button2 = new JButton(DefaultPlotEditor.localizationResources.getString("Select..."));
        button2.setActionCommand("OutlinePaint");
        button2.addActionListener(this);
        panel3.add(this.outlinePaintSample);
        panel3.add(button2);
        panel3.add(new JLabel(DefaultPlotEditor.localizationResources.getString("Background_paint")));
        final JButton button3 = new JButton(DefaultPlotEditor.localizationResources.getString("Select..."));
        button3.setActionCommand("BackgroundPaint");
        button3.addActionListener(this);
        panel3.add(this.backgroundPaintSample);
        panel3.add(button3);
        if (this.plotOrientation != null) {
            final int selectedIndex = this.plotOrientation.equals(PlotOrientation.VERTICAL) ? 0 : 1;
            panel3.add(new JLabel(DefaultPlotEditor.localizationResources.getString("Orientation")));
            (this.orientationCombo = new JComboBox((E[])DefaultPlotEditor.orientationNames)).setSelectedIndex(selectedIndex);
            this.orientationCombo.setActionCommand("Orientation");
            this.orientationCombo.addActionListener(this);
            panel3.add(new JPanel());
            panel3.add(this.orientationCombo);
        }
        if (this.drawLines != null) {
            panel3.add(new JLabel(DefaultPlotEditor.localizationResources.getString("Draw_lines")));
            (this.drawLinesCheckBox = new JCheckBox()).setSelected(this.drawLines);
            this.drawLinesCheckBox.setActionCommand("DrawLines");
            this.drawLinesCheckBox.addActionListener(this);
            panel3.add(new JPanel());
            panel3.add(this.drawLinesCheckBox);
        }
        if (this.drawShapes != null) {
            panel3.add(new JLabel(DefaultPlotEditor.localizationResources.getString("Draw_shapes")));
            (this.drawShapesCheckBox = new JCheckBox()).setSelected(this.drawShapes);
            this.drawShapesCheckBox.setActionCommand("DrawShapes");
            this.drawShapesCheckBox.addActionListener(this);
            panel3.add(new JPanel());
            panel3.add(this.drawShapesCheckBox);
        }
        panel2.add(panel3, "North");
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        panel4.add(panel2, "North");
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        Axis axis = null;
        if (plot instanceof CategoryPlot) {
            axis = ((CategoryPlot)plot).getDomainAxis();
        }
        else if (plot instanceof XYPlot) {
            axis = ((XYPlot)plot).getDomainAxis();
        }
        this.domainAxisPropertyPanel = DefaultAxisEditor.getInstance(axis);
        if (this.domainAxisPropertyPanel != null) {
            this.domainAxisPropertyPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            tabbedPane.add(DefaultPlotEditor.localizationResources.getString("Domain_Axis"), this.domainAxisPropertyPanel);
        }
        Axis axis2 = null;
        if (plot instanceof CategoryPlot) {
            axis2 = ((CategoryPlot)plot).getRangeAxis();
        }
        else if (plot instanceof XYPlot) {
            axis2 = ((XYPlot)plot).getRangeAxis();
        }
        this.rangeAxisPropertyPanel = DefaultAxisEditor.getInstance(axis2);
        if (this.rangeAxisPropertyPanel != null) {
            this.rangeAxisPropertyPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            tabbedPane.add(DefaultPlotEditor.localizationResources.getString("Range_Axis"), this.rangeAxisPropertyPanel);
        }
        ColorBar colorBar = null;
        if (plot instanceof ContourPlot) {
            colorBar = ((ContourPlot)plot).getColorBar();
        }
        this.colorBarAxisPropertyPanel = DefaultColorBarEditor.getInstance(colorBar);
        if (this.colorBarAxisPropertyPanel != null) {
            this.colorBarAxisPropertyPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            tabbedPane.add(DefaultPlotEditor.localizationResources.getString("Color_Bar"), this.colorBarAxisPropertyPanel);
        }
        tabbedPane.add(DefaultPlotEditor.localizationResources.getString("Appearance"), panel4);
        panel.add(tabbedPane);
        this.add(panel);
    }
    
    public RectangleInsets getPlotInsets() {
        if (this.plotInsets == null) {
            this.plotInsets = new RectangleInsets(0.0, 0.0, 0.0, 0.0);
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
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("BackgroundPaint")) {
            this.attemptBackgroundPaintSelection();
        }
        else if (actionCommand.equals("OutlineStroke")) {
            this.attemptOutlineStrokeSelection();
        }
        else if (actionCommand.equals("OutlinePaint")) {
            this.attemptOutlinePaintSelection();
        }
        else if (actionCommand.equals("Orientation")) {
            this.attemptOrientationSelection();
        }
        else if (actionCommand.equals("DrawLines")) {
            this.attemptDrawLinesSelection();
        }
        else if (actionCommand.equals("DrawShapes")) {
            this.attemptDrawShapesSelection();
        }
    }
    
    private void attemptBackgroundPaintSelection() {
        final Color showDialog = JColorChooser.showDialog(this, DefaultPlotEditor.localizationResources.getString("Background_Color"), Color.blue);
        if (showDialog != null) {
            this.backgroundPaintSample.setPaint(showDialog);
        }
    }
    
    private void attemptOutlineStrokeSelection() {
        final StrokeChooserPanel strokeChooserPanel = new StrokeChooserPanel(null, this.availableStrokeSamples);
        if (JOptionPane.showConfirmDialog(this, strokeChooserPanel, DefaultPlotEditor.localizationResources.getString("Stroke_Selection"), 2, -1) == 0) {
            this.outlineStrokeSample.setStroke(strokeChooserPanel.getSelectedStroke());
        }
    }
    
    private void attemptOutlinePaintSelection() {
        final Color showDialog = JColorChooser.showDialog(this, DefaultPlotEditor.localizationResources.getString("Outline_Color"), Color.blue);
        if (showDialog != null) {
            this.outlinePaintSample.setPaint(showDialog);
        }
    }
    
    private void attemptOrientationSelection() {
        if (this.orientationCombo.getSelectedIndex() == 0) {
            this.plotOrientation = PlotOrientation.VERTICAL;
        }
        else {
            this.plotOrientation = PlotOrientation.HORIZONTAL;
        }
    }
    
    private void attemptDrawLinesSelection() {
        this.drawLines = BooleanUtilities.valueOf(this.drawLinesCheckBox.isSelected());
    }
    
    private void attemptDrawShapesSelection() {
        this.drawShapes = BooleanUtilities.valueOf(this.drawShapesCheckBox.isSelected());
    }
    
    public void updatePlotProperties(final Plot plot) {
        plot.setOutlinePaint(this.getOutlinePaint());
        plot.setOutlineStroke(this.getOutlineStroke());
        plot.setBackgroundPaint(this.getBackgroundPaint());
        plot.setInsets(this.getPlotInsets());
        if (this.domainAxisPropertyPanel != null) {
            Axis axisProperties = null;
            if (plot instanceof CategoryPlot) {
                axisProperties = ((CategoryPlot)plot).getDomainAxis();
            }
            else if (plot instanceof XYPlot) {
                axisProperties = ((XYPlot)plot).getDomainAxis();
            }
            if (axisProperties != null) {
                this.domainAxisPropertyPanel.setAxisProperties(axisProperties);
            }
        }
        if (this.rangeAxisPropertyPanel != null) {
            Axis axisProperties2 = null;
            if (plot instanceof CategoryPlot) {
                axisProperties2 = ((CategoryPlot)plot).getRangeAxis();
            }
            else if (plot instanceof XYPlot) {
                axisProperties2 = ((XYPlot)plot).getRangeAxis();
            }
            if (axisProperties2 != null) {
                this.rangeAxisPropertyPanel.setAxisProperties(axisProperties2);
            }
        }
        if (this.plotOrientation != null) {
            if (plot instanceof CategoryPlot) {
                ((CategoryPlot)plot).setOrientation(this.plotOrientation);
            }
            else if (plot instanceof XYPlot) {
                ((XYPlot)plot).setOrientation(this.plotOrientation);
            }
        }
        if (this.drawLines != null) {
            if (plot instanceof CategoryPlot) {
                final CategoryItemRenderer renderer = ((CategoryPlot)plot).getRenderer();
                if (renderer instanceof LineAndShapeRenderer) {
                    ((LineAndShapeRenderer)renderer).setLinesVisible((boolean)this.drawLines);
                }
            }
            else if (plot instanceof XYPlot) {
                final XYItemRenderer renderer2 = ((XYPlot)plot).getRenderer();
                if (renderer2 instanceof StandardXYItemRenderer) {
                    ((StandardXYItemRenderer)renderer2).setPlotLines(this.drawLines);
                }
            }
        }
        if (this.drawShapes != null) {
            if (plot instanceof CategoryPlot) {
                final CategoryItemRenderer renderer3 = ((CategoryPlot)plot).getRenderer();
                if (renderer3 instanceof LineAndShapeRenderer) {
                    ((LineAndShapeRenderer)renderer3).setShapesVisible((boolean)this.drawShapes);
                }
            }
            else if (plot instanceof XYPlot) {
                final XYItemRenderer renderer4 = ((XYPlot)plot).getRenderer();
                if (renderer4 instanceof StandardXYItemRenderer) {
                    ((StandardXYItemRenderer)renderer4).setBaseShapesVisible(this.drawShapes);
                }
            }
        }
        if (this.colorBarAxisPropertyPanel != null) {
            ColorBar colorBar = null;
            if (plot instanceof ContourPlot) {
                colorBar = ((ContourPlot)plot).getColorBar();
            }
            if (colorBar != null) {
                this.colorBarAxisPropertyPanel.setAxisProperties(colorBar);
            }
        }
    }
    
    static {
        orientationNames = new String[] { "Vertical", "Horizontal" };
        DefaultPlotEditor.localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");
    }
}
