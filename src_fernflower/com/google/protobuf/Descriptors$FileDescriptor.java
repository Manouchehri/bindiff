package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor$InternalDescriptorAssigner;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public final class Descriptors$FileDescriptor extends Descriptors$GenericDescriptor {
   private DescriptorProtos$FileDescriptorProto proto;
   private final Descriptors$Descriptor[] messageTypes;
   private final Descriptors$EnumDescriptor[] enumTypes;
   private final Descriptors$ServiceDescriptor[] services;
   private final Descriptors$FieldDescriptor[] extensions;
   private final Descriptors$FileDescriptor[] dependencies;
   private final Descriptors$FileDescriptor[] publicDependencies;
   private final Descriptors$DescriptorPool pool;

   public DescriptorProtos$FileDescriptorProto toProto() {
      return this.proto;
   }

   public String getName() {
      return this.proto.getName();
   }

   public Descriptors$FileDescriptor getFile() {
      return this;
   }

   public String getFullName() {
      return this.proto.getName();
   }

   public String getPackage() {
      return this.proto.getPackage();
   }

   public DescriptorProtos$FileOptions getOptions() {
      return this.proto.getOptions();
   }

   public List getMessageTypes() {
      return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
   }

   public List getEnumTypes() {
      return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
   }

   public List getServices() {
      return Collections.unmodifiableList(Arrays.asList(this.services));
   }

   public List getExtensions() {
      return Collections.unmodifiableList(Arrays.asList(this.extensions));
   }

   public List getDependencies() {
      return Collections.unmodifiableList(Arrays.asList(this.dependencies));
   }

   public List getPublicDependencies() {
      return Collections.unmodifiableList(Arrays.asList(this.publicDependencies));
   }

   public Descriptors$FileDescriptor$Syntax getSyntax() {
      return Descriptors$FileDescriptor$Syntax.access$000(Descriptors$FileDescriptor$Syntax.PROTO3).equals(this.proto.getSyntax())?Descriptors$FileDescriptor$Syntax.PROTO3:Descriptors$FileDescriptor$Syntax.PROTO2;
   }

   public Descriptors$Descriptor findMessageTypeByName(String var1) {
      if(var1.indexOf(46) != -1) {
         return null;
      } else {
         if(this.getPackage().length() > 0) {
            String var2 = String.valueOf(String.valueOf(this.getPackage()));
            String var3 = String.valueOf(String.valueOf(var1));
            var1 = (new StringBuilder(1 + var2.length() + var3.length())).append(var2).append(".").append(var3).toString();
         }

         Descriptors$GenericDescriptor var4 = this.pool.findSymbol(var1);
         return var4 != null && var4 instanceof Descriptors$Descriptor && var4.getFile() == this?(Descriptors$Descriptor)var4:null;
      }
   }

   public Descriptors$EnumDescriptor findEnumTypeByName(String var1) {
      if(var1.indexOf(46) != -1) {
         return null;
      } else {
         if(this.getPackage().length() > 0) {
            String var2 = String.valueOf(String.valueOf(this.getPackage()));
            String var3 = String.valueOf(String.valueOf(var1));
            var1 = (new StringBuilder(1 + var2.length() + var3.length())).append(var2).append(".").append(var3).toString();
         }

         Descriptors$GenericDescriptor var4 = this.pool.findSymbol(var1);
         return var4 != null && var4 instanceof Descriptors$EnumDescriptor && var4.getFile() == this?(Descriptors$EnumDescriptor)var4:null;
      }
   }

   public Descriptors$ServiceDescriptor findServiceByName(String var1) {
      if(var1.indexOf(46) != -1) {
         return null;
      } else {
         if(this.getPackage().length() > 0) {
            String var2 = String.valueOf(String.valueOf(this.getPackage()));
            String var3 = String.valueOf(String.valueOf(var1));
            var1 = (new StringBuilder(1 + var2.length() + var3.length())).append(var2).append(".").append(var3).toString();
         }

         Descriptors$GenericDescriptor var4 = this.pool.findSymbol(var1);
         return var4 != null && var4 instanceof Descriptors$ServiceDescriptor && var4.getFile() == this?(Descriptors$ServiceDescriptor)var4:null;
      }
   }

   public Descriptors$FieldDescriptor findExtensionByName(String var1) {
      if(var1.indexOf(46) != -1) {
         return null;
      } else {
         if(this.getPackage().length() > 0) {
            String var2 = String.valueOf(String.valueOf(this.getPackage()));
            String var3 = String.valueOf(String.valueOf(var1));
            var1 = (new StringBuilder(1 + var2.length() + var3.length())).append(var2).append(".").append(var3).toString();
         }

         Descriptors$GenericDescriptor var4 = this.pool.findSymbol(var1);
         return var4 != null && var4 instanceof Descriptors$FieldDescriptor && var4.getFile() == this?(Descriptors$FieldDescriptor)var4:null;
      }
   }

   public static Descriptors$FileDescriptor buildFrom(DescriptorProtos$FileDescriptorProto var0, Descriptors$FileDescriptor[] var1) {
      return buildFrom(var0, var1, false);
   }

   private static Descriptors$FileDescriptor buildFrom(DescriptorProtos$FileDescriptorProto var0, Descriptors$FileDescriptor[] var1, boolean var2) {
      Descriptors$DescriptorPool var3 = new Descriptors$DescriptorPool(var1, var2);
      Descriptors$FileDescriptor var4 = new Descriptors$FileDescriptor(var0, var1, var3, var2);
      var4.crossLink();
      return var4;
   }

   public static void internalBuildGeneratedFileFrom(String[] var0, Descriptors$FileDescriptor[] var1, Descriptors$FileDescriptor$InternalDescriptorAssigner var2) {
      StringBuilder var3 = new StringBuilder();
      String[] var4 = var0;
      int var5 = var0.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         String var7 = var4[var6];
         var3.append(var7);
      }

      byte[] var12 = var3.toString().getBytes(Internal.ISO_8859_1);

      DescriptorProtos$FileDescriptorProto var13;
      try {
         var13 = DescriptorProtos$FileDescriptorProto.parseFrom(var12);
      } catch (InvalidProtocolBufferException var11) {
         throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", var11);
      }

      Descriptors$FileDescriptor var14;
      try {
         var14 = buildFrom(var13, var1, true);
      } catch (Descriptors$DescriptorValidationException var10) {
         String var8 = String.valueOf(String.valueOf(var13.getName()));
         throw new IllegalArgumentException((new StringBuilder(35 + var8.length())).append("Invalid embedded descriptor for \"").append(var8).append("\".").toString(), var10);
      }

      ExtensionRegistry var15 = var2.assignDescriptors(var14);
      if(var15 != null) {
         try {
            var13 = DescriptorProtos$FileDescriptorProto.parseFrom((byte[])var12, var15);
         } catch (InvalidProtocolBufferException var9) {
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", var9);
         }

         var14.setProto(var13);
      }

   }

   public static void internalBuildGeneratedFileFrom(String[] var0, Class var1, String[] var2, String[] var3, Descriptors$FileDescriptor$InternalDescriptorAssigner var4) {
      ArrayList var5 = new ArrayList();

      for(int var6 = 0; var6 < var2.length; ++var6) {
         try {
            Class var7 = var1.getClassLoader().loadClass(var2[var6]);
            var5.add((Descriptors$FileDescriptor)var7.getField("descriptor").get((Object)null));
         } catch (Exception var9) {
            Logger var10000 = Descriptors.access$100();
            String var8 = String.valueOf(String.valueOf(var3[var6]));
            var10000.warning((new StringBuilder(36 + var8.length())).append("Descriptors for \"").append(var8).append("\" can not be found.").toString());
         }
      }

      Descriptors$FileDescriptor[] var10 = new Descriptors$FileDescriptor[var5.size()];
      var5.toArray(var10);
      internalBuildGeneratedFileFrom(var0, var10, var4);
   }

   public static void internalUpdateFileDescriptor(Descriptors$FileDescriptor var0, ExtensionRegistry var1) {
      ByteString var2 = var0.proto.toByteString();

      DescriptorProtos$FileDescriptorProto var3;
      try {
         var3 = DescriptorProtos$FileDescriptorProto.parseFrom((ByteString)var2, var1);
      } catch (InvalidProtocolBufferException var5) {
         throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", var5);
      }

      var0.setProto(var3);
   }

   private Descriptors$FileDescriptor(DescriptorProtos$FileDescriptorProto var1, Descriptors$FileDescriptor[] var2, Descriptors$DescriptorPool var3, boolean var4) {
      // $FF: Couldn't be decompiled
   }

   Descriptors$FileDescriptor(String var1, Descriptors$Descriptor var2) {
      this.pool = new Descriptors$DescriptorPool(new Descriptors$FileDescriptor[0], true);
      this.proto = DescriptorProtos$FileDescriptorProto.newBuilder().setName(String.valueOf(var2.getFullName()).concat(".placeholder.proto")).setPackage(var1).addMessageType(var2.toProto()).build();
      this.dependencies = new Descriptors$FileDescriptor[0];
      this.publicDependencies = new Descriptors$FileDescriptor[0];
      this.messageTypes = new Descriptors$Descriptor[]{var2};
      this.enumTypes = new Descriptors$EnumDescriptor[0];
      this.services = new Descriptors$ServiceDescriptor[0];
      this.extensions = new Descriptors$FieldDescriptor[0];
      this.pool.addPackage(var1, this);
      this.pool.addSymbol(var2);
   }

   private void crossLink() {
      Descriptors$Descriptor[] var1 = this.messageTypes;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         Descriptors$Descriptor var4 = var1[var3];
         Descriptors$Descriptor.access$700(var4);
      }

      Descriptors$ServiceDescriptor[] var5 = this.services;
      var2 = var5.length;

      for(var3 = 0; var3 < var2; ++var3) {
         Descriptors$ServiceDescriptor var7 = var5[var3];
         Descriptors$ServiceDescriptor.access$800(var7);
      }

      Descriptors$FieldDescriptor[] var6 = this.extensions;
      var2 = var6.length;

      for(var3 = 0; var3 < var2; ++var3) {
         Descriptors$FieldDescriptor var8 = var6[var3];
         Descriptors$FieldDescriptor.access$900(var8);
      }

   }

   private void setProto(DescriptorProtos$FileDescriptorProto var1) {
      this.proto = var1;

      int var2;
      for(var2 = 0; var2 < this.messageTypes.length; ++var2) {
         Descriptors$Descriptor.access$1000(this.messageTypes[var2], var1.getMessageType(var2));
      }

      for(var2 = 0; var2 < this.enumTypes.length; ++var2) {
         Descriptors$EnumDescriptor.access$1100(this.enumTypes[var2], var1.getEnumType(var2));
      }

      for(var2 = 0; var2 < this.services.length; ++var2) {
         Descriptors$ServiceDescriptor.access$1200(this.services[var2], var1.getService(var2));
      }

      for(var2 = 0; var2 < this.extensions.length; ++var2) {
         Descriptors$FieldDescriptor.access$1300(this.extensions[var2], var1.getExtension(var2));
      }

   }

   boolean supportsUnknownEnumValue() {
      return this.getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO3;
   }

   // $FF: synthetic method
   static Descriptors$DescriptorPool access$1400(Descriptors$FileDescriptor var0) {
      return var0.pool;
   }
}
