package org.jfree.chart;

import org.jfree.ui.*;
import java.text.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;

public class LegendItem implements Serializable
{
    private static final long serialVersionUID = -797214582948827144L;
    private int datasetIndex;
    private int series;
    private String label;
    private transient AttributedString attributedLabel;
    private String description;
    private String toolTipText;
    private String urlText;
    private boolean shapeVisible;
    private transient Shape shape;
    private boolean shapeFilled;
    private transient Paint fillPaint;
    private GradientPaintTransformer fillPaintTransformer;
    private boolean shapeOutlineVisible;
    private transient Paint outlinePaint;
    private transient Stroke outlineStroke;
    private boolean lineVisible;
    private transient Shape line;
    private transient Stroke lineStroke;
    private transient Paint linePaint;
    private static final Shape UNUSED_SHAPE;
    private static final Stroke UNUSED_STROKE;
    
    public LegendItem(final String s, final String s2, final String s3, final String s4, final Shape shape, final Paint paint) {
        this(s, s2, s3, s4, true, shape, true, paint, false, Color.black, LegendItem.UNUSED_STROKE, false, LegendItem.UNUSED_SHAPE, LegendItem.UNUSED_STROKE, Color.black);
    }
    
    public LegendItem(final String s, final String s2, final String s3, final String s4, final Shape shape, final Paint paint, final Stroke stroke, final Paint paint2) {
        this(s, s2, s3, s4, true, shape, true, paint, true, paint2, stroke, false, LegendItem.UNUSED_SHAPE, LegendItem.UNUSED_STROKE, Color.black);
    }
    
    public LegendItem(final String s, final String s2, final String s3, final String s4, final Shape shape, final Stroke stroke, final Paint paint) {
        this(s, s2, s3, s4, false, LegendItem.UNUSED_SHAPE, false, Color.black, false, Color.black, LegendItem.UNUSED_STROKE, true, shape, stroke, paint);
    }
    
    public LegendItem(final String label, final String description, final String toolTipText, final String urlText, final boolean shapeVisible, final Shape shape, final boolean shapeFilled, final Paint fillPaint, final boolean shapeOutlineVisible, final Paint outlinePaint, final Stroke outlineStroke, final boolean lineVisible, final Shape line, final Stroke lineStroke, final Paint linePaint) {
        if (label == null) {
            throw new IllegalArgumentException("Null 'label' argument.");
        }
        if (fillPaint == null) {
            throw new IllegalArgumentException("Null 'fillPaint' argument.");
        }
        if (lineStroke == null) {
            throw new IllegalArgumentException("Null 'lineStroke' argument.");
        }
        if (outlinePaint == null) {
            throw new IllegalArgumentException("Null 'outlinePaint' argument.");
        }
        if (outlineStroke == null) {
            throw new IllegalArgumentException("Null 'outlineStroke' argument.");
        }
        this.label = label;
        this.attributedLabel = null;
        this.description = description;
        this.shapeVisible = shapeVisible;
        this.shape = shape;
        this.shapeFilled = shapeFilled;
        this.fillPaint = fillPaint;
        this.fillPaintTransformer = new StandardGradientPaintTransformer();
        this.shapeOutlineVisible = shapeOutlineVisible;
        this.outlinePaint = outlinePaint;
        this.outlineStroke = outlineStroke;
        this.lineVisible = lineVisible;
        this.line = line;
        this.lineStroke = lineStroke;
        this.linePaint = linePaint;
        this.toolTipText = toolTipText;
        this.urlText = urlText;
    }
    
    public LegendItem(final AttributedString attributedString, final String s, final String s2, final String s3, final Shape shape, final Paint paint) {
        this(attributedString, s, s2, s3, true, shape, true, paint, false, Color.black, LegendItem.UNUSED_STROKE, false, LegendItem.UNUSED_SHAPE, LegendItem.UNUSED_STROKE, Color.black);
    }
    
    public LegendItem(final AttributedString attributedString, final String s, final String s2, final String s3, final Shape shape, final Paint paint, final Stroke stroke, final Paint paint2) {
        this(attributedString, s, s2, s3, true, shape, true, paint, true, paint2, stroke, false, LegendItem.UNUSED_SHAPE, LegendItem.UNUSED_STROKE, Color.black);
    }
    
    public LegendItem(final AttributedString attributedString, final String s, final String s2, final String s3, final Shape shape, final Stroke stroke, final Paint paint) {
        this(attributedString, s, s2, s3, false, LegendItem.UNUSED_SHAPE, false, Color.black, false, Color.black, LegendItem.UNUSED_STROKE, true, shape, stroke, paint);
    }
    
    public LegendItem(final AttributedString attributedLabel, final String description, final String toolTipText, final String urlText, final boolean shapeVisible, final Shape shape, final boolean shapeFilled, final Paint fillPaint, final boolean shapeOutlineVisible, final Paint outlinePaint, final Stroke outlineStroke, final boolean lineVisible, final Shape line, final Stroke lineStroke, final Paint linePaint) {
        if (attributedLabel == null) {
            throw new IllegalArgumentException("Null 'label' argument.");
        }
        if (fillPaint == null) {
            throw new IllegalArgumentException("Null 'fillPaint' argument.");
        }
        if (lineStroke == null) {
            throw new IllegalArgumentException("Null 'lineStroke' argument.");
        }
        if (outlinePaint == null) {
            throw new IllegalArgumentException("Null 'outlinePaint' argument.");
        }
        if (outlineStroke == null) {
            throw new IllegalArgumentException("Null 'outlineStroke' argument.");
        }
        this.label = this.characterIteratorToString(attributedLabel.getIterator());
        this.attributedLabel = attributedLabel;
        this.description = description;
        this.shapeVisible = shapeVisible;
        this.shape = shape;
        this.shapeFilled = shapeFilled;
        this.fillPaint = fillPaint;
        this.shapeOutlineVisible = shapeOutlineVisible;
        this.outlinePaint = outlinePaint;
        this.outlineStroke = outlineStroke;
        this.lineVisible = lineVisible;
        this.line = line;
        this.lineStroke = lineStroke;
        this.linePaint = linePaint;
        this.toolTipText = toolTipText;
        this.urlText = urlText;
    }
    
    private String characterIteratorToString(final CharacterIterator characterIterator) {
        final int n = characterIterator.getEndIndex() - characterIterator.getBeginIndex();
        if (n <= 0) {
            return "";
        }
        final char[] array = new char[n];
        int n2 = 0;
        for (char c = characterIterator.first(); c != '\uffff'; c = characterIterator.next()) {
            array[n2] = c;
            ++n2;
        }
        return new String(array);
    }
    
    public int getDatasetIndex() {
        return this.datasetIndex;
    }
    
    public void setDatasetIndex(final int datasetIndex) {
        this.datasetIndex = datasetIndex;
    }
    
    public int getSeriesIndex() {
        return this.series;
    }
    
    public void setSeriesIndex(final int series) {
        this.series = series;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public AttributedString getAttributedLabel() {
        return this.attributedLabel;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getToolTipText() {
        return this.toolTipText;
    }
    
    public String getURLText() {
        return this.urlText;
    }
    
    public boolean isShapeVisible() {
        return this.shapeVisible;
    }
    
    public Shape getShape() {
        return this.shape;
    }
    
    public boolean isShapeFilled() {
        return this.shapeFilled;
    }
    
    public Paint getFillPaint() {
        return this.fillPaint;
    }
    
    public boolean isShapeOutlineVisible() {
        return this.shapeOutlineVisible;
    }
    
    public Stroke getLineStroke() {
        return this.lineStroke;
    }
    
    public Paint getLinePaint() {
        return this.linePaint;
    }
    
    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }
    
    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }
    
    public boolean isLineVisible() {
        return this.lineVisible;
    }
    
    public Shape getLine() {
        return this.line;
    }
    
    public GradientPaintTransformer getFillPaintTransformer() {
        return this.fillPaintTransformer;
    }
    
    public void setFillPaintTransformer(final GradientPaintTransformer fillPaintTransformer) {
        if (fillPaintTransformer == null) {
            throw new IllegalArgumentException("Null 'transformer' attribute.");
        }
        this.fillPaintTransformer = fillPaintTransformer;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LegendItem)) {
            return false;
        }
        final LegendItem legendItem = (LegendItem)o;
        return this.datasetIndex == legendItem.datasetIndex && this.series == legendItem.series && this.label.equals(legendItem.label) && AttributedStringUtilities.equal(this.attributedLabel, legendItem.attributedLabel) && ObjectUtilities.equal(this.description, legendItem.description) && this.shapeVisible == legendItem.shapeVisible && ShapeUtilities.equal(this.shape, legendItem.shape) && this.shapeFilled == legendItem.shapeFilled && this.fillPaint.equals(legendItem.fillPaint) && ObjectUtilities.equal(this.fillPaintTransformer, legendItem.fillPaintTransformer) && this.shapeOutlineVisible == legendItem.shapeOutlineVisible && this.outlineStroke.equals(legendItem.outlineStroke) && this.outlinePaint.equals(legendItem.outlinePaint) && !this.lineVisible != legendItem.lineVisible && ShapeUtilities.equal(this.line, legendItem.line) && this.lineStroke.equals(legendItem.lineStroke) && this.linePaint.equals(legendItem.linePaint);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeAttributedString(this.attributedLabel, objectOutputStream);
        SerialUtilities.writeShape(this.shape, objectOutputStream);
        SerialUtilities.writePaint(this.fillPaint, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writeShape(this.line, objectOutputStream);
        SerialUtilities.writeStroke(this.lineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.linePaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.attributedLabel = SerialUtilities.readAttributedString(objectInputStream);
        this.shape = SerialUtilities.readShape(objectInputStream);
        this.fillPaint = SerialUtilities.readPaint(objectInputStream);
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.line = SerialUtilities.readShape(objectInputStream);
        this.lineStroke = SerialUtilities.readStroke(objectInputStream);
        this.linePaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static {
        UNUSED_SHAPE = new Line2D.Float();
        UNUSED_STROKE = new BasicStroke(0.0f);
    }
}
