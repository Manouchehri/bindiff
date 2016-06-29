package com.google.protobuf;

import java.io.*;

public final class UnknownFieldSet$Parser extends AbstractParser
{
    public UnknownFieldSet parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        final UnknownFieldSet$Builder builder = UnknownFieldSet.newBuilder();
        try {
            builder.mergeFrom(codedInputStream);
        }
        catch (InvalidProtocolBufferException ex) {
            throw ex.setUnfinishedMessage(builder.buildPartial());
        }
        catch (IOException ex2) {
            throw new InvalidProtocolBufferException(ex2.getMessage()).setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
    }
}
