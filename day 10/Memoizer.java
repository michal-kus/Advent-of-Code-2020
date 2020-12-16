public class Memoizer {
    long[] cache;

    public Memoizer(int cacheSize) {
        this.cache = new long[cacheSize];
        for (int i = 0; i < cacheSize; i++) {
            cache[ i] = -1;
        }
    }
    public void putCache(int index, long value) {
        cache[index] = value;
    }
    public long getCache(int index) {
        return cache[index];
    }
    public boolean isCached(int index) {
        return cache[index] != -1;
    }
}
