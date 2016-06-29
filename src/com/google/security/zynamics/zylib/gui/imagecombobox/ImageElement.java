/*
Copyright 2011-2016 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.google.security.zynamics.zylib.gui.imagecombobox;

import javax.swing.ImageIcon;

public class ImageElement {
  private final Object m_object;
  private final ImageIcon m_icon;

  public ImageElement(final Object object, final ImageIcon icon) {
    m_object = object;
    m_icon = icon;
  }

  public ImageIcon getIcon() {
    return m_icon;
  }

  public Object getObject() {
    return m_object;
  }
}
