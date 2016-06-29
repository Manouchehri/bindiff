package org.jfree.chart.block;

import java.io.*;
import java.awt.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import java.util.*;

public class GridArrangement implements Serializable, Arrangement
{
    private static final long serialVersionUID = -2563758090144655938L;
    private int rows;
    private int columns;
    
    public GridArrangement(final int rows, final int columns) {
        this.rows = rows;
        this.columns = columns;
    }
    
    public void add(final Block block, final Object o) {
    }
    
    public Size2D arrange(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final LengthConstraintType widthConstraintType = rectangleConstraint.getWidthConstraintType();
        final LengthConstraintType heightConstraintType = rectangleConstraint.getHeightConstraintType();
        if (widthConstraintType == LengthConstraintType.NONE) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                return this.arrangeNN(blockContainer, graphics2D);
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not yet implemented.");
            }
        }
        else if (widthConstraintType == LengthConstraintType.FIXED) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                return this.arrangeFN(blockContainer, graphics2D, rectangleConstraint);
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                return this.arrangeFF(blockContainer, graphics2D, rectangleConstraint);
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                return this.arrangeFR(blockContainer, graphics2D, rectangleConstraint);
            }
        }
        else if (widthConstraintType == LengthConstraintType.RANGE) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not yet implemented.");
            }
        }
        return new Size2D();
    }
    
    protected Size2D arrangeNN(final BlockContainer blockContainer, final Graphics2D graphics2D) {
        double max = 0.0;
        double max2 = 0.0;
        final Iterator<Block> iterator = blockContainer.getBlocks().iterator();
        while (iterator.hasNext()) {
            final Size2D arrange = iterator.next().arrange(graphics2D, RectangleConstraint.NONE);
            max = Math.max(max, arrange.width);
            max2 = Math.max(max2, arrange.height);
        }
        return this.arrangeFF(blockContainer, graphics2D, new RectangleConstraint(this.columns * max, this.rows * max2));
    }
    
    protected Size2D arrangeFF(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final double n = rectangleConstraint.getWidth() / this.columns;
        final double n2 = rectangleConstraint.getHeight() / this.rows;
        final List blocks = blockContainer.getBlocks();
        for (int i = 0; i < this.columns; ++i) {
            for (int j = 0; j < this.rows; ++j) {
                final int n3 = j * this.columns + i;
                if (n3 == blocks.size()) {
                    break;
                }
                blocks.get(n3).setBounds(new Rectangle2D.Double(i * n, j * n2, n, n2));
            }
        }
        return new Size2D(this.columns * n, this.rows * n2);
    }
    
    protected Size2D arrangeFR(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final Size2D arrange = this.arrange(blockContainer, graphics2D, rectangleConstraint.toUnconstrainedHeight());
        if (rectangleConstraint.getHeightRange().contains(arrange.getHeight())) {
            return arrange;
        }
        return this.arrange(blockContainer, graphics2D, rectangleConstraint.toFixedHeight(rectangleConstraint.getHeightRange().constrain(arrange.getHeight())));
    }
    
    protected Size2D arrangeFN(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final RectangleConstraint fixedWidth = rectangleConstraint.toFixedWidth(rectangleConstraint.getWidth() / this.columns);
        final List blocks = blockContainer.getBlocks();
        double max = 0.0;
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                final int n = i * this.columns + j;
                if (n == blocks.size()) {
                    break;
                }
                max = Math.max(max, blocks.get(n).arrange(graphics2D, fixedWidth).getHeight());
            }
        }
        return this.arrange(blockContainer, graphics2D, rectangleConstraint.toFixedHeight(max * this.rows));
    }
    
    public void clear() {
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GridArrangement)) {
            return false;
        }
        final GridArrangement gridArrangement = (GridArrangement)o;
        return this.columns == gridArrangement.columns && this.rows == gridArrangement.rows;
    }
}
