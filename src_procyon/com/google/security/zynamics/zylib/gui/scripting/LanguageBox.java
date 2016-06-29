package com.google.security.zynamics.zylib.gui.scripting;

import javax.swing.*;
import javax.script.*;
import java.util.*;

public class LanguageBox extends JComboBox
{
    public LanguageBox(final ScriptEngineManager scriptEngineManager) {
        this.fillLanguageBox(scriptEngineManager);
    }
    
    private void fillLanguageBox(final ScriptEngineManager scriptEngineManager) {
        final List<ScriptEngineFactory> engineFactories = scriptEngineManager.getEngineFactories();
        final ArrayList<ScriptingLanguage> list = new ArrayList<ScriptingLanguage>();
        for (final ScriptEngineFactory scriptEngineFactory : engineFactories) {
            if (scriptEngineFactory.getLanguageName().equals("python")) {
                list.add((E)new ScriptingLanguage(scriptEngineFactory.getLanguageName(), scriptEngineFactory.getLanguageVersion()));
            }
        }
        Collections.sort(list);
        final Iterator<Object> iterator2 = (Iterator<Object>)list.iterator();
        while (iterator2.hasNext()) {
            this.addItem((ScriptingLanguage)iterator2.next());
        }
    }
    
    public String getSelectedLanguage() {
        return (this.getSelectedItem() != null) ? ((ScriptingLanguage)this.getSelectedItem()).getName() : null;
    }
    
    public void setSelectedLanguage(final String s) {
        for (int i = 0; i < this.getModel().getSize(); ++i) {
            if (((ScriptingLanguage)this.getItemAt(i)).toString().equals(s)) {
                this.setSelectedIndex(i);
                return;
            }
        }
    }
}
