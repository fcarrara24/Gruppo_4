package classes;

public class ObiettivoPersonale {
	
	public int numero;
	
	public ObiettivoPersonale(int numero) {
		this.numero=numero;
		}
	
	public int SelectorObiettivoPersonale(int[][] shelf) {
	 switch(numero) {
		case 1:
			return ObiettivoPersonale1(shelf);
			
		case 2:
			return ObiettivoPersonale2(shelf);
			
		case 3:
			return ObiettivoPersonale3(shelf);
			
		case 4:
			return ObiettivoPersonale4(shelf);
			
		case 5:
			return ObiettivoPersonale5(shelf);
			
		case 6:
			return ObiettivoPersonale6(shelf);
			
		case 7:
			return ObiettivoPersonale7(shelf);
			
		case 8:
			return ObiettivoPersonale8(shelf);
			
		case 9:
			return ObiettivoPersonale9(shelf);
			
		case 10:
			return ObiettivoPersonale10(shelf);
		
		case 11:
			return ObiettivoPersonale11(shelf);
			
		case 12:
			return ObiettivoPersonale12(shelf);
			
		default:
			break;
		}
	 return 0;
	}
	
	public int ObiettivoPersonale1(int[][] matrix) {
		int contatore=0;
		if(matrix[0][0]==5) {
			contatore++;
		}
		if(matrix[0][2]==1) {
			contatore++;
		}
		if(matrix[1][4]==2) {
			contatore++;
		}
		if(matrix[2][3]==4) {
			contatore++;
		}
		if(matrix[3][1]==3) {
			contatore++;
		}
		if(matrix[5][2]==6) {
			contatore++;
		}
		
		return contatore;
	}
	
	public int ObiettivoPersonale3(int[][] matrix) {
		int contatore=0;
		if(matrix[1][0]==1) {
			contatore++;
		}
		if(matrix[1][3]==3) {
			contatore++;
		}
		if(matrix[2][2]==5) {
			contatore++;
		}
		if(matrix[3][1]==2) {
			contatore++;
		}
		if(matrix[3][4]==6) {
			contatore++;
		}
		if(matrix[5][0]==4) {
			contatore++;
		}
		
		return contatore;
	}
	
	public int ObiettivoPersonale5(int[][] matrix) {
		int contatore=0;
		if(matrix[1][1]==6) {
			contatore++;
		}
		if(matrix[3][1]==1) {
			contatore++;
		}
		if(matrix[3][2]==4) {
			contatore++;
		}
		if(matrix[4][4]==5) {
			contatore++;
		}
		if(matrix[5][0]==3) {
			contatore++;
		}
		if(matrix[5][2]==2) {
			contatore++;
		}
		
		return contatore;
	}
	
	public int ObiettivoPersonale7(int[][] matrix) {
		int contatore=0;
		if(matrix[0][0]==2) {
			contatore++;
		}
		if(matrix[1][3]==1) {
			contatore++;
		}
		if(matrix[2][1]==5) {
			contatore++;
		}
		if(matrix[3][0]==6) {
			contatore++;
		}
		if(matrix[4][4]==3) {
			contatore++;
		}
		if(matrix[5][2]==4) {
			contatore++;
		}
		
		return contatore;
	}
	
	public int ObiettivoPersonale9(int[][] matrix) {
		int contatore=0;
		if(matrix[0][2]==3) {
			contatore++;
		}
		if(matrix[2][2]==2) {
			contatore++;
		}
		if(matrix[3][4]==4) {
			contatore++;
		}
		if(matrix[4][4]==6) {
			contatore++;
		}
		if(matrix[4][1]==5) {
			contatore++;
		}
		if(matrix[5][0]==1) {
			contatore++;
		}
		
		return contatore;
	}
	
	
	public int ObiettivoPersonale11(int[][] matrix) {
		int contatore=0;
		if(matrix[0][3]==5) {
			contatore++;
		}
		if(matrix[1][1]==4) {
			contatore++;
		}
		if(matrix[2][0]==3) {
			contatore++;
		}
		if(matrix[3][2]==1) {
			contatore++;
		}
		if(matrix[4][4]==2) {
			contatore++;
		}
		if(matrix[5][3]==6) {
			contatore++;
		}
		
		return contatore;
	}
	
	public int ObiettivoPersonale2(int[][] matrix) {
		int contatore = 0;

		if (matrix[1][1] == 5) {
			contatore++;
		}

		if (matrix[2][0] == 2) {
			contatore++;
		}

		if (matrix[2][2] == 3) {
			contatore++;
		}

		if (matrix[3][4] == 4) {
			contatore++;
		}

		if (matrix[4][3] == 6) {
			contatore++;
		}

		if (matrix[5][4] == 1) {
			contatore++;
		}

		return contatore;
	}

	public int ObiettivoPersonale4(int[][] matrix) {
		int contatore = 0;

		if (matrix[0][4] == 3) {
			contatore++;
		}

		if (matrix[2][0] == 6) {
			contatore++;
		}

		if (matrix[2][2] == 1) {
			contatore++;
		}

		if (matrix[3][3] == 5) {
			contatore++;
		}

		if (matrix[4][1] == 4) {
			contatore++;
		}

		if (matrix[4][2] == 2) {
			contatore++;
		}

		return contatore;
	}

	public int ObiettivoPersonale6(int[][] matrix) {
		int contatore = 0;

		if (matrix[0][2] == 6) {
			contatore++;
		}

		if (matrix[0][4] == 2) {
			contatore++;
		}

		if (matrix[2][3] == 4) {
			contatore++;
		}

		if (matrix[4][1] == 3) {
			contatore++;
		}

		if (matrix[4][3] == 1) {
			contatore++;
		}

		if (matrix[5][0] == 5) {
			contatore++;
		}

		return contatore;
	}

	public int ObiettivoPersonale8(int[][] matrix) {
		int contatore = 0;

		if (matrix[0][4] == 1) {
			contatore++;
		}

		if (matrix[1][1] == 2) {
			contatore++;
		}

		if (matrix[2][2] == 6) {
			contatore++;
		}

		if (matrix[3][0] == 5) {
			contatore++;
		}

		if (matrix[4][3] == 4) {
			contatore++;
		}

		if (matrix[5][3] == 3) {
			contatore++;
		}

		return contatore;
	}

	public int ObiettivoPersonale10(int[][] matrix) {
		int contatore = 0;

		if (matrix[0][4] == 6) {
			contatore++;
		}

		if (matrix[1][1] == 3) {
			contatore++;
		}

		if (matrix[2][0] == 4) {
			contatore++;
		}

		if (matrix[3][3] == 2) {
			contatore++;
		}

		if (matrix[4][1] == 1) {
			contatore++;
		}

		if (matrix[5][3] == 5) {
			contatore++;
		}

		return contatore;
	}

	public int ObiettivoPersonale12(int[][] matrix) {
		int contatore = 0;

		if (matrix[0][2] == 4) {
			contatore++;
		}

		if (matrix[1][1] == 5) {
			contatore++;
		}

		if (matrix[2][2] == 1) {
			contatore++;
		}

		if (matrix[3][3] == 6) {
			contatore++;
		}

		if (matrix[4][4] == 3) {
			contatore++;
		}

		if (matrix[5][0] == 2) {
			contatore++;
		}

		return contatore;
	}


}
