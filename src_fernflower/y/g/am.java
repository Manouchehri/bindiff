package y.g;

import java.io.Serializable;

public final class am implements Serializable {
   public final Object a;
   public final Object b;

   public am(Object var1, Object var2) {
      this.a = var1;
      this.b = var2;
   }

   public final boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof am)) {
         return false;
      } else {
         boolean var10000;
         label43: {
            label29: {
               am var2 = (am)var1;
               if(this.a != null) {
                  if(!this.a.equals(var2.a)) {
                     break label29;
                  }
               } else if(var2.a != null) {
                  break label29;
               }

               if(this.b != null) {
                  if(this.b.equals(var2.b)) {
                     break label43;
                  }
               } else if(var2.b == null) {
                  break label43;
               }
            }

            var10000 = false;
            return var10000;
         }

         var10000 = true;
         return var10000;
      }
   }

   public final int hashCode() {
      return this.a != null?(this.b != null?this.a.hashCode() ^ this.b.hashCode() >>> 1:this.a.hashCode()):(this.b != null?this.b.hashCode() >>> 1:666);
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer(50);
      var1.append('[');
      var1.append(this.a);
      var1.append(':');
      var1.append(this.b);
      var1.append(']');
      return var1.toString();
   }

   public static final Object a(Object var0, Object var1) {
      return new am(var0, var1);
   }

   public static final Object a(Object var0, Object var1, Object var2) {
      return new am(var0, new am(var1, var2));
   }

   public static final Object a(Object var0, Object var1, Object var2, Object var3) {
      return new am(var0, new am(var1, new am(var2, var3)));
   }
}
