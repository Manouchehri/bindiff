package com.google.protobuf;

final class DescriptorProtos$UninterpretedOption$1 extends AbstractParser
{
    public DescriptorProtos$UninterpretedOption parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$UninterpretedOption(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
