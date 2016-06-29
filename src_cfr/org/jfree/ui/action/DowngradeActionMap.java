/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.action;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Action;

public class DowngradeActionMap {
    private final HashMap actionMap = new HashMap();
    private final ArrayList actionList = new ArrayList();
    private DowngradeActionMap parent;

    public void setParent(DowngradeActionMap downgradeActionMap) {
        this.parent = downgradeActionMap;
    }

    public DowngradeActionMap getParent() {
        return this.parent;
    }

    public void put(Object object, Action action) {
        if (action == null) {
            this.remove(object);
            return;
        }
        if (this.actionMap.containsKey(object)) {
            this.remove(object);
        }
        this.actionMap.put(object, action);
        this.actionList.add(object);
    }

    public Action get(Object object) {
        Action action = (Action)this.actionMap.get(object);
        if (action != null) {
            return action;
        }
        if (this.parent == null) return null;
        return this.parent.get(object);
    }

    public void remove(Object object) {
        this.actionMap.remove(object);
        this.actionList.remove(object);
    }

    public void clear() {
        this.actionMap.clear();
        this.actionList.clear();
    }

    public Object[] keys() {
        return this.actionList.toArray();
    }

    public int size() {
        return this.actionMap.size();
    }

    public Object[] allKeys() {
        if (this.parent == null) {
            return this.keys();
        }
        Object[] arrobject = this.parent.allKeys();
        Object[] arrobject2 = this.keys();
        Object[] arrobject3 = new Object[arrobject.length + arrobject2.length];
        System.arraycopy(arrobject2, 0, arrobject3, 0, arrobject2.length);
        System.arraycopy(arrobject3, 0, arrobject3, arrobject2.length, arrobject3.length);
        return arrobject3;
    }
}

