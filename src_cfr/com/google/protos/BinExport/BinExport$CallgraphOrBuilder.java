/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.MessageOrBuilder;
import com.google.protos.BinExport.BinExport$Callgraph$Edge;
import com.google.protos.BinExport.BinExport$Callgraph$EdgeOrBuilder;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex;
import com.google.protos.BinExport.BinExport$Callgraph$VertexOrBuilder;
import java.util.List;

public interface BinExport$CallgraphOrBuilder
extends MessageOrBuilder {
    public List getVerticesList();

    public BinExport$Callgraph$Vertex getVertices(int var1);

    public int getVerticesCount();

    public List getVerticesOrBuilderList();

    public BinExport$Callgraph$VertexOrBuilder getVerticesOrBuilder(int var1);

    public List getEdgesList();

    public BinExport$Callgraph$Edge getEdges(int var1);

    public int getEdgesCount();

    public List getEdgesOrBuilderList();

    public BinExport$Callgraph$EdgeOrBuilder getEdgesOrBuilder(int var1);
}

