package org.jfree.chart.title;

import java.io.*;
import java.awt.*;
import org.jfree.chart.block.*;
import org.jfree.ui.*;
import java.awt.geom.*;

public class CompositeTitle extends Title implements Serializable, Cloneable
{
    private static final long serialVersionUID = -6770854036232562290L;
    private BlockContainer container;
    
    public CompositeTitle() {
        this(new BlockContainer(new BorderArrangement()));
    }
    
    public CompositeTitle(final BlockContainer container) {
        if (container == null) {
            throw new IllegalArgumentException("Null 'container' argument.");
        }
        this.container = container;
    }
    
    public BlockContainer getContainer() {
        return this.container;
    }
    
    public void setTitleContainer(final BlockContainer container) {
        if (container == null) {
            throw new IllegalArgumentException("Null 'container' argument.");
        }
        this.container = container;
    }
    
    public Size2D arrange(final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final Size2D arrange = this.container.arrange(graphics2D, this.toContentConstraint(rectangleConstraint));
        return new Size2D(this.calculateTotalWidth(arrange.getWidth()), this.calculateTotalHeight(arrange.getHeight()));
    }
    
    public void draw(final Graphics2D graphics2D, Rectangle2D rectangle2D) {
        rectangle2D = this.trimMargin(rectangle2D);
        this.drawBorder(graphics2D, rectangle2D);
        rectangle2D = this.trimBorder(rectangle2D);
        rectangle2D = this.trimPadding(rectangle2D);
        this.container.draw(graphics2D, rectangle2D);
    }
    
    public Object draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Object o) {
        this.draw(graphics2D, rectangle2D);
        return null;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof CompositeTitle && super.equals(o) && this.container.equals(((CompositeTitle)o).container));
    }
}
