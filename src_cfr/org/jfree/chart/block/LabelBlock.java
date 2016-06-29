/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.chart.block.AbstractBlock;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockResult;
import org.jfree.chart.block.EntityBlockParams;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.text.TextUtilities;
import org.jfree.ui.Size2D;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class LabelBlock
extends AbstractBlock
implements Block,
PublicCloneable {
    private String text;
    private TextBlock label;
    private Font font;
    private String toolTipText;
    private String urlText;
    public static final Paint DEFAULT_PAINT = Color.black;
    private transient Paint paint;

    public LabelBlock(String string) {
        this(string, new Font("SansSerif", 0, 10), DEFAULT_PAINT);
    }

    public LabelBlock(String string, Font font) {
        this(string, font, DEFAULT_PAINT);
    }

    public LabelBlock(String string, Font font, Paint paint) {
        this.text = string;
        this.paint = paint;
        this.label = TextUtilities.createTextBlock(string, font, this.paint);
        this.font = font;
        this.toolTipText = null;
        this.urlText = null;
    }

    public Font getFont() {
        return this.font;
    }

    public void setFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.font = font;
        this.label = TextUtilities.createTextBlock(this.text, font, this.paint);
    }

    public Paint getPaint() {
        return this.paint;
    }

    public void setPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
        this.label = TextUtilities.createTextBlock(this.text, this.font, this.paint);
    }

    public String getToolTipText() {
        return this.toolTipText;
    }

    public void setToolTipText(String string) {
        this.toolTipText = string;
    }

    public String getURLText() {
        return this.urlText;
    }

    public void setURLText(String string) {
        this.urlText = string;
    }

    @Override
    public Size2D arrange(Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        graphics2D.setFont(this.font);
        Size2D size2D = this.label.calculateDimensions(graphics2D);
        return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null);
    }

    @Override
    public Object draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Object object) {
        rectangle2D = this.trimMargin(rectangle2D);
        this.drawBorder(graphics2D, rectangle2D);
        rectangle2D = this.trimBorder(rectangle2D);
        rectangle2D = this.trimPadding(rectangle2D);
        EntityBlockParams entityBlockParams = null;
        StandardEntityCollection standardEntityCollection = null;
        Shape shape = null;
        if (object instanceof EntityBlockParams && (entityBlockParams = (EntityBlockParams)object).getGenerateEntities()) {
            standardEntityCollection = new StandardEntityCollection();
            shape = (Shape)rectangle2D.clone();
        }
        graphics2D.setPaint(this.paint);
        graphics2D.setFont(this.font);
        this.label.draw(graphics2D, (float)rectangle2D.getX(), (float)rectangle2D.getY(), TextBlockAnchor.TOP_LEFT);
        BlockResult blockResult = null;
        if (entityBlockParams == null) return blockResult;
        if (standardEntityCollection == null) return blockResult;
        if (this.toolTipText == null) {
            if (this.urlText == null) return blockResult;
        }
        ChartEntity chartEntity = new ChartEntity(shape, this.toolTipText, this.urlText);
        standardEntityCollection.add(chartEntity);
        blockResult = new BlockResult();
        blockResult.setEntityCollection(standardEntityCollection);
        return blockResult;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof LabelBlock)) {
            return false;
        }
        LabelBlock labelBlock = (LabelBlock)object;
        if (!this.text.equals(labelBlock.text)) {
            return false;
        }
        if (!this.font.equals(labelBlock.font)) {
            return false;
        }
        if (!PaintUtilities.equal(this.paint, labelBlock.paint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.toolTipText, labelBlock.toolTipText)) {
            return false;
        }
        if (ObjectUtilities.equal(this.urlText, labelBlock.urlText)) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
    }
}

