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
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitBendsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

import y.base.Edge;
import y.view.Bend;
import y.view.EdgeLabel;
import y.view.HitInfo;

import java.awt.event.MouseEvent;

public class CBendEnterState implements IMouseState {
  private final CStateFactory<?, ?> m_factory;

  private final AbstractZyGraph<?, ?> m_graph;

  private final Bend m_bend;

  public CBendEnterState(final CStateFactory<?, ?> factory, final AbstractZyGraph<?, ?> graph,
      final Bend b) {
    m_factory = Preconditions.checkNotNull(factory, "Error: factory argument can not be null");
    m_graph = Preconditions.checkNotNull(graph, "Error: graph argument can not be null");
    m_bend = Preconditions.checkNotNull(b, "Error: b argument can not be null");
  }

  public Bend getBend() {
    return m_bend;
  }

  public AbstractZyGraph<?, ?> getGraph() {
    return m_graph;
  }

  @Override
  public CStateFactory<? extends ZyGraphNode<?>, ? extends ZyGraphEdge<?, ?, ?>> getStateFactory() {
    return m_factory;
  }

  @Override
  public IMouseStateChange mouseDragged(final MouseEvent event, final AbstractZyGraph<?, ?> graph) {
    return new CStateChange(m_factory.createDefaultState(), true);
  }

  @Override
  public IMouseStateChange mouseMoved(final MouseEvent event, final AbstractZyGraph<?, ?> graph) {
    final double x = m_graph.getEditMode().translateX(event.getX());
    final double y = m_graph.getEditMode().translateY(event.getY());

    final HitInfo hitInfo = m_graph.getGraph().getHitInfo(x, y);

    if (hitInfo.hasHitNodes()) {
      m_factory.createBendExitState(m_bend, event);

      return CHitNodesTransformer.enterNode(m_factory, event, hitInfo);
    } else if (hitInfo.hasHitNodeLabels()) {
      throw new IllegalStateException();
    } else if (hitInfo.hasHitEdges()) {
      final Edge e = hitInfo.getHitEdge();

      m_factory.createBendExitState(m_bend, event);

      return new CStateChange(m_factory.createEdgeEnterState(e, event), true);
    } else if (hitInfo.hasHitEdgeLabels()) {
      final EdgeLabel l = hitInfo.getHitEdgeLabel();

      m_factory.createBendExitState(m_bend, event);

      return new CStateChange(m_factory.createEdgeLabelEnterState(l, event), true);
    } else if (hitInfo.hasHitBends()) {
      return CHitBendsTransformer.changeBend(m_factory, event, hitInfo, m_bend);
    } else if (hitInfo.hasHitPorts()) {
      return new CStateChange(this, true);
    } else {
      // We are in the edge hover state but now there are no more hit edges.
      // That means we just left the edge and we have to undo all GUI changes
      // we made when entering the edge.

      return new CStateChange(m_factory.createBendExitState(m_bend, event), true);
    }
  }

  @Override
  public IMouseStateChange mousePressed(final MouseEvent event, final AbstractZyGraph<?, ?> graph) {
    return new CStateChange(m_factory.createDefaultState(), true);
  }

  @Override
  public IMouseStateChange mouseReleased(final MouseEvent event, final AbstractZyGraph<?, ?> graph) {
    return new CStateChange(m_factory.createDefaultState(), true);
  }
}
