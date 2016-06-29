/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.List;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.data.Range;
import org.jfree.ui.Size2D;

public class CenterArrangement
implements Serializable,
Arrangement {
    private static final long serialVersionUID = -353308149220382047L;

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
                throw new RuntimeException("Not implemented.");
            }
            if (lengthConstraintType2 != LengthConstraintType.RANGE) throw new IllegalArgumentException("Unknown LengthConstraintType.");
            throw new RuntimeException("Not implemented.");
        }
        if (lengthConstraintType == LengthConstraintType.FIXED) {
            if (lengthConstraintType2 == LengthConstraintType.NONE) {
                return this.arrangeFN(blockContainer, graphics2D, rectangleConstraint);
            }
            if (lengthConstraintType2 == LengthConstraintType.FIXED) {
                throw new RuntimeException("Not implemented.");
            }
            if (lengthConstraintType2 != LengthConstraintType.RANGE) throw new IllegalArgumentException("Unknown LengthConstraintType.");
            throw new RuntimeException("Not implemented.");
        }
        if (lengthConstraintType != LengthConstraintType.RANGE) throw new IllegalArgumentException("Unknown LengthConstraintType.");
        if (lengthConstraintType2 == LengthConstraintType.NONE) {
            return this.arrangeRN(blockContainer, graphics2D, rectangleConstraint);
        }
        if (lengthConstraintType2 == LengthConstraintType.FIXED) {
            return this.arrangeRF(blockContainer, graphics2D, rectangleConstraint);
        }
        if (lengthConstraintType2 != LengthConstraintType.RANGE) throw new IllegalArgumentException("Unknown LengthConstraintType.");
        return this.arrangeRR(blockContainer, graphics2D, rectangleConstraint);
    }

    protected Size2D arrangeFN(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        List list = blockContainer.getBlocks();
        Block block = (Block)list.get(0);
        Size2D size2D = block.arrange(graphics2D, RectangleConstraint.NONE);
        double d2 = rectangleConstraint.getWidth();
        Rectangle2D.Double double_ = new Rectangle2D.Double((d2 - size2D.width) / 2.0, 0.0, size2D.width, size2D.height);
        block.setBounds(double_);
        return new Size2D((d2 - size2D.width) / 2.0, size2D.height);
    }

    protected Size2D arrangeFR(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        Size2D size2D = this.arrangeFN(blockContainer, graphics2D, rectangleConstraint);
        if (rectangleConstraint.getHeightRange().contains(size2D.height)) {
            return size2D;
        }
        RectangleConstraint rectangleConstraint2 = rectangleConstraint.toFixedHeight(rectangleConstraint.getHeightRange().constrain(size2D.getHeight()));
        return this.arrangeFF(blockContainer, graphics2D, rectangleConstraint2);
    }

    protected Size2D arrangeFF(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        return this.arrangeFN(blockContainer, graphics2D, rectangleConstraint);
    }

    protected Size2D arrangeRR(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        Size2D size2D = this.arrangeNN(blockContainer, graphics2D);
        if (rectangleConstraint.getWidthRange().contains(size2D.width)) {
            return size2D;
        }
        RectangleConstraint rectangleConstraint2 = rectangleConstraint.toFixedWidth(rectangleConstraint.getWidthRange().getUpperBound());
        return this.arrangeFR(blockContainer, graphics2D, rectangleConstraint2);
    }

    protected Size2D arrangeRF(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        Size2D size2D = this.arrangeNF(blockContainer, graphics2D, rectangleConstraint);
        if (rectangleConstraint.getWidthRange().contains(size2D.width)) {
            return size2D;
        }
        RectangleConstraint rectangleConstraint2 = rectangleConstraint.toFixedWidth(rectangleConstraint.getWidthRange().constrain(size2D.getWidth()));
        return this.arrangeFF(blockContainer, graphics2D, rectangleConstraint2);
    }

    protected Size2D arrangeRN(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        Size2D size2D = this.arrangeNN(blockContainer, graphics2D);
        if (rectangleConstraint.getWidthRange().contains(size2D.width)) {
            return size2D;
        }
        RectangleConstraint rectangleConstraint2 = rectangleConstraint.toFixedWidth(rectangleConstraint.getWidthRange().getUpperBound());
        return this.arrangeFN(blockContainer, graphics2D, rectangleConstraint2);
    }

    protected Size2D arrangeNN(BlockContainer blockContainer, Graphics2D graphics2D) {
        List list = blockContainer.getBlocks();
        Block block = (Block)list.get(0);
        Size2D size2D = block.arrange(graphics2D, RectangleConstraint.NONE);
        block.setBounds(new Rectangle2D.Double(0.0, 0.0, size2D.width, size2D.height));
        return new Size2D(size2D.width, size2D.height);
    }

    protected Size2D arrangeNF(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        return this.arrangeNN(blockContainer, graphics2D);
    }

    @Override
    public void clear() {
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof CenterArrangement) return true;
        return false;
    }
}

