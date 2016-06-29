/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.awt.geom.Rectangle2D;

public interface IViewableNode {
    public void calcUnionRect(Rectangle2D var1);

    public Rectangle2D.Double getBoundingBox();
}

