package com.google.protobuf;

public final class AnyProto
{
    static Descriptors$Descriptor internal_static_google_protobuf_Any_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Any_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;
    
    public static void registerAllExtensions(final ExtensionRegistry extensionRegistry) {
    }
    
    public static Descriptors$FileDescriptor getDescriptor() {
        return AnyProto.descriptor;
    }
    
    static {
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\u0019google/protobuf/any.proto\u0012\u000fgoogle.protobuf\"&\n\u0003Any\u0012\u0010\n\btype_url\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\fBC\n\u0013com.google.protobufB\bAnyProtoP\u0001 \u0001\u0001¢\u0002\u0003GPBª\u0002\u0016Google.ProtocolBuffersb\u0006proto3" }, new Descriptors$FileDescriptor[0], new AnyProto$1());
        AnyProto.internal_static_google_protobuf_Any_descriptor = getDescriptor().getMessageTypes().get(0);
        AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(AnyProto.internal_static_google_protobuf_Any_descriptor, new String[] { "TypeUrl", "Value" });
    }
}
