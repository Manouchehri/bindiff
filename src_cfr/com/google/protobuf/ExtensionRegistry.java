/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Extension;
import com.google.protobuf.Extension$ExtensionType;
import com.google.protobuf.ExtensionRegistry$1;
import com.google.protobuf.ExtensionRegistry$DescriptorIntPair;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExtensionRegistry
extends ExtensionRegistryLite {
    private final Map immutableExtensionsByName;
    private final Map mutableExtensionsByName;
    private final Map immutableExtensionsByNumber;
    private final Map mutableExtensionsByNumber;
    private static final ExtensionRegistry EMPTY = new ExtensionRegistry(true);

    public static ExtensionRegistry newInstance() {
        return new ExtensionRegistry();
    }

    public static ExtensionRegistry getEmptyRegistry() {
        return EMPTY;
    }

    @Override
    public ExtensionRegistry getUnmodifiable() {
        return new ExtensionRegistry(this);
    }

    public ExtensionRegistry$ExtensionInfo findExtensionByName(String string) {
        return this.findImmutableExtensionByName(string);
    }

    public ExtensionRegistry$ExtensionInfo findImmutableExtensionByName(String string) {
        return (ExtensionRegistry$ExtensionInfo)this.immutableExtensionsByName.get(string);
    }

    public ExtensionRegistry$ExtensionInfo findMutableExtensionByName(String string) {
        return (ExtensionRegistry$ExtensionInfo)this.mutableExtensionsByName.get(string);
    }

    public ExtensionRegistry$ExtensionInfo findExtensionByNumber(Descriptors$Descriptor descriptors$Descriptor, int n2) {
        return this.findImmutableExtensionByNumber(descriptors$Descriptor, n2);
    }

    public ExtensionRegistry$ExtensionInfo findImmutableExtensionByNumber(Descriptors$Descriptor descriptors$Descriptor, int n2) {
        return (ExtensionRegistry$ExtensionInfo)this.immutableExtensionsByNumber.get(new ExtensionRegistry$DescriptorIntPair(descriptors$Descriptor, n2));
    }

    public ExtensionRegistry$ExtensionInfo findMutableExtensionByNumber(Descriptors$Descriptor descriptors$Descriptor, int n2) {
        return (ExtensionRegistry$ExtensionInfo)this.mutableExtensionsByNumber.get(new ExtensionRegistry$DescriptorIntPair(descriptors$Descriptor, n2));
    }

    public Set getAllMutableExtensionsByExtendedType(String string) {
        HashSet hashSet = new HashSet();
        Iterator iterator = this.mutableExtensionsByNumber.keySet().iterator();
        while (iterator.hasNext()) {
            ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair = (ExtensionRegistry$DescriptorIntPair)iterator.next();
            if (!ExtensionRegistry$DescriptorIntPair.access$000(extensionRegistry$DescriptorIntPair).getFullName().equals(string)) continue;
            hashSet.add(this.mutableExtensionsByNumber.get(extensionRegistry$DescriptorIntPair));
        }
        return hashSet;
    }

    public Set getAllImmutableExtensionsByExtendedType(String string) {
        HashSet hashSet = new HashSet();
        Iterator iterator = this.immutableExtensionsByNumber.keySet().iterator();
        while (iterator.hasNext()) {
            ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair = (ExtensionRegistry$DescriptorIntPair)iterator.next();
            if (!ExtensionRegistry$DescriptorIntPair.access$000(extensionRegistry$DescriptorIntPair).getFullName().equals(string)) continue;
            hashSet.add(this.immutableExtensionsByNumber.get(extensionRegistry$DescriptorIntPair));
        }
        return hashSet;
    }

    public void add(Extension extension) {
        if (extension.getExtensionType() != Extension$ExtensionType.IMMUTABLE && extension.getExtensionType() != Extension$ExtensionType.MUTABLE) {
            return;
        }
        this.add(ExtensionRegistry.newExtensionInfo(extension), extension.getExtensionType());
    }

    static ExtensionRegistry$ExtensionInfo newExtensionInfo(Extension extension) {
        String string;
        if (extension.getDescriptor().getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) return new ExtensionRegistry$ExtensionInfo(extension.getDescriptor(), null, null);
        if (extension.getMessageDefaultInstance() != null) return new ExtensionRegistry$ExtensionInfo(extension.getDescriptor(), (Message)extension.getMessageDefaultInstance(), null);
        String string2 = String.valueOf(extension.getDescriptor().getFullName());
        if (string2.length() != 0) {
            string = "Registered message-type extension had null default instance: ".concat(string2);
            throw new IllegalStateException(string);
        }
        string = new String("Registered message-type extension had null default instance: ");
        throw new IllegalStateException(string);
    }

    public void add(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
        }
        ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo = new ExtensionRegistry$ExtensionInfo(descriptors$FieldDescriptor, null, null);
        this.add(extensionRegistry$ExtensionInfo, Extension$ExtensionType.IMMUTABLE);
        this.add(extensionRegistry$ExtensionInfo, Extension$ExtensionType.MUTABLE);
    }

    public void add(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message message) {
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

    private ExtensionRegistry(ExtensionRegistry extensionRegistry) {
        super(extensionRegistry);
        this.immutableExtensionsByName = Collections.unmodifiableMap(extensionRegistry.immutableExtensionsByName);
        this.mutableExtensionsByName = Collections.unmodifiableMap(extensionRegistry.mutableExtensionsByName);
        this.immutableExtensionsByNumber = Collections.unmodifiableMap(extensionRegistry.immutableExtensionsByNumber);
        this.mutableExtensionsByNumber = Collections.unmodifiableMap(extensionRegistry.mutableExtensionsByNumber);
    }

    ExtensionRegistry(boolean bl2) {
        super(ExtensionRegistryLite.getEmptyRegistry());
        this.immutableExtensionsByName = Collections.emptyMap();
        this.mutableExtensionsByName = Collections.emptyMap();
        this.immutableExtensionsByNumber = Collections.emptyMap();
        this.mutableExtensionsByNumber = Collections.emptyMap();
    }

    /*
     * Unable to fully structure code
     */
    private void add(ExtensionRegistry$ExtensionInfo var1_1, Extension$ExtensionType var2_2) {
        if (!var1_1.descriptor.isExtension()) {
            throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
        }
        switch (ExtensionRegistry$1.$SwitchMap$com$google$protobuf$Extension$ExtensionType[var2_2.ordinal()]) {
            case 1: {
                var3_3 = this.immutableExtensionsByName;
                var4_4 = this.immutableExtensionsByNumber;
                ** break;
            }
            case 2: {
                var3_3 = this.mutableExtensionsByName;
                var4_4 = this.mutableExtensionsByNumber;
                ** break;
            }
        }
        return;
lbl13: // 2 sources:
        var3_3.put(var1_1.descriptor.getFullName(), var1_1);
        var4_4.put(new ExtensionRegistry$DescriptorIntPair(var1_1.descriptor.getContainingType(), var1_1.descriptor.getNumber()), var1_1);
        var5_5 = var1_1.descriptor;
        if (var5_5.getContainingType().getOptions().getMessageSetWireFormat() == false) return;
        if (var5_5.getType() != Descriptors$FieldDescriptor$Type.MESSAGE) return;
        if (var5_5.isOptional() == false) return;
        if (var5_5.getExtensionScope() != var5_5.getMessageType()) return;
        var3_3.put(var5_5.getMessageType().getFullName(), var1_1);
    }
}

