
public class App {
    public static void main(String[] args) throws Exception {

        SLList L = new SLList(10);

        System.out.println(L.sizeIterative());
        L.addLastRecursive(5);
        L.addLastRecursive(10);

        System.out.println(L.sizeIterative());
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

    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        IntNode p = first;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public static IntNode addLastRecursive(IntNode p) {
        if (p.next == null) {
            return p;
        }
        return addLastRecursive(p.next);
    }

    public void addLastRecursive(int x) {
        IntNode last = addLastRecursive(first);

        last.next = new IntNode(x, null);
    }

    /** Returns the size of the list starting at IntNode p. */
    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }

        return 1 + size(p.next);
    }

    public int size() {
        return size(first);
    }

    public int sizeIterative() {
        IntNode p = this.first;
        int counter = 0;
        while (p.next != null) {
            counter++;
            p = p.next;
        }

        return counter;
    }
}
