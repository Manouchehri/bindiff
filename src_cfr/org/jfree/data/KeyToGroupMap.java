/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class KeyToGroupMap
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -2228169345475318082L;
    private Comparable defaultGroup;
    private List groups;
    private Map keyToGroupMap;

    public KeyToGroupMap() {
        this((Comparable)((Object)"Default Group"));
    }

    public KeyToGroupMap(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'defaultGroup' argument.");
        }
        this.defaultGroup = comparable;
        this.groups = new ArrayList();
        this.keyToGroupMap = new HashMap();
    }

    public int getGroupCount() {
        return this.groups.size() + 1;
    }

    public List getGroups() {
        ArrayList<Comparable> arrayList = new ArrayList<Comparable>();
        arrayList.add(this.defaultGroup);
        Iterator iterator = this.groups.iterator();
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)iterator.next();
            if (arrayList.contains(comparable)) continue;
            arrayList.add(comparable);
        }
        return arrayList;
    }

    public int getGroupIndex(Comparable comparable) {
        int n2 = this.groups.indexOf(comparable);
        if (n2 < 0) {
            if (!this.defaultGroup.equals(comparable)) return n2;
            return 0;
        }
        ++n2;
        return n2;
    }

    public Comparable getGroup(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        Comparable comparable2 = this.defaultGroup;
        Comparable comparable3 = (Comparable)this.keyToGroupMap.get(comparable);
        if (comparable3 == null) return comparable2;
        return comparable3;
    }

    public void mapKeyToGroup(Comparable comparable, Comparable comparable2) {
        int n2;
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        Comparable comparable3 = this.getGroup(comparable);
        if (!comparable3.equals(this.defaultGroup) && !comparable3.equals(comparable2) && (n2 = this.getKeyCount(comparable3)) == 1) {
            this.groups.remove(comparable3);
        }
        if (comparable2 == null) {
            this.keyToGroupMap.remove(comparable);
            return;
        }
        if (!this.groups.contains(comparable2) && !this.defaultGroup.equals(comparable2)) {
            this.groups.add(comparable2);
        }
        this.keyToGroupMap.put(comparable, comparable2);
    }

    public int getKeyCount(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'group' argument.");
        }
        int n2 = 0;
        Iterator iterator = this.keyToGroupMap.values().iterator();
        while (iterator.hasNext()) {
            Comparable comparable2 = (Comparable)iterator.next();
            if (!comparable.equals(comparable2)) continue;
            ++n2;
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof KeyToGroupMap)) {
            return false;
        }
        KeyToGroupMap keyToGroupMap = (KeyToGroupMap)object;
        if (!ObjectUtilities.equal(this.defaultGroup, keyToGroupMap.defaultGroup)) {
            return false;
        }
        if (this.keyToGroupMap.equals(keyToGroupMap.keyToGroupMap)) return true;
        return false;
    }

    @Override
    public Object clone() {
        KeyToGroupMap keyToGroupMap = (KeyToGroupMap)super.clone();
        keyToGroupMap.defaultGroup = (Comparable)KeyToGroupMap.clone(this.defaultGroup);
        keyToGroupMap.groups = (List)KeyToGroupMap.clone(this.groups);
        keyToGroupMap.keyToGroupMap = (Map)KeyToGroupMap.clone(this.keyToGroupMap);
        return keyToGroupMap;
    }

    private static Object clone(Object object) {
        if (object == null) {
            return null;
        }
        Class class_ = object.getClass();
        Object object2 = null;
        try {
            Method method = class_.getMethod("clone", null);
            if (!Modifier.isPublic(method.getModifiers())) return object2;
            try {
                return method.invoke(object, null);
            }
            catch (Exception var4_5) {
                var4_5.printStackTrace();
                return object2;
            }
        }
        catch (NoSuchMethodException var3_4) {
            return object;
        }
    }

    private static Collection clone(Collection collection) {
        List list = null;
        if (collection == null) return list;
        try {
            List list2 = (List)collection.getClass().newInstance();
            Iterator iterator = collection.iterator();
            do {
                if (!iterator.hasNext()) {
                    return list2;
                }
                list2.add(KeyToGroupMap.clone(iterator.next()));
            } while (true);
        }
        catch (Exception var2_3) {
            throw new CloneNotSupportedException("Exception.");
        }
    }
}

