public class Pawn extends ChessPiece {
    public Pawn(String color) {
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
            if (chessBoard.board[toLine][toColumn] == null) {
                if (checkTransferToTheQueen(toLine)) {
                    chessBoard.board[toLine][toColumn] = new Queen(this.color);
                }
                if (color.equals("White") && toLine == line + 1 && column == toColumn) {
                    return true;
                } else if (color.equals("Black") && toLine == line - 1 && column == toColumn) {
                    return true;
                } else if (color.equals("White") && line == 1 && toLine == line + 2 && column == toColumn &&
                        chessBoard.board[line + 1][column] == null) {
                    return true;
                } else if (color.equals("Black") && line == 6 && toLine == line - 2 && column == toColumn &&
                        chessBoard.board[line - 1][column] == null) {
                    return true;
                }
            } else {
                String opponent = (color.equals("White")) ? "Black" : "White";
                if (chessBoard.board[toLine][toColumn].getColor().equals(opponent) && color.equals("White") &&
                        line + 1 == toLine && (column + 1 == toColumn || column - 1 == toColumn)) {
                    return true;
                } else if (chessBoard.board[toLine][toColumn].getColor().equals(opponent) && color.equals("Black") &&
                        line - 1 == toLine && (column + 1 == toColumn || column - 1 == toColumn)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkTransferToTheQueen(int toLine) {
        if (this.color.equals("White") && toLine == 7) {
            return true;
        } else if (this.color.equals("Black") && toLine == 0) {
            return true;
        }
        return false;

    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
