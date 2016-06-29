/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.MessageOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge;
import com.google.protos.BinExport.BinExport$Flowgraph$EdgeOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex;
import com.google.protos.BinExport.BinExport$Flowgraph$VertexOrBuilder;
import java.util.List;

public interface BinExport$FlowgraphOrBuilder
extends MessageOrBuilder {
    public boolean hasAddress();

    public long getAddress();

    public List getVerticesList();

    public BinExport$Flowgraph$Vertex getVertices(int var1);

    public int getVerticesCount();

    public List getVerticesOrBuilderList();

    public BinExport$Flowgraph$VertexOrBuilder getVerticesOrBuilder(int var1);

    public List getEdgesList();

    public BinExport$Flowgraph$Edge getEdges(int var1);

    public int getEdgesCount();

    public List getEdgesOrBuilderList();

    public BinExport$Flowgraph$EdgeOrBuilder getEdgesOrBuilder(int var1);
}

