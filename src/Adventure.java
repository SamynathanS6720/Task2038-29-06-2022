import java.util.ArrayList;
import java.util.List;

public class Adventure {

    private List< List< ObjectInDungeon > > dungeon = new ArrayList < List < ObjectInDungeon > >() ;
    private int rowLength ;
    private int columnLenght ;
    private ObjectInDungeon goldBox = ObjectInDungeon.valueOf( "GOLD" ) ;
    private List < String > path = new ArrayList< String >();

    enum ObjectInDungeon {
        ADVENTURER,
        GOLD,
        EMPTY ,
        MONSTER ,
        PITS ,
        TRRIGER ;

        private int rowNum ;
        private int columnNum ;

        public boolean setposition( int rowNum , int columnNum ){
            this.rowNum = rowNum ;
            this.columnNum = columnNum ;
            return true ;
        }

        public int getRowNum(){
            return this.rowNum ;
        }

        public int getColumn() {
            return this.columnNum ;
        }
    }

    public boolean createDungeon( int rowLen , int columnLen ){
        this.rowLength = rowLen ;
        this.columnLenght = columnLen ; 
        ObjectInDungeon EmptyDungeanBox = ObjectInDungeon.valueOf( "EMPTY" ) ; 

        int i = 0 ,
            j = 0 ;
        
        while( i < rowLen ){
            List < ObjectInDungeon > dungeonRow = new ArrayList< ObjectInDungeon >() ;
            while( j < columnLen ) {
                dungeonRow.add( EmptyDungeanBox ) ;
                j++ ;
            }
            j = 0  ;
            i++ ;
            this.dungeon.add( dungeonRow ) ;
        }
        return true ;
    }

    public boolean setPostionOfGold( int rowNum , int columnNum ) {

        boolean rowNumValidate = ( rowNum < this.rowLength ) && ( rowNum >= 0 ) ;
        boolean columnNumValidate = ( columnNum < this.columnLenght ) && ( columnNum >= 0 ) ;

        if( rowNumValidate && columnNumValidate ){
            this.dungeon.get( rowNum ).set( columnNum , goldBox );
            this.goldBox.setposition( rowNum , columnNum);
            return true ; 
        }
        else{
            return false ;
        }
    }

    public int getPathToTheGold( int AdventurerInizialRowNum , int AdventurerInizialColumnNum ){

        ObjectInDungeon currentDungeonBox = ObjectInDungeon.valueOf( "ADVENTURER" ) ;
    
        int currentRow = AdventurerInizialRowNum ,
            currentcolumn = AdventurerInizialColumnNum ,
            count = -1 ;
        
        if( currentRow == this.goldBox.getRowNum() && currentcolumn == this.goldBox.getColumn() ){
            return 0 ; 
        }
        do{
            count = count + 1 ;
            if( currentRow < this.goldBox.getRowNum() && currentRow < this.rowLength ){
              currentRow = currentRow + 1;
            }
            else if( currentRow > this.goldBox.getRowNum() && currentRow >= 0  ){
                currentRow = currentRow - 1;
            }
            else if( currentRow == this.goldBox.getRowNum() ) {      
                if( currentcolumn > this.goldBox.getColumn() && currentcolumn >= 0 ){
                    currentcolumn = currentcolumn - 1;

                }
                else if( currentcolumn < this.goldBox.getColumn() && currentcolumn < this.columnLenght ){
                    currentcolumn = currentcolumn + 1;
                }
                else if ( currentcolumn == this.goldBox.getColumn() ){
                    return count ;
                }
            }

            this.path.add( (currentRow +1 ) + "," + (currentcolumn + 1 ) + "->" )   ;
            // currentDungeonBox = this.dungeon.get( currentRow ).get( currentcolumn ) ;
        }while( currentDungeonBox != this.goldBox );

        return count ;
    }

    public String getPath() {

        return String.valueOf( this.path ) ;
    }


    // public int searchLeftToRight( int AdventurerCurrentRowNum , int AdventurerCurrentColumnNum ){

    //     ObjectInDungeon currentDungeonBox = ObjectInDungeon.valueOf( "ADVENTURER" ) ;
    
    //     int currentRow = AdventurerInizialRowNum ,
    //         currentcolumn = AdventurerInizialColumnNum ,
    //         count = -1 ;
    //     System.out.println( currentRow + "    " +  currentcolumn ) ;
    //     if( currentRow == this.goldBox.getRowNum() && currentcolumn == this.goldBox.getColumn() ){
    //         return 0 ; 
    //     }
    //     do{
    //         count = count + 1 ;
    //         if( currentRow < this.goldBox.getRowNum() && currentRow < this.rowLength ){
    //           currentRow = currentRow + 1;
    //             System.out.println( "test : 1 " + currentRow + "    " +  currentcolumn ) ;
    //         }
    //         else if( currentRow > this.goldBox.getRowNum() && currentRow >= 0  ){
    //             currentRow = currentRow - 1;
    //             System.out.println( "test : 2 " + currentRow + "    " +  currentcolumn ) ;
    //         }
    //         else if( currentRow == this.goldBox.getRowNum() ) {      
    //             if( currentcolumn > this.goldBox.getColumn() && currentcolumn >= 0 ){
    //                 currentcolumn = currentcolumn - 1;
    //             System.out.println( "test : 3 " + currentRow + "    " +  currentcolumn ) ;

    //             }
    //             else if( currentcolumn < this.goldBox.getColumn() && currentcolumn < this.columnLenght ){
    //                 currentcolumn = currentcolumn + 1;
    //                 System.out.println( "test : 4 " + currentRow + "    " +  currentcolumn ) ;
    //             }
    //             else if ( currentcolumn == this.goldBox.getColumn() ){
    //                 return count ;
    //             }
    //         }
    //         // currentDungeonBox = this.dungeon.get( currentRow ).get( currentcolumn ) ;
    //     }while( currentDungeonBox != this.goldBox );

    //     return count ;
    // }

}