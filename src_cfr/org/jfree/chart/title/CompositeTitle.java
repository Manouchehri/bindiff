/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.title;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.title.Title;
import org.jfree.ui.Size2D;

public class CompositeTitle
extends Title
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -6770854036232562290L;
    private BlockContainer container;

    public CompositeTitle() {
        this(new BlockContainer(new BorderArrangement()));
    }

    public CompositeTitle(BlockContainer blockContainer) {
        if (blockContainer == null) {
            throw new IllegalArgumentException("Null 'container' argument.");
        }
        this.container = blockContainer;
    }

    public BlockContainer getContainer() {
        return this.container;
    }

    public void setTitleContainer(BlockContainer blockContainer) {
        if (blockContainer == null) {
            throw new IllegalArgumentException("Null 'container' argument.");
        }
        this.container = blockContainer;
    }

    @Override
    public Size2D arrange(Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        RectangleConstraint rectangleConstraint2 = this.toContentConstraint(rectangleConstraint);
        Size2D size2D = this.container.arrange(graphics2D, rectangleConstraint2);
        return new Size2D(this.calculateTotalWidth(size2D.getWidth()), this.calculateTotalHeight(size2D.getHeight()));
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        rectangle2D = this.trimMargin(rectangle2D);
        this.drawBorder(graphics2D, rectangle2D);
        rectangle2D = this.trimBorder(rectangle2D);
        rectangle2D = this.trimPadding(rectangle2D);
        this.container.draw(graphics2D, rectangle2D);
    }

    @Override
    public Object draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Object object) {
        this.draw(graphics2D, rectangle2D);
        return null;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CompositeTitle)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        CompositeTitle compositeTitle = (CompositeTitle)object;
        if (this.container.equals(compositeTitle.container)) return true;
        return false;
    }
}

