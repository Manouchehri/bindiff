package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IOperandTreeNode;

public interface IOperandTree {
   int NODE_TYPE_MNEMONIC_ID = 0;
   int NODE_TYPE_SYMBOL_ID = 1;
   int NODE_TYPE_IMMEDIATE_INT_ID = 2;
   int NODE_TYPE_IMMEDIATE_FLOAT_ID = 3;
   int NODE_TYPE_OPERATOR_ID = 4;
   int NODE_TYPE_REGISTER_ID = 5;
   int NODE_TYPE_SIZE_PREFIX_ID = 6;
   int NODE_TYPE_DEREFERENCE_ID = 7;

   IOperandTreeNode getRootNode();
}
