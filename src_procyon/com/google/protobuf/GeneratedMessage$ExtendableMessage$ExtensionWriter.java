package com.google.protobuf;

import java.util.*;

public class GeneratedMessage$ExtendableMessage$ExtensionWriter
{
    private final Iterator iter;
    private Map.Entry next;
    private final boolean messageSetWireFormat;
    final /* synthetic */ GeneratedMessage$ExtendableMessage this$0;
    
    private GeneratedMessage$ExtendableMessage$ExtensionWriter(final GeneratedMessage$ExtendableMessage this$0, final boolean messageSetWireFormat) {
        this.this$0 = this$0;
        this.iter = this.this$0.extensions.iterator();
        if (this.iter.hasNext()) {
            this.next = (Map.Entry)this.iter.next();
        }
        this.messageSetWireFormat = messageSetWireFormat;
    }
    
    public void writeUntil(final int n, final CodedOutputStream codedOutputStream) {
        while (this.next != null && this.next.getKey().getNumber() < n) {
            final Descriptors$FieldDescriptor descriptors$FieldDescriptor = this.next.getKey();
            if (this.messageSetWireFormat && descriptors$FieldDescriptor.getLiteJavaType() == WireFormat$JavaType.MESSAGE && !descriptors$FieldDescriptor.isRepeated()) {
                if (this.next instanceof LazyField$LazyEntry) {
                    codedOutputStream.writeRawMessageSetExtension(descriptors$FieldDescriptor.getNumber(), ((LazyField$LazyEntry)this.next).getField().toByteString());
                }
                else {
                    codedOutputStream.writeMessageSetExtension(descriptors$FieldDescriptor.getNumber(), this.next.getValue());
                }
            }
            else {
                FieldSet.writeField(descriptors$FieldDescriptor, this.next.getValue(), codedOutputStream);
            }
            if (this.iter.hasNext()) {
                this.next = (Map.Entry)this.iter.next();
            }
            else {
                this.next = null;
            }
        }
    }
}
