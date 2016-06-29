package com.google.protobuf;

final class DescriptorProtos$FileDescriptorSet$1 extends AbstractParser
{
    public DescriptorProtos$FileDescriptorSet parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$FileDescriptorSet(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
