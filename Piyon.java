public class Piyon extends Item {

      public Piyon(Board newBoard, int newColour, int newX, int newY) {
            super(newBoard, newColour, newX, newY);
            this.setPointsOfItem(1);
      }

      public boolean canGoTo(int newX , int newY)
      {
            if(isLegalToMove(newX, newY))
                  return canPiyonGo(newX,newY);
            else 
                  return false ;
      }

      private boolean canPiyonGo(int newX, int newY) {
             
            int move  ;
            Item locItem = this.getChessBoard().getItemAt(newX, newY) ;

            if(this.getColour() == BLACK)
                  move = 1 ;
            else if (this.getColour() == WHITE) 
                  move = -1 ;
            else 
            {
                  move = 0 ;
            }
          
            if(move == this.getX() - newX)
            {
                  if((newY == this.getY()) && (locItem == null))
                  {
                        return true ;
                  }
                  if((Math.abs(this.getY() - newY) == 1) && (locItem!= null))
                  {
                        return true ;
                  }
                  
            }
            return false ;
            
           

		









      }

      

      
}
