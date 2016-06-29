package com.google.security.zynamics.zylib.gui.zygraph.edges;

public enum EdgeType
{
    JUMP_CONDITIONAL_TRUE("JUMP_CONDITIONAL_TRUE", 0), 
    JUMP_CONDITIONAL_FALSE("JUMP_CONDITIONAL_FALSE", 1), 
    JUMP_UNCONDITIONAL("JUMP_UNCONDITIONAL", 2), 
    JUMP_SWITCH("JUMP_SWITCH", 3), 
    JUMP_CONDITIONAL_TRUE_LOOP("JUMP_CONDITIONAL_TRUE_LOOP", 4), 
    JUMP_CONDITIONAL_FALSE_LOOP("JUMP_CONDITIONAL_FALSE_LOOP", 5), 
    JUMP_UNCONDITIONAL_LOOP("JUMP_UNCONDITIONAL_LOOP", 6), 
    ENTER_INLINED_FUNCTION("ENTER_INLINED_FUNCTION", 7), 
    LEAVE_INLINED_FUNCTION("LEAVE_INLINED_FUNCTION", 8), 
    INTER_MODULE("INTER_MODULE", 9), 
    INTER_ADDRESSSPACE_EDGE("INTER_ADDRESSSPACE_EDGE", 10), 
    TEXTNODE_EDGE("TEXTNODE_EDGE", 11), 
    DUMMY("DUMMY", 12);
    
    private EdgeType(final String s, final int n) {
    }
    
    public static boolean isFalseEdge(final EdgeType edgeType) {
        return edgeType == EdgeType.JUMP_CONDITIONAL_FALSE || edgeType == EdgeType.JUMP_CONDITIONAL_FALSE_LOOP;
    }
    
    public static boolean isTrueEdge(final EdgeType edgeType) {
        return !isFalseEdge(edgeType);
    }
}
