package com.google.security.zynamics.zylib.types.graphs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MutableDirectedGraph implements IDirectedGraph, Iterable {
   private final List m_nodes;
   private final List m_edges;
   private final Map m_nodeToEdges = new HashMap();

   public MutableDirectedGraph(List var1, List var2) {
      this.m_nodes = (List)Preconditions.checkNotNull(var1, "Nodes argument can not be null");
      this.m_edges = (List)Preconditions.checkNotNull(var2, "Edges argument can not be null");
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         Preconditions.checkNotNull(var4, "Node list contains null-nodes");
         this.m_nodeToEdges.put(var4, new ArrayList());
      }

      var3 = var2.iterator();

      while(var3.hasNext()) {
         IGraphEdge var5 = (IGraphEdge)var3.next();
         this.updateNodeToEdgeMapping(var5);
      }

   }

   private void updateNodeToEdgeMapping(IGraphEdge var1) {
      Preconditions.checkNotNull(var1, "Error: edge argument can not be null");
      if(this.m_nodeToEdges.get(var1.getSource()) != null) {
         ((List)this.m_nodeToEdges.get(var1.getSource())).add(var1);
         if(this.m_nodeToEdges.get(var1.getTarget()) != null) {
            ((List)this.m_nodeToEdges.get(var1.getTarget())).add(var1);
         } else {
            throw new IllegalStateException("Error: the given edge has a target node which is not known to the graph.");
         }
      } else {
         throw new IllegalStateException("Error: The given edge has a source node which is not known to the graph.");
      }
   }

   public void addEdge(IGraphEdge var1) {
      Preconditions.checkNotNull(var1, "Edge argument can not be null");
      this.m_edges.add(var1);
      this.updateNodeToEdgeMapping(var1);
   }

   public void addNode(Object var1) {
      Preconditions.checkNotNull(var1, "Node argument can not be null");
      this.m_nodes.add(var1);
      this.m_nodeToEdges.put(var1, new ArrayList());
   }

   public int edgeCount() {
      return this.m_edges.size();
   }

   public List getEdges() {
      return Collections.unmodifiableList(this.m_edges);
   }

   public List getNodes() {
      return Collections.unmodifiableList(this.m_nodes);
   }

   public Iterator iterator() {
      return this.m_nodes.iterator();
   }

   public int nodeCount() {
      return this.m_nodes.size();
   }

   public void removeEdge(IGraphEdge var1) {
      Preconditions.checkArgument(this.m_edges.remove(var1), "Error: Edge was not part of the graph");
      ((List)this.m_nodeToEdges.get(var1.getSource())).remove(var1);
      ((List)this.m_nodeToEdges.get(var1.getTarget())).remove(var1);
   }

   public void removeNode(Object var1) {
      Preconditions.checkArgument(this.m_nodes.remove(var1), String.format("Error: Node \'%s\' was not part of the graph", new Object[]{var1}));
      this.m_edges.removeAll((Collection)this.m_nodeToEdges.get(var1));
      this.m_nodeToEdges.remove(var1);
   }
}
