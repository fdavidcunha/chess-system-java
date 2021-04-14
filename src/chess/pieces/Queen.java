package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		// Rainha.
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[ getBoard().getRows() ][ getBoard().getColumns() ]; 
		
		Position p = new Position( 0, 0 );
		
		// Marcando todas as posições possíveis nas quais a rainha pode se movimentar - ACIMA DELA.
		p.setValues( position.getRow() - 1, position.getColumn() );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setRow( p.getRow() - 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Marcando todas as posições possíveis nas quais a rainha pode se movimentar - A ESQUERDA DELA.
		p.setValues( position.getRow(), position.getColumn() - 1 );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setColumn( p.getColumn() - 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Marcando todas as posições possíveis nas quais a rainha pode se movimentar - A DIREITA DELA.
		p.setValues( position.getRow(), position.getColumn() + 1 );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setColumn( p.getColumn() + 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}

		// Marcando todas as posições possíveis nas quais a rainha pode se movimentar - ABAIXO DELA.
		p.setValues( position.getRow() + 1, position.getColumn() );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setRow( p.getRow() + 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Marcando todas as posições possíveis nas quais a rainha pode se movimentar - Noroeste - Diagonal superior esquerda.
		p.setValues( position.getRow() - 1, position.getColumn() - 1 );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setValues( p.getRow() - 1, p.getColumn() - 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Marcando todas as posições possíveis nas quais a rainha pode se movimentar - Nordeste - Diagonal superior diretia.
		p.setValues( position.getRow() - 1, position.getColumn() + 1 );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setValues( p.getRow() - 1, p.getColumn() + 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}
		
		// Marcando todas as posições possíveis nas quais a rainha pode se movimentar - Sudeste - Diagonal inferior direita.
		p.setValues( position.getRow() + 1, position.getColumn() + 1 );
		
		while ( getBoard().positionExists( p ) && !getBoard().thereIsAPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
			p.setValues( p.getRow() + 1, p.getColumn() + 1 );
		}
		
		if ( getBoard().positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow() ][ p.getColumn() ] = true;
		}

		// Marcando todas as posições possíveis nas quais a rainha pode se movimentar - Sudoeste - Diagonal inferior esquerda.
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
