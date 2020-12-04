package hw2;

public class MatrixException extends Throwable {
    public MatrixException(int num) {
        super("Matrix has " + num + " row(-s) instead of 4");
    }

    public MatrixException(int num, int row) {
        super("Matrix has " + num + " elements in " + row + " row instead of 4");
    }
}
