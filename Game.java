
import java.util.Scanner ;
public class Game {
      public static final int BLACK = 0 ;
      public static final int WHITE = 1 ;
      private Board chessBoard ;
      private int currentPlayer ;


      public Game()
      {
            this.chessBoard = new Board(8,8);
            currentPlayer = WHITE ;
            this.chessBoard.setBoardReady();

      }
      
      public void scrollLeftTheBoard(Board chessBoard)
      {     
            for(int i = 0 ; i<this.chessBoard.getXOfChessBoard() ; i++) {
                  Item temp =  chessBoard.getItemAt(i, 0);
                  for(int j = 0 ; j<this.chessBoard.getYOfChessBoard() - 1; j++) {
                        this.chessBoard.setItemAt(i, j, this.chessBoard.getChessBoard()[i][j+1]);
                        if(chessBoard.getItemAt(i, j) != null)
                              this.chessBoard.getItemAt(i, j).refreshItem(i, j);
                  }
                  
                  this.chessBoard.setItemAt(i, 7, temp);
                  if(chessBoard.getItemAt(i, 7) != null)
                              this.chessBoard.getItemAt(i, 7).refreshItem(i, 7);
            }
     
      }
      


      public void writeTurn()
      {
            if(currentPlayer == WHITE)
                  System.out.println("Sira Beyazda. Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz.");
            else if(currentPlayer == BLACK)
                  System.out.println("Sira Siyahta. Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz.");     
      }

      public int getTurn()
      {
            return currentPlayer ;
      }

      public void switchTurn()
      {
            if(currentPlayer == BLACK)
                  currentPlayer = WHITE ;
            else 
                  currentPlayer = BLACK ;
      }
      
      public void run()
      {     
            Scanner keyboard = new Scanner(System.in);
           
            Player p1 = new Player(WHITE);
            Player p2 = new Player(BLACK);

            while(true)
            {     
                  this.chessBoard.showBoard();
                 
                  if(this.chessBoard.getSahSayisi() < 2)
                  {
                        if(currentPlayer == WHITE)
                        {
                              System.out.println("Siyah kazandi !");
                              p1.writePlayerStats();
                              p2.writePlayerStats();
                        }
                        else 
                        {
                              System.out.println("Beyaz kazandi !");
                              p1.writePlayerStats();
                              p2.writePlayerStats();
                        }
                        break ;
                  }


                  this.writeTurn();
                  int currentX , currentY ;
                  int aimX , aimY ;
                  Item target ;
                  while(true)
                  {
                        String temp = keyboard.nextLine();  
                        
                        if(temp.equals("exit"))
                        {
                              System.out.println("Exit komutu verildi oyun bitiriliyor.");
                              p1.writePlayerStats();
                              p2.writePlayerStats();
                              System.exit(0);
                        }
                        currentX =  temp.charAt(0) - 97 ;
                        currentY = temp.charAt(1) - 49 ;
                       
                        target = chessBoard.getItemAt(currentX, currentY);

                        aimX = temp.charAt(3) - 97 ;
                        aimY = temp.charAt(4) - 49 ;
                        


                        if(currentX<0 || currentX>8)
                        {
                              System.out.println("Hatali giris yapildi ! Tekrar Deneyiniz : ");
                              continue ;
                        }
                        if(currentY<0 || currentY>8)
                        {
                              System.out.println("Hatali giris yapildi ! Tekrar Deneyiniz : ");
                              continue ;
                        }
                        if(aimX<0 || aimX>8)
                        {
                              System.out.println("Hatali giris yapildi ! Tekrar Deneyiniz : ");
                              continue ;
                        }
                        if(aimY<0 || aimY>8)
                        {
                              System.out.println("Hatali giris yapildi ! Tekrar Deneyiniz : ");
                              continue ;
                        }
                        
                        if(target == null)
                        {
                              System.out.println("Hatali giris yapildi ! Tekrar Deneyiniz :");
                              continue ;
                        }

                        if(target.getColour() != currentPlayer)
                        {
                              System.out.println("Hatali giris yapildi ! Tekrar Deneyiniz : ");
                              continue ;
                        }
                        if(!target.canGoTo(aimX,aimY))
                        {
                              System.out.println("Hatali giris yapildi ! Tekrar Deneyiniz : ");
                              continue ;
                        }
                        
                        break ;
                  }
                  
                  if(target.canGoTo(aimX, aimY))
                  {     
                        if(currentPlayer == WHITE)
                        {     
                              Item temp1 ;
                              if(chessBoard.getItemAt(aimX, aimY) != null)
                              {
                                    temp1 = chessBoard.getItemAt(aimX, aimY);
                                    p1.setPoints(temp1.getPointsOfItem());
                              }
                             
                        }
                        else 
                        {     
                              Item temp2 ;
                              if(chessBoard.getItemAt(aimX, aimY) != null){
                                    temp2 = chessBoard.getItemAt(aimX, aimY);
                                    p2.setPoints(temp2.getPointsOfItem());
                              }
                              
                        }
                        target.moveTo(aimX, aimY);
                        
                  }
                  else 
                  {
                        System.out.println("bi sikinti var...");
                  }

                  this.chessBoard.showBoard();
                  System.out.println("Tur oynandi bu sekilde tamamlandi. Simdi tahta kaydiriliyor...");
                  

                  
                  this.scrollLeftTheBoard(chessBoard);
            
                  System.out.println("--------------------------------------------------------");
                  this.switchTurn();
            }

      
      } 
            
}



