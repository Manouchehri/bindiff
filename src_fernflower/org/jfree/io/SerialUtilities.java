package org.jfree.io;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.HashMap;
import java.util.Map;

public class SerialUtilities {
   static Class class$java$io$Serializable;
   static Class class$java$awt$GradientPaint;
   static Class class$java$awt$BasicStroke;
   static Class class$java$awt$geom$Line2D;
   static Class class$java$awt$geom$Rectangle2D;
   static Class class$java$awt$geom$Ellipse2D;
   static Class class$java$awt$geom$Arc2D;
   static Class class$java$awt$geom$GeneralPath;

   public static boolean isSerializable(Class var0) {
      return (class$java$io$Serializable == null?(class$java$io$Serializable = class$("java.io.Serializable")):class$java$io$Serializable).isAssignableFrom(var0);
   }

   public static Paint readPaint(ObjectInputStream var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'stream\' argument.");
      } else {
         Object var1 = null;
         boolean var2 = var0.readBoolean();
         if(!var2) {
            Class var3 = (Class)var0.readObject();
            if(isSerializable(var3)) {
               var1 = (Paint)var0.readObject();
            } else if(var3.equals(class$java$awt$GradientPaint == null?(class$java$awt$GradientPaint = class$("java.awt.GradientPaint")):class$java$awt$GradientPaint)) {
               float var4 = var0.readFloat();
               float var5 = var0.readFloat();
               Color var6 = (Color)var0.readObject();
               float var7 = var0.readFloat();
               float var8 = var0.readFloat();
               Color var9 = (Color)var0.readObject();
               boolean var10 = var0.readBoolean();
               var1 = new GradientPaint(var4, var5, var6, var7, var8, var9, var10);
            }
         }

         return (Paint)var1;
      }
   }

   public static void writePaint(Paint var0, ObjectOutputStream var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stream\' argument.");
      } else {
         if(var0 != null) {
            var1.writeBoolean(false);
            var1.writeObject(var0.getClass());
            if(var0 instanceof Serializable) {
               var1.writeObject(var0);
            } else if(var0 instanceof GradientPaint) {
               GradientPaint var2 = (GradientPaint)var0;
               var1.writeFloat((float)var2.getPoint1().getX());
               var1.writeFloat((float)var2.getPoint1().getY());
               var1.writeObject(var2.getColor1());
               var1.writeFloat((float)var2.getPoint2().getX());
               var1.writeFloat((float)var2.getPoint2().getY());
               var1.writeObject(var2.getColor2());
               var1.writeBoolean(var2.isCyclic());
            }
         } else {
            var1.writeBoolean(true);
         }

      }
   }

   public static Stroke readStroke(ObjectInputStream var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'stream\' argument.");
      } else {
         Object var1 = null;
         boolean var2 = var0.readBoolean();
         if(!var2) {
            Class var3 = (Class)var0.readObject();
            if(var3.equals(class$java$awt$BasicStroke == null?(class$java$awt$BasicStroke = class$("java.awt.BasicStroke")):class$java$awt$BasicStroke)) {
               float var4 = var0.readFloat();
               int var5 = var0.readInt();
               int var6 = var0.readInt();
               float var7 = var0.readFloat();
               float[] var8 = (float[])((float[])var0.readObject());
               float var9 = var0.readFloat();
               var1 = new BasicStroke(var4, var5, var6, var7, var8, var9);
            } else {
               var1 = (Stroke)var0.readObject();
            }
         }

         return (Stroke)var1;
      }
   }

   public static void writeStroke(Stroke var0, ObjectOutputStream var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stream\' argument.");
      } else {
         if(var0 != null) {
            var1.writeBoolean(false);
            if(var0 instanceof BasicStroke) {
               BasicStroke var2 = (BasicStroke)var0;
               var1.writeObject(class$java$awt$BasicStroke == null?(class$java$awt$BasicStroke = class$("java.awt.BasicStroke")):class$java$awt$BasicStroke);
               var1.writeFloat(var2.getLineWidth());
               var1.writeInt(var2.getEndCap());
               var1.writeInt(var2.getLineJoin());
               var1.writeFloat(var2.getMiterLimit());
               var1.writeObject(var2.getDashArray());
               var1.writeFloat(var2.getDashPhase());
            } else {
               var1.writeObject(var0.getClass());
               var1.writeObject(var0);
            }
         } else {
            var1.writeBoolean(true);
         }

      }
   }

   public static Shape readShape(ObjectInputStream var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'stream\' argument.");
      } else {
         Object var1 = null;
         boolean var2 = var0.readBoolean();
         if(!var2) {
            Class var3 = (Class)var0.readObject();
            double var4;
            double var6;
            double var8;
            double var10;
            if(var3.equals(class$java$awt$geom$Line2D == null?(class$java$awt$geom$Line2D = class$("java.awt.geom.Line2D")):class$java$awt$geom$Line2D)) {
               var4 = var0.readDouble();
               var6 = var0.readDouble();
               var8 = var0.readDouble();
               var10 = var0.readDouble();
               var1 = new Double(var4, var6, var8, var10);
            } else if(var3.equals(class$java$awt$geom$Rectangle2D == null?(class$java$awt$geom$Rectangle2D = class$("java.awt.geom.Rectangle2D")):class$java$awt$geom$Rectangle2D)) {
               var4 = var0.readDouble();
               var6 = var0.readDouble();
               var8 = var0.readDouble();
               var10 = var0.readDouble();
               var1 = new java.awt.geom.Rectangle2D.Double(var4, var6, var8, var10);
            } else if(var3.equals(class$java$awt$geom$Ellipse2D == null?(class$java$awt$geom$Ellipse2D = class$("java.awt.geom.Ellipse2D")):class$java$awt$geom$Ellipse2D)) {
               var4 = var0.readDouble();
               var6 = var0.readDouble();
               var8 = var0.readDouble();
               var10 = var0.readDouble();
               var1 = new java.awt.geom.Ellipse2D.Double(var4, var6, var8, var10);
            } else if(var3.equals(class$java$awt$geom$Arc2D == null?(class$java$awt$geom$Arc2D = class$("java.awt.geom.Arc2D")):class$java$awt$geom$Arc2D)) {
               var4 = var0.readDouble();
               var6 = var0.readDouble();
               var8 = var0.readDouble();
               var10 = var0.readDouble();
               double var12 = var0.readDouble();
               double var14 = var0.readDouble();
               int var16 = var0.readInt();
               var1 = new java.awt.geom.Arc2D.Double(var4, var6, var8, var10, var12, var14, var16);
            } else if(var3.equals(class$java$awt$geom$GeneralPath == null?(class$java$awt$geom$GeneralPath = class$("java.awt.geom.GeneralPath")):class$java$awt$geom$GeneralPath)) {
               GeneralPath var17 = new GeneralPath();
               float[] var5 = new float[6];

               for(boolean var18 = var0.readBoolean(); !var18; var18 = var0.readBoolean()) {
                  int var7 = var0.readInt();

                  for(int var19 = 0; var19 < 6; ++var19) {
                     var5[var19] = var0.readFloat();
                  }

                  switch(var7) {
                  case 0:
                     var17.moveTo(var5[0], var5[1]);
                     break;
                  case 1:
                     var17.lineTo(var5[0], var5[1]);
                     break;
                  case 2:
                     var17.quadTo(var5[0], var5[1], var5[2], var5[3]);
                     break;
                  case 3:
                     var17.curveTo(var5[0], var5[1], var5[2], var5[3], var5[4], var5[5]);
                  case 4:
                     break;
                  default:
                     throw new RuntimeException("JFreeChart - No path exists");
                  }

                  var17.setWindingRule(var0.readInt());
               }

               var1 = var17;
            } else {
               var1 = (Shape)var0.readObject();
            }
         }

         return (Shape)var1;
      }
   }

   public static void writeShape(Shape var0, ObjectOutputStream var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stream\' argument.");
      } else {
         if(var0 != null) {
            var1.writeBoolean(false);
            if(var0 instanceof Line2D) {
               Line2D var2 = (Line2D)var0;
               var1.writeObject(class$java$awt$geom$Line2D == null?(class$java$awt$geom$Line2D = class$("java.awt.geom.Line2D")):class$java$awt$geom$Line2D);
               var1.writeDouble(var2.getX1());
               var1.writeDouble(var2.getY1());
               var1.writeDouble(var2.getX2());
               var1.writeDouble(var2.getY2());
            } else if(var0 instanceof Rectangle2D) {
               Rectangle2D var6 = (Rectangle2D)var0;
               var1.writeObject(class$java$awt$geom$Rectangle2D == null?(class$java$awt$geom$Rectangle2D = class$("java.awt.geom.Rectangle2D")):class$java$awt$geom$Rectangle2D);
               var1.writeDouble(var6.getX());
               var1.writeDouble(var6.getY());
               var1.writeDouble(var6.getWidth());
               var1.writeDouble(var6.getHeight());
            } else if(var0 instanceof Ellipse2D) {
               Ellipse2D var7 = (Ellipse2D)var0;
               var1.writeObject(class$java$awt$geom$Ellipse2D == null?(class$java$awt$geom$Ellipse2D = class$("java.awt.geom.Ellipse2D")):class$java$awt$geom$Ellipse2D);
               var1.writeDouble(var7.getX());
               var1.writeDouble(var7.getY());
               var1.writeDouble(var7.getWidth());
               var1.writeDouble(var7.getHeight());
            } else if(var0 instanceof Arc2D) {
               Arc2D var8 = (Arc2D)var0;
               var1.writeObject(class$java$awt$geom$Arc2D == null?(class$java$awt$geom$Arc2D = class$("java.awt.geom.Arc2D")):class$java$awt$geom$Arc2D);
               var1.writeDouble(var8.getX());
               var1.writeDouble(var8.getY());
               var1.writeDouble(var8.getWidth());
               var1.writeDouble(var8.getHeight());
               var1.writeDouble(var8.getAngleStart());
               var1.writeDouble(var8.getAngleExtent());
               var1.writeInt(var8.getArcType());
            } else if(var0 instanceof GeneralPath) {
               var1.writeObject(class$java$awt$geom$GeneralPath == null?(class$java$awt$geom$GeneralPath = class$("java.awt.geom.GeneralPath")):class$java$awt$geom$GeneralPath);
               PathIterator var9 = var0.getPathIterator((AffineTransform)null);
               float[] var3 = new float[6];
               var1.writeBoolean(var9.isDone());

               while(!var9.isDone()) {
                  int var4 = var9.currentSegment(var3);
                  var1.writeInt(var4);

                  for(int var5 = 0; var5 < 6; ++var5) {
                     var1.writeFloat(var3[var5]);
                  }

                  var1.writeInt(var9.getWindingRule());
                  var9.next();
                  var1.writeBoolean(var9.isDone());
               }
            } else {
               var1.writeObject(var0.getClass());
               var1.writeObject(var0);
            }
         } else {
            var1.writeBoolean(true);
         }

      }
   }

   public static Point2D readPoint2D(ObjectInputStream var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'stream\' argument.");
      } else {
         java.awt.geom.Point2D.Double var1 = null;
         boolean var2 = var0.readBoolean();
         if(!var2) {
            double var3 = var0.readDouble();
            double var5 = var0.readDouble();
            var1 = new java.awt.geom.Point2D.Double(var3, var5);
         }

         return var1;
      }
   }

   public static void writePoint2D(Point2D var0, ObjectOutputStream var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stream\' argument.");
      } else {
         if(var0 != null) {
            var1.writeBoolean(false);
            var1.writeDouble(var0.getX());
            var1.writeDouble(var0.getY());
         } else {
            var1.writeBoolean(true);
         }

      }
   }

   public static AttributedString readAttributedString(ObjectInputStream var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'stream\' argument.");
      } else {
         AttributedString var1 = null;
         boolean var2 = var0.readBoolean();
         if(!var2) {
            String var3 = (String)var0.readObject();
            var1 = new AttributedString(var3);
            char var4 = var0.readChar();

            for(int var5 = 0; var4 != '\uffff'; var4 = var0.readChar()) {
               int var6 = var0.readInt();
               Map var7 = (Map)var0.readObject();
               var1.addAttributes(var7, var5, var6);
               var5 = var6;
            }
         }

         return var1;
      }
   }

   public static void writeAttributedString(AttributedString var0, ObjectOutputStream var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stream\' argument.");
      } else {
         if(var0 != null) {
            var1.writeBoolean(false);
            AttributedCharacterIterator var2 = var0.getIterator();
            StringBuffer var3 = new StringBuffer();

            char var4;
            for(var4 = var2.first(); var4 != '\uffff'; var4 = var2.next()) {
               var3 = var3.append(var4);
            }

            var1.writeObject(var3.toString());
            var4 = var2.first();

            int var6;
            for(int var5 = var2.getBeginIndex(); var4 != '\uffff'; var4 = var2.setIndex(var6)) {
               var1.writeChar(var4);
               var6 = var2.getRunLimit();
               var1.writeInt(var6 - var5);
               HashMap var7 = new HashMap(var2.getAttributes());
               var1.writeObject(var7);
            }

            var1.writeChar('\uffff');
         } else {
            var1.writeBoolean(true);
         }

      }
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
