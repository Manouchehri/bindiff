package com.google.protobuf;

public final class SourceContextProto
{
    static Descriptors$Descriptor internal_static_google_protobuf_SourceContext_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_SourceContext_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;
    
    public static void registerAllExtensions(final ExtensionRegistry extensionRegistry) {
    }
    
    public static Descriptors$FileDescriptor getDescriptor() {
        return SourceContextProto.descriptor;
    }
    
    static {
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n$google/protobuf/source_context.proto\u0012\u000fgoogle.protobuf\"\"\n\rSourceContext\u0012\u0011\n\tfile_name\u0018\u0001 \u0001(\tB1\n\u0013com.google.protobufB\u0012SourceContextProtoP\u0001¢\u0002\u0003GPBb\u0006proto3" }, new Descriptors$FileDescriptor[0], new SourceContextProto$1());
        SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor = getDescriptor().getMessageTypes().get(0);
        SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor, new String[] { "FileName" });
    }
}
