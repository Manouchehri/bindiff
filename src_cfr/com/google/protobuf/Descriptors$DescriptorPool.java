/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool$DescriptorIntPair;
import com.google.protobuf.Descriptors$DescriptorPool$PackageDescriptor;
import com.google.protobuf.Descriptors$DescriptorPool$SearchFilter;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class Descriptors$DescriptorPool {
    private final Set dependencies = new HashSet();
    private boolean allowUnknownDependencies;
    private final Map descriptorsByName = new HashMap();
    private final Map fieldsByNumber = new HashMap();
    private final Map enumValuesByNumber = new HashMap();
    static final /* synthetic */ boolean $assertionsDisabled;

    Descriptors$DescriptorPool(Descriptors$FileDescriptor[] arrdescriptors$FileDescriptor, boolean bl2) {
        this.allowUnknownDependencies = bl2;
        for (int i2 = 0; i2 < arrdescriptors$FileDescriptor.length; ++i2) {
            this.dependencies.add(arrdescriptors$FileDescriptor[i2]);
            this.importPublicDependencies(arrdescriptors$FileDescriptor[i2]);
        }
        Iterator iterator = this.dependencies.iterator();
        while (iterator.hasNext()) {
            Descriptors$FileDescriptor descriptors$FileDescriptor = (Descriptors$FileDescriptor)iterator.next();
            try {
                this.addPackage(descriptors$FileDescriptor.getPackage(), descriptors$FileDescriptor);
                continue;
            }
            catch (Descriptors$DescriptorValidationException var5_6) {
                if (!$assertionsDisabled) throw new AssertionError();
                continue;
            }
        }
    }

    private void importPublicDependencies(Descriptors$FileDescriptor descriptors$FileDescriptor) {
        Iterator iterator = descriptors$FileDescriptor.getPublicDependencies().iterator();
        while (iterator.hasNext()) {
            Descriptors$FileDescriptor descriptors$FileDescriptor2 = (Descriptors$FileDescriptor)iterator.next();
            if (!this.dependencies.add(descriptors$FileDescriptor2)) continue;
            this.importPublicDependencies(descriptors$FileDescriptor2);
        }
    }

    Descriptors$GenericDescriptor findSymbol(String string) {
        return this.findSymbol(string, Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS);
    }

    /*
     * Unable to fully structure code
     */
    Descriptors$GenericDescriptor findSymbol(String var1_1, Descriptors$DescriptorPool$SearchFilter var2_2) {
        var3_3 = (Descriptors$GenericDescriptor)this.descriptorsByName.get(var1_1);
        if (var3_3 != null) {
            if (var2_2 == Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS) return var3_3;
            if (var2_2 == Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY) {
                if (this.isType(var3_3) != false) return var3_3;
            }
            if (var2_2 == Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY && this.isAggregate(var3_3)) {
                return var3_3;
            }
        }
        var4_4 = this.dependencies.iterator();
        do lbl-1000: // 3 sources:
        {
            if (var4_4.hasNext() == false) return null;
            var5_5 = (Descriptors$FileDescriptor)var4_4.next();
            var3_3 = (Descriptors$GenericDescriptor)Descriptors$FileDescriptor.access$1400((Descriptors$FileDescriptor)var5_5).descriptorsByName.get(var1_1);
            if (var3_3 == null) ** GOTO lbl-1000
            if (var2_2 == Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS) return var3_3;
            if (var2_2 != Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY) continue;
            if (this.isType(var3_3) != false) return var3_3;
        } while (var2_2 != Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY || !this.isAggregate(var3_3));
        return var3_3;
    }

    boolean isType(Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        if (descriptors$GenericDescriptor instanceof Descriptors$Descriptor) return true;
        if (descriptors$GenericDescriptor instanceof Descriptors$EnumDescriptor) return true;
        return false;
    }

    boolean isAggregate(Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        if (descriptors$GenericDescriptor instanceof Descriptors$Descriptor) return true;
        if (descriptors$GenericDescriptor instanceof Descriptors$EnumDescriptor) return true;
        if (descriptors$GenericDescriptor instanceof Descriptors$DescriptorPool$PackageDescriptor) return true;
        if (descriptors$GenericDescriptor instanceof Descriptors$ServiceDescriptor) return true;
        return false;
    }

    Descriptors$GenericDescriptor lookupSymbol(String string, Descriptors$GenericDescriptor descriptors$GenericDescriptor, Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter) {
        Descriptors$GenericDescriptor descriptors$GenericDescriptor2;
        String string2;
        if (string.startsWith(".")) {
            string2 = string.substring(1);
            descriptors$GenericDescriptor2 = this.findSymbol(string2, descriptors$DescriptorPool$SearchFilter);
        } else {
            int n2 = string.indexOf(46);
            String string3 = n2 == -1 ? string : string.substring(0, n2);
            StringBuilder stringBuilder = new StringBuilder(descriptors$GenericDescriptor.getFullName());
            do {
                int n3;
                if ((n3 = stringBuilder.lastIndexOf(".")) == -1) {
                    string2 = string;
                    descriptors$GenericDescriptor2 = this.findSymbol(string, descriptors$DescriptorPool$SearchFilter);
                    break;
                }
                stringBuilder.setLength(n3 + 1);
                stringBuilder.append(string3);
                descriptors$GenericDescriptor2 = this.findSymbol(stringBuilder.toString(), Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY);
                if (descriptors$GenericDescriptor2 != null) {
                    if (n2 != -1) {
                        stringBuilder.setLength(n3 + 1);
                        stringBuilder.append(string);
                        descriptors$GenericDescriptor2 = this.findSymbol(stringBuilder.toString(), descriptors$DescriptorPool$SearchFilter);
                    }
                    string2 = stringBuilder.toString();
                    break;
                }
                stringBuilder.setLength(n3);
            } while (true);
        }
        if (descriptors$GenericDescriptor2 != null) return descriptors$GenericDescriptor2;
        if (this.allowUnknownDependencies && descriptors$DescriptorPool$SearchFilter == Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY) {
            String string4 = String.valueOf(String.valueOf(string));
            Descriptors.access$100().warning(new StringBuilder(87 + string4.length()).append("The descriptor for message type \"").append(string4).append("\" can not be found and a placeholder is created for it").toString());
            descriptors$GenericDescriptor2 = new Descriptors$Descriptor(string2);
            this.dependencies.add(descriptors$GenericDescriptor2.getFile());
            return descriptors$GenericDescriptor2;
        }
        String string5 = String.valueOf(String.valueOf(string));
        throw new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, new StringBuilder(18 + string5.length()).append("\"").append(string5).append("\" is not defined.").toString(), null);
    }

    void addSymbol(Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        Descriptors$DescriptorPool.validateSymbolName(descriptors$GenericDescriptor);
        String string = descriptors$GenericDescriptor.getFullName();
        int n2 = string.lastIndexOf(46);
        Descriptors$GenericDescriptor descriptors$GenericDescriptor2 = this.descriptorsByName.put(string, descriptors$GenericDescriptor);
        if (descriptors$GenericDescriptor2 == null) return;
        this.descriptorsByName.put(string, descriptors$GenericDescriptor2);
        if (descriptors$GenericDescriptor.getFile() != descriptors$GenericDescriptor2.getFile()) {
            String string2 = String.valueOf(String.valueOf(string));
            String string3 = String.valueOf(String.valueOf(descriptors$GenericDescriptor2.getFile().getName()));
            throw new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, new StringBuilder(33 + string2.length() + string3.length()).append("\"").append(string2).append("\" is already defined in file \"").append(string3).append("\".").toString(), null);
        }
        if (n2 == -1) {
            String string4 = String.valueOf(String.valueOf(string));
            throw new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, new StringBuilder(22 + string4.length()).append("\"").append(string4).append("\" is already defined.").toString(), null);
        }
        String string5 = String.valueOf(String.valueOf(string.substring(n2 + 1)));
        String string6 = String.valueOf(String.valueOf(string.substring(0, n2)));
        throw new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, new StringBuilder(28 + string5.length() + string6.length()).append("\"").append(string5).append("\" is already defined in \"").append(string6).append("\".").toString(), null);
    }

    void addPackage(String string, Descriptors$FileDescriptor descriptors$FileDescriptor) {
        String string2;
        int n2 = string.lastIndexOf(46);
        if (n2 == -1) {
            string2 = string;
        } else {
            this.addPackage(string.substring(0, n2), descriptors$FileDescriptor);
            string2 = string.substring(n2 + 1);
        }
        Descriptors$GenericDescriptor descriptors$GenericDescriptor = this.descriptorsByName.put(string, new Descriptors$DescriptorPool$PackageDescriptor(string2, string, descriptors$FileDescriptor));
        if (descriptors$GenericDescriptor == null) return;
        this.descriptorsByName.put(string, descriptors$GenericDescriptor);
        if (descriptors$GenericDescriptor instanceof Descriptors$DescriptorPool$PackageDescriptor) return;
        String string3 = String.valueOf(String.valueOf(string2));
        String string4 = String.valueOf(String.valueOf(descriptors$GenericDescriptor.getFile().getName()));
        throw new Descriptors$DescriptorValidationException(descriptors$FileDescriptor, new StringBuilder(69 + string3.length() + string4.length()).append("\"").append(string3).append("\" is already defined (as something other than a ").append("package) in file \"").append(string4).append("\".").toString(), null);
    }

    void addFieldByNumber(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        Descriptors$DescriptorPool$DescriptorIntPair descriptors$DescriptorPool$DescriptorIntPair = new Descriptors$DescriptorPool$DescriptorIntPair(descriptors$FieldDescriptor.getContainingType(), descriptors$FieldDescriptor.getNumber());
        Descriptors$FieldDescriptor descriptors$FieldDescriptor2 = this.fieldsByNumber.put(descriptors$DescriptorPool$DescriptorIntPair, descriptors$FieldDescriptor);
        if (descriptors$FieldDescriptor2 == null) return;
        this.fieldsByNumber.put(descriptors$DescriptorPool$DescriptorIntPair, descriptors$FieldDescriptor2);
        int n2 = descriptors$FieldDescriptor.getNumber();
        String string = String.valueOf(String.valueOf(descriptors$FieldDescriptor.getContainingType().getFullName()));
        String string2 = String.valueOf(String.valueOf(descriptors$FieldDescriptor2.getName()));
        throw new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)descriptors$FieldDescriptor, new StringBuilder(65 + string.length() + string2.length()).append("Field number ").append(n2).append(" has already been used in \"").append(string).append("\" by field \"").append(string2).append("\".").toString(), null);
    }

    void addEnumValueByNumber(Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        Descriptors$DescriptorPool$DescriptorIntPair descriptors$DescriptorPool$DescriptorIntPair = new Descriptors$DescriptorPool$DescriptorIntPair(descriptors$EnumValueDescriptor.getType(), descriptors$EnumValueDescriptor.getNumber());
        Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor2 = this.enumValuesByNumber.put(descriptors$DescriptorPool$DescriptorIntPair, descriptors$EnumValueDescriptor);
        if (descriptors$EnumValueDescriptor2 == null) return;
        this.enumValuesByNumber.put(descriptors$DescriptorPool$DescriptorIntPair, descriptors$EnumValueDescriptor2);
    }

    static void validateSymbolName(Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        String string = descriptors$GenericDescriptor.getName();
        if (string.length() == 0) {
            throw new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, "Missing name.", null);
        }
        boolean bl2 = true;
        int n2 = 0;
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
            if (c2 >= '?') {
                bl2 = false;
            }
            if (!(Character.isLetter(c2) || c2 == '_' || Character.isDigit(c2) && n2 > 0)) {
                bl2 = false;
            }
            ++n2;
        }
    }

    static /* synthetic */ Map access$1500(Descriptors$DescriptorPool descriptors$DescriptorPool) {
        return descriptors$DescriptorPool.fieldsByNumber;
    }

    static /* synthetic */ Map access$2300(Descriptors$DescriptorPool descriptors$DescriptorPool) {
        return descriptors$DescriptorPool.enumValuesByNumber;
    }

    static {
        $assertionsDisabled = !Descriptors.class.desiredAssertionStatus();
    }
}

