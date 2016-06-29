package com.google.protobuf;

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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExtensionRegistry extends ExtensionRegistryLite {
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

   public ExtensionRegistry getUnmodifiable() {
      return new ExtensionRegistry(this);
   }

   public ExtensionRegistry$ExtensionInfo findExtensionByName(String var1) {
      return this.findImmutableExtensionByName(var1);
   }

   public ExtensionRegistry$ExtensionInfo findImmutableExtensionByName(String var1) {
      return (ExtensionRegistry$ExtensionInfo)this.immutableExtensionsByName.get(var1);
   }

   public ExtensionRegistry$ExtensionInfo findMutableExtensionByName(String var1) {
      return (ExtensionRegistry$ExtensionInfo)this.mutableExtensionsByName.get(var1);
   }

   public ExtensionRegistry$ExtensionInfo findExtensionByNumber(Descriptors$Descriptor var1, int var2) {
      return this.findImmutableExtensionByNumber(var1, var2);
   }

   public ExtensionRegistry$ExtensionInfo findImmutableExtensionByNumber(Descriptors$Descriptor var1, int var2) {
      return (ExtensionRegistry$ExtensionInfo)this.immutableExtensionsByNumber.get(new ExtensionRegistry$DescriptorIntPair(var1, var2));
   }

   public ExtensionRegistry$ExtensionInfo findMutableExtensionByNumber(Descriptors$Descriptor var1, int var2) {
      return (ExtensionRegistry$ExtensionInfo)this.mutableExtensionsByNumber.get(new ExtensionRegistry$DescriptorIntPair(var1, var2));
   }

   public Set getAllMutableExtensionsByExtendedType(String var1) {
      HashSet var2 = new HashSet();
      Iterator var3 = this.mutableExtensionsByNumber.keySet().iterator();

      while(var3.hasNext()) {
         ExtensionRegistry$DescriptorIntPair var4 = (ExtensionRegistry$DescriptorIntPair)var3.next();
         if(ExtensionRegistry$DescriptorIntPair.access$000(var4).getFullName().equals(var1)) {
            var2.add(this.mutableExtensionsByNumber.get(var4));
         }
      }

      return var2;
   }

   public Set getAllImmutableExtensionsByExtendedType(String var1) {
      HashSet var2 = new HashSet();
      Iterator var3 = this.immutableExtensionsByNumber.keySet().iterator();

      while(var3.hasNext()) {
         ExtensionRegistry$DescriptorIntPair var4 = (ExtensionRegistry$DescriptorIntPair)var3.next();
         if(ExtensionRegistry$DescriptorIntPair.access$000(var4).getFullName().equals(var1)) {
            var2.add(this.immutableExtensionsByNumber.get(var4));
         }
      }

      return var2;
   }

   public void add(Extension var1) {
      if(var1.getExtensionType() == Extension$ExtensionType.IMMUTABLE || var1.getExtensionType() == Extension$ExtensionType.MUTABLE) {
         this.add(newExtensionInfo(var1), var1.getExtensionType());
      }
   }

   static ExtensionRegistry$ExtensionInfo newExtensionInfo(Extension var0) {
      // $FF: Couldn't be decompiled
   }

   public void add(Descriptors$FieldDescriptor var1) {
      if(var1.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
         throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
      } else {
         ExtensionRegistry$ExtensionInfo var2 = new ExtensionRegistry$ExtensionInfo(var1, (Message)null, (ExtensionRegistry$1)null);
         this.add(var2, Extension$ExtensionType.IMMUTABLE);
         this.add(var2, Extension$ExtensionType.MUTABLE);
      }
   }

   public void add(Descriptors$FieldDescriptor var1, Message var2) {
      if(var1.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
         throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
      } else {
         this.add(new ExtensionRegistry$ExtensionInfo(var1, var2, (ExtensionRegistry$1)null), Extension$ExtensionType.IMMUTABLE);
      }
   }

   private ExtensionRegistry() {
      this.immutableExtensionsByName = new HashMap();
      this.mutableExtensionsByName = new HashMap();
      this.immutableExtensionsByNumber = new HashMap();
      this.mutableExtensionsByNumber = new HashMap();
   }

   private ExtensionRegistry(ExtensionRegistry var1) {
      super(var1);
      this.immutableExtensionsByName = Collections.unmodifiableMap(var1.immutableExtensionsByName);
      this.mutableExtensionsByName = Collections.unmodifiableMap(var1.mutableExtensionsByName);
      this.immutableExtensionsByNumber = Collections.unmodifiableMap(var1.immutableExtensionsByNumber);
      this.mutableExtensionsByNumber = Collections.unmodifiableMap(var1.mutableExtensionsByNumber);
   }

   ExtensionRegistry(boolean var1) {
      super(ExtensionRegistryLite.getEmptyRegistry());
      this.immutableExtensionsByName = Collections.emptyMap();
      this.mutableExtensionsByName = Collections.emptyMap();
      this.immutableExtensionsByNumber = Collections.emptyMap();
      this.mutableExtensionsByNumber = Collections.emptyMap();
   }

   private void add(ExtensionRegistry$ExtensionInfo var1, Extension$ExtensionType var2) {
      if(!var1.descriptor.isExtension()) {
         throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
      } else {
         Map var3;
         Map var4;
         switch(ExtensionRegistry$1.$SwitchMap$com$google$protobuf$Extension$ExtensionType[var2.ordinal()]) {
         case 1:
            var3 = this.immutableExtensionsByName;
            var4 = this.immutableExtensionsByNumber;
            break;
         case 2:
            var3 = this.mutableExtensionsByName;
            var4 = this.mutableExtensionsByNumber;
            break;
         default:
            return;
         }

         var3.put(var1.descriptor.getFullName(), var1);
         var4.put(new ExtensionRegistry$DescriptorIntPair(var1.descriptor.getContainingType(), var1.descriptor.getNumber()), var1);
         Descriptors$FieldDescriptor var5 = var1.descriptor;
         if(var5.getContainingType().getOptions().getMessageSetWireFormat() && var5.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && var5.isOptional() && var5.getExtensionScope() == var5.getMessageType()) {
            var3.put(var5.getMessageType().getFullName(), var1);
         }

      }
   }
}
