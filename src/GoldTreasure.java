
import java.io.IOException;
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
import java.lang.NumberFormatException;

public class GoldTreasure {

    public static void main( String[] args ) throws IOException {

        Adventure adventureObj = new Adventure() ;
        // BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) ) ;
        boolean flag = false ;

        System.out.println( "Dimensions of the dungeon(Row x Column) :" );
        do {
            try{ 
                // int rowLen = Integer.parseInt( reader.readLine() ) ;  
                // int columnLen = Integer.parseInt( reader.readLine() ) ;  
                // adventureObj.createDungeon( rowLen , columnLen ) ;
                adventureObj.createDungeon( 5 , 4 ) ;
                break ;
            }catch( NumberFormatException ex ){
                System.out.println( " Invalid Integer Value " );
            }
        }while( flag ) ;
        System.out.println( "Position of Gold :" );
        do {
            try{ 
                // int rownum = Integer.parseInt( reader.readLine() ) ;  
                // int columnnum = Integer.parseInt( reader.readLine() ) ;  
                // adventureObj.setPostionOfGold( rownum , columnnum ) ;
                adventureObj.setPostionOfGold( 0 , 3 ) ;
                break ;
            }catch( NumberFormatException ex ){
                System.out.println( " Invalid Integer Value " );
            }
        }while( flag ) ;

        int stepCounttoGoal = 0 ;

        System.out.println( "Position of Adventurer :" );
        do {
            try{ 
                // int rownum = Integer.parseInt( reader.readLine() ) ;  
                // int columnnum = Integer.parseInt( reader.readLine() ) ;  
                // stepCounttoGoal = adventureObj.getPathToTheGold( rownum , columnnum ) ;
                stepCounttoGoal = adventureObj.getPathToTheGold( 4 , 0 ) ;
                break ;
            }catch( NumberFormatException ex ){
                System.out.println( " Invalid Integer Value " );
            }
        }while( flag ) ;

        System.out.println(  "Minimum number of steps" + stepCounttoGoal ) ;
        System.out.println( "path" + adventureObj.getPath() ) ;

    } 

}
