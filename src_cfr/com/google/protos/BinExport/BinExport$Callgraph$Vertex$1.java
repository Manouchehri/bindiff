/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex;

final class BinExport$Callgraph$Vertex$1
extends AbstractParser {
    BinExport$Callgraph$Vertex$1() {
    }

    @Override
    public BinExport$Callgraph$Vertex parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new BinExport$Callgraph$Vertex(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException var3_3) {
            if (!(var3_3.getCause() instanceof InvalidProtocolBufferException)) throw var3_3;
            throw (InvalidProtocolBufferException)var3_3.getCause();
        }
    }
}

