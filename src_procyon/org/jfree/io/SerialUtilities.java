package org.jfree.io;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.text.*;
import java.util.*;

public class SerialUtilities
{
    static Class class$java$io$Serializable;
    static Class class$java$awt$GradientPaint;
    static Class class$java$awt$BasicStroke;
    static Class class$java$awt$geom$Line2D;
    static Class class$java$awt$geom$Rectangle2D;
    static Class class$java$awt$geom$Ellipse2D;
    static Class class$java$awt$geom$Arc2D;
    static Class class$java$awt$geom$GeneralPath;
    
    public static boolean isSerializable(final Class clazz) {
        return ((SerialUtilities.class$java$io$Serializable == null) ? (SerialUtilities.class$java$io$Serializable = class$("java.io.Serializable")) : SerialUtilities.class$java$io$Serializable).isAssignableFrom(clazz);
    }
    
    public static Paint readPaint(final ObjectInputStream objectInputStream) {
        if (objectInputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        Paint paint = null;
        if (!objectInputStream.readBoolean()) {
            final Class clazz = (Class)objectInputStream.readObject();
            if (isSerializable(clazz)) {
                paint = (Paint)objectInputStream.readObject();
            }
            else if (clazz.equals((SerialUtilities.class$java$awt$GradientPaint == null) ? (SerialUtilities.class$java$awt$GradientPaint = class$("java.awt.GradientPaint")) : SerialUtilities.class$java$awt$GradientPaint)) {
                paint = new GradientPaint(objectInputStream.readFloat(), objectInputStream.readFloat(), (Color)objectInputStream.readObject(), objectInputStream.readFloat(), objectInputStream.readFloat(), (Color)objectInputStream.readObject(), objectInputStream.readBoolean());
            }
        }
        return paint;
    }
    
    public static void writePaint(final Paint paint, final ObjectOutputStream objectOutputStream) {
        if (objectOutputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        if (paint != null) {
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeObject(paint.getClass());
            if (paint instanceof Serializable) {
                objectOutputStream.writeObject(paint);
            }
            else if (paint instanceof GradientPaint) {
                final GradientPaint gradientPaint = (GradientPaint)paint;
                objectOutputStream.writeFloat((float)gradientPaint.getPoint1().getX());
                objectOutputStream.writeFloat((float)gradientPaint.getPoint1().getY());
                objectOutputStream.writeObject(gradientPaint.getColor1());
                objectOutputStream.writeFloat((float)gradientPaint.getPoint2().getX());
                objectOutputStream.writeFloat((float)gradientPaint.getPoint2().getY());
                objectOutputStream.writeObject(gradientPaint.getColor2());
                objectOutputStream.writeBoolean(gradientPaint.isCyclic());
            }
        }
        else {
            objectOutputStream.writeBoolean(true);
        }
    }
    
    public static Stroke readStroke(final ObjectInputStream objectInputStream) {
        if (objectInputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        Stroke stroke = null;
        if (!objectInputStream.readBoolean()) {
            if (((Class)objectInputStream.readObject()).equals((SerialUtilities.class$java$awt$BasicStroke == null) ? (SerialUtilities.class$java$awt$BasicStroke = class$("java.awt.BasicStroke")) : SerialUtilities.class$java$awt$BasicStroke)) {
                stroke = new BasicStroke(objectInputStream.readFloat(), objectInputStream.readInt(), objectInputStream.readInt(), objectInputStream.readFloat(), (float[])objectInputStream.readObject(), objectInputStream.readFloat());
            }
            else {
                stroke = (Stroke)objectInputStream.readObject();
            }
        }
        return stroke;
    }
    
    public static void writeStroke(final Stroke stroke, final ObjectOutputStream objectOutputStream) {
        if (objectOutputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        if (stroke != null) {
            objectOutputStream.writeBoolean(false);
            if (stroke instanceof BasicStroke) {
                final BasicStroke basicStroke = (BasicStroke)stroke;
                objectOutputStream.writeObject((SerialUtilities.class$java$awt$BasicStroke == null) ? (SerialUtilities.class$java$awt$BasicStroke = class$("java.awt.BasicStroke")) : SerialUtilities.class$java$awt$BasicStroke);
                objectOutputStream.writeFloat(basicStroke.getLineWidth());
                objectOutputStream.writeInt(basicStroke.getEndCap());
                objectOutputStream.writeInt(basicStroke.getLineJoin());
                objectOutputStream.writeFloat(basicStroke.getMiterLimit());
                objectOutputStream.writeObject(basicStroke.getDashArray());
                objectOutputStream.writeFloat(basicStroke.getDashPhase());
            }
            else {
                objectOutputStream.writeObject(stroke.getClass());
                objectOutputStream.writeObject(stroke);
            }
        }
        else {
            objectOutputStream.writeBoolean(true);
        }
    }
    
    public static Shape readShape(final ObjectInputStream objectInputStream) {
        if (objectInputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        Shape shape = null;
        if (!objectInputStream.readBoolean()) {
            final Class clazz = (Class)objectInputStream.readObject();
            if (clazz.equals((SerialUtilities.class$java$awt$geom$Line2D == null) ? (SerialUtilities.class$java$awt$geom$Line2D = class$("java.awt.geom.Line2D")) : SerialUtilities.class$java$awt$geom$Line2D)) {
                shape = new Line2D.Double(objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble());
            }
            else if (clazz.equals((SerialUtilities.class$java$awt$geom$Rectangle2D == null) ? (SerialUtilities.class$java$awt$geom$Rectangle2D = class$("java.awt.geom.Rectangle2D")) : SerialUtilities.class$java$awt$geom$Rectangle2D)) {
                shape = new Rectangle2D.Double(objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble());
            }
            else if (clazz.equals((SerialUtilities.class$java$awt$geom$Ellipse2D == null) ? (SerialUtilities.class$java$awt$geom$Ellipse2D = class$("java.awt.geom.Ellipse2D")) : SerialUtilities.class$java$awt$geom$Ellipse2D)) {
                shape = new Ellipse2D.Double(objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble());
            }
            else if (clazz.equals((SerialUtilities.class$java$awt$geom$Arc2D == null) ? (SerialUtilities.class$java$awt$geom$Arc2D = class$("java.awt.geom.Arc2D")) : SerialUtilities.class$java$awt$geom$Arc2D)) {
                shape = new Arc2D.Double(objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readInt());
            }
            else if (clazz.equals((SerialUtilities.class$java$awt$geom$GeneralPath == null) ? (SerialUtilities.class$java$awt$geom$GeneralPath = class$("java.awt.geom.GeneralPath")) : SerialUtilities.class$java$awt$geom$GeneralPath)) {
                final GeneralPath generalPath = new GeneralPath();
                final float[] array = new float[6];
                for (boolean b = objectInputStream.readBoolean(); !b; b = objectInputStream.readBoolean()) {
                    final int int1 = objectInputStream.readInt();
                    for (int i = 0; i < 6; ++i) {
                        array[i] = objectInputStream.readFloat();
                    }
                    switch (int1) {
                        case 0: {
                            generalPath.moveTo(array[0], array[1]);
                            break;
                        }
                        case 1: {
                            generalPath.lineTo(array[0], array[1]);
                            break;
                        }
                        case 3: {
                            generalPath.curveTo(array[0], array[1], array[2], array[3], array[4], array[5]);
                            break;
                        }
                        case 2: {
                            generalPath.quadTo(array[0], array[1], array[2], array[3]);
                            break;
                        }
                        case 4: {
                            break;
                        }
                        default: {
                            throw new RuntimeException("JFreeChart - No path exists");
                        }
                    }
                    generalPath.setWindingRule(objectInputStream.readInt());
                }
                shape = generalPath;
            }
            else {
                shape = (Shape)objectInputStream.readObject();
            }
        }
        return shape;
    }
    
    public static void writeShape(final Shape shape, final ObjectOutputStream objectOutputStream) {
        if (objectOutputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        if (shape != null) {
            objectOutputStream.writeBoolean(false);
            if (shape instanceof Line2D) {
                final Line2D line2D = (Line2D)shape;
                objectOutputStream.writeObject((SerialUtilities.class$java$awt$geom$Line2D == null) ? (SerialUtilities.class$java$awt$geom$Line2D = class$("java.awt.geom.Line2D")) : SerialUtilities.class$java$awt$geom$Line2D);
                objectOutputStream.writeDouble(line2D.getX1());
                objectOutputStream.writeDouble(line2D.getY1());
                objectOutputStream.writeDouble(line2D.getX2());
                objectOutputStream.writeDouble(line2D.getY2());
            }
            else if (shape instanceof Rectangle2D) {
                final Rectangle2D rectangle2D = (Rectangle2D)shape;
                objectOutputStream.writeObject((SerialUtilities.class$java$awt$geom$Rectangle2D == null) ? (SerialUtilities.class$java$awt$geom$Rectangle2D = class$("java.awt.geom.Rectangle2D")) : SerialUtilities.class$java$awt$geom$Rectangle2D);
                objectOutputStream.writeDouble(rectangle2D.getX());
                objectOutputStream.writeDouble(rectangle2D.getY());
                objectOutputStream.writeDouble(rectangle2D.getWidth());
                objectOutputStream.writeDouble(rectangle2D.getHeight());
            }
            else if (shape instanceof Ellipse2D) {
                final Ellipse2D ellipse2D = (Ellipse2D)shape;
                objectOutputStream.writeObject((SerialUtilities.class$java$awt$geom$Ellipse2D == null) ? (SerialUtilities.class$java$awt$geom$Ellipse2D = class$("java.awt.geom.Ellipse2D")) : SerialUtilities.class$java$awt$geom$Ellipse2D);
                objectOutputStream.writeDouble(ellipse2D.getX());
                objectOutputStream.writeDouble(ellipse2D.getY());
                objectOutputStream.writeDouble(ellipse2D.getWidth());
                objectOutputStream.writeDouble(ellipse2D.getHeight());
            }
            else if (shape instanceof Arc2D) {
                final Arc2D arc2D = (Arc2D)shape;
                objectOutputStream.writeObject((SerialUtilities.class$java$awt$geom$Arc2D == null) ? (SerialUtilities.class$java$awt$geom$Arc2D = class$("java.awt.geom.Arc2D")) : SerialUtilities.class$java$awt$geom$Arc2D);
                objectOutputStream.writeDouble(arc2D.getX());
                objectOutputStream.writeDouble(arc2D.getY());
                objectOutputStream.writeDouble(arc2D.getWidth());
                objectOutputStream.writeDouble(arc2D.getHeight());
                objectOutputStream.writeDouble(arc2D.getAngleStart());
                objectOutputStream.writeDouble(arc2D.getAngleExtent());
                objectOutputStream.writeInt(arc2D.getArcType());
            }
            else if (shape instanceof GeneralPath) {
                objectOutputStream.writeObject((SerialUtilities.class$java$awt$geom$GeneralPath == null) ? (SerialUtilities.class$java$awt$geom$GeneralPath = class$("java.awt.geom.GeneralPath")) : SerialUtilities.class$java$awt$geom$GeneralPath);
                final PathIterator pathIterator = shape.getPathIterator(null);
                final float[] array = new float[6];
                objectOutputStream.writeBoolean(pathIterator.isDone());
                while (!pathIterator.isDone()) {
                    objectOutputStream.writeInt(pathIterator.currentSegment(array));
                    for (int i = 0; i < 6; ++i) {
                        objectOutputStream.writeFloat(array[i]);
                    }
                    objectOutputStream.writeInt(pathIterator.getWindingRule());
                    pathIterator.next();
                    objectOutputStream.writeBoolean(pathIterator.isDone());
                }
            }
            else {
                objectOutputStream.writeObject(shape.getClass());
                objectOutputStream.writeObject(shape);
            }
        }
        else {
            objectOutputStream.writeBoolean(true);
        }
    }
    
    public static Point2D readPoint2D(final ObjectInputStream objectInputStream) {
        if (objectInputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        Point2D point2D = null;
        if (!objectInputStream.readBoolean()) {
            point2D = new Point2D.Double(objectInputStream.readDouble(), objectInputStream.readDouble());
        }
        return point2D;
    }
    
    public static void writePoint2D(final Point2D point2D, final ObjectOutputStream objectOutputStream) {
        if (objectOutputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        if (point2D != null) {
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeDouble(point2D.getX());
            objectOutputStream.writeDouble(point2D.getY());
        }
        else {
            objectOutputStream.writeBoolean(true);
        }
    }
    
    public static AttributedString readAttributedString(final ObjectInputStream objectInputStream) {
        if (objectInputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        AttributedString attributedString = null;
        if (!objectInputStream.readBoolean()) {
            attributedString = new AttributedString((String)objectInputStream.readObject());
            char c = objectInputStream.readChar();
            int n = 0;
            while (c != '\uffff') {
                final int int1 = objectInputStream.readInt();
                attributedString.addAttributes((Map<? extends AttributedCharacterIterator.Attribute, ?>)objectInputStream.readObject(), n, int1);
                n = int1;
                c = objectInputStream.readChar();
            }
        }
        return attributedString;
    }
    
    public static void writeAttributedString(final AttributedString attributedString, final ObjectOutputStream objectOutputStream) {
        if (objectOutputStream == null) {
            throw new IllegalArgumentException("Null 'stream' argument.");
        }
        if (attributedString != null) {
            objectOutputStream.writeBoolean(false);
            final AttributedCharacterIterator iterator = attributedString.getIterator();
            StringBuffer append = new StringBuffer();
            for (char c = iterator.first(); c != '\uffff'; c = iterator.next()) {
                append = append.append(c);
            }
            objectOutputStream.writeObject(append.toString());
            char c2 = iterator.first();
            final int beginIndex = iterator.getBeginIndex();
            while (c2 != '\uffff') {
                objectOutputStream.writeChar(c2);
                final int runLimit = iterator.getRunLimit();
                objectOutputStream.writeInt(runLimit - beginIndex);
                objectOutputStream.writeObject(new HashMap(iterator.getAttributes()));
                c2 = iterator.setIndex(runLimit);
            }
            objectOutputStream.writeChar(65535);
        }
        else {
            objectOutputStream.writeBoolean(true);
        }
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
