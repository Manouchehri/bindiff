/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumExecuter$CriteriumFilter;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CriteriumExecuter {
    public static Set execute(CriteriumTree criteriumTree, BinDiffGraph binDiffGraph) {
        return new HashSet(CollectionHelpers.filter(binDiffGraph.getNodes(), new CriteriumExecuter$CriteriumFilter(criteriumTree)));
    }
}

