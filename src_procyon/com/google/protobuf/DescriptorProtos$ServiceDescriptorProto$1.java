package com.google.protobuf;

final class DescriptorProtos$ServiceDescriptorProto$1 extends AbstractParser
{
    public DescriptorProtos$ServiceDescriptorProto parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$ServiceDescriptorProto(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
