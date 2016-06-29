package com.google.protobuf;

final class DescriptorProtos$DescriptorProto$ReservedRange$1 extends AbstractParser
{
    public DescriptorProtos$DescriptorProto$ReservedRange parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$DescriptorProto$ReservedRange(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
