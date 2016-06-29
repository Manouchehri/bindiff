package org.ibex.nestedvm;

import java.lang.reflect.*;

class Compiler$Option
{
    private Field field;
    private final Compiler this$0;
    
    public Compiler$Option(final Compiler this$0, final String s) {
        this.this$0 = this$0;
        this.field = ((s == null) ? null : ((Compiler.class$org$ibex$nestedvm$Compiler == null) ? (Compiler.class$org$ibex$nestedvm$Compiler = Compiler.class$("org.ibex.nestedvm.Compiler")) : Compiler.class$org$ibex$nestedvm$Compiler).getDeclaredField(s));
    }
    
    public void set(final Object o) {
        if (this.field == null) {
            return;
        }
        try {
            this.field.set(this.this$0, o);
        }
        catch (IllegalAccessException ex) {
            System.err.println(ex);
        }
    }
    
    public Object get() {
        if (this.field == null) {
            return null;
        }
        try {
            return this.field.get(this.this$0);
        }
        catch (IllegalAccessException ex) {
            System.err.println(ex);
            return null;
        }
    }
    
    public Class getType() {
        return (this.field == null) ? null : this.field.getType();
    }
}
