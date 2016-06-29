/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.Timeline;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.HighLowItemLabelGenerator;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.PolarItemRenderer;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.LineRenderer3D;
import org.jfree.chart.renderer.category.StackedAreaRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer3D;
import org.jfree.chart.renderer.category.WaterfallBarRenderer;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.chart.renderer.xy.WindItemRenderer;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.urls.StandardXYZURLGenerator;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.WindDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.SortOrder;
import org.jfree.util.TableOrder;

public abstract class ChartFactory {
    public static JFreeChart createPieChart(String string, PieDataset pieDataset, boolean bl2, boolean bl3, boolean bl4) {
        PiePlot piePlot = new PiePlot(pieDataset);
        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator());
        piePlot.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        if (bl3) {
            piePlot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} = {1}"));
        }
        if (!bl4) return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, piePlot, bl2);
        piePlot.setURLGenerator(new StandardPieURLGenerator());
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, piePlot, bl2);
    }

    public static JFreeChart createPieChart(String string, PieDataset pieDataset, PieDataset pieDataset2, int n2, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        Object object2;
        PiePlot piePlot = new PiePlot(pieDataset);
        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator());
        piePlot.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        if (bl4) {
            piePlot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} = {1}"));
        }
        if (bl5) {
            piePlot.setURLGenerator(new StandardPieURLGenerator());
        }
        List list = pieDataset.getKeys();
        DefaultPieDataset defaultPieDataset = null;
        if (bl7) {
            defaultPieDataset = new DefaultPieDataset();
        }
        double d2 = 255.0 / (double)n2;
        for (Object object2 : list) {
            double d3;
            Number number = pieDataset.getValue((Comparable)object2);
            Number number2 = pieDataset2.getValue((Comparable)object2);
            if (number2 == null) {
                if (bl2) {
                    piePlot.setSectionPaint((Comparable)object2, (Paint)Color.green);
                } else {
                    piePlot.setSectionPaint((Comparable)object2, (Paint)Color.red);
                }
                if (!bl7) continue;
                defaultPieDataset.setValue((Comparable)((Object)new StringBuffer().append(object2).append(" (+100%)").toString()), number);
                continue;
            }
            double d4 = (number.doubleValue() / number2.doubleValue() - 1.0) * 100.0;
            double d5 = d3 = Math.abs(d4) >= (double)n2 ? 255.0 : Math.abs(d4) * d2;
            if (bl2 && number.doubleValue() > number2.doubleValue() || !bl2 && number.doubleValue() < number2.doubleValue()) {
                piePlot.setSectionPaint((Comparable)object2, (Paint)new Color(0, (int)d3, 0));
            } else {
                piePlot.setSectionPaint((Comparable)object2, (Paint)new Color((int)d3, 0, 0));
            }
            if (!bl7) continue;
            defaultPieDataset.setValue((Comparable)((Object)new StringBuffer().append(object2).append(" (").append(d4 >= 0.0 ? "+" : "").append(NumberFormat.getPercentInstance().format(d4 / 100.0)).append(")").toString()), number);
        }
        if (bl7) {
            piePlot.setDataset(defaultPieDataset);
        }
        JFreeChart jFreeChart = new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, piePlot, bl3);
        if (!bl6) return jFreeChart;
        object2 = null;
        object2 = new TextTitle(new StringBuffer().append("Bright ").append(bl2 ? "red" : "green").append("=change >=-").append(n2).append("%, Bright ").append(!bl2 ? "red" : "green").append("=change >=+").append(n2).append("%").toString(), new Font("SansSerif", 0, 10));
        jFreeChart.addSubtitle((Title)object2);
        return jFreeChart;
    }

    public static JFreeChart createRingChart(String string, PieDataset pieDataset, boolean bl2, boolean bl3, boolean bl4) {
        RingPlot ringPlot = new RingPlot(pieDataset);
        ringPlot.setLabelGenerator(new StandardPieSectionLabelGenerator());
        ringPlot.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        if (bl3) {
            ringPlot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} = {1}"));
        }
        if (!bl4) return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, ringPlot, bl2);
        ringPlot.setURLGenerator(new StandardPieURLGenerator());
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, ringPlot, bl2);
    }

    public static JFreeChart createMultiplePieChart(String string, CategoryDataset categoryDataset, TableOrder tableOrder, boolean bl2, boolean bl3, boolean bl4) {
        PiePlot piePlot;
        if (tableOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        MultiplePiePlot multiplePiePlot = new MultiplePiePlot(categoryDataset);
        multiplePiePlot.setDataExtractOrder(tableOrder);
        multiplePiePlot.setBackgroundPaint(null);
        multiplePiePlot.setOutlineStroke(null);
        if (bl3) {
            StandardPieToolTipGenerator standardPieToolTipGenerator = new StandardPieToolTipGenerator();
            piePlot = (PiePlot)multiplePiePlot.getPieChart().getPlot();
            piePlot.setToolTipGenerator(standardPieToolTipGenerator);
        }
        if (!bl4) return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, multiplePiePlot, bl2);
        StandardPieURLGenerator standardPieURLGenerator = new StandardPieURLGenerator();
        piePlot = (PiePlot)multiplePiePlot.getPieChart().getPlot();
        piePlot.setURLGenerator(standardPieURLGenerator);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, multiplePiePlot, bl2);
    }

    public static JFreeChart createPieChart3D(String string, PieDataset pieDataset, boolean bl2, boolean bl3, boolean bl4) {
        PiePlot3D piePlot3D = new PiePlot3D(pieDataset);
        piePlot3D.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        if (bl3) {
            piePlot3D.setToolTipGenerator(new StandardPieToolTipGenerator());
        }
        if (!bl4) return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, piePlot3D, bl2);
        piePlot3D.setURLGenerator(new StandardPieURLGenerator());
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, piePlot3D, bl2);
    }

    public static JFreeChart createMultiplePieChart3D(String string, CategoryDataset categoryDataset, TableOrder tableOrder, boolean bl2, boolean bl3, boolean bl4) {
        PiePlot piePlot;
        if (tableOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        MultiplePiePlot multiplePiePlot = new MultiplePiePlot(categoryDataset);
        multiplePiePlot.setDataExtractOrder(tableOrder);
        multiplePiePlot.setBackgroundPaint(null);
        multiplePiePlot.setOutlineStroke(null);
        JFreeChart jFreeChart = new JFreeChart(new PiePlot3D(null));
        TextTitle textTitle = new TextTitle("Series Title", new Font("SansSerif", 1, 12));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        jFreeChart.setTitle(textTitle);
        jFreeChart.removeLegend();
        jFreeChart.setBackgroundPaint(null);
        multiplePiePlot.setPieChart(jFreeChart);
        if (bl3) {
            StandardPieToolTipGenerator standardPieToolTipGenerator = new StandardPieToolTipGenerator();
            piePlot = (PiePlot)multiplePiePlot.getPieChart().getPlot();
            piePlot.setToolTipGenerator(standardPieToolTipGenerator);
        }
        if (!bl4) return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, multiplePiePlot, bl2);
        StandardPieURLGenerator standardPieURLGenerator = new StandardPieURLGenerator();
        piePlot = (PiePlot)multiplePiePlot.getPieChart().getPlot();
        piePlot.setURLGenerator(standardPieURLGenerator);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, multiplePiePlot, bl2);
    }

    public static JFreeChart createBarChart(String string, String string2, String string3, CategoryDataset categoryDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        CategoryAxis categoryAxis = new CategoryAxis(string2);
        NumberAxis numberAxis = new NumberAxis(string3);
        BarRenderer barRenderer = new BarRenderer();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            ItemLabelPosition itemLabelPosition2 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT);
            barRenderer.setPositiveItemLabelPosition(itemLabelPosition2);
            ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE9, TextAnchor.CENTER_RIGHT);
            barRenderer.setNegativeItemLabelPosition(itemLabelPosition);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER);
            barRenderer.setPositiveItemLabelPosition(itemLabelPosition);
            ItemLabelPosition itemLabelPosition2 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER);
            barRenderer.setNegativeItemLabelPosition(itemLabelPosition2);
        }
        if (bl3) {
            barRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (bl4) {
            barRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, barRenderer);
        categoryPlot.setOrientation(plotOrientation);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
    }

    public static JFreeChart createStackedBarChart(String string, String string2, String string3, CategoryDataset categoryDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        CategoryAxis categoryAxis = new CategoryAxis(string2);
        NumberAxis numberAxis = new NumberAxis(string3);
        StackedBarRenderer stackedBarRenderer = new StackedBarRenderer();
        if (bl3) {
            stackedBarRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (bl4) {
            stackedBarRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, stackedBarRenderer);
        categoryPlot.setOrientation(plotOrientation);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
    }

    public static JFreeChart createBarChart3D(String string, String string2, String string3, CategoryDataset categoryDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        CategoryAxis3D categoryAxis3D = new CategoryAxis3D(string2);
        NumberAxis3D numberAxis3D = new NumberAxis3D(string3);
        BarRenderer3D barRenderer3D = new BarRenderer3D();
        if (bl3) {
            barRenderer3D.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (bl4) {
            barRenderer3D.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis3D, numberAxis3D, barRenderer3D);
        categoryPlot.setOrientation(plotOrientation);
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            categoryPlot.setRowRenderingOrder(SortOrder.DESCENDING);
            categoryPlot.setColumnRenderingOrder(SortOrder.DESCENDING);
        }
        categoryPlot.setForegroundAlpha(0.75f);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
    }

    public static JFreeChart createStackedBarChart3D(String string, String string2, String string3, CategoryDataset categoryDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        CategoryAxis3D categoryAxis3D = new CategoryAxis3D(string2);
        NumberAxis3D numberAxis3D = new NumberAxis3D(string3);
        StackedBarRenderer3D stackedBarRenderer3D = new StackedBarRenderer3D();
        if (bl3) {
            stackedBarRenderer3D.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (bl4) {
            stackedBarRenderer3D.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis3D, numberAxis3D, stackedBarRenderer3D);
        categoryPlot.setOrientation(plotOrientation);
        if (plotOrientation != PlotOrientation.HORIZONTAL) return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
        categoryPlot.setColumnRenderingOrder(SortOrder.DESCENDING);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
    }

    public static JFreeChart createAreaChart(String string, String string2, String string3, CategoryDataset categoryDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        CategoryAxis categoryAxis = new CategoryAxis(string2);
        categoryAxis.setCategoryMargin(0.0);
        NumberAxis numberAxis = new NumberAxis(string3);
        AreaRenderer areaRenderer = new AreaRenderer();
        if (bl3) {
            areaRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (bl4) {
            areaRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, areaRenderer);
        categoryPlot.setOrientation(plotOrientation);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
    }

    public static JFreeChart createStackedAreaChart(String string, String string2, String string3, CategoryDataset categoryDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        CategoryAxis categoryAxis = new CategoryAxis(string2);
        NumberAxis numberAxis = new NumberAxis(string3);
        StackedAreaRenderer stackedAreaRenderer = new StackedAreaRenderer();
        if (bl3) {
            stackedAreaRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (bl4) {
            stackedAreaRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, stackedAreaRenderer);
        categoryPlot.setOrientation(plotOrientation);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
    }

    public static JFreeChart createLineChart(String string, String string2, String string3, CategoryDataset categoryDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        CategoryAxis categoryAxis = new CategoryAxis(string2);
        NumberAxis numberAxis = new NumberAxis(string3);
        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer(true, false);
        if (bl3) {
            lineAndShapeRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (bl4) {
            lineAndShapeRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, lineAndShapeRenderer);
        categoryPlot.setOrientation(plotOrientation);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
    }

    public static JFreeChart createLineChart3D(String string, String string2, String string3, CategoryDataset categoryDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        CategoryAxis3D categoryAxis3D = new CategoryAxis3D(string2);
        NumberAxis3D numberAxis3D = new NumberAxis3D(string3);
        LineRenderer3D lineRenderer3D = new LineRenderer3D();
        if (bl3) {
            lineRenderer3D.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (bl4) {
            lineRenderer3D.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis3D, numberAxis3D, lineRenderer3D);
        categoryPlot.setOrientation(plotOrientation);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
    }

    public static JFreeChart createGanttChart(String string, String string2, String string3, IntervalCategoryDataset intervalCategoryDataset, boolean bl2, boolean bl3, boolean bl4) {
        CategoryAxis categoryAxis = new CategoryAxis(string2);
        DateAxis dateAxis = new DateAxis(string3);
        GanttRenderer ganttRenderer = new GanttRenderer();
        if (bl3) {
            ganttRenderer.setBaseToolTipGenerator(new IntervalCategoryToolTipGenerator("{3} - {4}", DateFormat.getDateInstance()));
        }
        if (bl4) {
            ganttRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        CategoryPlot categoryPlot = new CategoryPlot(intervalCategoryDataset, categoryAxis, dateAxis, ganttRenderer);
        categoryPlot.setOrientation(PlotOrientation.HORIZONTAL);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
    }

    public static JFreeChart createWaterfallChart(String string, String string2, String string3, CategoryDataset categoryDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        CategoryAxis categoryAxis = new CategoryAxis(string2);
        categoryAxis.setCategoryMargin(0.0);
        NumberAxis numberAxis = new NumberAxis(string3);
        WaterfallBarRenderer waterfallBarRenderer = new WaterfallBarRenderer();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 1.5707963267948966);
            waterfallBarRenderer.setPositiveItemLabelPosition(itemLabelPosition);
            waterfallBarRenderer.setNegativeItemLabelPosition(itemLabelPosition);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 0.0);
            waterfallBarRenderer.setPositiveItemLabelPosition(itemLabelPosition);
            waterfallBarRenderer.setNegativeItemLabelPosition(itemLabelPosition);
        }
        if (bl3) {
            StandardCategoryToolTipGenerator standardCategoryToolTipGenerator = new StandardCategoryToolTipGenerator();
            waterfallBarRenderer.setBaseToolTipGenerator(standardCategoryToolTipGenerator);
        }
        if (bl4) {
            waterfallBarRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, waterfallBarRenderer);
        categoryPlot.clearRangeMarkers();
        ValueMarker valueMarker = new ValueMarker(0.0);
        valueMarker.setPaint(Color.black);
        categoryPlot.addRangeMarker(valueMarker, Layer.FOREGROUND);
        categoryPlot.setOrientation(plotOrientation);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
    }

    public static JFreeChart createPolarChart(String string, XYDataset xYDataset, boolean bl2, boolean bl3, boolean bl4) {
        PolarPlot polarPlot = new PolarPlot();
        polarPlot.setDataset(xYDataset);
        NumberAxis numberAxis = new NumberAxis();
        numberAxis.setAxisLineVisible(false);
        numberAxis.setTickMarksVisible(false);
        numberAxis.setTickLabelInsets(new RectangleInsets(0.0, 0.0, 0.0, 0.0));
        polarPlot.setAxis(numberAxis);
        polarPlot.setRenderer(new DefaultPolarItemRenderer());
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, polarPlot, bl2);
    }

    public static JFreeChart createScatterPlot(String string, String string2, String string3, XYDataset xYDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        NumberAxis numberAxis = new NumberAxis(string2);
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = new NumberAxis(string3);
        numberAxis2.setAutoRangeIncludesZero(false);
        XYPlot xYPlot = new XYPlot(xYDataset, numberAxis, numberAxis2, null);
        StandardXYToolTipGenerator standardXYToolTipGenerator = null;
        if (bl3) {
            standardXYToolTipGenerator = new StandardXYToolTipGenerator();
        }
        StandardXYURLGenerator standardXYURLGenerator = null;
        if (bl4) {
            standardXYURLGenerator = new StandardXYURLGenerator();
        }
        XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(false, true);
        xYLineAndShapeRenderer.setBaseToolTipGenerator(standardXYToolTipGenerator);
        xYLineAndShapeRenderer.setURLGenerator(standardXYURLGenerator);
        xYPlot.setRenderer(xYLineAndShapeRenderer);
        xYPlot.setOrientation(plotOrientation);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createXYBarChart(String string, String string2, boolean bl2, String string3, IntervalXYDataset intervalXYDataset, PlotOrientation plotOrientation, boolean bl3, boolean bl4, boolean bl5) {
        NumberAxis numberAxis;
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        ValueAxis valueAxis = null;
        if (bl2) {
            valueAxis = new DateAxis(string2);
        } else {
            numberAxis = new NumberAxis(string2);
            numberAxis.setAutoRangeIncludesZero(false);
            valueAxis = numberAxis;
        }
        numberAxis = new NumberAxis(string3);
        XYBarRenderer xYBarRenderer = new XYBarRenderer();
        if (bl4) {
            void var12_14;
            if (bl2) {
                StandardXYToolTipGenerator standardXYToolTipGenerator = StandardXYToolTipGenerator.getTimeSeriesInstance();
            } else {
                StandardXYToolTipGenerator standardXYToolTipGenerator = new StandardXYToolTipGenerator();
            }
            xYBarRenderer.setBaseToolTipGenerator((XYToolTipGenerator)var12_14);
        }
        if (bl5) {
            xYBarRenderer.setURLGenerator(new StandardXYURLGenerator());
        }
        XYPlot xYPlot = new XYPlot(intervalXYDataset, valueAxis, numberAxis, xYBarRenderer);
        xYPlot.setOrientation(plotOrientation);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl3);
    }

    public static JFreeChart createXYAreaChart(String string, String string2, String string3, XYDataset xYDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        NumberAxis numberAxis = new NumberAxis(string2);
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = new NumberAxis(string3);
        XYPlot xYPlot = new XYPlot(xYDataset, numberAxis, numberAxis2, null);
        xYPlot.setOrientation(plotOrientation);
        xYPlot.setForegroundAlpha(0.5f);
        StandardXYToolTipGenerator standardXYToolTipGenerator = null;
        if (bl3) {
            standardXYToolTipGenerator = new StandardXYToolTipGenerator();
        }
        StandardXYURLGenerator standardXYURLGenerator = null;
        if (bl4) {
            standardXYURLGenerator = new StandardXYURLGenerator();
        }
        xYPlot.setRenderer(new XYAreaRenderer(4, standardXYToolTipGenerator, standardXYURLGenerator));
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createStackedXYAreaChart(String string, String string2, String string3, TableXYDataset tableXYDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        NumberAxis numberAxis = new NumberAxis(string2);
        numberAxis.setAutoRangeIncludesZero(false);
        numberAxis.setLowerMargin(0.0);
        numberAxis.setUpperMargin(0.0);
        NumberAxis numberAxis2 = new NumberAxis(string3);
        StandardXYToolTipGenerator standardXYToolTipGenerator = null;
        if (bl3) {
            standardXYToolTipGenerator = new StandardXYToolTipGenerator();
        }
        StandardXYURLGenerator standardXYURLGenerator = null;
        if (bl4) {
            standardXYURLGenerator = new StandardXYURLGenerator();
        }
        StackedXYAreaRenderer2 stackedXYAreaRenderer2 = new StackedXYAreaRenderer2(standardXYToolTipGenerator, standardXYURLGenerator);
        stackedXYAreaRenderer2.setOutline(true);
        XYPlot xYPlot = new XYPlot(tableXYDataset, numberAxis, numberAxis2, stackedXYAreaRenderer2);
        xYPlot.setOrientation(plotOrientation);
        xYPlot.setRangeAxis(numberAxis2);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createXYLineChart(String string, String string2, String string3, XYDataset xYDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        NumberAxis numberAxis = new NumberAxis(string2);
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = new NumberAxis(string3);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(true, false);
        XYPlot xYPlot = new XYPlot(xYDataset, numberAxis, numberAxis2, xYLineAndShapeRenderer);
        xYPlot.setOrientation(plotOrientation);
        if (bl3) {
            xYLineAndShapeRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        }
        if (!bl4) return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
        xYLineAndShapeRenderer.setURLGenerator(new StandardXYURLGenerator());
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createXYStepChart(String string, String string2, String string3, XYDataset xYDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        DateAxis dateAxis = new DateAxis(string2);
        NumberAxis numberAxis = new NumberAxis(string3);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        StandardXYToolTipGenerator standardXYToolTipGenerator = null;
        if (bl3) {
            standardXYToolTipGenerator = new StandardXYToolTipGenerator();
        }
        StandardXYURLGenerator standardXYURLGenerator = null;
        if (bl4) {
            standardXYURLGenerator = new StandardXYURLGenerator();
        }
        XYStepRenderer xYStepRenderer = new XYStepRenderer(standardXYToolTipGenerator, standardXYURLGenerator);
        XYPlot xYPlot = new XYPlot(xYDataset, dateAxis, numberAxis, null);
        xYPlot.setRenderer(xYStepRenderer);
        xYPlot.setOrientation(plotOrientation);
        xYPlot.setDomainCrosshairVisible(false);
        xYPlot.setRangeCrosshairVisible(false);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createXYStepAreaChart(String string, String string2, String string3, XYDataset xYDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        NumberAxis numberAxis = new NumberAxis(string2);
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = new NumberAxis(string3);
        StandardXYToolTipGenerator standardXYToolTipGenerator = null;
        if (bl3) {
            standardXYToolTipGenerator = new StandardXYToolTipGenerator();
        }
        StandardXYURLGenerator standardXYURLGenerator = null;
        if (bl4) {
            standardXYURLGenerator = new StandardXYURLGenerator();
        }
        XYStepAreaRenderer xYStepAreaRenderer = new XYStepAreaRenderer(3, standardXYToolTipGenerator, standardXYURLGenerator);
        XYPlot xYPlot = new XYPlot(xYDataset, numberAxis, numberAxis2, null);
        xYPlot.setRenderer(xYStepAreaRenderer);
        xYPlot.setOrientation(plotOrientation);
        xYPlot.setDomainCrosshairVisible(false);
        xYPlot.setRangeCrosshairVisible(false);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createTimeSeriesChart(String string, String string2, String string3, XYDataset xYDataset, boolean bl2, boolean bl3, boolean bl4) {
        DateAxis dateAxis = new DateAxis(string2);
        dateAxis.setLowerMargin(0.02);
        dateAxis.setUpperMargin(0.02);
        NumberAxis numberAxis = new NumberAxis(string3);
        numberAxis.setAutoRangeIncludesZero(false);
        XYPlot xYPlot = new XYPlot(xYDataset, dateAxis, numberAxis, null);
        StandardXYToolTipGenerator standardXYToolTipGenerator = null;
        if (bl3) {
            standardXYToolTipGenerator = StandardXYToolTipGenerator.getTimeSeriesInstance();
        }
        StandardXYURLGenerator standardXYURLGenerator = null;
        if (bl4) {
            standardXYURLGenerator = new StandardXYURLGenerator();
        }
        XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(true, false);
        xYLineAndShapeRenderer.setBaseToolTipGenerator(standardXYToolTipGenerator);
        xYLineAndShapeRenderer.setURLGenerator(standardXYURLGenerator);
        xYPlot.setRenderer(xYLineAndShapeRenderer);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createCandlestickChart(String string, String string2, String string3, OHLCDataset oHLCDataset, boolean bl2) {
        DateAxis dateAxis = new DateAxis(string2);
        NumberAxis numberAxis = new NumberAxis(string3);
        XYPlot xYPlot = new XYPlot(oHLCDataset, dateAxis, numberAxis, null);
        xYPlot.setRenderer(new CandlestickRenderer());
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createHighLowChart(String string, String string2, String string3, OHLCDataset oHLCDataset, boolean bl2) {
        DateAxis dateAxis = new DateAxis(string2);
        NumberAxis numberAxis = new NumberAxis(string3);
        HighLowRenderer highLowRenderer = new HighLowRenderer();
        highLowRenderer.setBaseToolTipGenerator(new HighLowItemLabelGenerator());
        XYPlot xYPlot = new XYPlot(oHLCDataset, dateAxis, numberAxis, highLowRenderer);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createHighLowChart(String string, String string2, String string3, OHLCDataset oHLCDataset, Timeline timeline, boolean bl2) {
        DateAxis dateAxis = new DateAxis(string2);
        dateAxis.setTimeline(timeline);
        NumberAxis numberAxis = new NumberAxis(string3);
        HighLowRenderer highLowRenderer = new HighLowRenderer();
        highLowRenderer.setBaseToolTipGenerator(new HighLowItemLabelGenerator());
        XYPlot xYPlot = new XYPlot(oHLCDataset, dateAxis, numberAxis, highLowRenderer);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createBubbleChart(String string, String string2, String string3, XYZDataset xYZDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        NumberAxis numberAxis = new NumberAxis(string2);
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = new NumberAxis(string3);
        numberAxis2.setAutoRangeIncludesZero(false);
        XYPlot xYPlot = new XYPlot(xYZDataset, numberAxis, numberAxis2, null);
        XYBubbleRenderer xYBubbleRenderer = new XYBubbleRenderer(2);
        if (bl3) {
            xYBubbleRenderer.setBaseToolTipGenerator(new StandardXYZToolTipGenerator());
        }
        if (bl4) {
            xYBubbleRenderer.setURLGenerator(new StandardXYZURLGenerator());
        }
        xYPlot.setRenderer(xYBubbleRenderer);
        xYPlot.setOrientation(plotOrientation);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createHistogram(String string, String string2, String string3, IntervalXYDataset intervalXYDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        NumberAxis numberAxis = new NumberAxis(string2);
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = new NumberAxis(string3);
        XYBarRenderer xYBarRenderer = new XYBarRenderer();
        if (bl3) {
            xYBarRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        }
        if (bl4) {
            xYBarRenderer.setURLGenerator(new StandardXYURLGenerator());
        }
        XYPlot xYPlot = new XYPlot(intervalXYDataset, numberAxis, numberAxis2, xYBarRenderer);
        xYPlot.setOrientation(plotOrientation);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createBoxAndWhiskerChart(String string, String string2, String string3, BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset, boolean bl2) {
        CategoryAxis categoryAxis = new CategoryAxis(string2);
        NumberAxis numberAxis = new NumberAxis(string3);
        numberAxis.setAutoRangeIncludesZero(false);
        BoxAndWhiskerRenderer boxAndWhiskerRenderer = new BoxAndWhiskerRenderer();
        boxAndWhiskerRenderer.setToolTipGenerator(new BoxAndWhiskerToolTipGenerator());
        CategoryPlot categoryPlot = new CategoryPlot(boxAndWhiskerCategoryDataset, categoryAxis, numberAxis, boxAndWhiskerRenderer);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, bl2);
    }

    public static JFreeChart createBoxAndWhiskerChart(String string, String string2, String string3, BoxAndWhiskerXYDataset boxAndWhiskerXYDataset, boolean bl2) {
        DateAxis dateAxis = new DateAxis(string2);
        NumberAxis numberAxis = new NumberAxis(string3);
        numberAxis.setAutoRangeIncludesZero(false);
        XYBoxAndWhiskerRenderer xYBoxAndWhiskerRenderer = new XYBoxAndWhiskerRenderer(10.0);
        XYPlot xYPlot = new XYPlot(boxAndWhiskerXYDataset, dateAxis, numberAxis, xYBoxAndWhiskerRenderer);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createWindPlot(String string, String string2, String string3, WindDataset windDataset, boolean bl2, boolean bl3, boolean bl4) {
        DateAxis dateAxis = new DateAxis(string2);
        NumberAxis numberAxis = new NumberAxis(string3);
        numberAxis.setRange(-12.0, 12.0);
        WindItemRenderer windItemRenderer = new WindItemRenderer();
        if (bl3) {
            windItemRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        }
        if (bl4) {
            windItemRenderer.setURLGenerator(new StandardXYURLGenerator());
        }
        XYPlot xYPlot = new XYPlot(windDataset, dateAxis, numberAxis, windItemRenderer);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, xYPlot, bl2);
    }

    public static JFreeChart createWaferMapChart(String string, WaferMapDataset waferMapDataset, PlotOrientation plotOrientation, boolean bl2, boolean bl3, boolean bl4) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        WaferMapPlot waferMapPlot = new WaferMapPlot(waferMapDataset);
        WaferMapRenderer waferMapRenderer = new WaferMapRenderer();
        waferMapPlot.setRenderer(waferMapRenderer);
        return new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, waferMapPlot, bl2);
    }
}

