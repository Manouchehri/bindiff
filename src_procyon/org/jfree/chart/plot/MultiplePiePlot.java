package org.jfree.chart.plot;

import org.jfree.chart.title.*;
import org.jfree.ui.*;
import org.jfree.chart.event.*;
import java.awt.geom.*;
import org.jfree.data.general.*;
import java.awt.*;
import org.jfree.data.category.*;
import org.jfree.chart.*;
import java.util.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class MultiplePiePlot extends Plot implements Serializable, Cloneable
{
    private static final long serialVersionUID = -355377800470807389L;
    private JFreeChart pieChart;
    private CategoryDataset dataset;
    private TableOrder dataExtractOrder;
    private double limit;
    private Comparable aggregatedItemsKey;
    private transient Paint aggregatedItemsPaint;
    private transient Map sectionPaints;
    
    public MultiplePiePlot() {
        this(null);
    }
    
    public MultiplePiePlot(final CategoryDataset dataset) {
        this.limit = 0.0;
        this.dataset = dataset;
        (this.pieChart = new JFreeChart(new PiePlot(null))).removeLegend();
        this.dataExtractOrder = TableOrder.BY_COLUMN;
        this.pieChart.setBackgroundPaint(null);
        final TextTitle title = new TextTitle("Series Title", new Font("SansSerif", 1, 12));
        title.setPosition(RectangleEdge.BOTTOM);
        this.pieChart.setTitle(title);
        this.aggregatedItemsKey = "Other";
        this.aggregatedItemsPaint = Color.lightGray;
        this.sectionPaints = new HashMap();
    }
    
    public CategoryDataset getDataset() {
        return this.dataset;
    }
    
    public void setDataset(final CategoryDataset dataset) {
        if (this.dataset != null) {
            this.dataset.removeChangeListener(this);
        }
        if ((this.dataset = dataset) != null) {
            this.setDatasetGroup(dataset.getGroup());
            dataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, dataset));
    }
    
    public JFreeChart getPieChart() {
        return this.pieChart;
    }
    
    public void setPieChart(final JFreeChart pieChart) {
        this.pieChart = pieChart;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public TableOrder getDataExtractOrder() {
        return this.dataExtractOrder;
    }
    
    public void setDataExtractOrder(final TableOrder dataExtractOrder) {
        if (dataExtractOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument");
        }
        this.dataExtractOrder = dataExtractOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getLimit() {
        return this.limit;
    }
    
    public void setLimit(final double limit) {
        this.limit = limit;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Comparable getAggregatedItemsKey() {
        return this.aggregatedItemsKey;
    }
    
    public void setAggregatedItemsKey(final Comparable aggregatedItemsKey) {
        if (aggregatedItemsKey == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        this.aggregatedItemsKey = aggregatedItemsKey;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getAggregatedItemsPaint() {
        return this.aggregatedItemsPaint;
    }
    
    public void setAggregatedItemsPaint(final Paint aggregatedItemsPaint) {
        if (aggregatedItemsPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.aggregatedItemsPaint = aggregatedItemsPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public String getPlotType() {
        return "Multiple Pie Plot";
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        this.getInsets().trim(rectangle2D);
        this.drawBackground(graphics2D, rectangle2D);
        this.drawOutline(graphics2D, rectangle2D);
        if (DatasetUtilities.isEmptyOrNull(this.dataset)) {
            this.drawNoDataMessage(graphics2D, rectangle2D);
            return;
        }
        int n;
        if (this.dataExtractOrder == TableOrder.BY_ROW) {
            n = this.dataset.getRowCount();
        }
        else {
            n = this.dataset.getColumnCount();
        }
        int n2 = (int)Math.ceil(Math.sqrt(n));
        int n3 = (int)Math.ceil(n / n2);
        if (n2 > n3 && rectangle2D.getWidth() < rectangle2D.getHeight()) {
            final int n4 = n2;
            n2 = n3;
            n3 = n4;
        }
        this.prefetchSectionPaints();
        final int n5 = (int)rectangle2D.getX();
        final int n6 = (int)rectangle2D.getY();
        final int n7 = (int)rectangle2D.getWidth() / n2;
        final int n8 = (int)rectangle2D.getHeight() / n3;
        int n9 = 0;
        int n10 = 0;
        final int n11 = n3 * n2 - n;
        int n12 = 0;
        final Rectangle rectangle = new Rectangle();
        for (int i = 0; i < n; ++i) {
            rectangle.setBounds(n5 + n12 + n7 * n10, n6 + n8 * n9, n7, n8);
            String title;
            if (this.dataExtractOrder == TableOrder.BY_ROW) {
                title = this.dataset.getRowKey(i).toString();
            }
            else {
                title = this.dataset.getColumnKey(i).toString();
            }
            this.pieChart.setTitle(title);
            final CategoryToPieDataset categoryToPieDataset = new CategoryToPieDataset(this.dataset, this.dataExtractOrder, i);
            PieDataset consolidatedPieDataset;
            if (this.limit > 0.0) {
                consolidatedPieDataset = DatasetUtilities.createConsolidatedPieDataset(categoryToPieDataset, this.aggregatedItemsKey, this.limit);
            }
            else {
                consolidatedPieDataset = categoryToPieDataset;
            }
            final PiePlot piePlot = (PiePlot)this.pieChart.getPlot();
            piePlot.setDataset(consolidatedPieDataset);
            piePlot.setPieIndex(i);
            for (int j = 0; j < consolidatedPieDataset.getItemCount(); ++j) {
                final Comparable key = consolidatedPieDataset.getKey(j);
                Paint aggregatedItemsPaint;
                if (key.equals(this.aggregatedItemsKey)) {
                    aggregatedItemsPaint = this.aggregatedItemsPaint;
                }
                else {
                    aggregatedItemsPaint = this.sectionPaints.get(key);
                }
                piePlot.setSectionPaint(key, aggregatedItemsPaint);
            }
            ChartRenderingInfo chartRenderingInfo = null;
            if (plotRenderingInfo != null) {
                chartRenderingInfo = new ChartRenderingInfo();
            }
            this.pieChart.draw(graphics2D, rectangle, chartRenderingInfo);
            if (plotRenderingInfo != null) {
                plotRenderingInfo.getOwner().getEntityCollection().addAll(chartRenderingInfo.getEntityCollection());
                plotRenderingInfo.addSubplotInfo(chartRenderingInfo.getPlotInfo());
            }
            if (++n10 == n2) {
                n10 = 0;
                if (++n9 == n3 - 1 && n11 != 0) {
                    n12 = n11 * n7 / 2;
                }
            }
        }
    }
    
    private void prefetchSectionPaints() {
        final PiePlot piePlot = (PiePlot)this.getPieChart().getPlot();
        if (this.dataExtractOrder == TableOrder.BY_ROW) {
            for (int i = 0; i < this.dataset.getColumnCount(); ++i) {
                final Comparable columnKey = this.dataset.getColumnKey(i);
                Paint paint = piePlot.getSectionPaint(columnKey);
                if (paint == null) {
                    paint = this.sectionPaints.get(columnKey);
                    if (paint == null) {
                        paint = this.getDrawingSupplier().getNextPaint();
                    }
                }
                this.sectionPaints.put(columnKey, paint);
            }
        }
        else {
            for (int j = 0; j < this.dataset.getRowCount(); ++j) {
                final Comparable rowKey = this.dataset.getRowKey(j);
                Paint paint2 = piePlot.getSectionPaint(rowKey);
                if (paint2 == null) {
                    paint2 = this.sectionPaints.get(rowKey);
                    if (paint2 == null) {
                        paint2 = this.getDrawingSupplier().getNextPaint();
                    }
                }
                this.sectionPaints.put(rowKey, paint2);
            }
        }
    }
    
    public LegendItemCollection getLegendItems() {
        final LegendItemCollection collection = new LegendItemCollection();
        if (this.dataset != null) {
            List<Comparable> list = null;
            this.prefetchSectionPaints();
            if (this.dataExtractOrder == TableOrder.BY_ROW) {
                list = (List<Comparable>)this.dataset.getColumnKeys();
            }
            else if (this.dataExtractOrder == TableOrder.BY_COLUMN) {
                list = (List<Comparable>)this.dataset.getRowKeys();
            }
            if (list != null) {
                int n = 0;
                for (final Comparable comparable : list) {
                    final String string = comparable.toString();
                    final Paint paint = this.sectionPaints.get(comparable);
                    collection.add(new LegendItem(string, string, null, null, Plot.DEFAULT_LEGEND_ITEM_CIRCLE, paint, Plot.DEFAULT_OUTLINE_STROKE, paint));
                    ++n;
                }
            }
            if (this.limit > 0.0) {
                collection.add(new LegendItem(this.aggregatedItemsKey.toString(), this.aggregatedItemsKey.toString(), null, null, Plot.DEFAULT_LEGEND_ITEM_CIRCLE, this.aggregatedItemsPaint, Plot.DEFAULT_OUTLINE_STROKE, this.aggregatedItemsPaint));
            }
        }
        return collection;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MultiplePiePlot)) {
            return false;
        }
        final MultiplePiePlot multiplePiePlot = (MultiplePiePlot)o;
        return this.dataExtractOrder == multiplePiePlot.dataExtractOrder && this.limit == multiplePiePlot.limit && this.aggregatedItemsKey.equals(multiplePiePlot.aggregatedItemsKey) && PaintUtilities.equal(this.aggregatedItemsPaint, multiplePiePlot.aggregatedItemsPaint) && ObjectUtilities.equal(this.pieChart, multiplePiePlot.pieChart) && super.equals(o);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.aggregatedItemsPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.aggregatedItemsPaint = SerialUtilities.readPaint(objectInputStream);
        this.sectionPaints = new HashMap();
    }
}
