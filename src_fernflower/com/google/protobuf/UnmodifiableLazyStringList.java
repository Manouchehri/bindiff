package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList$1;
import com.google.protobuf.UnmodifiableLazyStringList$2;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList implements LazyStringList, RandomAccess {
   private final LazyStringList list;

   public UnmodifiableLazyStringList(LazyStringList var1) {
      this.list = var1;
   }

   public String get(int var1) {
      return (String)this.list.get(var1);
   }

   public int size() {
      return this.list.size();
   }

   public ByteString getByteString(int var1) {
      return this.list.getByteString(var1);
   }

   public void add(ByteString var1) {
      throw new UnsupportedOperationException();
   }

   public void set(int var1, ByteString var2) {
      throw new UnsupportedOperationException();
   }

   public boolean addAllByteString(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public byte[] getByteArray(int var1) {
      return this.list.getByteArray(var1);
   }

   public void add(byte[] var1) {
      throw new UnsupportedOperationException();
   }

   public void set(int var1, byte[] var2) {
      throw new UnsupportedOperationException();
   }

   public boolean addAllByteArray(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public ListIterator listIterator(int var1) {
      return new UnmodifiableLazyStringList$1(this, var1);
   }

   public Iterator iterator() {
      return new UnmodifiableLazyStringList$2(this);
   }

   public List getUnderlyingElements() {
      return this.list.getUnderlyingElements();
   }

   public void mergeFrom(LazyStringList var1) {
      throw new UnsupportedOperationException();
   }

   public List asByteArrayList() {
      return Collections.unmodifiableList(this.list.asByteArrayList());
   }

   public List asByteStringList() {
      return Collections.unmodifiableList(this.list.asByteStringList());
   }

   public LazyStringList getUnmodifiableView() {
      return this;
   }

   // $FF: synthetic method
   static LazyStringList access$000(UnmodifiableLazyStringList var0) {
      return var0.list;
   }
}
