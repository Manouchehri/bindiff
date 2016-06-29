package com.google.security.zynamics.zylib.gui.zygraph.editmode;

public interface IStateActionFactory
{
    IStateAction createBackgroundClickedLeftAction();
    
    IStateAction createBackgroundClickedRightAction();
    
    IStateAction createBackgroundDraggedLeftAction();
    
    IStateAction createBackgroundDraggedRightAction();
    
    IStateAction createBackgroundPressedLeftAction();
    
    IStateAction createBackgroundPressedRightAction();
    
    IStateAction createBendClickedLeftAction();
    
    IStateAction createBendEnterAction();
    
    IStateAction createBendExitAction();
    
    IStateAction createBendHoverAction();
    
    IStateAction createBendPressedLeftAction();
    
    IStateAction createEdgeClickedLeftAction();
    
    IStateAction createEdgeClickedRightAction();
    
    IStateAction createEdgeEnterAction();
    
    IStateAction createEdgeExitAction();
    
    IStateAction createEdgeHoverAction();
    
    IStateAction createEdgeLabelEnterAction();
    
    IStateAction createEdgeLabelExitAction();
    
    IStateAction createEdgeLabelHoverAction();
    
    IStateAction createEdgePressedLeftAction();
    
    IStateAction createEdgePressedRightAction();
    
    IStateAction createNodeClickedLeftAction();
    
    IStateAction createNodeClickedMiddleAction();
    
    IStateAction createNodeClickedRightAction();
    
    IStateAction createNodeDraggedLeftAction();
    
    IStateAction createNodeEditAction();
    
    IStateAction createNodeEditEnterAction();
    
    IStateAction createNodeEditExitAction();
    
    IStateAction createNodeEnterAction();
    
    IStateAction createNodeExitAction();
    
    IStateAction createNodeHoverAction();
    
    IStateAction createNodePressedLeftAction();
    
    IStateAction createNodePressedMiddleAction();
    
    IStateAction createNodePressedRightAction();
}
