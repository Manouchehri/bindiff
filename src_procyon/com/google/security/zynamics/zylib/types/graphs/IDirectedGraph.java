package com.google.security.zynamics.zylib.types.graphs;

import java.util.*;

public interface IDirectedGraph extends Iterable
{
    int edgeCount();
    
    List getEdges();
    
    List getNodes();
    
    int nodeCount();
}
