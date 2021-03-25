package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		// Torre.
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[ getBoard().getRows() ][ getBoard().getColumns() ]; 
		
		Position p = new Position( 0, 0 );
		
		// Marcando todas as posições possíveis nas quais o rei pode se movimentar - ACIMA DELE.
		p.setValues( position.getRow() - 1, position.getColumn() );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setRow( p.getRow() - 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Marcando todas as posições possíveis nas quais o rei pode se movimentar - A ESQUERDA DELE.
		p.setValues( position.getRow(), position.getColumn() - 1 );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setColumn( p.getColumn() - 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Marcando todas as posições possíveis nas quais o rei pode se movimentar - A DIREITA DELE.
		p.setValues( position.getRow(), position.getColumn() + 1 );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setColumn( p.getColumn() + 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}

		// Marcando todas as posições possíveis nas quais o rei pode se movimentar - ABAIXO DELE.
		p.setValues( position.getRow() + 1, position.getColumn() );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setRow( p.getRow() + 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		return mat;
	}
}
