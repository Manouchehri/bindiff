package com.google.security.zynamics.zylib.types.graphs;

import java.util.*;

public interface IGraphNode
{
    List getChildren();
    
    List getParents();
}
