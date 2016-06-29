/*
 * Decompiled with CFR 0_115.
 */
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

    private SerialUtilities() {
    }

    public static boolean isSerializable(Class class_) {
        Class class_2;
        if (class$java$io$Serializable == null) {
            class_2 = SerialUtilities.class$java$io$Serializable = SerialUtilities.class$("java.io.Serializable");
            return class_2.isAssignableFrom(class_);
        }
        class_2 = class$java$io$Serializable;
        return class_2.isAssignableFrom(class_);
    }

    public static Paint readPaint(ObjectInputStream objectInputStream) {
        if (objectInputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        Paint paint = null;
        boolean bl2 = objectInputStream.readBoolean();
        if (bl2) return paint;
        Class class_ = (Class)objectInputStream.readObject();
        if (SerialUtilities.isSerializable(class_)) {
            return (Paint)objectInputStream.readObject();
        }
        Class class_2 = class$java$awt$GradientPaint == null ? (SerialUtilities.class$java$awt$GradientPaint = SerialUtilities.class$("java.awt.GradientPaint")) : class$java$awt$GradientPaint;
        if (!class_.equals(class_2)) return paint;
        float f2 = objectInputStream.readFloat();
        float f3 = objectInputStream.readFloat();
        Color color = (Color)objectInputStream.readObject();
        float f4 = objectInputStream.readFloat();
        float f5 = objectInputStream.readFloat();
        Color color2 = (Color)objectInputStream.readObject();
        boolean bl3 = objectInputStream.readBoolean();
        return new GradientPaint(f2, f3, color, f4, f5, color2, bl3);
    }

    public static void writePaint(Paint paint, ObjectOutputStream objectOutputStream) {
        if (objectOutputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        if (paint == null) {
            objectOutputStream.writeBoolean(true);
            return;
        }
        objectOutputStream.writeBoolean(false);
        objectOutputStream.writeObject(paint.getClass());
        if (paint instanceof Serializable) {
            objectOutputStream.writeObject(paint);
            return;
        }
        if (!(paint instanceof GradientPaint)) return;
        GradientPaint gradientPaint = (GradientPaint)paint;
        objectOutputStream.writeFloat((float)gradientPaint.getPoint1().getX());
        objectOutputStream.writeFloat((float)gradientPaint.getPoint1().getY());
        objectOutputStream.writeObject(gradientPaint.getColor1());
        objectOutputStream.writeFloat((float)gradientPaint.getPoint2().getX());
        objectOutputStream.writeFloat((float)gradientPaint.getPoint2().getY());
        objectOutputStream.writeObject(gradientPaint.getColor2());
        objectOutputStream.writeBoolean(gradientPaint.isCyclic());
    }

    public static Stroke readStroke(ObjectInputStream objectInputStream) {
        if (objectInputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        Stroke stroke = null;
        boolean bl2 = objectInputStream.readBoolean();
        if (bl2) return stroke;
        Class class_ = (Class)objectInputStream.readObject();
        Class class_2 = class$java$awt$BasicStroke == null ? (SerialUtilities.class$java$awt$BasicStroke = SerialUtilities.class$("java.awt.BasicStroke")) : class$java$awt$BasicStroke;
        if (!class_.equals(class_2)) return (Stroke)objectInputStream.readObject();
        float f2 = objectInputStream.readFloat();
        int n2 = objectInputStream.readInt();
        int n3 = objectInputStream.readInt();
        float f3 = objectInputStream.readFloat();
        float[] arrf = (float[])objectInputStream.readObject();
        float f4 = objectInputStream.readFloat();
        return new BasicStroke(f2, n2, n3, f3, arrf, f4);
    }

    public static void writeStroke(Stroke stroke, ObjectOutputStream objectOutputStream) {
        if (objectOutputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        if (stroke == null) {
            objectOutputStream.writeBoolean(true);
            return;
        }
        objectOutputStream.writeBoolean(false);
        if (!(stroke instanceof BasicStroke)) {
            objectOutputStream.writeObject(stroke.getClass());
            objectOutputStream.writeObject(stroke);
            return;
        }
        BasicStroke basicStroke = (BasicStroke)stroke;
        Class class_ = class$java$awt$BasicStroke == null ? (SerialUtilities.class$java$awt$BasicStroke = SerialUtilities.class$("java.awt.BasicStroke")) : class$java$awt$BasicStroke;
        objectOutputStream.writeObject(class_);
        objectOutputStream.writeFloat(basicStroke.getLineWidth());
        objectOutputStream.writeInt(basicStroke.getEndCap());
        objectOutputStream.writeInt(basicStroke.getLineJoin());
        objectOutputStream.writeFloat(basicStroke.getMiterLimit());
        objectOutputStream.writeObject(basicStroke.getDashArray());
        objectOutputStream.writeFloat(basicStroke.getDashPhase());
    }

    /*
     * Unable to fully structure code
     */
    public static Shape readShape(ObjectInputStream var0) {
        if (var0 == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        var1_1 = null;
        var2_9 = var0.readBoolean();
        if (var2_9 != false) return var1_8;
        var3_10 = (Class)var0.readObject();
        v0 = SerialUtilities.class$java$awt$geom$Line2D == null ? (SerialUtilities.class$java$awt$geom$Line2D = SerialUtilities.class$("java.awt.geom.Line2D")) : SerialUtilities.class$java$awt$geom$Line2D;
        if (var3_10.equals(v0)) {
            var4_11 = var0.readDouble();
            var6_16 = var0.readDouble();
            var8_21 = var0.readDouble();
            var10_26 = var0.readDouble();
            var1_2 = new Line2D.Double(var4_11, var6_16, var8_21, var10_26);
            return var1_8;
        }
        v1 = SerialUtilities.class$java$awt$geom$Rectangle2D == null ? (SerialUtilities.class$java$awt$geom$Rectangle2D = SerialUtilities.class$("java.awt.geom.Rectangle2D")) : SerialUtilities.class$java$awt$geom$Rectangle2D;
        if (var3_10.equals(v1)) {
            var4_12 = var0.readDouble();
            var6_17 = var0.readDouble();
            var8_22 = var0.readDouble();
            var10_27 = var0.readDouble();
            var1_3 = new Rectangle2D.Double(var4_12, var6_17, var8_22, var10_27);
            return var1_8;
        }
        v2 = SerialUtilities.class$java$awt$geom$Ellipse2D == null ? (SerialUtilities.class$java$awt$geom$Ellipse2D = SerialUtilities.class$("java.awt.geom.Ellipse2D")) : SerialUtilities.class$java$awt$geom$Ellipse2D;
        if (var3_10.equals(v2)) {
            var4_13 = var0.readDouble();
            var6_18 = var0.readDouble();
            var8_23 = var0.readDouble();
            var10_28 = var0.readDouble();
            var1_4 = new Ellipse2D.Double(var4_13, var6_18, var8_23, var10_28);
            return var1_8;
        }
        v3 = SerialUtilities.class$java$awt$geom$Arc2D == null ? (SerialUtilities.class$java$awt$geom$Arc2D = SerialUtilities.class$("java.awt.geom.Arc2D")) : SerialUtilities.class$java$awt$geom$Arc2D;
        if (var3_10.equals(v3)) {
            var4_14 = var0.readDouble();
            var6_19 = var0.readDouble();
            var8_24 = var0.readDouble();
            var10_29 = var0.readDouble();
            var12_30 = var0.readDouble();
            var14_31 = var0.readDouble();
            var16_32 = var0.readInt();
            var1_5 = new Arc2D.Double(var4_14, var6_19, var8_24, var10_29, var12_30, var14_31, var16_32);
            return var1_8;
        }
        v4 = SerialUtilities.class$java$awt$geom$GeneralPath == null ? (SerialUtilities.class$java$awt$geom$GeneralPath = SerialUtilities.class$("java.awt.geom.GeneralPath")) : SerialUtilities.class$java$awt$geom$GeneralPath;
        if (!var3_10.equals(v4)) {
            var1_7 = (Shape)var0.readObject();
            return var1_8;
        }
        var4_15 = new GeneralPath();
        var5_33 = new float[6];
        var6_20 = var0.readBoolean();
        do {
            if (var6_20) {
                var1_6 = var4_15;
                return var1_8;
            }
            var7_34 = var0.readInt();
            for (var8_25 = 0; var8_25 < 6; ++var8_25) {
                var5_33[var8_25] = var0.readFloat();
            }
            switch (var7_34) {
                case 0: {
                    var4_15.moveTo(var5_33[0], var5_33[1]);
                    ** break;
                }
                case 1: {
                    var4_15.lineTo(var5_33[0], var5_33[1]);
                    ** break;
                }
                case 3: {
                    var4_15.curveTo(var5_33[0], var5_33[1], var5_33[2], var5_33[3], var5_33[4], var5_33[5]);
                    ** break;
                }
                case 2: {
                    var4_15.quadTo(var5_33[0], var5_33[1], var5_33[2], var5_33[3]);
                    ** break;
                }
                case 4: {
                    ** break;
                }
            }
            throw new RuntimeException("JFreeChart - No path exists");
lbl73: // 5 sources:
            var4_15.setWindingRule(var0.readInt());
            var6_20 = var0.readBoolean();
        } while (true);
    }

    public static void writeShape(Shape shape, ObjectOutputStream objectOutputStream) {
        if (objectOutputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        if (shape == null) {
            objectOutputStream.writeBoolean(true);
            return;
        }
        objectOutputStream.writeBoolean(false);
        if (shape instanceof Line2D) {
            Line2D line2D = (Line2D)shape;
            Class class_ = class$java$awt$geom$Line2D == null ? (SerialUtilities.class$java$awt$geom$Line2D = SerialUtilities.class$("java.awt.geom.Line2D")) : class$java$awt$geom$Line2D;
            objectOutputStream.writeObject(class_);
            objectOutputStream.writeDouble(line2D.getX1());
            objectOutputStream.writeDouble(line2D.getY1());
            objectOutputStream.writeDouble(line2D.getX2());
            objectOutputStream.writeDouble(line2D.getY2());
            return;
        }
        if (shape instanceof Rectangle2D) {
            Rectangle2D rectangle2D = (Rectangle2D)shape;
            Class class_ = class$java$awt$geom$Rectangle2D == null ? (SerialUtilities.class$java$awt$geom$Rectangle2D = SerialUtilities.class$("java.awt.geom.Rectangle2D")) : class$java$awt$geom$Rectangle2D;
            objectOutputStream.writeObject(class_);
            objectOutputStream.writeDouble(rectangle2D.getX());
            objectOutputStream.writeDouble(rectangle2D.getY());
            objectOutputStream.writeDouble(rectangle2D.getWidth());
            objectOutputStream.writeDouble(rectangle2D.getHeight());
            return;
        }
        if (shape instanceof Ellipse2D) {
            Ellipse2D ellipse2D = (Ellipse2D)shape;
            Class class_ = class$java$awt$geom$Ellipse2D == null ? (SerialUtilities.class$java$awt$geom$Ellipse2D = SerialUtilities.class$("java.awt.geom.Ellipse2D")) : class$java$awt$geom$Ellipse2D;
            objectOutputStream.writeObject(class_);
            objectOutputStream.writeDouble(ellipse2D.getX());
            objectOutputStream.writeDouble(ellipse2D.getY());
            objectOutputStream.writeDouble(ellipse2D.getWidth());
            objectOutputStream.writeDouble(ellipse2D.getHeight());
            return;
        }
        if (shape instanceof Arc2D) {
            Arc2D arc2D = (Arc2D)shape;
            Class class_ = class$java$awt$geom$Arc2D == null ? (SerialUtilities.class$java$awt$geom$Arc2D = SerialUtilities.class$("java.awt.geom.Arc2D")) : class$java$awt$geom$Arc2D;
            objectOutputStream.writeObject(class_);
            objectOutputStream.writeDouble(arc2D.getX());
            objectOutputStream.writeDouble(arc2D.getY());
            objectOutputStream.writeDouble(arc2D.getWidth());
            objectOutputStream.writeDouble(arc2D.getHeight());
            objectOutputStream.writeDouble(arc2D.getAngleStart());
            objectOutputStream.writeDouble(arc2D.getAngleExtent());
            objectOutputStream.writeInt(arc2D.getArcType());
            return;
        }
        if (!(shape instanceof GeneralPath)) {
            objectOutputStream.writeObject(shape.getClass());
            objectOutputStream.writeObject(shape);
            return;
        }
        Class class_ = class$java$awt$geom$GeneralPath == null ? (SerialUtilities.class$java$awt$geom$GeneralPath = SerialUtilities.class$("java.awt.geom.GeneralPath")) : class$java$awt$geom$GeneralPath;
        objectOutputStream.writeObject(class_);
        PathIterator pathIterator = shape.getPathIterator(null);
        float[] arrf = new float[6];
        objectOutputStream.writeBoolean(pathIterator.isDone());
        while (!pathIterator.isDone()) {
            int n2 = pathIterator.currentSegment(arrf);
            objectOutputStream.writeInt(n2);
            for (int i2 = 0; i2 < 6; ++i2) {
                objectOutputStream.writeFloat(arrf[i2]);
            }
            objectOutputStream.writeInt(pathIterator.getWindingRule());
            pathIterator.next();
            objectOutputStream.writeBoolean(pathIterator.isDone());
        }
    }

    public static Point2D readPoint2D(ObjectInputStream objectInputStream) {
        if (objectInputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        Point2D.Double double_ = null;
        boolean bl2 = objectInputStream.readBoolean();
        if (bl2) return double_;
        double d2 = objectInputStream.readDouble();
        double d3 = objectInputStream.readDouble();
        return new Point2D.Double(d2, d3);
    }

    public static void writePoint2D(Point2D point2D, ObjectOutputStream objectOutputStream) {
        if (objectOutputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        if (point2D != null) {
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeDouble(point2D.getX());
            objectOutputStream.writeDouble(point2D.getY());
            return;
        }
        objectOutputStream.writeBoolean(true);
    }

    public static AttributedString readAttributedString(ObjectInputStream objectInputStream) {
        if (objectInputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        AttributedString attributedString = null;
        boolean bl2 = objectInputStream.readBoolean();
        if (bl2) return attributedString;
        String string = (String)objectInputStream.readObject();
        attributedString = new AttributedString(string);
        char c2 = objectInputStream.readChar();
        int n2 = 0;
        while (c2 != '\uffff') {
            int n3 = objectInputStream.readInt();
            Map map = (Map)objectInputStream.readObject();
            attributedString.addAttributes(map, n2, n3);
            n2 = n3;
            c2 = objectInputStream.readChar();
        }
        return attributedString;
    }

    public static void writeAttributedString(AttributedString attributedString, ObjectOutputStream objectOutputStream) {
        if (objectOutputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        if (attributedString == null) {
            objectOutputStream.writeBoolean(true);
            return;
        }
        objectOutputStream.writeBoolean(false);
        AttributedCharacterIterator attributedCharacterIterator = attributedString.getIterator();
        StringBuffer stringBuffer = new StringBuffer();
        char c2 = attributedCharacterIterator.first();
        while (c2 != '\uffff') {
            stringBuffer = stringBuffer.append(c2);
            c2 = attributedCharacterIterator.next();
        }
        objectOutputStream.writeObject(stringBuffer.toString());
        c2 = attributedCharacterIterator.first();
        int n2 = attributedCharacterIterator.getBeginIndex();
        do {
            if (c2 == '\uffff') {
                objectOutputStream.writeChar(65535);
                return;
            }
            objectOutputStream.writeChar(c2);
            int n3 = attributedCharacterIterator.getRunLimit();
            objectOutputStream.writeInt(n3 - n2);
            HashMap<AttributedCharacterIterator.Attribute, Object> hashMap = new HashMap<AttributedCharacterIterator.Attribute, Object>(attributedCharacterIterator.getAttributes());
            objectOutputStream.writeObject(hashMap);
            c2 = attributedCharacterIterator.setIndex(n3);
        } while (true);
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

