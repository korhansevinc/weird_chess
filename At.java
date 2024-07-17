public class At extends Item {

      
      public At(Board newBoard, int newColour, int newX, int newY) {
            super(newBoard, newColour, newX, newY);
            this.setPointsOfItem(3);
                  
      }

      public boolean canGoTo(int newX , int newY)
      {
            if(isLegalToMove(newX, newY)){
                  return canAtGo(newX,newY) ;
            }
            else 
                  return false ;
      }

      private boolean canAtGo(int newX , int newY)
      {
            if((Math.abs(newX - this.getX()) == 2) & (Math.abs(newY - this.getY()) == 1))
            {
                  return true ;
            }
            if((Math.abs(newX - this.getX()) == 1) & (Math.abs(newY - this.getY()) == 2))
            {
                  return true ;
            }
            return false ;
      }
      
}
