public class King extends ChessPiece{
    public King(String color) {
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
            if (!chessBoard.board[toLine][toColumn].getColor().equals(this.color) && !new King(this.color).isUnderAttack(chessBoard,toLine,toColumn)) {
                if (column == toColumn && (line + 1 == toLine || line - 1 == toLine)) {
                    return true;
                }
                else if (line == toLine && (column + 1 == toColumn || column - 1 == toColumn)) {
                    return true;
                }
                else if ((column + 1 == toColumn || column - 1 == toColumn) && (line + 1 == toLine || line - 1 == toLine)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        String opponent = (color.equals("White"))? "Black" : "White";
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board.length; j++) {
                if (board.board[i][j] != null  && board.board[i][j].color.equals(opponent)) {
                        if (board.board[i][j].equals("P") && new Pawn(opponent).canMoveToPosition(board, i,j,line,column)) {
                            return true;
                        }
                        if (board.board[i][j].equals("R") && new Rook(opponent).canMoveToPosition(board, i,j,line,column)) {
                            return true;
                        }
                        if (board.board[i][j].equals("H") && new Horse(opponent).canMoveToPosition(board, i,j,line,column)) {
                            return true;
                        }
                        if (board.board[i][j].equals("B") && new Bishop(opponent).canMoveToPosition(board, i,j,line,column)) {
                            return true;
                        }
                        if (board.board[i][j].equals("Q") && new Queen(opponent).canMoveToPosition(board, i,j,line,column)) {
                            return true;
                        }
                        if (board.board[i][j].equals("K") && new King(opponent).canMoveToPosition(board, i,j,line,column)) {
                            return true;
                        }
                    }
                }
            }
        return false;
    }
}
