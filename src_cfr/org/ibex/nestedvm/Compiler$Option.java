/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.PrintStream;
import java.lang.reflect.Field;
import org.ibex.nestedvm.Compiler;

class Compiler$Option {
    private Field field;
    private final Compiler this$0;

    public Compiler$Option(Compiler compiler, String string) {
        Field field;
        this.this$0 = compiler;
        if (string == null) {
            field = null;
        } else {
            Class class_ = Compiler.class$org$ibex$nestedvm$Compiler == null ? (Compiler.class$org$ibex$nestedvm$Compiler = Compiler.class$("org.ibex.nestedvm.Compiler")) : Compiler.class$org$ibex$nestedvm$Compiler;
            field = class_.getDeclaredField(string);
        }
        this.field = field;
    }

    public void set(Object object) {
        if (this.field == null) {
            return;
        }
        try {
            this.field.set(this.this$0, object);
            return;
        }
        catch (IllegalAccessException var2_2) {
            System.err.println(var2_2);
        }
    }

    public Object get() {
        if (this.field == null) {
            return null;
        }
        try {
            return this.field.get(this.this$0);
        }
        catch (IllegalAccessException var1_1) {
            System.err.println(var1_1);
            return null;
        }
    }

    public Class getType() {
        if (this.field == null) {
            return null;
        }
        Class class_ = this.field.getType();
        return class_;
    }
}

