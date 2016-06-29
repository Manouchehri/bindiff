package org.jfree.chart.title;

import org.jfree.chart.event.*;
import org.jfree.ui.*;
import org.jfree.data.*;
import java.awt.geom.*;
import org.jfree.chart.block.*;
import org.jfree.chart.entity.*;
import org.jfree.text.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.*;

public class TextTitle extends Title implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 8372008692127477443L;
    public static final Font DEFAULT_FONT;
    public static final Paint DEFAULT_TEXT_PAINT;
    private String text;
    private Font font;
    private HorizontalAlignment textAlignment;
    private transient Paint paint;
    private transient Paint backgroundPaint;
    private String toolTipText;
    private String urlText;
    private TextBlock content;
    private boolean expandToFitSpace;
    
    public TextTitle() {
        this("");
    }
    
    public TextTitle(final String s) {
        this(s, TextTitle.DEFAULT_FONT, TextTitle.DEFAULT_TEXT_PAINT, Title.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT, Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING);
    }
    
    public TextTitle(final String s, final Font font) {
        this(s, font, TextTitle.DEFAULT_TEXT_PAINT, Title.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT, Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING);
    }
    
    public TextTitle(final String text, final Font font, final Paint paint, final RectangleEdge rectangleEdge, final HorizontalAlignment textAlignment, final VerticalAlignment verticalAlignment, final RectangleInsets rectangleInsets) {
        super(rectangleEdge, textAlignment, verticalAlignment, rectangleInsets);
        this.expandToFitSpace = false;
        if (text == null) {
            throw new NullPointerException("Null 'text' argument.");
        }
        if (font == null) {
            throw new NullPointerException("Null 'font' argument.");
        }
        if (paint == null) {
            throw new NullPointerException("Null 'paint' argument.");
        }
        this.text = text;
        this.font = font;
        this.paint = paint;
        this.textAlignment = textAlignment;
        this.backgroundPaint = null;
        this.content = null;
        this.toolTipText = null;
        this.urlText = null;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(final String text) {
        if (text == null) {
            throw new NullPointerException("Null 'text' argument.");
        }
        if (!this.text.equals(text)) {
            this.text = text;
            this.notifyListeners(new TitleChangeEvent(this));
        }
    }
    
    public HorizontalAlignment getTextAlignment() {
        return this.textAlignment;
    }
    
    public void setTextAlignment(final HorizontalAlignment textAlignment) {
        if (textAlignment == null) {
            throw new IllegalArgumentException("Null 'alignment' argument.");
        }
        this.textAlignment = textAlignment;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public Font getFont() {
        return this.font;
    }
    
    public void setFont(final Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (!this.font.equals(font)) {
            this.font = font;
            this.notifyListeners(new TitleChangeEvent(this));
        }
    }
    
    public Paint getPaint() {
        return this.paint;
    }
    
    public void setPaint(final Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        if (!this.paint.equals(paint)) {
            this.paint = paint;
            this.notifyListeners(new TitleChangeEvent(this));
        }
    }
    
    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }
    
    public void setBackgroundPaint(final Paint backgroundPaint) {
        this.backgroundPaint = backgroundPaint;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public String getToolTipText() {
        return this.toolTipText;
    }
    
    public void setToolTipText(final String toolTipText) {
        this.toolTipText = toolTipText;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public String getURLText() {
        return this.urlText;
    }
    
    public void setURLText(final String urlText) {
        this.urlText = urlText;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public boolean getExpandToFitSpace() {
        return this.expandToFitSpace;
    }
    
    public void setExpandToFitSpace(final boolean expandToFitSpace) {
        this.expandToFitSpace = expandToFitSpace;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public Size2D arrange(final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final RectangleConstraint contentConstraint = this.toContentConstraint(rectangleConstraint);
        final LengthConstraintType widthConstraintType = contentConstraint.getWidthConstraintType();
        final LengthConstraintType heightConstraintType = contentConstraint.getHeightConstraintType();
        Size2D arrangeRR = null;
        if (widthConstraintType == LengthConstraintType.NONE) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                throw new RuntimeException("Not yet implemented.");
            }
        }
        else if (widthConstraintType == LengthConstraintType.RANGE) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                arrangeRR = this.arrangeRR(graphics2D, contentConstraint.getWidthRange(), contentConstraint.getHeightRange());
            }
            else if (heightConstraintType == LengthConstraintType.FIXED) {
                throw new RuntimeException("Not yet implemented.");
            }
        }
        else if (widthConstraintType == LengthConstraintType.FIXED) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                throw new RuntimeException("Not yet implemented.");
            }
        }
        return new Size2D(this.calculateTotalWidth(arrangeRR.getWidth()), this.calculateTotalHeight(arrangeRR.getHeight()));
    }
    
    protected Size2D arrangeRR(final Graphics2D graphics2D, final Range range, final Range range2) {
        final RectangleEdge position = this.getPosition();
        if (position == RectangleEdge.TOP || position == RectangleEdge.BOTTOM) {
            final float n = (float)range.getUpperBound();
            graphics2D.setFont(this.font);
            (this.content = TextUtilities.createTextBlock(this.text, this.font, this.paint, n, new G2TextMeasurer(graphics2D))).setLineAlignment(this.textAlignment);
            final Size2D calculateDimensions = this.content.calculateDimensions(graphics2D);
            if (this.expandToFitSpace) {
                return new Size2D(n, calculateDimensions.getHeight());
            }
            return calculateDimensions;
        }
        else {
            if (position != RectangleEdge.LEFT && position != RectangleEdge.RIGHT) {
                throw new RuntimeException("Unrecognised exception.");
            }
            final float n2 = (float)range2.getUpperBound();
            graphics2D.setFont(this.font);
            (this.content = TextUtilities.createTextBlock(this.text, this.font, this.paint, n2, new G2TextMeasurer(graphics2D))).setLineAlignment(this.textAlignment);
            final Size2D calculateDimensions2 = this.content.calculateDimensions(graphics2D);
            if (this.expandToFitSpace) {
                return new Size2D(calculateDimensions2.getHeight(), n2);
            }
            return new Size2D(calculateDimensions2.height, calculateDimensions2.width);
        }
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, null);
    }
    
    public Object draw(final Graphics2D graphics2D, Rectangle2D rectangle2D, final Object o) {
        if (this.content == null) {
            return null;
        }
        rectangle2D = this.trimMargin(rectangle2D);
        this.drawBorder(graphics2D, rectangle2D);
        if (this.text.equals("")) {
            return null;
        }
        ChartEntity chartEntity = null;
        if (o instanceof EntityBlockParams && ((EntityBlockParams)o).getGenerateEntities()) {
            chartEntity = new ChartEntity(rectangle2D, this.toolTipText, this.urlText);
        }
        rectangle2D = this.trimBorder(rectangle2D);
        if (this.backgroundPaint != null) {
            graphics2D.setPaint(this.backgroundPaint);
            graphics2D.fill(rectangle2D);
        }
        rectangle2D = this.trimPadding(rectangle2D);
        final RectangleEdge position = this.getPosition();
        if (position == RectangleEdge.TOP || position == RectangleEdge.BOTTOM) {
            this.drawHorizontal(graphics2D, rectangle2D);
        }
        else if (position == RectangleEdge.LEFT || position == RectangleEdge.RIGHT) {
            this.drawVertical(graphics2D, rectangle2D);
        }
        final BlockResult blockResult = new BlockResult();
        if (chartEntity != null) {
            final StandardEntityCollection entityCollection = new StandardEntityCollection();
            entityCollection.add(chartEntity);
            blockResult.setEntityCollection(entityCollection);
        }
        return blockResult;
    }
    
    protected void drawHorizontal(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final Rectangle2D rectangle2D2 = (Rectangle2D)rectangle2D.clone();
        graphics2D.setFont(this.font);
        graphics2D.setPaint(this.paint);
        TextBlockAnchor textBlockAnchor = null;
        float n = 0.0f;
        final HorizontalAlignment horizontalAlignment = this.getHorizontalAlignment();
        if (horizontalAlignment == HorizontalAlignment.LEFT) {
            n = (float)rectangle2D2.getX();
            textBlockAnchor = TextBlockAnchor.TOP_LEFT;
        }
        else if (horizontalAlignment == HorizontalAlignment.RIGHT) {
            n = (float)rectangle2D2.getMaxX();
            textBlockAnchor = TextBlockAnchor.TOP_RIGHT;
        }
        else if (horizontalAlignment == HorizontalAlignment.CENTER) {
            n = (float)rectangle2D2.getCenterX();
            textBlockAnchor = TextBlockAnchor.TOP_CENTER;
        }
        float n2 = 0.0f;
        final RectangleEdge position = this.getPosition();
        if (position == RectangleEdge.TOP) {
            n2 = (float)rectangle2D2.getY();
        }
        else if (position == RectangleEdge.BOTTOM) {
            n2 = (float)rectangle2D2.getMaxY();
            if (horizontalAlignment == HorizontalAlignment.LEFT) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_LEFT;
            }
            else if (horizontalAlignment == HorizontalAlignment.CENTER) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_CENTER;
            }
            else if (horizontalAlignment == HorizontalAlignment.RIGHT) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_RIGHT;
            }
        }
        this.content.draw(graphics2D, n, n2, textBlockAnchor);
    }
    
    protected void drawVertical(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final Rectangle2D rectangle2D2 = (Rectangle2D)rectangle2D.clone();
        graphics2D.setFont(this.font);
        graphics2D.setPaint(this.paint);
        TextBlockAnchor textBlockAnchor = null;
        float n = 0.0f;
        final VerticalAlignment verticalAlignment = this.getVerticalAlignment();
        if (verticalAlignment == VerticalAlignment.TOP) {
            n = (float)rectangle2D2.getY();
            textBlockAnchor = TextBlockAnchor.TOP_RIGHT;
        }
        else if (verticalAlignment == VerticalAlignment.BOTTOM) {
            n = (float)rectangle2D2.getMaxY();
            textBlockAnchor = TextBlockAnchor.TOP_LEFT;
        }
        else if (verticalAlignment == VerticalAlignment.CENTER) {
            n = (float)rectangle2D2.getCenterY();
            textBlockAnchor = TextBlockAnchor.TOP_CENTER;
        }
        float n2 = 0.0f;
        final RectangleEdge position = this.getPosition();
        if (position == RectangleEdge.LEFT) {
            n2 = (float)rectangle2D2.getX();
        }
        else if (position == RectangleEdge.RIGHT) {
            n2 = (float)rectangle2D2.getMaxX();
            if (verticalAlignment == VerticalAlignment.TOP) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_RIGHT;
            }
            else if (verticalAlignment == VerticalAlignment.CENTER) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_CENTER;
            }
            else if (verticalAlignment == VerticalAlignment.BOTTOM) {
                textBlockAnchor = TextBlockAnchor.BOTTOM_LEFT;
            }
        }
        this.content.draw(graphics2D, n2, n, textBlockAnchor, n2, n, -1.5707963267948966);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TextTitle)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final TextTitle textTitle = (TextTitle)o;
        return ObjectUtilities.equal(this.text, textTitle.text) && ObjectUtilities.equal(this.font, textTitle.font) && PaintUtilities.equal(this.paint, textTitle.paint) && this.textAlignment == textTitle.textAlignment && PaintUtilities.equal(this.backgroundPaint, textTitle.backgroundPaint);
    }
    
    public int hashCode() {
        return 29 * (29 * (29 * (29 * super.hashCode() + ((this.text != null) ? this.text.hashCode() : 0)) + ((this.font != null) ? this.font.hashCode() : 0)) + ((this.paint != null) ? this.paint.hashCode() : 0)) + ((this.backgroundPaint != null) ? this.backgroundPaint.hashCode() : 0);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static {
        DEFAULT_FONT = new Font("SansSerif", 1, 12);
        DEFAULT_TEXT_PAINT = Color.black;
    }
}
