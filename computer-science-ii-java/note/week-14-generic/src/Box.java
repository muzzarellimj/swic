package semester_two.week_fourteen;

public class Box<T> {

    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "[" + data + "]";
    }

    public T getData() {
        return data;
    }

    public void setData(T value) {
        data = value;
    }

    public T add(T rightOp) {
        return null;
    }
}