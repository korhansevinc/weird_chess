public class Sah extends Item {

      public Sah(Board newBoard, int newColour, int newX, int newY) {
            super(newBoard, newColour, newX, newY);
            
      }

      public boolean canGoTo(int newX , int newY){
            if(isLegalToMove(newX, newY))
                  return canSahGo(newX , newY);
            else 
                  return false ;
      }

      private boolean canSahGo(int newX , int newY) {
            
            if((Math.abs(newX - this.getX()) <= 1) && (Math.abs(newY - this.getY())) <=1)
            {
                  if(Math.abs(newX - this.getX()) == 0 && Math.abs(newY - this.getY()) == 0)
                  {
                        return false ;
                  }
                  return true ;
            }
            return false ;


      }
      
}
