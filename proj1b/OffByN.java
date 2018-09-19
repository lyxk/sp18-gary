public class OffByN implements CharacterComparator{
    private int N;

    // Constructor takes in N. Use N as a standard when implementing equalChars(char x, char y), if dist(x, y) == N.
    OffByN(int N) {
        this.N = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int offset = x - y;
        if (offset == this.N || offset == -this.N) {
            return true;
        }
        return false;
    }
}
