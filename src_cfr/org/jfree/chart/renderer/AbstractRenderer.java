/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
import javax.swing.event.EventListenerList;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.BooleanList;
import org.jfree.util.BooleanUtilities;
import org.jfree.util.ObjectList;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintList;
import org.jfree.util.PaintUtilities;
import org.jfree.util.ShapeList;
import org.jfree.util.ShapeUtilities;
import org.jfree.util.StrokeList;

public abstract class AbstractRenderer
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -828267569428206075L;
    public static final Double ZERO = new Double(0.0);
    public static final Paint DEFAULT_PAINT = Color.blue;
    public static final Paint DEFAULT_OUTLINE_PAINT = Color.gray;
    public static final Stroke DEFAULT_STROKE = new BasicStroke(1.0f);
    public static final Stroke DEFAULT_OUTLINE_STROKE = new BasicStroke(1.0f);
    public static final Shape DEFAULT_SHAPE = new Rectangle2D.Double(-3.0, -3.0, 6.0, 6.0);
    public static final Font DEFAULT_VALUE_LABEL_FONT = new Font("SansSerif", 0, 10);
    public static final Paint DEFAULT_VALUE_LABEL_PAINT = Color.black;
    private Boolean seriesVisible = null;
    private BooleanList seriesVisibleList = new BooleanList();
    private boolean baseSeriesVisible = true;
    private Boolean seriesVisibleInLegend = null;
    private BooleanList seriesVisibleInLegendList = new BooleanList();
    private boolean baseSeriesVisibleInLegend = true;
    private transient Paint paint = null;
    private PaintList paintList = new PaintList();
    private transient Paint basePaint = DEFAULT_PAINT;
    private transient Paint fillPaint = null;
    private PaintList fillPaintList = new PaintList();
    private transient Paint baseFillPaint = Color.white;
    private transient Paint outlinePaint = null;
    private PaintList outlinePaintList = new PaintList();
    private transient Paint baseOutlinePaint = DEFAULT_OUTLINE_PAINT;
    private transient Stroke stroke = null;
    private StrokeList strokeList = new StrokeList();
    private transient Stroke baseStroke = DEFAULT_STROKE;
    private transient Stroke outlineStroke = null;
    private StrokeList outlineStrokeList = new StrokeList();
    private transient Stroke baseOutlineStroke = DEFAULT_OUTLINE_STROKE;
    private transient Shape shape = null;
    private ShapeList shapeList = new ShapeList();
    private transient Shape baseShape = DEFAULT_SHAPE;
    private Boolean itemLabelsVisible = null;
    private BooleanList itemLabelsVisibleList = new BooleanList();
    private Boolean baseItemLabelsVisible = Boolean.FALSE;
    private Font itemLabelFont = null;
    private ObjectList itemLabelFontList = new ObjectList();
    private Font baseItemLabelFont = new Font("SansSerif", 0, 10);
    private transient Paint itemLabelPaint = null;
    private PaintList itemLabelPaintList = new PaintList();
    private transient Paint baseItemLabelPaint = Color.black;
    private ItemLabelPosition positiveItemLabelPosition = null;
    private ObjectList positiveItemLabelPositionList = new ObjectList();
    private ItemLabelPosition basePositiveItemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER);
    private ItemLabelPosition negativeItemLabelPosition = null;
    private ObjectList negativeItemLabelPositionList = new ObjectList();
    private ItemLabelPosition baseNegativeItemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER);
    private double itemLabelAnchorOffset = 2.0;
    private Boolean createEntities = null;
    private BooleanList createEntitiesList = new BooleanList();
    private boolean baseCreateEntities = true;
    private transient EventListenerList listenerList = new EventListenerList();
    private transient RendererChangeEvent event;
    private static final double ADJ = Math.cos(0.5235987755982988);
    private static final double OPP = Math.sin(0.5235987755982988);
    static Class class$org$jfree$chart$event$RendererChangeListener;

    public abstract DrawingSupplier getDrawingSupplier();

    public boolean getItemVisible(int n2, int n3) {
        return this.isSeriesVisible(n2);
    }

    public boolean isSeriesVisible(int n2) {
        boolean bl2 = this.baseSeriesVisible;
        if (this.seriesVisible != null) {
            return this.seriesVisible;
        }
        Boolean bl3 = this.seriesVisibleList.getBoolean(n2);
        if (bl3 == null) return bl2;
        return bl3;
    }

    public Boolean getSeriesVisible() {
        return this.seriesVisible;
    }

    public void setSeriesVisible(Boolean bl2) {
        this.setSeriesVisible(bl2, true);
    }

    public void setSeriesVisible(Boolean bl2, boolean bl3) {
        this.seriesVisible = bl2;
        if (!bl3) return;
        this.fireChangeEvent();
    }

    public Boolean getSeriesVisible(int n2) {
        return this.seriesVisibleList.getBoolean(n2);
    }

    public void setSeriesVisible(int n2, Boolean bl2) {
        this.setSeriesVisible(n2, bl2, true);
    }

    public void setSeriesVisible(int n2, Boolean bl2, boolean bl3) {
        this.seriesVisibleList.setBoolean(n2, bl2);
        if (!bl3) return;
        this.fireChangeEvent();
    }

    public boolean getBaseSeriesVisible() {
        return this.baseSeriesVisible;
    }

    public void setBaseSeriesVisible(boolean bl2) {
        this.setBaseSeriesVisible(bl2, true);
    }

    public void setBaseSeriesVisible(boolean bl2, boolean bl3) {
        this.baseSeriesVisible = bl2;
        if (!bl3) return;
        this.fireChangeEvent();
    }

    public boolean isSeriesVisibleInLegend(int n2) {
        boolean bl2 = this.baseSeriesVisibleInLegend;
        if (this.seriesVisibleInLegend != null) {
            return this.seriesVisibleInLegend;
        }
        Boolean bl3 = this.seriesVisibleInLegendList.getBoolean(n2);
        if (bl3 == null) return bl2;
        return bl3;
    }

    public Boolean getSeriesVisibleInLegend() {
        return this.seriesVisibleInLegend;
    }

    public void setSeriesVisibleInLegend(Boolean bl2) {
        this.setSeriesVisibleInLegend(bl2, true);
    }

    public void setSeriesVisibleInLegend(Boolean bl2, boolean bl3) {
        this.seriesVisibleInLegend = bl2;
        if (!bl3) return;
        this.fireChangeEvent();
    }

    public Boolean getSeriesVisibleInLegend(int n2) {
        return this.seriesVisibleInLegendList.getBoolean(n2);
    }

    public void setSeriesVisibleInLegend(int n2, Boolean bl2) {
        this.setSeriesVisibleInLegend(n2, bl2, true);
    }

    public void setSeriesVisibleInLegend(int n2, Boolean bl2, boolean bl3) {
        this.seriesVisibleInLegendList.setBoolean(n2, bl2);
        if (!bl3) return;
        this.fireChangeEvent();
    }

    public boolean getBaseSeriesVisibleInLegend() {
        return this.baseSeriesVisibleInLegend;
    }

    public void setBaseSeriesVisibleInLegend(boolean bl2) {
        this.setBaseSeriesVisibleInLegend(bl2, true);
    }

    public void setBaseSeriesVisibleInLegend(boolean bl2, boolean bl3) {
        this.baseSeriesVisibleInLegend = bl2;
        if (!bl3) return;
        this.fireChangeEvent();
    }

    public Paint getItemPaint(int n2, int n3) {
        return this.getSeriesPaint(n2);
    }

    public Paint getSeriesPaint(int n2) {
        if (this.paint != null) {
            return this.paint;
        }
        Paint paint = this.paintList.getPaint(n2);
        if (paint != null) return paint;
        DrawingSupplier drawingSupplier = this.getDrawingSupplier();
        if (drawingSupplier == null) return this.basePaint;
        paint = drawingSupplier.getNextPaint();
        this.paintList.setPaint(n2, paint);
        return paint;
    }

    public void setPaint(Paint paint) {
        this.setPaint(paint, true);
    }

    public void setPaint(Paint paint, boolean bl2) {
        this.paint = paint;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public void setSeriesPaint(int n2, Paint paint) {
        this.setSeriesPaint(n2, paint, true);
    }

    public void setSeriesPaint(int n2, Paint paint, boolean bl2) {
        this.paintList.setPaint(n2, paint);
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Paint getBasePaint() {
        return this.basePaint;
    }

    public void setBasePaint(Paint paint) {
        this.setBasePaint(paint, true);
    }

    public void setBasePaint(Paint paint, boolean bl2) {
        this.basePaint = paint;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Paint getItemFillPaint(int n2, int n3) {
        return this.getSeriesFillPaint(n2);
    }

    public Paint getSeriesFillPaint(int n2) {
        if (this.fillPaint != null) {
            return this.fillPaint;
        }
        Paint paint = this.fillPaintList.getPaint(n2);
        if (paint != null) return paint;
        return this.baseFillPaint;
    }

    public void setSeriesFillPaint(int n2, Paint paint) {
        this.setSeriesFillPaint(n2, paint, true);
    }

    public void setSeriesFillPaint(int n2, Paint paint, boolean bl2) {
        this.fillPaintList.setPaint(n2, paint);
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public void setFillPaint(Paint paint) {
        this.setFillPaint(paint, true);
    }

    public void setFillPaint(Paint paint, boolean bl2) {
        this.fillPaint = paint;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Paint getBaseFillPaint() {
        return this.baseFillPaint;
    }

    public void setBaseFillPaint(Paint paint) {
        this.setBaseFillPaint(paint, true);
    }

    public void setBaseFillPaint(Paint paint, boolean bl2) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseFillPaint = paint;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Paint getItemOutlinePaint(int n2, int n3) {
        return this.getSeriesOutlinePaint(n2);
    }

    public Paint getSeriesOutlinePaint(int n2) {
        if (this.outlinePaint != null) {
            return this.outlinePaint;
        }
        Paint paint = this.outlinePaintList.getPaint(n2);
        if (paint != null) return paint;
        DrawingSupplier drawingSupplier = this.getDrawingSupplier();
        if (drawingSupplier == null) return this.baseOutlinePaint;
        paint = drawingSupplier.getNextOutlinePaint();
        this.outlinePaintList.setPaint(n2, paint);
        return paint;
    }

    public void setSeriesOutlinePaint(int n2, Paint paint) {
        this.setSeriesOutlinePaint(n2, paint, true);
    }

    public void setSeriesOutlinePaint(int n2, Paint paint, boolean bl2) {
        this.outlinePaintList.setPaint(n2, paint);
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public void setOutlinePaint(Paint paint) {
        this.setOutlinePaint(paint, true);
    }

    public void setOutlinePaint(Paint paint, boolean bl2) {
        this.outlinePaint = paint;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Paint getBaseOutlinePaint() {
        return this.baseOutlinePaint;
    }

    public void setBaseOutlinePaint(Paint paint) {
        this.setBaseOutlinePaint(paint, true);
    }

    public void setBaseOutlinePaint(Paint paint, boolean bl2) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseOutlinePaint = paint;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Stroke getItemStroke(int n2, int n3) {
        return this.getSeriesStroke(n2);
    }

    public Stroke getSeriesStroke(int n2) {
        if (this.stroke != null) {
            return this.stroke;
        }
        Stroke stroke = this.strokeList.getStroke(n2);
        if (stroke != null) return stroke;
        DrawingSupplier drawingSupplier = this.getDrawingSupplier();
        if (drawingSupplier == null) return this.baseStroke;
        stroke = drawingSupplier.getNextStroke();
        this.strokeList.setStroke(n2, stroke);
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.setStroke(stroke, true);
    }

    public void setStroke(Stroke stroke, boolean bl2) {
        this.stroke = stroke;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public void setSeriesStroke(int n2, Stroke stroke) {
        this.setSeriesStroke(n2, stroke, true);
    }

    public void setSeriesStroke(int n2, Stroke stroke, boolean bl2) {
        this.strokeList.setStroke(n2, stroke);
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Stroke getBaseStroke() {
        return this.baseStroke;
    }

    public void setBaseStroke(Stroke stroke) {
        this.setBaseStroke(stroke, true);
    }

    public void setBaseStroke(Stroke stroke, boolean bl2) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.baseStroke = stroke;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Stroke getItemOutlineStroke(int n2, int n3) {
        return this.getSeriesOutlineStroke(n2);
    }

    public Stroke getSeriesOutlineStroke(int n2) {
        if (this.outlineStroke != null) {
            return this.outlineStroke;
        }
        Stroke stroke = this.outlineStrokeList.getStroke(n2);
        if (stroke != null) return stroke;
        DrawingSupplier drawingSupplier = this.getDrawingSupplier();
        if (drawingSupplier == null) return this.baseOutlineStroke;
        stroke = drawingSupplier.getNextOutlineStroke();
        this.outlineStrokeList.setStroke(n2, stroke);
        return stroke;
    }

    public void setOutlineStroke(Stroke stroke) {
        this.setOutlineStroke(stroke, true);
    }

    public void setOutlineStroke(Stroke stroke, boolean bl2) {
        this.outlineStroke = stroke;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public void setSeriesOutlineStroke(int n2, Stroke stroke) {
        this.setSeriesOutlineStroke(n2, stroke, true);
    }

    public void setSeriesOutlineStroke(int n2, Stroke stroke, boolean bl2) {
        this.outlineStrokeList.setStroke(n2, stroke);
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Stroke getBaseOutlineStroke() {
        return this.baseOutlineStroke;
    }

    public void setBaseOutlineStroke(Stroke stroke) {
        this.setBaseOutlineStroke(stroke, true);
    }

    public void setBaseOutlineStroke(Stroke stroke, boolean bl2) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.baseOutlineStroke = stroke;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Shape getItemShape(int n2, int n3) {
        return this.getSeriesShape(n2);
    }

    public Shape getSeriesShape(int n2) {
        if (this.shape != null) {
            return this.shape;
        }
        Shape shape = this.shapeList.getShape(n2);
        if (shape != null) return shape;
        DrawingSupplier drawingSupplier = this.getDrawingSupplier();
        if (drawingSupplier == null) return this.baseShape;
        shape = drawingSupplier.getNextShape();
        this.shapeList.setShape(n2, shape);
        return shape;
    }

    public void setShape(Shape shape) {
        this.setShape(shape, true);
    }

    public void setShape(Shape shape, boolean bl2) {
        this.shape = shape;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public void setSeriesShape(int n2, Shape shape) {
        this.setSeriesShape(n2, shape, true);
    }

    public void setSeriesShape(int n2, Shape shape, boolean bl2) {
        this.shapeList.setShape(n2, shape);
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Shape getBaseShape() {
        return this.baseShape;
    }

    public void setBaseShape(Shape shape) {
        this.setBaseShape(shape, true);
    }

    public void setBaseShape(Shape shape, boolean bl2) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        this.baseShape = shape;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public boolean isItemLabelVisible(int n2, int n3) {
        return this.isSeriesItemLabelsVisible(n2);
    }

    public boolean isSeriesItemLabelsVisible(int n2) {
        if (this.itemLabelsVisible != null) {
            return this.itemLabelsVisible;
        }
        Boolean bl2 = this.itemLabelsVisibleList.getBoolean(n2);
        if (bl2 == null) {
            bl2 = this.baseItemLabelsVisible;
        }
        if (bl2 != null) return bl2;
        bl2 = Boolean.FALSE;
        return bl2;
    }

    public void setItemLabelsVisible(boolean bl2) {
        this.setItemLabelsVisible(BooleanUtilities.valueOf(bl2));
    }

    public void setItemLabelsVisible(Boolean bl2) {
        this.setItemLabelsVisible(bl2, true);
    }

    public void setItemLabelsVisible(Boolean bl2, boolean bl3) {
        this.itemLabelsVisible = bl2;
        if (!bl3) return;
        this.fireChangeEvent();
    }

    public void setSeriesItemLabelsVisible(int n2, boolean bl2) {
        this.setSeriesItemLabelsVisible(n2, BooleanUtilities.valueOf(bl2));
    }

    public void setSeriesItemLabelsVisible(int n2, Boolean bl2) {
        this.setSeriesItemLabelsVisible(n2, bl2, true);
    }

    public void setSeriesItemLabelsVisible(int n2, Boolean bl2, boolean bl3) {
        this.itemLabelsVisibleList.setBoolean(n2, bl2);
        if (!bl3) return;
        this.fireChangeEvent();
    }

    public Boolean getBaseItemLabelsVisible() {
        return this.baseItemLabelsVisible;
    }

    public void setBaseItemLabelsVisible(boolean bl2) {
        this.setBaseItemLabelsVisible(BooleanUtilities.valueOf(bl2));
    }

    public void setBaseItemLabelsVisible(Boolean bl2) {
        this.setBaseItemLabelsVisible(bl2, true);
    }

    public void setBaseItemLabelsVisible(Boolean bl2, boolean bl3) {
        this.baseItemLabelsVisible = bl2;
        if (!bl3) return;
        this.fireChangeEvent();
    }

    public Font getItemLabelFont(int n2, int n3) {
        Font font = this.itemLabelFont;
        if (font != null) return font;
        font = this.getSeriesItemLabelFont(n2);
        if (font != null) return font;
        return this.baseItemLabelFont;
    }

    public Font getItemLabelFont() {
        return this.itemLabelFont;
    }

    public void setItemLabelFont(Font font) {
        this.setItemLabelFont(font, true);
    }

    public void setItemLabelFont(Font font, boolean bl2) {
        this.itemLabelFont = font;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Font getSeriesItemLabelFont(int n2) {
        return (Font)this.itemLabelFontList.get(n2);
    }

    public void setSeriesItemLabelFont(int n2, Font font) {
        this.setSeriesItemLabelFont(n2, font, true);
    }

    public void setSeriesItemLabelFont(int n2, Font font, boolean bl2) {
        this.itemLabelFontList.set(n2, font);
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Font getBaseItemLabelFont() {
        return this.baseItemLabelFont;
    }

    public void setBaseItemLabelFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.setBaseItemLabelFont(font, true);
    }

    public void setBaseItemLabelFont(Font font, boolean bl2) {
        this.baseItemLabelFont = font;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Paint getItemLabelPaint(int n2, int n3) {
        Paint paint = this.itemLabelPaint;
        if (paint != null) return paint;
        paint = this.getSeriesItemLabelPaint(n2);
        if (paint != null) return paint;
        return this.baseItemLabelPaint;
    }

    public Paint getItemLabelPaint() {
        return this.itemLabelPaint;
    }

    public void setItemLabelPaint(Paint paint) {
        this.setItemLabelPaint(paint, true);
    }

    public void setItemLabelPaint(Paint paint, boolean bl2) {
        this.itemLabelPaint = paint;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Paint getSeriesItemLabelPaint(int n2) {
        return this.itemLabelPaintList.getPaint(n2);
    }

    public void setSeriesItemLabelPaint(int n2, Paint paint) {
        this.setSeriesItemLabelPaint(n2, paint, true);
    }

    public void setSeriesItemLabelPaint(int n2, Paint paint, boolean bl2) {
        this.itemLabelPaintList.setPaint(n2, paint);
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public Paint getBaseItemLabelPaint() {
        return this.baseItemLabelPaint;
    }

    public void setBaseItemLabelPaint(Paint paint) {
        this.setBaseItemLabelPaint(paint, true);
    }

    public void setBaseItemLabelPaint(Paint paint, boolean bl2) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseItemLabelPaint = paint;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public ItemLabelPosition getPositiveItemLabelPosition(int n2, int n3) {
        return this.getSeriesPositiveItemLabelPosition(n2);
    }

    public ItemLabelPosition getPositiveItemLabelPosition() {
        return this.positiveItemLabelPosition;
    }

    public void setPositiveItemLabelPosition(ItemLabelPosition itemLabelPosition) {
        this.setPositiveItemLabelPosition(itemLabelPosition, true);
    }

    public void setPositiveItemLabelPosition(ItemLabelPosition itemLabelPosition, boolean bl2) {
        this.positiveItemLabelPosition = itemLabelPosition;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public ItemLabelPosition getSeriesPositiveItemLabelPosition(int n2) {
        if (this.positiveItemLabelPosition != null) {
            return this.positiveItemLabelPosition;
        }
        ItemLabelPosition itemLabelPosition = (ItemLabelPosition)this.positiveItemLabelPositionList.get(n2);
        if (itemLabelPosition != null) return itemLabelPosition;
        return this.basePositiveItemLabelPosition;
    }

    public void setSeriesPositiveItemLabelPosition(int n2, ItemLabelPosition itemLabelPosition) {
        this.setSeriesPositiveItemLabelPosition(n2, itemLabelPosition, true);
    }

    public void setSeriesPositiveItemLabelPosition(int n2, ItemLabelPosition itemLabelPosition, boolean bl2) {
        this.positiveItemLabelPositionList.set(n2, itemLabelPosition);
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public ItemLabelPosition getBasePositiveItemLabelPosition() {
        return this.basePositiveItemLabelPosition;
    }

    public void setBasePositiveItemLabelPosition(ItemLabelPosition itemLabelPosition) {
        this.setBasePositiveItemLabelPosition(itemLabelPosition, true);
    }

    public void setBasePositiveItemLabelPosition(ItemLabelPosition itemLabelPosition, boolean bl2) {
        if (itemLabelPosition == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        this.basePositiveItemLabelPosition = itemLabelPosition;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public ItemLabelPosition getNegativeItemLabelPosition(int n2, int n3) {
        return this.getSeriesNegativeItemLabelPosition(n2);
    }

    public ItemLabelPosition getNegativeItemLabelPosition() {
        return this.negativeItemLabelPosition;
    }

    public void setNegativeItemLabelPosition(ItemLabelPosition itemLabelPosition) {
        this.setNegativeItemLabelPosition(itemLabelPosition, true);
    }

    public void setNegativeItemLabelPosition(ItemLabelPosition itemLabelPosition, boolean bl2) {
        this.negativeItemLabelPosition = itemLabelPosition;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public ItemLabelPosition getSeriesNegativeItemLabelPosition(int n2) {
        if (this.negativeItemLabelPosition != null) {
            return this.negativeItemLabelPosition;
        }
        ItemLabelPosition itemLabelPosition = (ItemLabelPosition)this.negativeItemLabelPositionList.get(n2);
        if (itemLabelPosition != null) return itemLabelPosition;
        return this.baseNegativeItemLabelPosition;
    }

    public void setSeriesNegativeItemLabelPosition(int n2, ItemLabelPosition itemLabelPosition) {
        this.setSeriesNegativeItemLabelPosition(n2, itemLabelPosition, true);
    }

    public void setSeriesNegativeItemLabelPosition(int n2, ItemLabelPosition itemLabelPosition, boolean bl2) {
        this.negativeItemLabelPositionList.set(n2, itemLabelPosition);
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public ItemLabelPosition getBaseNegativeItemLabelPosition() {
        return this.baseNegativeItemLabelPosition;
    }

    public void setBaseNegativeItemLabelPosition(ItemLabelPosition itemLabelPosition) {
        this.setBaseNegativeItemLabelPosition(itemLabelPosition, true);
    }

    public void setBaseNegativeItemLabelPosition(ItemLabelPosition itemLabelPosition, boolean bl2) {
        if (itemLabelPosition == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        this.baseNegativeItemLabelPosition = itemLabelPosition;
        if (!bl2) return;
        this.fireChangeEvent();
    }

    public double getItemLabelAnchorOffset() {
        return this.itemLabelAnchorOffset;
    }

    public void setItemLabelAnchorOffset(double d2) {
        this.itemLabelAnchorOffset = d2;
        this.fireChangeEvent();
    }

    public boolean getItemCreateEntity(int n2, int n3) {
        if (this.createEntities != null) {
            return this.createEntities;
        }
        Boolean bl2 = this.getSeriesCreateEntities(n2);
        if (bl2 == null) return this.baseCreateEntities;
        return bl2;
    }

    public Boolean getCreateEntities() {
        return this.createEntities;
    }

    public void setCreateEntities(Boolean bl2) {
        this.setCreateEntities(bl2, true);
    }

    public void setCreateEntities(Boolean bl2, boolean bl3) {
        this.createEntities = bl2;
        if (!bl3) return;
        this.fireChangeEvent();
    }

    public Boolean getSeriesCreateEntities(int n2) {
        return this.createEntitiesList.getBoolean(n2);
    }

    public void setSeriesCreateEntities(int n2, Boolean bl2) {
        this.setSeriesCreateEntities(n2, bl2, true);
    }

    public void setSeriesCreateEntities(int n2, Boolean bl2, boolean bl3) {
        this.createEntitiesList.setBoolean(n2, bl2);
        if (!bl3) return;
        this.fireChangeEvent();
    }

    public boolean getBaseCreateEntities() {
        return this.baseCreateEntities;
    }

    public void setBaseCreateEntities(boolean bl2) {
        this.setBaseCreateEntities(bl2, true);
    }

    public void setBaseCreateEntities(boolean bl2, boolean bl3) {
        this.baseCreateEntities = bl2;
        if (!bl3) return;
        this.fireChangeEvent();
    }

    protected Point2D calculateLabelAnchorPoint(ItemLabelAnchor itemLabelAnchor, double d2, double d3, PlotOrientation plotOrientation) {
        Point2D.Double double_ = null;
        if (itemLabelAnchor == ItemLabelAnchor.CENTER) {
            return new Point2D.Double(d2, d3);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE1) {
            return new Point2D.Double(d2 + OPP * this.itemLabelAnchorOffset, d3 - ADJ * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE2) {
            return new Point2D.Double(d2 + ADJ * this.itemLabelAnchorOffset, d3 - OPP * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE3) {
            return new Point2D.Double(d2 + this.itemLabelAnchorOffset, d3);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE4) {
            return new Point2D.Double(d2 + ADJ * this.itemLabelAnchorOffset, d3 + OPP * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE5) {
            return new Point2D.Double(d2 + OPP * this.itemLabelAnchorOffset, d3 + ADJ * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE6) {
            return new Point2D.Double(d2, d3 + this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE7) {
            return new Point2D.Double(d2 - OPP * this.itemLabelAnchorOffset, d3 + ADJ * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE8) {
            return new Point2D.Double(d2 - ADJ * this.itemLabelAnchorOffset, d3 + OPP * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE9) {
            return new Point2D.Double(d2 - this.itemLabelAnchorOffset, d3);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE10) {
            return new Point2D.Double(d2 - ADJ * this.itemLabelAnchorOffset, d3 - OPP * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE11) {
            return new Point2D.Double(d2 - OPP * this.itemLabelAnchorOffset, d3 - ADJ * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE12) {
            return new Point2D.Double(d2, d3 - this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE1) {
            return new Point2D.Double(d2 + 2.0 * OPP * this.itemLabelAnchorOffset, d3 - 2.0 * ADJ * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE2) {
            return new Point2D.Double(d2 + 2.0 * ADJ * this.itemLabelAnchorOffset, d3 - 2.0 * OPP * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE3) {
            return new Point2D.Double(d2 + 2.0 * this.itemLabelAnchorOffset, d3);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE4) {
            return new Point2D.Double(d2 + 2.0 * ADJ * this.itemLabelAnchorOffset, d3 + 2.0 * OPP * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE5) {
            return new Point2D.Double(d2 + 2.0 * OPP * this.itemLabelAnchorOffset, d3 + 2.0 * ADJ * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE6) {
            return new Point2D.Double(d2, d3 + 2.0 * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE7) {
            return new Point2D.Double(d2 - 2.0 * OPP * this.itemLabelAnchorOffset, d3 + 2.0 * ADJ * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE8) {
            return new Point2D.Double(d2 - 2.0 * ADJ * this.itemLabelAnchorOffset, d3 + 2.0 * OPP * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE9) {
            return new Point2D.Double(d2 - 2.0 * this.itemLabelAnchorOffset, d3);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE10) {
            return new Point2D.Double(d2 - 2.0 * ADJ * this.itemLabelAnchorOffset, d3 - 2.0 * OPP * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE11) {
            return new Point2D.Double(d2 - 2.0 * OPP * this.itemLabelAnchorOffset, d3 - 2.0 * ADJ * this.itemLabelAnchorOffset);
        }
        if (itemLabelAnchor != ItemLabelAnchor.OUTSIDE12) return double_;
        return new Point2D.Double(d2, d3 - 2.0 * this.itemLabelAnchorOffset);
    }

    public void addChangeListener(RendererChangeListener rendererChangeListener) {
        if (rendererChangeListener == null) {
            throw new IllegalArgumentException("Null 'listener' argument.");
        }
        Class class_ = class$org$jfree$chart$event$RendererChangeListener == null ? (AbstractRenderer.class$org$jfree$chart$event$RendererChangeListener = AbstractRenderer.class$("org.jfree.chart.event.RendererChangeListener")) : class$org$jfree$chart$event$RendererChangeListener;
        this.listenerList.add(class_, rendererChangeListener);
    }

    public void removeChangeListener(RendererChangeListener rendererChangeListener) {
        if (rendererChangeListener == null) {
            throw new IllegalArgumentException("Null 'listener' argument.");
        }
        Class class_ = class$org$jfree$chart$event$RendererChangeListener == null ? (AbstractRenderer.class$org$jfree$chart$event$RendererChangeListener = AbstractRenderer.class$("org.jfree.chart.event.RendererChangeListener")) : class$org$jfree$chart$event$RendererChangeListener;
        this.listenerList.remove(class_, rendererChangeListener);
    }

    public boolean hasListener(EventListener eventListener) {
        List<Object> list = Arrays.asList(this.listenerList.getListenerList());
        return list.contains(eventListener);
    }

    protected void fireChangeEvent() {
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public void notifyListeners(RendererChangeEvent rendererChangeEvent) {
        Object[] arrobject = this.listenerList.getListenerList();
        int n2 = arrobject.length - 2;
        while (n2 >= 0) {
            if (arrobject[n2] == (class$org$jfree$chart$event$RendererChangeListener == null ? AbstractRenderer.class$("org.jfree.chart.event.RendererChangeListener") : class$org$jfree$chart$event$RendererChangeListener)) {
                ((RendererChangeListener)arrobject[n2 + 1]).rendererChanged(rendererChangeEvent);
            }
            n2 -= 2;
        }
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AbstractRenderer)) {
            return false;
        }
        AbstractRenderer abstractRenderer = (AbstractRenderer)object;
        if (!ObjectUtilities.equal(this.seriesVisible, abstractRenderer.seriesVisible)) {
            return false;
        }
        if (!this.seriesVisibleList.equals(abstractRenderer.seriesVisibleList)) {
            return false;
        }
        if (this.baseSeriesVisible != abstractRenderer.baseSeriesVisible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.seriesVisibleInLegend, abstractRenderer.seriesVisibleInLegend)) {
            return false;
        }
        if (!this.seriesVisibleInLegendList.equals(abstractRenderer.seriesVisibleInLegendList)) {
            return false;
        }
        if (this.baseSeriesVisibleInLegend != abstractRenderer.baseSeriesVisibleInLegend) {
            return false;
        }
        if (!PaintUtilities.equal(this.paint, abstractRenderer.paint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.paintList, abstractRenderer.paintList)) {
            return false;
        }
        if (!PaintUtilities.equal(this.basePaint, abstractRenderer.basePaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.fillPaint, abstractRenderer.fillPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.fillPaintList, abstractRenderer.fillPaintList)) {
            return false;
        }
        if (!PaintUtilities.equal(this.baseFillPaint, abstractRenderer.baseFillPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.outlinePaint, abstractRenderer.outlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.outlinePaintList, abstractRenderer.outlinePaintList)) {
            return false;
        }
        if (!PaintUtilities.equal(this.baseOutlinePaint, abstractRenderer.baseOutlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.stroke, abstractRenderer.stroke)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.strokeList, abstractRenderer.strokeList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseStroke, abstractRenderer.baseStroke)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.outlineStroke, abstractRenderer.outlineStroke)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.outlineStrokeList, abstractRenderer.outlineStrokeList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseOutlineStroke, abstractRenderer.baseOutlineStroke)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.shape, abstractRenderer.shape)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.shapeList, abstractRenderer.shapeList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseShape, abstractRenderer.baseShape)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.itemLabelsVisible, abstractRenderer.itemLabelsVisible)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.itemLabelsVisibleList, abstractRenderer.itemLabelsVisibleList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseItemLabelsVisible, abstractRenderer.baseItemLabelsVisible)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.itemLabelFont, abstractRenderer.itemLabelFont)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.itemLabelFontList, abstractRenderer.itemLabelFontList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseItemLabelFont, abstractRenderer.baseItemLabelFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.itemLabelPaint, abstractRenderer.itemLabelPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.itemLabelPaintList, abstractRenderer.itemLabelPaintList)) {
            return false;
        }
        if (!PaintUtilities.equal(this.baseItemLabelPaint, abstractRenderer.baseItemLabelPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.positiveItemLabelPosition, abstractRenderer.positiveItemLabelPosition)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.positiveItemLabelPositionList, abstractRenderer.positiveItemLabelPositionList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.basePositiveItemLabelPosition, abstractRenderer.basePositiveItemLabelPosition)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.negativeItemLabelPosition, abstractRenderer.negativeItemLabelPosition)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.negativeItemLabelPositionList, abstractRenderer.negativeItemLabelPositionList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseNegativeItemLabelPosition, abstractRenderer.baseNegativeItemLabelPosition)) {
            return false;
        }
        if (this.itemLabelAnchorOffset != abstractRenderer.itemLabelAnchorOffset) {
            return false;
        }
        if (!ObjectUtilities.equal(this.createEntities, abstractRenderer.createEntities)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.createEntitiesList, abstractRenderer.createEntitiesList)) {
            return false;
        }
        if (this.baseCreateEntities == abstractRenderer.baseCreateEntities) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 193;
        n2 = 37 * n2 + ObjectUtilities.hashCode(this.stroke);
        n2 = 37 * n2 + ObjectUtilities.hashCode(this.baseStroke);
        n2 = 37 * n2 + ObjectUtilities.hashCode(this.outlineStroke);
        return 37 * n2 + ObjectUtilities.hashCode(this.baseOutlineStroke);
    }

    protected Object clone() {
        AbstractRenderer abstractRenderer = (AbstractRenderer)super.clone();
        if (this.seriesVisibleList != null) {
            abstractRenderer.seriesVisibleList = (BooleanList)this.seriesVisibleList.clone();
        }
        if (this.seriesVisibleInLegendList != null) {
            abstractRenderer.seriesVisibleInLegendList = (BooleanList)this.seriesVisibleInLegendList.clone();
        }
        if (this.paintList != null) {
            abstractRenderer.paintList = (PaintList)this.paintList.clone();
        }
        if (this.fillPaintList != null) {
            abstractRenderer.fillPaintList = (PaintList)this.fillPaintList.clone();
        }
        if (this.outlinePaintList != null) {
            abstractRenderer.outlinePaintList = (PaintList)this.outlinePaintList.clone();
        }
        if (this.strokeList != null) {
            abstractRenderer.strokeList = (StrokeList)this.strokeList.clone();
        }
        if (this.outlineStrokeList != null) {
            abstractRenderer.outlineStrokeList = (StrokeList)this.outlineStrokeList.clone();
        }
        if (this.shape != null) {
            abstractRenderer.shape = ShapeUtilities.clone(this.shape);
        }
        if (this.shapeList != null) {
            abstractRenderer.shapeList = (ShapeList)this.shapeList.clone();
        }
        if (this.baseShape != null) {
            abstractRenderer.baseShape = ShapeUtilities.clone(this.baseShape);
        }
        if (this.itemLabelsVisibleList != null) {
            abstractRenderer.itemLabelsVisibleList = (BooleanList)this.itemLabelsVisibleList.clone();
        }
        if (this.itemLabelFontList != null) {
            abstractRenderer.itemLabelFontList = (ObjectList)this.itemLabelFontList.clone();
        }
        if (this.itemLabelPaintList != null) {
            abstractRenderer.itemLabelPaintList = (PaintList)this.itemLabelPaintList.clone();
        }
        if (this.positiveItemLabelPositionList != null) {
            abstractRenderer.positiveItemLabelPositionList = (ObjectList)this.positiveItemLabelPositionList.clone();
        }
        if (this.negativeItemLabelPositionList != null) {
            abstractRenderer.negativeItemLabelPositionList = (ObjectList)this.negativeItemLabelPositionList.clone();
        }
        if (this.createEntitiesList != null) {
            abstractRenderer.createEntitiesList = (BooleanList)this.createEntitiesList.clone();
        }
        abstractRenderer.listenerList = new EventListenerList();
        abstractRenderer.event = null;
        return abstractRenderer;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writePaint(this.basePaint, objectOutputStream);
        SerialUtilities.writePaint(this.fillPaint, objectOutputStream);
        SerialUtilities.writePaint(this.baseFillPaint, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.baseOutlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
        SerialUtilities.writeStroke(this.baseStroke, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writeStroke(this.baseOutlineStroke, objectOutputStream);
        SerialUtilities.writeShape(this.shape, objectOutputStream);
        SerialUtilities.writeShape(this.baseShape, objectOutputStream);
        SerialUtilities.writePaint(this.itemLabelPaint, objectOutputStream);
        SerialUtilities.writePaint(this.baseItemLabelPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.basePaint = SerialUtilities.readPaint(objectInputStream);
        this.fillPaint = SerialUtilities.readPaint(objectInputStream);
        this.baseFillPaint = SerialUtilities.readPaint(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.baseOutlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.stroke = SerialUtilities.readStroke(objectInputStream);
        this.baseStroke = SerialUtilities.readStroke(objectInputStream);
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.baseOutlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.shape = SerialUtilities.readShape(objectInputStream);
        this.baseShape = SerialUtilities.readShape(objectInputStream);
        this.itemLabelPaint = SerialUtilities.readPaint(objectInputStream);
        this.baseItemLabelPaint = SerialUtilities.readPaint(objectInputStream);
        this.listenerList = new EventListenerList();
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

