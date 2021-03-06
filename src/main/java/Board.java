import java.util.ArrayList;

public class Board {

    private final int SIZE;
    private String[][] board;

    public Board (int size) {
        SIZE  = size;
        board = new String[SIZE][SIZE];
        reset();
    }

    // http://stackoverflow.com/questions/1754315/how-to-create-custom-exceptions-in-java
    public void setCell(int index, String cellContent) {
        board[getRowFromIndex(index)][getColFromIndex(index)] = cellContent;
    }

    public String getCell(int index) {
        return board[getRowFromIndex(index)][getColFromIndex(index)];
    }

    public int getSize() {
        return SIZE;
    }

    public String[][] getContents() {
        String[][] copy = new String[SIZE][SIZE];

        for(int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                copy[row][col] = board[row][col];
            }
        }

        return copy;
    }

    public void setContents(String[][] contents) {
        for(int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = contents[row][col];
            }
        }
    }

    public void reset() {
        for (int index = 1; index <= SIZE*SIZE; index++) {
            setCell(index, "");
        }
    }

    public ArrayList<Integer> getEmptyCellIndexes() {
        ArrayList<Integer> empties = new ArrayList();

        for (int index = 1; index <= SIZE*SIZE; index++) {
            if (getCell(index).equals("")) {
                empties.add(index);
            }
        }

        return empties;
    }

    public boolean isFull() {
        return getEmptyCellIndexes().size() == 0;
    }

    public int getRowFromIndex(int index) {
        return (index - 1) / SIZE;
    }

    public int getColFromIndex(int index) {
        return (index - 1) % SIZE;
    }

    public int getIndexFromCoords(int row, int col) {
        return 1 + row*SIZE + col;
    }

    public boolean isCellBusy(int index) {
        if ( board[getRowFromIndex(index)][getColFromIndex(index)].equals("") ) {
            return false;
        }

        return true;
    }
}
