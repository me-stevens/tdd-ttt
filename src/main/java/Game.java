public class Game {

    private Board board;
    private ConsoleUI gameUI;

    public Game(Board board, ConsoleUI gameUI) {
        this.board  = board;
        this.gameUI = gameUI;
    }

    public Board getBoard() {
        return board;
    }

    public boolean nextTurn() {
        gameUI.printBoard(board);

        int index = humanTurn();

        updateBoard(index, getMark(true));

        if (board.hasWinner(getMark(true)) || board.isFull() ) {
            gameUI.printGameOverMessage();
            return false;
        }

        return true;
    }

    public int humanTurn() {
        String cellIndex = returnEmptyCellIndex(returnValidCellIndex());
        return stringToNumber(cellIndex);
    }

    public String returnValidCellIndex() {
        String cellIndex = gameUI.getInput();
        String regex     = "[1-" + board.getSize()*board.getSize() + "]";

         while ( !cellIndex.matches(regex) ) {
             gameUI.printNotValidCellMessage();
             cellIndex = gameUI.getInput();
         }

        return cellIndex;
    }

    public String returnEmptyCellIndex(String cellIndex) {

        while ( board.isCellBusy(stringToNumber(cellIndex) ) ) {
            gameUI.printCellIsBusyMessage();
            cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    public int stringToNumber(String cellIndex) {
        return Integer.parseInt(cellIndex);
    }

    public String getMark(boolean first) {
        return first ? "X" : "O";
    }

    public void updateBoard(int index, String mark) {
        board.setCell(board.getRowFromIndex(index), board.getColFromIndex(index), mark);
    }
}