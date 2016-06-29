/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.MessageReflection$BuilderAdapter;
import com.google.protobuf.TextFormat;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMessage$Builder
extends AbstractMessageLite$Builder
implements Message$Builder {
    @Override
    public abstract AbstractMessage$Builder clone();

    @Override
    public boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }

    @Override
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }

    @Override
    public AbstractMessage$Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
        throw new UnsupportedOperationException("clearOneof() is not implemented.");
    }

    @Override
    public AbstractMessage$Builder clear() {
        Iterator<Map.Entry<K, V>> iterator = this.getAllFields().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            this.clearField((Descriptors$FieldDescriptor)entry.getKey());
        }
        return this;
    }

    @Override
    public List findInitializationErrors() {
        return MessageReflection.findMissingFields(this);
    }

    @Override
    public String getInitializationErrorString() {
        return MessageReflection.delimitWithCommas(this.findInitializationErrors());
    }

    @Override
    public AbstractMessage$Builder mergeFrom(Message message) {
        if (message.getDescriptorForType() != this.getDescriptorForType()) {
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
        Iterator<Map.Entry<K, V>> iterator = message.getAllFields().entrySet().iterator();
        block0 : do {
            Object object;
            if (!iterator.hasNext()) {
                this.mergeUnknownFields(message.getUnknownFields());
                return this;
            }
            Map.Entry<K, V> entry = iterator.next();
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)entry.getKey();
            if (descriptors$FieldDescriptor.isRepeated()) {
                object = ((List)entry.getValue()).iterator();
                do {
                    if (!object.hasNext()) continue block0;
                    E e2 = object.next();
                    this.addRepeatedField(descriptors$FieldDescriptor, e2);
                } while (true);
            }
            if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                object = (Message)this.getField(descriptors$FieldDescriptor);
                if (object == object.getDefaultInstanceForType()) {
                    this.setField(descriptors$FieldDescriptor, entry.getValue());
                    continue;
                }
                this.setField(descriptors$FieldDescriptor, object.newBuilderForType().mergeFrom((Message)object).mergeFrom((Message)entry.getValue()).build());
                continue;
            }
            this.setField(descriptors$FieldDescriptor, entry.getValue());
        } while (true);
    }

    @Override
    public AbstractMessage$Builder mergeFrom(CodedInputStream codedInputStream) {
        return this.mergeFrom(codedInputStream, (ExtensionRegistryLite)ExtensionRegistry.getEmptyRegistry());
    }

    @Override
    public AbstractMessage$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        int n2;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder(this.getUnknownFields());
        while ((n2 = codedInputStream.readTag()) != 0) {
            MessageReflection$BuilderAdapter messageReflection$BuilderAdapter = new MessageReflection$BuilderAdapter(this);
            if (MessageReflection.mergeFieldFrom(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, this.getDescriptorForType(), messageReflection$BuilderAdapter, n2)) continue;
        }
        this.setUnknownFields(unknownFieldSet$Builder.build());
        return this;
    }

    @Override
    public AbstractMessage$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        this.setUnknownFields(UnknownFieldSet.newBuilder(this.getUnknownFields()).mergeFrom(unknownFieldSet).build());
        return this;
    }

    @Override
    public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
    }

    @Override
    public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2) {
        throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
    }

    public String toString() {
        return TextFormat.printToString(this);
    }

    protected static UninitializedMessageException newUninitializedMessageException(Message message) {
        return new UninitializedMessageException(MessageReflection.findMissingFields(message));
    }

    @Override
    public AbstractMessage$Builder mergeFrom(ByteString byteString) {
        return (AbstractMessage$Builder)super.mergeFrom(byteString);
    }

    @Override
    public AbstractMessage$Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(byteString, extensionRegistryLite);
    }

    @Override
    public AbstractMessage$Builder mergeFrom(byte[] arrby) {
        return (AbstractMessage$Builder)super.mergeFrom(arrby);
    }

    @Override
    public AbstractMessage$Builder mergeFrom(byte[] arrby, int n2, int n3) {
        return (AbstractMessage$Builder)super.mergeFrom(arrby, n2, n3);
    }

    @Override
    public AbstractMessage$Builder mergeFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(arrby, extensionRegistryLite);
    }

    @Override
    public AbstractMessage$Builder mergeFrom(byte[] arrby, int n2, int n3, ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(arrby, n2, n3, extensionRegistryLite);
    }

    @Override
    public AbstractMessage$Builder mergeFrom(InputStream inputStream) {
        return (AbstractMessage$Builder)super.mergeFrom(inputStream);
    }

    @Override
    public AbstractMessage$Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(inputStream, extensionRegistryLite);
    }

    @Override
    public boolean mergeDelimitedFrom(InputStream inputStream) {
        return super.mergeDelimitedFrom(inputStream);
    }

    @Override
    public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return super.mergeDelimitedFrom(inputStream, extensionRegistryLite);
    }
}

