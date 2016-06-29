package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import java.awt.Color;

public class CProximityNode extends CViewNode implements IViewNode {
   private final IViewNode m_attachedNode;

   public CProximityNode(IViewNode var1) {
      super(0, 0.0D, 0.0D, 0.0D, 0.0D, Color.WHITE, Color.BLACK, false, false);
      this.m_attachedNode = (IViewNode)Preconditions.checkNotNull(var1, "Error: Attached node argument can not be null");
   }

   public IViewNode getAttachedNode() {
      return this.m_attachedNode;
   }

   public Color getColor() {
      return Color.WHITE;
   }

   public int getId() {
      return -1;
   }

   public IGroupNode getParentGroup() {
      return null;
   }

   public double getX() {
      return 0.0D;
   }

   public double getY() {
      return 0.0D;
   }

   public boolean isSelected() {
      return false;
   }

   public boolean isVisible() {
      return true;
   }

   public void setColor(Color var1) {
      throw new UnsupportedOperationException("Error: Proximity browsing nodes can not change colors");
   }
}
