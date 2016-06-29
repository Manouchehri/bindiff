package org.jfree.chart.block;

import java.io.*;
import java.awt.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import org.jfree.data.*;
import org.jfree.util.*;

public class BorderArrangement implements Serializable, Arrangement
{
    private static final long serialVersionUID = 506071142274883745L;
    private Block centerBlock;
    private Block topBlock;
    private Block bottomBlock;
    private Block leftBlock;
    private Block rightBlock;
    
    public void add(final Block rightBlock, final Object o) {
        if (o == null) {
            this.centerBlock = rightBlock;
        }
        else {
            final RectangleEdge rectangleEdge = (RectangleEdge)o;
            if (rectangleEdge == RectangleEdge.TOP) {
                this.topBlock = rightBlock;
            }
            else if (rectangleEdge == RectangleEdge.BOTTOM) {
                this.bottomBlock = rightBlock;
            }
            else if (rectangleEdge == RectangleEdge.LEFT) {
                this.leftBlock = rightBlock;
            }
            else if (rectangleEdge == RectangleEdge.RIGHT) {
                this.rightBlock = rightBlock;
            }
        }
    }
    
    public Size2D arrange(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final RectangleConstraint contentConstraint = blockContainer.toContentConstraint(rectangleConstraint);
        Size2D size2D = null;
        final LengthConstraintType widthConstraintType = contentConstraint.getWidthConstraintType();
        final LengthConstraintType heightConstraintType = contentConstraint.getHeightConstraintType();
        if (widthConstraintType == LengthConstraintType.NONE) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                size2D = this.arrangeNN(blockContainer, graphics2D);
            }
            else {
                if (heightConstraintType == LengthConstraintType.FIXED) {
                    throw new RuntimeException("Not implemented.");
                }
                if (heightConstraintType == LengthConstraintType.RANGE) {
                    throw new RuntimeException("Not implemented.");
                }
            }
        }
        else if (widthConstraintType == LengthConstraintType.FIXED) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                size2D = this.arrangeFN(blockContainer, graphics2D, rectangleConstraint.getWidth());
            }
            else if (heightConstraintType == LengthConstraintType.FIXED) {
                size2D = this.arrangeFF(blockContainer, graphics2D, rectangleConstraint);
            }
            else if (heightConstraintType == LengthConstraintType.RANGE) {
                size2D = this.arrangeFR(blockContainer, graphics2D, rectangleConstraint);
            }
        }
        else if (widthConstraintType == LengthConstraintType.RANGE) {
            if (heightConstraintType == LengthConstraintType.NONE) {
                throw new RuntimeException("Not implemented.");
            }
            if (heightConstraintType == LengthConstraintType.FIXED) {
                throw new RuntimeException("Not implemented.");
            }
            if (heightConstraintType == LengthConstraintType.RANGE) {
                size2D = this.arrangeRR(blockContainer, rectangleConstraint.getWidthRange(), rectangleConstraint.getHeightRange(), graphics2D);
            }
        }
        return new Size2D(blockContainer.calculateTotalWidth(size2D.getWidth()), blockContainer.calculateTotalHeight(size2D.getHeight()));
    }
    
    protected Size2D arrangeNN(final BlockContainer blockContainer, final Graphics2D graphics2D) {
        final double[] array = new double[5];
        final double[] array2 = new double[5];
        if (this.topBlock != null) {
            final Size2D arrange = this.topBlock.arrange(graphics2D, RectangleConstraint.NONE);
            array[0] = arrange.width;
            array2[0] = arrange.height;
        }
        if (this.bottomBlock != null) {
            final Size2D arrange2 = this.bottomBlock.arrange(graphics2D, RectangleConstraint.NONE);
            array[1] = arrange2.width;
            array2[1] = arrange2.height;
        }
        if (this.leftBlock != null) {
            final Size2D arrange3 = this.leftBlock.arrange(graphics2D, RectangleConstraint.NONE);
            array[2] = arrange3.width;
            array2[2] = arrange3.height;
        }
        if (this.rightBlock != null) {
            final Size2D arrange4 = this.rightBlock.arrange(graphics2D, RectangleConstraint.NONE);
            array[3] = arrange4.width;
            array2[3] = arrange4.height;
        }
        array2[3] = (array2[2] = Math.max(array2[2], array2[3]));
        if (this.centerBlock != null) {
            final Size2D arrange5 = this.centerBlock.arrange(graphics2D, RectangleConstraint.NONE);
            array[4] = arrange5.width;
            array2[4] = arrange5.height;
        }
        final double max = Math.max(array[0], Math.max(array[1], array[2] + array[4] + array[3]));
        final double max2 = Math.max(array2[2], Math.max(array2[3], array2[4]));
        final double n = array2[0] + array2[1] + max2;
        if (this.topBlock != null) {
            this.topBlock.setBounds(new Rectangle2D.Double(0.0, 0.0, max, array2[0]));
        }
        if (this.bottomBlock != null) {
            this.bottomBlock.setBounds(new Rectangle2D.Double(0.0, n - array2[1], max, array2[1]));
        }
        if (this.leftBlock != null) {
            this.leftBlock.setBounds(new Rectangle2D.Double(0.0, array2[0], array[2], max2));
        }
        if (this.rightBlock != null) {
            this.rightBlock.setBounds(new Rectangle2D.Double(max - array[3], array2[0], array[3], max2));
        }
        if (this.centerBlock != null) {
            this.centerBlock.setBounds(new Rectangle2D.Double(array[2], array2[0], max - array[2] - array[3], max2));
        }
        return new Size2D(max, n);
    }
    
    protected Size2D arrangeFR(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final Size2D arrangeFN = this.arrangeFN(blockContainer, graphics2D, rectangleConstraint.getWidth());
        if (rectangleConstraint.getHeightRange().contains(arrangeFN.getHeight())) {
            return arrangeFN;
        }
        return this.arrange(blockContainer, graphics2D, rectangleConstraint.toFixedHeight(rectangleConstraint.getHeightRange().constrain(arrangeFN.getHeight())));
    }
    
    protected Size2D arrangeFN(final BlockContainer blockContainer, final Graphics2D graphics2D, final double n) {
        final double[] array = new double[5];
        final double[] array2 = new double[5];
        final RectangleConstraint rectangleConstraint = new RectangleConstraint(n, null, LengthConstraintType.FIXED, 0.0, null, LengthConstraintType.NONE);
        if (this.topBlock != null) {
            final Size2D arrange = this.topBlock.arrange(graphics2D, rectangleConstraint);
            array[0] = arrange.width;
            array2[0] = arrange.height;
        }
        if (this.bottomBlock != null) {
            final Size2D arrange2 = this.bottomBlock.arrange(graphics2D, rectangleConstraint);
            array[1] = arrange2.width;
            array2[1] = arrange2.height;
        }
        final RectangleConstraint rectangleConstraint2 = new RectangleConstraint(0.0, new Range(0.0, n), LengthConstraintType.RANGE, 0.0, null, LengthConstraintType.NONE);
        if (this.leftBlock != null) {
            final Size2D arrange3 = this.leftBlock.arrange(graphics2D, rectangleConstraint2);
            array[2] = arrange3.width;
            array2[2] = arrange3.height;
        }
        if (this.rightBlock != null) {
            final double max = Math.max(n - array[2], 0.0);
            final Size2D arrange4 = this.rightBlock.arrange(graphics2D, new RectangleConstraint(0.0, new Range(Math.min(array[2], max), max), LengthConstraintType.RANGE, 0.0, null, LengthConstraintType.NONE));
            array[3] = arrange4.width;
            array2[3] = arrange4.height;
        }
        array2[3] = (array2[2] = Math.max(array2[2], array2[3]));
        if (this.centerBlock != null) {
            final Size2D arrange5 = this.centerBlock.arrange(graphics2D, new RectangleConstraint(n - array[2] - array[3], null, LengthConstraintType.FIXED, 0.0, null, LengthConstraintType.NONE));
            array[4] = arrange5.width;
            array2[4] = arrange5.height;
        }
        return this.arrange(blockContainer, graphics2D, new RectangleConstraint(n, array2[0] + array2[1] + Math.max(array2[2], Math.max(array2[3], array2[4]))));
    }
    
    protected Size2D arrangeRR(final BlockContainer blockContainer, final Range range, final Range range2, final Graphics2D graphics2D) {
        final double[] array = new double[5];
        final double[] array2 = new double[5];
        if (this.topBlock != null) {
            final Size2D arrange = this.topBlock.arrange(graphics2D, new RectangleConstraint(range, range2));
            array[0] = arrange.width;
            array2[0] = arrange.height;
        }
        if (this.bottomBlock != null) {
            final Size2D arrange2 = this.bottomBlock.arrange(graphics2D, new RectangleConstraint(range, Range.shift(range2, -array2[0], false)));
            array[1] = arrange2.width;
            array2[1] = arrange2.height;
        }
        final Range shift = Range.shift(range2, -(array2[0] + array2[1]));
        if (this.leftBlock != null) {
            final Size2D arrange3 = this.leftBlock.arrange(graphics2D, new RectangleConstraint(range, shift));
            array[2] = arrange3.width;
            array2[2] = arrange3.height;
        }
        final Range shift2 = Range.shift(range, -array[2], false);
        if (this.rightBlock != null) {
            final Size2D arrange4 = this.rightBlock.arrange(graphics2D, new RectangleConstraint(shift2, shift));
            array[3] = arrange4.width;
            array2[3] = arrange4.height;
        }
        array2[3] = (array2[2] = Math.max(array2[2], array2[3]));
        final Range shift3 = Range.shift(range, -(array[2] + array[3]), false);
        if (this.centerBlock != null) {
            final Size2D arrange5 = this.centerBlock.arrange(graphics2D, new RectangleConstraint(shift3, shift));
            array[4] = arrange5.width;
            array2[4] = arrange5.height;
        }
        final double max = Math.max(array[0], Math.max(array[1], array[2] + array[4] + array[3]));
        final double n = array2[0] + array2[1] + Math.max(array2[2], Math.max(array2[3], array2[4]));
        if (this.topBlock != null) {
            this.topBlock.setBounds(new Rectangle2D.Double(0.0, 0.0, max, array2[0]));
        }
        if (this.bottomBlock != null) {
            this.bottomBlock.setBounds(new Rectangle2D.Double(0.0, n - array2[1], max, array2[1]));
        }
        if (this.leftBlock != null) {
            this.leftBlock.setBounds(new Rectangle2D.Double(0.0, array2[0], array[2], array2[2]));
        }
        if (this.rightBlock != null) {
            this.rightBlock.setBounds(new Rectangle2D.Double(max - array[3], array2[0], array[3], array2[3]));
        }
        if (this.centerBlock != null) {
            this.centerBlock.setBounds(new Rectangle2D.Double(array[2], array2[0], max - array[2] - array[3], n - array2[0] - array2[1]));
        }
        return new Size2D(max, n);
    }
    
    protected Size2D arrangeFF(final BlockContainer blockContainer, final Graphics2D graphics2D, final RectangleConstraint rectangleConstraint) {
        final double[] array = new double[5];
        final double[] array2 = new double[5];
        array[0] = rectangleConstraint.getWidth();
        if (this.topBlock != null) {
            array2[0] = this.topBlock.arrange(graphics2D, new RectangleConstraint(array[0], null, LengthConstraintType.FIXED, 0.0, new Range(0.0, rectangleConstraint.getHeight()), LengthConstraintType.RANGE)).height;
        }
        array[1] = array[0];
        if (this.bottomBlock != null) {
            array2[1] = this.bottomBlock.arrange(graphics2D, new RectangleConstraint(array[0], null, LengthConstraintType.FIXED, 0.0, new Range(0.0, rectangleConstraint.getHeight() - array2[0]), LengthConstraintType.RANGE)).height;
        }
        array2[2] = rectangleConstraint.getHeight() - array2[1] - array2[0];
        if (this.leftBlock != null) {
            array[2] = this.leftBlock.arrange(graphics2D, new RectangleConstraint(0.0, new Range(0.0, rectangleConstraint.getWidth()), LengthConstraintType.RANGE, array2[2], null, LengthConstraintType.FIXED)).width;
        }
        array2[3] = array2[2];
        if (this.rightBlock != null) {
            array[3] = this.rightBlock.arrange(graphics2D, new RectangleConstraint(0.0, new Range(0.0, rectangleConstraint.getWidth() - array[2]), LengthConstraintType.RANGE, array2[2], null, LengthConstraintType.FIXED)).width;
        }
        array2[4] = array2[2];
        array[4] = rectangleConstraint.getWidth() - array[3] - array[2];
        final RectangleConstraint rectangleConstraint2 = new RectangleConstraint(array[4], array2[4]);
        if (this.centerBlock != null) {
            this.centerBlock.arrange(graphics2D, rectangleConstraint2);
        }
        if (this.topBlock != null) {
            this.topBlock.setBounds(new Rectangle2D.Double(0.0, 0.0, array[0], array2[0]));
        }
        if (this.bottomBlock != null) {
            this.bottomBlock.setBounds(new Rectangle2D.Double(0.0, array2[0] + array2[2], array[1], array2[1]));
        }
        if (this.leftBlock != null) {
            this.leftBlock.setBounds(new Rectangle2D.Double(0.0, array2[0], array[2], array2[2]));
        }
        if (this.rightBlock != null) {
            this.rightBlock.setBounds(new Rectangle2D.Double(array[2] + array[4], array2[0], array[3], array2[3]));
        }
        if (this.centerBlock != null) {
            this.centerBlock.setBounds(new Rectangle2D.Double(array[2], array2[0], array[4], array2[4]));
        }
        return new Size2D(rectangleConstraint.getWidth(), rectangleConstraint.getHeight());
    }
    
    public void clear() {
        this.centerBlock = null;
        this.topBlock = null;
        this.bottomBlock = null;
        this.leftBlock = null;
        this.rightBlock = null;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BorderArrangement)) {
            return false;
        }
        final BorderArrangement borderArrangement = (BorderArrangement)o;
        return ObjectUtilities.equal(this.topBlock, borderArrangement.topBlock) && ObjectUtilities.equal(this.bottomBlock, borderArrangement.bottomBlock) && ObjectUtilities.equal(this.leftBlock, borderArrangement.leftBlock) && ObjectUtilities.equal(this.rightBlock, borderArrangement.rightBlock) && ObjectUtilities.equal(this.centerBlock, borderArrangement.centerBlock);
    }
}
