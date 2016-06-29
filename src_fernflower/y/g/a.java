package y.g;

import y.g.ag;

public abstract class a implements ag {
   protected Class a;

   protected a(Class var1) {
      this.a = var1;
   }

   public Object a(String var1, Class var2) {
      if(var1 == null) {
         return null;
      } else if(var2 == null) {
         throw new NullPointerException("Must provide asClass argument!");
      } else if(!this.a.isAssignableFrom(var2)) {
         throw new IllegalArgumentException(this + " cannot parse " + var1 + " as " + var2);
      } else {
         return this.a(var1);
      }
   }

   public String a(Object var1, Class var2) {
      if(var1 == null) {
         return null;
      } else if(var2 == null) {
         throw new NullPointerException("Must provide asClass argument!");
      } else if(!this.a.isAssignableFrom(var2)) {
         throw new IllegalArgumentException(this + " cannot serializer " + var1 + " as " + var2);
      } else {
         return this.a(var1);
      }
   }

   protected abstract Object a(String var1);

   protected abstract String a(Object var1);
}
