/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.title;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.block.BlockResult;
import org.jfree.chart.block.EntityBlockParams;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.event.TitleChangeEvent;
import org.jfree.chart.title.Title;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.text.G2TextMeasurer;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.text.TextUtilities;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.ui.VerticalAlignment;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class TextTitle
extends Title
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 8372008692127477443L;
    public static final Font DEFAULT_FONT = new Font("SansSerif", 1, 12);
    public static final Paint DEFAULT_TEXT_PAINT = Color.black;
    private String text;
    private Font font;
    private HorizontalAlignment textAlignment;
    private transient Paint paint;
    private transient Paint backgroundPaint;
    private String toolTipText;
    private String urlText;
    private TextBlock content;
    private boolean expandToFitSpace = false;

    public TextTitle() {
        this("");
    }

    public TextTitle(String string) {
        this(string, DEFAULT_FONT, DEFAULT_TEXT_PAINT, Title.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT, Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING);
    }

    public TextTitle(String string, Font font) {
        this(string, font, DEFAULT_TEXT_PAINT, Title.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT, Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING);
    }

    public TextTitle(String string, Font font, Paint paint, RectangleEdge rectangleEdge, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, RectangleInsets rectangleInsets) {
        super(rectangleEdge, horizontalAlignment, verticalAlignment, rectangleInsets);
        if (string == null) {
            throw new NullPointerException("Null 'text' argument.");
        }
        if (font == null) {
            throw new NullPointerException("Null 'font' argument.");
        }
        if (paint == null) {
            throw new NullPointerException("Null 'paint' argument.");
        }
        this.text = string;
        this.font = font;
        this.paint = paint;
        this.textAlignment = horizontalAlignment;
        this.backgroundPaint = null;
        this.content = null;
        this.toolTipText = null;
        this.urlText = null;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String string) {
        if (string == null) {
            throw new NullPointerException("Null 'text' argument.");
        }
        if (this.text.equals(string)) return;
        this.text = string;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public HorizontalAlignment getTextAlignment() {
        return this.textAlignment;
    }

    public void setTextAlignment(HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment == null) {
            throw new IllegalArgumentException("Null 'alignment' argument.");
        }
        this.textAlignment = horizontalAlignment;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public Font getFont() {
        return this.font;
    }

    public void setFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (this.font.equals(font)) return;
        this.font = font;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public Paint getPaint() {
        return this.paint;
    }

    public void setPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        if (this.paint.equals(paint)) return;
        this.paint = paint;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }

    public void setBackgroundPaint(Paint paint) {
        this.backgroundPaint = paint;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public String getToolTipText() {
        return this.toolTipText;
    }

    public void setToolTipText(String string) {
        this.toolTipText = string;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public String getURLText() {
        return this.urlText;
    }

    public void setURLText(String string) {
        this.urlText = string;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public boolean getExpandToFitSpace() {
        return this.expandToFitSpace;
    }

    public void setExpandToFitSpace(boolean bl2) {
        this.expandToFitSpace = bl2;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    @Override
    public Size2D arrange(Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        RectangleConstraint rectangleConstraint2 = this.toContentConstraint(rectangleConstraint);
        LengthConstraintType lengthConstraintType = rectangleConstraint2.getWidthConstraintType();
        LengthConstraintType lengthConstraintType2 = rectangleConstraint2.getHeightConstraintType();
        Size2D size2D = null;
        if (lengthConstraintType == LengthConstraintType.NONE) {
            if (lengthConstraintType2 == LengthConstraintType.NONE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (lengthConstraintType2 == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (lengthConstraintType2 != LengthConstraintType.FIXED) return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
            throw new RuntimeException("Not yet implemented.");
        }
        if (lengthConstraintType == LengthConstraintType.RANGE) {
            if (lengthConstraintType2 == LengthConstraintType.NONE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (lengthConstraintType2 == LengthConstraintType.RANGE) {
                size2D = this.arrangeRR(graphics2D, rectangleConstraint2.getWidthRange(), rectangleConstraint2.getHeightRange());
                return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
            }
            if (lengthConstraintType2 != LengthConstraintType.FIXED) return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
            throw new RuntimeException("Not yet implemented.");
        }
        if (lengthConstraintType != LengthConstraintType.FIXED) return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
        if (lengthConstraintType2 == LengthConstraintType.NONE) {
            throw new RuntimeException("Not yet implemented.");
        }
        if (lengthConstraintType2 == LengthConstraintType.RANGE) {
            throw new RuntimeException("Not yet implemented.");
        }
        if (lengthConstraintType2 != LengthConstraintType.FIXED) return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
        throw new RuntimeException("Not yet implemented.");
    }

    protected Size2D arrangeRR(Graphics2D graphics2D, Range range, Range range2) {
        RectangleEdge rectangleEdge = this.getPosition();
        if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
            float f2 = (float)range.getUpperBound();
            graphics2D.setFont(this.font);
            this.content = TextUtilities.createTextBlock(this.text, this.font, this.paint, f2, new G2TextMeasurer(graphics2D));
            this.content.setLineAlignment(this.textAlignment);
            Size2D size2D = this.content.calculateDimensions(graphics2D);
            if (!this.expandToFitSpace) return size2D;
            return new Size2D(f2, size2D.getHeight());
        }
        if (rectangleEdge != RectangleEdge.LEFT) {
            if (rectangleEdge != RectangleEdge.RIGHT) throw new RuntimeException("Unrecognised exception.");
        }
        float f3 = (float)range2.getUpperBound();
        graphics2D.setFont(this.font);
        this.content = TextUtilities.createTextBlock(this.text, this.font, this.paint, f3, new G2TextMeasurer(graphics2D));
        this.content.setLineAlignment(this.textAlignment);
        Size2D size2D = this.content.calculateDimensions(graphics2D);
        if (!this.expandToFitSpace) return new Size2D(size2D.height, size2D.width);
        return new Size2D(size2D.getHeight(), f3);
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null);
    }

    @Override
    public Object draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Object object) {
        Object object2;
        if (this.content == null) {
            return null;
        }
        rectangle2D = this.trimMargin(rectangle2D);
        this.drawBorder(graphics2D, rectangle2D);
        if (this.text.equals("")) {
            return null;
        }
        ChartEntity chartEntity = null;
        if (object instanceof EntityBlockParams && (object2 = (EntityBlockParams)object).getGenerateEntities()) {
            chartEntity = new ChartEntity(rectangle2D, this.toolTipText, this.urlText);
        }
        rectangle2D = this.trimBorder(rectangle2D);
        if (this.backgroundPaint != null) {
            graphics2D.setPaint(this.backgroundPaint);
            graphics2D.fill(rectangle2D);
        }
        rectangle2D = this.trimPadding(rectangle2D);
        object2 = this.getPosition();
        if (object2 == RectangleEdge.TOP || object2 == RectangleEdge.BOTTOM) {
            this.drawHorizontal(graphics2D, rectangle2D);
        } else if (object2 == RectangleEdge.LEFT || object2 == RectangleEdge.RIGHT) {
            this.drawVertical(graphics2D, rectangle2D);
        }
        BlockResult blockResult = new BlockResult();
        if (chartEntity == null) return blockResult;
        StandardEntityCollection standardEntityCollection = new StandardEntityCollection();
        standardEntityCollection.add(chartEntity);
        blockResult.setEntityCollection(standardEntityCollection);
        return blockResult;
    }

    protected void drawHorizontal(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        Rectangle2D rectangle2D2 = (Rectangle2D)rectangle2D.clone();
        graphics2D.setFont(this.font);
        graphics2D.setPaint(this.paint);
        TextBlockAnchor textBlockAnchor = null;
        float f2 = 0.0f;
        HorizontalAlignment horizontalAlignment = this.getHorizontalAlignment();
        if (horizontalAlignment == HorizontalAlignment.LEFT) {
            f2 = (float)rectangle2D2.getX();
            textBlockAnchor = TextBlockAnchor.TOP_LEFT;
        } else if (horizontalAlignment == HorizontalAlignment.RIGHT) {
            f2 = (float)rectangle2D2.getMaxX();
            textBlockAnchor = TextBlockAnchor.TOP_RIGHT;
        } else if (horizontalAlignment == HorizontalAlignment.CENTER) {
            f2 = (float)rectangle2D2.getCenterX();
            textBlockAnchor = TextBlockAnchor.TOP_CENTER;
        }
        float f3 = 0.0f;
        RectangleEdge rectangleEdge = this.getPosition();
        if (rectangleEdge == RectangleEdge.TOP) {
            f3 = (float)rectangle2D2.getY();
        } else if (rectangleEdge == RectangleEdge.BOTTOM) {
            f3 = (float)rectangle2D2.getMaxY();
            if (horizontalAlignment == HorizontalAlignment.LEFT) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_LEFT;
            } else if (horizontalAlignment == HorizontalAlignment.CENTER) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_CENTER;
            } else if (horizontalAlignment == HorizontalAlignment.RIGHT) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_RIGHT;
            }
        }
        this.content.draw(graphics2D, f2, f3, textBlockAnchor);
    }

    protected void drawVertical(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        Rectangle2D rectangle2D2 = (Rectangle2D)rectangle2D.clone();
        graphics2D.setFont(this.font);
        graphics2D.setPaint(this.paint);
        TextBlockAnchor textBlockAnchor = null;
        float f2 = 0.0f;
        VerticalAlignment verticalAlignment = this.getVerticalAlignment();
        if (verticalAlignment == VerticalAlignment.TOP) {
            f2 = (float)rectangle2D2.getY();
            textBlockAnchor = TextBlockAnchor.TOP_RIGHT;
        } else if (verticalAlignment == VerticalAlignment.BOTTOM) {
            f2 = (float)rectangle2D2.getMaxY();
            textBlockAnchor = TextBlockAnchor.TOP_LEFT;
        } else if (verticalAlignment == VerticalAlignment.CENTER) {
            f2 = (float)rectangle2D2.getCenterY();
            textBlockAnchor = TextBlockAnchor.TOP_CENTER;
        }
        float f3 = 0.0f;
        RectangleEdge rectangleEdge = this.getPosition();
        if (rectangleEdge == RectangleEdge.LEFT) {
            f3 = (float)rectangle2D2.getX();
        } else if (rectangleEdge == RectangleEdge.RIGHT) {
            f3 = (float)rectangle2D2.getMaxX();
            if (verticalAlignment == VerticalAlignment.TOP) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_RIGHT;
            } else if (verticalAlignment == VerticalAlignment.CENTER) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_CENTER;
            } else if (verticalAlignment == VerticalAlignment.BOTTOM) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_LEFT;
            }
        }
        this.content.draw(graphics2D, f3, f2, textBlockAnchor, f3, f2, -1.5707963267948966);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TextTitle)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        TextTitle textTitle = (TextTitle)object;
        if (!ObjectUtilities.equal(this.text, textTitle.text)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.font, textTitle.font)) {
            return false;
        }
        if (!PaintUtilities.equal(this.paint, textTitle.paint)) {
            return false;
        }
        if (this.textAlignment != textTitle.textAlignment) {
            return false;
        }
        if (PaintUtilities.equal(this.backgroundPaint, textTitle.backgroundPaint)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 29 * n2 + (this.text != null ? this.text.hashCode() : 0);
        n2 = 29 * n2 + (this.font != null ? this.font.hashCode() : 0);
        n2 = 29 * n2 + (this.paint != null ? this.paint.hashCode() : 0);
        return 29 * n2 + (this.backgroundPaint != null ? this.backgroundPaint.hashCode() : 0);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

