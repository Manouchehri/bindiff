package com.google.security.zynamics.zylib.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.*;

public class CDefaultActionFactory implements IStateActionFactory
{
    @Override
    public IStateAction createBackgroundClickedLeftAction() {
        return new CDefaultBackgroundClickedLeftAction();
    }
    
    @Override
    public IStateAction createBackgroundClickedRightAction() {
        return new CDefaultBackgroundClickedRightAction();
    }
    
    @Override
    public IStateAction createBackgroundDraggedLeftAction() {
        return new CDefaultBackgroundDraggedLeftAction();
    }
    
    @Override
    public IStateAction createBackgroundDraggedRightAction() {
        return new CDefaultBackgroundDraggedRightAction();
    }
    
    @Override
    public IStateAction createBackgroundPressedLeftAction() {
        return new CDefaultBackgroundPressedLeftAction();
    }
    
    @Override
    public IStateAction createBackgroundPressedRightAction() {
        return new CDefaultBackgroundPressedRightAction();
    }
    
    @Override
    public IStateAction createBendClickedLeftAction() {
        return new CDefaultBendClickedLeftAction();
    }
    
    @Override
    public IStateAction createBendEnterAction() {
        return new CDefaultBendEnterAction();
    }
    
    @Override
    public IStateAction createBendExitAction() {
        return new CDefaultBendExitAction();
    }
    
    @Override
    public IStateAction createBendHoverAction() {
        return new CDefaultBendHoverAction();
    }
    
    @Override
    public IStateAction createBendPressedLeftAction() {
        return new CDefaultBendPressedLeftAction();
    }
    
    @Override
    public IStateAction createEdgeClickedLeftAction() {
        return new CDefaultEdgeClickedLeftAction();
    }
    
    @Override
    public IStateAction createEdgeClickedRightAction() {
        return new CDefaultEdgeClickedRightAction();
    }
    
    @Override
    public IStateAction createEdgeEnterAction() {
        return new CDefaultEdgeEnterAction();
    }
    
    @Override
    public IStateAction createEdgeExitAction() {
        return new CDefaultEdgeExitAction();
    }
    
    @Override
    public IStateAction createEdgeHoverAction() {
        return new CDefaultEdgeHoverAction();
    }
    
    @Override
    public IStateAction createEdgeLabelEnterAction() {
        return new CDefaultEdgeLabelEnterAction();
    }
    
    @Override
    public IStateAction createEdgeLabelExitAction() {
        return new CDefaultEdgeLabelExitAction();
    }
    
    @Override
    public IStateAction createEdgeLabelHoverAction() {
        return new CDefaultEdgeLabelHoverAction();
    }
    
    @Override
    public IStateAction createEdgePressedLeftAction() {
        return new CDefaultEdgePressedLeftAction();
    }
    
    @Override
    public IStateAction createEdgePressedRightAction() {
        return new CDefaultEdgePressedRightAction();
    }
    
    @Override
    public IStateAction createNodeClickedLeftAction() {
        return new CDefaultNodeClickedLeftAction();
    }
    
    @Override
    public IStateAction createNodeClickedMiddleAction() {
        return new CDefaultNodeClickedMiddleAction();
    }
    
    @Override
    public IStateAction createNodeClickedRightAction() {
        return new CDefaultNodeClickedRightAction();
    }
    
    @Override
    public IStateAction createNodeDraggedLeftAction() {
        return new CDefaultNodeDraggedLeftAction();
    }
    
    @Override
    public IStateAction createNodeEditAction() {
        return new CDefaultNodeEditAction();
    }
    
    @Override
    public IStateAction createNodeEditEnterAction() {
        return new CDefaultNodeEditEnterAction();
    }
    
    @Override
    public IStateAction createNodeEditExitAction() {
        return new CDefaultNodeEditExitAction();
    }
    
    @Override
    public IStateAction createNodeEnterAction() {
        return new CDefaultNodeEnterAction();
    }
    
    @Override
    public IStateAction createNodeExitAction() {
        return new CDefaultNodeExitAction();
    }
    
    @Override
    public IStateAction createNodeHoverAction() {
        return new CDefaultNodeHoverAction();
    }
    
    @Override
    public IStateAction createNodePressedLeftAction() {
        return new CDefaultNodePressedLeftAction();
    }
    
    @Override
    public IStateAction createNodePressedMiddleAction() {
        return new CDefaultNodePressedMiddleAction();
    }
    
    @Override
    public IStateAction createNodePressedRightAction() {
        return new CDefaultNodePressedRightAction();
    }
}
