package y.g;

import y.c.*;

final class S implements A
{
    double[] a;
    int[] b;
    boolean[] c;
    Object[] d;
    
    S(final double[] a, final int[] b, final boolean[] c, final Object[] d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public Object b(final Object o) {
        try {
            return this.d[((q)o).d()];
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Argument must be of type Node.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (o instanceof q && ((q)o).e() == null) {
                throw new IllegalArgumentException("Argument is not in graph");
            }
            throw new UnsupportedOperationException("Cannot get Object from this type of Map!");
        }
    }
    
    public double c(final Object o) {
        try {
            return this.a[((q)o).d()];
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Argument must be of type Node.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (o instanceof q && ((q)o).e() == null) {
                throw new IllegalArgumentException("Argument is not in graph");
            }
            throw new UnsupportedOperationException("Cannot get double from this type of Map!");
        }
    }
    
    public int a(final Object o) {
        try {
            return this.b[((q)o).d()];
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Argument must be of type Node.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (o instanceof q && ((q)o).e() == null) {
                throw new IllegalArgumentException("Argument is not in graph");
            }
            throw new UnsupportedOperationException("Cannot get int from this type of Map!");
        }
    }
    
    public boolean d(final Object o) {
        try {
            return this.c[((q)o).d()];
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Argument must be of type Node.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (o instanceof q && ((q)o).e() == null) {
                throw new IllegalArgumentException("Argument is not in graph");
            }
            throw new UnsupportedOperationException("Cannot get boolean from this type of Map!");
        }
    }
    
    public void a(final Object o, final Object o2) {
        try {
            this.d[((q)o).d()] = o2;
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Key must be of type Node.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (o instanceof q && ((q)o).e() == null) {
                throw new IllegalArgumentException("Key is not in graph");
            }
            throw new UnsupportedOperationException("Cannot set Object in this type of Map!");
        }
    }
    
    public void a(final Object o, final double n) {
        try {
            this.a[((q)o).d()] = n;
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Key must be of type Node.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (o instanceof q && ((q)o).e() == null) {
                throw new IllegalArgumentException("Key is not in graph");
            }
            throw new UnsupportedOperationException("Cannot set double in this type of Map!");
        }
    }
    
    public void a(final Object o, final int n) {
        try {
            this.b[((q)o).d()] = n;
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Key must be of type Node.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (o instanceof q && ((q)o).e() == null) {
                throw new IllegalArgumentException("Key is not in graph");
            }
            throw new UnsupportedOperationException("Cannot set int in this type of Map!");
        }
    }
    
    public void a(final Object o, final boolean b) {
        try {
            this.c[((q)o).d()] = b;
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Key must be of type Node.");
        }
        catch (NullPointerException ex2) {
            if (o == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (o instanceof q && ((q)o).e() == null) {
                throw new IllegalArgumentException("Key is not in graph");
            }
            throw new UnsupportedOperationException("Cannot set boolean in this type of Map!");
        }
    }
}
