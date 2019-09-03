public class NQueens{

	int [][] board;
	int number;

	public NQueens (int n) {

		number=n;	

		board=new int[number][number];  //this creates a board the same length and width as n
		

	}

	public boolean placeNQueens() throws Exception {



		if (number<=0){
			throw new Exception("Number must be greater than 0!");  //catches a board size error
		}

		if (placeTheQueens(0)){			//Uses 0 as a base case for the recursive backtracking
			printToConsole();
			return true;
		}

		else{
			System.out.println("this is a failed attempt: try a different number"); //lets the user know if the solution is not possible given n
			return false;
		}
	}


	public boolean placeTheQueens(int row){

		if (row>=number){ //if we have reached row n, we can return true 
			return true;
		}

		for (int i=0; i<number; i++){

			if (canPlace(row, i)){
				board[row][i]=1;



				if (placeTheQueens(row+1)) //backtracking and recurrsion
					return true;
				
				
		
				
					board[row][i]=0; //sets the spaces back to 0 if needed
				}
			}
		



		return false;
	}

	public boolean canPlace(int row, int col){ //checks each direction of the queen to see if it is being attacked
		for (int i=row, j=col; i>=0 && j>=0; i--, j--)
		{
			if (board[i][j]==1)									//north west
				return false;
		}

		for (int i=row, j=col; i<number && j>=0; i++, j--)
		{															//north east
			if (board[i][j]==1)
				return false;
		}

		for (int i=row, j=col; i<number && j<number; i++, j++)
		{															//south east
			if (board[i][j]==1)
				return false;
		}

		for (int i=row, j=col; i>=0 && j<number; i--, j++)
		{														//south west
			if (board[i][j]==1)
				return false;
		}

		for(int i=0; i<number; i++)
		{
			if (board[i][col]==1)          //checks north
				return false;
		}

		
		return true;  //returns true if the piece is able to be moved by the user
	}

	public void printToConsole(){ //prints out the board with queens and blank spaces instead of 1 and o

      int i;
      for (i=0; i<number; i++){
         for (int j=0; j<number; j++){
            if (board[i][j]==1){
               System.out.print("Q  ");
            }
            else{
               System.out.print("_  ");
            }
            
         }

         System.out.println();
      }


	}

} 