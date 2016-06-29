package org.jfree.chart.editor;

import java.util.*;
import org.jfree.chart.axis.*;
import javax.swing.border.*;
import org.jfree.layout.*;
import java.awt.event.*;
import org.jfree.ui.*;
import java.awt.*;
import javax.swing.*;

class DefaultAxisEditor extends JPanel implements ActionListener
{
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
    protected static ResourceBundle localizationResources;
    
    public static DefaultAxisEditor getInstance(final Axis axis) {
        if (axis == null) {
            return null;
        }
        if (axis instanceof NumberAxis) {
            return new DefaultNumberAxisEditor((NumberAxis)axis);
        }
        return new DefaultAxisEditor(axis);
    }
    
    public DefaultAxisEditor(final Axis axis) {
        this.labelFont = axis.getLabelFont();
        this.labelPaintSample = new PaintSample(axis.getLabelPaint());
        this.tickLabelFont = axis.getTickLabelFont();
        this.tickLabelPaintSample = new PaintSample(axis.getTickLabelPaint());
        this.tickLabelInsets = axis.getTickLabelInsets();
        this.labelInsets = axis.getLabelInsets();
        this.setLayout(new BorderLayout());
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), DefaultAxisEditor.localizationResources.getString("General")));
        final JPanel panel2 = new JPanel(new LCBLayout(5));
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        panel2.add(new JLabel(DefaultAxisEditor.localizationResources.getString("Label")));
        panel2.add(this.label = new JTextField(axis.getLabel()));
        panel2.add(new JPanel());
        panel2.add(new JLabel(DefaultAxisEditor.localizationResources.getString("Font")));
        panel2.add(this.labelFontField = new FontDisplayField(this.labelFont));
        final JButton button = new JButton(DefaultAxisEditor.localizationResources.getString("Select..."));
        button.setActionCommand("SelectLabelFont");
        button.addActionListener(this);
        panel2.add(button);
        panel2.add(new JLabel(DefaultAxisEditor.localizationResources.getString("Paint")));
        panel2.add(this.labelPaintSample);
        final JButton button2 = new JButton(DefaultAxisEditor.localizationResources.getString("Select..."));
        button2.setActionCommand("SelectLabelPaint");
        button2.addActionListener(this);
        panel2.add(button2);
        panel.add(panel2);
        this.add(panel, "North");
        this.slot1 = new JPanel(new BorderLayout());
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), DefaultAxisEditor.localizationResources.getString("Other")));
        (this.otherTabs = new JTabbedPane()).setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        final JPanel panel4 = new JPanel(new LCBLayout(3));
        panel4.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        panel4.add(this.showTickLabelsCheckBox = new JCheckBox(DefaultAxisEditor.localizationResources.getString("Show_tick_labels"), axis.isTickLabelsVisible()));
        panel4.add(new JPanel());
        panel4.add(new JPanel());
        panel4.add(new JLabel(DefaultAxisEditor.localizationResources.getString("Tick_label_font")));
        panel4.add(this.tickLabelFontField = new FontDisplayField(this.tickLabelFont));
        final JButton button3 = new JButton(DefaultAxisEditor.localizationResources.getString("Select..."));
        button3.setActionCommand("SelectTickLabelFont");
        button3.addActionListener(this);
        panel4.add(button3);
        panel4.add(this.showTickMarksCheckBox = new JCheckBox(DefaultAxisEditor.localizationResources.getString("Show_tick_marks"), axis.isTickMarksVisible()));
        panel4.add(new JPanel());
        panel4.add(new JPanel());
        this.otherTabs.add(DefaultAxisEditor.localizationResources.getString("Ticks"), panel4);
        panel3.add(this.otherTabs);
        this.slot1.add(panel3);
        (this.slot2 = new JPanel(new BorderLayout())).add(this.slot1, "North");
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
        return (this.tickLabelInsets == null) ? new RectangleInsets(0.0, 0.0, 0.0, 0.0) : this.tickLabelInsets;
    }
    
    public RectangleInsets getLabelInsets() {
        return (this.labelInsets == null) ? new RectangleInsets(0.0, 0.0, 0.0, 0.0) : this.labelInsets;
    }
    
    public JTabbedPane getOtherTabs() {
        return this.otherTabs;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("SelectLabelFont")) {
            this.attemptLabelFontSelection();
        }
        else if (actionCommand.equals("SelectLabelPaint")) {
            this.attemptModifyLabelPaint();
        }
        else if (actionCommand.equals("SelectTickLabelFont")) {
            this.attemptTickLabelFontSelection();
        }
    }
    
    private void attemptLabelFontSelection() {
        final FontChooserPanel fontChooserPanel = new FontChooserPanel(this.labelFont);
        if (JOptionPane.showConfirmDialog(this, fontChooserPanel, DefaultAxisEditor.localizationResources.getString("Font_Selection"), 2, -1) == 0) {
            this.labelFont = fontChooserPanel.getSelectedFont();
            this.labelFontField.setText(this.labelFont.getFontName() + " " + this.labelFont.getSize());
        }
    }
    
    private void attemptModifyLabelPaint() {
        final Color showDialog = JColorChooser.showDialog(this, DefaultAxisEditor.localizationResources.getString("Label_Color"), Color.blue);
        if (showDialog != null) {
            this.labelPaintSample.setPaint(showDialog);
        }
    }
    
    public void attemptTickLabelFontSelection() {
        final FontChooserPanel fontChooserPanel = new FontChooserPanel(this.tickLabelFont);
        if (JOptionPane.showConfirmDialog(this, fontChooserPanel, DefaultAxisEditor.localizationResources.getString("Font_Selection"), 2, -1) == 0) {
            this.tickLabelFont = fontChooserPanel.getSelectedFont();
            this.tickLabelFontField.setText(this.tickLabelFont.getFontName() + " " + this.tickLabelFont.getSize());
        }
    }
    
    public void setAxisProperties(final Axis axis) {
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
    
    static {
        DefaultAxisEditor.localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");
    }
}
