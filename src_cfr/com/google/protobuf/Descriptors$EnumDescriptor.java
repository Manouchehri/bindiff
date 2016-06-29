/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$DescriptorPool$DescriptorIntPair;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Message;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

public final class Descriptors$EnumDescriptor
extends Descriptors$GenericDescriptor
implements Internal$EnumLiteMap {
    private final int index;
    private DescriptorProtos$EnumDescriptorProto proto;
    private final String fullName;
    private final Descriptors$FileDescriptor file;
    private final Descriptors$Descriptor containingType;
    private Descriptors$EnumValueDescriptor[] values;
    private final WeakHashMap unknownValues = new WeakHashMap();

    public int getIndex() {
        return this.index;
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto toProto() {
        return this.proto;
    }

    @Override
    public String getName() {
        return this.proto.getName();
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public Descriptors$FileDescriptor getFile() {
        return this.file;
    }

    public Descriptors$Descriptor getContainingType() {
        return this.containingType;
    }

    public DescriptorProtos$EnumOptions getOptions() {
        return this.proto.getOptions();
    }

    public List getValues() {
        return Collections.unmodifiableList(Arrays.asList(this.values));
    }

    public Descriptors$EnumValueDescriptor findValueByName(String string) {
        String string2 = String.valueOf(String.valueOf(this.fullName));
        String string3 = String.valueOf(String.valueOf(string));
        Descriptors$GenericDescriptor descriptors$GenericDescriptor = Descriptors$FileDescriptor.access$1400(this.file).findSymbol(new StringBuilder(1 + string2.length() + string3.length()).append(string2).append(".").append(string3).toString());
        if (descriptors$GenericDescriptor == null) return null;
        if (!(descriptors$GenericDescriptor instanceof Descriptors$EnumValueDescriptor)) return null;
        return (Descriptors$EnumValueDescriptor)descriptors$GenericDescriptor;
    }

    @Override
    public Descriptors$EnumValueDescriptor findValueByNumber(int n2) {
        return (Descriptors$EnumValueDescriptor)Descriptors$DescriptorPool.access$2300(Descriptors$FileDescriptor.access$1400(this.file)).get(new Descriptors$DescriptorPool$DescriptorIntPair(this, n2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Descriptors$EnumValueDescriptor findValueByNumberCreatingIfUnknown(int n2) {
        Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor = this.findValueByNumber(n2);
        if (descriptors$EnumValueDescriptor != null) {
            return descriptors$EnumValueDescriptor;
        }
        Descriptors$EnumDescriptor descriptors$EnumDescriptor = this;
        synchronized (descriptors$EnumDescriptor) {
            Integer n3 = new Integer(n2);
            WeakReference weakReference = (WeakReference)this.unknownValues.get(n3);
            if (weakReference != null) {
                descriptors$EnumValueDescriptor = (Descriptors$EnumValueDescriptor)weakReference.get();
            }
            if (descriptors$EnumValueDescriptor != null) return descriptors$EnumValueDescriptor;
            descriptors$EnumValueDescriptor = new Descriptors$EnumValueDescriptor(this.file, this, n3, null);
            this.unknownValues.put(n3, new WeakReference<Descriptors$EnumValueDescriptor>(descriptors$EnumValueDescriptor));
            return descriptors$EnumValueDescriptor;
        }
    }

    int getUnknownEnumValueDescriptorCount() {
        return this.unknownValues.size();
    }

    private Descriptors$EnumDescriptor(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n2) {
        this.index = n2;
        this.proto = descriptorProtos$EnumDescriptorProto;
        this.fullName = Descriptors.access$1600(descriptors$FileDescriptor, descriptors$Descriptor, descriptorProtos$EnumDescriptorProto.getName());
        this.file = descriptors$FileDescriptor;
        this.containingType = descriptors$Descriptor;
        if (descriptorProtos$EnumDescriptorProto.getValueCount() == 0) {
            throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, "Enums must contain at least one value.", null);
        }
        this.values = new Descriptors$EnumValueDescriptor[descriptorProtos$EnumDescriptorProto.getValueCount()];
        int n3 = 0;
        do {
            if (n3 >= descriptorProtos$EnumDescriptorProto.getValueCount()) {
                Descriptors$FileDescriptor.access$1400(descriptors$FileDescriptor).addSymbol(this);
                return;
            }
            this.values[n3] = new Descriptors$EnumValueDescriptor(descriptorProtos$EnumDescriptorProto.getValue(n3), descriptors$FileDescriptor, this, n3, null);
            ++n3;
        } while (true);
    }

    private void setProto(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        this.proto = descriptorProtos$EnumDescriptorProto;
        int n2 = 0;
        while (n2 < this.values.length) {
            Descriptors$EnumValueDescriptor.access$2600(this.values[n2], descriptorProtos$EnumDescriptorProto.getValue(n2));
            ++n2;
        }
    }

    /* synthetic */ Descriptors$EnumDescriptor(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n2, Descriptors$1 descriptors$1) {
        this(descriptorProtos$EnumDescriptorProto, descriptors$FileDescriptor, descriptors$Descriptor, n2);
    }

    static /* synthetic */ void access$1100(Descriptors$EnumDescriptor descriptors$EnumDescriptor, DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        descriptors$EnumDescriptor.setProto(descriptorProtos$EnumDescriptorProto);
    }
}

