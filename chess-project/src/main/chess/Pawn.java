package chess;

public class Pawn extends Piece{
	private PieceColour colour;
	private String symbol;

	public Pawn(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♙";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♟";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

	public boolean directionUp(int i, int j){
		if (Board.getPiece(i, j).getColour() == PieceColour.WHITE) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if (Board.hasPiece(i1, j1)) {
			if (Board.getPiece(i0, j0).getColour() == (Board.getPiece(i1, j1).getColour())) {
				return false;
			}
			else {
				if (!directionUp(i0, j0) && Math.abs(j0-j1) == 1 && i1-i0 == 1){
					return true;
				}
				else if (directionUp(i0, j0) && Math.abs(j0-j1) == 1 && i0-i1 == 1){
					return true;
				}
			}
		}
		else {
			if (j0 == j1 && Math.abs(i1-i0) == 1){
				if (!directionUp(i0, j0) && i1-i0 == 1) {
					return true;
				}
				else if (directionUp(i0, j0) && i0-i1 == 1){
					return true;
				}
			}
			else if (j0 == j1 && (i0 == 1 || i0 == 6) && (Math.abs(i1-i0) == 2 || Math.abs(i1-i0) == 1)){
				if (!directionUp(i0, j0)) {
					if (i1-i0 == 2 || i1-i0 == 1) {
						return true;
					}
				}
				else if (i0-i1 == 2 || i0-i1 == 1) {
					return true;
				}
			}
		}
		return false;
	}
}
