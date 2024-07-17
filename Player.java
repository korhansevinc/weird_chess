public class Player {
      public static final int BLACK = 0 ;
      public static final int WHITE = 1 ; 
      private int points ;
      private int colour ; 


      public Player(int newColour)
      {
            this.colour = newColour ; 
            this.points = 0 ;
      }
      

      public int getPoints()
      {
            return this.points ;
      }

      public void setPoints(int addPoint)
      {
            this.points += addPoint ;
      }
      public void writePlayerStats()
      {     
            if(this.colour == WHITE)
                  System.out.println("[PLAYER 1] (BEYAZ) Puani : " + this.getPoints());
            else if(this.colour == BLACK)
                  System.out.println("[PLAYER 2] (SIYAH) Puani : " + this.getPoints());
            else 
                  System.out.println("Bir hata var...");
      }
      public int getColour()
      {
            return this.colour ;
      }
}
