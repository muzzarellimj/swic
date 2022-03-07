package semester_two.week_fifteen;

/**
 *
 *
 * @param <T1>  the top type.
 * @param <T2>  the middle type.
 * @param <T3>  the bottom type.
 *
 * @author Michael Muzzarelli
 */
public class Totem<T1, T2, T3> {

    private T1 top;
    private T2 middle;
    private T3 bottom;

    public Totem(T1 top, T2 middle, T3 bottom) {
        this.top = top;
        this.middle = middle;
        this.bottom = bottom;
    }

    public boolean isUnique() {
        return !(top.equals(middle) && top.equals(bottom));
    }

    @Override
    public boolean equals(Object o) {
        Totem<T1, T2, T3> other = (Totem<T1, T2, T3>) o;

        return top.equals(other.top) &&
                middle.equals(other.middle) &&
                bottom.equals(other.bottom);
    }

    @Override
    public String toString() {
        return top + " - " + middle + " - " + bottom;
    }

    public static void main(String[] args) {
        Totem<String, String, String> test = new Totem<>("top", "middle", "bottom");
        // Totem<Circle, Hexagon, Square> geometric = new Totem<>(a, b, c);
    }
}