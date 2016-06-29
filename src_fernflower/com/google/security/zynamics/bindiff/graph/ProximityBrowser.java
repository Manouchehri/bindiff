package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;
import java.util.List;
import y.c.q;

public class ProximityBrowser extends ZyDefaultProximityBrowser {
   public ProximityBrowser(BinDiffGraph var1) {
      super(var1, var1.getSettings());
      this.blockProximitySettingsListener();
   }

   public void blockProximitySettingsListener() {
      this.removeSettingsListener();
   }

   public void createProximityNodes(List var1) {
      this.createProximityBrowsingNodes(var1);
   }

   public void deleteProximityNode(q var1) {
      this.deleteProximityBrowsingNode(var1);
   }

   public void deleteProximityNodes() {
      this.deleteProximityBrowsingNodes();
   }

   public void freeProximitySettingsListener() {
      this.addSettingsListener();
   }
}
