package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		// Bispo.
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[ getBoard().getRows() ][ getBoard().getColumns() ]; 
		
		Position p = new Position( 0, 0 );
		
		// Marcando todas as posições possíveis nas quais o bispo pode se movimentar - Noroeste - Diagonal superior esquerda.
		p.setValues( position.getRow() - 1, position.getColumn() - 1 );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setValues( p.getRow() - 1, p.getColumn() - 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Marcando todas as posições possíveis nas quais o rei pode se movimentar - Nordeste - Diagonal superior diretia.
		p.setValues( position.getRow() - 1, position.getColumn() + 1 );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setValues( p.getRow() - 1, p.getColumn() + 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Marcando todas as posições possíveis nas quais o rei pode se movimentar - Sudeste - Diagonal inferior direita.
		p.setValues( position.getRow() + 1, position.getColumn() + 1 );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setValues( p.getRow() + 1, p.getColumn() + 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}

		// Marcando todas as posições possíveis nas quais o rei pode se movimentar - Sudoeste - Diagonal inferior esquerda.
		p.setValues( position.getRow() + 1, position.getColumn() - 1 );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setValues( p.getRow() + 1, p.getColumn() - 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		return mat;
	}
}
