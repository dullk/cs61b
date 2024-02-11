package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
  private BSTNode root;
  private int size;

  private class BSTNode {
    private K key;
    private V value;
    private BSTNode left;
    private BSTNode right;

    private BSTNode(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
    }

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

    private void setValue(V value) {
      this.value = value;
    }

    private void setLeft (BSTNode node) {
      left = node;
    }

    private void setRight (BSTNode node) {
      right = node;
    }
  }

  public BSTMap() {
    root = null;
    size = 0;
  }

  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  @Override
  public boolean containsKey(K key) {
    BSTNode node = root;
    while (node != null) {
      if (node.getKey().compareTo(key) == 0) {
        return true;
      } else if (node.getKey().compareTo(key) < 0) {
        node = node.getRight();
      } else if (node.getKey().compareTo(key) > 0) {
        node = node.getLeft();
      }
    }
    return false;
  }

  @Override
  public V get(K key) {
    BSTNode node = root;
    while (node != null) {
      if (node.getKey().compareTo(key) == 0) {
        return node.getValue();
      } else if (node.getKey().compareTo(key) < 0) {
        node = node.getRight();
      } else if (node.getKey().compareTo(key) > 0) {
        node = node.getLeft();
      }
    }
    return null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void put(K key, V value) {
    BSTNode node = root;
    BSTNode prev = null;
    BSTNode newNode = new BSTNode(key, value);
    if (node == null) {
      root = newNode;
      size += 1;
      return;
    }
    while (node != null) {
      prev = node;
      if (node.getKey().compareTo(key) == 0) {
        node.setValue(value);
        return;
      } else if (node.getKey().compareTo(key) < 0) {
        node = node.getRight();
      } else if (node.getKey().compareTo(key) > 0) {
        node = node.getLeft();
      }
    }
    if (prev.getKey().compareTo(key) > 0) {
      prev.setLeft(newNode);
    } else if (prev.getKey().compareTo(key) < 0) {
      prev.setRight(newNode);
    }
    size += 1;
  }

  private void printHelper(BSTNode node) {
    if (node == null) {
      return;
    }
    printHelper(node.getLeft());
    System.out.print(node.getValue() + " ");
    printHelper(node.getRight());
  }

  public void printInOrder() {
    printHelper(root);
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
