package com.google.protobuf;

import java.util.*;
import java.io.*;

public abstract class AbstractMessage$Builder extends AbstractMessageLite$Builder implements Message$Builder
{
    public abstract AbstractMessage$Builder clone();
    
    public boolean hasOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }
    
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }
    
    public AbstractMessage$Builder clearOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        throw new UnsupportedOperationException("clearOneof() is not implemented.");
    }
    
    public AbstractMessage$Builder clear() {
        final Iterator<Map.Entry<Descriptors$FieldDescriptor, V>> iterator = this.getAllFields().entrySet().iterator();
        while (iterator.hasNext()) {
            this.clearField(iterator.next().getKey());
        }
        return this;
    }
    
    public List findInitializationErrors() {
        return MessageReflection.findMissingFields(this);
    }
    
    public String getInitializationErrorString() {
        return MessageReflection.delimitWithCommas(this.findInitializationErrors());
    }
    
    public AbstractMessage$Builder mergeFrom(final Message message) {
        if (message.getDescriptorForType() != this.getDescriptorForType()) {
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
        for (final Map.Entry<Descriptors$FieldDescriptor, V> entry : message.getAllFields().entrySet()) {
            final Descriptors$FieldDescriptor descriptors$FieldDescriptor = entry.getKey();
            if (descriptors$FieldDescriptor.isRepeated()) {
                final Iterator iterator2 = ((List)entry.getValue()).iterator();
                while (iterator2.hasNext()) {
                    this.addRepeatedField(descriptors$FieldDescriptor, iterator2.next());
                }
            }
            else if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                final Message message2 = (Message)this.getField(descriptors$FieldDescriptor);
                if (message2 == message2.getDefaultInstanceForType()) {
                    this.setField(descriptors$FieldDescriptor, entry.getValue());
                }
                else {
                    this.setField(descriptors$FieldDescriptor, message2.newBuilderForType().mergeFrom(message2).mergeFrom((Message)entry.getValue()).build());
                }
            }
            else {
                this.setField(descriptors$FieldDescriptor, entry.getValue());
            }
        }
        this.mergeUnknownFields(message.getUnknownFields());
        return this;
    }
    
    public AbstractMessage$Builder mergeFrom(final CodedInputStream codedInputStream) {
        return this.mergeFrom(codedInputStream, ExtensionRegistry.getEmptyRegistry());
    }
    
    public AbstractMessage$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        final UnknownFieldSet$Builder builder = UnknownFieldSet.newBuilder(this.getUnknownFields());
        int tag;
        do {
            tag = codedInputStream.readTag();
            if (tag == 0) {
                break;
            }
        } while (MessageReflection.mergeFieldFrom(codedInputStream, builder, extensionRegistryLite, this.getDescriptorForType(), new MessageReflection$BuilderAdapter(this), tag));
        this.setUnknownFields(builder.build());
        return this;
    }
    
    public AbstractMessage$Builder mergeUnknownFields(final UnknownFieldSet set) {
        this.setUnknownFields(UnknownFieldSet.newBuilder(this.getUnknownFields()).mergeFrom(set).build());
        return this;
    }
    
    public Message$Builder getFieldBuilder(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
    }
    
    public Message$Builder getRepeatedFieldBuilder(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n) {
        throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
    }
    
    public String toString() {
        return TextFormat.printToString(this);
    }
    
    protected static UninitializedMessageException newUninitializedMessageException(final Message message) {
        return new UninitializedMessageException(MessageReflection.findMissingFields(message));
    }
    
    public AbstractMessage$Builder mergeFrom(final ByteString byteString) {
        return (AbstractMessage$Builder)super.mergeFrom(byteString);
    }
    
    public AbstractMessage$Builder mergeFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(byteString, extensionRegistryLite);
    }
    
    public AbstractMessage$Builder mergeFrom(final byte[] array) {
        return (AbstractMessage$Builder)super.mergeFrom(array);
    }
    
    public AbstractMessage$Builder mergeFrom(final byte[] array, final int n, final int n2) {
        return (AbstractMessage$Builder)super.mergeFrom(array, n, n2);
    }
    
    public AbstractMessage$Builder mergeFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(array, extensionRegistryLite);
    }
    
    public AbstractMessage$Builder mergeFrom(final byte[] array, final int n, final int n2, final ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(array, n, n2, extensionRegistryLite);
    }
    
    public AbstractMessage$Builder mergeFrom(final InputStream inputStream) {
        return (AbstractMessage$Builder)super.mergeFrom(inputStream);
    }
    
    public AbstractMessage$Builder mergeFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(inputStream, extensionRegistryLite);
    }
    
    public boolean mergeDelimitedFrom(final InputStream inputStream) {
        return super.mergeDelimitedFrom(inputStream);
    }
    
    public boolean mergeDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return super.mergeDelimitedFrom(inputStream, extensionRegistryLite);
    }
}
