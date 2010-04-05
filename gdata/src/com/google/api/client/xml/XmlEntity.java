package com.google.api.client.xml;

import com.google.api.client.Entity;

/**
 * Represents an XML element and stores its attributes and text content or
 * sub-elements. As an entity, uses public fields and an internal map to store
 * all attributes/text content/sub-elements that are known or unknown
 * (respectively).
 */
public class XmlEntity extends Entity implements Cloneable {

  /**
   * Optional XML element local name prefixed by its namespace alias -- for
   * example {@code "atom:entry"} -- or {@code null} if not set.
   */
  public volatile String name;

  /** Optional namespace dictionary or {@code null} if not set. */
  public volatile XmlNamespaceDictionary namespaceDictionary;

  @Override
  public XmlEntity clone() {
    return Xml.clone(this);
  }

  @Override
  public String toString() {
    XmlNamespaceDictionary namespaceDictionary = this.namespaceDictionary;
    if (namespaceDictionary == null) {
      namespaceDictionary = new XmlNamespaceDictionary();
    }
    return namespaceDictionary.toStringOf(this.name, this);
  }
}