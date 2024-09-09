public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7) {
            if (line == toLine && column == toColumn) {
                return false;
            }
            int deltaLine = Math.abs(toLine - line);
            int deltaColumn = Math.abs(toColumn - column);

            if ((deltaLine == 2 && deltaColumn == 1) || (deltaLine == 1 && deltaColumn == 2)) {
                if (chessBoard.board[toLine][toColumn] == null ||
                        !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
