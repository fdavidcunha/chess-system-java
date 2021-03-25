package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		// Rei.
		return "K";
	}

	private boolean canMove( Position position ) {
		ChessPiece p = ( ChessPiece )getBoard().piece( position );
		return ( ( p == null ) || ( p.getColor() != getColor() ) );
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[ getBoard().getRows() ][ getBoard().getColumns() ]; 
		
		Position p = new Position( 0, 0 );
		
		// Testando se o rei pode se mover para cima.
		p.setValues( position.getRow() - 1, position.getColumn() );
		if ( getBoard().positionExists(p) && canMove(p) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Testando se o rei pode se mover para baixo.
		p.setValues( position.getRow() + 1, position.getColumn() );
		if ( getBoard().positionExists(p) && canMove(p) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Testando se o rei pode se mover para a esquerda.
		p.setValues( position.getRow(), position.getColumn() - 1 );
		if ( getBoard().positionExists(p) && canMove(p) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Testando se o rei pode se mover para a direita.
		p.setValues( position.getRow(), position.getColumn() + 1 );
		if ( getBoard().positionExists(p) && canMove(p) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Testando se o rei pode se mover para a diagonal superior esquerda (noroeste).
		p.setValues( position.getRow() - 1, position.getColumn() - 1 );
		if ( getBoard().positionExists(p) && canMove(p) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Testando se o rei pode se mover para a diagonal superior direita (nordeste).
		p.setValues( position.getRow() - 1, position.getColumn() + 1 );
		if ( getBoard().positionExists(p) && canMove(p) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Testando se o rei pode se mover para a diagonal inferior esquerda (sudoeste).
		p.setValues( position.getRow() + 1, position.getColumn() - 1 );
		if ( getBoard().positionExists(p) && canMove(p) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Testando se o rei pode se mover para a diagonal inferior direita (sudeste).
		p.setValues( position.getRow() + 1, position.getColumn() + 1 );
		if ( getBoard().positionExists(p) && canMove(p) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}

		return mat;
	}

}
