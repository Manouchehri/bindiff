package com.google.security.zynamics.bindiff.graph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.bindiff.graph.editmode.actions.*;

public class CombinedGraphActionFactory extends CDefaultActionFactory
{
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
