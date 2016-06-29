/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.graph.AbstractGraphsContainer;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;
import java.util.ArrayList;
import java.util.List;

public final class CriteriaFactory {
    private final AbstractGraphsContainer graphs;

    public CriteriaFactory(AbstractGraphsContainer abstractGraphsContainer) {
        if (abstractGraphsContainer == null) {
            throw new IllegalArgumentException("Graph container can not be null");
        }
        this.graphs = abstractGraphsContainer;
    }

    public List getConditions() {
        ArrayList<ICriteriumCreator> arrayList = new ArrayList<ICriteriumCreator>();
        arrayList.add(new TextCriteriumCreator());
        arrayList.add(new ColorCriteriumCreator(this.graphs));
        arrayList.add(new IndegreeCriteriumCreator());
        arrayList.add(new OutdegreeCriteriumCreator());
        arrayList.add(new RecursionCriteriumCreator());
        arrayList.add(new VisibilityCriteriumCreator());
        arrayList.add(new CSelectionCriteriumCreator());
        return arrayList;
    }
}

