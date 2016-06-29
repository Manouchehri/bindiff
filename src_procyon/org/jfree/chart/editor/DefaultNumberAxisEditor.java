package org.jfree.chart.editor;

import java.util.*;
import org.jfree.chart.axis.*;
import org.jfree.layout.*;
import java.awt.*;
import org.jfree.ui.*;
import javax.swing.*;
import java.awt.event.*;

class DefaultNumberAxisEditor extends DefaultAxisEditor implements FocusListener
{
    private boolean autoRange;
    private double minimumValue;
    private double maximumValue;
    private JCheckBox autoRangeCheckBox;
    private JTextField minimumRangeValue;
    private JTextField maximumRangeValue;
    private PaintSample gridPaintSample;
    private StrokeSample gridStrokeSample;
    private StrokeSample[] availableStrokeSamples;
    protected static ResourceBundle localizationResources;
    
    public DefaultNumberAxisEditor(final NumberAxis numberAxis) {
        super(numberAxis);
        this.autoRange = numberAxis.isAutoRange();
        this.minimumValue = numberAxis.getLowerBound();
        this.maximumValue = numberAxis.getUpperBound();
        this.gridPaintSample = new PaintSample(Color.blue);
        this.gridStrokeSample = new StrokeSample(new BasicStroke(1.0f));
        (this.availableStrokeSamples = new StrokeSample[3])[0] = new StrokeSample(new BasicStroke(1.0f));
        this.availableStrokeSamples[1] = new StrokeSample(new BasicStroke(2.0f));
        this.availableStrokeSamples[2] = new StrokeSample(new BasicStroke(3.0f));
        final JTabbedPane otherTabs = this.getOtherTabs();
        final JPanel panel = new JPanel(new LCBLayout(3));
        panel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        panel.add(new JPanel());
        (this.autoRangeCheckBox = new JCheckBox(DefaultNumberAxisEditor.localizationResources.getString("Auto-adjust_range"), this.autoRange)).setActionCommand("AutoRangeOnOff");
        this.autoRangeCheckBox.addActionListener(this);
        panel.add(this.autoRangeCheckBox);
        panel.add(new JPanel());
        panel.add(new JLabel(DefaultNumberAxisEditor.localizationResources.getString("Minimum_range_value")));
        (this.minimumRangeValue = new JTextField(Double.toString(this.minimumValue))).setEnabled(!this.autoRange);
        this.minimumRangeValue.setActionCommand("MinimumRange");
        this.minimumRangeValue.addActionListener(this);
        this.minimumRangeValue.addFocusListener(this);
        panel.add(this.minimumRangeValue);
        panel.add(new JPanel());
        panel.add(new JLabel(DefaultNumberAxisEditor.localizationResources.getString("Maximum_range_value")));
        (this.maximumRangeValue = new JTextField(Double.toString(this.maximumValue))).setEnabled(!this.autoRange);
        this.maximumRangeValue.setActionCommand("MaximumRange");
        this.maximumRangeValue.addActionListener(this);
        this.maximumRangeValue.addFocusListener(this);
        panel.add(this.maximumRangeValue);
        panel.add(new JPanel());
        otherTabs.add(DefaultNumberAxisEditor.localizationResources.getString("Range"), panel);
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
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("GridStroke")) {
            this.attemptGridStrokeSelection();
        }
        else if (actionCommand.equals("GridPaint")) {
            this.attemptGridPaintSelection();
        }
        else if (actionCommand.equals("AutoRangeOnOff")) {
            this.toggleAutoRange();
        }
        else if (actionCommand.equals("MinimumRange")) {
            this.validateMinimum();
        }
        else if (actionCommand.equals("MaximumRange")) {
            this.validateMaximum();
        }
        else {
            super.actionPerformed(actionEvent);
        }
    }
    
    private void attemptGridStrokeSelection() {
        final StrokeChooserPanel strokeChooserPanel = new StrokeChooserPanel(null, this.availableStrokeSamples);
        if (JOptionPane.showConfirmDialog(this, strokeChooserPanel, DefaultNumberAxisEditor.localizationResources.getString("Stroke_Selection"), 2, -1) == 0) {
            this.gridStrokeSample.setStroke(strokeChooserPanel.getSelectedStroke());
        }
    }
    
    private void attemptGridPaintSelection() {
        final Color showDialog = JColorChooser.showDialog(this, DefaultNumberAxisEditor.localizationResources.getString("Grid_Color"), Color.blue);
        if (showDialog != null) {
            this.gridPaintSample.setPaint(showDialog);
        }
    }
    
    public void focusGained(final FocusEvent focusEvent) {
    }
    
    public void focusLost(final FocusEvent focusEvent) {
        if (focusEvent.getSource() == this.minimumRangeValue) {
            this.validateMinimum();
        }
        else if (focusEvent.getSource() == this.maximumRangeValue) {
            this.validateMaximum();
        }
    }
    
    public void toggleAutoRange() {
        this.autoRange = this.autoRangeCheckBox.isSelected();
        if (this.autoRange) {
            this.minimumRangeValue.setText(Double.toString(this.minimumValue));
            this.minimumRangeValue.setEnabled(false);
            this.maximumRangeValue.setText(Double.toString(this.maximumValue));
            this.maximumRangeValue.setEnabled(false);
        }
        else {
            this.minimumRangeValue.setEnabled(true);
            this.maximumRangeValue.setEnabled(true);
        }
    }
    
    public void validateMinimum() {
        double minimumValue;
        try {
            minimumValue = Double.parseDouble(this.minimumRangeValue.getText());
            if (minimumValue >= this.maximumValue) {
                minimumValue = this.minimumValue;
            }
        }
        catch (NumberFormatException ex) {
            minimumValue = this.minimumValue;
        }
        this.minimumValue = minimumValue;
        this.minimumRangeValue.setText(Double.toString(this.minimumValue));
    }
    
    public void validateMaximum() {
        double maximumValue;
        try {
            maximumValue = Double.parseDouble(this.maximumRangeValue.getText());
            if (maximumValue <= this.minimumValue) {
                maximumValue = this.maximumValue;
            }
        }
        catch (NumberFormatException ex) {
            maximumValue = this.maximumValue;
        }
        this.maximumValue = maximumValue;
        this.maximumRangeValue.setText(Double.toString(this.maximumValue));
    }
    
    public void setAxisProperties(final Axis axisProperties) {
        super.setAxisProperties(axisProperties);
        final NumberAxis numberAxis = (NumberAxis)axisProperties;
        numberAxis.setAutoRange(this.autoRange);
        if (!this.autoRange) {
            numberAxis.setRange(this.minimumValue, this.maximumValue);
        }
    }
    
    static {
        DefaultNumberAxisEditor.localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");
    }
}
