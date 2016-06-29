/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.editmode;

import com.google.security.zynamics.bindiff.graph.editmode.actions.CombinedNodeClickedLeftAction;
import com.google.security.zynamics.bindiff.graph.editmode.actions.CombinedNodeClickedMiddleAction;
import com.google.security.zynamics.bindiff.graph.editmode.actions.CombinedNodeDraggedLeftAction;
import com.google.security.zynamics.bindiff.graph.editmode.actions.CombinedNodePressedLeftAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CDefaultActionFactory;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;

public class CombinedGraphActionFactory
extends CDefaultActionFactory {
    @Override
    public IStateAction createNodeClickedLeftAction() {
        return new CombinedNodeClickedLeftAction();
    }

    @Override
    public IStateAction createNodeClickedMiddleAction() {
        return new CombinedNodeClickedMiddleAction();
    }

    @Override
    public IStateAction createNodeDraggedLeftAction() {
        return new CombinedNodeDraggedLeftAction();
    }

    @Override
    public IStateAction createNodePressedLeftAction() {
        return new CombinedNodePressedLeftAction();
    }
}

