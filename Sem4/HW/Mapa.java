package Sem4.HW;

public class Mapa<K, V> {
    Node<K, V>[] nodes = new Node[16];

    int size = 16;
    private int count = 0;
    public V put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        int index = getIndex(key);

        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                V tmp = currentNode.value;
                currentNode.value = value;
                return tmp;
            }
            currentNode = currentNode.nextNode;
        }
        count++;
        newNode.nextNode = nodes[index];
        nodes[index] = newNode;
        return value;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = nodes[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.nextNode;
        }
        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> currentNode = nodes[index];
        Node<K, V> previousNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                V tmp = currentNode.value;
                if (previousNode == null) {
                    nodes[index] = currentNode.nextNode;
                } else if (currentNode.nextNode == null) {
                    previousNode.nextNode = null;
                } else {
                    previousNode.nextNode = currentNode.nextNode;
                }
                count--;
                return tmp;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        return null;
    }
    public V replace(K key, V value) {
        int index = getIndex(key);
        Node<K, V> currentNode = nodes[index];
        Node<K, V> previousNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
                return currentNode.value;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        return null;
    }

    public int size() {
        return count;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> node = nodes[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.nextNode;
        }
        return false;
    }
    public boolean containsValue(V value) {
        for (int i = 0; i < nodes.length-1; i++) {
            Node<K, V> node = nodes[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.nextNode;
            }
        }
        return false;
    }
}