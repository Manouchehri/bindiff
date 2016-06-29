package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.TextFormat;
import com.google.protobuf.UninitializedMessageException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class AbstractMessage extends AbstractMessageLite implements Message {
   protected int memoizedSize = -1;

   public boolean isInitialized() {
      return MessageReflection.isInitialized(this);
   }

   public List findInitializationErrors() {
      return MessageReflection.findMissingFields(this);
   }

   public String getInitializationErrorString() {
      return MessageReflection.delimitWithCommas(this.findInitializationErrors());
   }

   public boolean hasOneof(Descriptors$OneofDescriptor var1) {
      throw new UnsupportedOperationException("hasOneof() is not implemented.");
   }

   public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1) {
      throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
   }

   public final String toString() {
      return TextFormat.printToString((MessageOrBuilder)this);
   }

   public void writeTo(CodedOutputStream var1) {
      MessageReflection.writeMessageTo(this, this.getAllFields(), var1, false);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSize;
      if(var1 != -1) {
         return var1;
      } else {
         this.memoizedSize = MessageReflection.getSerializedSize(this, this.getAllFields());
         return this.memoizedSize;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Message)) {
         return false;
      } else {
         Message var2 = (Message)var1;
         return this.getDescriptorForType() != var2.getDescriptorForType()?false:compareFields(this.getAllFields(), var2.getAllFields()) && this.getUnknownFields().equals(var2.getUnknownFields());
      }
   }

   public int hashCode() {
      int var1 = this.memoizedHashCode;
      if(var1 == 0) {
         byte var2 = 41;
         var1 = 19 * var2 + this.getDescriptorForType().hashCode();
         var1 = hashFields(var1, this.getAllFields());
         var1 = 29 * var1 + this.getUnknownFields().hashCode();
         this.memoizedHashCode = var1;
      }

      return var1;
   }

   private static ByteString toByteString(Object var0) {
      return var0 instanceof byte[]?ByteString.copyFrom((byte[])((byte[])var0)):(ByteString)var0;
   }

   private static boolean compareBytes(Object var0, Object var1) {
      return var0 instanceof byte[] && var1 instanceof byte[]?Arrays.equals((byte[])((byte[])var0), (byte[])((byte[])var1)):toByteString(var0).equals(toByteString(var1));
   }

   private static Map convertMapEntryListToMap(List var0) {
      if(var0.isEmpty()) {
         return Collections.emptyMap();
      } else {
         HashMap var1 = new HashMap();
         Iterator var2 = var0.iterator();
         Message var3 = (Message)var2.next();
         Descriptors$Descriptor var4 = var3.getDescriptorForType();
         Descriptors$FieldDescriptor var5 = var4.findFieldByName("key");
         Descriptors$FieldDescriptor var6 = var4.findFieldByName("value");
         var1.put(var3.getField(var5), var3.getField(var6));

         while(var2.hasNext()) {
            var3 = (Message)var2.next();
            var1.put(var3.getField(var5), var3.getField(var6));
         }

         return var1;
      }
   }

   private static boolean compareMapField(Object var0, Object var1) {
      Map var2 = convertMapEntryListToMap((List)var0);
      Map var3 = convertMapEntryListToMap((List)var1);
      return MapFieldLite.equals(var2, var3);
   }

   static boolean compareFields(Map var0, Map var1) {
      if(var0.size() != var1.size()) {
         return false;
      } else {
         Iterator var2 = var0.keySet().iterator();

         while(true) {
            while(true) {
               while(var2.hasNext()) {
                  Descriptors$FieldDescriptor var3 = (Descriptors$FieldDescriptor)var2.next();
                  if(!var1.containsKey(var3)) {
                     return false;
                  }

                  Object var4 = var0.get(var3);
                  Object var5 = var1.get(var3);
                  if(var3.getType() == Descriptors$FieldDescriptor$Type.BYTES) {
                     if(var3.isRepeated()) {
                        List var6 = (List)var4;
                        List var7 = (List)var5;
                        if(var6.size() != var7.size()) {
                           return false;
                        }

                        for(int var8 = 0; var8 < var6.size(); ++var8) {
                           if(!compareBytes(var6.get(var8), var7.get(var8))) {
                              return false;
                           }
                        }
                     } else if(!compareBytes(var4, var5)) {
                        return false;
                     }
                  } else if(var3.isMapField()) {
                     if(!compareMapField(var4, var5)) {
                        return false;
                     }
                  } else if(!var4.equals(var5)) {
                     return false;
                  }
               }

               return true;
            }
         }
      }
   }

   private static int hashMapField(Object var0) {
      return MapFieldLite.calculateHashCodeForMap(convertMapEntryListToMap((List)var0));
   }

   protected static int hashFields(int var0, Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         Descriptors$FieldDescriptor var4 = (Descriptors$FieldDescriptor)var3.getKey();
         Object var5 = var3.getValue();
         var0 = 37 * var0 + var4.getNumber();
         if(var4.isMapField()) {
            var0 = 53 * var0 + hashMapField(var5);
         } else if(var4.getType() != Descriptors$FieldDescriptor$Type.ENUM) {
            var0 = 53 * var0 + var5.hashCode();
         } else if(var4.isRepeated()) {
            List var6 = (List)var5;
            var0 = 53 * var0 + Internal.hashEnumList(var6);
         } else {
            var0 = 53 * var0 + Internal.hashEnum((Internal$EnumLite)var5);
         }
      }

      return var0;
   }

   UninitializedMessageException newUninitializedMessageException() {
      return AbstractMessage$Builder.newUninitializedMessageException(this);
   }
}
