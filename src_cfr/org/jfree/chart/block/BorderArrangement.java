/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.data.Range;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.Size2D;
import org.jfree.util.ObjectUtilities;

public class BorderArrangement
implements Serializable,
Arrangement {
    private static final long serialVersionUID = 506071142274883745L;
    private Block centerBlock;
    private Block topBlock;
    private Block bottomBlock;
    private Block leftBlock;
    private Block rightBlock;

    @Override
    public void add(Block block, Object object) {
        if (object == null) {
            this.centerBlock = block;
            return;
        }
        RectangleEdge rectangleEdge = (RectangleEdge)object;
        if (rectangleEdge == RectangleEdge.TOP) {
            this.topBlock = block;
            return;
        }
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            this.bottomBlock = block;
            return;
        }
        if (rectangleEdge == RectangleEdge.LEFT) {
            this.leftBlock = block;
            return;
        }
        if (rectangleEdge != RectangleEdge.RIGHT) return;
        this.rightBlock = block;
    }

    @Override
    public Size2D arrange(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        RectangleConstraint rectangleConstraint2 = blockContainer.toContentConstraint(rectangleConstraint);
        Size2D size2D = null;
        LengthConstraintType lengthConstraintType = rectangleConstraint2.getWidthConstraintType();
        LengthConstraintType lengthConstraintType2 = rectangleConstraint2.getHeightConstraintType();
        if (lengthConstraintType == LengthConstraintType.NONE) {
            if (lengthConstraintType2 == LengthConstraintType.NONE) {
                size2D = this.arrangeNN(blockContainer, graphics2D);
                return new Size2D(blockContainer.calculateTotalWidth(size2D.getWidth()), blockContainer.calculateTotalHeight(size2D.getHeight()));
            }
            if (lengthConstraintType2 == LengthConstraintType.FIXED) {
                throw new RuntimeException("Not implemented.");
            }
            if (lengthConstraintType2 != LengthConstraintType.RANGE) return new Size2D(blockContainer.calculateTotalWidth(size2D.getWidth()), blockContainer.calculateTotalHeight(size2D.getHeight()));
            throw new RuntimeException("Not implemented.");
        }
        if (lengthConstraintType == LengthConstraintType.FIXED) {
            if (lengthConstraintType2 == LengthConstraintType.NONE) {
                size2D = this.arrangeFN(blockContainer, graphics2D, rectangleConstraint.getWidth());
                return new Size2D(blockContainer.calculateTotalWidth(size2D.getWidth()), blockContainer.calculateTotalHeight(size2D.getHeight()));
            }
            if (lengthConstraintType2 == LengthConstraintType.FIXED) {
                size2D = this.arrangeFF(blockContainer, graphics2D, rectangleConstraint);
                return new Size2D(blockContainer.calculateTotalWidth(size2D.getWidth()), blockContainer.calculateTotalHeight(size2D.getHeight()));
            }
            if (lengthConstraintType2 != LengthConstraintType.RANGE) return new Size2D(blockContainer.calculateTotalWidth(size2D.getWidth()), blockContainer.calculateTotalHeight(size2D.getHeight()));
            size2D = this.arrangeFR(blockContainer, graphics2D, rectangleConstraint);
            return new Size2D(blockContainer.calculateTotalWidth(size2D.getWidth()), blockContainer.calculateTotalHeight(size2D.getHeight()));
        }
        if (lengthConstraintType != LengthConstraintType.RANGE) return new Size2D(blockContainer.calculateTotalWidth(size2D.getWidth()), blockContainer.calculateTotalHeight(size2D.getHeight()));
        if (lengthConstraintType2 == LengthConstraintType.NONE) {
            throw new RuntimeException("Not implemented.");
        }
        if (lengthConstraintType2 == LengthConstraintType.FIXED) {
            throw new RuntimeException("Not implemented.");
        }
        if (lengthConstraintType2 != LengthConstraintType.RANGE) return new Size2D(blockContainer.calculateTotalWidth(size2D.getWidth()), blockContainer.calculateTotalHeight(size2D.getHeight()));
        size2D = this.arrangeRR(blockContainer, rectangleConstraint.getWidthRange(), rectangleConstraint.getHeightRange(), graphics2D);
        return new Size2D(blockContainer.calculateTotalWidth(size2D.getWidth()), blockContainer.calculateTotalHeight(size2D.getHeight()));
    }

    protected Size2D arrangeNN(BlockContainer blockContainer, Graphics2D graphics2D) {
        Size2D size2D;
        double[] arrd = new double[5];
        double[] arrd2 = new double[5];
        if (this.topBlock != null) {
            size2D = this.topBlock.arrange(graphics2D, RectangleConstraint.NONE);
            arrd[0] = size2D.width;
            arrd2[0] = size2D.height;
        }
        if (this.bottomBlock != null) {
            size2D = this.bottomBlock.arrange(graphics2D, RectangleConstraint.NONE);
            arrd[1] = size2D.width;
            arrd2[1] = size2D.height;
        }
        if (this.leftBlock != null) {
            size2D = this.leftBlock.arrange(graphics2D, RectangleConstraint.NONE);
            arrd[2] = size2D.width;
            arrd2[2] = size2D.height;
        }
        if (this.rightBlock != null) {
            size2D = this.rightBlock.arrange(graphics2D, RectangleConstraint.NONE);
            arrd[3] = size2D.width;
            arrd2[3] = size2D.height;
        }
        arrd2[2] = Math.max(arrd2[2], arrd2[3]);
        arrd2[3] = arrd2[2];
        if (this.centerBlock != null) {
            size2D = this.centerBlock.arrange(graphics2D, RectangleConstraint.NONE);
            arrd[4] = size2D.width;
            arrd2[4] = size2D.height;
        }
        double d2 = Math.max(arrd[0], Math.max(arrd[1], arrd[2] + arrd[4] + arrd[3]));
        double d3 = Math.max(arrd2[2], Math.max(arrd2[3], arrd2[4]));
        double d4 = arrd2[0] + arrd2[1] + d3;
        if (this.topBlock != null) {
            this.topBlock.setBounds(new Rectangle2D.Double(0.0, 0.0, d2, arrd2[0]));
        }
        if (this.bottomBlock != null) {
            this.bottomBlock.setBounds(new Rectangle2D.Double(0.0, d4 - arrd2[1], d2, arrd2[1]));
        }
        if (this.leftBlock != null) {
            this.leftBlock.setBounds(new Rectangle2D.Double(0.0, arrd2[0], arrd[2], d3));
        }
        if (this.rightBlock != null) {
            this.rightBlock.setBounds(new Rectangle2D.Double(d2 - arrd[3], arrd2[0], arrd[3], d3));
        }
        if (this.centerBlock == null) return new Size2D(d2, d4);
        this.centerBlock.setBounds(new Rectangle2D.Double(arrd[2], arrd2[0], d2 - arrd[2] - arrd[3], d3));
        return new Size2D(d2, d4);
    }

    protected Size2D arrangeFR(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        Size2D size2D = this.arrangeFN(blockContainer, graphics2D, rectangleConstraint.getWidth());
        if (rectangleConstraint.getHeightRange().contains(size2D.getHeight())) {
            return size2D;
        }
        double d2 = rectangleConstraint.getHeightRange().constrain(size2D.getHeight());
        RectangleConstraint rectangleConstraint2 = rectangleConstraint.toFixedHeight(d2);
        return this.arrange(blockContainer, graphics2D, rectangleConstraint2);
    }

    protected Size2D arrangeFN(BlockContainer blockContainer, Graphics2D graphics2D, double d2) {
        Object object;
        Object object2;
        double[] arrd = new double[5];
        double[] arrd2 = new double[5];
        RectangleConstraint rectangleConstraint = new RectangleConstraint(d2, null, LengthConstraintType.FIXED, 0.0, null, LengthConstraintType.NONE);
        if (this.topBlock != null) {
            object2 = this.topBlock.arrange(graphics2D, rectangleConstraint);
            arrd[0] = object2.width;
            arrd2[0] = object2.height;
        }
        if (this.bottomBlock != null) {
            object2 = this.bottomBlock.arrange(graphics2D, rectangleConstraint);
            arrd[1] = object2.width;
            arrd2[1] = object2.height;
        }
        object2 = new RectangleConstraint(0.0, new Range(0.0, d2), LengthConstraintType.RANGE, 0.0, null, LengthConstraintType.NONE);
        if (this.leftBlock != null) {
            object = this.leftBlock.arrange(graphics2D, (RectangleConstraint)object2);
            arrd[2] = object.width;
            arrd2[2] = object.height;
        }
        if (this.rightBlock != null) {
            double d3 = Math.max(d2 - arrd[2], 0.0);
            RectangleConstraint rectangleConstraint2 = new RectangleConstraint(0.0, new Range(Math.min(arrd[2], d3), d3), LengthConstraintType.RANGE, 0.0, null, LengthConstraintType.NONE);
            Size2D size2D = this.rightBlock.arrange(graphics2D, rectangleConstraint2);
            arrd[3] = size2D.width;
            arrd2[3] = size2D.height;
        }
        arrd2[2] = Math.max(arrd2[2], arrd2[3]);
        arrd2[3] = arrd2[2];
        if (this.centerBlock != null) {
            object = new RectangleConstraint(d2 - arrd[2] - arrd[3], null, LengthConstraintType.FIXED, 0.0, null, LengthConstraintType.NONE);
            Size2D size2D = this.centerBlock.arrange(graphics2D, (RectangleConstraint)object);
            arrd[4] = size2D.width;
            arrd2[4] = size2D.height;
        }
        double d4 = arrd2[0] + arrd2[1] + Math.max(arrd2[2], Math.max(arrd2[3], arrd2[4]));
        return this.arrange(blockContainer, graphics2D, new RectangleConstraint(d2, d4));
    }

    protected Size2D arrangeRR(BlockContainer blockContainer, Range range, Range range2, Graphics2D graphics2D) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        double[] arrd = new double[5];
        double[] arrd2 = new double[5];
        if (this.topBlock != null) {
            object2 = new RectangleConstraint(range, range2);
            object4 = this.topBlock.arrange(graphics2D, (RectangleConstraint)object2);
            arrd[0] = object4.width;
            arrd2[0] = object4.height;
        }
        if (this.bottomBlock != null) {
            object2 = Range.shift(range2, - arrd2[0], false);
            object4 = new RectangleConstraint(range, (Range)object2);
            object3 = this.bottomBlock.arrange(graphics2D, (RectangleConstraint)object4);
            arrd[1] = object3.width;
            arrd2[1] = object3.height;
        }
        object2 = Range.shift(range2, - arrd2[0] + arrd2[1]);
        if (this.leftBlock != null) {
            object4 = new RectangleConstraint(range, (Range)object2);
            object3 = this.leftBlock.arrange(graphics2D, (RectangleConstraint)object4);
            arrd[2] = object3.width;
            arrd2[2] = object3.height;
        }
        object4 = Range.shift(range, - arrd[2], false);
        if (this.rightBlock != null) {
            object3 = new RectangleConstraint((Range)object4, (Range)object2);
            object = this.rightBlock.arrange(graphics2D, (RectangleConstraint)object3);
            arrd[3] = object.width;
            arrd2[3] = object.height;
        }
        arrd2[2] = Math.max(arrd2[2], arrd2[3]);
        arrd2[3] = arrd2[2];
        object3 = Range.shift(range, - arrd[2] + arrd[3], false);
        if (this.centerBlock != null) {
            object = new RectangleConstraint((Range)object3, (Range)object2);
            Size2D size2D = this.centerBlock.arrange(graphics2D, (RectangleConstraint)object);
            arrd[4] = size2D.width;
            arrd2[4] = size2D.height;
        }
        double d2 = Math.max(arrd[0], Math.max(arrd[1], arrd[2] + arrd[4] + arrd[3]));
        double d3 = arrd2[0] + arrd2[1] + Math.max(arrd2[2], Math.max(arrd2[3], arrd2[4]));
        if (this.topBlock != null) {
            this.topBlock.setBounds(new Rectangle2D.Double(0.0, 0.0, d2, arrd2[0]));
        }
        if (this.bottomBlock != null) {
            this.bottomBlock.setBounds(new Rectangle2D.Double(0.0, d3 - arrd2[1], d2, arrd2[1]));
        }
        if (this.leftBlock != null) {
            this.leftBlock.setBounds(new Rectangle2D.Double(0.0, arrd2[0], arrd[2], arrd2[2]));
        }
        if (this.rightBlock != null) {
            this.rightBlock.setBounds(new Rectangle2D.Double(d2 - arrd[3], arrd2[0], arrd[3], arrd2[3]));
        }
        if (this.centerBlock == null) return new Size2D(d2, d3);
        this.centerBlock.setBounds(new Rectangle2D.Double(arrd[2], arrd2[0], d2 - arrd[2] - arrd[3], d3 - arrd2[0] - arrd2[1]));
        return new Size2D(d2, d3);
    }

    protected Size2D arrangeFF(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        Size2D size2D;
        RectangleConstraint rectangleConstraint2;
        double[] arrd = new double[5];
        double[] arrd2 = new double[5];
        arrd[0] = rectangleConstraint.getWidth();
        if (this.topBlock != null) {
            rectangleConstraint2 = new RectangleConstraint(arrd[0], null, LengthConstraintType.FIXED, 0.0, new Range(0.0, rectangleConstraint.getHeight()), LengthConstraintType.RANGE);
            size2D = this.topBlock.arrange(graphics2D, rectangleConstraint2);
            arrd2[0] = size2D.height;
        }
        arrd[1] = arrd[0];
        if (this.bottomBlock != null) {
            rectangleConstraint2 = new RectangleConstraint(arrd[0], null, LengthConstraintType.FIXED, 0.0, new Range(0.0, rectangleConstraint.getHeight() - arrd2[0]), LengthConstraintType.RANGE);
            size2D = this.bottomBlock.arrange(graphics2D, rectangleConstraint2);
            arrd2[1] = size2D.height;
        }
        arrd2[2] = rectangleConstraint.getHeight() - arrd2[1] - arrd2[0];
        if (this.leftBlock != null) {
            rectangleConstraint2 = new RectangleConstraint(0.0, new Range(0.0, rectangleConstraint.getWidth()), LengthConstraintType.RANGE, arrd2[2], null, LengthConstraintType.FIXED);
            size2D = this.leftBlock.arrange(graphics2D, rectangleConstraint2);
            arrd[2] = size2D.width;
        }
        arrd2[3] = arrd2[2];
        if (this.rightBlock != null) {
            rectangleConstraint2 = new RectangleConstraint(0.0, new Range(0.0, rectangleConstraint.getWidth() - arrd[2]), LengthConstraintType.RANGE, arrd2[2], null, LengthConstraintType.FIXED);
            size2D = this.rightBlock.arrange(graphics2D, rectangleConstraint2);
            arrd[3] = size2D.width;
        }
        arrd2[4] = arrd2[2];
        arrd[4] = rectangleConstraint.getWidth() - arrd[3] - arrd[2];
        rectangleConstraint2 = new RectangleConstraint(arrd[4], arrd2[4]);
        if (this.centerBlock != null) {
            this.centerBlock.arrange(graphics2D, rectangleConstraint2);
        }
        if (this.topBlock != null) {
            this.topBlock.setBounds(new Rectangle2D.Double(0.0, 0.0, arrd[0], arrd2[0]));
        }
        if (this.bottomBlock != null) {
            this.bottomBlock.setBounds(new Rectangle2D.Double(0.0, arrd2[0] + arrd2[2], arrd[1], arrd2[1]));
        }
        if (this.leftBlock != null) {
            this.leftBlock.setBounds(new Rectangle2D.Double(0.0, arrd2[0], arrd[2], arrd2[2]));
        }
        if (this.rightBlock != null) {
            this.rightBlock.setBounds(new Rectangle2D.Double(arrd[2] + arrd[4], arrd2[0], arrd[3], arrd2[3]));
        }
        if (this.centerBlock == null) return new Size2D(rectangleConstraint.getWidth(), rectangleConstraint.getHeight());
        this.centerBlock.setBounds(new Rectangle2D.Double(arrd[2], arrd2[0], arrd[4], arrd2[4]));
        return new Size2D(rectangleConstraint.getWidth(), rectangleConstraint.getHeight());
    }

    @Override
    public void clear() {
        this.centerBlock = null;
        this.topBlock = null;
        this.bottomBlock = null;
        this.leftBlock = null;
        this.rightBlock = null;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BorderArrangement)) {
            return false;
        }
        BorderArrangement borderArrangement = (BorderArrangement)object;
        if (!ObjectUtilities.equal(this.topBlock, borderArrangement.topBlock)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.bottomBlock, borderArrangement.bottomBlock)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.leftBlock, borderArrangement.leftBlock)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rightBlock, borderArrangement.rightBlock)) {
            return false;
        }
        if (ObjectUtilities.equal(this.centerBlock, borderArrangement.centerBlock)) return true;
        return false;
    }
}

