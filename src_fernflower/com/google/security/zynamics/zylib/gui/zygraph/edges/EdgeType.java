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

   public static boolean isFalseEdge(EdgeType var0) {
      return var0 == JUMP_CONDITIONAL_FALSE || var0 == JUMP_CONDITIONAL_FALSE_LOOP;
   }

   public static boolean isTrueEdge(EdgeType var0) {
      return !isFalseEdge(var0);
   }
}
