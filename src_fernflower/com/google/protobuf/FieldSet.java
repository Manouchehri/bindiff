package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.FieldSet$1;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.LazyField;
import com.google.protobuf.LazyField$LazyIterator;
import com.google.protobuf.MessageLite;
import com.google.protobuf.SmallSortedMap;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import com.google.protobuf.WireFormat$Utf8Validation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class FieldSet {
   private final SmallSortedMap fields;
   private boolean isImmutable;
   private boolean hasLazyField = false;
   private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);

   private FieldSet() {
      this.fields = SmallSortedMap.newFieldMap(16);
   }

   private FieldSet(boolean var1) {
      this.fields = SmallSortedMap.newFieldMap(0);
      this.makeImmutable();
   }

   public static FieldSet newFieldSet() {
      return new FieldSet();
   }

   public static FieldSet emptySet() {
      return DEFAULT_INSTANCE;
   }

   public void makeImmutable() {
      if(!this.isImmutable) {
         this.fields.makeImmutable();
         this.isImmutable = true;
      }
   }

   public boolean isImmutable() {
      return this.isImmutable;
   }

   public FieldSet clone() {
      FieldSet var1 = newFieldSet();

      Entry var3;
      FieldSet$FieldDescriptorLite var4;
      for(int var2 = 0; var2 < this.fields.getNumArrayEntries(); ++var2) {
         var3 = this.fields.getArrayEntryAt(var2);
         var4 = (FieldSet$FieldDescriptorLite)var3.getKey();
         var1.setField(var4, var3.getValue());
      }

      Iterator var5 = this.fields.getOverflowEntries().iterator();

      while(var5.hasNext()) {
         var3 = (Entry)var5.next();
         var4 = (FieldSet$FieldDescriptorLite)var3.getKey();
         var1.setField(var4, var3.getValue());
      }

      var1.hasLazyField = this.hasLazyField;
      return var1;
   }

   public void clear() {
      this.fields.clear();
      this.hasLazyField = false;
   }

   public Map getAllFields() {
      if(!this.hasLazyField) {
         return (Map)(this.fields.isImmutable()?this.fields:Collections.unmodifiableMap(this.fields));
      } else {
         SmallSortedMap var1 = SmallSortedMap.newFieldMap(16);

         for(int var2 = 0; var2 < this.fields.getNumArrayEntries(); ++var2) {
            this.cloneFieldEntry(var1, this.fields.getArrayEntryAt(var2));
         }

         Iterator var4 = this.fields.getOverflowEntries().iterator();

         while(var4.hasNext()) {
            Entry var3 = (Entry)var4.next();
            this.cloneFieldEntry(var1, var3);
         }

         if(this.fields.isImmutable()) {
            var1.makeImmutable();
         }

         return var1;
      }
   }

   private void cloneFieldEntry(Map var1, Entry var2) {
      FieldSet$FieldDescriptorLite var3 = (FieldSet$FieldDescriptorLite)var2.getKey();
      Object var4 = var2.getValue();
      if(var4 instanceof LazyField) {
         var1.put(var3, ((LazyField)var4).getValue());
      } else {
         var1.put(var3, var4);
      }

   }

   public Iterator iterator() {
      return (Iterator)(this.hasLazyField?new LazyField$LazyIterator(this.fields.entrySet().iterator()):this.fields.entrySet().iterator());
   }

   public boolean hasField(FieldSet$FieldDescriptorLite var1) {
      if(var1.isRepeated()) {
         throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
      } else {
         return this.fields.get(var1) != null;
      }
   }

   public Object getField(FieldSet$FieldDescriptorLite var1) {
      Object var2 = this.fields.get(var1);
      return var2 instanceof LazyField?((LazyField)var2).getValue():var2;
   }

   public void setField(FieldSet$FieldDescriptorLite var1, Object var2) {
      if(var1.isRepeated()) {
         if(!(var2 instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
         }

         ArrayList var3 = new ArrayList();
         var3.addAll((List)var2);
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            verifyType(var1.getLiteType(), var5);
         }

         var2 = var3;
      } else {
         verifyType(var1.getLiteType(), var2);
      }

      if(var2 instanceof LazyField) {
         this.hasLazyField = true;
      }

      this.fields.put((Comparable)var1, var2);
   }

   public void clearField(FieldSet$FieldDescriptorLite var1) {
      this.fields.remove(var1);
      if(this.fields.isEmpty()) {
         this.hasLazyField = false;
      }

   }

   public int getRepeatedFieldCount(FieldSet$FieldDescriptorLite var1) {
      if(!var1.isRepeated()) {
         throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      } else {
         Object var2 = this.getField(var1);
         return var2 == null?0:((List)var2).size();
      }
   }

   public Object getRepeatedField(FieldSet$FieldDescriptorLite var1, int var2) {
      if(!var1.isRepeated()) {
         throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      } else {
         Object var3 = this.getField(var1);
         if(var3 == null) {
            throw new IndexOutOfBoundsException();
         } else {
            return ((List)var3).get(var2);
         }
      }
   }

   public void setRepeatedField(FieldSet$FieldDescriptorLite var1, int var2, Object var3) {
      if(!var1.isRepeated()) {
         throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      } else {
         Object var4 = this.getField(var1);
         if(var4 == null) {
            throw new IndexOutOfBoundsException();
         } else {
            verifyType(var1.getLiteType(), var3);
            ((List)var4).set(var2, var3);
         }
      }
   }

   public void addRepeatedField(FieldSet$FieldDescriptorLite var1, Object var2) {
      if(!var1.isRepeated()) {
         throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
      } else {
         verifyType(var1.getLiteType(), var2);
         Object var3 = this.getField(var1);
         Object var4;
         if(var3 == null) {
            var4 = new ArrayList();
            this.fields.put((Comparable)var1, var4);
         } else {
            var4 = (List)var3;
         }

         ((List)var4).add(var2);
      }
   }

   private static void verifyType(WireFormat$FieldType var0, Object var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         boolean var2 = false;
         switch(FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[var0.getJavaType().ordinal()]) {
         case 1:
            var2 = var1 instanceof Integer;
            break;
         case 2:
            var2 = var1 instanceof Long;
            break;
         case 3:
            var2 = var1 instanceof Float;
            break;
         case 4:
            var2 = var1 instanceof Double;
            break;
         case 5:
            var2 = var1 instanceof Boolean;
            break;
         case 6:
            var2 = var1 instanceof String;
            break;
         case 7:
            var2 = var1 instanceof ByteString || var1 instanceof byte[];
            break;
         case 8:
            var2 = var1 instanceof Integer || var1 instanceof Internal$EnumLite;
            break;
         case 9:
            var2 = var1 instanceof MessageLite || var1 instanceof LazyField;
         }

         if(!var2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
         }
      }
   }

   public boolean isInitialized() {
      for(int var1 = 0; var1 < this.fields.getNumArrayEntries(); ++var1) {
         if(!this.isInitialized(this.fields.getArrayEntryAt(var1))) {
            return false;
         }
      }

      Iterator var3 = this.fields.getOverflowEntries().iterator();

      Entry var2;
      do {
         if(!var3.hasNext()) {
            return true;
         }

         var2 = (Entry)var3.next();
      } while(this.isInitialized(var2));

      return false;
   }

   private boolean isInitialized(Entry var1) {
      FieldSet$FieldDescriptorLite var2 = (FieldSet$FieldDescriptorLite)var1.getKey();
      if(var2.getLiteJavaType() == WireFormat$JavaType.MESSAGE) {
         if(var2.isRepeated()) {
            Iterator var3 = ((List)var1.getValue()).iterator();

            while(var3.hasNext()) {
               MessageLite var4 = (MessageLite)var3.next();
               if(!var4.isInitialized()) {
                  return false;
               }
            }
         } else {
            Object var5 = var1.getValue();
            if(!(var5 instanceof MessageLite)) {
               if(var5 instanceof LazyField) {
                  return true;
               }

               throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }

            if(!((MessageLite)var5).isInitialized()) {
               return false;
            }
         }
      }

      return true;
   }

   static int getWireFormatForFieldType(WireFormat$FieldType var0, boolean var1) {
      return var1?2:var0.getWireType();
   }

   public void mergeFrom(FieldSet var1) {
      for(int var2 = 0; var2 < var1.fields.getNumArrayEntries(); ++var2) {
         this.mergeFromField(var1.fields.getArrayEntryAt(var2));
      }

      Iterator var4 = var1.fields.getOverflowEntries().iterator();

      while(var4.hasNext()) {
         Entry var3 = (Entry)var4.next();
         this.mergeFromField(var3);
      }

   }

   private Object cloneIfMutable(Object var1) {
      if(var1 instanceof byte[]) {
         byte[] var2 = (byte[])((byte[])var1);
         byte[] var3 = new byte[var2.length];
         System.arraycopy(var2, 0, var3, 0, var2.length);
         return var3;
      } else {
         return var1;
      }
   }

   private void mergeFromField(Entry var1) {
      FieldSet$FieldDescriptorLite var2 = (FieldSet$FieldDescriptorLite)var1.getKey();
      Object var3 = var1.getValue();
      if(var3 instanceof LazyField) {
         var3 = ((LazyField)var3).getValue();
      }

      Object var4;
      if(var2.isRepeated()) {
         var4 = this.getField(var2);
         if(var4 == null) {
            var4 = new ArrayList();
         }

         Iterator var5 = ((List)var3).iterator();

         while(var5.hasNext()) {
            Object var6 = var5.next();
            ((List)var4).add(this.cloneIfMutable(var6));
         }

         this.fields.put((Comparable)var2, var4);
      } else if(var2.getLiteJavaType() == WireFormat$JavaType.MESSAGE) {
         var4 = this.getField(var2);
         if(var4 == null) {
            this.fields.put((Comparable)var2, this.cloneIfMutable(var3));
         } else {
            MessageLite var7 = var2.internalMergeFrom(((MessageLite)var4).toBuilder(), (MessageLite)var3).build();
            this.fields.put((Comparable)var2, var7);
         }
      } else {
         this.fields.put((Comparable)var2, this.cloneIfMutable(var3));
      }

   }

   public static Object readPrimitiveField(CodedInputStream var0, WireFormat$FieldType var1, boolean var2) {
      return var2?WireFormat.readPrimitiveField(var0, var1, WireFormat$Utf8Validation.STRICT):WireFormat.readPrimitiveField(var0, var1, WireFormat$Utf8Validation.LOOSE);
   }

   public void writeTo(CodedOutputStream var1) {
      Entry var3;
      for(int var2 = 0; var2 < this.fields.getNumArrayEntries(); ++var2) {
         var3 = this.fields.getArrayEntryAt(var2);
         writeField((FieldSet$FieldDescriptorLite)var3.getKey(), var3.getValue(), var1);
      }

      Iterator var4 = this.fields.getOverflowEntries().iterator();

      while(var4.hasNext()) {
         var3 = (Entry)var4.next();
         writeField((FieldSet$FieldDescriptorLite)var3.getKey(), var3.getValue(), var1);
      }

   }

   public void writeMessageSetTo(CodedOutputStream var1) {
      for(int var2 = 0; var2 < this.fields.getNumArrayEntries(); ++var2) {
         this.writeMessageSetTo(this.fields.getArrayEntryAt(var2), var1);
      }

      Iterator var4 = this.fields.getOverflowEntries().iterator();

      while(var4.hasNext()) {
         Entry var3 = (Entry)var4.next();
         this.writeMessageSetTo(var3, var1);
      }

   }

   private void writeMessageSetTo(Entry var1, CodedOutputStream var2) {
      FieldSet$FieldDescriptorLite var3 = (FieldSet$FieldDescriptorLite)var1.getKey();
      if(var3.getLiteJavaType() == WireFormat$JavaType.MESSAGE && !var3.isRepeated() && !var3.isPacked()) {
         Object var4 = var1.getValue();
         if(var4 instanceof LazyField) {
            var4 = ((LazyField)var4).getValue();
         }

         var2.writeMessageSetExtension(((FieldSet$FieldDescriptorLite)var1.getKey()).getNumber(), (MessageLite)var4);
      } else {
         writeField(var3, var1.getValue(), var2);
      }

   }

   private static void writeElement(CodedOutputStream var0, WireFormat$FieldType var1, int var2, Object var3) {
      if(var1 == WireFormat$FieldType.GROUP) {
         var0.writeGroup(var2, (MessageLite)var3);
      } else {
         var0.writeTag(var2, getWireFormatForFieldType(var1, false));
         writeElementNoTag(var0, var1, var3);
      }

   }

   static void writeElementNoTag(CodedOutputStream var0, WireFormat$FieldType var1, Object var2) {
      switch(FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[var1.ordinal()]) {
      case 1:
         var0.writeDoubleNoTag(((Double)var2).doubleValue());
         break;
      case 2:
         var0.writeFloatNoTag(((Float)var2).floatValue());
         break;
      case 3:
         var0.writeInt64NoTag(((Long)var2).longValue());
         break;
      case 4:
         var0.writeUInt64NoTag(((Long)var2).longValue());
         break;
      case 5:
         var0.writeInt32NoTag(((Integer)var2).intValue());
         break;
      case 6:
         var0.writeFixed64NoTag(((Long)var2).longValue());
         break;
      case 7:
         var0.writeFixed32NoTag(((Integer)var2).intValue());
         break;
      case 8:
         var0.writeBoolNoTag(((Boolean)var2).booleanValue());
         break;
      case 9:
         var0.writeGroupNoTag((MessageLite)var2);
         break;
      case 10:
         var0.writeMessageNoTag((MessageLite)var2);
         break;
      case 11:
         if(var2 instanceof ByteString) {
            var0.writeBytesNoTag((ByteString)var2);
         } else {
            var0.writeStringNoTag((String)var2);
         }
         break;
      case 12:
         if(var2 instanceof ByteString) {
            var0.writeBytesNoTag((ByteString)var2);
         } else {
            var0.writeByteArrayNoTag((byte[])((byte[])var2));
         }
         break;
      case 13:
         var0.writeUInt32NoTag(((Integer)var2).intValue());
         break;
      case 14:
         var0.writeSFixed32NoTag(((Integer)var2).intValue());
         break;
      case 15:
         var0.writeSFixed64NoTag(((Long)var2).longValue());
         break;
      case 16:
         var0.writeSInt32NoTag(((Integer)var2).intValue());
         break;
      case 17:
         var0.writeSInt64NoTag(((Long)var2).longValue());
         break;
      case 18:
         if(var2 instanceof Internal$EnumLite) {
            var0.writeEnumNoTag(((Internal$EnumLite)var2).getNumber());
         } else {
            var0.writeEnumNoTag(((Integer)var2).intValue());
         }
      }

   }

   public static void writeField(FieldSet$FieldDescriptorLite var0, Object var1, CodedOutputStream var2) {
      WireFormat$FieldType var3 = var0.getLiteType();
      int var4 = var0.getNumber();
      if(var0.isRepeated()) {
         List var5 = (List)var1;
         if(var0.isPacked()) {
            var2.writeTag(var4, 2);
            int var6 = 0;

            Iterator var7;
            Object var8;
            for(var7 = var5.iterator(); var7.hasNext(); var6 += computeElementSizeNoTag(var3, var8)) {
               var8 = var7.next();
            }

            var2.writeRawVarint32(var6);
            var7 = var5.iterator();

            while(var7.hasNext()) {
               var8 = var7.next();
               writeElementNoTag(var2, var3, var8);
            }
         } else {
            Iterator var9 = var5.iterator();

            while(var9.hasNext()) {
               Object var10 = var9.next();
               writeElement(var2, var3, var4, var10);
            }
         }
      } else if(var1 instanceof LazyField) {
         writeElement(var2, var3, var4, ((LazyField)var1).getValue());
      } else {
         writeElement(var2, var3, var4, var1);
      }

   }

   public int getSerializedSize() {
      int var1 = 0;

      Entry var3;
      for(int var2 = 0; var2 < this.fields.getNumArrayEntries(); ++var2) {
         var3 = this.fields.getArrayEntryAt(var2);
         var1 += computeFieldSize((FieldSet$FieldDescriptorLite)var3.getKey(), var3.getValue());
      }

      for(Iterator var4 = this.fields.getOverflowEntries().iterator(); var4.hasNext(); var1 += computeFieldSize((FieldSet$FieldDescriptorLite)var3.getKey(), var3.getValue())) {
         var3 = (Entry)var4.next();
      }

      return var1;
   }

   public int getMessageSetSerializedSize() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.fields.getNumArrayEntries(); ++var2) {
         var1 += this.getMessageSetSerializedSize(this.fields.getArrayEntryAt(var2));
      }

      Entry var3;
      for(Iterator var4 = this.fields.getOverflowEntries().iterator(); var4.hasNext(); var1 += this.getMessageSetSerializedSize(var3)) {
         var3 = (Entry)var4.next();
      }

      return var1;
   }

   private int getMessageSetSerializedSize(Entry var1) {
      FieldSet$FieldDescriptorLite var2 = (FieldSet$FieldDescriptorLite)var1.getKey();
      Object var3 = var1.getValue();
      return var2.getLiteJavaType() == WireFormat$JavaType.MESSAGE && !var2.isRepeated() && !var2.isPacked()?(var3 instanceof LazyField?CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldSet$FieldDescriptorLite)var1.getKey()).getNumber(), (LazyField)var3):CodedOutputStream.computeMessageSetExtensionSize(((FieldSet$FieldDescriptorLite)var1.getKey()).getNumber(), (MessageLite)var3)):computeFieldSize(var2, var3);
   }

   private static int computeElementSize(WireFormat$FieldType var0, int var1, Object var2) {
      int var3 = CodedOutputStream.computeTagSize(var1);
      if(var0 == WireFormat$FieldType.GROUP) {
         var3 *= 2;
      }

      return var3 + computeElementSizeNoTag(var0, var2);
   }

   static int computeElementSizeNoTag(WireFormat$FieldType var0, Object var1) {
      switch(FieldSet$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[var0.ordinal()]) {
      case 1:
         return CodedOutputStream.computeDoubleSizeNoTag(((Double)var1).doubleValue());
      case 2:
         return CodedOutputStream.computeFloatSizeNoTag(((Float)var1).floatValue());
      case 3:
         return CodedOutputStream.computeInt64SizeNoTag(((Long)var1).longValue());
      case 4:
         return CodedOutputStream.computeUInt64SizeNoTag(((Long)var1).longValue());
      case 5:
         return CodedOutputStream.computeInt32SizeNoTag(((Integer)var1).intValue());
      case 6:
         return CodedOutputStream.computeFixed64SizeNoTag(((Long)var1).longValue());
      case 7:
         return CodedOutputStream.computeFixed32SizeNoTag(((Integer)var1).intValue());
      case 8:
         return CodedOutputStream.computeBoolSizeNoTag(((Boolean)var1).booleanValue());
      case 9:
         return CodedOutputStream.computeGroupSizeNoTag((MessageLite)var1);
      case 10:
         if(var1 instanceof LazyField) {
            return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField)var1);
         }

         return CodedOutputStream.computeMessageSizeNoTag((MessageLite)var1);
      case 11:
         if(var1 instanceof ByteString) {
            return CodedOutputStream.computeBytesSizeNoTag((ByteString)var1);
         }

         return CodedOutputStream.computeStringSizeNoTag((String)var1);
      case 12:
         if(var1 instanceof ByteString) {
            return CodedOutputStream.computeBytesSizeNoTag((ByteString)var1);
         }

         return CodedOutputStream.computeByteArraySizeNoTag((byte[])((byte[])var1));
      case 13:
         return CodedOutputStream.computeUInt32SizeNoTag(((Integer)var1).intValue());
      case 14:
         return CodedOutputStream.computeSFixed32SizeNoTag(((Integer)var1).intValue());
      case 15:
         return CodedOutputStream.computeSFixed64SizeNoTag(((Long)var1).longValue());
      case 16:
         return CodedOutputStream.computeSInt32SizeNoTag(((Integer)var1).intValue());
      case 17:
         return CodedOutputStream.computeSInt64SizeNoTag(((Long)var1).longValue());
      case 18:
         if(var1 instanceof Internal$EnumLite) {
            return CodedOutputStream.computeEnumSizeNoTag(((Internal$EnumLite)var1).getNumber());
         }

         return CodedOutputStream.computeEnumSizeNoTag(((Integer)var1).intValue());
      default:
         throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      }
   }

   public static int computeFieldSize(FieldSet$FieldDescriptorLite var0, Object var1) {
      WireFormat$FieldType var2 = var0.getLiteType();
      int var3 = var0.getNumber();
      if(!var0.isRepeated()) {
         return computeElementSize(var2, var3, var1);
      } else {
         int var4;
         Iterator var5;
         Object var6;
         if(var0.isPacked()) {
            var4 = 0;

            for(var5 = ((List)var1).iterator(); var5.hasNext(); var4 += computeElementSizeNoTag(var2, var6)) {
               var6 = var5.next();
            }

            return var4 + CodedOutputStream.computeTagSize(var3) + CodedOutputStream.computeRawVarint32Size(var4);
         } else {
            var4 = 0;

            for(var5 = ((List)var1).iterator(); var5.hasNext(); var4 += computeElementSize(var2, var3, var6)) {
               var6 = var5.next();
            }

            return var4;
         }
      }
   }
}
