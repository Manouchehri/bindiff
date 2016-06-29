package y.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import y.c.C;
import y.c.E;
import y.c.F;
import y.c.G;
import y.c.c;
import y.c.p;

public class D implements Collection, List {
   int a;
   p b;
   p c;
   int d;
   public static boolean e;

   public D() {
      this.d = Integer.MIN_VALUE;
   }

   public D(Collection var1) {
      this(var1.iterator());
   }

   public D(Iterator var1) {
      boolean var2 = e;
      super();

      while(true) {
         if(var1.hasNext()) {
            this.b(var1.next());
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         this.d = Integer.MIN_VALUE;
         break;
      }

   }

   public D(C var1) {
      boolean var2 = e;
      super();
      var1.i();

      while(true) {
         if(var1.f()) {
            this.b(var1.d());
            var1.g();
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         this.d = Integer.MIN_VALUE;
         break;
      }

   }

   public D(C var1, c var2) {
      boolean var3 = e;
      super();
      var1.i();

      while(var1.f()) {
         if(var2.d(var1.d())) {
            this.b(var1.d());
         }

         var1.g();
         if(var3) {
            break;
         }
      }

      this.d = Integer.MIN_VALUE;
   }

   public D(Object[] var1) {
      boolean var3 = e;
      super();
      int var2 = var1.length - 1;

      while(true) {
         if(var2 >= 0) {
            this.a(var1[var2]);
            --var2;
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         this.d = Integer.MIN_VALUE;
         break;
      }

   }

   public p a(Object var1) {
      p var2;
      label11: {
         var2 = this.e(var1);
         if(this.b == null) {
            this.b = this.c = var2;
            if(!e) {
               break label11;
            }
         }

         this.b.b = var2;
         var2.a = this.b;
         this.b = var2;
      }

      ++this.a;
      ++this.d;
      return var2;
   }

   public p b(Object var1) {
      p var2 = this.e(var1);
      if(this.c == null) {
         this.b = this.c = var2;
      } else {
         this.c.a = var2;
         var2.b = this.c;
         this.c = var2;
      }

      ++this.a;
      ++this.d;
      return var2;
   }

   public void a(p var1) {
      label11: {
         var1.b = null;
         var1.a = null;
         if(this.c == null) {
            this.b = this.c = var1;
            if(!e) {
               break label11;
            }
         }

         this.c.a = var1;
         var1.b = this.c;
         this.c = var1;
      }

      ++this.d;
      ++this.a;
   }

   public void b(p var1) {
      label11: {
         var1.b = null;
         var1.a = null;
         if(this.b == null) {
            this.b = this.c = var1;
            if(!e) {
               break label11;
            }
         }

         this.b.b = var1;
         var1.a = this.b;
         this.b = var1;
      }

      ++this.d;
      ++this.a;
   }

   public boolean add(Object var1) {
      this.b(var1);
      return true;
   }

   public boolean addAll(Collection var1) {
      boolean var10000;
      boolean var2;
      label43: {
         boolean var4 = e;
         var2 = false;
         if(var1 instanceof D) {
            p var3 = ((D)var1).k();

            do {
               if(var3 == null) {
                  break label43;
               }

               var10000 = this.add(var3.c());
               if(var4) {
                  return var10000;
               }

               if(var10000) {
                  var2 = true;
               }

               var3 = var3.a();
            } while(!var4);
         }

         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            if(this.add(var5.next())) {
               var10000 = true;
               if(var4) {
                  return var10000;
               }

               var2 = true;
               if(var4) {
                  break;
               }
            }
         }
      }

      var10000 = var2;
      return var10000;
   }

   public void a(C var1) {
      boolean var2 = e;

      while(var1.f()) {
         this.b(var1.d());
         var1.g();
         if(var2) {
            break;
         }
      }

   }

   public p a(Object var1, p var2) {
      if(var2 == this.b) {
         return this.a(var1);
      } else if(var2 == null) {
         return this.b(var1);
      } else {
         p var3 = this.e(var1);
         this.a(var3, var2);
         return var3;
      }
   }

   public void a(p var1, p var2) {
      boolean var4 = e;
      if(var2 == null) {
         this.b(var1);
         if(!var4) {
            return;
         }
      }

      if(var2 == this.b) {
         this.b(var1);
         if(!var4) {
            return;
         }
      }

      label16: {
         if(this.c == null) {
            var1.b = null;
            var1.a = null;
            this.b = this.c = var1;
            if(!var4) {
               break label16;
            }
         }

         p var3 = var2.b;
         var2.b = var1;
         var1.a = var2;
         var3.a = var1;
         var1.b = var3;
      }

      ++this.a;
      ++this.d;
   }

   public void b(p var1, p var2) {
      boolean var4 = e;
      if(var2 == null) {
         this.a(var1);
         if(!var4) {
            return;
         }
      }

      if(var2 == this.c) {
         this.a(var1);
         if(!var4) {
            return;
         }
      }

      label16: {
         if(this.b == null) {
            var1.b = null;
            var1.a = null;
            this.b = this.c = var1;
            if(!var4) {
               break label16;
            }
         }

         p var3 = var2.a;
         var2.a = var1;
         var1.a = var3;
         var3.b = var1;
         var1.b = var2;
      }

      ++this.a;
      ++this.d;
   }

   public p b(Object var1, p var2) {
      if(var2 == this.c) {
         return this.b(var1);
      } else if(var2 == null) {
         return this.a(var1);
      } else {
         p var3 = this.e(var1);
         this.b(var3, var2);
         return var3;
      }
   }

   public int size() {
      return this.a;
   }

   public boolean isEmpty() {
      return this.a == 0;
   }

   public void clear() {
      if(this.a > 0) {
         this.b = this.c = null;
         this.a = 0;
         ++this.d;
      }

   }

   public Object f() {
      return this.b.c;
   }

   public Object g() {
      Object var1 = this.f();
      this.h(this.k());
      return var1;
   }

   public p c(Object var1) {
      return this.a(var1);
   }

   public Object h() {
      return this.f();
   }

   public Object i() {
      return this.c.c;
   }

   public Object j() {
      return this.h(this.c);
   }

   public Object a(int var1) {
      boolean var4 = e;
      if(var1 >= 0 && var1 < this.size()) {
         int var2 = 0;
         p var3 = this.b;

         while(var3 != null) {
            if(var1 == var2) {
               return var3.c;
            }

            var3 = var3.a;
            ++var2;
            if(var4) {
               break;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public int indexOf(Object var1) {
      boolean var4 = e;
      int var2 = 0;
      p var3 = this.b;

      while(true) {
         if(var3 != null) {
            if(var3.c == var1 || var3.c != null && var3.c.equals(var1)) {
               return var2;
            }

            var3 = var3.a;
            ++var2;
            if(!var4) {
               continue;
            }
         }

         return -1;
      }
   }

   public p k() {
      return this.b;
   }

   public p l() {
      return this.c;
   }

   public p c(p var1) {
      return var1.a;
   }

   public p d(p var1) {
      return var1.b;
   }

   public p e(p var1) {
      return var1.a == null?this.b:var1.a;
   }

   public p f(p var1) {
      return var1.b == null?this.c:var1.b;
   }

   public Object g(p var1) {
      return var1.c;
   }

   public void a(p var1, Object var2) {
      var1.c = var2;
   }

   public boolean remove(Object var1) {
      p var2 = this.d(var1);
      if(var2 != null) {
         this.h(var2);
         return true;
      } else {
         return false;
      }
   }

   public boolean removeAll(Collection var1) {
      boolean var5 = e;
      int var2 = this.size();
      Object var3 = var1 instanceof Set?(Set)var1:new HashSet(var1);
      p var4 = this.k();

      int var10000;
      while(true) {
         if(var4 != null) {
            var10000 = ((Set)var3).contains(var4.c());
            if(var5) {
               break;
            }

            if(var10000 != 0) {
               this.h(var4);
            }

            var4 = var4.a();
            if(!var5) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000 != this.size();
   }

   public boolean retainAll(Collection var1) {
      boolean var5 = e;
      int var2 = this.size();
      Object var3 = var1 instanceof Set?(Set)var1:new HashSet(var1);
      p var4 = this.k();

      int var10000;
      while(true) {
         if(var4 != null) {
            var10000 = ((Set)var3).contains(var4.c());
            if(var5) {
               break;
            }

            if(var10000 == 0) {
               this.h(var4);
            }

            var4 = var4.a();
            if(!var5) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000 != this.size();
   }

   public Object h(p var1) {
      boolean var2;
      label19: {
         var2 = e;
         if(var1 != this.b) {
            var1.b.a = var1.a;
            if(!var2) {
               break label19;
            }
         }

         this.b = var1.a;
      }

      label14: {
         if(var1 != this.c) {
            var1.a.b = var1.b;
            if(!var2) {
               break label14;
            }
         }

         this.c = var1.b;
      }

      ++this.d;
      --this.a;
      return var1.c;
   }

   public Object b(C var1) {
      return this.h(((E)var1).a);
   }

   public C m() {
      return new E(this);
   }

   public Iterator iterator() {
      return new F(this, this.b);
   }

   public ListIterator listIterator() {
      return new G(this, 0, this.b);
   }

   public boolean contains(Object var1) {
      return this.d(var1) != null;
   }

   public boolean containsAll(Collection var1) {
      boolean var4 = e;
      Iterator var2 = var1.iterator();

      boolean var10000;
      while(true) {
         if(var2.hasNext()) {
            Object var3 = var2.next();
            if(this.contains(var3)) {
               continue;
            }

            var10000 = false;
            if(!var4) {
               return false;
            }
            break;
         }

         var10000 = true;
         break;
      }

      return var10000;
   }

   public p d(Object var1) {
      boolean var3 = e;
      p var2 = this.b;

      while(true) {
         if(var2 != null) {
            if(var2.c == var1 || var2.c != null && var2.c.equals(var1)) {
               return var2;
            }

            var2 = var2.a;
            if(!var3) {
               continue;
            }
         }

         return null;
      }
   }

   public String toString() {
      boolean var3 = e;
      StringBuffer var1 = new StringBuffer(80);
      var1.append('[');
      p var2 = this.b;

      while(true) {
         if(var2 != this.c) {
            var1.append(var2.c);
            var1.append(',');
            var2 = var2.a;
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         if(this.c != null) {
            var1.append(this.c.c);
         }

         var1.append(']');
         break;
      }

      return var1.toString();
   }

   public Object[] toArray() {
      boolean var4 = e;
      Object[] var1 = new Object[this.size()];
      int var2 = 0;
      p var3 = this.b;

      Object[] var10000;
      while(true) {
         if(var3 != null) {
            var10000 = var1;
            if(var4) {
               break;
            }

            var1[var2] = var3.c;
            var3 = var3.a;
            ++var2;
            if(!var4) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public Object[] toArray(Object[] var1) {
      boolean var4 = e;
      if(var1.length < this.a) {
         var1 = (Object[])Array.newInstance(var1.getClass().getComponentType(), this.a);
      }

      int var2 = 0;
      p var3 = this.b;

      while(true) {
         if(var3 != null) {
            var1[var2++] = var3.c;
            var3 = var3.a;
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         if(var1.length > var2) {
            var1[var2] = null;
         }
         break;
      }

      return var1;
   }

   public void n() {
      boolean var3 = e;
      p var2 = this.b;

      while(true) {
         p var1;
         if(var2 != null) {
            var1 = var2.a;
            var2.a = var2.b;
            var2.b = var1;
            var2 = var2.b;
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         var1 = this.b;
         this.b = this.c;
         this.c = var1;
         ++this.d;
         break;
      }

   }

   public void sort(Comparator var1) {
      boolean var5 = e;
      if(this.a > 1) {
         if(this.a == 2 && var1 != null) {
            if(var1.compare(this.b.c, this.c.c) <= 0) {
               return;
            }

            Object var2 = this.b.c;
            this.b.c = this.c.c;
            this.c.c = var2;
            if(!var5) {
               return;
            }
         }

         Object[] var6 = this.toArray();
         y.g.e.a(var6, var1);
         int var3 = 0;
         p var4 = this.b;

         while(var4 != null) {
            var4.c = var6[var3];
            var4 = var4.a;
            ++var3;
            if(var5) {
               break;
            }
         }
      }

   }

   public void o() {
      boolean var4 = e;
      if(this.a > 1) {
         Object[] var1 = this.toArray();
         y.g.e.a((Object[])var1, (Comparator)null);
         int var2 = 0;
         p var3 = this.b;

         while(var3 != null) {
            var3.c = var1[var2];
            var3 = var3.a;
            ++var2;
            if(var4) {
               break;
            }
         }
      }

   }

   public void a(D var1) {
      if(var1.a > 0) {
         label15: {
            if(this.b == null) {
               this.b = var1.b;
               this.c = var1.c;
               if(!e) {
                  break label15;
               }
            }

            if(var1.b != null) {
               this.c.a = var1.b;
               var1.b.b = this.c;
               this.c = var1.c;
            }
         }

         this.a += var1.a;
         var1.b = var1.c = null;
         var1.a = 0;
         ++var1.d;
         ++this.d;
      }

   }

   private p e(Object var1) {
      return new p(var1);
   }

   public boolean addAll(int var1, Collection var2) {
      boolean var10000;
      label39: {
         label42: {
            boolean var5 = e;
            p var3 = this.b(var1);
            Iterator var4;
            if(var3.a == null) {
               var4 = var2.iterator();

               do {
                  if(!var4.hasNext()) {
                     break label42;
                  }

                  this.add(var4.next());
                  if(var5) {
                     break label39;
                  }
               } while(!var5);
            }

            var4 = var2.iterator();

            while(var4.hasNext()) {
               var3 = this.b(var4.next(), var3);
               if(var5) {
                  break label39;
               }

               if(var5) {
                  break;
               }
            }
         }

         if(!var2.isEmpty()) {
            var10000 = true;
            return var10000;
         }
      }

      var10000 = false;
      return var10000;
   }

   public final p b(int var1) {
      boolean var4 = e;
      if(var1 >= 0 && var1 < this.a) {
         p var10000;
         if(var1 > this.a / 2) {
            int var5 = this.a - 1;
            p var3 = this.c;

            while(true) {
               if(var5 > var1) {
                  --var5;
                  var10000 = var3.b;
                  if(var4) {
                     break;
                  }

                  var3 = var10000;
                  if(!var4) {
                     continue;
                  }
               }

               var10000 = var3;
               break;
            }

            return var10000;
         } else {
            p var2 = this.b;

            while(true) {
               if(var1 > 0) {
                  --var1;
                  var10000 = var2.a;
                  if(var4) {
                     break;
                  }

                  var2 = var10000;
                  if(!var4) {
                     continue;
                  }
               }

               var10000 = var2;
               break;
            }

            return var10000;
         }
      } else {
         throw new IndexOutOfBoundsException(Integer.toString(var1));
      }
   }

   public int lastIndexOf(Object var1) {
      boolean var4 = e;
      int var2 = this.a - 1;
      p var3 = this.c;

      while(true) {
         if(var3 != null) {
            if(var3.c == var1 || var3.c != null && var3.c.equals(var1)) {
               return var2;
            }

            var3 = var3.b;
            --var2;
            if(!var4) {
               continue;
            }
         }

         return -1;
      }
   }

   public Object set(int var1, Object var2) {
      p var3 = this.b(var1);
      Object var4 = var3.c;
      var3.c = var2;
      return var4;
   }

   public Object remove(int var1) {
      return this.h(this.b(var1));
   }

   public ListIterator listIterator(int var1) {
      if(var1 == this.a) {
         G var2 = new G(this, var1 - 1, this.c);
         var2.next();
         return var2;
      } else {
         return new G(this, var1, this.b(var1));
      }
   }

   public Object get(int var1) {
      return this.b(var1).c;
   }

   public void add(int var1, Object var2) {
      if(var1 == this.a) {
         this.b(var2);
         if(!e) {
            return;
         }
      }

      this.a(var2, this.b(var1));
   }

   public List subList(int var1, int var2) {
      throw new UnsupportedOperationException();
   }

   public boolean equals(Object var1) {
      boolean var6 = e;
      if(!(var1 instanceof List)) {
         return false;
      } else if(var1 == this) {
         return true;
      } else {
         List var2 = (List)var1;
         if(var2.size() != this.a) {
            return false;
         } else {
            p var3 = this.b;
            Iterator var4 = var2.iterator();

            while(true) {
               if(var4.hasNext()) {
                  Object var5 = var4.next();
                  if(var3.c != var5 && (var5 == null || !var5.equals(var3.c))) {
                     return false;
                  }

                  var3 = var3.a;
                  if(!var6) {
                     continue;
                  }
               }

               return true;
            }
         }
      }
   }

   public int hashCode() {
      boolean var4 = e;
      int var1 = 1;
      p var2 = this.b;

      while(var2 != null) {
         label17: {
            Object var3 = var2.c;
            if(var3 == null) {
               var1 *= 31;
               if(!var4) {
                  break label17;
               }
            }

            var1 = var1 * 31 + var3.hashCode();
         }

         var2 = var2.a();
         if(var4) {
            break;
         }
      }

      return var1;
   }

   static {
      new y.g.o();
   }
}
