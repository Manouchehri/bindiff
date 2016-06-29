package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.SelectedVisibleFilter;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettings;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ProximityNodeCreator;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$2;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$3;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$4;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$InternalNodeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$InternalSettingsListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$InternalVisibilityListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import y.c.q;

public class ZyDefaultProximityBrowser {
   private boolean m_internallyDisabled = false;
   private final AbstractZyGraph m_graph;
   private final HashMap m_proximityMap = new HashMap();
   private final IProximitySettings m_settings;
   private Set m_lastShown = new HashSet();
   private final ZyDefaultProximityBrowser$InternalVisibilityListener m_visibilityListener = new ZyDefaultProximityBrowser$InternalVisibilityListener(this, (ZyDefaultProximityBrowser$1)null);
   private final ZyDefaultProximityBrowser$InternalSettingsListener m_settingsListener = new ZyDefaultProximityBrowser$InternalSettingsListener(this, (ZyDefaultProximityBrowser$1)null);
   private boolean m_changedProximityBrowsing = false;
   private boolean m_doLayout = true;
   private final Map m_nodeListeners = new HashMap();

   public ZyDefaultProximityBrowser(AbstractZyGraph var1, AbstractZyGraphSettings var2) {
      this.m_graph = var1;
      this.m_settings = var2.getProximitySettings();
      this.addVisibilityListener();
      this.addSettingsListener();
   }

   private void disableProximityBrowsing() {
      if(this.hasAnyHiddenNodes()) {
         this.unhideEverything();
         this.deleteProximityBrowsingNodes();
         this.updateViews();
      }

   }

   private List filterGroupedNodes(List var1) {
      return CollectionHelpers.filter(var1, new ZyDefaultProximityBrowser$1(this));
   }

   private ZyGraphNode getVisibleNode(ZyGraphNode var1) {
      ZyGraphNode var2 = var1;

      for(IGroupNode var3 = var1.getRawNode().getParentGroup(); var3 != null && var3.isCollapsed(); var3 = var3.getParentGroup()) {
         var2 = this.m_graph.getNode((Object)var3);
      }

      return var2;
   }

   private boolean hasAnyHiddenNodes() {
      return GraphHelpers.any(this.m_graph, new ZyDefaultProximityBrowser$2(this));
   }

   private void restartProximityBrowsing() {
      this.m_lastShown = new HashSet();
      Collection var1 = SelectedVisibleFilter.filter(this.m_graph.getSelectedNodes());
      if(!var1.isEmpty()) {
         List var2 = GraphHelpers.getNodes(this.m_graph);
         var2.removeAll(var1);
         this.m_graph.showNodes(var1, var2);
         this.updateViews();
      }

   }

   private void setActive() {
      if(!this.m_graph.getSettings().getProximitySettings().getProximityBrowsing()) {
         this.disableProximityBrowsing();
      } else {
         this.restartProximityBrowsing();
      }

   }

   private void unhideEverything() {
      this.m_graph.iterate((INodeCallback)(new ZyDefaultProximityBrowser$3(this)));
      this.m_graph.iterateEdges(new ZyDefaultProximityBrowser$4(this));
   }

   private void updateProximityBrowsing(Set var1) {
      if(this.m_graph.getSettings().getProximitySettings().getProximityBrowsing() && !this.m_internallyDisabled) {
         if(!this.m_lastShown.equals(var1)) {
            this.m_lastShown = new HashSet(var1);
            this.m_internallyDisabled = true;
            this.deleteProximityBrowsingNodes();
            List var2 = GraphHelpers.getNodes(this.m_graph);
            this.createProximityBrowsingNodes(var2);
            this.updateViews();
            this.m_internallyDisabled = false;
         }
      }
   }

   private void updateViews() {
      if(this.m_graph.getSettings().getLayoutSettings().getAutomaticLayouting() && this.m_doLayout) {
         this.m_graph.doLayout();
      }

      this.m_graph.updateViews();
   }

   protected void addSettingsListener() {
      this.m_settings.addListener(this.m_settingsListener);
   }

   protected void addVisibilityListener() {
      this.m_graph.addListener((IZyGraphVisibilityListener)this.m_visibilityListener);
   }

   protected void createProximityBrowsingNodes(List var1) {
      Iterator var2 = this.filterGroupedNodes(var1).iterator();

      while(var2.hasNext()) {
         ZyGraphNode var3 = (ZyGraphNode)var2.next();
         if(var3.isVisible()) {
            int var4 = NodeHelpers.countInvisibleIndegreeNeighbours(var3.getRawNode());
            if(var4 > 0) {
               ZyProximityNode var5 = ProximityNodeCreator.createProximityNode(this.m_graph.getGraph(), var3, var4, false);
               ZyDefaultProximityBrowser$InternalNodeListener var6 = new ZyDefaultProximityBrowser$InternalNodeListener(this, var3.getX(), var3.getY(), var5);
               var3.getRawNode().addListener(var6);
               this.m_nodeListeners.put(var5, var6);
               this.m_proximityMap.put(var5.getNode(), var5);
               ProximityNodeCreator.insertProximityEdge(this.m_graph.getGraph(), var5, this.getVisibleNode(var3));
            }

            int var8 = NodeHelpers.countInvisibleOutdegreeNeighbours(var3.getRawNode());
            if(var8 > 0) {
               ZyProximityNode var9 = ProximityNodeCreator.createProximityNode(this.m_graph.getGraph(), var3, var8, true);
               ZyDefaultProximityBrowser$InternalNodeListener var7 = new ZyDefaultProximityBrowser$InternalNodeListener(this, var3.getX(), var3.getY(), var9);
               var3.getRawNode().addListener(var7);
               this.m_nodeListeners.put(var9, var7);
               this.m_proximityMap.put(var9.getNode(), var9);
               ProximityNodeCreator.insertProximityEdge(this.m_graph.getGraph(), this.getVisibleNode(var3), var9);
            }
         }
      }

   }

   protected void deleteProximityBrowsingNode(q var1) {
      ZyProximityNode var2 = (ZyProximityNode)this.m_proximityMap.get(var1);
      this.m_nodeListeners.remove(var2);
      this.m_proximityMap.remove(var1);
      this.m_graph.getGraph().a((q)var1);
   }

   protected void deleteProximityBrowsingNodes() {
      this.m_internallyDisabled = true;
      Iterator var1 = this.m_proximityMap.keySet().iterator();

      while(var1.hasNext()) {
         q var2 = (q)var1.next();
         this.m_graph.getGraph().a((q)var2);
      }

      this.m_proximityMap.clear();
      var1 = this.m_nodeListeners.entrySet().iterator();

      while(var1.hasNext()) {
         Entry var3 = (Entry)var1.next();
         ((ZyProximityNode)var3.getKey()).getRawNode().getAttachedNode().removeListener((IViewNodeListener)var3.getValue());
      }

      this.m_nodeListeners.clear();
      this.m_internallyDisabled = false;
   }

   protected void removeSettingsListener() {
      this.m_settings.removeListener(this.m_settingsListener);
   }

   protected void removeVisibilityListener() {
      this.m_graph.removeListener((IZyGraphVisibilityListener)this.m_visibilityListener);
   }

   public void dispose() {
      this.removeVisibilityListener();
      this.removeSettingsListener();
   }

   public void setEnabled(boolean var1) {
      if(var1) {
         this.m_graph.getSettings().getProximitySettings().addListener(this.m_settingsListener);
      } else {
         this.m_graph.getSettings().getProximitySettings().removeListener(this.m_settingsListener);
      }

   }

   // $FF: synthetic method
   static ZyGraphNode access$200(ZyDefaultProximityBrowser var0, ZyGraphNode var1) {
      return var0.getVisibleNode(var1);
   }

   // $FF: synthetic method
   static boolean access$302(ZyDefaultProximityBrowser var0, boolean var1) {
      return var0.m_changedProximityBrowsing = var1;
   }

   // $FF: synthetic method
   static void access$400(ZyDefaultProximityBrowser var0) {
      var0.setActive();
   }

   // $FF: synthetic method
   static AbstractZyGraph access$500(ZyDefaultProximityBrowser var0) {
      return var0.m_graph;
   }

   // $FF: synthetic method
   static void access$600(ZyDefaultProximityBrowser var0) {
      var0.restartProximityBrowsing();
   }

   // $FF: synthetic method
   static Set access$700(ZyDefaultProximityBrowser var0) {
      return var0.m_lastShown;
   }

   // $FF: synthetic method
   static void access$800(ZyDefaultProximityBrowser var0, Set var1) {
      var0.updateProximityBrowsing(var1);
   }

   // $FF: synthetic method
   static boolean access$300(ZyDefaultProximityBrowser var0) {
      return var0.m_changedProximityBrowsing;
   }

   // $FF: synthetic method
   static boolean access$902(ZyDefaultProximityBrowser var0, boolean var1) {
      return var0.m_doLayout = var1;
   }
}
