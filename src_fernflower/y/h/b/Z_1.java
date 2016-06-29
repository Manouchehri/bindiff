package y.h.b;

import java.awt.Color;
import java.awt.Stroke;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import y.h.dr;
import y.h.fj;
import y.h.b.Y;
import y.h.b.a;

public class Z implements Externalizable, Y {
   private dr a;
   private Color b;
   private Color c;
   private dr d;
   private Color e;
   private Color f;

   public Z() {
      this((dr)null, (Color)null, (Color)null, (dr)null, (Color)null, (Color)null);
   }

   public Z(dr var1, Color var2, Color var3) {
      this((dr)null, (Color)null, (Color)null, var1, var2, var3);
   }

   public Z(dr var1, Color var2, Color var3, dr var4, Color var5, Color var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   public Stroke a(fj var1) {
      return this.a;
   }

   public Color b(fj var1) {
      return this.b;
   }

   public Color c(fj var1) {
      return this.c;
   }

   public Stroke d(fj var1) {
      return this.d;
   }

   public Color e(fj var1) {
      return this.e;
   }

   public Color f(fj var1) {
      return this.f;
   }

   public void readExternal(ObjectInput var1) {
      switch(var1.readByte()) {
      case 0:
         this.a = dr.a(var1);
         this.b = (Color)var1.readObject();
         this.c = (Color)var1.readObject();
         this.d = dr.a(var1);
         this.e = (Color)var1.readObject();
         this.f = (Color)var1.readObject();
         if(a.H == 0) {
            return;
         }
      default:
         throw new y.e.a();
      }
   }

   public void writeExternal(ObjectOutput var1) {
      var1.writeByte(0);
      dr.a(var1, this.a);
      var1.writeObject(this.b);
      var1.writeObject(this.c);
      dr.a(var1, this.d);
      var1.writeObject(this.e);
      var1.writeObject(this.f);
   }
}
