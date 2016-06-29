package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import java.util.*;
import y.c.*;

public class ProximityBrowser extends ZyDefaultProximityBrowser
{
    public ProximityBrowser(final BinDiffGraph binDiffGraph) {
        super(binDiffGraph, binDiffGraph.getSettings());
        this.blockProximitySettingsListener();
    }
    
    public void blockProximitySettingsListener() {
        this.removeSettingsListener();
    }
    
    public void createProximityNodes(final List list) {
        this.createProximityBrowsingNodes(list);
    }
    
    public void deleteProximityNode(final q q) {
        this.deleteProximityBrowsingNode(q);
    }
    
    public void deleteProximityNodes() {
        this.deleteProximityBrowsingNodes();
    }
    
    public void freeProximitySettingsListener() {
        this.addSettingsListener();
    }
}
