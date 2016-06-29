/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.editor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.Border;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.editor.DefaultAxisEditor;
import org.jfree.layout.LCBLayout;
import org.jfree.ui.PaintSample;
import org.jfree.ui.StrokeChooserPanel;
import org.jfree.ui.StrokeSample;

class DefaultNumberAxisEditor
extends DefaultAxisEditor
implements FocusListener {
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

    public DefaultNumberAxisEditor(NumberAxis numberAxis) {
        super(numberAxis);
        this.autoRange = numberAxis.isAutoRange();
        this.minimumValue = numberAxis.getLowerBound();
        this.maximumValue = numberAxis.getUpperBound();
        this.gridPaintSample = new PaintSample(Color.blue);
        this.gridStrokeSample = new StrokeSample(new BasicStroke(1.0f));
        this.availableStrokeSamples = new StrokeSample[3];
        this.availableStrokeSamples[0] = new StrokeSample(new BasicStroke(1.0f));
        this.availableStrokeSamples[1] = new StrokeSample(new BasicStroke(2.0f));
        this.availableStrokeSamples[2] = new StrokeSample(new BasicStroke(3.0f));
        JTabbedPane jTabbedPane = this.getOtherTabs();
        JPanel jPanel = new JPanel(new LCBLayout(3));
        jPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel.add(new JPanel());
        this.autoRangeCheckBox = new JCheckBox(localizationResources.getString("Auto-adjust_range"), this.autoRange);
        this.autoRangeCheckBox.setActionCommand("AutoRangeOnOff");
        this.autoRangeCheckBox.addActionListener(this);
        jPanel.add(this.autoRangeCheckBox);
        jPanel.add(new JPanel());
        jPanel.add(new JLabel(localizationResources.getString("Minimum_range_value")));
        this.minimumRangeValue = new JTextField(Double.toString(this.minimumValue));
        this.minimumRangeValue.setEnabled(!this.autoRange);
        this.minimumRangeValue.setActionCommand("MinimumRange");
        this.minimumRangeValue.addActionListener(this);
        this.minimumRangeValue.addFocusListener(this);
        jPanel.add(this.minimumRangeValue);
        jPanel.add(new JPanel());
        jPanel.add(new JLabel(localizationResources.getString("Maximum_range_value")));
        this.maximumRangeValue = new JTextField(Double.toString(this.maximumValue));
        this.maximumRangeValue.setEnabled(!this.autoRange);
        this.maximumRangeValue.setActionCommand("MaximumRange");
        this.maximumRangeValue.addActionListener(this);
        this.maximumRangeValue.addFocusListener(this);
        jPanel.add(this.maximumRangeValue);
        jPanel.add(new JPanel());
        jTabbedPane.add(localizationResources.getString("Range"), jPanel);
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("GridStroke")) {
            this.attemptGridStrokeSelection();
            return;
        }
        if (string.equals("GridPaint")) {
            this.attemptGridPaintSelection();
            return;
        }
        if (string.equals("AutoRangeOnOff")) {
            this.toggleAutoRange();
            return;
        }
        if (string.equals("MinimumRange")) {
            this.validateMinimum();
            return;
        }
        if (string.equals("MaximumRange")) {
            this.validateMaximum();
            return;
        }
        super.actionPerformed(actionEvent);
    }

    private void attemptGridStrokeSelection() {
        StrokeChooserPanel strokeChooserPanel = new StrokeChooserPanel(null, this.availableStrokeSamples);
        int n2 = JOptionPane.showConfirmDialog(this, strokeChooserPanel, localizationResources.getString("Stroke_Selection"), 2, -1);
        if (n2 != 0) return;
        this.gridStrokeSample.setStroke(strokeChooserPanel.getSelectedStroke());
    }

    private void attemptGridPaintSelection() {
        Color color = JColorChooser.showDialog(this, localizationResources.getString("Grid_Color"), Color.blue);
        if (color == null) return;
        this.gridPaintSample.setPaint(color);
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        if (focusEvent.getSource() == this.minimumRangeValue) {
            this.validateMinimum();
            return;
        }
        if (focusEvent.getSource() != this.maximumRangeValue) return;
        this.validateMaximum();
    }

    public void toggleAutoRange() {
        this.autoRange = this.autoRangeCheckBox.isSelected();
        if (this.autoRange) {
            this.minimumRangeValue.setText(Double.toString(this.minimumValue));
            this.minimumRangeValue.setEnabled(false);
            this.maximumRangeValue.setText(Double.toString(this.maximumValue));
            this.maximumRangeValue.setEnabled(false);
            return;
        }
        this.minimumRangeValue.setEnabled(true);
        this.maximumRangeValue.setEnabled(true);
    }

    public void validateMinimum() {
        double d2;
        try {
            d2 = Double.parseDouble(this.minimumRangeValue.getText());
            if (d2 >= this.maximumValue) {
                d2 = this.minimumValue;
            }
        }
        catch (NumberFormatException var3_2) {
            d2 = this.minimumValue;
        }
        this.minimumValue = d2;
        this.minimumRangeValue.setText(Double.toString(this.minimumValue));
    }

    public void validateMaximum() {
        double d2;
        try {
            d2 = Double.parseDouble(this.maximumRangeValue.getText());
            if (d2 <= this.minimumValue) {
                d2 = this.maximumValue;
            }
        }
        catch (NumberFormatException var3_2) {
            d2 = this.maximumValue;
        }
        this.maximumValue = d2;
        this.maximumRangeValue.setText(Double.toString(this.maximumValue));
    }

    @Override
    public void setAxisProperties(Axis axis) {
        super.setAxisProperties(axis);
        NumberAxis numberAxis = (NumberAxis)axis;
        numberAxis.setAutoRange(this.autoRange);
        if (this.autoRange) return;
        numberAxis.setRange(this.minimumValue, this.maximumValue);
    }
}

