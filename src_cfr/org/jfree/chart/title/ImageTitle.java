/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.title;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import org.jfree.chart.event.TitleChangeEvent;
import org.jfree.chart.title.Title;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.ui.VerticalAlignment;

public class ImageTitle
extends Title {
    private Image image;

    public ImageTitle(Image image) {
        this(image, image.getHeight(null), image.getWidth(null), Title.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT, Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING);
    }

    public ImageTitle(Image image, RectangleEdge rectangleEdge, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment) {
        this(image, image.getHeight(null), image.getWidth(null), rectangleEdge, horizontalAlignment, verticalAlignment, Title.DEFAULT_PADDING);
    }

    public ImageTitle(Image image, int n2, int n3, RectangleEdge rectangleEdge, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, RectangleInsets rectangleInsets) {
        super(rectangleEdge, horizontalAlignment, verticalAlignment, rectangleInsets);
        if (image == null) {
            throw new NullPointerException("Null 'image' argument.");
        }
        this.image = image;
        this.setHeight(n2);
        this.setWidth(n3);
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        if (image == null) {
            throw new NullPointerException("Null 'image' argument.");
        }
        this.image = image;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        RectangleEdge rectangleEdge = this.getPosition();
        if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
            this.drawHorizontal(graphics2D, rectangle2D);
            return;
        }
        if (rectangleEdge != RectangleEdge.LEFT) {
            if (rectangleEdge != RectangleEdge.RIGHT) throw new RuntimeException("Invalid title position.");
        }
        this.drawVertical(graphics2D, rectangle2D);
    }

    protected Size2D drawHorizontal(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        double d7 = this.getWidth();
        double d8 = this.getHeight();
        RectangleInsets rectangleInsets = this.getPadding();
        d3 = rectangleInsets.calculateTopOutset(d8);
        d4 = rectangleInsets.calculateBottomOutset(d8);
        d5 = rectangleInsets.calculateLeftOutset(d7);
        d6 = rectangleInsets.calculateRightOutset(d7);
        d2 = this.getPosition() == RectangleEdge.TOP ? rectangle2D.getY() + d3 : rectangle2D.getY() + rectangle2D.getHeight() - d4 - d8;
        HorizontalAlignment horizontalAlignment = this.getHorizontalAlignment();
        double d9 = 0.0;
        if (horizontalAlignment == HorizontalAlignment.CENTER) {
            d9 = rectangle2D.getX() + d5 + rectangle2D.getWidth() / 2.0 - d7 / 2.0;
        } else if (horizontalAlignment == HorizontalAlignment.LEFT) {
            d9 = rectangle2D.getX() + d5;
        } else if (horizontalAlignment == HorizontalAlignment.RIGHT) {
            d9 = rectangle2D.getX() + rectangle2D.getWidth() - d6 - d7;
        }
        graphics2D.drawImage(this.image, (int)d9, (int)d2, (int)d7, (int)d8, null);
        return new Size2D(rectangle2D.getWidth() + d5 + d6, d8 + d3 + d4);
    }

    protected Size2D drawVertical(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        double d7 = this.getWidth();
        double d8 = this.getHeight();
        RectangleInsets rectangleInsets = this.getPadding();
        if (rectangleInsets != null) {
            d3 = rectangleInsets.calculateTopOutset(d8);
            d4 = rectangleInsets.calculateBottomOutset(d8);
            d5 = rectangleInsets.calculateLeftOutset(d7);
            d6 = rectangleInsets.calculateRightOutset(d7);
        }
        d2 = this.getPosition() == RectangleEdge.LEFT ? rectangle2D.getX() + d5 : rectangle2D.getMaxX() - d6 - d7;
        VerticalAlignment verticalAlignment = this.getVerticalAlignment();
        double d9 = 0.0;
        if (verticalAlignment == VerticalAlignment.CENTER) {
            d9 = rectangle2D.getMinY() + d3 + rectangle2D.getHeight() / 2.0 - d8 / 2.0;
        } else if (verticalAlignment == VerticalAlignment.TOP) {
            d9 = rectangle2D.getMinY() + d3;
        } else if (verticalAlignment == VerticalAlignment.BOTTOM) {
            d9 = rectangle2D.getMaxY() - d4 - d8;
        }
        graphics2D.drawImage(this.image, (int)d2, (int)d9, (int)d7, (int)d8, null);
        return new Size2D(rectangle2D.getWidth() + d5 + d6, d8 + d3 + d4);
    }

    @Override
    public Object draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Object object) {
        this.draw(graphics2D, rectangle2D);
        return null;
    }
}

