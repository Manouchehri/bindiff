package y.h.b;

import y.h.*;
import java.awt.*;
import java.io.*;

public class Z implements Externalizable, Y
{
    private dr a;
    private Color b;
    private Color c;
    private dr d;
    private Color e;
    private Color f;
    
    public Z() {
        this(null, null, null, null, null, null);
    }
    
    public Z(final dr dr, final Color color, final Color color2) {
        this(null, null, null, dr, color, color2);
    }
    
    public Z(final dr a, final Color b, final Color c, final dr d, final Color e, final Color f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public Stroke a(final fj fj) {
        return this.a;
    }
    
    public Color b(final fj fj) {
        return this.b;
    }
    
    public Color c(final fj fj) {
        return this.c;
    }
    
    public Stroke d(final fj fj) {
        return this.d;
    }
    
    public Color e(final fj fj) {
        return this.e;
    }
    
    public Color f(final fj fj) {
        return this.f;
    }
    
    public void readExternal(final ObjectInput objectInput) {
        switch (objectInput.readByte()) {
            case 0: {
                this.a = dr.a(objectInput);
                this.b = (Color)objectInput.readObject();
                this.c = (Color)objectInput.readObject();
                this.d = dr.a(objectInput);
                this.e = (Color)objectInput.readObject();
                this.f = (Color)objectInput.readObject();
                if (y.h.b.a.H != 0) {
                    break;
                }
                return;
            }
        }
        throw new y.e.a();
    }
    
    public void writeExternal(final ObjectOutput objectOutput) {
        objectOutput.writeByte(0);
        dr.a(objectOutput, this.a);
        objectOutput.writeObject(this.b);
        objectOutput.writeObject(this.c);
        dr.a(objectOutput, this.d);
        objectOutput.writeObject(this.e);
        objectOutput.writeObject(this.f);
    }
}
