package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import java.util.List;

public interface IGroupNode extends IViewNode {
   void addElement(IViewNode var1);

   List getElements();

   boolean isCollapsed();

   void setCollapsed(boolean var1);
}
