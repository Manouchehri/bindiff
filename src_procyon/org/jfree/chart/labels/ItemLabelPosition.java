package org.jfree.chart.labels;

import java.io.*;
import org.jfree.ui.*;

public class ItemLabelPosition implements Serializable
{
    private static final long serialVersionUID = 5845390630157034499L;
    private ItemLabelAnchor itemLabelAnchor;
    private TextAnchor textAnchor;
    private TextAnchor rotationAnchor;
    private double angle;
    
    public ItemLabelPosition() {
        this(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER, TextAnchor.CENTER, 0.0);
    }
    
    public ItemLabelPosition(final ItemLabelAnchor itemLabelAnchor, final TextAnchor textAnchor) {
        this(itemLabelAnchor, textAnchor, TextAnchor.CENTER, 0.0);
    }
    
    public ItemLabelPosition(final ItemLabelAnchor itemLabelAnchor, final TextAnchor textAnchor, final TextAnchor rotationAnchor, final double angle) {
        if (itemLabelAnchor == null) {
            throw new IllegalArgumentException("Null 'itemLabelAnchor' argument.");
        }
        if (textAnchor == null) {
            throw new IllegalArgumentException("Null 'textAnchor' argument.");
        }
        if (rotationAnchor == null) {
            throw new IllegalArgumentException("Null 'rotationAnchor' argument.");
        }
        this.itemLabelAnchor = itemLabelAnchor;
        this.textAnchor = textAnchor;
        this.rotationAnchor = rotationAnchor;
        this.angle = angle;
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
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ItemLabelPosition)) {
            return false;
        }
        final ItemLabelPosition itemLabelPosition = (ItemLabelPosition)o;
        return this.itemLabelAnchor.equals(itemLabelPosition.itemLabelAnchor) && this.textAnchor.equals(itemLabelPosition.textAnchor) && this.rotationAnchor.equals(itemLabelPosition.rotationAnchor) && this.angle == itemLabelPosition.angle;
    }
}
