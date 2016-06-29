package com.google.security.zynamics.zylib.gui.zygraph.edges;

import com.google.security.zynamics.zylib.disassembly.ICodeEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdgeListener;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import java.awt.Color;
import java.util.List;

public interface IViewEdge extends ICodeEdge, IGraphEdge {
   void addBend(double var1, double var3);

   void addListener(IViewEdgeListener var1);

   void clearBends();

   int getBendCount();

   List getBends();

   Color getColor();

   int getId();

   EdgeType getType();

   double getX1();

   double getX2();

   double getY1();

   double getY2();

   void insertBend(int var1, double var2, double var4);

   boolean isSelected();

   boolean isVisible();

   void removeBend(int var1);

   void removeListener(IViewEdgeListener var1);

   void setColor(Color var1);

   void setEdgeType(EdgeType var1);

   void setId(int var1);

   void setSelected(boolean var1);

   void setVisible(boolean var1);

   void setX1(double var1);

   void setX2(double var1);

   void setY1(double var1);

   void setY2(double var1);
}
