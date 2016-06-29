package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.JPanel;

public interface ICriterium {
   void addListener(ICriteriumListener var1);

   String getCriteriumDescription();

   JPanel getCriteriumPanel();

   Icon getIcon();

   CriteriumType getType();

   void removeAllListener();

   void removeListener(ICriteriumListener var1);

   boolean matches(ZyGraphNode var1);
}
