package org.jfree.chart.plot;

import javax.swing.*;
import java.io.*;
import org.jfree.chart.*;
import org.jfree.ui.*;
import org.jfree.data.general.*;
import org.jfree.chart.title.*;
import java.text.*;
import java.awt.*;

public class JThermometer extends JPanel implements Serializable
{
    private static final long serialVersionUID = 1079905665515589820L;
    private DefaultValueDataset data;
    private JFreeChart chart;
    private ChartPanel panel;
    private ThermometerPlot plot;
    
    public JThermometer() {
        super(new CardLayout());
        (this.plot = new ThermometerPlot()).setInsets(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        this.data = new DefaultValueDataset();
        this.plot.setDataset(this.data);
        this.chart = new JFreeChart(null, JFreeChart.DEFAULT_TITLE_FONT, this.plot, false);
        this.add(this.panel = new ChartPanel(this.chart), "Panel");
        this.setBackground(this.getBackground());
    }
    
    public void addSubtitle(final Title title) {
        this.chart.addSubtitle(title);
    }
    
    public void addSubtitle(final String s) {
        this.chart.addSubtitle(new TextTitle(s));
    }
    
    public void addSubtitle(final String s, final Font font) {
        this.chart.addSubtitle(new TextTitle(s, font));
    }
    
    public void setValueFormat(final DecimalFormat valueFormat) {
        this.plot.setValueFormat(valueFormat);
    }
    
    public void setRange(final double n, final double n2) {
        this.plot.setRange(n, n2);
    }
    
    public void setSubrangeInfo(final int n, final double n2, final double n3) {
        this.plot.setSubrangeInfo(n, n2, n3);
    }
    
    public void setSubrangeInfo(final int n, final double n2, final double n3, final double n4, final double n5) {
        this.plot.setSubrangeInfo(n, n2, n3, n4, n5);
    }
    
    public void setValueLocation(final int valueLocation) {
        this.plot.setValueLocation(valueLocation);
        this.panel.repaint();
    }
    
    public void setValuePaint(final Paint valuePaint) {
        this.plot.setValuePaint(valuePaint);
    }
    
    public Number getValue() {
        if (this.data != null) {
            return this.data.getValue();
        }
        return null;
    }
    
    public void setValue(final double n) {
        this.setValue(new Double(n));
    }
    
    public void setValue(final Number value) {
        if (this.data != null) {
            this.data.setValue(value);
        }
    }
    
    public void setUnits(final int units) {
        if (this.plot != null) {
            this.plot.setUnits(units);
        }
    }
    
    public void setOutlinePaint(final Paint outlinePaint) {
        if (this.plot != null) {
            this.plot.setOutlinePaint(outlinePaint);
        }
    }
    
    public void setForeground(final Color color) {
        super.setForeground(color);
        if (this.plot != null) {
            this.plot.setThermometerPaint(color);
        }
    }
    
    public void setBackground(final Color color) {
        super.setBackground(color);
        if (this.plot != null) {
            this.plot.setBackgroundPaint(color);
        }
        if (this.chart != null) {
            this.chart.setBackgroundPaint(color);
        }
        if (this.panel != null) {
            this.panel.setBackground(color);
        }
    }
    
    public void setValueFont(final Font valueFont) {
        if (this.plot != null) {
            this.plot.setValueFont(valueFont);
        }
    }
    
    public Font getTickLabelFont() {
        return this.plot.getRangeAxis().getTickLabelFont();
    }
    
    public void setTickLabelFont(final Font tickLabelFont) {
        this.plot.getRangeAxis().setTickLabelFont(tickLabelFont);
    }
    
    public void changeTickFontSize(final int n) {
        final Font tickLabelFont = this.getTickLabelFont();
        this.setTickLabelFont(new Font(tickLabelFont.getFontName(), tickLabelFont.getStyle(), tickLabelFont.getSize() + n));
    }
    
    public void setTickFontStyle(final int n) {
        final Font tickLabelFont = this.getTickLabelFont();
        this.setTickLabelFont(new Font(tickLabelFont.getFontName(), n, tickLabelFont.getSize()));
    }
    
    public void setFollowDataInSubranges(final boolean followDataInSubranges) {
        this.plot.setFollowDataInSubranges(followDataInSubranges);
    }
    
    public void setShowValueLines(final boolean showValueLines) {
        this.plot.setShowValueLines(showValueLines);
    }
    
    public void setShowAxisLocation(final int axisLocation) {
        this.plot.setAxisLocation(axisLocation);
    }
    
    public int getShowAxisLocation() {
        return this.plot.getAxisLocation();
    }
}
