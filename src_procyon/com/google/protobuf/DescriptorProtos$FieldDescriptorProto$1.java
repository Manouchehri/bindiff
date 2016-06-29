package com.google.protobuf;

final class DescriptorProtos$FieldDescriptorProto$1 extends AbstractParser
{
    public DescriptorProtos$FieldDescriptorProto parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$FieldDescriptorProto(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
