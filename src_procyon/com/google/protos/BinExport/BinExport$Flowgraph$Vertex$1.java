package com.google.protos.BinExport;

import com.google.protobuf.*;

final class BinExport$Flowgraph$Vertex$1 extends AbstractParser
{
    @Override
    public BinExport$Flowgraph$Vertex parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new BinExport$Flowgraph$Vertex(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
