
public class App {
    public static void main(String[] args) throws Exception {

        SLList L = new SLList(10);

        System.out.println(L.sizeIterative());
        L.addLastRecursive(5);
        L.addLastRecursive(10);

        System.out.println(L.size());
    }

}

class SLList {
    static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int f, IntNode r) {
            item = f;
            next = r;
        }

    }

    // first item if exists is at sentinel.next
    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Retrieves the front item from the list. */
    public int getSentinel() {
        return sentinel.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;

    }

    public static IntNode addLastRecursive(IntNode p) {
        if (p.next == null) {
            return p;
        }
        return addLastRecursive(p.next);
    }

    public void addLastRecursive(int x) {
        IntNode last = addLastRecursive(sentinel);

        last.next = new IntNode(x, null);
        size += 1;

    }

    /** Returns the size of the list starting at IntNode p. */
    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }

        return 1 + size(p.next);
    }

    public int size() {
        return size(sentinel);
    }

    public int sizeIterative() {
        IntNode p = this.sentinel;
        int counter = 0;
        while (p.next != null) {
            counter++;
            p = p.next;
        }

        return counter;
    }

    public int sizeCache() {
        return size;
    }
}
