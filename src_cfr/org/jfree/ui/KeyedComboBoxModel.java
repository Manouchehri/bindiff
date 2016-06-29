/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import org.jfree.ui.KeyedComboBoxModel$ComboBoxItemPair;

public class KeyedComboBoxModel
implements ComboBoxModel {
    private int selectedItemIndex;
    private Object selectedItemValue;
    private ArrayList data = new ArrayList();
    private ArrayList listdatalistener = new ArrayList();
    private transient ListDataListener[] tempListeners;
    private boolean allowOtherValue;

    public KeyedComboBoxModel() {
    }

    public KeyedComboBoxModel(Object[] arrobject, Object[] arrobject2) {
        this();
        this.setData(arrobject, arrobject2);
    }

    public void setData(Object[] arrobject, Object[] arrobject2) {
        if (arrobject2.length != arrobject.length) {
            throw new IllegalArgumentException("Values and text must have the same length.");
        }
        this.data.clear();
        this.data.ensureCapacity(arrobject.length);
        int n2 = 0;
        do {
            if (n2 >= arrobject2.length) {
                this.selectedItemIndex = -1;
                ListDataEvent listDataEvent = new ListDataEvent(this, 0, 0, this.data.size() - 1);
                this.fireListDataEvent(listDataEvent);
                return;
            }
            this.add(arrobject[n2], arrobject2[n2]);
            ++n2;
        } while (true);
    }

    protected synchronized void fireListDataEvent(ListDataEvent listDataEvent) {
        if (this.tempListeners == null) {
            this.tempListeners = this.listdatalistener.toArray(new ListDataListener[this.listdatalistener.size()]);
        }
        int n2 = 0;
        while (n2 < this.tempListeners.length) {
            ListDataListener listDataListener = this.tempListeners[n2];
            listDataListener.contentsChanged(listDataEvent);
            ++n2;
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItemValue;
    }

    public void setSelectedKey(Object object) {
        if (object == null) {
            this.selectedItemIndex = -1;
            this.selectedItemValue = null;
        } else {
            int n2 = this.findDataElementIndex(object);
            if (n2 == -1) {
                this.selectedItemIndex = -1;
                this.selectedItemValue = null;
            } else {
                this.selectedItemIndex = n2;
                this.selectedItemValue = this.getElementAt(this.selectedItemIndex);
            }
        }
        this.fireListDataEvent(new ListDataEvent(this, 0, -1, -1));
    }

    @Override
    public void setSelectedItem(Object object) {
        if (object == null) {
            this.selectedItemIndex = -1;
            this.selectedItemValue = null;
        } else {
            int n2 = this.findElementIndex(object);
            if (n2 == -1) {
                if (this.isAllowOtherValue()) {
                    this.selectedItemIndex = -1;
                    this.selectedItemValue = object;
                } else {
                    this.selectedItemIndex = -1;
                    this.selectedItemValue = null;
                }
            } else {
                this.selectedItemIndex = n2;
                this.selectedItemValue = this.getElementAt(this.selectedItemIndex);
            }
        }
        this.fireListDataEvent(new ListDataEvent(this, 0, -1, -1));
    }

    private boolean isAllowOtherValue() {
        return this.allowOtherValue;
    }

    public void setAllowOtherValue(boolean bl2) {
        this.allowOtherValue = bl2;
    }

    @Override
    public synchronized void addListDataListener(ListDataListener listDataListener) {
        this.listdatalistener.add(listDataListener);
        this.tempListeners = null;
    }

    @Override
    public Object getElementAt(int n2) {
        if (n2 >= this.data.size()) {
            return null;
        }
        KeyedComboBoxModel$ComboBoxItemPair keyedComboBoxModel$ComboBoxItemPair = (KeyedComboBoxModel$ComboBoxItemPair)this.data.get(n2);
        if (keyedComboBoxModel$ComboBoxItemPair != null) return keyedComboBoxModel$ComboBoxItemPair.getValue();
        return null;
    }

    public Object getKeyAt(int n2) {
        if (n2 >= this.data.size()) {
            return null;
        }
        if (n2 < 0) {
            return null;
        }
        KeyedComboBoxModel$ComboBoxItemPair keyedComboBoxModel$ComboBoxItemPair = (KeyedComboBoxModel$ComboBoxItemPair)this.data.get(n2);
        if (keyedComboBoxModel$ComboBoxItemPair != null) return keyedComboBoxModel$ComboBoxItemPair.getKey();
        return null;
    }

    public Object getSelectedKey() {
        return this.getKeyAt(this.selectedItemIndex);
    }

    @Override
    public int getSize() {
        return this.data.size();
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
        this.listdatalistener.remove(listDataListener);
        this.tempListeners = null;
    }

    private int findDataElementIndex(Object object) {
        if (object == null) {
            throw new NullPointerException("Item to find must not be null");
        }
        int n2 = 0;
        while (n2 < this.data.size()) {
            KeyedComboBoxModel$ComboBoxItemPair keyedComboBoxModel$ComboBoxItemPair = (KeyedComboBoxModel$ComboBoxItemPair)this.data.get(n2);
            if (object.equals(keyedComboBoxModel$ComboBoxItemPair.getKey())) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public int findElementIndex(Object object) {
        if (object == null) {
            throw new NullPointerException("Item to find must not be null");
        }
        int n2 = 0;
        while (n2 < this.data.size()) {
            KeyedComboBoxModel$ComboBoxItemPair keyedComboBoxModel$ComboBoxItemPair = (KeyedComboBoxModel$ComboBoxItemPair)this.data.get(n2);
            if (object.equals(keyedComboBoxModel$ComboBoxItemPair.getValue())) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public void removeDataElement(Object object) {
        int n2 = this.findDataElementIndex(object);
        if (n2 == -1) {
            return;
        }
        this.data.remove(n2);
        ListDataEvent listDataEvent = new ListDataEvent(this, 2, n2, n2);
        this.fireListDataEvent(listDataEvent);
    }

    public void add(Object object, Object object2) {
        KeyedComboBoxModel$ComboBoxItemPair keyedComboBoxModel$ComboBoxItemPair = new KeyedComboBoxModel$ComboBoxItemPair(object, object2);
        this.data.add(keyedComboBoxModel$ComboBoxItemPair);
        ListDataEvent listDataEvent = new ListDataEvent(this, 1, this.data.size() - 2, this.data.size() - 2);
        this.fireListDataEvent(listDataEvent);
    }

    public void clear() {
        int n2 = this.getSize();
        this.data.clear();
        ListDataEvent listDataEvent = new ListDataEvent(this, 2, 0, n2 - 1);
        this.fireListDataEvent(listDataEvent);
    }
}

