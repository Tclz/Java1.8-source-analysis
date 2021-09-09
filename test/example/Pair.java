package example;

public class Pair<T, K> {
    private T first;
    private K last;
    public Pair(T first, K last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() { return first; }
    public K getLast() { return last; }
    public Pair() {
        // Compile error:
//        first = new T();
//        last = new T();
    }
}