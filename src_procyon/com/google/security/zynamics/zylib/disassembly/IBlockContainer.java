package com.google.security.zynamics.zylib.disassembly;

import java.util.*;

public interface IBlockContainer
{
    List getBasicBlockEdges();
    
    List getBasicBlocks();
    
    String getName();
}
