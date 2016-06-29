package com.google.protobuf;

import java.util.*;

public class GeneratedMessageLite$ExtendableMessage$ExtensionWriter
{
    private final Iterator iter;
    private Map.Entry next;
    private final boolean messageSetWireFormat;
    final /* synthetic */ GeneratedMessageLite$ExtendableMessage this$0;
    
    private GeneratedMessageLite$ExtendableMessage$ExtensionWriter(final GeneratedMessageLite$ExtendableMessage this$0, final boolean messageSetWireFormat) {
        this.this$0 = this$0;
        this.iter = this.this$0.extensions.iterator();
        if (this.iter.hasNext()) {
            this.next = (Map.Entry)this.iter.next();
        }
        this.messageSetWireFormat = messageSetWireFormat;
    }
    
    public void writeUntil(final int n, final CodedOutputStream codedOutputStream) {
        while (this.next != null && this.next.getKey().getNumber() < n) {
            final GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor = this.next.getKey();
            if (this.messageSetWireFormat && generatedMessageLite$ExtensionDescriptor.getLiteJavaType() == WireFormat$JavaType.MESSAGE && !generatedMessageLite$ExtensionDescriptor.isRepeated()) {
                codedOutputStream.writeMessageSetExtension(generatedMessageLite$ExtensionDescriptor.getNumber(), this.next.getValue());
            }
            else {
                FieldSet.writeField(generatedMessageLite$ExtensionDescriptor, this.next.getValue(), codedOutputStream);
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
