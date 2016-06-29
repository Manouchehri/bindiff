package com.google.protobuf;

import java.util.logging.*;
import java.util.*;
import java.lang.ref.*;

public final class Descriptors$Descriptor extends Descriptors$GenericDescriptor
{
    private final int index;
    private DescriptorProtos$DescriptorProto proto;
    private final String fullName;
    private final Descriptors$FileDescriptor file;
    private final Descriptors$Descriptor containingType;
    private final Descriptors$Descriptor[] nestedTypes;
    private final Descriptors$EnumDescriptor[] enumTypes;
    private final Descriptors$FieldDescriptor[] fields;
    private final Descriptors$FieldDescriptor[] extensions;
    private final Descriptors$OneofDescriptor[] oneofs;
    
    public int getIndex() {
        return this.index;
    }
    
    public DescriptorProtos$DescriptorProto toProto() {
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
    
    public DescriptorProtos$MessageOptions getOptions() {
        return this.proto.getOptions();
    }
    
    public List getFields() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.fields));
    }
    
    public List getOneofs() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.oneofs));
    }
    
    public List getExtensions() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.extensions));
    }
    
    public List getNestedTypes() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.nestedTypes));
    }
    
    public List getEnumTypes() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.enumTypes));
    }
    
    public boolean isExtensionNumber(final int n) {
        for (final DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange : this.proto.getExtensionRangeList()) {
            if (descriptorProtos$DescriptorProto$ExtensionRange.getStart() <= n && n < descriptorProtos$DescriptorProto$ExtensionRange.getEnd()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isReservedNumber(final int n) {
        for (final DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange : this.proto.getReservedRangeList()) {
            if (descriptorProtos$DescriptorProto$ReservedRange.getStart() <= n && n < descriptorProtos$DescriptorProto$ReservedRange.getEnd()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isReservedName(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        final Iterator<String> iterator = this.proto.getReservedNameList().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isExtendable() {
        return this.proto.getExtensionRangeList().size() != 0;
    }
    
    public Descriptors$FieldDescriptor findFieldByName(final String s) {
        final Descriptors$DescriptorPool access$1400 = this.file.pool;
        final String value = String.valueOf(String.valueOf(this.fullName));
        final String value2 = String.valueOf(String.valueOf(s));
        final Descriptors$GenericDescriptor symbol = access$1400.findSymbol(new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString());
        if (symbol != null && symbol instanceof Descriptors$FieldDescriptor) {
            return (Descriptors$FieldDescriptor)symbol;
        }
        return null;
    }
    
    public Descriptors$FieldDescriptor findFieldByNumber(final int n) {
        return this.file.pool.fieldsByNumber.get(new Descriptors$DescriptorPool$DescriptorIntPair(this, n));
    }
    
    public Descriptors$Descriptor findNestedTypeByName(final String s) {
        final Descriptors$DescriptorPool access$1400 = this.file.pool;
        final String value = String.valueOf(String.valueOf(this.fullName));
        final String value2 = String.valueOf(String.valueOf(s));
        final Descriptors$GenericDescriptor symbol = access$1400.findSymbol(new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString());
        if (symbol != null && symbol instanceof Descriptors$Descriptor) {
            return (Descriptors$Descriptor)symbol;
        }
        return null;
    }
    
    public Descriptors$EnumDescriptor findEnumTypeByName(final String s) {
        final Descriptors$DescriptorPool access$1400 = this.file.pool;
        final String value = String.valueOf(String.valueOf(this.fullName));
        final String value2 = String.valueOf(String.valueOf(s));
        final Descriptors$GenericDescriptor symbol = access$1400.findSymbol(new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString());
        if (symbol != null && symbol instanceof Descriptors$EnumDescriptor) {
            return (Descriptors$EnumDescriptor)symbol;
        }
        return null;
    }
    
    Descriptors$Descriptor(final String fullName) {
        String substring = fullName;
        String substring2 = "";
        final int lastIndex = fullName.lastIndexOf(46);
        if (lastIndex != -1) {
            substring = fullName.substring(lastIndex + 1);
            substring2 = fullName.substring(0, lastIndex);
        }
        this.index = 0;
        this.proto = DescriptorProtos$DescriptorProto.newBuilder().setName(substring).addExtensionRange(DescriptorProtos$DescriptorProto$ExtensionRange.newBuilder().setStart(1).setEnd(536870912).build()).build();
        this.fullName = fullName;
        this.containingType = null;
        this.nestedTypes = new Descriptors$Descriptor[0];
        this.enumTypes = new Descriptors$EnumDescriptor[0];
        this.fields = new Descriptors$FieldDescriptor[0];
        this.extensions = new Descriptors$FieldDescriptor[0];
        this.oneofs = new Descriptors$OneofDescriptor[0];
        this.file = new Descriptors$FileDescriptor(substring2, this);
    }
    
    private Descriptors$Descriptor(final DescriptorProtos$DescriptorProto proto, final Descriptors$FileDescriptor file, final Descriptors$Descriptor containingType, final int index) {
        this.index = index;
        this.proto = proto;
        this.fullName = computeFullName(file, containingType, proto.getName());
        this.file = file;
        this.containingType = containingType;
        this.oneofs = new Descriptors$OneofDescriptor[proto.getOneofDeclCount()];
        for (int i = 0; i < proto.getOneofDeclCount(); ++i) {
            this.oneofs[i] = new Descriptors$OneofDescriptor(proto.getOneofDecl(i), file, this, i, null);
        }
        this.nestedTypes = new Descriptors$Descriptor[proto.getNestedTypeCount()];
        for (int j = 0; j < proto.getNestedTypeCount(); ++j) {
            this.nestedTypes[j] = new Descriptors$Descriptor(proto.getNestedType(j), file, this, j);
        }
        this.enumTypes = new Descriptors$EnumDescriptor[proto.getEnumTypeCount()];
        for (int k = 0; k < proto.getEnumTypeCount(); ++k) {
            this.enumTypes[k] = new Descriptors$EnumDescriptor(proto.getEnumType(k), file, this, k, null);
        }
        this.fields = new Descriptors$FieldDescriptor[proto.getFieldCount()];
        for (int l = 0; l < proto.getFieldCount(); ++l) {
            this.fields[l] = new Descriptors$FieldDescriptor(proto.getField(l), file, this, l, false, null);
        }
        this.extensions = new Descriptors$FieldDescriptor[proto.getExtensionCount()];
        for (int n = 0; n < proto.getExtensionCount(); ++n) {
            this.extensions[n] = new Descriptors$FieldDescriptor(proto.getExtension(n), file, this, n, true, null);
        }
        for (int n2 = 0; n2 < proto.getOneofDeclCount(); ++n2) {
            this.oneofs[n2].fields = new Descriptors$FieldDescriptor[this.oneofs[n2].getFieldCount()];
            this.oneofs[n2].fieldCount = 0;
        }
        for (int n3 = 0; n3 < proto.getFieldCount(); ++n3) {
            final Descriptors$OneofDescriptor containingOneof = this.fields[n3].getContainingOneof();
            if (containingOneof != null) {
                containingOneof.fields[containingOneof.fieldCount++] = this.fields[n3];
            }
        }
        file.pool.addSymbol(this);
    }
    
    private void crossLink() {
        final Descriptors$Descriptor[] nestedTypes = this.nestedTypes;
        for (int length = nestedTypes.length, i = 0; i < length; ++i) {
            nestedTypes[i].crossLink();
        }
        final Descriptors$FieldDescriptor[] fields = this.fields;
        for (int length2 = fields.length, j = 0; j < length2; ++j) {
            fields[j].crossLink();
        }
        final Descriptors$FieldDescriptor[] extensions = this.extensions;
        for (int length3 = extensions.length, k = 0; k < length3; ++k) {
            extensions[k].crossLink();
        }
    }
    
    private void setProto(final DescriptorProtos$DescriptorProto proto) {
        this.proto = proto;
        for (int i = 0; i < this.nestedTypes.length; ++i) {
            this.nestedTypes[i].setProto(proto.getNestedType(i));
        }
        for (int j = 0; j < this.enumTypes.length; ++j) {
            this.enumTypes[j].setProto(proto.getEnumType(j));
        }
        for (int k = 0; k < this.fields.length; ++k) {
            this.fields[k].setProto(proto.getField(k));
        }
        for (int l = 0; l < this.extensions.length; ++l) {
            this.extensions[l].setProto(proto.getExtension(l));
        }
    }
}
