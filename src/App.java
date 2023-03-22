
public class App {
    public static void main(String[] args) throws Exception {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);

        System.out.println(L.get(2));
    }

}

class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }

        return 1 + this.rest.size();
    }

    public int iterativeSize() {
        int counter = 0;
        IntList current = this;
        while (current != null) {
            counter++;
            current = current.rest;
        }

        return counter;
    }

    public int get(int i) {
        int counter = 0;
        IntList current = this;

        while (i != counter) {
            counter++;
            current = current.rest;
        }

        return current.first;
    }
}
