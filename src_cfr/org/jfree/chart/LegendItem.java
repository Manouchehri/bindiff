/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.CharacterIterator;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.util.AttributedStringUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.ShapeUtilities;

public class LegendItem
implements Serializable {
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
    private static final Shape UNUSED_SHAPE = new Line2D.Float();
    private static final Stroke UNUSED_STROKE = new BasicStroke(0.0f);

    public LegendItem(String string, String string2, String string3, String string4, Shape shape, Paint paint) {
        this(string, string2, string3, string4, true, shape, true, paint, false, (Paint)Color.black, UNUSED_STROKE, false, UNUSED_SHAPE, UNUSED_STROKE, (Paint)Color.black);
    }

    public LegendItem(String string, String string2, String string3, String string4, Shape shape, Paint paint, Stroke stroke, Paint paint2) {
        this(string, string2, string3, string4, true, shape, true, paint, true, paint2, stroke, false, UNUSED_SHAPE, UNUSED_STROKE, (Paint)Color.black);
    }

    public LegendItem(String string, String string2, String string3, String string4, Shape shape, Stroke stroke, Paint paint) {
        this(string, string2, string3, string4, false, UNUSED_SHAPE, false, (Paint)Color.black, false, (Paint)Color.black, UNUSED_STROKE, true, shape, stroke, paint);
    }

    public LegendItem(String string, String string2, String string3, String string4, boolean bl2, Shape shape, boolean bl3, Paint paint, boolean bl4, Paint paint2, Stroke stroke, boolean bl5, Shape shape2, Stroke stroke2, Paint paint3) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'label' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'fillPaint' argument.");
        }
        if (stroke2 == null) {
            throw new IllegalArgumentException("Null 'lineStroke' argument.");
        }
        if (paint2 == null) {
            throw new IllegalArgumentException("Null 'outlinePaint' argument.");
        }
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'outlineStroke' argument.");
        }
        this.label = string;
        this.attributedLabel = null;
        this.description = string2;
        this.shapeVisible = bl2;
        this.shape = shape;
        this.shapeFilled = bl3;
        this.fillPaint = paint;
        this.fillPaintTransformer = new StandardGradientPaintTransformer();
        this.shapeOutlineVisible = bl4;
        this.outlinePaint = paint2;
        this.outlineStroke = stroke;
        this.lineVisible = bl5;
        this.line = shape2;
        this.lineStroke = stroke2;
        this.linePaint = paint3;
        this.toolTipText = string3;
        this.urlText = string4;
    }

    public LegendItem(AttributedString attributedString, String string, String string2, String string3, Shape shape, Paint paint) {
        this(attributedString, string, string2, string3, true, shape, true, paint, false, (Paint)Color.black, UNUSED_STROKE, false, UNUSED_SHAPE, UNUSED_STROKE, (Paint)Color.black);
    }

    public LegendItem(AttributedString attributedString, String string, String string2, String string3, Shape shape, Paint paint, Stroke stroke, Paint paint2) {
        this(attributedString, string, string2, string3, true, shape, true, paint, true, paint2, stroke, false, UNUSED_SHAPE, UNUSED_STROKE, (Paint)Color.black);
    }

    public LegendItem(AttributedString attributedString, String string, String string2, String string3, Shape shape, Stroke stroke, Paint paint) {
        this(attributedString, string, string2, string3, false, UNUSED_SHAPE, false, (Paint)Color.black, false, (Paint)Color.black, UNUSED_STROKE, true, shape, stroke, paint);
    }

    public LegendItem(AttributedString attributedString, String string, String string2, String string3, boolean bl2, Shape shape, boolean bl3, Paint paint, boolean bl4, Paint paint2, Stroke stroke, boolean bl5, Shape shape2, Stroke stroke2, Paint paint3) {
        if (attributedString == null) {
            throw new IllegalArgumentException("Null 'label' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'fillPaint' argument.");
        }
        if (stroke2 == null) {
            throw new IllegalArgumentException("Null 'lineStroke' argument.");
        }
        if (paint2 == null) {
            throw new IllegalArgumentException("Null 'outlinePaint' argument.");
        }
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'outlineStroke' argument.");
        }
        this.label = this.characterIteratorToString(attributedString.getIterator());
        this.attributedLabel = attributedString;
        this.description = string;
        this.shapeVisible = bl2;
        this.shape = shape;
        this.shapeFilled = bl3;
        this.fillPaint = paint;
        this.shapeOutlineVisible = bl4;
        this.outlinePaint = paint2;
        this.outlineStroke = stroke;
        this.lineVisible = bl5;
        this.line = shape2;
        this.lineStroke = stroke2;
        this.linePaint = paint3;
        this.toolTipText = string2;
        this.urlText = string3;
    }

    private String characterIteratorToString(CharacterIterator characterIterator) {
        int n2;
        int n3 = characterIterator.getEndIndex();
        int n4 = n3 - (n2 = characterIterator.getBeginIndex());
        if (n4 <= 0) {
            return "";
        }
        char[] arrc = new char[n4];
        int n5 = 0;
        char c2 = characterIterator.first();
        while (c2 != '\uffff') {
            arrc[n5] = c2;
            ++n5;
            c2 = characterIterator.next();
        }
        return new String(arrc);
    }

    public int getDatasetIndex() {
        return this.datasetIndex;
    }

    public void setDatasetIndex(int n2) {
        this.datasetIndex = n2;
    }

    public int getSeriesIndex() {
        return this.series;
    }

    public void setSeriesIndex(int n2) {
        this.series = n2;
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

    public void setFillPaintTransformer(GradientPaintTransformer gradientPaintTransformer) {
        if (gradientPaintTransformer == null) {
            throw new IllegalArgumentException("Null 'transformer' attribute.");
        }
        this.fillPaintTransformer = gradientPaintTransformer;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LegendItem)) {
            return false;
        }
        LegendItem legendItem = (LegendItem)object;
        if (this.datasetIndex != legendItem.datasetIndex) {
            return false;
        }
        if (this.series != legendItem.series) {
            return false;
        }
        if (!this.label.equals(legendItem.label)) {
            return false;
        }
        if (!AttributedStringUtilities.equal(this.attributedLabel, legendItem.attributedLabel)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.description, legendItem.description)) {
            return false;
        }
        if (this.shapeVisible != legendItem.shapeVisible) {
            return false;
        }
        if (!ShapeUtilities.equal(this.shape, legendItem.shape)) {
            return false;
        }
        if (this.shapeFilled != legendItem.shapeFilled) {
            return false;
        }
        if (!this.fillPaint.equals(legendItem.fillPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.fillPaintTransformer, legendItem.fillPaintTransformer)) {
            return false;
        }
        if (this.shapeOutlineVisible != legendItem.shapeOutlineVisible) {
            return false;
        }
        if (!this.outlineStroke.equals(legendItem.outlineStroke)) {
            return false;
        }
        if (!this.outlinePaint.equals(legendItem.outlinePaint)) {
            return false;
        }
        if (!this.lineVisible == legendItem.lineVisible) {
            return false;
        }
        if (!ShapeUtilities.equal(this.line, legendItem.line)) {
            return false;
        }
        if (!this.lineStroke.equals(legendItem.lineStroke)) {
            return false;
        }
        if (this.linePaint.equals(legendItem.linePaint)) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
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

    private void readObject(ObjectInputStream objectInputStream) {
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
}

