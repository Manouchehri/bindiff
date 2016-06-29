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

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

/**
 * Collects all information that is passed to the user data field of a yfiles node.
 * 
 * @param <NodeType> The type of the node.
 */
public class ZyNodeData<NodeType extends ZyGraphNode<? extends IViewNode<?>>> {
  private final NodeType m_node;

  public ZyNodeData(final NodeType node) {
    Preconditions.checkNotNull(node, "Error: Node argument can't be null");

    m_node = node;
  }

  public NodeType getNode() {
    return m_node;
  }

}
