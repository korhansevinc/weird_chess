public class Fil extends Item {

      public Fil(Board newBoard, int newColour, int newX, int newY) {
            super(newBoard, newColour, newX, newY);
            this.setPointsOfItem(3);
            
      }

      public boolean canGoTo(int newX , int newY)
            {
                  if(isLegalToMove(newX, newY))
                        return canFilGo(newX,newY);
                  else 
                        return false ;
            }


      private boolean canFilGo(int newX, int newY) {
            return isMovingDiagonal(newX, newY) ;
      }
      
}
