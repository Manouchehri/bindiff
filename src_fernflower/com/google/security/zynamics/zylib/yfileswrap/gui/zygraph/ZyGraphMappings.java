package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import y.c.d;
import y.c.q;
import y.h.bu;

public class ZyGraphMappings {
   private final Map m_edgeMap;
   private final Map m_rawEdgeMap;
   private final Map m_nodeMap;
   private final Map m_rawNodeMap;
   private final bu m_graph;

   public ZyGraphMappings(bu var1, Map var2, Map var3) {
      this.m_graph = var1;
      this.m_nodeMap = Maps.newHashMap(var2);
      this.m_rawNodeMap = Maps.newHashMap();
      this.m_edgeMap = Maps.newHashMap(var3);
      this.m_rawEdgeMap = Maps.newHashMap();
      Iterator var4 = var3.values().iterator();

      while(var4.hasNext()) {
         ZyGraphEdge var5 = (ZyGraphEdge)var4.next();
         this.m_rawEdgeMap.put(var5.getRawEdge(), var5);
      }

      var4 = var2.values().iterator();

      while(var4.hasNext()) {
         ZyGraphNode var6 = (ZyGraphNode)var4.next();
         this.m_rawNodeMap.put(var6.getRawNode(), var6);
      }

   }

   public void addEdge(d var1, ZyGraphEdge var2) {
      this.m_edgeMap.put(var1, var2);
      this.m_rawEdgeMap.put(var2.getRawEdge(), var2);
   }

   public void addNode(q var1, ZyGraphNode var2) {
      this.m_nodeMap.put(var1, var2);
      this.m_rawNodeMap.put(var2.getRawNode(), var2);
   }

   public ZyGraphEdge getEdge(d var1) {
      if(var1.a() != this.m_graph) {
         return null;
      } else {
         ZyGraphEdge var2 = (ZyGraphEdge)((ZyEdgeRealizer)this.m_graph.i(var1)).getUserData().getEdge();
         return var2;
      }
   }

   public ZyGraphEdge getEdge(Object var1) {
      return (ZyGraphEdge)this.m_rawEdgeMap.get(var1);
   }

   public Collection getEdges() {
      return this.m_edgeMap.values();
   }

   public ZyGraphNode getNode(q var1) {
      Preconditions.checkNotNull(var1, "Node argument cannot be null");
      return (ZyGraphNode)this.m_nodeMap.get(var1);
   }

   public ZyGraphNode getNode(Object var1) {
      return (ZyGraphNode)this.m_rawNodeMap.get(var1);
   }

   public Collection getNodes() {
      return this.m_nodeMap.values();
   }

   public d getYEdge(Object var1) {
      return ((ZyGraphEdge)this.m_rawEdgeMap.get(var1)).getEdge();
   }

   public q getYNode(Object var1) {
      return this.m_rawNodeMap.containsKey(var1)?((ZyGraphNode)this.m_rawNodeMap.get(var1)).getNode():null;
   }

   public void removeEdge(ZyGraphEdge var1) {
      this.m_edgeMap.remove(var1.getEdge());
      this.m_rawEdgeMap.remove(var1.getRawEdge());
   }

   public void removeNode(ZyGraphNode var1) {
      this.m_nodeMap.remove(var1.getNode());
      this.m_rawNodeMap.remove(var1.getRawNode());
   }

   public void setEdge(Object var1, ZyGraphEdge var2) {
      this.m_rawEdgeMap.put(var1, var2);
   }

   public void setNode(Object var1, ZyGraphNode var2) {
      this.m_rawNodeMap.put(var1, var2);
   }
}
