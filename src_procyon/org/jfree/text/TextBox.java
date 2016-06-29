package org.jfree.text;

import org.jfree.ui.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class TextBox implements Serializable
{
    private static final long serialVersionUID = 3360220213180203706L;
    private transient Paint outlinePaint;
    private transient Stroke outlineStroke;
    private RectangleInsets interiorGap;
    private transient Paint backgroundPaint;
    private transient Paint shadowPaint;
    private double shadowXOffset;
    private double shadowYOffset;
    private TextBlock textBlock;
    
    public TextBox() {
        this((TextBlock)null);
    }
    
    public TextBox(final String s) {
        this((TextBlock)null);
        if (s != null) {
            (this.textBlock = new TextBlock()).addLine(s, new Font("SansSerif", 0, 10), Color.black);
        }
    }
    
    public TextBox(final TextBlock textBlock) {
        this.shadowXOffset = 2.0;
        this.shadowYOffset = 2.0;
        this.outlinePaint = Color.black;
        this.outlineStroke = new BasicStroke(1.0f);
        this.interiorGap = new RectangleInsets(1.0, 3.0, 1.0, 3.0);
        this.backgroundPaint = new Color(255, 255, 192);
        this.shadowPaint = Color.gray;
        this.shadowXOffset = 2.0;
        this.shadowYOffset = 2.0;
        this.textBlock = textBlock;
    }
    
    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }
    
    public void setOutlinePaint(final Paint outlinePaint) {
        this.outlinePaint = outlinePaint;
    }
    
    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }
    
    public void setOutlineStroke(final Stroke outlineStroke) {
        this.outlineStroke = outlineStroke;
    }
    
    public RectangleInsets getInteriorGap() {
        return this.interiorGap;
    }
    
    public void setInteriorGap(final RectangleInsets interiorGap) {
        this.interiorGap = interiorGap;
    }
    
    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }
    
    public void setBackgroundPaint(final Paint backgroundPaint) {
        this.backgroundPaint = backgroundPaint;
    }
    
    public Paint getShadowPaint() {
        return this.shadowPaint;
    }
    
    public void setShadowPaint(final Paint shadowPaint) {
        this.shadowPaint = shadowPaint;
    }
    
    public double getShadowXOffset() {
        return this.shadowXOffset;
    }
    
    public void setShadowXOffset(final double shadowXOffset) {
        this.shadowXOffset = shadowXOffset;
    }
    
    public double getShadowYOffset() {
        return this.shadowYOffset;
    }
    
    public void setShadowYOffset(final double shadowYOffset) {
        this.shadowYOffset = shadowYOffset;
    }
    
    public TextBlock getTextBlock() {
        return this.textBlock;
    }
    
    public void setTextBlock(final TextBlock textBlock) {
        this.textBlock = textBlock;
    }
    
    public void draw(final Graphics2D graphics2D, final float n, final float n2, final RectangleAnchor rectangleAnchor) {
        final Size2D calculateDimensions = this.textBlock.calculateDimensions(graphics2D);
        final Rectangle2D rectangle = RectangleAnchor.createRectangle(new Size2D(this.interiorGap.extendWidth(calculateDimensions.getWidth()), this.interiorGap.extendHeight(calculateDimensions.getHeight())), n, n2, rectangleAnchor);
        if (this.shadowPaint != null) {
            final Rectangle2D.Double double1 = new Rectangle2D.Double(rectangle.getX() + this.shadowXOffset, rectangle.getY() + this.shadowYOffset, rectangle.getWidth(), rectangle.getHeight());
            graphics2D.setPaint(this.shadowPaint);
            graphics2D.fill(double1);
        }
        if (this.backgroundPaint != null) {
            graphics2D.setPaint(this.backgroundPaint);
            graphics2D.fill(rectangle);
        }
        if (this.outlinePaint != null && this.outlineStroke != null) {
            graphics2D.setPaint(this.outlinePaint);
            graphics2D.setStroke(this.outlineStroke);
            graphics2D.draw(rectangle);
        }
        this.textBlock.draw(graphics2D, (float)rectangle.getCenterX(), (float)rectangle.getCenterY(), TextBlockAnchor.CENTER);
    }
    
    public double getHeight(final Graphics2D graphics2D) {
        return this.interiorGap.extendHeight(this.textBlock.calculateDimensions(graphics2D).getHeight());
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TextBox)) {
            return false;
        }
        final TextBox textBox = (TextBox)o;
        return ObjectUtilities.equal(this.outlinePaint, textBox.outlinePaint) && ObjectUtilities.equal(this.outlineStroke, textBox.outlineStroke) && ObjectUtilities.equal(this.interiorGap, textBox.interiorGap) && ObjectUtilities.equal(this.backgroundPaint, textBox.backgroundPaint) && ObjectUtilities.equal(this.shadowPaint, textBox.shadowPaint) && this.shadowXOffset == textBox.shadowXOffset && this.shadowYOffset == textBox.shadowYOffset && ObjectUtilities.equal(this.textBlock, textBox.textBlock);
    }
    
    public int hashCode() {
        final int n = 29 * (29 * (29 * (29 * ((this.outlinePaint != null) ? this.outlinePaint.hashCode() : 0) + ((this.outlineStroke != null) ? this.outlineStroke.hashCode() : 0)) + ((this.interiorGap != null) ? this.interiorGap.hashCode() : 0)) + ((this.backgroundPaint != null) ? this.backgroundPaint.hashCode() : 0)) + ((this.shadowPaint != null) ? this.shadowPaint.hashCode() : 0);
        final long n2 = (this.shadowXOffset != 0.0) ? Double.doubleToLongBits(this.shadowXOffset) : 0L;
        final int n3 = 29 * n + (int)(n2 ^ n2 >>> 32);
        final long n4 = (this.shadowYOffset != 0.0) ? Double.doubleToLongBits(this.shadowYOffset) : 0L;
        return 29 * (29 * n3 + (int)(n4 ^ n4 >>> 32)) + ((this.textBlock != null) ? this.textBlock.hashCode() : 0);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
        SerialUtilities.writePaint(this.shadowPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.shadowPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
