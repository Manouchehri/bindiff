/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$DescriptorPool$DescriptorIntPair;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.ProtocolStringList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Descriptors$Descriptor
extends Descriptors$GenericDescriptor {
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

    @Override
    public DescriptorProtos$DescriptorProto toProto() {
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

    public DescriptorProtos$MessageOptions getOptions() {
        return this.proto.getOptions();
    }

    public List getFields() {
        return Collections.unmodifiableList(Arrays.asList(this.fields));
    }

    public List getOneofs() {
        return Collections.unmodifiableList(Arrays.asList(this.oneofs));
    }

    public List getExtensions() {
        return Collections.unmodifiableList(Arrays.asList(this.extensions));
    }

    public List getNestedTypes() {
        return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
    }

    public List getEnumTypes() {
        return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
    }

    public boolean isExtensionNumber(int n2) {
        DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange;
        Iterator iterator = this.proto.getExtensionRangeList().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while ((descriptorProtos$DescriptorProto$ExtensionRange = (DescriptorProtos$DescriptorProto$ExtensionRange)iterator.next()).getStart() > n2 || n2 >= descriptorProtos$DescriptorProto$ExtensionRange.getEnd());
        return true;
    }

    public boolean isReservedNumber(int n2) {
        DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange;
        Iterator iterator = this.proto.getReservedRangeList().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while ((descriptorProtos$DescriptorProto$ReservedRange = (DescriptorProtos$DescriptorProto$ReservedRange)iterator.next()).getStart() > n2 || n2 >= descriptorProtos$DescriptorProto$ReservedRange.getEnd());
        return true;
    }

    public boolean isReservedName(String string) {
        String string2;
        if (string == null) {
            throw new NullPointerException();
        }
        Iterator iterator = this.proto.getReservedNameList().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!(string2 = (String)iterator.next()).equals(string));
        return true;
    }

    public boolean isExtendable() {
        if (this.proto.getExtensionRangeList().size() == 0) return false;
        return true;
    }

    public Descriptors$FieldDescriptor findFieldByName(String string) {
        String string2 = String.valueOf(String.valueOf(this.fullName));
        String string3 = String.valueOf(String.valueOf(string));
        Descriptors$GenericDescriptor descriptors$GenericDescriptor = Descriptors$FileDescriptor.access$1400(this.file).findSymbol(new StringBuilder(1 + string2.length() + string3.length()).append(string2).append(".").append(string3).toString());
        if (descriptors$GenericDescriptor == null) return null;
        if (!(descriptors$GenericDescriptor instanceof Descriptors$FieldDescriptor)) return null;
        return (Descriptors$FieldDescriptor)descriptors$GenericDescriptor;
    }

    public Descriptors$FieldDescriptor findFieldByNumber(int n2) {
        return (Descriptors$FieldDescriptor)Descriptors$DescriptorPool.access$1500(Descriptors$FileDescriptor.access$1400(this.file)).get(new Descriptors$DescriptorPool$DescriptorIntPair(this, n2));
    }

    public Descriptors$Descriptor findNestedTypeByName(String string) {
        String string2 = String.valueOf(String.valueOf(this.fullName));
        String string3 = String.valueOf(String.valueOf(string));
        Descriptors$GenericDescriptor descriptors$GenericDescriptor = Descriptors$FileDescriptor.access$1400(this.file).findSymbol(new StringBuilder(1 + string2.length() + string3.length()).append(string2).append(".").append(string3).toString());
        if (descriptors$GenericDescriptor == null) return null;
        if (!(descriptors$GenericDescriptor instanceof Descriptors$Descriptor)) return null;
        return (Descriptors$Descriptor)descriptors$GenericDescriptor;
    }

    public Descriptors$EnumDescriptor findEnumTypeByName(String string) {
        String string2 = String.valueOf(String.valueOf(this.fullName));
        String string3 = String.valueOf(String.valueOf(string));
        Descriptors$GenericDescriptor descriptors$GenericDescriptor = Descriptors$FileDescriptor.access$1400(this.file).findSymbol(new StringBuilder(1 + string2.length() + string3.length()).append(string2).append(".").append(string3).toString());
        if (descriptors$GenericDescriptor == null) return null;
        if (!(descriptors$GenericDescriptor instanceof Descriptors$EnumDescriptor)) return null;
        return (Descriptors$EnumDescriptor)descriptors$GenericDescriptor;
    }

    Descriptors$Descriptor(String string) {
        String string2 = string;
        String string3 = "";
        int n2 = string.lastIndexOf(46);
        if (n2 != -1) {
            string2 = string.substring(n2 + 1);
            string3 = string.substring(0, n2);
        }
        this.index = 0;
        this.proto = DescriptorProtos$DescriptorProto.newBuilder().setName(string2).addExtensionRange(DescriptorProtos$DescriptorProto$ExtensionRange.newBuilder().setStart(1).setEnd(536870912).build()).build();
        this.fullName = string;
        this.containingType = null;
        this.nestedTypes = new Descriptors$Descriptor[0];
        this.enumTypes = new Descriptors$EnumDescriptor[0];
        this.fields = new Descriptors$FieldDescriptor[0];
        this.extensions = new Descriptors$FieldDescriptor[0];
        this.oneofs = new Descriptors$OneofDescriptor[0];
        this.file = new Descriptors$FileDescriptor(string3, this);
    }

    private Descriptors$Descriptor(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n2) {
        int n3;
        this.index = n2;
        this.proto = descriptorProtos$DescriptorProto;
        this.fullName = Descriptors.access$1600(descriptors$FileDescriptor, descriptors$Descriptor, descriptorProtos$DescriptorProto.getName());
        this.file = descriptors$FileDescriptor;
        this.containingType = descriptors$Descriptor;
        this.oneofs = new Descriptors$OneofDescriptor[descriptorProtos$DescriptorProto.getOneofDeclCount()];
        for (n3 = 0; n3 < descriptorProtos$DescriptorProto.getOneofDeclCount(); ++n3) {
            this.oneofs[n3] = new Descriptors$OneofDescriptor(descriptorProtos$DescriptorProto.getOneofDecl(n3), descriptors$FileDescriptor, this, n3, null);
        }
        this.nestedTypes = new Descriptors$Descriptor[descriptorProtos$DescriptorProto.getNestedTypeCount()];
        for (n3 = 0; n3 < descriptorProtos$DescriptorProto.getNestedTypeCount(); ++n3) {
            this.nestedTypes[n3] = new Descriptors$Descriptor(descriptorProtos$DescriptorProto.getNestedType(n3), descriptors$FileDescriptor, this, n3);
        }
        this.enumTypes = new Descriptors$EnumDescriptor[descriptorProtos$DescriptorProto.getEnumTypeCount()];
        for (n3 = 0; n3 < descriptorProtos$DescriptorProto.getEnumTypeCount(); ++n3) {
            this.enumTypes[n3] = new Descriptors$EnumDescriptor(descriptorProtos$DescriptorProto.getEnumType(n3), descriptors$FileDescriptor, this, n3, null);
        }
        this.fields = new Descriptors$FieldDescriptor[descriptorProtos$DescriptorProto.getFieldCount()];
        for (n3 = 0; n3 < descriptorProtos$DescriptorProto.getFieldCount(); ++n3) {
            this.fields[n3] = new Descriptors$FieldDescriptor(descriptorProtos$DescriptorProto.getField(n3), descriptors$FileDescriptor, this, n3, false, null);
        }
        this.extensions = new Descriptors$FieldDescriptor[descriptorProtos$DescriptorProto.getExtensionCount()];
        for (n3 = 0; n3 < descriptorProtos$DescriptorProto.getExtensionCount(); ++n3) {
            this.extensions[n3] = new Descriptors$FieldDescriptor(descriptorProtos$DescriptorProto.getExtension(n3), descriptors$FileDescriptor, this, n3, true, null);
        }
        for (n3 = 0; n3 < descriptorProtos$DescriptorProto.getOneofDeclCount(); ++n3) {
            Descriptors$OneofDescriptor.access$1802(this.oneofs[n3], new Descriptors$FieldDescriptor[this.oneofs[n3].getFieldCount()]);
            Descriptors$OneofDescriptor.access$1902(this.oneofs[n3], 0);
        }
        n3 = 0;
        do {
            if (n3 >= descriptorProtos$DescriptorProto.getFieldCount()) {
                Descriptors$FileDescriptor.access$1400(descriptors$FileDescriptor).addSymbol(this);
                return;
            }
            Descriptors$OneofDescriptor descriptors$OneofDescriptor = this.fields[n3].getContainingOneof();
            if (descriptors$OneofDescriptor != null) {
                Descriptors$OneofDescriptor.access$1800((Descriptors$OneofDescriptor)descriptors$OneofDescriptor)[Descriptors$OneofDescriptor.access$1908((Descriptors$OneofDescriptor)descriptors$OneofDescriptor)] = this.fields[n3];
            }
            ++n3;
        } while (true);
    }

    private void crossLink() {
        for (Descriptors$Descriptor descriptors$Descriptor22 : this.nestedTypes) {
            descriptors$Descriptor22.crossLink();
        }
        for (Descriptors$Descriptor descriptors$Descriptor : this.fields) {
            Descriptors$FieldDescriptor.access$900((Descriptors$FieldDescriptor)((Object)descriptors$Descriptor));
        }
        Descriptors$Descriptor[] arrdescriptors$Descriptor = this.extensions;
        int n2 = arrdescriptors$Descriptor.length;
        int n3 = 0;
        while (n3 < n2) {
            Descriptors$Descriptor descriptors$Descriptor2 = arrdescriptors$Descriptor[n3];
            Descriptors$FieldDescriptor.access$900((Descriptors$FieldDescriptor)((Object)descriptors$Descriptor2));
            ++n3;
        }
    }

    private void setProto(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        int n2;
        this.proto = descriptorProtos$DescriptorProto;
        for (n2 = 0; n2 < this.nestedTypes.length; ++n2) {
            this.nestedTypes[n2].setProto(descriptorProtos$DescriptorProto.getNestedType(n2));
        }
        for (n2 = 0; n2 < this.enumTypes.length; ++n2) {
            Descriptors$EnumDescriptor.access$1100(this.enumTypes[n2], descriptorProtos$DescriptorProto.getEnumType(n2));
        }
        for (n2 = 0; n2 < this.fields.length; ++n2) {
            Descriptors$FieldDescriptor.access$1300(this.fields[n2], descriptorProtos$DescriptorProto.getField(n2));
        }
        n2 = 0;
        while (n2 < this.extensions.length) {
            Descriptors$FieldDescriptor.access$1300(this.extensions[n2], descriptorProtos$DescriptorProto.getExtension(n2));
            ++n2;
        }
    }

    /* synthetic */ Descriptors$Descriptor(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n2, Descriptors$1 descriptors$1) {
        this(descriptorProtos$DescriptorProto, descriptors$FileDescriptor, descriptors$Descriptor, n2);
    }

    static /* synthetic */ void access$700(Descriptors$Descriptor descriptors$Descriptor) {
        descriptors$Descriptor.crossLink();
    }

    static /* synthetic */ void access$1000(Descriptors$Descriptor descriptors$Descriptor, DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        descriptors$Descriptor.setProto(descriptorProtos$DescriptorProto);
    }
}

