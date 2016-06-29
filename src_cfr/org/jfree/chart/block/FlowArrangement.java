/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.data.Range;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.Size2D;
import org.jfree.ui.VerticalAlignment;

public class FlowArrangement
implements Serializable,
Arrangement {
    private static final long serialVersionUID = 4543632485478613800L;
    private HorizontalAlignment horizontalAlignment;
    private VerticalAlignment verticalAlignment;
    private double horizontalGap;
    private double verticalGap;

    public FlowArrangement() {
        this(HorizontalAlignment.CENTER, VerticalAlignment.CENTER, 2.0, 2.0);
    }

    public FlowArrangement(HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, double d2, double d3) {
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.horizontalGap = d2;
        this.verticalGap = d3;
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
                return this.arrangeNF(blockContainer, graphics2D, rectangleConstraint);
            }
            if (lengthConstraintType2 != LengthConstraintType.RANGE) throw new RuntimeException("Unrecognised constraint type.");
            throw new RuntimeException("Not implemented.");
        }
        if (lengthConstraintType == LengthConstraintType.FIXED) {
            if (lengthConstraintType2 == LengthConstraintType.NONE) {
                return this.arrangeFN(blockContainer, graphics2D, rectangleConstraint);
            }
            if (lengthConstraintType2 == LengthConstraintType.FIXED) {
                return this.arrangeFF(blockContainer, graphics2D, rectangleConstraint);
            }
            if (lengthConstraintType2 != LengthConstraintType.RANGE) throw new RuntimeException("Unrecognised constraint type.");
            return this.arrangeFR(blockContainer, graphics2D, rectangleConstraint);
        }
        if (lengthConstraintType != LengthConstraintType.RANGE) throw new RuntimeException("Unrecognised constraint type.");
        if (lengthConstraintType2 == LengthConstraintType.NONE) {
            return this.arrangeRN(blockContainer, graphics2D, rectangleConstraint);
        }
        if (lengthConstraintType2 == LengthConstraintType.FIXED) {
            return this.arrangeRF(blockContainer, graphics2D, rectangleConstraint);
        }
        if (lengthConstraintType2 != LengthConstraintType.RANGE) throw new RuntimeException("Unrecognised constraint type.");
        return this.arrangeRR(blockContainer, graphics2D, rectangleConstraint);
    }

    protected Size2D arrangeFN(BlockContainer blockContainer, Graphics2D graphics2D, RectangleConstraint rectangleConstraint) {
        List list = blockContainer.getBlocks();
        double d2 = rectangleConstraint.getWidth();
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        ArrayList<Block> arrayList = new ArrayList<Block>();
        int n2 = 0;
        while (n2 < list.size()) {
            Block block = (Block)list.get(n2);
            Size2D size2D = block.arrange(graphics2D, RectangleConstraint.NONE);
            if (d3 + size2D.width <= d2) {
                arrayList.add(block);
                block.setBounds(new Rectangle2D.Double(d3, d4, size2D.width, size2D.height));
                d3 = d3 + size2D.width + this.horizontalGap;
                d5 = Math.max(d5, size2D.height);
            } else if (arrayList.isEmpty()) {
                block.setBounds(new Rectangle2D.Double(d3, d4, Math.min(size2D.width, d2 - d3), size2D.height));
                d3 = 0.0;
                d4 = d4 + size2D.height + this.verticalGap;
            } else {
                arrayList.clear();
                d3 = 0.0;
                d4 = d4 + d5 + this.verticalGap;
                d5 = size2D.height;
                block.setBounds(new Rectangle2D.Double(d3, d4, Math.min(size2D.width, d2), size2D.height));
                d3 = size2D.width + this.horizontalGap;
                arrayList.add(block);
            }
            ++n2;
        }
        return new Size2D(rectangleConstraint.getWidth(), d4 + d5);
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
        int n2;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        List list = blockContainer.getBlocks();
        int n3 = list.size();
        if (n3 <= 0) return new Size2D(d3, d4);
        Size2D[] arrsize2D = new Size2D[list.size()];
        for (n2 = 0; n2 < list.size(); d3 += arrsize2D[n2].getWidth(), ++n2) {
            Block block = (Block)list.get(n2);
            arrsize2D[n2] = block.arrange(graphics2D, RectangleConstraint.NONE);
            d4 = Math.max(arrsize2D[n2].height, d4);
            block.setBounds(new Rectangle2D.Double(d2, 0.0, arrsize2D[n2].width, arrsize2D[n2].height));
            d2 = d2 + arrsize2D[n2].width + this.horizontalGap;
        }
        if (n3 > 1) {
            d3 += this.horizontalGap * (double)(n3 - 1);
        }
        if (this.verticalAlignment == VerticalAlignment.TOP) return new Size2D(d3, d4);
        n2 = 0;
        while (n2 < list.size()) {
            if (this.verticalAlignment == VerticalAlignment.CENTER || this.verticalAlignment == VerticalAlignment.BOTTOM) {
                // empty if block
            }
            ++n2;
        }
        return new Size2D(d3, d4);
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
        if (!(object instanceof FlowArrangement)) {
            return false;
        }
        FlowArrangement flowArrangement = (FlowArrangement)object;
        if (this.horizontalAlignment != flowArrangement.horizontalAlignment) {
            return false;
        }
        if (this.verticalAlignment != flowArrangement.verticalAlignment) {
            return false;
        }
        if (this.horizontalGap != flowArrangement.horizontalGap) {
            return false;
        }
        if (this.verticalGap == flowArrangement.verticalGap) return true;
        return false;
    }
}

