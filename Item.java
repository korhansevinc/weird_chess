
public abstract class Item {
      public static final int BLACK = 0 ;
      public static final int WHITE = 1 ;
     
      private int colour ;
      private int x ;
      private int y ;
      private Board chessBoard ;
      private int points ;
    
      
      public Item()
      {

      }

      public void refreshItem(int newX, int newY)
      {
            this.x = newX ;
            this.y = newY ;
      }
      
      public Item(int newX, int newY)
      {
            this.x = newX ;
            this.y = newY ;
      }
      public Item(Board newBoard , int newColour, int newX , int newY)
      {
            this.colour = newColour ;
            this.x = newX ;
            this.y = newY ;
            this.chessBoard = newBoard ;
       

            this.chessBoard.placeItem(this,newX, newY);
      }
      
      public boolean canGoTo(int newX , int newY)
      {     
            return isLegalToMove(newX,newY);
      }

      public boolean isLegalToMove(int newX, int newY)
      {
            if(this.chessBoard.isIndexInBounds(newX, newY) == true){
                  Item anItem = this.chessBoard.getItemAt(newX, newY) ;

                  if(anItem == null)
                        return true ;
                  if(anItem.getColour() != this.colour)
                        return true ;
                  else 
                        return false ;

            }
            else 
                  return false ;
      }
      public void scrollTo(int newX , int newY)
      {     
            this.chessBoard.removeItem(this);

            this.x = newX ;
            this.y = newY ;

            Item target = this.chessBoard.getItemAt(newX, newY);
            if(target != null){
                  this.killItem(target);
                        
            }
                  
            
            this.chessBoard.placeItem(this, newX, newY);     
 
      }

      public void placeTo(int newX , int newY)
      {
            this.x = newX ;
            this.y = newY ;
      }
      public void moveTo(int newX , int newY)
      {
            this.chessBoard.removeItem(this);
            this.x = newX ;
            this.y = newY ;

            Item target = this.chessBoard.getItemAt(newX, newY);
            if(target != null){
                  this.killItem(target);
                  if(target instanceof Sah){
                        this.chessBoard.setSahSayisi();
                  }
                        
            }
                  
            
            this.chessBoard.placeItem(this, newX, newY);

      }

      public boolean isOnBoard()
      {
            if(this.chessBoard.isIndexInBounds(this.x, this.y))
                  return true ;
            else 
                  return false ;
      }

      public boolean isMovingStraight(int xPosition , int yPosition)
      {
            int locX = this.getX();
            int locY = this.getY();
      
            int sV , lV ;

            if(locX == xPosition){
                  if(locY > yPosition){
                        sV = yPosition ;
                        lV = locY ;
                  }
                  else if(yPosition > locY)
                  {
                        sV = locY ;
                        lV = yPosition ;
                  }
                  else 
                        return false ;

                  sV++ ;
                  for(;sV<lV;sV++){
                        if(this.chessBoard.getItemAt(locX, sV ) != null)
                        {
                              return false ;
                        }
                  }
                  return true ;

            }

            if(locY == yPosition){
                  if(locX > xPosition){
                        sV = xPosition ;
                        lV = locX ;
                  }
                  else if(xPosition > locX)
                  {
                        sV = locX ;
                        lV = xPosition ;
                  }
                  else 
                        return false ;

                  sV++ ;
                  for(;sV<lV;sV++){
                        if(this.chessBoard.getItemAt(sV,locY) != null){
                              return false ;
                        }
                  }
                  return true ;
            }

            return false ;
      }

      public void killItem(Item enemyItem)
      {
            enemyItem.chessBoard.removeItem(this);
      }

      public boolean isMovingDiagonal(int newX , int newY)
      {
            int startX = 0 ;
            int startY = 0 ;
            int finalX = 1 ;
            int finalY = 1 ;

            int totalX = Math.abs(newX - this.getX());
            int totalY = Math.abs(newY - this.getY());

            if(totalX == totalY){
                  if(newX < this.getX())
                  {
                        startX = newX ;
                        finalX = this.getX();
                  }
                  else if(newX >this.getX())
                  {
                        startX = this.getX();
                        finalX = newX ;
                  }
                  else 
                        return false ;

                  if(newY < this.getY())
                  {
                        startY = newY ;
                        finalY = this.getY();
                  }
                  else if(newY > this.getY())
                  {
                        startY = this.getY();
                        finalY = newY ;
                  }
                  else 
                        return false ;

                  startX ++ ;
                  startY ++ ;

                  for(; startX < finalX ; startX++ , startY++)
                  {
                        if(this.chessBoard.getItemAt(startX, startY) != null){
                              return false ;
                        }
                  }
                  return true ;
            }
            return false ;
      }

      public int getX()
      {
            return this.x ;
      }

      public void setX(int newX)
      {
            this.x = newX ;
      }

      public int getY()
      {
            return this.y ;
      }

      public void setY(int newY)
      {
            this.y = newY ;
      }

      public int getColour()
      {
            return this.colour ;
      }

      public Board getChessBoard()
      {
            return this.chessBoard ;
      }

      public int getPointsOfItem()
      {
            return this.points ;
      }
      public void setPointsOfItem(int newPoint)
      {
            this.points = newPoint ;
      }
}
