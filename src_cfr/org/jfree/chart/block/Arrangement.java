/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Graphics2D;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.ui.Size2D;

public interface Arrangement {
    public void add(Block var1, Object var2);

    public Size2D arrange(BlockContainer var1, Graphics2D var2, RectangleConstraint var3);

    public void clear();
}

