/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.edges;

public enum EdgeType {
    JUMP_CONDITIONAL_TRUE,
    JUMP_CONDITIONAL_FALSE,
    JUMP_UNCONDITIONAL,
    JUMP_SWITCH,
    JUMP_CONDITIONAL_TRUE_LOOP,
    JUMP_CONDITIONAL_FALSE_LOOP,
    JUMP_UNCONDITIONAL_LOOP,
    ENTER_INLINED_FUNCTION,
    LEAVE_INLINED_FUNCTION,
    INTER_MODULE,
    INTER_ADDRESSSPACE_EDGE,
    TEXTNODE_EDGE,
    DUMMY;
    

    private EdgeType() {
    }

    public static boolean isFalseEdge(EdgeType edgeType) {
        if (edgeType == JUMP_CONDITIONAL_FALSE) return true;
        if (edgeType != JUMP_CONDITIONAL_FALSE_LOOP) return false;
        return true;
    }

    public static boolean isTrueEdge(EdgeType edgeType) {
        if (EdgeType.isFalseEdge(edgeType)) return false;
        return true;
    }
}

