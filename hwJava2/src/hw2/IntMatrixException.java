package hw2;

public class IntMatrixException extends Throwable {
    IntMatrixException(int row, int col) {
        super("Element at " + row + " row and " + col + " column can not be converted to int");
    }
}
