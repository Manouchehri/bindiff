package org.jfree.ui;

import javax.swing.*;
import java.util.*;
import javax.swing.event.*;

public class KeyedComboBoxModel implements ComboBoxModel
{
    private int selectedItemIndex;
    private Object selectedItemValue;
    private ArrayList data;
    private ArrayList listdatalistener;
    private transient ListDataListener[] tempListeners;
    private boolean allowOtherValue;
    
    public KeyedComboBoxModel() {
        this.data = new ArrayList();
        this.listdatalistener = new ArrayList();
    }
    
    public KeyedComboBoxModel(final Object[] array, final Object[] array2) {
        this();
        this.setData(array, array2);
    }
    
    public void setData(final Object[] array, final Object[] array2) {
        if (array2.length != array.length) {
            throw new IllegalArgumentException("Values and text must have the same length.");
        }
        this.data.clear();
        this.data.ensureCapacity(array.length);
        for (int i = 0; i < array2.length; ++i) {
            this.add(array[i], array2[i]);
        }
        this.selectedItemIndex = -1;
        this.fireListDataEvent(new ListDataEvent(this, 0, 0, this.data.size() - 1));
    }
    
    protected synchronized void fireListDataEvent(final ListDataEvent listDataEvent) {
        if (this.tempListeners == null) {
            this.tempListeners = this.listdatalistener.toArray(new ListDataListener[this.listdatalistener.size()]);
        }
        for (int i = 0; i < this.tempListeners.length; ++i) {
            this.tempListeners[i].contentsChanged(listDataEvent);
        }
    }
    
    public Object getSelectedItem() {
        return this.selectedItemValue;
    }
    
    public void setSelectedKey(final Object o) {
        if (o == null) {
            this.selectedItemIndex = -1;
            this.selectedItemValue = null;
        }
        else {
            final int dataElementIndex = this.findDataElementIndex(o);
            if (dataElementIndex == -1) {
                this.selectedItemIndex = -1;
                this.selectedItemValue = null;
            }
            else {
                this.selectedItemIndex = dataElementIndex;
                this.selectedItemValue = this.getElementAt(this.selectedItemIndex);
            }
        }
        this.fireListDataEvent(new ListDataEvent(this, 0, -1, -1));
    }
    
    public void setSelectedItem(final Object selectedItemValue) {
        if (selectedItemValue == null) {
            this.selectedItemIndex = -1;
            this.selectedItemValue = null;
        }
        else {
            final int elementIndex = this.findElementIndex(selectedItemValue);
            if (elementIndex == -1) {
                if (this.isAllowOtherValue()) {
                    this.selectedItemIndex = -1;
                    this.selectedItemValue = selectedItemValue;
                }
                else {
                    this.selectedItemIndex = -1;
                    this.selectedItemValue = null;
                }
            }
            else {
                this.selectedItemIndex = elementIndex;
                this.selectedItemValue = this.getElementAt(this.selectedItemIndex);
            }
        }
        this.fireListDataEvent(new ListDataEvent(this, 0, -1, -1));
    }
    
    private boolean isAllowOtherValue() {
        return this.allowOtherValue;
    }
    
    public void setAllowOtherValue(final boolean allowOtherValue) {
        this.allowOtherValue = allowOtherValue;
    }
    
    public synchronized void addListDataListener(final ListDataListener listDataListener) {
        this.listdatalistener.add(listDataListener);
        this.tempListeners = null;
    }
    
    public Object getElementAt(final int n) {
        if (n >= this.data.size()) {
            return null;
        }
        final KeyedComboBoxModel$ComboBoxItemPair keyedComboBoxModel$ComboBoxItemPair = this.data.get(n);
        if (keyedComboBoxModel$ComboBoxItemPair == null) {
            return null;
        }
        return keyedComboBoxModel$ComboBoxItemPair.getValue();
    }
    
    public Object getKeyAt(final int n) {
        if (n >= this.data.size()) {
            return null;
        }
        if (n < 0) {
            return null;
        }
        final KeyedComboBoxModel$ComboBoxItemPair keyedComboBoxModel$ComboBoxItemPair = this.data.get(n);
        if (keyedComboBoxModel$ComboBoxItemPair == null) {
            return null;
        }
        return keyedComboBoxModel$ComboBoxItemPair.getKey();
    }
    
    public Object getSelectedKey() {
        return this.getKeyAt(this.selectedItemIndex);
    }
    
    public int getSize() {
        return this.data.size();
    }
    
    public void removeListDataListener(final ListDataListener listDataListener) {
        this.listdatalistener.remove(listDataListener);
        this.tempListeners = null;
    }
    
    private int findDataElementIndex(final Object o) {
        if (o == null) {
            throw new NullPointerException("Item to find must not be null");
        }
        for (int i = 0; i < this.data.size(); ++i) {
            if (o.equals(((KeyedComboBoxModel$ComboBoxItemPair)this.data.get(i)).getKey())) {
                return i;
            }
        }
        return -1;
    }
    
    public int findElementIndex(final Object o) {
        if (o == null) {
            throw new NullPointerException("Item to find must not be null");
        }
        for (int i = 0; i < this.data.size(); ++i) {
            if (o.equals(((KeyedComboBoxModel$ComboBoxItemPair)this.data.get(i)).getValue())) {
                return i;
            }
        }
        return -1;
    }
    
    public void removeDataElement(final Object o) {
        final int dataElementIndex = this.findDataElementIndex(o);
        if (dataElementIndex == -1) {
            return;
        }
        this.data.remove(dataElementIndex);
        this.fireListDataEvent(new ListDataEvent(this, 2, dataElementIndex, dataElementIndex));
    }
    
    public void add(final Object o, final Object o2) {
        this.data.add(new KeyedComboBoxModel$ComboBoxItemPair(o, o2));
        this.fireListDataEvent(new ListDataEvent(this, 1, this.data.size() - 2, this.data.size() - 2));
    }
    
    public void clear() {
        final int size = this.getSize();
        this.data.clear();
        this.fireListDataEvent(new ListDataEvent(this, 2, 0, size - 1));
    }
}
