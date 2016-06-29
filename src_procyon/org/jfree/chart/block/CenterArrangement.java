package org.jfree.chart.block;

import java.io.*;
import java.awt.*;
import org.jfree.ui.*;
import java.awt.geom.*;

public class CenterArrangement implements Serializable, Arrangement
{
    private static final long serialVersionUID = -353308149220382047L;
    
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
                throw new RuntimeException("Not implemented.");
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not implemented.");
            }
        }
        else if (widthConstraintType == LengthConstraintType.FIXED) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                return this.arrangeFN(blockContainer, graphics2D, rectangleConstraint);
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                throw new RuntimeException("Not implemented.");
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not implemented.");
            }
        }
        else if (widthConstraintType == LengthConstraintType.RANGE) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                return this.arrangeRN(blockContainer, graphics2D, rectangleConstraint);
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                return this.arrangeRF(blockContainer, graphics2D, rectangleConstraint);
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                return this.arrangeRR(blockContainer, graphics2D, rectangleConstraint);
            }
        }
        throw new IllegalArgumentException("Unknown LengthConstraintType.");
    }
    
    protected Size2D arrangeFN(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final Block block = blockContainer.getBlocks().get(0);
        final Size2D arrange = block.arrange(graphics2D, RectangleConstraint.NONE);
        final double width = rectangleConstraint.getWidth();
        block.setBounds(new Rectangle2D.Double((width - arrange.width) / 2.0, 0.0, arrange.width, arrange.height));
        return new Size2D((width - arrange.width) / 2.0, arrange.height);
    }
    
    protected Size2D arrangeFR(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final Size2D arrangeFN = this.arrangeFN(blockContainer, graphics2D, rectangleConstraint);
        if (rectangleConstraint.getHeightRange().contains(arrangeFN.height)) {
            return arrangeFN;
        }
        return this.arrangeFF(blockContainer, graphics2D, rectangleConstraint.toFixedHeight(rectangleConstraint.getHeightRange().constrain(arrangeFN.getHeight())));
    }
    
    protected Size2D arrangeFF(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        return this.arrangeFN(blockContainer, graphics2D, rectangleConstraint);
    }
    
    protected Size2D arrangeRR(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final Size2D arrangeNN = this.arrangeNN(blockContainer, graphics2D);
        if (rectangleConstraint.getWidthRange().contains(arrangeNN.width)) {
            return arrangeNN;
        }
        return this.arrangeFR(blockContainer, graphics2D, rectangleConstraint.toFixedWidth(rectangleConstraint.getWidthRange().getUpperBound()));
    }
    
    protected Size2D arrangeRF(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final Size2D arrangeNF = this.arrangeNF(blockContainer, graphics2D, rectangleConstraint);
        if (rectangleConstraint.getWidthRange().contains(arrangeNF.width)) {
            return arrangeNF;
        }
        return this.arrangeFF(blockContainer, graphics2D, rectangleConstraint.toFixedWidth(rectangleConstraint.getWidthRange().constrain(arrangeNF.getWidth())));
    }
    
    protected Size2D arrangeRN(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final Size2D arrangeNN = this.arrangeNN(blockContainer, graphics2D);
        if (rectangleConstraint.getWidthRange().contains(arrangeNN.width)) {
            return arrangeNN;
        }
        return this.arrangeFN(blockContainer, graphics2D, rectangleConstraint.toFixedWidth(rectangleConstraint.getWidthRange().getUpperBound()));
    }
    
    protected Size2D arrangeNN(final BlockContainer blockContainer, final Graphics2D graphics2D) {
        final Block block = blockContainer.getBlocks().get(0);
        final Size2D arrange = block.arrange(graphics2D, RectangleConstraint.NONE);
        block.setBounds(new Rectangle2D.Double(0.0, 0.0, arrange.width, arrange.height));
        return new Size2D(arrange.width, arrange.height);
    }
    
    protected Size2D arrangeNF(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        return this.arrangeNN(blockContainer, graphics2D);
    }
    
    public void clear() {
    }
    
    public boolean equals(final Object o) {
        return o == this || o instanceof CenterArrangement;
    }
}
