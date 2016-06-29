package com.google.protobuf;

public final class DurationProto
{
    static Descriptors$Descriptor internal_static_google_protobuf_Duration_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Duration_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;
    
    public static void registerAllExtensions(final ExtensionRegistry extensionRegistry) {
    }
    
    public static Descriptors$FileDescriptor getDescriptor() {
        return DurationProto.descriptor;
    }
    
    static {
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\u001egoogle/protobuf/duration.proto\u0012\u000fgoogle.protobuf\"*\n\bDuration\u0012\u000f\n\u0007seconds\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005nanos\u0018\u0002 \u0001(\u0005BH\n\u0013com.google.protobufB\rDurationProtoP\u0001 \u0001\u0001¢\u0002\u0003GPBª\u0002\u0016Google.ProtocolBuffersb\u0006proto3" }, new Descriptors$FileDescriptor[0], new DurationProto$1());
        DurationProto.internal_static_google_protobuf_Duration_descriptor = getDescriptor().getMessageTypes().get(0);
        DurationProto.internal_static_google_protobuf_Duration_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(DurationProto.internal_static_google_protobuf_Duration_descriptor, new String[] { "Seconds", "Nanos" });
    }
}
