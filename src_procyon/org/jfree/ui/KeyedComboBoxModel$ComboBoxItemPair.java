package org.jfree.ui;

class KeyedComboBoxModel$ComboBoxItemPair
{
    private Object key;
    private Object value;
    
    public KeyedComboBoxModel$ComboBoxItemPair(final Object key, final Object value) {
        this.key = key;
        this.value = value;
    }
    
    public Object getKey() {
        return this.key;
    }
    
    public Object getValue() {
        return this.value;
    }
    
    public void setValue(final Object value) {
        this.value = value;
    }
}
