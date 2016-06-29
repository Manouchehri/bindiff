/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite$1;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat$JavaType;
import java.util.Iterator;
import java.util.Map;

public class GeneratedMessageLite$ExtendableMessage$ExtensionWriter {
    private final Iterator iter;
    private Map.Entry next;
    private final boolean messageSetWireFormat;
    final /* synthetic */ GeneratedMessageLite$ExtendableMessage this$0;

    private GeneratedMessageLite$ExtendableMessage$ExtensionWriter(GeneratedMessageLite$ExtendableMessage generatedMessageLite$ExtendableMessage, boolean bl2) {
        this.this$0 = generatedMessageLite$ExtendableMessage;
        this.iter = this.this$0.extensions.iterator();
        if (this.iter.hasNext()) {
            this.next = (Map.Entry)this.iter.next();
        }
        this.messageSetWireFormat = bl2;
    }

    public void writeUntil(int n2, CodedOutputStream codedOutputStream) {
        while (this.next != null) {
            if (((GeneratedMessageLite$ExtensionDescriptor)this.next.getKey()).getNumber() >= n2) return;
            GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor = (GeneratedMessageLite$ExtensionDescriptor)this.next.getKey();
            if (this.messageSetWireFormat && generatedMessageLite$ExtensionDescriptor.getLiteJavaType() == WireFormat$JavaType.MESSAGE && !generatedMessageLite$ExtensionDescriptor.isRepeated()) {
                codedOutputStream.writeMessageSetExtension(generatedMessageLite$ExtensionDescriptor.getNumber(), (MessageLite)this.next.getValue());
            } else {
                FieldSet.writeField(generatedMessageLite$ExtensionDescriptor, this.next.getValue(), codedOutputStream);
            }
            if (this.iter.hasNext()) {
                this.next = (Map.Entry)this.iter.next();
                continue;
            }
            this.next = null;
        }
    }

    /* synthetic */ GeneratedMessageLite$ExtendableMessage$ExtensionWriter(GeneratedMessageLite$ExtendableMessage generatedMessageLite$ExtendableMessage, boolean bl2, GeneratedMessageLite$1 generatedMessageLite$1) {
        this(generatedMessageLite$ExtendableMessage, bl2);
    }
}

