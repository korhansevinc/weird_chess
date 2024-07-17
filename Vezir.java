public class Vezir extends Item {

      public Vezir(Board newBoard, int newColour, int newX, int newY) {
            super(newBoard, newColour, newX, newY);
            this.setPointsOfItem(9);
      }

      public boolean canGoTo(int newX , int newY){
            if(this.isLegalToMove(newX, newY)){
                  return canVezirGo(newX, newY) ;
            }
            else 
                  return false ;
      }

      public boolean canVezirGo(int newX , int newY){
            if((this.isMovingStraight(newX, newY) == true) || this.isMovingDiagonal(newX, newY) == true) {
                  return true ;
            }
            else 
                  return false ;
      }
      
}
