package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
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
	
	// Testando se a torre est� apta para a jogada especial chamada "roque".
	private boolean testRookCastling( Position position ) {
		ChessPiece p = (ChessPiece)getBoard().piece( position );
		return ( p != null ) && ( p instanceof Rook ) && ( p.getColor() == getColor() ) && ( p.getMoveCount() == 0 );
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
		
		// Testando a jogada especial do roque (castling).
		if ( ( getMoveCount() == 0 ) && !chessMatch.getCheck() ) {
			// Roque pequeno (roque do lado do rei).
			Position posT1 = new Position( position.getRow(), position.getColumn() + 3 );
			
			if ( testRookCastling( posT1 ) ) {
				Position p1 = new Position( position.getRow(), position.getColumn() + 1 );
				Position p2 = new Position( position.getRow(), position.getColumn() + 2 );
				
				if ( getBoard().piece( p1 ) == null && getBoard().piece( p2 ) == null ) {
					mat[ position.getRow() ][ position.getColumn() + 2 ] = true;
				}
			}
			
			// Roque grande (roque do lado da rainha).
			Position posT2 = new Position( position.getRow(), position.getColumn() - 4 );
			
			if ( testRookCastling( posT2 ) ) {
				Position p1 = new Position( position.getRow(), position.getColumn() - 1 );
				Position p2 = new Position( position.getRow(), position.getColumn() - 2 );
				Position p3 = new Position( position.getRow(), position.getColumn() - 3 );
				
				if ( ( getBoard().piece( p1 ) == null ) && ( getBoard().piece( p2 ) == null ) && ( getBoard().piece( p3 ) == null ) ) {
					mat[ position.getRow() ][ position.getColumn() - 2 ] = true;
				}
			}
			
		}

		return mat;
	}

}
