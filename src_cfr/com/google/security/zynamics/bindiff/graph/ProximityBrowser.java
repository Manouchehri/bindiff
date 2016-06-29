/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;
import java.util.List;
import y.c.q;

public class ProximityBrowser
extends ZyDefaultProximityBrowser {
    public ProximityBrowser(BinDiffGraph binDiffGraph) {
        super(binDiffGraph, binDiffGraph.getSettings());
        this.blockProximitySettingsListener();
    }

    public void blockProximitySettingsListener() {
        this.removeSettingsListener();
    }

    public void createProximityNodes(List list) {
        this.createProximityBrowsingNodes(list);
    }

    public void deleteProximityNode(q q2) {
        this.deleteProximityBrowsingNode(q2);
    }

    public void deleteProximityNodes() {
        this.deleteProximityBrowsingNodes();
    }

    public void freeProximitySettingsListener() {
        this.addSettingsListener();
    }
}

