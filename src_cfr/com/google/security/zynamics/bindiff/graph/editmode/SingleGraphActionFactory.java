/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.editmode;

import com.google.security.zynamics.bindiff.graph.editmode.actions.SingleGraphNodeDraggedLeftAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CDefaultActionFactory;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;

public class SingleGraphActionFactory
extends CDefaultActionFactory {
    @Override
    public IStateAction createNodeDraggedLeftAction() {
        return new SingleGraphNodeDraggedLeftAction();
    }
}

