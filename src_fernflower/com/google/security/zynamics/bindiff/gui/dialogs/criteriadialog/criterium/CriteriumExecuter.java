package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumExecuter$CriteriumFilter;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import java.util.HashSet;
import java.util.Set;

public class CriteriumExecuter {
   public static Set execute(CriteriumTree var0, BinDiffGraph var1) {
      return new HashSet(CollectionHelpers.filter(var1.getNodes(), new CriteriumExecuter$CriteriumFilter(var0)));
   }
}
