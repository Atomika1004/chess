public class Rook extends ChessPiece {
    public Rook(String color) {
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
            if (column == toColumn || line == toLine) {
                if (checkPath(chessBoard,line,column,toLine,toColumn)) {
                    if(chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkPath (ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (column == toColumn) {
            int step = (line < toLine)? 1: -1;
            for (int i = line + step; i != toLine; i += step) {
                if (chessBoard.board[i][column] != null) {
                    return false;
                }
            }
        }
        else if (line == toLine) {
            int step = (column < toColumn)? 1 : -1;
            for (int i = column + step; i != toColumn ; i += step) {
                if (chessBoard.board[line][i] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
