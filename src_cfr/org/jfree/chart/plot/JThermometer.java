/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.RectangleInsets;

public class JThermometer
extends JPanel
implements Serializable {
    private static final long serialVersionUID = 1079905665515589820L;
    private DefaultValueDataset data;
    private JFreeChart chart;
    private ChartPanel panel;
    private ThermometerPlot plot = new ThermometerPlot();

    public JThermometer() {
        super(new CardLayout());
        this.plot.setInsets(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        this.data = new DefaultValueDataset();
        this.plot.setDataset(this.data);
        this.chart = new JFreeChart(null, JFreeChart.DEFAULT_TITLE_FONT, this.plot, false);
        this.panel = new ChartPanel(this.chart);
        this.add((Component)this.panel, "Panel");
        this.setBackground(this.getBackground());
    }

    public void addSubtitle(Title title) {
        this.chart.addSubtitle(title);
    }

    public void addSubtitle(String string) {
        this.chart.addSubtitle(new TextTitle(string));
    }

    public void addSubtitle(String string, Font font) {
        this.chart.addSubtitle(new TextTitle(string, font));
    }

    public void setValueFormat(DecimalFormat decimalFormat) {
        this.plot.setValueFormat(decimalFormat);
    }

    public void setRange(double d2, double d3) {
        this.plot.setRange(d2, d3);
    }

    public void setSubrangeInfo(int n2, double d2, double d3) {
        this.plot.setSubrangeInfo(n2, d2, d3);
    }

    public void setSubrangeInfo(int n2, double d2, double d3, double d4, double d5) {
        this.plot.setSubrangeInfo(n2, d2, d3, d4, d5);
    }

    public void setValueLocation(int n2) {
        this.plot.setValueLocation(n2);
        this.panel.repaint();
    }

    public void setValuePaint(Paint paint) {
        this.plot.setValuePaint(paint);
    }

    public Number getValue() {
        if (this.data == null) return null;
        return this.data.getValue();
    }

    public void setValue(double d2) {
        this.setValue(new Double(d2));
    }

    public void setValue(Number number) {
        if (this.data == null) return;
        this.data.setValue(number);
    }

    public void setUnits(int n2) {
        if (this.plot == null) return;
        this.plot.setUnits(n2);
    }

    public void setOutlinePaint(Paint paint) {
        if (this.plot == null) return;
        this.plot.setOutlinePaint(paint);
    }

    @Override
    public void setForeground(Color color) {
        super.setForeground(color);
        if (this.plot == null) return;
        this.plot.setThermometerPaint(color);
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        if (this.plot != null) {
            this.plot.setBackgroundPaint(color);
        }
        if (this.chart != null) {
            this.chart.setBackgroundPaint(color);
        }
        if (this.panel == null) return;
        this.panel.setBackground(color);
    }

    public void setValueFont(Font font) {
        if (this.plot == null) return;
        this.plot.setValueFont(font);
    }

    public Font getTickLabelFont() {
        ValueAxis valueAxis = this.plot.getRangeAxis();
        return valueAxis.getTickLabelFont();
    }

    public void setTickLabelFont(Font font) {
        ValueAxis valueAxis = this.plot.getRangeAxis();
        valueAxis.setTickLabelFont(font);
    }

    public void changeTickFontSize(int n2) {
        Font font = this.getTickLabelFont();
        String string = font.getFontName();
        Font font2 = new Font(string, font.getStyle(), font.getSize() + n2);
        this.setTickLabelFont(font2);
    }

    public void setTickFontStyle(int n2) {
        Font font = this.getTickLabelFont();
        String string = font.getFontName();
        Font font2 = new Font(string, n2, font.getSize());
        this.setTickLabelFont(font2);
    }

    public void setFollowDataInSubranges(boolean bl2) {
        this.plot.setFollowDataInSubranges(bl2);
    }

    public void setShowValueLines(boolean bl2) {
        this.plot.setShowValueLines(bl2);
    }

    public void setShowAxisLocation(int n2) {
        this.plot.setAxisLocation(n2);
    }

    public int getShowAxisLocation() {
        return this.plot.getAxisLocation();
    }
}

