package org.jfree.chart.block;

import java.io.*;
import java.awt.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import java.util.*;

public class FlowArrangement implements Serializable, Arrangement
{
    private static final long serialVersionUID = 4543632485478613800L;
    private HorizontalAlignment horizontalAlignment;
    private VerticalAlignment verticalAlignment;
    private double horizontalGap;
    private double verticalGap;
    
    public FlowArrangement() {
        this(HorizontalAlignment.CENTER, VerticalAlignment.CENTER, 2.0, 2.0);
    }
    
    public FlowArrangement(final HorizontalAlignment horizontalAlignment, final VerticalAlignment verticalAlignment, final double horizontalGap, final double verticalGap) {
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
                return this.arrangeNF(blockContainer, graphics2D, rectangleConstraint);
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
                return this.arrangeFF(blockContainer, graphics2D, rectangleConstraint);
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                return this.arrangeFR(blockContainer, graphics2D, rectangleConstraint);
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
        throw new RuntimeException("Unrecognised constraint type.");
    }
    
    protected Size2D arrangeFN(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final List blocks = blockContainer.getBlocks();
        final double width = rectangleConstraint.getWidth();
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        final ArrayList<Block> list = new ArrayList<Block>();
        for (int i = 0; i < blocks.size(); ++i) {
            final Block block = blocks.get(i);
            final Size2D arrange = block.arrange(graphics2D, RectangleConstraint.NONE);
            if (n + arrange.width <= width) {
                list.add(block);
                block.setBounds(new Rectangle2D.Double(n, n2, arrange.width, arrange.height));
                n = n + arrange.width + this.horizontalGap;
                n3 = Math.max(n3, arrange.height);
            }
            else if (list.isEmpty()) {
                block.setBounds(new Rectangle2D.Double(n, n2, Math.min(arrange.width, width - n), arrange.height));
                n = 0.0;
                n2 = n2 + arrange.height + this.verticalGap;
            }
            else {
                list.clear();
                final double n4 = 0.0;
                n2 = n2 + n3 + this.verticalGap;
                n3 = arrange.height;
                block.setBounds(new Rectangle2D.Double(n4, n2, Math.min(arrange.width, width), arrange.height));
                n = arrange.width + this.horizontalGap;
                list.add(block);
            }
        }
        return new Size2D(rectangleConstraint.getWidth(), n2 + n3);
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
                n2 += array[i].getWidth();
                max = Math.max(array[i].height, max);
                block.setBounds(new Rectangle2D.Double(n, 0.0, array[i].width, array[i].height));
                n = n + array[i].width + this.horizontalGap;
            }
            if (size > 1) {
                n2 += this.horizontalGap * (size - 1);
            }
            if (this.verticalAlignment != VerticalAlignment.TOP) {
                for (int j = 0; j < blocks.size(); ++j) {
                    if (this.verticalAlignment != VerticalAlignment.CENTER) {
                        if (this.verticalAlignment == VerticalAlignment.BOTTOM) {}
                    }
                }
            }
        }
        return new Size2D(n2, max);
    }
    
    protected Size2D arrangeNF(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        return this.arrangeNN(blockContainer, graphics2D);
    }
    
    public void clear() {
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FlowArrangement)) {
            return false;
        }
        final FlowArrangement flowArrangement = (FlowArrangement)o;
        return this.horizontalAlignment == flowArrangement.horizontalAlignment && this.verticalAlignment == flowArrangement.verticalAlignment && this.horizontalGap == flowArrangement.horizontalGap && this.verticalGap == flowArrangement.verticalGap;
    }
}
