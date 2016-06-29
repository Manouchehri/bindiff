package com.google.security.zynamics.zylib.types.graphs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;

public class DefaultEdge implements IGraphEdge {
   private final Object m_source;
   private final Object m_target;

   public DefaultEdge(Object var1, Object var2) {
      this.m_source = Preconditions.checkNotNull(var1, "Error: Source argument can not be null");
      this.m_target = Preconditions.checkNotNull(var2, "Error: Target argument can not be null");
   }

   public Object getSource() {
      return this.m_source;
   }

   public Object getTarget() {
      return this.m_target;
   }
}
