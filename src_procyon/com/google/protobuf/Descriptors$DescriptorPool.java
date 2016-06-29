package com.google.protobuf;

import java.util.logging.*;
import java.util.*;
import java.io.*;

final class Descriptors$DescriptorPool
{
    private final Set dependencies;
    private boolean allowUnknownDependencies;
    private final Map descriptorsByName;
    private final Map fieldsByNumber;
    private final Map enumValuesByNumber;
    
    Descriptors$DescriptorPool(final Descriptors$FileDescriptor[] array, final boolean allowUnknownDependencies) {
        this.descriptorsByName = new HashMap();
        this.fieldsByNumber = new HashMap();
        this.enumValuesByNumber = new HashMap();
        this.dependencies = new HashSet();
        this.allowUnknownDependencies = allowUnknownDependencies;
        for (int i = 0; i < array.length; ++i) {
            this.dependencies.add(array[i]);
            this.importPublicDependencies(array[i]);
        }
        for (final Descriptors$FileDescriptor descriptors$FileDescriptor : this.dependencies) {
            try {
                this.addPackage(descriptors$FileDescriptor.getPackage(), descriptors$FileDescriptor);
            }
            catch (Descriptors$DescriptorValidationException ex) {
                assert false;
                continue;
            }
        }
    }
    
    private void importPublicDependencies(final Descriptors$FileDescriptor descriptors$FileDescriptor) {
        for (final Descriptors$FileDescriptor descriptors$FileDescriptor2 : descriptors$FileDescriptor.getPublicDependencies()) {
            if (this.dependencies.add(descriptors$FileDescriptor2)) {
                this.importPublicDependencies(descriptors$FileDescriptor2);
            }
        }
    }
    
    Descriptors$GenericDescriptor findSymbol(final String s) {
        return this.findSymbol(s, Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS);
    }
    
    Descriptors$GenericDescriptor findSymbol(final String s, final Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter) {
        final Descriptors$GenericDescriptor descriptors$GenericDescriptor = this.descriptorsByName.get(s);
        if (descriptors$GenericDescriptor != null && (descriptors$DescriptorPool$SearchFilter == Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS || (descriptors$DescriptorPool$SearchFilter == Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY && this.isType(descriptors$GenericDescriptor)) || (descriptors$DescriptorPool$SearchFilter == Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY && this.isAggregate(descriptors$GenericDescriptor)))) {
            return descriptors$GenericDescriptor;
        }
        final Iterator<Descriptors$FileDescriptor> iterator = this.dependencies.iterator();
        while (iterator.hasNext()) {
            final Descriptors$GenericDescriptor descriptors$GenericDescriptor2 = iterator.next().pool.descriptorsByName.get(s);
            if (descriptors$GenericDescriptor2 != null && (descriptors$DescriptorPool$SearchFilter == Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS || (descriptors$DescriptorPool$SearchFilter == Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY && this.isType(descriptors$GenericDescriptor2)) || (descriptors$DescriptorPool$SearchFilter == Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY && this.isAggregate(descriptors$GenericDescriptor2)))) {
                return descriptors$GenericDescriptor2;
            }
        }
        return null;
    }
    
    boolean isType(final Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        return descriptors$GenericDescriptor instanceof Descriptors$Descriptor || descriptors$GenericDescriptor instanceof Descriptors$EnumDescriptor;
    }
    
    boolean isAggregate(final Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        return descriptors$GenericDescriptor instanceof Descriptors$Descriptor || descriptors$GenericDescriptor instanceof Descriptors$EnumDescriptor || descriptors$GenericDescriptor instanceof Descriptors$DescriptorPool$PackageDescriptor || descriptors$GenericDescriptor instanceof Descriptors$ServiceDescriptor;
    }
    
    Descriptors$GenericDescriptor lookupSymbol(final String s, final Descriptors$GenericDescriptor descriptors$GenericDescriptor, final Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter) {
        String s2;
        Descriptors$GenericDescriptor descriptors$GenericDescriptor2;
        if (s.startsWith(".")) {
            s2 = s.substring(1);
            descriptors$GenericDescriptor2 = this.findSymbol(s2, descriptors$DescriptorPool$SearchFilter);
        }
        else {
            final int index = s.indexOf(46);
            String substring;
            if (index == -1) {
                substring = s;
            }
            else {
                substring = s.substring(0, index);
            }
            final StringBuilder sb = new StringBuilder(descriptors$GenericDescriptor.getFullName());
            while (true) {
                final int lastIndex = sb.lastIndexOf(".");
                if (lastIndex == -1) {
                    s2 = s;
                    descriptors$GenericDescriptor2 = this.findSymbol(s, descriptors$DescriptorPool$SearchFilter);
                    break;
                }
                sb.setLength(lastIndex + 1);
                sb.append(substring);
                descriptors$GenericDescriptor2 = this.findSymbol(sb.toString(), Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY);
                if (descriptors$GenericDescriptor2 != null) {
                    if (index != -1) {
                        sb.setLength(lastIndex + 1);
                        sb.append(s);
                        descriptors$GenericDescriptor2 = this.findSymbol(sb.toString(), descriptors$DescriptorPool$SearchFilter);
                    }
                    s2 = sb.toString();
                    break;
                }
                sb.setLength(lastIndex);
            }
        }
        if (descriptors$GenericDescriptor2 != null) {
            return descriptors$GenericDescriptor2;
        }
        if (this.allowUnknownDependencies && descriptors$DescriptorPool$SearchFilter == Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY) {
            final Logger access$100 = Descriptors.logger;
            final String value = String.valueOf(String.valueOf(s));
            access$100.warning(new StringBuilder(87 + value.length()).append("The descriptor for message type \"").append(value).append("\" can not be found and a placeholder is created for it").toString());
            final Descriptors$Descriptor descriptors$Descriptor = new Descriptors$Descriptor(s2);
            this.dependencies.add(descriptors$Descriptor.getFile());
            return descriptors$Descriptor;
        }
        final String value2 = String.valueOf(String.valueOf(s));
        throw new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, new StringBuilder(18 + value2.length()).append("\"").append(value2).append("\" is not defined.").toString(), (Descriptors$1)null);
    }
    
    void addSymbol(final Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        validateSymbolName(descriptors$GenericDescriptor);
        final String fullName = descriptors$GenericDescriptor.getFullName();
        final int lastIndex = fullName.lastIndexOf(46);
        final Descriptors$GenericDescriptor descriptors$GenericDescriptor2 = this.descriptorsByName.put(fullName, descriptors$GenericDescriptor);
        if (descriptors$GenericDescriptor2 == null) {
            return;
        }
        this.descriptorsByName.put(fullName, descriptors$GenericDescriptor2);
        if (descriptors$GenericDescriptor.getFile() != descriptors$GenericDescriptor2.getFile()) {
            final String value = String.valueOf(String.valueOf(fullName));
            final String value2 = String.valueOf(String.valueOf(descriptors$GenericDescriptor2.getFile().getName()));
            throw new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, new StringBuilder(33 + value.length() + value2.length()).append("\"").append(value).append("\" is already defined in file \"").append(value2).append("\".").toString(), (Descriptors$1)null);
        }
        if (lastIndex == -1) {
            final String value3 = String.valueOf(String.valueOf(fullName));
            throw new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, new StringBuilder(22 + value3.length()).append("\"").append(value3).append("\" is already defined.").toString(), (Descriptors$1)null);
        }
        final String value4 = String.valueOf(String.valueOf(fullName.substring(lastIndex + 1)));
        final String value5 = String.valueOf(String.valueOf(fullName.substring(0, lastIndex)));
        throw new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, new StringBuilder(28 + value4.length() + value5.length()).append("\"").append(value4).append("\" is already defined in \"").append(value5).append("\".").toString(), (Descriptors$1)null);
    }
    
    void addPackage(final String s, final Descriptors$FileDescriptor descriptors$FileDescriptor) {
        final int lastIndex = s.lastIndexOf(46);
        String substring;
        if (lastIndex == -1) {
            substring = s;
        }
        else {
            this.addPackage(s.substring(0, lastIndex), descriptors$FileDescriptor);
            substring = s.substring(lastIndex + 1);
        }
        final Descriptors$DescriptorPool$PackageDescriptor descriptors$DescriptorPool$PackageDescriptor = this.descriptorsByName.put(s, new Descriptors$DescriptorPool$PackageDescriptor(substring, s, descriptors$FileDescriptor));
        if (descriptors$DescriptorPool$PackageDescriptor != null) {
            this.descriptorsByName.put(s, descriptors$DescriptorPool$PackageDescriptor);
            if (!(descriptors$DescriptorPool$PackageDescriptor instanceof Descriptors$DescriptorPool$PackageDescriptor)) {
                final String value = String.valueOf(String.valueOf(substring));
                final String value2 = String.valueOf(String.valueOf(descriptors$DescriptorPool$PackageDescriptor.getFile().getName()));
                throw new Descriptors$DescriptorValidationException(descriptors$FileDescriptor, new StringBuilder(69 + value.length() + value2.length()).append("\"").append(value).append("\" is already defined (as something other than a ").append("package) in file \"").append(value2).append("\".").toString(), null);
            }
        }
    }
    
    void addFieldByNumber(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        final Descriptors$DescriptorPool$DescriptorIntPair descriptors$DescriptorPool$DescriptorIntPair = new Descriptors$DescriptorPool$DescriptorIntPair(descriptors$FieldDescriptor.getContainingType(), descriptors$FieldDescriptor.getNumber());
        final Descriptors$FieldDescriptor descriptors$FieldDescriptor2 = this.fieldsByNumber.put(descriptors$DescriptorPool$DescriptorIntPair, descriptors$FieldDescriptor);
        if (descriptors$FieldDescriptor2 != null) {
            this.fieldsByNumber.put(descriptors$DescriptorPool$DescriptorIntPair, descriptors$FieldDescriptor2);
            final int number = descriptors$FieldDescriptor.getNumber();
            final String value = String.valueOf(String.valueOf(descriptors$FieldDescriptor.getContainingType().getFullName()));
            final String value2 = String.valueOf(String.valueOf(descriptors$FieldDescriptor2.getName()));
            throw new Descriptors$DescriptorValidationException(descriptors$FieldDescriptor, new StringBuilder(65 + value.length() + value2.length()).append("Field number ").append(number).append(" has already been used in \"").append(value).append("\" by field \"").append(value2).append("\".").toString(), (Descriptors$1)null);
        }
    }
    
    void addEnumValueByNumber(final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        final Descriptors$DescriptorPool$DescriptorIntPair descriptors$DescriptorPool$DescriptorIntPair = new Descriptors$DescriptorPool$DescriptorIntPair(descriptors$EnumValueDescriptor.getType(), descriptors$EnumValueDescriptor.getNumber());
        final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor2 = this.enumValuesByNumber.put(descriptors$DescriptorPool$DescriptorIntPair, descriptors$EnumValueDescriptor);
        if (descriptors$EnumValueDescriptor2 != null) {
            this.enumValuesByNumber.put(descriptors$DescriptorPool$DescriptorIntPair, descriptors$EnumValueDescriptor2);
        }
    }
    
    static void validateSymbolName(final Descriptors$GenericDescriptor descriptors$GenericDescriptor) {
        final String name = descriptors$GenericDescriptor.getName();
        if (name.length() == 0) {
            throw new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, "Missing name.", (Descriptors$1)null);
        }
        boolean b = true;
        for (int i = 0; i < name.length(); ++i) {
            final char char1 = name.charAt(i);
            if (char1 >= '\u0080') {
                b = false;
            }
            if (!Character.isLetter(char1) && char1 != '_') {
                if (!Character.isDigit(char1) || i <= 0) {
                    b = false;
                }
            }
        }
        if (!b) {
            final String value = String.valueOf(String.valueOf(name));
            throw new Descriptors$DescriptorValidationException(descriptors$GenericDescriptor, new StringBuilder(29 + value.length()).append("\"").append(value).append("\" is not a valid identifier.").toString(), (Descriptors$1)null);
        }
    }
    
    static {
        $assertionsDisabled = !Descriptors.class.desiredAssertionStatus();
    }
}
