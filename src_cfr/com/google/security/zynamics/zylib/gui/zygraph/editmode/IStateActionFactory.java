/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;

public interface IStateActionFactory {
    public IStateAction createBackgroundClickedLeftAction();

    public IStateAction createBackgroundClickedRightAction();

    public IStateAction createBackgroundDraggedLeftAction();

    public IStateAction createBackgroundDraggedRightAction();

    public IStateAction createBackgroundPressedLeftAction();

    public IStateAction createBackgroundPressedRightAction();

    public IStateAction createBendClickedLeftAction();

    public IStateAction createBendEnterAction();

    public IStateAction createBendExitAction();

    public IStateAction createBendHoverAction();

    public IStateAction createBendPressedLeftAction();

    public IStateAction createEdgeClickedLeftAction();

    public IStateAction createEdgeClickedRightAction();

    public IStateAction createEdgeEnterAction();

    public IStateAction createEdgeExitAction();

    public IStateAction createEdgeHoverAction();

    public IStateAction createEdgeLabelEnterAction();

    public IStateAction createEdgeLabelExitAction();

    public IStateAction createEdgeLabelHoverAction();

    public IStateAction createEdgePressedLeftAction();

    public IStateAction createEdgePressedRightAction();

    public IStateAction createNodeClickedLeftAction();

    public IStateAction createNodeClickedMiddleAction();

    public IStateAction createNodeClickedRightAction();

    public IStateAction createNodeDraggedLeftAction();

    public IStateAction createNodeEditAction();

    public IStateAction createNodeEditEnterAction();

    public IStateAction createNodeEditExitAction();

    public IStateAction createNodeEnterAction();

    public IStateAction createNodeExitAction();

    public IStateAction createNodeHoverAction();

    public IStateAction createNodePressedLeftAction();

    public IStateAction createNodePressedMiddleAction();

    public IStateAction createNodePressedRightAction();
}

