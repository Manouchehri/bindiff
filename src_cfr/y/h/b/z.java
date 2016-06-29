/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.Color;
import java.awt.Stroke;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import y.h.b.Y;
import y.h.b.a;
import y.h.dr;
import y.h.fj;

public class Z
implements Externalizable,
Y {
    private dr a;
    private Color b;
    private Color c;
    private dr d;
    private Color e;
    private Color f;

    public Z() {
        this(null, null, null, null, null, null);
    }

    public Z(dr dr2, Color color, Color color2) {
        this(null, null, null, dr2, color, color2);
    }

    public Z(dr dr2, Color color, Color color2, dr dr3, Color color3, Color color4) {
        this.a = dr2;
        this.b = color;
        this.c = color2;
        this.d = dr3;
        this.e = color3;
        this.f = color4;
    }

    @Override
    public Stroke a(fj fj2) {
        return this.a;
    }

    @Override
    public Color b(fj fj2) {
        return this.b;
    }

    @Override
    public Color c(fj fj2) {
        return this.c;
    }

    @Override
    public Stroke d(fj fj2) {
        return this.d;
    }

    @Override
    public Color e(fj fj2) {
        return this.e;
    }

    @Override
    public Color f(fj fj2) {
        return this.f;
    }

    @Override
    public void readExternal(ObjectInput objectInput) {
        switch (objectInput.readByte()) {
            case 0: {
                this.a = dr.a(objectInput);
                this.b = (Color)objectInput.readObject();
                this.c = (Color)objectInput.readObject();
                this.d = dr.a(objectInput);
                this.e = (Color)objectInput.readObject();
                this.f = (Color)objectInput.readObject();
                if (a.H == 0) return;
            }
        }
        throw new y.e.a();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeByte(0);
        dr.a(objectOutput, this.a);
        objectOutput.writeObject(this.b);
        objectOutput.writeObject(this.c);
        dr.a(objectOutput, this.d);
        objectOutput.writeObject(this.e);
        objectOutput.writeObject(this.f);
    }
}

