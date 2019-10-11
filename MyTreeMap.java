import java.util.HashSet;
import java.util.Set;

public class MyTreeMap {
    public static class MyEntry {
        private int key;
        private int value;
        private MyEntry left;
        private MyEntry right;

        public MyEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    private MyEntry root = null;

    public int get(int key) {
        MyEntry cur = root;
        while (cur != null) {
            if (key == cur.key) {
                return cur.value;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return -1;
    }

    public int getOrDefault(int key, int defaultValue) {
        MyEntry cur = root;
        while (cur != null) {
            if (key == cur.key) {
                return cur.value;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return defaultValue;
    }


    //存在做更新，不存在做插入
    public int set(int key, int value) {
        if (root == null) {
            root = new MyEntry(key, value);
            return -1;
        }

        MyEntry parent = null;
        MyEntry cur = root;
        while (cur != null) {
            if (key == cur.key) {
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            } else if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }

        if (cur == parent.left) {
            parent.left = new MyEntry(key, value);
        } else {
            parent.right = new MyEntry(key, value);
        }

        return -1;
    }

    // TODO: remove
    public boolean remove(int key) {
        MyEntry cur = root;
        MyEntry parent = null;
        while (cur != null) {
            if (key == cur.key) {
                // 找到，准备删除
                removeMyEntry(parent, cur);
                return true;
            } else if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }

        return false;
    }

    private void removeMyEntry(MyEntry parent, MyEntry cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            MyEntry goatParent = cur;
            MyEntry goat = cur.right;
            while (goat.left != null) {
                goatParent = goat;
                goat = goat.left;
            }

            cur.key = goat.key;
            //cur.value = goat.value;

            if (goat == goatParent.left) {
                goatParent.left = goat.right;
            } else {
                goatParent.right = goat.right;
            }
        }
    }

    public Set<Integer> keySet() {
        return inorderKeySet(root);
    }

    private static Set<Integer> inorderKeySet(MyEntry node) {
        Set<Integer> set = new HashSet<>();
        if (node != null) {
            Set<Integer> left = inorderKeySet(node.left);
            Set<Integer> right = inorderKeySet(node.right);
            set.addAll(left);
            set.add(node.key);
            set.addAll(right);
        }
        return set;
    }

    public boolean containsKey(int key) {
        return get(key) != -1;
    }
}
