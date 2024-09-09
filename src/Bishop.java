public class Bishop extends ChessPiece{
    public Bishop(String color) {
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
            int deltaLine  = toLine - line;
            int deltaCol = toColumn - column;

            if (Math.abs(deltaLine) == Math.abs(deltaCol)) {
                int stepLine = (line < toLine)? 1 : -1;
                int stepCol = (column < toColumn)? 1 : -1;
                for (int i = line + stepLine, j = column + stepCol; i != toLine; i += stepLine, j += stepCol) {
                    if (chessBoard.board[i][j] != null) {
                        return false;
                    }
                }
                if(chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
