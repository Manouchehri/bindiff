package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import java.awt.Color;

public interface IViewNodeListener {
   void changedBorderColor(IViewNode var1, Color var2);

   void changedColor(IViewNode var1, Color var2);

   void changedSelection(IViewNode var1, boolean var2);

   void changedVisibility(IViewNode var1, boolean var2);

   void heightChanged(IViewNode var1, double var2);

   void widthChanged(IViewNode var1, double var2);

   void xposChanged(IViewNode var1, double var2);

   void yposChanged(IViewNode var1, double var2);
}
