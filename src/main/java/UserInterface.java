public class UserInterface {

    private static final String PROMPT       = "Choose a cell to put your mark: ";
    private static final String NOTVALIDCELL = "Please enter a valid cell number: ";
    private static final String CELLISBUSY   = "Please enter an empty cell number: ";
    private static final String GAMEOVER     = "GAME OVER\n";
    private Console console;

    public UserInterface(Console console) {
        this.console = console;
    }

    public void print(String message) {
        console.write(message);
    }

    public String printBoard(Board board) {
        int cellIndex   = 0;
        String boardStr = "";

        for (String[] row : board.copy()) {
            for (String cell : row) {
                cellIndex++;
                boardStr += makeCell(cellIndex, cell);
            }

            boardStr += "\n";
        }

        print(boardStr);
        return boardStr;
    }

    private String makeCell(int cellIndex, String cell) {
        return (cell.equals("")) ? cellIndex + " " : cell + " ";
    }

    public String getInput() {
        print(PROMPT);
        return console.read();
    }

    public void printNotValidCellMessage() {
        print(NOTVALIDCELL);
    }

    public void printCellIsBusyMessage() {
        print(CELLISBUSY);
    }

    public void printGameOverMessage() {
        print(GAMEOVER);
    }
}