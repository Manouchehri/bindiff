/*
Copyright 2011-2016 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

import java.util.HashSet;
import java.util.Set;


public class NodeHelpers {
  public static <NodeType extends IViewNode<?>> int countInvisibleIndegree(final NodeType node) {
    return CollectionHelpers.countIf(node.getIncomingEdges(),
        new ICollectionFilter<IViewEdge<? extends IViewNode<?>>>() {
          @Override
          public boolean qualifies(final IViewEdge<? extends IViewNode<?>> item) {
            return !getVisibleNode(item.getSource()).isVisible();
          }
        });
  }

  public static <NodeType extends IViewNode<?>> int countInvisibleIndegreeNeighbours(
      final NodeType node) {
    final Set<IViewNode<?>> nodeSet = new HashSet<IViewNode<?>>();

    for (final IViewEdge<? extends IViewNode<?>> edge : node.getIncomingEdges()) {
      final IViewNode<?> source = edge.getSource();

      if (!source.isVisible()) {
        nodeSet.add(source);
      }
    }

    return nodeSet.size();
  }

  public static <NodeType extends IViewNode<?>> int countInvisibleOutdegree(final NodeType node) {
    return CollectionHelpers.countIf(node.getOutgoingEdges(),
        new ICollectionFilter<IViewEdge<? extends IViewNode<?>>>() {
          @Override
          public boolean qualifies(final IViewEdge<? extends IViewNode<?>> item) {
            return !getVisibleNode(item.getTarget()).isVisible();
          }
        });
  }

  public static <NodeType extends IViewNode<?>> int countInvisibleOutdegreeNeighbours(
      final NodeType node) {
    final Set<IViewNode<?>> nodeSet = new HashSet<IViewNode<?>>();

    for (final IViewEdge<? extends IViewNode<?>> edge : node.getOutgoingEdges()) {
      final IViewNode<?> target = edge.getTarget();

      if (!target.isVisible()) {
        nodeSet.add(target);
      }
    }

    return nodeSet.size();
  }

  public static IViewNode<?> getVisibleNode(final IViewNode<?> node) {
    IViewNode<?> previousNode = node;
    IGroupNode<?, ?> parentGroup = node.getParentGroup();

    while ((parentGroup != null) && parentGroup.isCollapsed()) {
      previousNode = parentGroup;
      parentGroup = parentGroup.getParentGroup();
    }

    return previousNode;
  }
}
