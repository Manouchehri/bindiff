package com.google.protobuf;

public final class FieldMaskProto
{
    static Descriptors$Descriptor internal_static_google_protobuf_FieldMask_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_FieldMask_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;
    
    public static void registerAllExtensions(final ExtensionRegistry extensionRegistry) {
    }
    
    public static Descriptors$FileDescriptor getDescriptor() {
        return FieldMaskProto.descriptor;
    }
    
    static {
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n google/protobuf/field_mask.proto\u0012\u000fgoogle.protobuf\"\u001a\n\tFieldMask\u0012\r\n\u0005paths\u0018\u0001 \u0003(\tBF\n\u0013com.google.protobufB\u000eFieldMaskProtoP\u0001¢\u0002\u0003GPBª\u0002\u0016Google.ProtocolBuffersb\u0006proto3" }, new Descriptors$FileDescriptor[0], new FieldMaskProto$1());
        FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor = getDescriptor().getMessageTypes().get(0);
        FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor, new String[] { "Paths" });
    }
}
