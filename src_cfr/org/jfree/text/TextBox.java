/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.text;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.util.ObjectUtilities;

public class TextBox
implements Serializable {
    private static final long serialVersionUID = 3360220213180203706L;
    private transient Paint outlinePaint = Color.black;
    private transient Stroke outlineStroke = new BasicStroke(1.0f);
    private RectangleInsets interiorGap = new RectangleInsets(1.0, 3.0, 1.0, 3.0);
    private transient Paint backgroundPaint = new Color(255, 255, 192);
    private transient Paint shadowPaint = Color.gray;
    private double shadowXOffset = 2.0;
    private double shadowYOffset = 2.0;
    private TextBlock textBlock;

    public TextBox() {
        this((TextBlock)null);
    }

    public TextBox(String string) {
        this((TextBlock)null);
        if (string == null) return;
        this.textBlock = new TextBlock();
        this.textBlock.addLine(string, new Font("SansSerif", 0, 10), Color.black);
    }

    public TextBox(TextBlock textBlock) {
        this.textBlock = textBlock;
    }

    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }

    public void setOutlinePaint(Paint paint) {
        this.outlinePaint = paint;
    }

    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }

    public void setOutlineStroke(Stroke stroke) {
        this.outlineStroke = stroke;
    }

    public RectangleInsets getInteriorGap() {
        return this.interiorGap;
    }

    public void setInteriorGap(RectangleInsets rectangleInsets) {
        this.interiorGap = rectangleInsets;
    }

    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }

    public void setBackgroundPaint(Paint paint) {
        this.backgroundPaint = paint;
    }

    public Paint getShadowPaint() {
        return this.shadowPaint;
    }

    public void setShadowPaint(Paint paint) {
        this.shadowPaint = paint;
    }

    public double getShadowXOffset() {
        return this.shadowXOffset;
    }

    public void setShadowXOffset(double d2) {
        this.shadowXOffset = d2;
    }

    public double getShadowYOffset() {
        return this.shadowYOffset;
    }

    public void setShadowYOffset(double d2) {
        this.shadowYOffset = d2;
    }

    public TextBlock getTextBlock() {
        return this.textBlock;
    }

    public void setTextBlock(TextBlock textBlock) {
        this.textBlock = textBlock;
    }

    public void draw(Graphics2D graphics2D, float f2, float f3, RectangleAnchor rectangleAnchor) {
        Size2D size2D = this.textBlock.calculateDimensions(graphics2D);
        double d2 = this.interiorGap.extendWidth(size2D.getWidth());
        double d3 = this.interiorGap.extendHeight(size2D.getHeight());
        Size2D size2D2 = new Size2D(d2, d3);
        Rectangle2D rectangle2D = RectangleAnchor.createRectangle(size2D2, f2, f3, rectangleAnchor);
        if (this.shadowPaint != null) {
            Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D.getX() + this.shadowXOffset, rectangle2D.getY() + this.shadowYOffset, rectangle2D.getWidth(), rectangle2D.getHeight());
            graphics2D.setPaint(this.shadowPaint);
            graphics2D.fill(double_);
        }
        if (this.backgroundPaint != null) {
            graphics2D.setPaint(this.backgroundPaint);
            graphics2D.fill(rectangle2D);
        }
        if (this.outlinePaint != null && this.outlineStroke != null) {
            graphics2D.setPaint(this.outlinePaint);
            graphics2D.setStroke(this.outlineStroke);
            graphics2D.draw(rectangle2D);
        }
        this.textBlock.draw(graphics2D, (float)rectangle2D.getCenterX(), (float)rectangle2D.getCenterY(), TextBlockAnchor.CENTER);
    }

    public double getHeight(Graphics2D graphics2D) {
        Size2D size2D = this.textBlock.calculateDimensions(graphics2D);
        return this.interiorGap.extendHeight(size2D.getHeight());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TextBox)) {
            return false;
        }
        TextBox textBox = (TextBox)object;
        if (!ObjectUtilities.equal(this.outlinePaint, textBox.outlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.outlineStroke, textBox.outlineStroke)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.interiorGap, textBox.interiorGap)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundPaint, textBox.backgroundPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.shadowPaint, textBox.shadowPaint)) {
            return false;
        }
        if (this.shadowXOffset != textBox.shadowXOffset) {
            return false;
        }
        if (this.shadowYOffset != textBox.shadowYOffset) {
            return false;
        }
        if (ObjectUtilities.equal(this.textBlock, textBox.textBlock)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.outlinePaint != null ? this.outlinePaint.hashCode() : 0;
        n2 = 29 * n2 + (this.outlineStroke != null ? this.outlineStroke.hashCode() : 0);
        n2 = 29 * n2 + (this.interiorGap != null ? this.interiorGap.hashCode() : 0);
        n2 = 29 * n2 + (this.backgroundPaint != null ? this.backgroundPaint.hashCode() : 0);
        n2 = 29 * n2 + (this.shadowPaint != null ? this.shadowPaint.hashCode() : 0);
        long l2 = this.shadowXOffset != 0.0 ? Double.doubleToLongBits(this.shadowXOffset) : 0;
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = this.shadowYOffset != 0.0 ? Double.doubleToLongBits(this.shadowYOffset) : 0;
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        return 29 * n2 + (this.textBlock != null ? this.textBlock.hashCode() : 0);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
        SerialUtilities.writePaint(this.shadowPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.shadowPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

