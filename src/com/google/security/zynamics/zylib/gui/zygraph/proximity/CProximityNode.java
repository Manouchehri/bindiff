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
package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import java.awt.Color;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;

/**
 * Represents the raw node of a proximity node. That means this class provides background
 * information used to draw the proximity browsing node.
 */
public class CProximityNode<T extends IViewNode<?>> extends CViewNode<IViewEdge<CProximityNode<T>>>
    implements IViewNode<IViewEdge<CProximityNode<T>>> {
  /**
   * Raw node the proximity node is connected to.
   */
  private final T m_attachedNode;

  /**
   * Creates a new proximity node.
   * 
   * @param attachedNode Raw node the proximity node is connected to.
   */
  public CProximityNode(final T attachedNode) {
    super(0, 0, 0, 0, 0, Color.WHITE, Color.BLACK, false, false);

    m_attachedNode =
        Preconditions.checkNotNull(attachedNode, "Error: Attached node argument can not be null");
  }

  /**
   * Returns the real graph node the proximity node is attached to.
   * 
   * @return The real graph node the proximity node is attached to.
   */
  public T getAttachedNode() {
    return m_attachedNode;
  }

  @Override
  public Color getColor() {
    return Color.WHITE;
  }

  @Override
  public int getId() {
    return -1;
  }

  @Override
  public IGroupNode<T, IViewEdge<T>> getParentGroup() {
    return null;
  }

  @Override
  public double getX() {
    return 0;
  }

  @Override
  public double getY() {
    return 0;
  }

  @Override
  public boolean isSelected() {
    return false;
  }

  @Override
  public boolean isVisible() {
    return true;
  }

  @Override
  public void setColor(final Color color) {
    throw new UnsupportedOperationException("Error: Proximity browsing nodes can not change colors");
  }
}
