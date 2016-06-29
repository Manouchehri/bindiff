package com.google.protobuf;

import java.util.*;

public class ExtensionRegistry extends ExtensionRegistryLite
{
    private final Map immutableExtensionsByName;
    private final Map mutableExtensionsByName;
    private final Map immutableExtensionsByNumber;
    private final Map mutableExtensionsByNumber;
    private static final ExtensionRegistry EMPTY;
    
    public static ExtensionRegistry newInstance() {
        return new ExtensionRegistry();
    }
    
    public static ExtensionRegistry getEmptyRegistry() {
        return ExtensionRegistry.EMPTY;
    }
    
    public ExtensionRegistry getUnmodifiable() {
        return new ExtensionRegistry(this);
    }
    
    public ExtensionRegistry$ExtensionInfo findExtensionByName(final String s) {
        return this.findImmutableExtensionByName(s);
    }
    
    public ExtensionRegistry$ExtensionInfo findImmutableExtensionByName(final String s) {
        return this.immutableExtensionsByName.get(s);
    }
    
    public ExtensionRegistry$ExtensionInfo findMutableExtensionByName(final String s) {
        return this.mutableExtensionsByName.get(s);
    }
    
    public ExtensionRegistry$ExtensionInfo findExtensionByNumber(final Descriptors$Descriptor descriptors$Descriptor, final int n) {
        return this.findImmutableExtensionByNumber(descriptors$Descriptor, n);
    }
    
    public ExtensionRegistry$ExtensionInfo findImmutableExtensionByNumber(final Descriptors$Descriptor descriptors$Descriptor, final int n) {
        return this.immutableExtensionsByNumber.get(new ExtensionRegistry$DescriptorIntPair(descriptors$Descriptor, n));
    }
    
    public ExtensionRegistry$ExtensionInfo findMutableExtensionByNumber(final Descriptors$Descriptor descriptors$Descriptor, final int n) {
        return this.mutableExtensionsByNumber.get(new ExtensionRegistry$DescriptorIntPair(descriptors$Descriptor, n));
    }
    
    public Set getAllMutableExtensionsByExtendedType(final String s) {
        final HashSet<Object> set = new HashSet<Object>();
        for (final ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair : this.mutableExtensionsByNumber.keySet()) {
            if (extensionRegistry$DescriptorIntPair.descriptor.getFullName().equals(s)) {
                set.add(this.mutableExtensionsByNumber.get(extensionRegistry$DescriptorIntPair));
            }
        }
        return set;
    }
    
    public Set getAllImmutableExtensionsByExtendedType(final String s) {
        final HashSet<Object> set = new HashSet<Object>();
        for (final ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair : this.immutableExtensionsByNumber.keySet()) {
            if (extensionRegistry$DescriptorIntPair.descriptor.getFullName().equals(s)) {
                set.add(this.immutableExtensionsByNumber.get(extensionRegistry$DescriptorIntPair));
            }
        }
        return set;
    }
    
    public void add(final Extension extension) {
        if (extension.getExtensionType() != Extension$ExtensionType.IMMUTABLE && extension.getExtensionType() != Extension$ExtensionType.MUTABLE) {
            return;
        }
        this.add(newExtensionInfo(extension), extension.getExtensionType());
    }
    
    static ExtensionRegistry$ExtensionInfo newExtensionInfo(final Extension extension) {
        if (extension.getDescriptor().getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            return new ExtensionRegistry$ExtensionInfo(extension.getDescriptor(), null, null);
        }
        if (extension.getMessageDefaultInstance() == null) {
            final String s = "Registered message-type extension had null default instance: ";
            final String value = String.valueOf(extension.getDescriptor().getFullName());
            throw new IllegalStateException((value.length() != 0) ? s.concat(value) : new String(s));
        }
        return new ExtensionRegistry$ExtensionInfo(extension.getDescriptor(), (Message)extension.getMessageDefaultInstance(), null);
    }
    
    public void add(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
        }
        final ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo = new ExtensionRegistry$ExtensionInfo(descriptors$FieldDescriptor, null, null);
        this.add(extensionRegistry$ExtensionInfo, Extension$ExtensionType.IMMUTABLE);
        this.add(extensionRegistry$ExtensionInfo, Extension$ExtensionType.MUTABLE);
    }
    
    public void add(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Message message) {
        if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
        }
        this.add(new ExtensionRegistry$ExtensionInfo(descriptors$FieldDescriptor, message, null), Extension$ExtensionType.IMMUTABLE);
    }
    
    private ExtensionRegistry() {
        this.immutableExtensionsByName = new HashMap();
        this.mutableExtensionsByName = new HashMap();
        this.immutableExtensionsByNumber = new HashMap();
        this.mutableExtensionsByNumber = new HashMap();
    }
    
    private ExtensionRegistry(final ExtensionRegistry extensionRegistry) {
        super(extensionRegistry);
        this.immutableExtensionsByName = Collections.unmodifiableMap((Map<?, ?>)extensionRegistry.immutableExtensionsByName);
        this.mutableExtensionsByName = Collections.unmodifiableMap((Map<?, ?>)extensionRegistry.mutableExtensionsByName);
        this.immutableExtensionsByNumber = Collections.unmodifiableMap((Map<?, ?>)extensionRegistry.immutableExtensionsByNumber);
        this.mutableExtensionsByNumber = Collections.unmodifiableMap((Map<?, ?>)extensionRegistry.mutableExtensionsByNumber);
    }
    
    ExtensionRegistry(final boolean b) {
        super(ExtensionRegistryLite.getEmptyRegistry());
        this.immutableExtensionsByName = Collections.emptyMap();
        this.mutableExtensionsByName = Collections.emptyMap();
        this.immutableExtensionsByNumber = Collections.emptyMap();
        this.mutableExtensionsByNumber = Collections.emptyMap();
    }
    
    private void add(final ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo, final Extension$ExtensionType extension$ExtensionType) {
        if (!extensionRegistry$ExtensionInfo.descriptor.isExtension()) {
            throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
        }
        Map map = null;
        Map map2 = null;
        switch (ExtensionRegistry$1.$SwitchMap$com$google$protobuf$Extension$ExtensionType[extension$ExtensionType.ordinal()]) {
            case 1: {
                map = this.immutableExtensionsByName;
                map2 = this.immutableExtensionsByNumber;
                break;
            }
            case 2: {
                map = this.mutableExtensionsByName;
                map2 = this.mutableExtensionsByNumber;
                break;
            }
            default: {
                return;
            }
        }
        map.put(extensionRegistry$ExtensionInfo.descriptor.getFullName(), extensionRegistry$ExtensionInfo);
        map2.put(new ExtensionRegistry$DescriptorIntPair(extensionRegistry$ExtensionInfo.descriptor.getContainingType(), extensionRegistry$ExtensionInfo.descriptor.getNumber()), extensionRegistry$ExtensionInfo);
        final Descriptors$FieldDescriptor descriptor = extensionRegistry$ExtensionInfo.descriptor;
        if (descriptor.getContainingType().getOptions().getMessageSetWireFormat() && descriptor.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && descriptor.isOptional() && descriptor.getExtensionScope() == descriptor.getMessageType()) {
            map.put(descriptor.getMessageType().getFullName(), extensionRegistry$ExtensionInfo);
        }
    }
    
    static {
        EMPTY = new ExtensionRegistry(true);
    }
}
