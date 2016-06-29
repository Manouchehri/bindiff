package org.jfree.chart.renderer;

import javax.swing.event.*;
import org.jfree.chart.labels.*;
import org.jfree.ui.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.event.*;
import java.util.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;

public abstract class AbstractRenderer implements Serializable, Cloneable
{
    private static final long serialVersionUID = -828267569428206075L;
    public static final Double ZERO;
    public static final Paint DEFAULT_PAINT;
    public static final Paint DEFAULT_OUTLINE_PAINT;
    public static final Stroke DEFAULT_STROKE;
    public static final Stroke DEFAULT_OUTLINE_STROKE;
    public static final Shape DEFAULT_SHAPE;
    public static final Font DEFAULT_VALUE_LABEL_FONT;
    public static final Paint DEFAULT_VALUE_LABEL_PAINT;
    private Boolean seriesVisible;
    private BooleanList seriesVisibleList;
    private boolean baseSeriesVisible;
    private Boolean seriesVisibleInLegend;
    private BooleanList seriesVisibleInLegendList;
    private boolean baseSeriesVisibleInLegend;
    private transient Paint paint;
    private PaintList paintList;
    private transient Paint basePaint;
    private transient Paint fillPaint;
    private PaintList fillPaintList;
    private transient Paint baseFillPaint;
    private transient Paint outlinePaint;
    private PaintList outlinePaintList;
    private transient Paint baseOutlinePaint;
    private transient Stroke stroke;
    private StrokeList strokeList;
    private transient Stroke baseStroke;
    private transient Stroke outlineStroke;
    private StrokeList outlineStrokeList;
    private transient Stroke baseOutlineStroke;
    private transient Shape shape;
    private ShapeList shapeList;
    private transient Shape baseShape;
    private Boolean itemLabelsVisible;
    private BooleanList itemLabelsVisibleList;
    private Boolean baseItemLabelsVisible;
    private Font itemLabelFont;
    private ObjectList itemLabelFontList;
    private Font baseItemLabelFont;
    private transient Paint itemLabelPaint;
    private PaintList itemLabelPaintList;
    private transient Paint baseItemLabelPaint;
    private ItemLabelPosition positiveItemLabelPosition;
    private ObjectList positiveItemLabelPositionList;
    private ItemLabelPosition basePositiveItemLabelPosition;
    private ItemLabelPosition negativeItemLabelPosition;
    private ObjectList negativeItemLabelPositionList;
    private ItemLabelPosition baseNegativeItemLabelPosition;
    private double itemLabelAnchorOffset;
    private Boolean createEntities;
    private BooleanList createEntitiesList;
    private boolean baseCreateEntities;
    private transient EventListenerList listenerList;
    private transient RendererChangeEvent event;
    private static final double ADJ;
    private static final double OPP;
    static Class class$org$jfree$chart$event$RendererChangeListener;
    
    public AbstractRenderer() {
        this.itemLabelAnchorOffset = 2.0;
        this.seriesVisible = null;
        this.seriesVisibleList = new BooleanList();
        this.baseSeriesVisible = true;
        this.seriesVisibleInLegend = null;
        this.seriesVisibleInLegendList = new BooleanList();
        this.baseSeriesVisibleInLegend = true;
        this.paint = null;
        this.paintList = new PaintList();
        this.basePaint = AbstractRenderer.DEFAULT_PAINT;
        this.fillPaint = null;
        this.fillPaintList = new PaintList();
        this.baseFillPaint = Color.white;
        this.outlinePaint = null;
        this.outlinePaintList = new PaintList();
        this.baseOutlinePaint = AbstractRenderer.DEFAULT_OUTLINE_PAINT;
        this.stroke = null;
        this.strokeList = new StrokeList();
        this.baseStroke = AbstractRenderer.DEFAULT_STROKE;
        this.outlineStroke = null;
        this.outlineStrokeList = new StrokeList();
        this.baseOutlineStroke = AbstractRenderer.DEFAULT_OUTLINE_STROKE;
        this.shape = null;
        this.shapeList = new ShapeList();
        this.baseShape = AbstractRenderer.DEFAULT_SHAPE;
        this.itemLabelsVisible = null;
        this.itemLabelsVisibleList = new BooleanList();
        this.baseItemLabelsVisible = Boolean.FALSE;
        this.itemLabelFont = null;
        this.itemLabelFontList = new ObjectList();
        this.baseItemLabelFont = new Font("SansSerif", 0, 10);
        this.itemLabelPaint = null;
        this.itemLabelPaintList = new PaintList();
        this.baseItemLabelPaint = Color.black;
        this.positiveItemLabelPosition = null;
        this.positiveItemLabelPositionList = new ObjectList();
        this.basePositiveItemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER);
        this.negativeItemLabelPosition = null;
        this.negativeItemLabelPositionList = new ObjectList();
        this.baseNegativeItemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER);
        this.createEntities = null;
        this.createEntitiesList = new BooleanList();
        this.baseCreateEntities = true;
        this.listenerList = new EventListenerList();
    }
    
    public abstract DrawingSupplier getDrawingSupplier();
    
    public boolean getItemVisible(final int n, final int n2) {
        return this.isSeriesVisible(n);
    }
    
    public boolean isSeriesVisible(final int n) {
        boolean b = this.baseSeriesVisible;
        if (this.seriesVisible != null) {
            b = this.seriesVisible;
        }
        else {
            final Boolean boolean1 = this.seriesVisibleList.getBoolean(n);
            if (boolean1 != null) {
                b = boolean1;
            }
        }
        return b;
    }
    
    public Boolean getSeriesVisible() {
        return this.seriesVisible;
    }
    
    public void setSeriesVisible(final Boolean b) {
        this.setSeriesVisible(b, true);
    }
    
    public void setSeriesVisible(final Boolean seriesVisible, final boolean b) {
        this.seriesVisible = seriesVisible;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Boolean getSeriesVisible(final int n) {
        return this.seriesVisibleList.getBoolean(n);
    }
    
    public void setSeriesVisible(final int n, final Boolean b) {
        this.setSeriesVisible(n, b, true);
    }
    
    public void setSeriesVisible(final int n, final Boolean b, final boolean b2) {
        this.seriesVisibleList.setBoolean(n, b);
        if (b2) {
            this.fireChangeEvent();
        }
    }
    
    public boolean getBaseSeriesVisible() {
        return this.baseSeriesVisible;
    }
    
    public void setBaseSeriesVisible(final boolean b) {
        this.setBaseSeriesVisible(b, true);
    }
    
    public void setBaseSeriesVisible(final boolean baseSeriesVisible, final boolean b) {
        this.baseSeriesVisible = baseSeriesVisible;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public boolean isSeriesVisibleInLegend(final int n) {
        boolean b = this.baseSeriesVisibleInLegend;
        if (this.seriesVisibleInLegend != null) {
            b = this.seriesVisibleInLegend;
        }
        else {
            final Boolean boolean1 = this.seriesVisibleInLegendList.getBoolean(n);
            if (boolean1 != null) {
                b = boolean1;
            }
        }
        return b;
    }
    
    public Boolean getSeriesVisibleInLegend() {
        return this.seriesVisibleInLegend;
    }
    
    public void setSeriesVisibleInLegend(final Boolean b) {
        this.setSeriesVisibleInLegend(b, true);
    }
    
    public void setSeriesVisibleInLegend(final Boolean seriesVisibleInLegend, final boolean b) {
        this.seriesVisibleInLegend = seriesVisibleInLegend;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Boolean getSeriesVisibleInLegend(final int n) {
        return this.seriesVisibleInLegendList.getBoolean(n);
    }
    
    public void setSeriesVisibleInLegend(final int n, final Boolean b) {
        this.setSeriesVisibleInLegend(n, b, true);
    }
    
    public void setSeriesVisibleInLegend(final int n, final Boolean b, final boolean b2) {
        this.seriesVisibleInLegendList.setBoolean(n, b);
        if (b2) {
            this.fireChangeEvent();
        }
    }
    
    public boolean getBaseSeriesVisibleInLegend() {
        return this.baseSeriesVisibleInLegend;
    }
    
    public void setBaseSeriesVisibleInLegend(final boolean b) {
        this.setBaseSeriesVisibleInLegend(b, true);
    }
    
    public void setBaseSeriesVisibleInLegend(final boolean baseSeriesVisibleInLegend, final boolean b) {
        this.baseSeriesVisibleInLegend = baseSeriesVisibleInLegend;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Paint getItemPaint(final int n, final int n2) {
        return this.getSeriesPaint(n);
    }
    
    public Paint getSeriesPaint(final int n) {
        if (this.paint != null) {
            return this.paint;
        }
        Paint paint = this.paintList.getPaint(n);
        if (paint == null) {
            final DrawingSupplier drawingSupplier = this.getDrawingSupplier();
            if (drawingSupplier != null) {
                paint = drawingSupplier.getNextPaint();
                this.paintList.setPaint(n, paint);
            }
            else {
                paint = this.basePaint;
            }
        }
        return paint;
    }
    
    public void setPaint(final Paint paint) {
        this.setPaint(paint, true);
    }
    
    public void setPaint(final Paint paint, final boolean b) {
        this.paint = paint;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public void setSeriesPaint(final int n, final Paint paint) {
        this.setSeriesPaint(n, paint, true);
    }
    
    public void setSeriesPaint(final int n, final Paint paint, final boolean b) {
        this.paintList.setPaint(n, paint);
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Paint getBasePaint() {
        return this.basePaint;
    }
    
    public void setBasePaint(final Paint paint) {
        this.setBasePaint(paint, true);
    }
    
    public void setBasePaint(final Paint basePaint, final boolean b) {
        this.basePaint = basePaint;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Paint getItemFillPaint(final int n, final int n2) {
        return this.getSeriesFillPaint(n);
    }
    
    public Paint getSeriesFillPaint(final int n) {
        if (this.fillPaint != null) {
            return this.fillPaint;
        }
        Paint paint = this.fillPaintList.getPaint(n);
        if (paint == null) {
            paint = this.baseFillPaint;
        }
        return paint;
    }
    
    public void setSeriesFillPaint(final int n, final Paint paint) {
        this.setSeriesFillPaint(n, paint, true);
    }
    
    public void setSeriesFillPaint(final int n, final Paint paint, final boolean b) {
        this.fillPaintList.setPaint(n, paint);
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public void setFillPaint(final Paint paint) {
        this.setFillPaint(paint, true);
    }
    
    public void setFillPaint(final Paint fillPaint, final boolean b) {
        this.fillPaint = fillPaint;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Paint getBaseFillPaint() {
        return this.baseFillPaint;
    }
    
    public void setBaseFillPaint(final Paint paint) {
        this.setBaseFillPaint(paint, true);
    }
    
    public void setBaseFillPaint(final Paint baseFillPaint, final boolean b) {
        if (baseFillPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseFillPaint = baseFillPaint;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Paint getItemOutlinePaint(final int n, final int n2) {
        return this.getSeriesOutlinePaint(n);
    }
    
    public Paint getSeriesOutlinePaint(final int n) {
        if (this.outlinePaint != null) {
            return this.outlinePaint;
        }
        Paint paint = this.outlinePaintList.getPaint(n);
        if (paint == null) {
            final DrawingSupplier drawingSupplier = this.getDrawingSupplier();
            if (drawingSupplier != null) {
                paint = drawingSupplier.getNextOutlinePaint();
                this.outlinePaintList.setPaint(n, paint);
            }
            else {
                paint = this.baseOutlinePaint;
            }
        }
        return paint;
    }
    
    public void setSeriesOutlinePaint(final int n, final Paint paint) {
        this.setSeriesOutlinePaint(n, paint, true);
    }
    
    public void setSeriesOutlinePaint(final int n, final Paint paint, final boolean b) {
        this.outlinePaintList.setPaint(n, paint);
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public void setOutlinePaint(final Paint paint) {
        this.setOutlinePaint(paint, true);
    }
    
    public void setOutlinePaint(final Paint outlinePaint, final boolean b) {
        this.outlinePaint = outlinePaint;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Paint getBaseOutlinePaint() {
        return this.baseOutlinePaint;
    }
    
    public void setBaseOutlinePaint(final Paint paint) {
        this.setBaseOutlinePaint(paint, true);
    }
    
    public void setBaseOutlinePaint(final Paint baseOutlinePaint, final boolean b) {
        if (baseOutlinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseOutlinePaint = baseOutlinePaint;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Stroke getItemStroke(final int n, final int n2) {
        return this.getSeriesStroke(n);
    }
    
    public Stroke getSeriesStroke(final int n) {
        if (this.stroke != null) {
            return this.stroke;
        }
        Stroke stroke = this.strokeList.getStroke(n);
        if (stroke == null) {
            final DrawingSupplier drawingSupplier = this.getDrawingSupplier();
            if (drawingSupplier != null) {
                stroke = drawingSupplier.getNextStroke();
                this.strokeList.setStroke(n, stroke);
            }
            else {
                stroke = this.baseStroke;
            }
        }
        return stroke;
    }
    
    public void setStroke(final Stroke stroke) {
        this.setStroke(stroke, true);
    }
    
    public void setStroke(final Stroke stroke, final boolean b) {
        this.stroke = stroke;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public void setSeriesStroke(final int n, final Stroke stroke) {
        this.setSeriesStroke(n, stroke, true);
    }
    
    public void setSeriesStroke(final int n, final Stroke stroke, final boolean b) {
        this.strokeList.setStroke(n, stroke);
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Stroke getBaseStroke() {
        return this.baseStroke;
    }
    
    public void setBaseStroke(final Stroke stroke) {
        this.setBaseStroke(stroke, true);
    }
    
    public void setBaseStroke(final Stroke baseStroke, final boolean b) {
        if (baseStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.baseStroke = baseStroke;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Stroke getItemOutlineStroke(final int n, final int n2) {
        return this.getSeriesOutlineStroke(n);
    }
    
    public Stroke getSeriesOutlineStroke(final int n) {
        if (this.outlineStroke != null) {
            return this.outlineStroke;
        }
        Stroke stroke = this.outlineStrokeList.getStroke(n);
        if (stroke == null) {
            final DrawingSupplier drawingSupplier = this.getDrawingSupplier();
            if (drawingSupplier != null) {
                stroke = drawingSupplier.getNextOutlineStroke();
                this.outlineStrokeList.setStroke(n, stroke);
            }
            else {
                stroke = this.baseOutlineStroke;
            }
        }
        return stroke;
    }
    
    public void setOutlineStroke(final Stroke stroke) {
        this.setOutlineStroke(stroke, true);
    }
    
    public void setOutlineStroke(final Stroke outlineStroke, final boolean b) {
        this.outlineStroke = outlineStroke;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public void setSeriesOutlineStroke(final int n, final Stroke stroke) {
        this.setSeriesOutlineStroke(n, stroke, true);
    }
    
    public void setSeriesOutlineStroke(final int n, final Stroke stroke, final boolean b) {
        this.outlineStrokeList.setStroke(n, stroke);
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Stroke getBaseOutlineStroke() {
        return this.baseOutlineStroke;
    }
    
    public void setBaseOutlineStroke(final Stroke stroke) {
        this.setBaseOutlineStroke(stroke, true);
    }
    
    public void setBaseOutlineStroke(final Stroke baseOutlineStroke, final boolean b) {
        if (baseOutlineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.baseOutlineStroke = baseOutlineStroke;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Shape getItemShape(final int n, final int n2) {
        return this.getSeriesShape(n);
    }
    
    public Shape getSeriesShape(final int n) {
        if (this.shape != null) {
            return this.shape;
        }
        Shape shape = this.shapeList.getShape(n);
        if (shape == null) {
            final DrawingSupplier drawingSupplier = this.getDrawingSupplier();
            if (drawingSupplier != null) {
                shape = drawingSupplier.getNextShape();
                this.shapeList.setShape(n, shape);
            }
            else {
                shape = this.baseShape;
            }
        }
        return shape;
    }
    
    public void setShape(final Shape shape) {
        this.setShape(shape, true);
    }
    
    public void setShape(final Shape shape, final boolean b) {
        this.shape = shape;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public void setSeriesShape(final int n, final Shape shape) {
        this.setSeriesShape(n, shape, true);
    }
    
    public void setSeriesShape(final int n, final Shape shape, final boolean b) {
        this.shapeList.setShape(n, shape);
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Shape getBaseShape() {
        return this.baseShape;
    }
    
    public void setBaseShape(final Shape shape) {
        this.setBaseShape(shape, true);
    }
    
    public void setBaseShape(final Shape baseShape, final boolean b) {
        if (baseShape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        this.baseShape = baseShape;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public boolean isItemLabelVisible(final int n, final int n2) {
        return this.isSeriesItemLabelsVisible(n);
    }
    
    public boolean isSeriesItemLabelsVisible(final int n) {
        if (this.itemLabelsVisible != null) {
            return this.itemLabelsVisible;
        }
        Boolean b = this.itemLabelsVisibleList.getBoolean(n);
        if (b == null) {
            b = this.baseItemLabelsVisible;
        }
        if (b == null) {
            b = Boolean.FALSE;
        }
        return b;
    }
    
    public void setItemLabelsVisible(final boolean b) {
        this.setItemLabelsVisible(BooleanUtilities.valueOf(b));
    }
    
    public void setItemLabelsVisible(final Boolean b) {
        this.setItemLabelsVisible(b, true);
    }
    
    public void setItemLabelsVisible(final Boolean itemLabelsVisible, final boolean b) {
        this.itemLabelsVisible = itemLabelsVisible;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public void setSeriesItemLabelsVisible(final int n, final boolean b) {
        this.setSeriesItemLabelsVisible(n, BooleanUtilities.valueOf(b));
    }
    
    public void setSeriesItemLabelsVisible(final int n, final Boolean b) {
        this.setSeriesItemLabelsVisible(n, b, true);
    }
    
    public void setSeriesItemLabelsVisible(final int n, final Boolean b, final boolean b2) {
        this.itemLabelsVisibleList.setBoolean(n, b);
        if (b2) {
            this.fireChangeEvent();
        }
    }
    
    public Boolean getBaseItemLabelsVisible() {
        return this.baseItemLabelsVisible;
    }
    
    public void setBaseItemLabelsVisible(final boolean b) {
        this.setBaseItemLabelsVisible(BooleanUtilities.valueOf(b));
    }
    
    public void setBaseItemLabelsVisible(final Boolean b) {
        this.setBaseItemLabelsVisible(b, true);
    }
    
    public void setBaseItemLabelsVisible(final Boolean baseItemLabelsVisible, final boolean b) {
        this.baseItemLabelsVisible = baseItemLabelsVisible;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Font getItemLabelFont(final int n, final int n2) {
        Font font = this.itemLabelFont;
        if (font == null) {
            font = this.getSeriesItemLabelFont(n);
            if (font == null) {
                font = this.baseItemLabelFont;
            }
        }
        return font;
    }
    
    public Font getItemLabelFont() {
        return this.itemLabelFont;
    }
    
    public void setItemLabelFont(final Font font) {
        this.setItemLabelFont(font, true);
    }
    
    public void setItemLabelFont(final Font itemLabelFont, final boolean b) {
        this.itemLabelFont = itemLabelFont;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Font getSeriesItemLabelFont(final int n) {
        return (Font)this.itemLabelFontList.get(n);
    }
    
    public void setSeriesItemLabelFont(final int n, final Font font) {
        this.setSeriesItemLabelFont(n, font, true);
    }
    
    public void setSeriesItemLabelFont(final int n, final Font font, final boolean b) {
        this.itemLabelFontList.set(n, font);
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Font getBaseItemLabelFont() {
        return this.baseItemLabelFont;
    }
    
    public void setBaseItemLabelFont(final Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.setBaseItemLabelFont(font, true);
    }
    
    public void setBaseItemLabelFont(final Font baseItemLabelFont, final boolean b) {
        this.baseItemLabelFont = baseItemLabelFont;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Paint getItemLabelPaint(final int n, final int n2) {
        Paint paint = this.itemLabelPaint;
        if (paint == null) {
            paint = this.getSeriesItemLabelPaint(n);
            if (paint == null) {
                paint = this.baseItemLabelPaint;
            }
        }
        return paint;
    }
    
    public Paint getItemLabelPaint() {
        return this.itemLabelPaint;
    }
    
    public void setItemLabelPaint(final Paint paint) {
        this.setItemLabelPaint(paint, true);
    }
    
    public void setItemLabelPaint(final Paint itemLabelPaint, final boolean b) {
        this.itemLabelPaint = itemLabelPaint;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Paint getSeriesItemLabelPaint(final int n) {
        return this.itemLabelPaintList.getPaint(n);
    }
    
    public void setSeriesItemLabelPaint(final int n, final Paint paint) {
        this.setSeriesItemLabelPaint(n, paint, true);
    }
    
    public void setSeriesItemLabelPaint(final int n, final Paint paint, final boolean b) {
        this.itemLabelPaintList.setPaint(n, paint);
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Paint getBaseItemLabelPaint() {
        return this.baseItemLabelPaint;
    }
    
    public void setBaseItemLabelPaint(final Paint paint) {
        this.setBaseItemLabelPaint(paint, true);
    }
    
    public void setBaseItemLabelPaint(final Paint baseItemLabelPaint, final boolean b) {
        if (baseItemLabelPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseItemLabelPaint = baseItemLabelPaint;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public ItemLabelPosition getPositiveItemLabelPosition(final int n, final int n2) {
        return this.getSeriesPositiveItemLabelPosition(n);
    }
    
    public ItemLabelPosition getPositiveItemLabelPosition() {
        return this.positiveItemLabelPosition;
    }
    
    public void setPositiveItemLabelPosition(final ItemLabelPosition itemLabelPosition) {
        this.setPositiveItemLabelPosition(itemLabelPosition, true);
    }
    
    public void setPositiveItemLabelPosition(final ItemLabelPosition positiveItemLabelPosition, final boolean b) {
        this.positiveItemLabelPosition = positiveItemLabelPosition;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public ItemLabelPosition getSeriesPositiveItemLabelPosition(final int n) {
        if (this.positiveItemLabelPosition != null) {
            return this.positiveItemLabelPosition;
        }
        ItemLabelPosition basePositiveItemLabelPosition = (ItemLabelPosition)this.positiveItemLabelPositionList.get(n);
        if (basePositiveItemLabelPosition == null) {
            basePositiveItemLabelPosition = this.basePositiveItemLabelPosition;
        }
        return basePositiveItemLabelPosition;
    }
    
    public void setSeriesPositiveItemLabelPosition(final int n, final ItemLabelPosition itemLabelPosition) {
        this.setSeriesPositiveItemLabelPosition(n, itemLabelPosition, true);
    }
    
    public void setSeriesPositiveItemLabelPosition(final int n, final ItemLabelPosition itemLabelPosition, final boolean b) {
        this.positiveItemLabelPositionList.set(n, itemLabelPosition);
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public ItemLabelPosition getBasePositiveItemLabelPosition() {
        return this.basePositiveItemLabelPosition;
    }
    
    public void setBasePositiveItemLabelPosition(final ItemLabelPosition itemLabelPosition) {
        this.setBasePositiveItemLabelPosition(itemLabelPosition, true);
    }
    
    public void setBasePositiveItemLabelPosition(final ItemLabelPosition basePositiveItemLabelPosition, final boolean b) {
        if (basePositiveItemLabelPosition == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        this.basePositiveItemLabelPosition = basePositiveItemLabelPosition;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public ItemLabelPosition getNegativeItemLabelPosition(final int n, final int n2) {
        return this.getSeriesNegativeItemLabelPosition(n);
    }
    
    public ItemLabelPosition getNegativeItemLabelPosition() {
        return this.negativeItemLabelPosition;
    }
    
    public void setNegativeItemLabelPosition(final ItemLabelPosition itemLabelPosition) {
        this.setNegativeItemLabelPosition(itemLabelPosition, true);
    }
    
    public void setNegativeItemLabelPosition(final ItemLabelPosition negativeItemLabelPosition, final boolean b) {
        this.negativeItemLabelPosition = negativeItemLabelPosition;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public ItemLabelPosition getSeriesNegativeItemLabelPosition(final int n) {
        if (this.negativeItemLabelPosition != null) {
            return this.negativeItemLabelPosition;
        }
        ItemLabelPosition baseNegativeItemLabelPosition = (ItemLabelPosition)this.negativeItemLabelPositionList.get(n);
        if (baseNegativeItemLabelPosition == null) {
            baseNegativeItemLabelPosition = this.baseNegativeItemLabelPosition;
        }
        return baseNegativeItemLabelPosition;
    }
    
    public void setSeriesNegativeItemLabelPosition(final int n, final ItemLabelPosition itemLabelPosition) {
        this.setSeriesNegativeItemLabelPosition(n, itemLabelPosition, true);
    }
    
    public void setSeriesNegativeItemLabelPosition(final int n, final ItemLabelPosition itemLabelPosition, final boolean b) {
        this.negativeItemLabelPositionList.set(n, itemLabelPosition);
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public ItemLabelPosition getBaseNegativeItemLabelPosition() {
        return this.baseNegativeItemLabelPosition;
    }
    
    public void setBaseNegativeItemLabelPosition(final ItemLabelPosition itemLabelPosition) {
        this.setBaseNegativeItemLabelPosition(itemLabelPosition, true);
    }
    
    public void setBaseNegativeItemLabelPosition(final ItemLabelPosition baseNegativeItemLabelPosition, final boolean b) {
        if (baseNegativeItemLabelPosition == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        this.baseNegativeItemLabelPosition = baseNegativeItemLabelPosition;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public double getItemLabelAnchorOffset() {
        return this.itemLabelAnchorOffset;
    }
    
    public void setItemLabelAnchorOffset(final double itemLabelAnchorOffset) {
        this.itemLabelAnchorOffset = itemLabelAnchorOffset;
        this.fireChangeEvent();
    }
    
    public boolean getItemCreateEntity(final int n, final int n2) {
        if (this.createEntities != null) {
            return this.createEntities;
        }
        final Boolean seriesCreateEntities = this.getSeriesCreateEntities(n);
        if (seriesCreateEntities != null) {
            return seriesCreateEntities;
        }
        return this.baseCreateEntities;
    }
    
    public Boolean getCreateEntities() {
        return this.createEntities;
    }
    
    public void setCreateEntities(final Boolean b) {
        this.setCreateEntities(b, true);
    }
    
    public void setCreateEntities(final Boolean createEntities, final boolean b) {
        this.createEntities = createEntities;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    public Boolean getSeriesCreateEntities(final int n) {
        return this.createEntitiesList.getBoolean(n);
    }
    
    public void setSeriesCreateEntities(final int n, final Boolean b) {
        this.setSeriesCreateEntities(n, b, true);
    }
    
    public void setSeriesCreateEntities(final int n, final Boolean b, final boolean b2) {
        this.createEntitiesList.setBoolean(n, b);
        if (b2) {
            this.fireChangeEvent();
        }
    }
    
    public boolean getBaseCreateEntities() {
        return this.baseCreateEntities;
    }
    
    public void setBaseCreateEntities(final boolean b) {
        this.setBaseCreateEntities(b, true);
    }
    
    public void setBaseCreateEntities(final boolean baseCreateEntities, final boolean b) {
        this.baseCreateEntities = baseCreateEntities;
        if (b) {
            this.fireChangeEvent();
        }
    }
    
    protected Point2D calculateLabelAnchorPoint(final ItemLabelAnchor itemLabelAnchor, final double n, final double n2, final PlotOrientation plotOrientation) {
        Point2D point2D = null;
        if (itemLabelAnchor == ItemLabelAnchor.CENTER) {
            point2D = new Point2D.Double(n, n2);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE1) {
            point2D = new Point2D.Double(n + AbstractRenderer.OPP * this.itemLabelAnchorOffset, n2 - AbstractRenderer.ADJ * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE2) {
            point2D = new Point2D.Double(n + AbstractRenderer.ADJ * this.itemLabelAnchorOffset, n2 - AbstractRenderer.OPP * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE3) {
            point2D = new Point2D.Double(n + this.itemLabelAnchorOffset, n2);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE4) {
            point2D = new Point2D.Double(n + AbstractRenderer.ADJ * this.itemLabelAnchorOffset, n2 + AbstractRenderer.OPP * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE5) {
            point2D = new Point2D.Double(n + AbstractRenderer.OPP * this.itemLabelAnchorOffset, n2 + AbstractRenderer.ADJ * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE6) {
            point2D = new Point2D.Double(n, n2 + this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE7) {
            point2D = new Point2D.Double(n - AbstractRenderer.OPP * this.itemLabelAnchorOffset, n2 + AbstractRenderer.ADJ * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE8) {
            point2D = new Point2D.Double(n - AbstractRenderer.ADJ * this.itemLabelAnchorOffset, n2 + AbstractRenderer.OPP * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE9) {
            point2D = new Point2D.Double(n - this.itemLabelAnchorOffset, n2);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE10) {
            point2D = new Point2D.Double(n - AbstractRenderer.ADJ * this.itemLabelAnchorOffset, n2 - AbstractRenderer.OPP * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE11) {
            point2D = new Point2D.Double(n - AbstractRenderer.OPP * this.itemLabelAnchorOffset, n2 - AbstractRenderer.ADJ * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE12) {
            point2D = new Point2D.Double(n, n2 - this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE1) {
            point2D = new Point2D.Double(n + 2.0 * AbstractRenderer.OPP * this.itemLabelAnchorOffset, n2 - 2.0 * AbstractRenderer.ADJ * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE2) {
            point2D = new Point2D.Double(n + 2.0 * AbstractRenderer.ADJ * this.itemLabelAnchorOffset, n2 - 2.0 * AbstractRenderer.OPP * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE3) {
            point2D = new Point2D.Double(n + 2.0 * this.itemLabelAnchorOffset, n2);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE4) {
            point2D = new Point2D.Double(n + 2.0 * AbstractRenderer.ADJ * this.itemLabelAnchorOffset, n2 + 2.0 * AbstractRenderer.OPP * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE5) {
            point2D = new Point2D.Double(n + 2.0 * AbstractRenderer.OPP * this.itemLabelAnchorOffset, n2 + 2.0 * AbstractRenderer.ADJ * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE6) {
            point2D = new Point2D.Double(n, n2 + 2.0 * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE7) {
            point2D = new Point2D.Double(n - 2.0 * AbstractRenderer.OPP * this.itemLabelAnchorOffset, n2 + 2.0 * AbstractRenderer.ADJ * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE8) {
            point2D = new Point2D.Double(n - 2.0 * AbstractRenderer.ADJ * this.itemLabelAnchorOffset, n2 + 2.0 * AbstractRenderer.OPP * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE9) {
            point2D = new Point2D.Double(n - 2.0 * this.itemLabelAnchorOffset, n2);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE10) {
            point2D = new Point2D.Double(n - 2.0 * AbstractRenderer.ADJ * this.itemLabelAnchorOffset, n2 - 2.0 * AbstractRenderer.OPP * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE11) {
            point2D = new Point2D.Double(n - 2.0 * AbstractRenderer.OPP * this.itemLabelAnchorOffset, n2 - 2.0 * AbstractRenderer.ADJ * this.itemLabelAnchorOffset);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE12) {
            point2D = new Point2D.Double(n, n2 - 2.0 * this.itemLabelAnchorOffset);
        }
        return point2D;
    }
    
    public void addChangeListener(final RendererChangeListener rendererChangeListener) {
        if (rendererChangeListener == null) {
            throw new IllegalArgumentException("Null 'listener' argument.");
        }
        this.listenerList.add((AbstractRenderer.class$org$jfree$chart$event$RendererChangeListener == null) ? (AbstractRenderer.class$org$jfree$chart$event$RendererChangeListener = class$("org.jfree.chart.event.RendererChangeListener")) : AbstractRenderer.class$org$jfree$chart$event$RendererChangeListener, rendererChangeListener);
    }
    
    public void removeChangeListener(final RendererChangeListener rendererChangeListener) {
        if (rendererChangeListener == null) {
            throw new IllegalArgumentException("Null 'listener' argument.");
        }
        this.listenerList.remove((AbstractRenderer.class$org$jfree$chart$event$RendererChangeListener == null) ? (AbstractRenderer.class$org$jfree$chart$event$RendererChangeListener = class$("org.jfree.chart.event.RendererChangeListener")) : AbstractRenderer.class$org$jfree$chart$event$RendererChangeListener, rendererChangeListener);
    }
    
    public boolean hasListener(final EventListener eventListener) {
        return Arrays.asList(this.listenerList.getListenerList()).contains(eventListener);
    }
    
    protected void fireChangeEvent() {
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void notifyListeners(final RendererChangeEvent rendererChangeEvent) {
        final Object[] listenerList = this.listenerList.getListenerList();
        for (int i = listenerList.length - 2; i >= 0; i -= 2) {
            if (listenerList[i] == ((AbstractRenderer.class$org$jfree$chart$event$RendererChangeListener == null) ? (AbstractRenderer.class$org$jfree$chart$event$RendererChangeListener = class$("org.jfree.chart.event.RendererChangeListener")) : AbstractRenderer.class$org$jfree$chart$event$RendererChangeListener)) {
                ((RendererChangeListener)listenerList[i + 1]).rendererChanged(rendererChangeEvent);
            }
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AbstractRenderer)) {
            return false;
        }
        final AbstractRenderer abstractRenderer = (AbstractRenderer)o;
        return ObjectUtilities.equal(this.seriesVisible, abstractRenderer.seriesVisible) && this.seriesVisibleList.equals(abstractRenderer.seriesVisibleList) && this.baseSeriesVisible == abstractRenderer.baseSeriesVisible && ObjectUtilities.equal(this.seriesVisibleInLegend, abstractRenderer.seriesVisibleInLegend) && this.seriesVisibleInLegendList.equals(abstractRenderer.seriesVisibleInLegendList) && this.baseSeriesVisibleInLegend == abstractRenderer.baseSeriesVisibleInLegend && PaintUtilities.equal(this.paint, abstractRenderer.paint) && ObjectUtilities.equal(this.paintList, abstractRenderer.paintList) && PaintUtilities.equal(this.basePaint, abstractRenderer.basePaint) && PaintUtilities.equal(this.fillPaint, abstractRenderer.fillPaint) && ObjectUtilities.equal(this.fillPaintList, abstractRenderer.fillPaintList) && PaintUtilities.equal(this.baseFillPaint, abstractRenderer.baseFillPaint) && PaintUtilities.equal(this.outlinePaint, abstractRenderer.outlinePaint) && ObjectUtilities.equal(this.outlinePaintList, abstractRenderer.outlinePaintList) && PaintUtilities.equal(this.baseOutlinePaint, abstractRenderer.baseOutlinePaint) && ObjectUtilities.equal(this.stroke, abstractRenderer.stroke) && ObjectUtilities.equal(this.strokeList, abstractRenderer.strokeList) && ObjectUtilities.equal(this.baseStroke, abstractRenderer.baseStroke) && ObjectUtilities.equal(this.outlineStroke, abstractRenderer.outlineStroke) && ObjectUtilities.equal(this.outlineStrokeList, abstractRenderer.outlineStrokeList) && ObjectUtilities.equal(this.baseOutlineStroke, abstractRenderer.baseOutlineStroke) && ObjectUtilities.equal(this.shape, abstractRenderer.shape) && ObjectUtilities.equal(this.shapeList, abstractRenderer.shapeList) && ObjectUtilities.equal(this.baseShape, abstractRenderer.baseShape) && ObjectUtilities.equal(this.itemLabelsVisible, abstractRenderer.itemLabelsVisible) && ObjectUtilities.equal(this.itemLabelsVisibleList, abstractRenderer.itemLabelsVisibleList) && ObjectUtilities.equal(this.baseItemLabelsVisible, abstractRenderer.baseItemLabelsVisible) && ObjectUtilities.equal(this.itemLabelFont, abstractRenderer.itemLabelFont) && ObjectUtilities.equal(this.itemLabelFontList, abstractRenderer.itemLabelFontList) && ObjectUtilities.equal(this.baseItemLabelFont, abstractRenderer.baseItemLabelFont) && PaintUtilities.equal(this.itemLabelPaint, abstractRenderer.itemLabelPaint) && ObjectUtilities.equal(this.itemLabelPaintList, abstractRenderer.itemLabelPaintList) && PaintUtilities.equal(this.baseItemLabelPaint, abstractRenderer.baseItemLabelPaint) && ObjectUtilities.equal(this.positiveItemLabelPosition, abstractRenderer.positiveItemLabelPosition) && ObjectUtilities.equal(this.positiveItemLabelPositionList, abstractRenderer.positiveItemLabelPositionList) && ObjectUtilities.equal(this.basePositiveItemLabelPosition, abstractRenderer.basePositiveItemLabelPosition) && ObjectUtilities.equal(this.negativeItemLabelPosition, abstractRenderer.negativeItemLabelPosition) && ObjectUtilities.equal(this.negativeItemLabelPositionList, abstractRenderer.negativeItemLabelPositionList) && ObjectUtilities.equal(this.baseNegativeItemLabelPosition, abstractRenderer.baseNegativeItemLabelPosition) && this.itemLabelAnchorOffset == abstractRenderer.itemLabelAnchorOffset && ObjectUtilities.equal(this.createEntities, abstractRenderer.createEntities) && ObjectUtilities.equal(this.createEntitiesList, abstractRenderer.createEntitiesList) && this.baseCreateEntities == abstractRenderer.baseCreateEntities;
    }
    
    public int hashCode() {
        return 37 * (37 * (37 * (37 * 193 + ObjectUtilities.hashCode(this.stroke)) + ObjectUtilities.hashCode(this.baseStroke)) + ObjectUtilities.hashCode(this.outlineStroke)) + ObjectUtilities.hashCode(this.baseOutlineStroke);
    }
    
    protected Object clone() {
        final AbstractRenderer abstractRenderer = (AbstractRenderer)super.clone();
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
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
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
    
    private void readObject(final ObjectInputStream objectInputStream) {
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
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        ZERO = new Double(0.0);
        DEFAULT_PAINT = Color.blue;
        DEFAULT_OUTLINE_PAINT = Color.gray;
        DEFAULT_STROKE = new BasicStroke(1.0f);
        DEFAULT_OUTLINE_STROKE = new BasicStroke(1.0f);
        DEFAULT_SHAPE = new Rectangle2D.Double(-3.0, -3.0, 6.0, 6.0);
        DEFAULT_VALUE_LABEL_FONT = new Font("SansSerif", 0, 10);
        DEFAULT_VALUE_LABEL_PAINT = Color.black;
        ADJ = Math.cos(0.5235987755982988);
        OPP = Math.sin(0.5235987755982988);
    }
}
