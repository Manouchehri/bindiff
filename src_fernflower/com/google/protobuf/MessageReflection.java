package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.LazyField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.UnknownFieldSet$Field;
import com.google.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

class MessageReflection {
   static void writeMessageTo(Message var0, Map var1, CodedOutputStream var2, boolean var3) {
      boolean var4 = var0.getDescriptorForType().getOptions().getMessageSetWireFormat();
      Iterator var5;
      if(var3) {
         var1 = new TreeMap((Map)var1);
         var5 = var0.getDescriptorForType().getFields().iterator();

         while(var5.hasNext()) {
            Descriptors$FieldDescriptor var6 = (Descriptors$FieldDescriptor)var5.next();
            if(var6.isRequired() && !((Map)var1).containsKey(var6)) {
               ((Map)var1).put(var6, var0.getField(var6));
            }
         }
      }

      var5 = ((Map)var1).entrySet().iterator();

      while(true) {
         while(var5.hasNext()) {
            Entry var10 = (Entry)var5.next();
            Descriptors$FieldDescriptor var7 = (Descriptors$FieldDescriptor)var10.getKey();
            Object var8 = var10.getValue();
            if(var4 && var7.isExtension() && var7.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && !var7.isRepeated()) {
               var2.writeMessageSetExtension(var7.getNumber(), (Message)var8);
            } else {
               FieldSet.writeField(var7, var8, var2);
            }
         }

         UnknownFieldSet var9 = var0.getUnknownFields();
         if(var4) {
            var9.writeAsMessageSetTo(var2);
         } else {
            var9.writeTo(var2);
         }

         return;
      }
   }

   static int getSerializedSize(Message var0, Map var1) {
      int var2 = 0;
      boolean var3 = var0.getDescriptorForType().getOptions().getMessageSetWireFormat();
      Iterator var4 = var1.entrySet().iterator();

      while(true) {
         while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            Descriptors$FieldDescriptor var6 = (Descriptors$FieldDescriptor)var5.getKey();
            Object var7 = var5.getValue();
            if(var3 && var6.isExtension() && var6.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && !var6.isRepeated()) {
               var2 += CodedOutputStream.computeMessageSetExtensionSize(var6.getNumber(), (Message)var7);
            } else {
               var2 += FieldSet.computeFieldSize(var6, var7);
            }
         }

         UnknownFieldSet var8 = var0.getUnknownFields();
         if(var3) {
            var2 += var8.getSerializedSizeAsMessageSet();
         } else {
            var2 += var8.getSerializedSize();
         }

         return var2;
      }
   }

   static String delimitWithCommas(List var0) {
      StringBuilder var1 = new StringBuilder();

      String var3;
      for(Iterator var2 = var0.iterator(); var2.hasNext(); var1.append(var3)) {
         var3 = (String)var2.next();
         if(var1.length() > 0) {
            var1.append(", ");
         }
      }

      return var1.toString();
   }

   static boolean isInitialized(MessageOrBuilder var0) {
      Iterator var1 = var0.getDescriptorForType().getFields().iterator();

      while(var1.hasNext()) {
         Descriptors$FieldDescriptor var2 = (Descriptors$FieldDescriptor)var1.next();
         if(var2.isRequired() && !var0.hasField(var2)) {
            return false;
         }
      }

      var1 = var0.getAllFields().entrySet().iterator();

      while(true) {
         while(true) {
            Descriptors$FieldDescriptor var3;
            Entry var6;
            do {
               if(!var1.hasNext()) {
                  return true;
               }

               var6 = (Entry)var1.next();
               var3 = (Descriptors$FieldDescriptor)var6.getKey();
            } while(var3.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE);

            if(var3.isRepeated()) {
               Iterator var4 = ((List)var6.getValue()).iterator();

               while(var4.hasNext()) {
                  Message var5 = (Message)var4.next();
                  if(!var5.isInitialized()) {
                     return false;
                  }
               }
            } else if(!((Message)var6.getValue()).isInitialized()) {
               return false;
            }
         }
      }
   }

   private static String subMessagePrefix(String var0, Descriptors$FieldDescriptor var1, int var2) {
      StringBuilder var3 = new StringBuilder(var0);
      if(var1.isExtension()) {
         var3.append('(').append(var1.getFullName()).append(')');
      } else {
         var3.append(var1.getName());
      }

      if(var2 != -1) {
         var3.append('[').append(var2).append(']');
      }

      var3.append('.');
      return var3.toString();
   }

   private static void findMissingFields(MessageOrBuilder var0, String var1, List var2) {
      // $FF: Couldn't be decompiled
   }

   static List findMissingFields(MessageOrBuilder var0) {
      ArrayList var1 = new ArrayList();
      findMissingFields(var0, "", var1);
      return var1;
   }

   static boolean mergeFieldFrom(CodedInputStream var0, UnknownFieldSet$Builder var1, ExtensionRegistryLite var2, Descriptors$Descriptor var3, MessageReflection$MergeTarget var4, int var5) {
      // $FF: Couldn't be decompiled
   }

   private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream var0, UnknownFieldSet$Builder var1, ExtensionRegistryLite var2, Descriptors$Descriptor var3, MessageReflection$MergeTarget var4) {
      int var5 = 0;
      ByteString var6 = null;
      ExtensionRegistry$ExtensionInfo var7 = null;

      while(true) {
         int var8 = var0.readTag();
         if(var8 == 0) {
            break;
         }

         if(var8 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
            var5 = var0.readUInt32();
            if(var5 != 0 && var2 instanceof ExtensionRegistry) {
               var7 = var4.findExtensionByNumber((ExtensionRegistry)var2, var3, var5);
            }
         } else if(var8 == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
            if(var5 != 0 && var7 != null && ExtensionRegistryLite.isEagerlyParseMessageSets()) {
               eagerlyMergeMessageSetExtension(var0, var7, var2, var4);
               var6 = null;
            } else {
               var6 = var0.readBytes();
            }
         } else if(!var0.skipField(var8)) {
            break;
         }
      }

      var0.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
      if(var6 != null && var5 != 0) {
         if(var7 != null) {
            mergeMessageSetExtensionFromBytes(var6, var7, var2, var4);
         } else if(var6 != null) {
            var1.mergeField(var5, UnknownFieldSet$Field.newBuilder().addLengthDelimited(var6).build());
         }
      }

   }

   private static void mergeMessageSetExtensionFromBytes(ByteString var0, ExtensionRegistry$ExtensionInfo var1, ExtensionRegistryLite var2, MessageReflection$MergeTarget var3) {
      Descriptors$FieldDescriptor var4 = var1.descriptor;
      boolean var5 = var3.hasField(var4);
      if(!var5 && !ExtensionRegistryLite.isEagerlyParseMessageSets()) {
         LazyField var7 = new LazyField(var1.defaultInstance, var2, var0);
         var3.setField(var4, var7);
      } else {
         Object var6 = var3.parseMessageFromBytes(var0, var2, var4, var1.defaultInstance);
         var3.setField(var4, var6);
      }

   }

   private static void eagerlyMergeMessageSetExtension(CodedInputStream var0, ExtensionRegistry$ExtensionInfo var1, ExtensionRegistryLite var2, MessageReflection$MergeTarget var3) {
      Descriptors$FieldDescriptor var4 = var1.descriptor;
      Object var5 = var3.parseMessage(var0, var2, var4, var1.defaultInstance);
      var3.setField(var4, var5);
   }
}
