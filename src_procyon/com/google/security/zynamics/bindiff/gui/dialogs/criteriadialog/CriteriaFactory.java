package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.*;

public final class CriteriaFactory
{
    private final AbstractGraphsContainer graphs;
    
    public CriteriaFactory(final AbstractGraphsContainer graphs) {
        if (graphs == null) {
            throw new IllegalArgumentException("Graph container can not be null");
        }
        this.graphs = graphs;
    }
    
    public List getConditions() {
        final ArrayList<ColorCriteriumCreator> list = new ArrayList<ColorCriteriumCreator>();
        list.add(new TextCriteriumCreator());
        list.add((TextCriteriumCreator)new ColorCriteriumCreator(this.graphs));
        list.add((TextCriteriumCreator)new IndegreeCriteriumCreator());
        list.add((TextCriteriumCreator)new OutdegreeCriteriumCreator());
        list.add((TextCriteriumCreator)new RecursionCriteriumCreator());
        list.add((TextCriteriumCreator)new VisibilityCriteriumCreator());
        list.add((TextCriteriumCreator)new CSelectionCriteriumCreator());
        return list;
    }
}
