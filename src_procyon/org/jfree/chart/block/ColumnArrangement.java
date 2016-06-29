package org.jfree.chart.block;

import java.io.*;
import java.awt.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import java.util.*;

public class ColumnArrangement implements Serializable, Arrangement
{
    private static final long serialVersionUID = -5315388482898581555L;
    private HorizontalAlignment horizontalAlignment;
    private VerticalAlignment verticalAlignment;
    private double horizontalGap;
    private double verticalGap;
    
    public ColumnArrangement() {
    }
    
    public ColumnArrangement(final HorizontalAlignment horizontalAlignment, final VerticalAlignment verticalAlignment, final double horizontalGap, final double verticalGap) {
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.horizontalGap = horizontalGap;
        this.verticalGap = verticalGap;
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
                throw new RuntimeException("Not implemented.");
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not implemented.");
            }
        }
        else if (widthConstraintType == LengthConstraintType.FIXED) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                throw new RuntimeException("Not implemented.");
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                return this.arrangeFF(blockContainer, graphics2D, rectangleConstraint);
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                throw new RuntimeException("Not implemented.");
            }
        }
        else if (widthConstraintType == LengthConstraintType.RANGE) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                throw new RuntimeException("Not implemented.");
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                return this.arrangeRF(blockContainer, graphics2D, rectangleConstraint);
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                return this.arrangeRR(blockContainer, graphics2D, rectangleConstraint);
            }
        }
        return new Size2D();
    }
    
    protected Size2D arrangeFF(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        return this.arrangeNF(blockContainer, graphics2D, rectangleConstraint);
    }
    
    protected Size2D arrangeNF(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final List blocks = blockContainer.getBlocks();
        double height = rectangleConstraint.getHeight();
        if (height <= 0.0) {
            height = Double.POSITIVE_INFINITY;
        }
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        final ArrayList<Block> list = new ArrayList<Block>();
        for (int i = 0; i < blocks.size(); ++i) {
            final Block block = blocks.get(i);
            final Size2D arrange = block.arrange(graphics2D, RectangleConstraint.NONE);
            if (n2 + arrange.height <= height) {
                list.add(block);
                block.setBounds(new Rectangle2D.Double(n, n2, arrange.width, arrange.height));
                n2 = n2 + arrange.height + this.verticalGap;
                n3 = Math.max(n3, arrange.width);
            }
            else if (list.isEmpty()) {
                block.setBounds(new Rectangle2D.Double(n, n2, arrange.width, Math.min(arrange.height, height - n2)));
                n2 = 0.0;
                n = n + arrange.width + this.horizontalGap;
            }
            else {
                list.clear();
                n = n + n3 + this.horizontalGap;
                final double n4 = 0.0;
                n3 = arrange.width;
                block.setBounds(new Rectangle2D.Double(n, n4, arrange.width, Math.min(arrange.height, height)));
                n2 = arrange.height + this.verticalGap;
                list.add(block);
            }
        }
        return new Size2D(n + n3, rectangleConstraint.getHeight());
    }
    
    protected Size2D arrangeRR(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final Size2D arrangeNN = this.arrangeNN(blockContainer, graphics2D);
        if (rectangleConstraint.getHeightRange().contains(arrangeNN.height)) {
            return arrangeNN;
        }
        return this.arrangeRF(blockContainer, graphics2D, rectangleConstraint.toFixedHeight(rectangleConstraint.getHeightRange().getUpperBound()));
    }
    
    protected Size2D arrangeRF(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final Size2D arrangeNF = this.arrangeNF(blockContainer, graphics2D, rectangleConstraint);
        if (rectangleConstraint.getWidthRange().contains(arrangeNF.width)) {
            return arrangeNF;
        }
        return this.arrangeFF(blockContainer, graphics2D, rectangleConstraint.toFixedWidth(rectangleConstraint.getWidthRange().constrain(arrangeNF.getWidth())));
    }
    
    protected Size2D arrangeNN(final BlockContainer blockContainer, final Graphics2D graphics2D) {
        double n = 0.0;
        double n2 = 0.0;
        double max = 0.0;
        final List blocks = blockContainer.getBlocks();
        final int size = blocks.size();
        if (size > 0) {
            final Size2D[] array = new Size2D[blocks.size()];
            for (int i = 0; i < blocks.size(); ++i) {
                final Block block = blocks.get(i);
                array[i] = block.arrange(graphics2D, RectangleConstraint.NONE);
                n2 += array[i].getHeight();
                max = Math.max(array[i].width, max);
                block.setBounds(new Rectangle2D.Double(0.0, n, array[i].width, array[i].height));
                n = n + array[i].height + this.verticalGap;
            }
            if (size > 1) {
                n2 += this.verticalGap * (size - 1);
            }
            if (this.horizontalAlignment != HorizontalAlignment.LEFT) {
                for (int j = 0; j < blocks.size(); ++j) {
                    if (this.horizontalAlignment != HorizontalAlignment.CENTER) {
                        if (this.horizontalAlignment == HorizontalAlignment.RIGHT) {}
                    }
                }
            }
        }
        return new Size2D(max, n2);
    }
    
    public void clear() {
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ColumnArrangement)) {
            return false;
        }
        final ColumnArrangement columnArrangement = (ColumnArrangement)o;
        return this.horizontalAlignment == columnArrangement.horizontalAlignment && this.verticalAlignment == columnArrangement.verticalAlignment && this.horizontalGap == columnArrangement.horizontalGap && this.verticalGap == columnArrangement.verticalGap;
    }
}
