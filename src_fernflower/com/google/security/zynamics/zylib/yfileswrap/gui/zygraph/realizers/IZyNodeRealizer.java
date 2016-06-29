package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import y.h.fj;

public interface IZyNodeRealizer {
   void addListener(IZyNodeRealizerListener var1);

   void calcUnionRect(Rectangle2D var1);

   Double getBoundingBox();

   double getCenterX();

   double getCenterY();

   Color getFillColor();

   double getHeight();

   ZyLabelContent getNodeContent();

   fj getRealizer();

   IRealizerUpdater getUpdater();

   ZyNodeData getUserData();

   double getWidth();

   double getX();

   double getY();

   boolean isSelected();

   boolean isVisible();

   int positionToRow(double var1);

   void regenerate();

   void removeListener(IZyNodeRealizerListener var1);

   void repaint();

   double rowToPosition(int var1);

   void setFillColor(Color var1);

   void setHeight(double var1);

   void setLineColor(Color var1);

   void setSelected(boolean var1);

   void setUpdater(IRealizerUpdater var1);

   void setUserData(ZyNodeData var1);

   void setWidth(double var1);

   void setX(double var1);

   void setY(double var1);

   void updateContentSelectionColor();
}
