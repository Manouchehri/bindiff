/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.editor.ChartEditor;
import org.jfree.chart.editor.DefaultPlotEditor;
import org.jfree.chart.editor.DefaultTitleEditor;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.layout.LCBLayout;
import org.jfree.ui.PaintSample;

class DefaultChartEditor
extends JPanel
implements ActionListener,
ChartEditor {
    private DefaultTitleEditor titleEditor;
    private DefaultPlotEditor plotEditor;
    private JCheckBox antialias;
    private PaintSample background;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");

    public DefaultChartEditor(JFreeChart jFreeChart) {
        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("General")));
        JPanel jPanel3 = new JPanel(new LCBLayout(6));
        jPanel3.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        this.antialias = new JCheckBox(localizationResources.getString("Draw_anti-aliased"));
        this.antialias.setSelected(jFreeChart.getAntiAlias());
        jPanel3.add(this.antialias);
        jPanel3.add(new JLabel(""));
        jPanel3.add(new JLabel(""));
        jPanel3.add(new JLabel(localizationResources.getString("Background_paint")));
        this.background = new PaintSample(jFreeChart.getBackgroundPaint());
        jPanel3.add(this.background);
        JButton jButton = new JButton(localizationResources.getString("Select..."));
        jButton.setActionCommand("BackgroundPaint");
        jButton.addActionListener(this);
        jPanel3.add(jButton);
        jPanel3.add(new JLabel(localizationResources.getString("Series_Paint")));
        JTextField jTextField = new JTextField(localizationResources.getString("No_editor_implemented"));
        jTextField.setEnabled(false);
        jPanel3.add(jTextField);
        jButton = new JButton(localizationResources.getString("Edit..."));
        jButton.setEnabled(false);
        jPanel3.add(jButton);
        jPanel3.add(new JLabel(localizationResources.getString("Series_Stroke")));
        jTextField = new JTextField(localizationResources.getString("No_editor_implemented"));
        jTextField.setEnabled(false);
        jPanel3.add(jTextField);
        jButton = new JButton(localizationResources.getString("Edit..."));
        jButton.setEnabled(false);
        jPanel3.add(jButton);
        jPanel3.add(new JLabel(localizationResources.getString("Series_Outline_Paint")));
        jTextField = new JTextField(localizationResources.getString("No_editor_implemented"));
        jTextField.setEnabled(false);
        jPanel3.add(jTextField);
        jButton = new JButton(localizationResources.getString("Edit..."));
        jButton.setEnabled(false);
        jPanel3.add(jButton);
        jPanel3.add(new JLabel(localizationResources.getString("Series_Outline_Stroke")));
        jTextField = new JTextField(localizationResources.getString("No_editor_implemented"));
        jTextField.setEnabled(false);
        jPanel3.add(jTextField);
        jButton = new JButton(localizationResources.getString("Edit..."));
        jButton.setEnabled(false);
        jPanel3.add(jButton);
        jPanel2.add((Component)jPanel3, "North");
        jPanel.add((Component)jPanel2, "North");
        JPanel jPanel4 = new JPanel(new BorderLayout());
        TextTitle textTitle = jFreeChart.getTitle();
        Plot plot = jFreeChart.getPlot();
        JTabbedPane jTabbedPane = new JTabbedPane();
        this.titleEditor = new DefaultTitleEditor(textTitle);
        this.titleEditor.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jTabbedPane.addTab(localizationResources.getString("Title"), this.titleEditor);
        this.plotEditor = new DefaultPlotEditor(plot);
        this.plotEditor.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jTabbedPane.addTab(localizationResources.getString("Plot"), this.plotEditor);
        jTabbedPane.add(localizationResources.getString("Other"), jPanel);
        jPanel4.add((Component)jTabbedPane, "North");
        this.add(jPanel4);
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (!string.equals("BackgroundPaint")) return;
        this.attemptModifyBackgroundPaint();
    }

    private void attemptModifyBackgroundPaint() {
        Color color = JColorChooser.showDialog(this, localizationResources.getString("Background_Color"), Color.blue);
        if (color == null) return;
        this.background.setPaint(color);
    }

    @Override
    public void updateChart(JFreeChart jFreeChart) {
        this.titleEditor.setTitleProperties(jFreeChart);
        this.plotEditor.updatePlotProperties(jFreeChart.getPlot());
        jFreeChart.setAntiAlias(this.getAntiAlias());
        jFreeChart.setBackgroundPaint(this.getBackgroundPaint());
    }
}

