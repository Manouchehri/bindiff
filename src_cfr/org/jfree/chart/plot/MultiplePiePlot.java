/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.Values;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.CategoryToPieDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.PieDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.TableOrder;

public class MultiplePiePlot
extends Plot
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -355377800470807389L;
    private JFreeChart pieChart;
    private CategoryDataset dataset;
    private TableOrder dataExtractOrder;
    private double limit = 0.0;
    private Comparable aggregatedItemsKey;
    private transient Paint aggregatedItemsPaint;
    private transient Map sectionPaints;

    public MultiplePiePlot() {
        this(null);
    }

    public MultiplePiePlot(CategoryDataset categoryDataset) {
        this.dataset = categoryDataset;
        PiePlot piePlot = new PiePlot(null);
        this.pieChart = new JFreeChart(piePlot);
        this.pieChart.removeLegend();
        this.dataExtractOrder = TableOrder.BY_COLUMN;
        this.pieChart.setBackgroundPaint(null);
        TextTitle textTitle = new TextTitle("Series Title", new Font("SansSerif", 1, 12));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        this.pieChart.setTitle(textTitle);
        this.aggregatedItemsKey = "Other";
        this.aggregatedItemsPaint = Color.lightGray;
        this.sectionPaints = new HashMap();
    }

    public CategoryDataset getDataset() {
        return this.dataset;
    }

    public void setDataset(CategoryDataset categoryDataset) {
        if (this.dataset != null) {
            this.dataset.removeChangeListener(this);
        }
        this.dataset = categoryDataset;
        if (categoryDataset != null) {
            this.setDatasetGroup(categoryDataset.getGroup());
            categoryDataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, categoryDataset));
    }

    public JFreeChart getPieChart() {
        return this.pieChart;
    }

    public void setPieChart(JFreeChart jFreeChart) {
        this.pieChart = jFreeChart;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public TableOrder getDataExtractOrder() {
        return this.dataExtractOrder;
    }

    public void setDataExtractOrder(TableOrder tableOrder) {
        if (tableOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument");
        }
        this.dataExtractOrder = tableOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getLimit() {
        return this.limit;
    }

    public void setLimit(double d2) {
        this.limit = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Comparable getAggregatedItemsKey() {
        return this.aggregatedItemsKey;
    }

    public void setAggregatedItemsKey(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        this.aggregatedItemsKey = comparable;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getAggregatedItemsPaint() {
        return this.aggregatedItemsPaint;
    }

    public void setAggregatedItemsPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.aggregatedItemsPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public String getPlotType() {
        return "Multiple Pie Plot";
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        int n2;
        int n3;
        RectangleInsets rectangleInsets = this.getInsets();
        rectangleInsets.trim(rectangle2D);
        this.drawBackground(graphics2D, rectangle2D);
        this.drawOutline(graphics2D, rectangle2D);
        if (DatasetUtilities.isEmptyOrNull(this.dataset)) {
            this.drawNoDataMessage(graphics2D, rectangle2D);
            return;
        }
        int n4 = 0;
        n4 = this.dataExtractOrder == TableOrder.BY_ROW ? this.dataset.getRowCount() : this.dataset.getColumnCount();
        int n5 = (int)Math.ceil(Math.sqrt(n4));
        if (n5 > (n3 = (int)Math.ceil((double)n4 / (double)n5)) && rectangle2D.getWidth() < rectangle2D.getHeight()) {
            n2 = n5;
            n5 = n3;
            n3 = n2;
        }
        this.prefetchSectionPaints();
        n2 = (int)rectangle2D.getX();
        int n6 = (int)rectangle2D.getY();
        int n7 = (int)rectangle2D.getWidth() / n5;
        int n8 = (int)rectangle2D.getHeight() / n3;
        int n9 = 0;
        int n10 = 0;
        int n11 = n3 * n5 - n4;
        int n12 = 0;
        Rectangle rectangle = new Rectangle();
        int n13 = 0;
        while (n13 < n4) {
            rectangle.setBounds(n2 + n12 + n7 * n10, n6 + n8 * n9, n7, n8);
            String string = null;
            string = this.dataExtractOrder == TableOrder.BY_ROW ? this.dataset.getRowKey(n13).toString() : this.dataset.getColumnKey(n13).toString();
            this.pieChart.setTitle(string);
            Values values = null;
            PieDataset pieDataset = new CategoryToPieDataset(this.dataset, this.dataExtractOrder, n13);
            values = this.limit > 0.0 ? DatasetUtilities.createConsolidatedPieDataset(pieDataset, this.aggregatedItemsKey, this.limit) : pieDataset;
            PiePlot piePlot = (PiePlot)this.pieChart.getPlot();
            piePlot.setDataset((PieDataset)values);
            piePlot.setPieIndex(n13);
            for (int i2 = 0; i2 < values.getItemCount(); ++i2) {
                Comparable comparable = values.getKey(i2);
                Paint paint = comparable.equals(this.aggregatedItemsKey) ? this.aggregatedItemsPaint : (Paint)this.sectionPaints.get(comparable);
                piePlot.setSectionPaint(comparable, paint);
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
            if (++n10 == n5) {
                n10 = 0;
                if (++n9 == n3 - 1 && n11 != 0) {
                    n12 = n11 * n7 / 2;
                }
            }
            ++n13;
        }
    }

    private void prefetchSectionPaints() {
        PiePlot piePlot = (PiePlot)this.getPieChart().getPlot();
        if (this.dataExtractOrder == TableOrder.BY_ROW) {
            int n2 = 0;
            while (n2 < this.dataset.getColumnCount()) {
                Comparable comparable = this.dataset.getColumnKey(n2);
                Paint paint = piePlot.getSectionPaint(comparable);
                if (paint == null && (paint = (Paint)this.sectionPaints.get(comparable)) == null) {
                    paint = this.getDrawingSupplier().getNextPaint();
                }
                this.sectionPaints.put(comparable, paint);
                ++n2;
            }
            return;
        }
        int n3 = 0;
        while (n3 < this.dataset.getRowCount()) {
            Comparable comparable = this.dataset.getRowKey(n3);
            Paint paint = piePlot.getSectionPaint(comparable);
            if (paint == null && (paint = (Paint)this.sectionPaints.get(comparable)) == null) {
                paint = this.getDrawingSupplier().getNextPaint();
            }
            this.sectionPaints.put(comparable, paint);
            ++n3;
        }
    }

    @Override
    public LegendItemCollection getLegendItems() {
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        if (this.dataset == null) return legendItemCollection;
        List list = null;
        this.prefetchSectionPaints();
        if (this.dataExtractOrder == TableOrder.BY_ROW) {
            list = this.dataset.getColumnKeys();
        } else if (this.dataExtractOrder == TableOrder.BY_COLUMN) {
            list = this.dataset.getRowKeys();
        }
        if (list != null) {
            int n2 = 0;
            for (Comparable comparable : list) {
                String string;
                String string2 = string = comparable.toString();
                Paint paint = (Paint)this.sectionPaints.get(comparable);
                LegendItem legendItem = new LegendItem(string, string2, null, null, Plot.DEFAULT_LEGEND_ITEM_CIRCLE, paint, Plot.DEFAULT_OUTLINE_STROKE, paint);
                legendItemCollection.add(legendItem);
                ++n2;
            }
        }
        if (this.limit <= 0.0) return legendItemCollection;
        legendItemCollection.add(new LegendItem(this.aggregatedItemsKey.toString(), this.aggregatedItemsKey.toString(), null, null, Plot.DEFAULT_LEGEND_ITEM_CIRCLE, this.aggregatedItemsPaint, Plot.DEFAULT_OUTLINE_STROKE, this.aggregatedItemsPaint));
        return legendItemCollection;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MultiplePiePlot)) {
            return false;
        }
        MultiplePiePlot multiplePiePlot = (MultiplePiePlot)object;
        if (this.dataExtractOrder != multiplePiePlot.dataExtractOrder) {
            return false;
        }
        if (this.limit != multiplePiePlot.limit) {
            return false;
        }
        if (!this.aggregatedItemsKey.equals(multiplePiePlot.aggregatedItemsKey)) {
            return false;
        }
        if (!PaintUtilities.equal(this.aggregatedItemsPaint, multiplePiePlot.aggregatedItemsPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.pieChart, multiplePiePlot.pieChart)) {
            return false;
        }
        if (super.equals(object)) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.aggregatedItemsPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.aggregatedItemsPaint = SerialUtilities.readPaint(objectInputStream);
        this.sectionPaints = new HashMap();
    }
}

