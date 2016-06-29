package org.jfree.chart;

import org.jfree.chart.title.*;
import java.util.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.data.category.*;
import java.text.*;
import org.jfree.ui.*;
import java.io.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.labels.*;
import org.jfree.data.statistics.*;
import org.jfree.data.xy.*;
import org.jfree.chart.renderer.xy.*;
import org.jfree.data.general.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.*;

public abstract class ChartFactory
{
    public static JFreeChart createPieChart(final String s, final PieDataset pieDataset, final boolean b, final boolean b2, final boolean b3) {
        final PiePlot piePlot = new PiePlot(pieDataset);
        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator());
        piePlot.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        if (b2) {
            piePlot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} = {1}"));
        }
        if (b3) {
            piePlot.setURLGenerator(new StandardPieURLGenerator());
        }
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, piePlot, b);
    }
    
    public static JFreeChart createPieChart(final String s, final PieDataset pieDataset, final PieDataset pieDataset2, final int n, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6) {
        final PiePlot piePlot = new PiePlot(pieDataset);
        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator());
        piePlot.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        if (b3) {
            piePlot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} = {1}"));
        }
        if (b4) {
            piePlot.setURLGenerator(new StandardPieURLGenerator());
        }
        final List keys = pieDataset.getKeys();
        DefaultPieDataset dataset = null;
        if (b6) {
            dataset = new DefaultPieDataset();
        }
        final double n2 = 255.0 / n;
        for (final Comparable comparable : keys) {
            final Number value = pieDataset.getValue(comparable);
            final Number value2 = pieDataset2.getValue(comparable);
            if (value2 == null) {
                if (b) {
                    piePlot.setSectionPaint(comparable, Color.green);
                }
                else {
                    piePlot.setSectionPaint(comparable, Color.red);
                }
                if (!b6) {
                    continue;
                }
                dataset.setValue(comparable + " (+100%)", value);
            }
            else {
                final double n3 = (value.doubleValue() / value2.doubleValue() - 1.0) * 100.0;
                final double n4 = (Math.abs(n3) >= n) ? 255.0 : (Math.abs(n3) * n2);
                if ((b && value.doubleValue() > value2.doubleValue()) || (!b && value.doubleValue() < value2.doubleValue())) {
                    piePlot.setSectionPaint(comparable, new Color(0, (int)n4, 0));
                }
                else {
                    piePlot.setSectionPaint(comparable, new Color((int)n4, 0, 0));
                }
                if (!b6) {
                    continue;
                }
                dataset.setValue(comparable + " (" + ((n3 >= 0.0) ? "+" : "") + NumberFormat.getPercentInstance().format(n3 / 100.0) + ")", value);
            }
        }
        if (b6) {
            piePlot.setDataset(dataset);
        }
        final JFreeChart freeChart = new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, piePlot, b2);
        if (b5) {
            freeChart.addSubtitle(new TextTitle("Bright " + (b ? "red" : "green") + "=change >=-" + n + "%, Bright " + (b ? "green" : "red") + "=change >=+" + n + "%", new Font("SansSerif", 0, 10)));
        }
        return freeChart;
    }
    
    public static JFreeChart createRingChart(final String s, final PieDataset pieDataset, final boolean b, final boolean b2, final boolean b3) {
        final RingPlot ringPlot = new RingPlot(pieDataset);
        ringPlot.setLabelGenerator(new StandardPieSectionLabelGenerator());
        ringPlot.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        if (b2) {
            ringPlot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} = {1}"));
        }
        if (b3) {
            ringPlot.setURLGenerator(new StandardPieURLGenerator());
        }
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, ringPlot, b);
    }
    
    public static JFreeChart createMultiplePieChart(final String s, final CategoryDataset categoryDataset, final TableOrder dataExtractOrder, final boolean b, final boolean b2, final boolean b3) {
        if (dataExtractOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        final MultiplePiePlot multiplePiePlot = new MultiplePiePlot(categoryDataset);
        multiplePiePlot.setDataExtractOrder(dataExtractOrder);
        multiplePiePlot.setBackgroundPaint(null);
        multiplePiePlot.setOutlineStroke(null);
        if (b2) {
            ((PiePlot)multiplePiePlot.getPieChart().getPlot()).setToolTipGenerator(new StandardPieToolTipGenerator());
        }
        if (b3) {
            ((PiePlot)multiplePiePlot.getPieChart().getPlot()).setURLGenerator(new StandardPieURLGenerator());
        }
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, multiplePiePlot, b);
    }
    
    public static JFreeChart createPieChart3D(final String s, final PieDataset pieDataset, final boolean b, final boolean b2, final boolean b3) {
        final PiePlot3D piePlot3D = new PiePlot3D(pieDataset);
        piePlot3D.setInsets(new RectangleInsets(0.0, 5.0, 5.0, 5.0));
        if (b2) {
            piePlot3D.setToolTipGenerator(new StandardPieToolTipGenerator());
        }
        if (b3) {
            piePlot3D.setURLGenerator(new StandardPieURLGenerator());
        }
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, piePlot3D, b);
    }
    
    public static JFreeChart createMultiplePieChart3D(final String s, final CategoryDataset categoryDataset, final TableOrder dataExtractOrder, final boolean b, final boolean b2, final boolean b3) {
        if (dataExtractOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        final MultiplePiePlot multiplePiePlot = new MultiplePiePlot(categoryDataset);
        multiplePiePlot.setDataExtractOrder(dataExtractOrder);
        multiplePiePlot.setBackgroundPaint(null);
        multiplePiePlot.setOutlineStroke(null);
        final JFreeChart pieChart = new JFreeChart(new PiePlot3D(null));
        final TextTitle title = new TextTitle("Series Title", new Font("SansSerif", 1, 12));
        title.setPosition(RectangleEdge.BOTTOM);
        pieChart.setTitle(title);
        pieChart.removeLegend();
        pieChart.setBackgroundPaint(null);
        multiplePiePlot.setPieChart(pieChart);
        if (b2) {
            ((PiePlot)multiplePiePlot.getPieChart().getPlot()).setToolTipGenerator(new StandardPieToolTipGenerator());
        }
        if (b3) {
            ((PiePlot)multiplePiePlot.getPieChart().getPlot()).setURLGenerator(new StandardPieURLGenerator());
        }
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, multiplePiePlot, b);
    }
    
    public static JFreeChart createBarChart(final String s, final String s2, final String s3, final CategoryDataset categoryDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final CategoryAxis categoryAxis = new CategoryAxis(s2);
        final NumberAxis numberAxis = new NumberAxis(s3);
        final BarRenderer barRenderer = new BarRenderer();
        if (orientation == PlotOrientation.HORIZONTAL) {
            barRenderer.setPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT));
            barRenderer.setNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE9, TextAnchor.CENTER_RIGHT));
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            barRenderer.setPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
            barRenderer.setNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER));
        }
        if (b2) {
            barRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (b3) {
            barRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        final CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, barRenderer);
        categoryPlot.setOrientation(orientation);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, b);
    }
    
    public static JFreeChart createStackedBarChart(final String s, final String s2, final String s3, final CategoryDataset categoryDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final CategoryAxis categoryAxis = new CategoryAxis(s2);
        final NumberAxis numberAxis = new NumberAxis(s3);
        final StackedBarRenderer stackedBarRenderer = new StackedBarRenderer();
        if (b2) {
            stackedBarRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (b3) {
            stackedBarRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        final CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, stackedBarRenderer);
        categoryPlot.setOrientation(orientation);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, b);
    }
    
    public static JFreeChart createBarChart3D(final String s, final String s2, final String s3, final CategoryDataset categoryDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final CategoryAxis3D categoryAxis3D = new CategoryAxis3D(s2);
        final NumberAxis3D numberAxis3D = new NumberAxis3D(s3);
        final BarRenderer3D barRenderer3D = new BarRenderer3D();
        if (b2) {
            barRenderer3D.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (b3) {
            barRenderer3D.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        final CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis3D, numberAxis3D, barRenderer3D);
        categoryPlot.setOrientation(orientation);
        if (orientation == PlotOrientation.HORIZONTAL) {
            categoryPlot.setRowRenderingOrder(SortOrder.DESCENDING);
            categoryPlot.setColumnRenderingOrder(SortOrder.DESCENDING);
        }
        categoryPlot.setForegroundAlpha(0.75f);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, b);
    }
    
    public static JFreeChart createStackedBarChart3D(final String s, final String s2, final String s3, final CategoryDataset categoryDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final CategoryAxis3D categoryAxis3D = new CategoryAxis3D(s2);
        final NumberAxis3D numberAxis3D = new NumberAxis3D(s3);
        final StackedBarRenderer3D stackedBarRenderer3D = new StackedBarRenderer3D();
        if (b2) {
            stackedBarRenderer3D.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (b3) {
            stackedBarRenderer3D.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        final CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis3D, numberAxis3D, stackedBarRenderer3D);
        categoryPlot.setOrientation(orientation);
        if (orientation == PlotOrientation.HORIZONTAL) {
            categoryPlot.setColumnRenderingOrder(SortOrder.DESCENDING);
        }
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, b);
    }
    
    public static JFreeChart createAreaChart(final String s, final String s2, final String s3, final CategoryDataset categoryDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final CategoryAxis categoryAxis = new CategoryAxis(s2);
        categoryAxis.setCategoryMargin(0.0);
        final NumberAxis numberAxis = new NumberAxis(s3);
        final AreaRenderer areaRenderer = new AreaRenderer();
        if (b2) {
            areaRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (b3) {
            areaRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        final CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, areaRenderer);
        categoryPlot.setOrientation(orientation);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, b);
    }
    
    public static JFreeChart createStackedAreaChart(final String s, final String s2, final String s3, final CategoryDataset categoryDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final CategoryAxis categoryAxis = new CategoryAxis(s2);
        final NumberAxis numberAxis = new NumberAxis(s3);
        final StackedAreaRenderer stackedAreaRenderer = new StackedAreaRenderer();
        if (b2) {
            stackedAreaRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (b3) {
            stackedAreaRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        final CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, stackedAreaRenderer);
        categoryPlot.setOrientation(orientation);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, b);
    }
    
    public static JFreeChart createLineChart(final String s, final String s2, final String s3, final CategoryDataset categoryDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final CategoryAxis categoryAxis = new CategoryAxis(s2);
        final NumberAxis numberAxis = new NumberAxis(s3);
        final LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer(true, false);
        if (b2) {
            lineAndShapeRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (b3) {
            lineAndShapeRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        final CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, lineAndShapeRenderer);
        categoryPlot.setOrientation(orientation);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, b);
    }
    
    public static JFreeChart createLineChart3D(final String s, final String s2, final String s3, final CategoryDataset categoryDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final CategoryAxis3D categoryAxis3D = new CategoryAxis3D(s2);
        final NumberAxis3D numberAxis3D = new NumberAxis3D(s3);
        final LineRenderer3D lineRenderer3D = new LineRenderer3D();
        if (b2) {
            lineRenderer3D.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (b3) {
            lineRenderer3D.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        final CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis3D, numberAxis3D, lineRenderer3D);
        categoryPlot.setOrientation(orientation);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, b);
    }
    
    public static JFreeChart createGanttChart(final String s, final String s2, final String s3, final IntervalCategoryDataset intervalCategoryDataset, final boolean b, final boolean b2, final boolean b3) {
        final CategoryAxis categoryAxis = new CategoryAxis(s2);
        final DateAxis dateAxis = new DateAxis(s3);
        final GanttRenderer ganttRenderer = new GanttRenderer();
        if (b2) {
            ganttRenderer.setBaseToolTipGenerator(new IntervalCategoryToolTipGenerator("{3} - {4}", DateFormat.getDateInstance()));
        }
        if (b3) {
            ganttRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        final CategoryPlot categoryPlot = new CategoryPlot(intervalCategoryDataset, categoryAxis, dateAxis, ganttRenderer);
        categoryPlot.setOrientation(PlotOrientation.HORIZONTAL);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, b);
    }
    
    public static JFreeChart createWaterfallChart(final String s, final String s2, final String s3, final CategoryDataset categoryDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final CategoryAxis categoryAxis = new CategoryAxis(s2);
        categoryAxis.setCategoryMargin(0.0);
        final NumberAxis numberAxis = new NumberAxis(s3);
        final WaterfallBarRenderer waterfallBarRenderer = new WaterfallBarRenderer();
        if (orientation == PlotOrientation.HORIZONTAL) {
            final ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 1.5707963267948966);
            waterfallBarRenderer.setPositiveItemLabelPosition(itemLabelPosition);
            waterfallBarRenderer.setNegativeItemLabelPosition(itemLabelPosition);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            final ItemLabelPosition itemLabelPosition2 = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 0.0);
            waterfallBarRenderer.setPositiveItemLabelPosition(itemLabelPosition2);
            waterfallBarRenderer.setNegativeItemLabelPosition(itemLabelPosition2);
        }
        if (b2) {
            waterfallBarRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        }
        if (b3) {
            waterfallBarRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
        }
        final CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, numberAxis, waterfallBarRenderer);
        categoryPlot.clearRangeMarkers();
        final ValueMarker valueMarker = new ValueMarker(0.0);
        valueMarker.setPaint(Color.black);
        categoryPlot.addRangeMarker(valueMarker, Layer.FOREGROUND);
        categoryPlot.setOrientation(orientation);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, categoryPlot, b);
    }
    
    public static JFreeChart createPolarChart(final String s, final XYDataset dataset, final boolean b, final boolean b2, final boolean b3) {
        final PolarPlot polarPlot = new PolarPlot();
        polarPlot.setDataset(dataset);
        final NumberAxis axis = new NumberAxis();
        axis.setAxisLineVisible(false);
        axis.setTickMarksVisible(false);
        axis.setTickLabelInsets(new RectangleInsets(0.0, 0.0, 0.0, 0.0));
        polarPlot.setAxis(axis);
        polarPlot.setRenderer(new DefaultPolarItemRenderer());
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, polarPlot, b);
    }
    
    public static JFreeChart createScatterPlot(final String s, final String s2, final String s3, final XYDataset xyDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final NumberAxis numberAxis = new NumberAxis(s2);
        numberAxis.setAutoRangeIncludesZero(false);
        final NumberAxis numberAxis2 = new NumberAxis(s3);
        numberAxis2.setAutoRangeIncludesZero(false);
        final XYPlot xyPlot = new XYPlot(xyDataset, numberAxis, numberAxis2, null);
        XYToolTipGenerator baseToolTipGenerator = null;
        if (b2) {
            baseToolTipGenerator = new StandardXYToolTipGenerator();
        }
        XYURLGenerator urlGenerator = null;
        if (b3) {
            urlGenerator = new StandardXYURLGenerator();
        }
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(false, true);
        renderer.setBaseToolTipGenerator(baseToolTipGenerator);
        renderer.setURLGenerator(urlGenerator);
        xyPlot.setRenderer(renderer);
        xyPlot.setOrientation(orientation);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, xyPlot, b);
    }
    
    public static JFreeChart createXYBarChart(final String s, final String s2, final boolean b, final String s3, final IntervalXYDataset intervalXYDataset, final PlotOrientation orientation, final boolean b2, final boolean b3, final boolean b4) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        Serializable s4;
        if (b) {
            s4 = new DateAxis(s2);
        }
        else {
            final NumberAxis numberAxis = new NumberAxis(s2);
            numberAxis.setAutoRangeIncludesZero(false);
            s4 = numberAxis;
        }
        final NumberAxis numberAxis2 = new NumberAxis(s3);
        final XYBarRenderer xyBarRenderer = new XYBarRenderer();
        if (b3) {
            StandardXYToolTipGenerator timeSeriesInstance;
            if (b) {
                timeSeriesInstance = StandardXYToolTipGenerator.getTimeSeriesInstance();
            }
            else {
                timeSeriesInstance = new StandardXYToolTipGenerator();
            }
            xyBarRenderer.setBaseToolTipGenerator(timeSeriesInstance);
        }
        if (b4) {
            xyBarRenderer.setURLGenerator(new StandardXYURLGenerator());
        }
        final XYPlot xyPlot = new XYPlot(intervalXYDataset, (ValueAxis)s4, numberAxis2, xyBarRenderer);
        xyPlot.setOrientation(orientation);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, xyPlot, b2);
    }
    
    public static JFreeChart createXYAreaChart(final String s, final String s2, final String s3, final XYDataset xyDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final NumberAxis numberAxis = new NumberAxis(s2);
        numberAxis.setAutoRangeIncludesZero(false);
        final XYPlot xyPlot = new XYPlot(xyDataset, numberAxis, new NumberAxis(s3), null);
        xyPlot.setOrientation(orientation);
        xyPlot.setForegroundAlpha(0.5f);
        XYToolTipGenerator xyToolTipGenerator = null;
        if (b2) {
            xyToolTipGenerator = new StandardXYToolTipGenerator();
        }
        XYURLGenerator xyurlGenerator = null;
        if (b3) {
            xyurlGenerator = new StandardXYURLGenerator();
        }
        xyPlot.setRenderer(new XYAreaRenderer(4, xyToolTipGenerator, xyurlGenerator));
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, xyPlot, b);
    }
    
    public static JFreeChart createStackedXYAreaChart(final String s, final String s2, final String s3, final TableXYDataset tableXYDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final NumberAxis numberAxis = new NumberAxis(s2);
        numberAxis.setAutoRangeIncludesZero(false);
        numberAxis.setLowerMargin(0.0);
        numberAxis.setUpperMargin(0.0);
        final NumberAxis rangeAxis = new NumberAxis(s3);
        XYToolTipGenerator xyToolTipGenerator = null;
        if (b2) {
            xyToolTipGenerator = new StandardXYToolTipGenerator();
        }
        XYURLGenerator xyurlGenerator = null;
        if (b3) {
            xyurlGenerator = new StandardXYURLGenerator();
        }
        final StackedXYAreaRenderer2 stackedXYAreaRenderer2 = new StackedXYAreaRenderer2(xyToolTipGenerator, xyurlGenerator);
        stackedXYAreaRenderer2.setOutline(true);
        final XYPlot xyPlot = new XYPlot(tableXYDataset, numberAxis, rangeAxis, stackedXYAreaRenderer2);
        xyPlot.setOrientation(orientation);
        xyPlot.setRangeAxis(rangeAxis);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, xyPlot, b);
    }
    
    public static JFreeChart createXYLineChart(final String s, final String s2, final String s3, final XYDataset xyDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final NumberAxis numberAxis = new NumberAxis(s2);
        numberAxis.setAutoRangeIncludesZero(false);
        final NumberAxis numberAxis2 = new NumberAxis(s3);
        final XYLineAndShapeRenderer xyLineAndShapeRenderer = new XYLineAndShapeRenderer(true, false);
        final XYPlot xyPlot = new XYPlot(xyDataset, numberAxis, numberAxis2, xyLineAndShapeRenderer);
        xyPlot.setOrientation(orientation);
        if (b2) {
            xyLineAndShapeRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        }
        if (b3) {
            xyLineAndShapeRenderer.setURLGenerator(new StandardXYURLGenerator());
        }
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, xyPlot, b);
    }
    
    public static JFreeChart createXYStepChart(final String s, final String s2, final String s3, final XYDataset xyDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final DateAxis dateAxis = new DateAxis(s2);
        final NumberAxis numberAxis = new NumberAxis(s3);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYToolTipGenerator xyToolTipGenerator = null;
        if (b2) {
            xyToolTipGenerator = new StandardXYToolTipGenerator();
        }
        XYURLGenerator xyurlGenerator = null;
        if (b3) {
            xyurlGenerator = new StandardXYURLGenerator();
        }
        final XYStepRenderer renderer = new XYStepRenderer(xyToolTipGenerator, xyurlGenerator);
        final XYPlot xyPlot = new XYPlot(xyDataset, dateAxis, numberAxis, null);
        xyPlot.setRenderer(renderer);
        xyPlot.setOrientation(orientation);
        xyPlot.setDomainCrosshairVisible(false);
        xyPlot.setRangeCrosshairVisible(false);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, xyPlot, b);
    }
    
    public static JFreeChart createXYStepAreaChart(final String s, final String s2, final String s3, final XYDataset xyDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final NumberAxis numberAxis = new NumberAxis(s2);
        numberAxis.setAutoRangeIncludesZero(false);
        final NumberAxis numberAxis2 = new NumberAxis(s3);
        XYToolTipGenerator xyToolTipGenerator = null;
        if (b2) {
            xyToolTipGenerator = new StandardXYToolTipGenerator();
        }
        XYURLGenerator xyurlGenerator = null;
        if (b3) {
            xyurlGenerator = new StandardXYURLGenerator();
        }
        final XYStepAreaRenderer renderer = new XYStepAreaRenderer(3, xyToolTipGenerator, xyurlGenerator);
        final XYPlot xyPlot = new XYPlot(xyDataset, numberAxis, numberAxis2, null);
        xyPlot.setRenderer(renderer);
        xyPlot.setOrientation(orientation);
        xyPlot.setDomainCrosshairVisible(false);
        xyPlot.setRangeCrosshairVisible(false);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, xyPlot, b);
    }
    
    public static JFreeChart createTimeSeriesChart(final String s, final String s2, final String s3, final XYDataset xyDataset, final boolean b, final boolean b2, final boolean b3) {
        final DateAxis dateAxis = new DateAxis(s2);
        dateAxis.setLowerMargin(0.02);
        dateAxis.setUpperMargin(0.02);
        final NumberAxis numberAxis = new NumberAxis(s3);
        numberAxis.setAutoRangeIncludesZero(false);
        final XYPlot xyPlot = new XYPlot(xyDataset, dateAxis, numberAxis, null);
        XYToolTipGenerator timeSeriesInstance = null;
        if (b2) {
            timeSeriesInstance = StandardXYToolTipGenerator.getTimeSeriesInstance();
        }
        XYURLGenerator urlGenerator = null;
        if (b3) {
            urlGenerator = new StandardXYURLGenerator();
        }
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setBaseToolTipGenerator(timeSeriesInstance);
        renderer.setURLGenerator(urlGenerator);
        xyPlot.setRenderer(renderer);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, xyPlot, b);
    }
    
    public static JFreeChart createCandlestickChart(final String s, final String s2, final String s3, final OHLCDataset ohlcDataset, final boolean b) {
        final XYPlot xyPlot = new XYPlot(ohlcDataset, new DateAxis(s2), new NumberAxis(s3), null);
        xyPlot.setRenderer(new CandlestickRenderer());
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, xyPlot, b);
    }
    
    public static JFreeChart createHighLowChart(final String s, final String s2, final String s3, final OHLCDataset ohlcDataset, final boolean b) {
        final DateAxis dateAxis = new DateAxis(s2);
        final NumberAxis numberAxis = new NumberAxis(s3);
        final HighLowRenderer highLowRenderer = new HighLowRenderer();
        highLowRenderer.setBaseToolTipGenerator(new HighLowItemLabelGenerator());
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, new XYPlot(ohlcDataset, dateAxis, numberAxis, highLowRenderer), b);
    }
    
    public static JFreeChart createHighLowChart(final String s, final String s2, final String s3, final OHLCDataset ohlcDataset, final Timeline timeline, final boolean b) {
        final DateAxis dateAxis = new DateAxis(s2);
        dateAxis.setTimeline(timeline);
        final NumberAxis numberAxis = new NumberAxis(s3);
        final HighLowRenderer highLowRenderer = new HighLowRenderer();
        highLowRenderer.setBaseToolTipGenerator(new HighLowItemLabelGenerator());
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, new XYPlot(ohlcDataset, dateAxis, numberAxis, highLowRenderer), b);
    }
    
    public static JFreeChart createBubbleChart(final String s, final String s2, final String s3, final XYZDataset xyzDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final NumberAxis numberAxis = new NumberAxis(s2);
        numberAxis.setAutoRangeIncludesZero(false);
        final NumberAxis numberAxis2 = new NumberAxis(s3);
        numberAxis2.setAutoRangeIncludesZero(false);
        final XYPlot xyPlot = new XYPlot(xyzDataset, numberAxis, numberAxis2, null);
        final XYBubbleRenderer renderer = new XYBubbleRenderer(2);
        if (b2) {
            renderer.setBaseToolTipGenerator(new StandardXYZToolTipGenerator());
        }
        if (b3) {
            renderer.setURLGenerator(new StandardXYZURLGenerator());
        }
        xyPlot.setRenderer(renderer);
        xyPlot.setOrientation(orientation);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, xyPlot, b);
    }
    
    public static JFreeChart createHistogram(final String s, final String s2, final String s3, final IntervalXYDataset intervalXYDataset, final PlotOrientation orientation, final boolean b, final boolean b2, final boolean b3) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final NumberAxis numberAxis = new NumberAxis(s2);
        numberAxis.setAutoRangeIncludesZero(false);
        final NumberAxis numberAxis2 = new NumberAxis(s3);
        final XYBarRenderer xyBarRenderer = new XYBarRenderer();
        if (b2) {
            xyBarRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        }
        if (b3) {
            xyBarRenderer.setURLGenerator(new StandardXYURLGenerator());
        }
        final XYPlot xyPlot = new XYPlot(intervalXYDataset, numberAxis, numberAxis2, xyBarRenderer);
        xyPlot.setOrientation(orientation);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, xyPlot, b);
    }
    
    public static JFreeChart createBoxAndWhiskerChart(final String s, final String s2, final String s3, final BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset, final boolean b) {
        final CategoryAxis categoryAxis = new CategoryAxis(s2);
        final NumberAxis numberAxis = new NumberAxis(s3);
        numberAxis.setAutoRangeIncludesZero(false);
        final BoxAndWhiskerRenderer boxAndWhiskerRenderer = new BoxAndWhiskerRenderer();
        boxAndWhiskerRenderer.setToolTipGenerator(new BoxAndWhiskerToolTipGenerator());
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, new CategoryPlot(boxAndWhiskerCategoryDataset, categoryAxis, numberAxis, boxAndWhiskerRenderer), b);
    }
    
    public static JFreeChart createBoxAndWhiskerChart(final String s, final String s2, final String s3, final BoxAndWhiskerXYDataset boxAndWhiskerXYDataset, final boolean b) {
        final DateAxis dateAxis = new DateAxis(s2);
        final NumberAxis numberAxis = new NumberAxis(s3);
        numberAxis.setAutoRangeIncludesZero(false);
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, new XYPlot(boxAndWhiskerXYDataset, dateAxis, numberAxis, new XYBoxAndWhiskerRenderer(10.0)), b);
    }
    
    public static JFreeChart createWindPlot(final String s, final String s2, final String s3, final WindDataset windDataset, final boolean b, final boolean b2, final boolean b3) {
        final DateAxis dateAxis = new DateAxis(s2);
        final NumberAxis numberAxis = new NumberAxis(s3);
        numberAxis.setRange(-12.0, 12.0);
        final WindItemRenderer windItemRenderer = new WindItemRenderer();
        if (b2) {
            windItemRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        }
        if (b3) {
            windItemRenderer.setURLGenerator(new StandardXYURLGenerator());
        }
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, new XYPlot(windDataset, dateAxis, numberAxis, windItemRenderer), b);
    }
    
    public static JFreeChart createWaferMapChart(final String s, final WaferMapDataset waferMapDataset, final PlotOrientation plotOrientation, final boolean b, final boolean b2, final boolean b3) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        final WaferMapPlot waferMapPlot = new WaferMapPlot(waferMapDataset);
        waferMapPlot.setRenderer(new WaferMapRenderer());
        return new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, waferMapPlot, b);
    }
}
