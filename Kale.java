public class Kale extends Item {

      public Kale(Board newBoard, int newColour, int newX, int newY) {
            super(newBoard, newColour, newX, newY);
            this.setPointsOfItem(5);
      }

      public boolean canGoTo(int newX , int newY) {
            if(isLegalToMove(newX, newY)== true) 
                  return canKaleGo(newX,newY);
            
            else 
                  return false ;
      }

      private boolean canKaleGo(int newX, int newY) {
            return isMovingStraight(newX, newY) ;
      }
      
}
