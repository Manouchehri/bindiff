package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.types.common.*;
import java.util.*;

public class CriteriumExecuter
{
    public static Set execute(final CriteriumTree criteriumTree, final BinDiffGraph binDiffGraph) {
        return new HashSet(CollectionHelpers.filter(binDiffGraph.getNodes(), new CriteriumExecuter$CriteriumFilter(criteriumTree)));
    }
}
