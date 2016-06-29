package com.google.protobuf;

import java.lang.ref.*;
import java.util.logging.*;
import java.util.*;

public final class Descriptors$EnumDescriptor extends Descriptors$GenericDescriptor implements Internal$EnumLiteMap
{
    private final int index;
    private DescriptorProtos$EnumDescriptorProto proto;
    private final String fullName;
    private final Descriptors$FileDescriptor file;
    private final Descriptors$Descriptor containingType;
    private Descriptors$EnumValueDescriptor[] values;
    private final WeakHashMap unknownValues;
    
    public int getIndex() {
        return this.index;
    }
    
    public DescriptorProtos$EnumDescriptorProto toProto() {
        return this.proto;
    }
    
    public String getName() {
        return this.proto.getName();
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
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
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.values));
    }
    
    public Descriptors$EnumValueDescriptor findValueByName(final String s) {
        final Descriptors$DescriptorPool access$1400 = this.file.pool;
        final String value = String.valueOf(String.valueOf(this.fullName));
        final String value2 = String.valueOf(String.valueOf(s));
        final Descriptors$GenericDescriptor symbol = access$1400.findSymbol(new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString());
        if (symbol != null && symbol instanceof Descriptors$EnumValueDescriptor) {
            return (Descriptors$EnumValueDescriptor)symbol;
        }
        return null;
    }
    
    public Descriptors$EnumValueDescriptor findValueByNumber(final int n) {
        return this.file.pool.enumValuesByNumber.get(new Descriptors$DescriptorPool$DescriptorIntPair(this, n));
    }
    
    public Descriptors$EnumValueDescriptor findValueByNumberCreatingIfUnknown(final int n) {
        Descriptors$EnumValueDescriptor valueByNumber = this.findValueByNumber(n);
        if (valueByNumber != null) {
            return valueByNumber;
        }
        synchronized (this) {
            final Integer n2 = new Integer(n);
            final WeakReference<Descriptors$EnumValueDescriptor> weakReference = this.unknownValues.get(n2);
            if (weakReference != null) {
                valueByNumber = weakReference.get();
            }
            if (valueByNumber == null) {
                valueByNumber = new Descriptors$EnumValueDescriptor(this.file, this, n2, null);
                this.unknownValues.put(n2, new WeakReference<Descriptors$EnumValueDescriptor>(valueByNumber));
            }
        }
        return valueByNumber;
    }
    
    int getUnknownEnumValueDescriptorCount() {
        return this.unknownValues.size();
    }
    
    private Descriptors$EnumDescriptor(final DescriptorProtos$EnumDescriptorProto proto, final Descriptors$FileDescriptor file, final Descriptors$Descriptor containingType, final int index) {
        this.unknownValues = new WeakHashMap();
        this.index = index;
        this.proto = proto;
        this.fullName = computeFullName(file, containingType, proto.getName());
        this.file = file;
        this.containingType = containingType;
        if (proto.getValueCount() == 0) {
            throw new Descriptors$DescriptorValidationException(this, "Enums must contain at least one value.", (Descriptors$1)null);
        }
        this.values = new Descriptors$EnumValueDescriptor[proto.getValueCount()];
        for (int i = 0; i < proto.getValueCount(); ++i) {
            this.values[i] = new Descriptors$EnumValueDescriptor(proto.getValue(i), file, this, i, null);
        }
        file.pool.addSymbol(this);
    }
    
    private void setProto(final DescriptorProtos$EnumDescriptorProto proto) {
        this.proto = proto;
        for (int i = 0; i < this.values.length; ++i) {
            this.values[i].setProto(proto.getValue(i));
        }
    }
}
