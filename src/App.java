
public class App {
    public static void main(String[] args) throws Exception {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.print(L.get(2));
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
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    public int get(int i) {
        IntList p = this;
        int counter = 0;

        while (counter != i) {
            p = p.rest;
            counter += 1;
        }

        return p.first;
    }
}