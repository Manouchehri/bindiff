/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.data.Range;
import org.jfree.ui.Size2D;

public class GridArrangement
implements Serializable,
Arrangement {
    private static final long serialVersionUID = -2563758090144655938L;
    private int rows;
    private int columns;

    public GridArrangement(int n2, int n3) {
        this.rows = n2;
        this.columns = n3;
    }

    @Override
    public void add(Block block, Object object) {
    }

    @Override
    public Size2D arrange(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        LengthConstraintType lengthConstraintType = rectangleConstraint.getWidthConstraintType();
        LengthConstraintType lengthConstraintType2 = rectangleConstraint.getHeightConstraintType();
        if (lengthConstraintType == LengthConstraintType.NONE) {
            if (lengthConstraintType2 == LengthConstraintType.NONE) {
                return this.arrangeNN(blockContainer, graphics2D);
            }
            if (lengthConstraintType2 == LengthConstraintType.FIXED) {
                throw new RuntimeException("Not yet implemented.");
            }
            if (lengthConstraintType2 != LengthConstraintType.RANGE) return new Size2D();
            throw new RuntimeException("Not yet implemented.");
        }
        if (lengthConstraintType == LengthConstraintType.FIXED) {
            if (lengthConstraintType2 == LengthConstraintType.NONE) {
                return this.arrangeFN(blockContainer, graphics2D, rectangleConstraint);
            }
            if (lengthConstraintType2 == LengthConstraintType.FIXED) {
                return this.arrangeFF(blockContainer, graphics2D, rectangleConstraint);
            }
            if (lengthConstraintType2 != LengthConstraintType.RANGE) return new Size2D();
            return this.arrangeFR(blockContainer, graphics2D, rectangleConstraint);
        }
        if (lengthConstraintType != LengthConstraintType.RANGE) return new Size2D();
        if (lengthConstraintType2 == LengthConstraintType.NONE) {
            throw new RuntimeException("Not yet implemented.");
        }
        if (lengthConstraintType2 == LengthConstraintType.FIXED) {
            throw new RuntimeException("Not yet implemented.");
        }
        if (lengthConstraintType2 != LengthConstraintType.RANGE) return new Size2D();
        throw new RuntimeException("Not yet implemented.");
    }

    protected Size2D arrangeNN(BlockContainer blockContainer, Graphics2D graphics2D) {
        double d2 = 0.0;
        double d3 = 0.0;
        List list = blockContainer.getBlocks();
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) {
                double d4 = (double)this.columns * d2;
                double d5 = (double)this.rows * d3;
                RectangleConstraint rectangleConstraint = new RectangleConstraint(d4, d5);
                return this.arrangeFF(blockContainer, graphics2D, rectangleConstraint);
            }
            Block block = (Block)iterator.next();
            Size2D size2D = block.arrange(graphics2D, RectangleConstraint.NONE);
            d2 = Math.max(d2, size2D.width);
            d3 = Math.max(d3, size2D.height);
        } while (true);
    }

    protected Size2D arrangeFF(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        double d2 = rectangleConstraint.getWidth() / (double)this.columns;
        double d3 = rectangleConstraint.getHeight() / (double)this.rows;
        List list = blockContainer.getBlocks();
        int n2 = 0;
        while (n2 < this.columns) {
            int n3;
            for (int i2 = 0; i2 < this.rows && (n3 = i2 * this.columns + n2) != list.size(); ++i2) {
                Block block = (Block)list.get(n3);
                block.setBounds(new Rectangle2D.Double((double)n2 * d2, (double)i2 * d3, d2, d3));
            }
            ++n2;
        }
        return new Size2D((double)this.columns * d2, (double)this.rows * d3);
    }

    protected Size2D arrangeFR(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        RectangleConstraint rectangleConstraint2 = rectangleConstraint.toUnconstrainedHeight();
        Size2D size2D = this.arrange(blockContainer, graphics2D, rectangleConstraint2);
        if (rectangleConstraint.getHeightRange().contains(size2D.getHeight())) {
            return size2D;
        }
        double d2 = rectangleConstraint.getHeightRange().constrain(size2D.getHeight());
        RectangleConstraint rectangleConstraint3 = rectangleConstraint.toFixedHeight(d2);
        return this.arrange(blockContainer, graphics2D, rectangleConstraint3);
    }

    protected Size2D arrangeFN(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        double d2 = rectangleConstraint.getWidth() / (double)this.columns;
        RectangleConstraint rectangleConstraint2 = rectangleConstraint.toFixedWidth(d2);
        List list = blockContainer.getBlocks();
        double d3 = 0.0;
        int n2 = 0;
        do {
            int n3;
            if (n2 >= this.rows) {
                RectangleConstraint rectangleConstraint3 = rectangleConstraint.toFixedHeight(d3 * (double)this.rows);
                return this.arrange(blockContainer, graphics2D, rectangleConstraint3);
            }
            for (int i2 = 0; i2 < this.columns && (n3 = n2 * this.columns + i2) != list.size(); ++i2) {
                Block block = (Block)list.get(n3);
                Size2D size2D = block.arrange(graphics2D, rectangleConstraint2);
                d3 = Math.max(d3, size2D.getHeight());
            }
            ++n2;
        } while (true);
    }

    @Override
    public void clear() {
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof GridArrangement)) {
            return false;
        }
        GridArrangement gridArrangement = (GridArrangement)object;
        if (this.columns != gridArrangement.columns) {
            return false;
        }
        if (this.rows == gridArrangement.rows) return true;
        return false;
    }
}

