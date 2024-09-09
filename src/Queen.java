public class Queen extends ChessPiece {
    public Queen(String color) {
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
            if (checkPathDiagonal(chessBoard, line, column, toLine, toColumn) ||
                    checkPathVerticalAndHorizontal(chessBoard, line, column, toLine, toColumn)) {
                if(chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean checkPathDiagonal (ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
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
            return true;
        }
        return false;
    }

    public static boolean checkPathVerticalAndHorizontal (ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (column == toColumn) {
            int step = (line < toLine)? 1: -1;
            for (int i = line + step; i != toLine; i += step) {
                if (chessBoard.board[i][column] != null) {
                    return false;
                }
            }
            return true;
        }
        else if (line == toLine) {
            int step = (column < toColumn)? 1 : -1;
            for (int i = column + step; i != toColumn ; i += step) {
                if (chessBoard.board[line][i] != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
