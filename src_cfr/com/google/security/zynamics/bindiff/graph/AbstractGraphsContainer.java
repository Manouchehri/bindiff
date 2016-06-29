/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;

public abstract class AbstractGraphsContainer
implements Iterable {
    public abstract void dispose();

    public abstract CombinedGraph getCombinedGraph();

    public abstract BinDiffGraph getFocusedGraph();

    public abstract SingleGraph getPrimaryGraph();

    public abstract SingleGraph getSecondaryGraph();

    public abstract GraphSettings getSettings();

    public abstract SuperGraph getSuperGraph();

    public abstract void updateViews();
}

