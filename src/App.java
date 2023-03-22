
public class App {
    public static void main(String[] args) throws Exception {
        SLList L = new SLList();
        L.addFirst(10);
        L.addFirst(5);
        int x = L.getFirst();

        System.out.print(L.size);
    }

}

class SLList {

    static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    public int size;

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        sentinel = new IntNode(x, sentinel);
        size = +1;
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return sentinel.item;
    }

    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
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

}
