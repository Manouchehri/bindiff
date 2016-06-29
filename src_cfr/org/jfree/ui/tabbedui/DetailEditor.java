/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import javax.swing.JComponent;

public abstract class DetailEditor
extends JComponent {
    private Object object;
    private boolean confirmed;

    public void update() {
        if (this.object == null) {
            throw new IllegalStateException();
        }
        this.updateObject(this.object);
        this.setConfirmed(false);
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.object = object;
        this.setConfirmed(false);
        this.fillObject();
    }

    protected static int parseInt(String string, int n2) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException var2_2) {
            return n2;
        }
    }

    public abstract void clear();

    protected abstract void fillObject();

    protected abstract void updateObject(Object var1);

    public boolean isConfirmed() {
        return this.confirmed;
    }

    protected void setConfirmed(boolean bl2) {
        boolean bl3 = this.confirmed;
        this.confirmed = bl2;
        this.firePropertyChange("confirmed", bl3, bl2);
    }
}

