/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$ExtendableMessage;
import com.google.protobuf.LazyField;
import com.google.protobuf.LazyField$LazyEntry;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat$JavaType;
import java.util.Iterator;
import java.util.Map;

public class GeneratedMessage$ExtendableMessage$ExtensionWriter {
    private final Iterator iter;
    private Map.Entry next;
    private final boolean messageSetWireFormat;
    final /* synthetic */ GeneratedMessage$ExtendableMessage this$0;

    private GeneratedMessage$ExtendableMessage$ExtensionWriter(GeneratedMessage$ExtendableMessage generatedMessage$ExtendableMessage, boolean bl2) {
        this.this$0 = generatedMessage$ExtendableMessage;
        this.iter = GeneratedMessage$ExtendableMessage.access$600(this.this$0).iterator();
        if (this.iter.hasNext()) {
            this.next = (Map.Entry)this.iter.next();
        }
        this.messageSetWireFormat = bl2;
    }

    public void writeUntil(int n2, CodedOutputStream codedOutputStream) {
        while (this.next != null) {
            if (((Descriptors$FieldDescriptor)this.next.getKey()).getNumber() >= n2) return;
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)this.next.getKey();
            if (this.messageSetWireFormat && descriptors$FieldDescriptor.getLiteJavaType() == WireFormat$JavaType.MESSAGE && !descriptors$FieldDescriptor.isRepeated()) {
                if (this.next instanceof LazyField$LazyEntry) {
                    codedOutputStream.writeRawMessageSetExtension(descriptors$FieldDescriptor.getNumber(), ((LazyField$LazyEntry)this.next).getField().toByteString());
                } else {
                    codedOutputStream.writeMessageSetExtension(descriptors$FieldDescriptor.getNumber(), (Message)this.next.getValue());
                }
            } else {
                FieldSet.writeField(descriptors$FieldDescriptor, this.next.getValue(), codedOutputStream);
            }
            if (this.iter.hasNext()) {
                this.next = (Map.Entry)this.iter.next();
                continue;
            }
            this.next = null;
        }
    }

    /* synthetic */ GeneratedMessage$ExtendableMessage$ExtensionWriter(GeneratedMessage$ExtendableMessage generatedMessage$ExtendableMessage, boolean bl2, GeneratedMessage$1 generatedMessage$1) {
        this(generatedMessage$ExtendableMessage, bl2);
    }
}

