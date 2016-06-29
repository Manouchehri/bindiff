/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
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
import javax.swing.border.Border;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.editor.DefaultNumberAxisEditor;
import org.jfree.layout.LCBLayout;
import org.jfree.ui.FontChooserPanel;
import org.jfree.ui.FontDisplayField;
import org.jfree.ui.PaintSample;
import org.jfree.ui.RectangleInsets;

class DefaultAxisEditor
extends JPanel
implements ActionListener {
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

    public static DefaultAxisEditor getInstance(Axis axis) {
        if (axis == null) return null;
        if (!(axis instanceof NumberAxis)) return new DefaultAxisEditor(axis);
        return new DefaultNumberAxisEditor((NumberAxis)axis);
    }

    public DefaultAxisEditor(Axis axis) {
        this.labelFont = axis.getLabelFont();
        this.labelPaintSample = new PaintSample(axis.getLabelPaint());
        this.tickLabelFont = axis.getTickLabelFont();
        this.tickLabelPaintSample = new PaintSample(axis.getTickLabelPaint());
        this.tickLabelInsets = axis.getTickLabelInsets();
        this.labelInsets = axis.getLabelInsets();
        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("General")));
        JPanel jPanel2 = new JPanel(new LCBLayout(5));
        jPanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        jPanel2.add(new JLabel(localizationResources.getString("Label")));
        this.label = new JTextField(axis.getLabel());
        jPanel2.add(this.label);
        jPanel2.add(new JPanel());
        jPanel2.add(new JLabel(localizationResources.getString("Font")));
        this.labelFontField = new FontDisplayField(this.labelFont);
        jPanel2.add(this.labelFontField);
        JButton jButton = new JButton(localizationResources.getString("Select..."));
        jButton.setActionCommand("SelectLabelFont");
        jButton.addActionListener(this);
        jPanel2.add(jButton);
        jPanel2.add(new JLabel(localizationResources.getString("Paint")));
        jPanel2.add(this.labelPaintSample);
        jButton = new JButton(localizationResources.getString("Select..."));
        jButton.setActionCommand("SelectLabelPaint");
        jButton.addActionListener(this);
        jPanel2.add(jButton);
        jPanel.add(jPanel2);
        this.add((Component)jPanel, "North");
        this.slot1 = new JPanel(new BorderLayout());
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("Other")));
        this.otherTabs = new JTabbedPane();
        this.otherTabs.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        JPanel jPanel4 = new JPanel(new LCBLayout(3));
        jPanel4.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        this.showTickLabelsCheckBox = new JCheckBox(localizationResources.getString("Show_tick_labels"), axis.isTickLabelsVisible());
        jPanel4.add(this.showTickLabelsCheckBox);
        jPanel4.add(new JPanel());
        jPanel4.add(new JPanel());
        jPanel4.add(new JLabel(localizationResources.getString("Tick_label_font")));
        this.tickLabelFontField = new FontDisplayField(this.tickLabelFont);
        jPanel4.add(this.tickLabelFontField);
        jButton = new JButton(localizationResources.getString("Select..."));
        jButton.setActionCommand("SelectTickLabelFont");
        jButton.addActionListener(this);
        jPanel4.add(jButton);
        this.showTickMarksCheckBox = new JCheckBox(localizationResources.getString("Show_tick_marks"), axis.isTickMarksVisible());
        jPanel4.add(this.showTickMarksCheckBox);
        jPanel4.add(new JPanel());
        jPanel4.add(new JPanel());
        this.otherTabs.add(localizationResources.getString("Ticks"), jPanel4);
        jPanel3.add(this.otherTabs);
        this.slot1.add(jPanel3);
        this.slot2 = new JPanel(new BorderLayout());
        this.slot2.add((Component)this.slot1, "North");
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
        RectangleInsets rectangleInsets;
        if (this.tickLabelInsets == null) {
            rectangleInsets = new RectangleInsets(0.0, 0.0, 0.0, 0.0);
            return rectangleInsets;
        }
        rectangleInsets = this.tickLabelInsets;
        return rectangleInsets;
    }

    public RectangleInsets getLabelInsets() {
        RectangleInsets rectangleInsets;
        if (this.labelInsets == null) {
            rectangleInsets = new RectangleInsets(0.0, 0.0, 0.0, 0.0);
            return rectangleInsets;
        }
        rectangleInsets = this.labelInsets;
        return rectangleInsets;
    }

    public JTabbedPane getOtherTabs() {
        return this.otherTabs;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("SelectLabelFont")) {
            this.attemptLabelFontSelection();
            return;
        }
        if (string.equals("SelectLabelPaint")) {
            this.attemptModifyLabelPaint();
            return;
        }
        if (!string.equals("SelectTickLabelFont")) return;
        this.attemptTickLabelFontSelection();
    }

    private void attemptLabelFontSelection() {
        FontChooserPanel fontChooserPanel = new FontChooserPanel(this.labelFont);
        int n2 = JOptionPane.showConfirmDialog(this, fontChooserPanel, localizationResources.getString("Font_Selection"), 2, -1);
        if (n2 != 0) return;
        this.labelFont = fontChooserPanel.getSelectedFont();
        this.labelFontField.setText(new StringBuffer().append(this.labelFont.getFontName()).append(" ").append(this.labelFont.getSize()).toString());
    }

    private void attemptModifyLabelPaint() {
        Color color = JColorChooser.showDialog(this, localizationResources.getString("Label_Color"), Color.blue);
        if (color == null) return;
        this.labelPaintSample.setPaint(color);
    }

    public void attemptTickLabelFontSelection() {
        FontChooserPanel fontChooserPanel = new FontChooserPanel(this.tickLabelFont);
        int n2 = JOptionPane.showConfirmDialog(this, fontChooserPanel, localizationResources.getString("Font_Selection"), 2, -1);
        if (n2 != 0) return;
        this.tickLabelFont = fontChooserPanel.getSelectedFont();
        this.tickLabelFontField.setText(new StringBuffer().append(this.tickLabelFont.getFontName()).append(" ").append(this.tickLabelFont.getSize()).toString());
    }

    public void setAxisProperties(Axis axis) {
        axis.setLabel(this.getLabel());
        axis.setLabelFont(this.getLabelFont());
        axis.setLabelPaint(this.getLabelPaint());
        axis.setTickMarksVisible(this.isTickMarksVisible());
        axis.setTickLabelsVisible(this.isTickLabelsVisible());
        axis.setTickLabelFont(this.getTickLabelFont());
        axis.setTickLabelPaint(this.getTickLabelPaint());
        axis.setTickLabelInsets(this.getTickLabelInsets());
        axis.setLabelInsets(this.getLabelInsets());
    }
}

