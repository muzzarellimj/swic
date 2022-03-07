package semester_two.week_fifteen;

public class MapObject<K, V> {

    private K key;
    private V value;

    public MapObject(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}