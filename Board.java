public class Board {
      
      private Item[][] chessBoard ; // x , y 
      private int sahSayisi ;


      
      public Board(int x , int y)
      {
            this.chessBoard = new Item[x][y] ;
            this.sahSayisi = 2 ;
      }
      
      public int getSahSayisi()
      {
            return this.sahSayisi ;
      }

      public void setSahSayisi()
      {
            this.sahSayisi -= 1 ;            
      }

      

      public void setBoardReady()
      {   
           
            // WHITE PIECES
            this.chessBoard[0][0] = new Piyon(this,1,0,0);
            this.chessBoard[0][1] = new Piyon(this,1,0,1);
            this.chessBoard[0][2] = new Piyon(this,1,0,2);
            this.chessBoard[0][3] = new Piyon(this,1,0,3);
            this.chessBoard[0][4] = new Piyon(this,1,0,4);
            this.chessBoard[0][5] = new Piyon(this,1,0,5);
            this.chessBoard[0][6] = new Piyon(this,1,0,6);
            this.chessBoard[0][7] = new Piyon(this,1,0,7);

            this.chessBoard[1][0] = new Kale(this,1,1,0);
            this.chessBoard[1][7] = new Kale(this,1,1,7);

            this.chessBoard[1][1] = new At(this,1,1,1);
            this.chessBoard[1][6] = new At(this,1,1,6);

            this.chessBoard[1][2] = new Fil(this, 1, 1, 2);
            this.chessBoard[1][5] = new Fil(this,1,1,5);

            this.chessBoard[1][3] = new Vezir(this,1,1,3);
            this.chessBoard[1][4] = new Sah(this,1,1,4);

            // BLACK PIECES

            this.chessBoard[7][0] = new Piyon(this,0,7,0);
            this.chessBoard[7][1] = new Piyon(this,0,7,1);
            this.chessBoard[7][2] = new Piyon(this,0,7,2);
            this.chessBoard[7][3] = new Piyon(this,0,7,3);
            this.chessBoard[7][4] = new Piyon(this,0,7,4);
            this.chessBoard[7][5] = new Piyon(this,0,7,5);
            this.chessBoard[7][6] = new Piyon(this,0,7,6);
            this.chessBoard[7][7] = new Piyon(this,0,7,7);

            this.chessBoard[6][0] = new Kale(this,0,6,0);
            this.chessBoard[6][7] = new Kale(this,0,6,7);

            this.chessBoard[6][1] = new At(this,0,6,1);
            this.chessBoard[6][6] = new At(this,0,6,6);

            this.chessBoard[6][2] = new Fil(this,0,6,2);
            this.chessBoard[6][5] = new Fil(this,0,6,5);

            this.chessBoard[6][3] = new Vezir(this,0,6,3);
            this.chessBoard[6][4] = new Sah(this,0,6,4);
            
      }

      public boolean isPositionAvailable(int newX, int newY)
      {
            if(this.chessBoard[newX][newY] == null)
                  return true ;
            else
                  return false ;
      }
     

      public boolean isIndexInBounds(int newX, int newY)
      {
            if(newX< this.getXOfChessBoard() && newY < this.getYOfChessBoard() && newX >= 0 && newY >= 0)
                  return true ;
            else 
                  return false ;
      }


      public int getXOfChessBoard()
      {
            return (this.chessBoard[0]).length;
      }

      
      public int getYOfChessBoard()
      {
            return (this.chessBoard).length ;
      }


      public Item[][] getChessBoard()
      {
            return this.chessBoard ;
      }

      public Item getItemAt(int xPosition , int yPosition)
      {     
            if(this.isIndexInBounds(xPosition, yPosition))
                  return this.chessBoard[xPosition][yPosition] ;
            else 
                  return null ;
      }

      public void setItemAt(int xPosition , int yPosition , Item anItem)
      {
            this.chessBoard[xPosition][yPosition] = anItem ;
            
      }

      public void removeItem(Item anItem)
      {
            this.chessBoard[anItem.getX()][anItem.getY()] = null ;
      }

      public void placeItem(Item newItem , int newX , int newY)
      {
            if(isIndexInBounds(newX, newY) == true)
                  (this.chessBoard)[newX][newY] = newItem ;
      }

      public void showBoard()
      {    
           
            char ch = 'a';
            int sy = 1 ;
            System.out.print("      ");
            for(int i = 0 ; i<getYOfChessBoard(); i++)
            {
                  System.out.print(sy + "      ");
                  sy++ ;
            }
            System.out.println();
            
            for(int i = 0 ; i<getXOfChessBoard(); i++){
                  
                  System.out.print(ch + "     ");
                  ch++ ;
                  for(int j = 0 ; j<getYOfChessBoard(); j++){            
                        if(chessBoard[i][j] instanceof Kale){
                              if(chessBoard[i][j].getColour() == 0){
                                    System.out.print("k" + "      ");
                              }        
                              if(chessBoard[i][j].getColour() == 1){
                                    System.out.print("K" + "      ");
                              }       
                        }
                              
                        else if(chessBoard[i][j] instanceof At){
                              if(chessBoard[i][j].getColour() == 0)
                                    System.out.print("a" +  "      ");
                              if(chessBoard[i][j].getColour() == 1)
                                    System.out.print("A" +  "      ");
                        }
                              
                        else if(chessBoard[i][j] instanceof Fil){
                              if(chessBoard[i][j].getColour() == 0)
                                    System.out.print("f" + "      ");
                              if(chessBoard[i][j].getColour() == 1)
                                    System.out.print("F" + "      ");
                        }
                               
                        else if(chessBoard[i][j] instanceof Vezir){
                              if(chessBoard[i][j].getColour() == 0)
                                    System.out.print("v" + "      ");
                              if(chessBoard[i][j].getColour() == 1)
                                    System.out.print("V" + "      ");
                        }
                              
                        else if(chessBoard[i][j] instanceof Sah){
                              if(chessBoard[i][j].getColour() == 0)      
                                    System.out.print("s" + "      ");
                              if(chessBoard[i][j].getColour() == 1)
                                    System.out.print("S" + "      ");
                        }
                              
                        else if(chessBoard[i][j] instanceof Piyon){
                              if(chessBoard[i][j].getColour() == 0)
                                    System.out.print("p" + "      ");  
                              if(chessBoard[i][j].getColour() == 1)     
                                    System.out.print("P" + "      "); 
                        }
                                               
                        else 
                              System.out.print("-" + "      ");
                  }
                  System.out.println();
            }
                  

      }
}
