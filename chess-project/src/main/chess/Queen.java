package chess;

public class Queen extends Piece{
	private PieceColour colour;
	private String symbol;

	public Queen(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♕";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♛";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}


	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if (Board.hasPiece(i1, j1)) {
			if (Board.getPiece(i0, j0).getColour() == (Board.getPiece(i1, j1).getColour())) {
				return false;
			}
		}
		if (Math.abs(i1-i0) == Math.abs(j1-j0)) {
			if (Math.abs(i1-i0) > 1) {
				if (i1>i0 && j1>j0) {
					int ic=i0+1;
					int jc=j0+1;
					while (ic >= i1-1) {
						if (Board.hasPiece(ic, jc)) {
							return false;
						}
						ic++;
						jc++;
					}
					return true;
				}
				else if (i1<i0 && j1>j0) {
					int ic=i0-1;
					int jc=j0+1;
					while (ic >= i1+1) {
						if (Board.hasPiece(ic, jc)) {
							return false;
						}
						ic--;
						jc++;
					}
					return true;
				}
				else if (i1<i0 && j1<j0) {
					int ic=i0-1;
					int jc=j0-1;
					while (ic >= i1+1) {
						if (Board.hasPiece(ic, jc)) {
							return false;
						}
						ic--;
						jc--;
					}
					return true;
				}
				else if (i1>i0 && j1<j0) {
					int ic = i0 + 1;
					int jc = j0 - 1;
					while (ic >= i1 - 1) {
						if (Board.hasPiece(ic, jc)) {
							return false;
						}
						ic++;
						jc--;
					}
					return true;
				}
			}
			else {
				return true;
			}
		}
		else {
			if(i1-i0 != 0 && j1==j0){
				if (i0 > i1) {
					for (int k=i0-1; k>=i1+1; k--) {
						if (Board.hasPiece(k, j0)){
							return false;
						}
					}
					return true;
				}
				else {
					for (int k=i0+1; k<=i1-1; k++) {
						if (Board.hasPiece(k, j0)) {
							return false;
						}
					}
					return true;
				}
			}
			else if (j1-j0 != 0 && i1==i0) {
				if (j1>j0) {
					for (int k=j0+1; k<=j1-1; k++) {
						if (Board.hasPiece(i0, k)) {
							return false;
						}
					}
					return true;
				}
				else {
					for (int k=j0-1; k>=j1+1; k--) {
						if (Board.hasPiece(i0, k)) {
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
	}
}
