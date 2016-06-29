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
package com.google.security.zynamics.zylib.gui.zygraph.settings;

public interface IProximitySettingsListener {
  /**
   * Invoked after the proximity browsing setting changed.
   * 
   * @param value The new value of the proximity browsing setting.
   */
  void changedProximityBrowsing(boolean value);

  void changedProximityBrowsingDepth(int children, int parents);

  /**
   * Invoked after the proximity browsing frozen setting changed.
   * 
   * @param value The new value of the proximity browsing frozen setting.
   */
  void changedProximityBrowsingFrozen(boolean value);

  /**
   * Invoked after the proximity browsing preview setting changed.
   * 
   * @param value The new value of the proximity browsing preview setting.
   */
  void changedProximityBrowsingPreview(boolean value);
}
