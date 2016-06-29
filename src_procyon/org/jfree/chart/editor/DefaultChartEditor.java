package org.jfree.chart.editor;

import org.jfree.ui.*;
import java.util.*;
import org.jfree.chart.*;
import javax.swing.border.*;
import org.jfree.layout.*;
import org.jfree.chart.title.*;
import org.jfree.chart.plot.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class DefaultChartEditor extends JPanel implements ActionListener, ChartEditor
{
    private DefaultTitleEditor titleEditor;
    private DefaultPlotEditor plotEditor;
    private JCheckBox antialias;
    private PaintSample background;
    protected static ResourceBundle localizationResources;
    
    public DefaultChartEditor(final JFreeChart freeChart) {
        this.setLayout(new BorderLayout());
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), DefaultChartEditor.localizationResources.getString("General")));
        final JPanel panel3 = new JPanel(new LCBLayout(6));
        panel3.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        (this.antialias = new JCheckBox(DefaultChartEditor.localizationResources.getString("Draw_anti-aliased"))).setSelected(freeChart.getAntiAlias());
        panel3.add(this.antialias);
        panel3.add(new JLabel(""));
        panel3.add(new JLabel(""));
        panel3.add(new JLabel(DefaultChartEditor.localizationResources.getString("Background_paint")));
        panel3.add(this.background = new PaintSample(freeChart.getBackgroundPaint()));
        final JButton button = new JButton(DefaultChartEditor.localizationResources.getString("Select..."));
        button.setActionCommand("BackgroundPaint");
        button.addActionListener(this);
        panel3.add(button);
        panel3.add(new JLabel(DefaultChartEditor.localizationResources.getString("Series_Paint")));
        final JTextField textField = new JTextField(DefaultChartEditor.localizationResources.getString("No_editor_implemented"));
        textField.setEnabled(false);
        panel3.add(textField);
        final JButton button2 = new JButton(DefaultChartEditor.localizationResources.getString("Edit..."));
        button2.setEnabled(false);
        panel3.add(button2);
        panel3.add(new JLabel(DefaultChartEditor.localizationResources.getString("Series_Stroke")));
        final JTextField textField2 = new JTextField(DefaultChartEditor.localizationResources.getString("No_editor_implemented"));
        textField2.setEnabled(false);
        panel3.add(textField2);
        final JButton button3 = new JButton(DefaultChartEditor.localizationResources.getString("Edit..."));
        button3.setEnabled(false);
        panel3.add(button3);
        panel3.add(new JLabel(DefaultChartEditor.localizationResources.getString("Series_Outline_Paint")));
        final JTextField textField3 = new JTextField(DefaultChartEditor.localizationResources.getString("No_editor_implemented"));
        textField3.setEnabled(false);
        panel3.add(textField3);
        final JButton button4 = new JButton(DefaultChartEditor.localizationResources.getString("Edit..."));
        button4.setEnabled(false);
        panel3.add(button4);
        panel3.add(new JLabel(DefaultChartEditor.localizationResources.getString("Series_Outline_Stroke")));
        final JTextField textField4 = new JTextField(DefaultChartEditor.localizationResources.getString("No_editor_implemented"));
        textField4.setEnabled(false);
        panel3.add(textField4);
        final JButton button5 = new JButton(DefaultChartEditor.localizationResources.getString("Edit..."));
        button5.setEnabled(false);
        panel3.add(button5);
        panel2.add(panel3, "North");
        panel.add(panel2, "North");
        final JPanel panel4 = new JPanel(new BorderLayout());
        final TextTitle title = freeChart.getTitle();
        final Plot plot = freeChart.getPlot();
        final JTabbedPane tabbedPane = new JTabbedPane();
        (this.titleEditor = new DefaultTitleEditor(title)).setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        tabbedPane.addTab(DefaultChartEditor.localizationResources.getString("Title"), this.titleEditor);
        (this.plotEditor = new DefaultPlotEditor(plot)).setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        tabbedPane.addTab(DefaultChartEditor.localizationResources.getString("Plot"), this.plotEditor);
        tabbedPane.add(DefaultChartEditor.localizationResources.getString("Other"), panel);
        panel4.add(tabbedPane, "North");
        this.add(panel4);
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
    
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("BackgroundPaint")) {
            this.attemptModifyBackgroundPaint();
        }
    }
    
    private void attemptModifyBackgroundPaint() {
        final Color showDialog = JColorChooser.showDialog(this, DefaultChartEditor.localizationResources.getString("Background_Color"), Color.blue);
        if (showDialog != null) {
            this.background.setPaint(showDialog);
        }
    }
    
    public void updateChart(final JFreeChart titleProperties) {
        this.titleEditor.setTitleProperties(titleProperties);
        this.plotEditor.updatePlotProperties(titleProperties.getPlot());
        titleProperties.setAntiAlias(this.getAntiAlias());
        titleProperties.setBackgroundPaint(this.getBackgroundPaint());
    }
    
    static {
        DefaultChartEditor.localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");
    }
}
