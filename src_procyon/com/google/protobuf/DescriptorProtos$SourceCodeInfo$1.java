package com.google.protobuf;

final class DescriptorProtos$SourceCodeInfo$1 extends AbstractParser
{
    public DescriptorProtos$SourceCodeInfo parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$SourceCodeInfo(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
