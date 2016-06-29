package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import java.awt.Color;
import java.util.List;

public interface IViewNode {
   void addListener(IViewNodeListener var1);

   Color getBorderColor();

   Color getColor();

   double getHeight();

   int getId();

   List getIncomingEdges();

   List getOutgoingEdges();

   IGroupNode getParentGroup();

   double getWidth();

   double getX();

   double getY();

   boolean isSelected();

   boolean isVisible();

   void removeListener(IViewNodeListener var1);

   void setBorderColor(Color var1);

   void setColor(Color var1);

   void setHeight(double var1);

   void setId(int var1);

   void setSelected(boolean var1);

   void setVisible(boolean var1);

   void setWidth(double var1);

   void setX(double var1);

   void setY(double var1);
}
