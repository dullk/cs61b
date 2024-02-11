package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K, V> implements Map61B<K, V> {
  private BSTNode root;

  private class BSTNode {
    private K key;
    private V value;
    private BSTNode left;
    private BSTNode right;

    private K getKey() {
      return key;
    }

    private V getValue() {
      return value;
    }

    private BSTNode getLeft() {
      return left;
    }

    private BSTNode getRight() {
      return right;
    }
  }
  @Override
  public void clear() {

  }

  @Override
  public boolean containsKey(K key) {
    return false;
  }

  @Override
  public V get(K key) {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public void put(K key, V value) {

  }

  @Override
  public Set<K> keySet() {
    throw new UnsupportedOperationException();
  }

  @Override
  public V remove(K key) {
    throw new UnsupportedOperationException();
  }

  @Override
  public V remove(K key, V value) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterator<K> iterator() {
    throw new UnsupportedOperationException();
  }
}
