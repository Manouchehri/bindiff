package com.google.protobuf;

public final class TimestampProto
{
    static Descriptors$Descriptor internal_static_google_protobuf_Timestamp_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Timestamp_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;
    
    public static void registerAllExtensions(final ExtensionRegistry extensionRegistry) {
    }
    
    public static Descriptors$FileDescriptor getDescriptor() {
        return TimestampProto.descriptor;
    }
    
    static {
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\u001fgoogle/protobuf/timestamp.proto\u0012\u000fgoogle.protobuf\"+\n\tTimestamp\u0012\u000f\n\u0007seconds\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005nanos\u0018\u0002 \u0001(\u0005BI\n\u0013com.google.protobufB\u000eTimestampProtoP\u0001 \u0001\u0001¢\u0002\u0003GPBª\u0002\u0016Google.ProtocolBuffersb\u0006proto3" }, new Descriptors$FileDescriptor[0], new TimestampProto$1());
        TimestampProto.internal_static_google_protobuf_Timestamp_descriptor = getDescriptor().getMessageTypes().get(0);
        TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(TimestampProto.internal_static_google_protobuf_Timestamp_descriptor, new String[] { "Seconds", "Nanos" });
    }
}
