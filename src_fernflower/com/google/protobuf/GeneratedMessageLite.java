package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.BooleanArrayList;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DoubleArrayList;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FloatArrayList;
import com.google.protobuf.GeneratedMessageLite$1;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.GeneratedMessageLite$PrototypeHolder;
import com.google.protobuf.GeneratedMessageLite$SerializedForm;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal$BooleanList;
import com.google.protobuf.Internal$DoubleList;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$FloatList;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.Internal$LongList;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LongArrayList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtobufArrayList;
import com.google.protobuf.UnknownFieldSetLite;
import com.google.protobuf.UnknownFieldSetLite$Builder;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {
   private static final Map PROTOTYPE_MAP = new ConcurrentHashMap();
   private static final long serialVersionUID = 1L;
   protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();
   protected int memoizedSerializedSize = -1;

   protected static void onLoad(Class var0, GeneratedMessageLite$PrototypeHolder var1) {
      PROTOTYPE_MAP.put(var0, var1);
   }

   public final Parser getParserForType() {
      return ((GeneratedMessageLite$PrototypeHolder)PROTOTYPE_MAP.get(this.getClass())).getParserForType();
   }

   public final GeneratedMessageLite getDefaultInstanceForType() {
      return ((GeneratedMessageLite$PrototypeHolder)PROTOTYPE_MAP.get(this.getClass())).getDefaultInstanceForType();
   }

   public final GeneratedMessageLite$Builder newBuilderForType() {
      return ((GeneratedMessageLite$PrototypeHolder)PROTOTYPE_MAP.get(this.getClass())).newBuilderForType();
   }

   protected static boolean parseUnknownField(CodedInputStream var0, UnknownFieldSetLite$Builder var1, ExtensionRegistryLite var2, int var3) {
      return var1.mergeFieldFrom(var3, var0);
   }

   public final boolean isInitialized() {
      return this.dynamicMethod(GeneratedMessageLite$MethodToInvoke.IS_INITIALIZED, new Object[]{Boolean.TRUE}) != null;
   }

   public final GeneratedMessageLite$Builder toBuilder() {
      GeneratedMessageLite$Builder var1 = (GeneratedMessageLite$Builder)this.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_BUILDER, new Object[0]);
      var1.mergeFrom(this);
      return var1;
   }

   protected abstract Object dynamicMethod(GeneratedMessageLite$MethodToInvoke var1, Object... var2);

   protected final void mergeUnknownFields(UnknownFieldSetLite var1) {
      this.unknownFields = UnknownFieldSetLite.concat(this.unknownFields, var1);
   }

   protected static boolean parseUnknownField(FieldSet var0, MessageLite var1, CodedInputStream var2, UnknownFieldSetLite$Builder var3, ExtensionRegistryLite var4, int var5) {
      int var6 = WireFormat.getTagWireType(var5);
      int var7 = WireFormat.getTagFieldNumber(var5);
      GeneratedMessageLite$GeneratedExtension var8 = var4.findLiteExtensionByNumber(var1, var7);
      boolean var9 = false;
      boolean var10 = false;
      if(var8 == null) {
         var9 = true;
      } else if(var6 == FieldSet.getWireFormatForFieldType(var8.descriptor.getLiteType(), false)) {
         var10 = false;
      } else if(var8.descriptor.isRepeated && var8.descriptor.type.isPackable() && var6 == FieldSet.getWireFormatForFieldType(var8.descriptor.getLiteType(), true)) {
         var10 = true;
      } else {
         var9 = true;
      }

      if(var9) {
         return var3.mergeFieldFrom(var5, var2);
      } else {
         int var12;
         if(var10) {
            int var11 = var2.readRawVarint32();
            var12 = var2.pushLimit(var11);
            if(var8.descriptor.getLiteType() == WireFormat$FieldType.ENUM) {
               while(var2.getBytesUntilLimit() > 0) {
                  int var17 = var2.readEnum();
                  Internal$EnumLite var14 = var8.descriptor.getEnumType().findValueByNumber(var17);
                  if(var14 == null) {
                     return true;
                  }

                  var0.addRepeatedField(var8.descriptor, var8.singularToFieldSetType(var14));
               }
            } else {
               while(var2.getBytesUntilLimit() > 0) {
                  Object var13 = FieldSet.readPrimitiveField(var2, var8.descriptor.getLiteType(), false);
                  var0.addRepeatedField(var8.descriptor, var13);
               }
            }

            var2.popLimit(var12);
         } else {
            Object var15;
            switch(GeneratedMessageLite$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[var8.descriptor.getLiteJavaType().ordinal()]) {
            case 1:
               MessageLite$Builder var16 = null;
               if(!var8.descriptor.isRepeated()) {
                  MessageLite var18 = (MessageLite)var0.getField(var8.descriptor);
                  if(var18 != null) {
                     var16 = var18.toBuilder();
                  }
               }

               if(var16 == null) {
                  var16 = var8.getMessageDefaultInstance().newBuilderForType();
               }

               if(var8.descriptor.getLiteType() == WireFormat$FieldType.GROUP) {
                  var2.readGroup(var8.getNumber(), var16, var4);
               } else {
                  var2.readMessage(var16, var4);
               }

               var15 = var16.build();
               break;
            case 2:
               var12 = var2.readEnum();
               var15 = var8.descriptor.getEnumType().findValueByNumber(var12);
               if(var15 == null) {
                  var3.mergeVarintField(var7, var12);
                  return true;
               }
               break;
            default:
               var15 = FieldSet.readPrimitiveField(var2, var8.descriptor.getLiteType(), false);
            }

            if(var8.descriptor.isRepeated()) {
               var0.addRepeatedField(var8.descriptor, var8.singularToFieldSetType(var15));
            } else {
               var0.setField(var8.descriptor, var8.singularToFieldSetType(var15));
            }
         }

         return true;
      }
   }

   public static GeneratedMessageLite$GeneratedExtension newSingularGeneratedExtension(MessageLite var0, Object var1, MessageLite var2, Internal$EnumLiteMap var3, int var4, WireFormat$FieldType var5, Class var6) {
      return new GeneratedMessageLite$GeneratedExtension(var0, var1, var2, new GeneratedMessageLite$ExtensionDescriptor(var3, var4, var5, false, false), var6);
   }

   public static GeneratedMessageLite$GeneratedExtension newRepeatedGeneratedExtension(MessageLite var0, MessageLite var1, Internal$EnumLiteMap var2, int var3, WireFormat$FieldType var4, boolean var5, Class var6) {
      List var7 = Collections.emptyList();
      return new GeneratedMessageLite$GeneratedExtension(var0, var7, var1, new GeneratedMessageLite$ExtensionDescriptor(var2, var3, var4, true, var5), var6);
   }

   static java.lang.reflect.Method getMethodOrDie(Class var0, String var1, Class... var2) {
      try {
         return var0.getMethod(var1, var2);
      } catch (NoSuchMethodException var6) {
         String var4 = String.valueOf(String.valueOf(var0.getName()));
         String var5 = String.valueOf(String.valueOf(var1));
         throw new RuntimeException((new StringBuilder(45 + var4.length() + var5.length())).append("Generated message class \"").append(var4).append("\" missing method \"").append(var5).append("\".").toString(), var6);
      }
   }

   static Object invokeOrDie(java.lang.reflect.Method var0, Object var1, Object... var2) {
      try {
         return var0.invoke(var1, var2);
      } catch (IllegalAccessException var5) {
         throw new RuntimeException("Couldn\'t use Java reflection to implement protocol message reflection.", var5);
      } catch (InvocationTargetException var6) {
         Throwable var4 = var6.getCause();
         if(var4 instanceof RuntimeException) {
            throw (RuntimeException)var4;
         } else if(var4 instanceof Error) {
            throw (Error)var4;
         } else {
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", var4);
         }
      }
   }

   protected Object writeReplace() {
      return new GeneratedMessageLite$SerializedForm(this);
   }

   private static GeneratedMessageLite$GeneratedExtension checkIsLite(ExtensionLite var0) {
      if(!var0.isLite()) {
         throw new IllegalArgumentException("Expected a lite extension.");
      } else {
         return (GeneratedMessageLite$GeneratedExtension)var0;
      }
   }

   protected static final boolean isInitialized(GeneratedMessageLite var0, boolean var1) {
      return var0.dynamicMethod(GeneratedMessageLite$MethodToInvoke.IS_INITIALIZED, new Object[]{Boolean.valueOf(var1)}) != null;
   }

   protected static final void makeImmutable(GeneratedMessageLite var0) {
      var0.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MAKE_IMMUTABLE, new Object[0]);
   }

   static GeneratedMessageLite parsePartialFrom(GeneratedMessageLite var0, CodedInputStream var1, ExtensionRegistryLite var2) {
      try {
         return (GeneratedMessageLite)var0.dynamicMethod(GeneratedMessageLite$MethodToInvoke.PARSE_PARTIAL_FROM, new Object[]{var1, var2});
      } catch (RuntimeException var4) {
         if(var4.getCause() instanceof InvalidProtocolBufferException) {
            throw (InvalidProtocolBufferException)var4.getCause();
         } else {
            throw var4;
         }
      }
   }

   protected static Internal$IntList newIntList() {
      return new IntArrayList();
   }

   protected static Internal$IntList newIntList(List var0) {
      return new IntArrayList(var0);
   }

   protected static Internal$IntList emptyIntList() {
      return IntArrayList.emptyList();
   }

   protected static Internal$LongList newLongList() {
      return new LongArrayList();
   }

   protected static Internal$LongList newLongList(List var0) {
      return new LongArrayList(var0);
   }

   protected static Internal$LongList emptyLongList() {
      return LongArrayList.emptyList();
   }

   protected static Internal$FloatList newFloatList() {
      return new FloatArrayList();
   }

   protected static Internal$FloatList newFloatList(List var0) {
      return new FloatArrayList(var0);
   }

   protected static Internal$FloatList emptyFloatList() {
      return FloatArrayList.emptyList();
   }

   protected static Internal$DoubleList newDoubleList() {
      return new DoubleArrayList();
   }

   protected static Internal$DoubleList newDoubleList(List var0) {
      return new DoubleArrayList(var0);
   }

   protected static Internal$DoubleList emptyDoubleList() {
      return DoubleArrayList.emptyList();
   }

   protected static Internal$BooleanList newBooleanList() {
      return new BooleanArrayList();
   }

   protected static Internal$BooleanList newBooleanList(List var0) {
      return new BooleanArrayList(var0);
   }

   protected static Internal$BooleanList emptyBooleanList() {
      return BooleanArrayList.emptyList();
   }

   protected static Internal$ProtobufList newProtobufList() {
      return new ProtobufArrayList();
   }

   protected static Internal$ProtobufList newProtobufList(List var0) {
      return new ProtobufArrayList(var0);
   }

   protected static Internal$ProtobufList emptyProtobufList() {
      return ProtobufArrayList.emptyList();
   }

   protected static LazyStringArrayList emptyLazyStringArrayList() {
      return LazyStringArrayList.emptyList();
   }

   // $FF: synthetic method
   static GeneratedMessageLite$GeneratedExtension access$000(ExtensionLite var0) {
      return checkIsLite(var0);
   }
}
