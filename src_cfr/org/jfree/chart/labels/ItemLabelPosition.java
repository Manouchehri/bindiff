/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.ui.TextAnchor;

public class ItemLabelPosition
implements Serializable {
    private static final long serialVersionUID = 5845390630157034499L;
    private ItemLabelAnchor itemLabelAnchor;
    private TextAnchor textAnchor;
    private TextAnchor rotationAnchor;
    private double angle;

    public ItemLabelPosition() {
        this(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER, TextAnchor.CENTER, 0.0);
    }

    public ItemLabelPosition(ItemLabelAnchor itemLabelAnchor, TextAnchor textAnchor) {
        this(itemLabelAnchor, textAnchor, TextAnchor.CENTER, 0.0);
    }

    public ItemLabelPosition(ItemLabelAnchor itemLabelAnchor, TextAnchor textAnchor, TextAnchor textAnchor2, double d2) {
        if (itemLabelAnchor == null) {
            throw new IllegalArgumentException("Null 'itemLabelAnchor' argument.");
        }
        if (textAnchor == null) {
            throw new IllegalArgumentException("Null 'textAnchor' argument.");
        }
        if (textAnchor2 == null) {
            throw new IllegalArgumentException("Null 'rotationAnchor' argument.");
        }
        this.itemLabelAnchor = itemLabelAnchor;
        this.textAnchor = textAnchor;
        this.rotationAnchor = textAnchor2;
        this.angle = d2;
    }

    public ItemLabelAnchor getItemLabelAnchor() {
        return this.itemLabelAnchor;
    }

    public TextAnchor getTextAnchor() {
        return this.textAnchor;
    }

    public TextAnchor getRotationAnchor() {
        return this.rotationAnchor;
    }

    public double getAngle() {
        return this.angle;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ItemLabelPosition)) {
            return false;
        }
        ItemLabelPosition itemLabelPosition = (ItemLabelPosition)object;
        if (!this.itemLabelAnchor.equals(itemLabelPosition.itemLabelAnchor)) {
            return false;
        }
        if (!this.textAnchor.equals(itemLabelPosition.textAnchor)) {
            return false;
        }
        if (!this.rotationAnchor.equals(itemLabelPosition.rotationAnchor)) {
            return false;
        }
        if (this.angle == itemLabelPosition.angle) return true;
        return false;
    }
}

