package y.g;

import java.util.*;
import java.awt.geom.*;
import java.beans.*;
import java.io.*;

final class Y extends a
{
    Y() {
        super((X.o == null) ? (X.o = X.a("java.awt.geom.Point2D")) : X.o);
    }
    
    protected Object a(final String s) {
        final StringTokenizer stringTokenizer = new StringTokenizer(s, "(,)", false);
        try {
            final Point2D point2D = (Point2D)Beans.instantiate(this.getClass().getClassLoader(), stringTokenizer.nextToken());
            point2D.setLocation(Double.parseDouble(stringTokenizer.nextToken()), Double.parseDouble(stringTokenizer.nextToken()));
            return point2D;
        }
        catch (NumberFormatException ex3) {
            throw new IllegalArgumentException("Could not parse number " + s);
        }
        catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("Unknown class " + ex);
        }
        catch (IOException ex2) {
            throw new IllegalArgumentException("Could not load class " + ex2);
        }
    }
    
    protected String a(final Object o) {
        final Point2D point2D = (Point2D)o;
        final StringBuffer sb = new StringBuffer(50);
        sb.append(point2D.getClass().getName());
        sb.append('(');
        sb.append(point2D.getX());
        sb.append(',');
        sb.append(point2D.getY());
        sb.append(')');
        return sb.toString();
    }
}
