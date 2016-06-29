/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.block.AbstractBlock;
import org.jfree.chart.block.Block;
import org.jfree.util.PublicCloneable;

public class EmptyBlock
extends AbstractBlock
implements Serializable,
Cloneable,
Block,
PublicCloneable {
    private static final long serialVersionUID = -4083197869412648579L;

    public EmptyBlock(double d2, double d3) {
        this.setWidth(d2);
        this.setHeight(d3);
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
    }

    @Override
    public Object draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Object object) {
        return null;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

