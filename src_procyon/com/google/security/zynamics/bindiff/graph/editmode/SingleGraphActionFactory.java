package com.google.security.zynamics.bindiff.graph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.bindiff.graph.editmode.actions.*;

public class SingleGraphActionFactory extends CDefaultActionFactory
{
    @Override
    public IStateAction createNodeDraggedLeftAction() {
        return new SingleGraphNodeDraggedLeftAction();
    }
}
