package com.google.security.zynamics.zylib.types.graphs;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DirectedGraph implements IDirectedGraph, Iterable {
   private final List m_nodes;
   private final List m_edges;
   private final HashMultimap m_incomingEdges = HashMultimap.create();
   private final HashMultimap m_outgoingEdges = HashMultimap.create();

   public DirectedGraph(List var1, List var2) {
      Preconditions.checkNotNull(var1, "Error: Nodes argument can not be null");
      Preconditions.checkNotNull(var2, "Error: Edges argument can not be null");
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         IGraphNode var4 = (IGraphNode)var3.next();
         Preconditions.checkNotNull(var4, "Error: Node list contains null-nodes");
      }

      var3 = var2.iterator();

      while(var3.hasNext()) {
         IGraphEdge var5 = (IGraphEdge)var3.next();
         this.m_outgoingEdges.put(var5.getSource(), var5);
         this.m_incomingEdges.put(var5.getTarget(), var5);
      }

      this.m_nodes = var1;
      this.m_edges = var2;
   }

   public int edgeCount() {
      return this.m_edges.size();
   }

   public List getEdges() {
      return Collections.unmodifiableList(this.m_edges);
   }

   public Set getIncomingEdges(IGraphNode var1) {
      return this.m_incomingEdges.get(var1);
   }

   public List getNodes() {
      return Collections.unmodifiableList(this.m_nodes);
   }

   public Set getOutgoingEdges(IGraphNode var1) {
      return this.m_outgoingEdges.get(var1);
   }

   public Iterator iterator() {
      return this.m_nodes.iterator();
   }

   public int nodeCount() {
      return this.m_nodes.size();
   }
}
