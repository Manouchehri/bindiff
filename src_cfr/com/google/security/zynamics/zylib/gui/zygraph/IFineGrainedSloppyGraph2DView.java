/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph;

public interface IFineGrainedSloppyGraph2DView {
    public boolean drawEdges();

    public boolean isEdgeSloppyPaintMode();

    public boolean isNodeSloppyPaintMode();

    public void setEdgeSloppyThreshold(double var1);

    public void setMinEdgesForSloppyEdgeHiding(int var1);

    public void setNodeSloppyThreshold(double var1);

    public void setSloppyEdgeHidingThreshold(double var1);
}

