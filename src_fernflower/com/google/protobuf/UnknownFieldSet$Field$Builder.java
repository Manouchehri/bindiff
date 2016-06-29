package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$1;
import com.google.protobuf.UnknownFieldSet$Field;
import java.util.ArrayList;
import java.util.Collections;

public final class UnknownFieldSet$Field$Builder {
   private UnknownFieldSet$Field result;

   private static UnknownFieldSet$Field$Builder create() {
      UnknownFieldSet$Field$Builder var0 = new UnknownFieldSet$Field$Builder();
      var0.result = new UnknownFieldSet$Field((UnknownFieldSet$1)null);
      return var0;
   }

   public UnknownFieldSet$Field build() {
      if(UnknownFieldSet$Field.access$500(this.result) == null) {
         UnknownFieldSet$Field.access$502(this.result, Collections.emptyList());
      } else {
         UnknownFieldSet$Field.access$502(this.result, Collections.unmodifiableList(UnknownFieldSet$Field.access$500(this.result)));
      }

      if(UnknownFieldSet$Field.access$600(this.result) == null) {
         UnknownFieldSet$Field.access$602(this.result, Collections.emptyList());
      } else {
         UnknownFieldSet$Field.access$602(this.result, Collections.unmodifiableList(UnknownFieldSet$Field.access$600(this.result)));
      }

      if(UnknownFieldSet$Field.access$700(this.result) == null) {
         UnknownFieldSet$Field.access$702(this.result, Collections.emptyList());
      } else {
         UnknownFieldSet$Field.access$702(this.result, Collections.unmodifiableList(UnknownFieldSet$Field.access$700(this.result)));
      }

      if(UnknownFieldSet$Field.access$800(this.result) == null) {
         UnknownFieldSet$Field.access$802(this.result, Collections.emptyList());
      } else {
         UnknownFieldSet$Field.access$802(this.result, Collections.unmodifiableList(UnknownFieldSet$Field.access$800(this.result)));
      }

      if(UnknownFieldSet$Field.access$900(this.result) == null) {
         UnknownFieldSet$Field.access$902(this.result, Collections.emptyList());
      } else {
         UnknownFieldSet$Field.access$902(this.result, Collections.unmodifiableList(UnknownFieldSet$Field.access$900(this.result)));
      }

      UnknownFieldSet$Field var1 = this.result;
      this.result = null;
      return var1;
   }

   public UnknownFieldSet$Field$Builder clear() {
      this.result = new UnknownFieldSet$Field((UnknownFieldSet$1)null);
      return this;
   }

   public UnknownFieldSet$Field$Builder mergeFrom(UnknownFieldSet$Field var1) {
      if(!UnknownFieldSet$Field.access$500(var1).isEmpty()) {
         if(UnknownFieldSet$Field.access$500(this.result) == null) {
            UnknownFieldSet$Field.access$502(this.result, new ArrayList());
         }

         UnknownFieldSet$Field.access$500(this.result).addAll(UnknownFieldSet$Field.access$500(var1));
      }

      if(!UnknownFieldSet$Field.access$600(var1).isEmpty()) {
         if(UnknownFieldSet$Field.access$600(this.result) == null) {
            UnknownFieldSet$Field.access$602(this.result, new ArrayList());
         }

         UnknownFieldSet$Field.access$600(this.result).addAll(UnknownFieldSet$Field.access$600(var1));
      }

      if(!UnknownFieldSet$Field.access$700(var1).isEmpty()) {
         if(UnknownFieldSet$Field.access$700(this.result) == null) {
            UnknownFieldSet$Field.access$702(this.result, new ArrayList());
         }

         UnknownFieldSet$Field.access$700(this.result).addAll(UnknownFieldSet$Field.access$700(var1));
      }

      if(!UnknownFieldSet$Field.access$800(var1).isEmpty()) {
         if(UnknownFieldSet$Field.access$800(this.result) == null) {
            UnknownFieldSet$Field.access$802(this.result, new ArrayList());
         }

         UnknownFieldSet$Field.access$800(this.result).addAll(UnknownFieldSet$Field.access$800(var1));
      }

      if(!UnknownFieldSet$Field.access$900(var1).isEmpty()) {
         if(UnknownFieldSet$Field.access$900(this.result) == null) {
            UnknownFieldSet$Field.access$902(this.result, new ArrayList());
         }

         UnknownFieldSet$Field.access$900(this.result).addAll(UnknownFieldSet$Field.access$900(var1));
      }

      return this;
   }

   public UnknownFieldSet$Field$Builder addVarint(long var1) {
      if(UnknownFieldSet$Field.access$500(this.result) == null) {
         UnknownFieldSet$Field.access$502(this.result, new ArrayList());
      }

      UnknownFieldSet$Field.access$500(this.result).add(Long.valueOf(var1));
      return this;
   }

   public UnknownFieldSet$Field$Builder addFixed32(int var1) {
      if(UnknownFieldSet$Field.access$600(this.result) == null) {
         UnknownFieldSet$Field.access$602(this.result, new ArrayList());
      }

      UnknownFieldSet$Field.access$600(this.result).add(Integer.valueOf(var1));
      return this;
   }

   public UnknownFieldSet$Field$Builder addFixed64(long var1) {
      if(UnknownFieldSet$Field.access$700(this.result) == null) {
         UnknownFieldSet$Field.access$702(this.result, new ArrayList());
      }

      UnknownFieldSet$Field.access$700(this.result).add(Long.valueOf(var1));
      return this;
   }

   public UnknownFieldSet$Field$Builder addLengthDelimited(ByteString var1) {
      if(UnknownFieldSet$Field.access$800(this.result) == null) {
         UnknownFieldSet$Field.access$802(this.result, new ArrayList());
      }

      UnknownFieldSet$Field.access$800(this.result).add(var1);
      return this;
   }

   public UnknownFieldSet$Field$Builder addGroup(UnknownFieldSet var1) {
      if(UnknownFieldSet$Field.access$900(this.result) == null) {
         UnknownFieldSet$Field.access$902(this.result, new ArrayList());
      }

      UnknownFieldSet$Field.access$900(this.result).add(var1);
      return this;
   }

   // $FF: synthetic method
   static UnknownFieldSet$Field$Builder access$300() {
      return create();
   }
}
