package org.jfree.chart.title;

import java.awt.image.*;
import org.jfree.chart.event.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.ui.*;

public class ImageTitle extends Title
{
    private Image image;
    
    public ImageTitle(final Image image) {
        this(image, image.getHeight(null), image.getWidth(null), Title.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT, Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING);
    }
    
    public ImageTitle(final Image image, final RectangleEdge rectangleEdge, final HorizontalAlignment horizontalAlignment, final VerticalAlignment verticalAlignment) {
        this(image, image.getHeight(null), image.getWidth(null), rectangleEdge, horizontalAlignment, verticalAlignment, Title.DEFAULT_PADDING);
    }
    
    public ImageTitle(final Image image, final int n, final int n2, final RectangleEdge rectangleEdge, final HorizontalAlignment horizontalAlignment, final VerticalAlignment verticalAlignment, final RectangleInsets rectangleInsets) {
        super(rectangleEdge, horizontalAlignment, verticalAlignment, rectangleInsets);
        if (image == null) {
            throw new NullPointerException("Null 'image' argument.");
        }
        this.image = image;
        this.setHeight(n);
        this.setWidth(n2);
    }
    
    public Image getImage() {
        return this.image;
    }
    
    public void setImage(final Image image) {
        if (image == null) {
            throw new NullPointerException("Null 'image' argument.");
        }
        this.image = image;
        this.notifyListeners(new TitleChangeEvent(this));
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final RectangleEdge position = this.getPosition();
        if (position == RectangleEdge.TOP || position == RectangleEdge.BOTTOM) {
            this.drawHorizontal(graphics2D, rectangle2D);
        }
        else {
            if (position != RectangleEdge.LEFT && position != RectangleEdge.RIGHT) {
                throw new RuntimeException("Invalid title position.");
            }
            this.drawVertical(graphics2D, rectangle2D);
        }
    }
    
    protected Size2D drawHorizontal(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final double width = this.getWidth();
        final double height = this.getHeight();
        final RectangleInsets padding = this.getPadding();
        final double calculateTopOutset = padding.calculateTopOutset(height);
        final double calculateBottomOutset = padding.calculateBottomOutset(height);
        final double calculateLeftOutset = padding.calculateLeftOutset(width);
        final double calculateRightOutset = padding.calculateRightOutset(width);
        double n;
        if (this.getPosition() == RectangleEdge.TOP) {
            n = rectangle2D.getY() + calculateTopOutset;
        }
        else {
            n = rectangle2D.getY() + rectangle2D.getHeight() - calculateBottomOutset - height;
        }
        final HorizontalAlignment horizontalAlignment = this.getHorizontalAlignment();
        double n2 = 0.0;
        if (horizontalAlignment == HorizontalAlignment.CENTER) {
            n2 = rectangle2D.getX() + calculateLeftOutset + rectangle2D.getWidth() / 2.0 - width / 2.0;
        }
        else if (horizontalAlignment == HorizontalAlignment.LEFT) {
            n2 = rectangle2D.getX() + calculateLeftOutset;
        }
        else if (horizontalAlignment == HorizontalAlignment.RIGHT) {
            n2 = rectangle2D.getX() + rectangle2D.getWidth() - calculateRightOutset - width;
        }
        graphics2D.drawImage(this.image, (int)n2, (int)n, (int)width, (int)height, null);
        return new Size2D(rectangle2D.getWidth() + calculateLeftOutset + calculateRightOutset, height + calculateTopOutset + calculateBottomOutset);
    }
    
    protected Size2D drawVertical(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        double calculateTopOutset = 0.0;
        double calculateBottomOutset = 0.0;
        double calculateLeftOutset = 0.0;
        double calculateRightOutset = 0.0;
        final double width = this.getWidth();
        final double height = this.getHeight();
        final RectangleInsets padding = this.getPadding();
        if (padding != null) {
            calculateTopOutset = padding.calculateTopOutset(height);
            calculateBottomOutset = padding.calculateBottomOutset(height);
            calculateLeftOutset = padding.calculateLeftOutset(width);
            calculateRightOutset = padding.calculateRightOutset(width);
        }
        double n;
        if (this.getPosition() == RectangleEdge.LEFT) {
            n = rectangle2D.getX() + calculateLeftOutset;
        }
        else {
            n = rectangle2D.getMaxX() - calculateRightOutset - width;
        }
        final VerticalAlignment verticalAlignment = this.getVerticalAlignment();
        double n2 = 0.0;
        if (verticalAlignment == VerticalAlignment.CENTER) {
            n2 = rectangle2D.getMinY() + calculateTopOutset + rectangle2D.getHeight() / 2.0 - height / 2.0;
        }
        else if (verticalAlignment == VerticalAlignment.TOP) {
            n2 = rectangle2D.getMinY() + calculateTopOutset;
        }
        else if (verticalAlignment == VerticalAlignment.BOTTOM) {
            n2 = rectangle2D.getMaxY() - calculateBottomOutset - height;
        }
        graphics2D.drawImage(this.image, (int)n, (int)n2, (int)width, (int)height, null);
        return new Size2D(rectangle2D.getWidth() + calculateLeftOutset + calculateRightOutset, height + calculateTopOutset + calculateBottomOutset);
    }
    
    public Object draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Object o) {
        this.draw(graphics2D, rectangle2D);
        return null;
    }
}
