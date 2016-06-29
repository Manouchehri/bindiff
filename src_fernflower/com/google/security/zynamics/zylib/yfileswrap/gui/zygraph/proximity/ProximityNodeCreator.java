package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyProximityNodeRealizer;
import java.awt.Font;
import y.c.d;
import y.c.q;
import y.h.aB;
import y.h.bu;
import y.h.dr;
import y.h.fj;

public final class ProximityNodeCreator {
   public static ZyProximityNode createProximityNode(bu var0, ZyGraphNode var1, int var2, boolean var3) {
      Preconditions.checkNotNull(var0, "Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Target node argument can not be null");
      ZyLabelContent var4 = new ZyLabelContent((IZyEditableObject)null);
      var4.addLineContent(new ZyLineContent(String.valueOf(var2), new Font("New Courier", 0, 12), (IZyEditableObject)null));
      ZyProximityNodeRealizer var5 = new ZyProximityNodeRealizer(var4);
      q var6 = var0.a((fj)var5);
      ZyProximityNode var7 = new ZyProximityNode(var6, var5, var1, var3);
      ZyNodeData var8 = new ZyNodeData(var7);
      var5.setUserData(var8);
      return var7;
   }

   public static ZyInfoEdge insertProximityEdge(bu var0, ZyGraphNode var1, ZyGraphNode var2) {
      Preconditions.checkNotNull(var0, "Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Source node argument can not be null");
      Preconditions.checkNotNull(var2, "Target node argument can not be null");
      Preconditions.checkArgument(var1 instanceof ZyProximityNode || var2 instanceof ZyProximityNode, "One of the two arguments must be a proximity browsing node");
      ZyEdgeRealizer var3 = new ZyEdgeRealizer(new ZyLabelContent((IZyEditableObject)null), (IEdgeRealizerUpdater)null);
      var3.setLineType(dr.b);
      d var4 = var0.a((q)var1.getNode(), var2.getNode(), (aB)var3);
      ZyInfoEdge var5 = new ZyInfoEdge(var1, var2, var4, var3);
      ZyEdgeData var6 = new ZyEdgeData(var5);
      var3.setUserData(var6);
      return var5;
   }
}
