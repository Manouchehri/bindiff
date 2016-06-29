package org.jfree.chart.block;

import org.jfree.ui.*;
import java.awt.geom.*;
import org.jfree.text.*;
import org.jfree.chart.entity.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.*;

public class LabelBlock extends AbstractBlock implements Block, PublicCloneable
{
    private String text;
    private TextBlock label;
    private Font font;
    private String toolTipText;
    private String urlText;
    public static final Paint DEFAULT_PAINT;
    private transient Paint paint;
    
    public LabelBlock(final String s) {
        this(s, new Font("SansSerif", 0, 10), LabelBlock.DEFAULT_PAINT);
    }
    
    public LabelBlock(final String s, final Font font) {
        this(s, font, LabelBlock.DEFAULT_PAINT);
    }
    
    public LabelBlock(final String text, final Font font, final Paint paint) {
        this.text = text;
        this.paint = paint;
        this.label = TextUtilities.createTextBlock(text, font, this.paint);
        this.font = font;
        this.toolTipText = null;
        this.urlText = null;
    }
    
    public Font getFont() {
        return this.font;
    }
    
    public void setFont(final Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.font = font;
        this.label = TextUtilities.createTextBlock(this.text, font, this.paint);
    }
    
    public Paint getPaint() {
        return this.paint;
    }
    
    public void setPaint(final Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
        this.label = TextUtilities.createTextBlock(this.text, this.font, this.paint);
    }
    
    public String getToolTipText() {
        return this.toolTipText;
    }
    
    public void setToolTipText(final String toolTipText) {
        this.toolTipText = toolTipText;
    }
    
    public String getURLText() {
        return this.urlText;
    }
    
    public void setURLText(final String urlText) {
        this.urlText = urlText;
    }
    
    public Size2D arrange(final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        graphics2D.setFont(this.font);
        final Size2D calculateDimensions = this.label.calculateDimensions(graphics2D);
        return new Size2D(this.calculateTotalWidth(calculateDimensions.getWidth()), this.calculateTotalHeight(calculateDimensions.getHeight()));
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null);
    }
    
    public Object draw(final Graphics2D graphics2D, Rectangle2D rectangle2D, final Object o) {
        rectangle2D = this.trimMargin(rectangle2D);
        this.drawBorder(graphics2D, rectangle2D);
        rectangle2D = this.trimBorder(rectangle2D);
        rectangle2D = this.trimPadding(rectangle2D);
        EntityBlockParams entityBlockParams = null;
        StandardEntityCollection entityCollection = null;
        Shape shape = null;
        if (o instanceof EntityBlockParams) {
            entityBlockParams = (EntityBlockParams)o;
            if (entityBlockParams.getGenerateEntities()) {
                entityCollection = new StandardEntityCollection();
                shape = (Shape)rectangle2D.clone();
            }
        }
        graphics2D.setPaint(this.paint);
        graphics2D.setFont(this.font);
        this.label.draw(graphics2D, (float)rectangle2D.getX(), (float)rectangle2D.getY(), TextBlockAnchor.TOP_LEFT);
        BlockResult blockResult = null;
        if (entityBlockParams != null && entityCollection != null && (this.toolTipText != null || this.urlText != null)) {
            entityCollection.add(new ChartEntity(shape, this.toolTipText, this.urlText));
            blockResult = new BlockResult();
            blockResult.setEntityCollection(entityCollection);
        }
        return blockResult;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof LabelBlock)) {
            return false;
        }
        final LabelBlock labelBlock = (LabelBlock)o;
        return this.text.equals(labelBlock.text) && this.font.equals(labelBlock.font) && PaintUtilities.equal(this.paint, labelBlock.paint) && ObjectUtilities.equal(this.toolTipText, labelBlock.toolTipText) && ObjectUtilities.equal(this.urlText, labelBlock.urlText) && super.equals(o);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static {
        DEFAULT_PAINT = Color.black;
    }
}
