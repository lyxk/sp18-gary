public class OffByOne implements CharacterComparator {
    // Returns true if two characters are off by one, e.g., 'a' and 'b', '%' and '&'.
    @Override
    public boolean equalChars(char x, char y) {
        int offset = x - y;
        if (offset == -1 || offset == 1) {
            return true;
        }
        return false;
    }
}
