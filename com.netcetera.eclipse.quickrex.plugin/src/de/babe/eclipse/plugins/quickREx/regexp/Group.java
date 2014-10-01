/*******************************************************************************
 * Copyright (c) 2005 Bastian Bergerhoff and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution.
 *
 * Contributors:
 *     Bastian Bergerhoff - initial API and implementation
 *     Georg Sendt - added code for groups with IDs
 *******************************************************************************/
package de.babe.eclipse.plugins.quickREx.regexp;

/**
 * @author bastian.bergerhoff, georg.sendt
 */
public class Group {

  private final int index;
  private final String id;
  private final int start;
  private final int end;
  private final String text;

  /**
   * The constructor. Instances of this class are immutable.
   *
   * @param p_index the index of this group
   * @param p_id the ID of this group, can be null
   * @param p_text the textual contents of this group
   * @param p_start the start-index of this group
   * @param p_end the end-index of this group
   */
  Group(int p_index, String p_id, String p_text, int p_start, int p_end) {
    this.index = p_index;
    this.id = p_id;
    this.text = p_text;
    this.start = p_start;
    this.end = p_end;
  }

  /**
   * The constructor. Instances of this class are immutable.
   *
   * @param p_index the index of this group
   * @param p_text the textual contents of this group
   * @param p_start the start-index of this group
   * @param p_end the end-index of this group
   */
  Group(int p_index, String p_text, int p_start, int p_end) {
    this(p_index, null, p_text, p_start, p_end);
  }


  /**
   * Returns the index of this group.
   *
   * @return the index
   */
  public int getIndex() {
    return this.index;
  }

  /**
   * Returns the ID of this group or null if the group has no ID.
   *
   * @return the ID
   */
  public String getID() {
    return this.id;
  }

  /**
   * Returns the start-index of this group.
   *
   * @return the start-index
   */
  public int getStart() {
    return this.start;
  }

  /**
   * Returns the end-index of this group.
   *
   * @return the end-index
   */
  public int getEnd() {
    return this.end;
  }

  /**
   * Returns (a one-line representation of) the textual contents of this group
   * where line-breaks and tabs are represented by their escape-sequences.
   *
   * @return the textual contents
   */
  public String getText() {
    if (this.text == null) {
      return null;
    }
    return this.text
        .replaceAll("\r", "\\\u005C\\u0072") //$NON-NLS-1$ //$NON-NLS-2$
        .replaceAll("\n", "\\\u005C\\u006E") //$NON-NLS-1$ //$NON-NLS-2$
        .replaceAll("\t", "\\\u005C\\u0074"); //$NON-NLS-1$ //$NON-NLS-2$
  }
}
