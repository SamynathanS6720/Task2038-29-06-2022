import java.util.ArrayList;
import java.util.List;

public class AdventureGame {

    private List< List< ObjectInDungeon > > dungeon = new ArrayList < List < ObjectInDungeon > >() ;
    private int rowLength ;
    private int columnLenght ;
    private ObjectInDungeon goldBox = ObjectInDungeon.valueOf( "GOLD" ) ;
    private ObjectInDungeon AdventurerBox =  ObjectInDungeon.valueOf( "ADVENTURER" ) ;
    private ObjectInDungeon MonterBox = ObjectInDungeon.valueOf( "MONSTER" ) ;
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


    public boolean setPostionOfMoster( int rowNum , int columnNum ) {

        boolean rowNumValidate = ( rowNum < this.rowLength ) && ( rowNum >= 0 ) ;
        boolean columnNumValidate = ( columnNum < this.columnLenght ) && ( columnNum >= 0 ) ;

        if( rowNumValidate && columnNumValidate ){
            this.dungeon.get( rowNum ).set( columnNum , goldBox );
            this.MonterBox.setposition( rowNum , columnNum);
            return true ; 
        }
        else{
            return false ;
        }
    }

    public boolean setInitialPostionOfAdventurer( int rowNum , int columnNum ) {

        boolean rowNumValidate = ( rowNum < this.rowLength ) && ( rowNum >= 0 ) ;
        boolean columnNumValidate = ( columnNum < this.columnLenght ) && ( columnNum >= 0 ) ;

        if( rowNumValidate && columnNumValidate ){
            this.dungeon.get( rowNum ).set( columnNum , goldBox );
            this.AdventurerBox.setposition( rowNum , columnNum);
            return true ; 
        }
        else{
            return false ;
        }
    }


    public int getPathToTheGold( int AdventurerInizialRowNum , int AdventurerInizialColumnNum ){

        ObjectInDungeon currentDungeonBox = this.AdventurerBox ;

        int currentRow = currentDungeonBox.getRowNum() ,
            currentcolumn = currentDungeonBox.getColumn() ,
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
                // else if ( currentcolumn == this.goldBox.getColumn() ){
                //     return count ;
                // }
            }

            this.path.add( "(" + (currentRow +1 ) + "," + (currentcolumn + 1 ) + ")->" )   ;
            currentDungeonBox = this.dungeon.get( currentRow ).get( currentcolumn ) ;
        }while( currentDungeonBox != this.goldBox );

        return count + 1 ;
    }

    public String getPath() {

        return String.valueOf( this.path ) ;
    }



    // public int getPathToTheGoldWithoutDestroy( int AdventurerInizialRowNum , int AdventurerInizialColumnNum ){

    //     ObjectInDungeon currentDungeonBox = this.AdventurerBox ;

    //     int currentRow = AdventurerInizialRowNum ,
    //         currentcolumn = AdventurerInizialColumnNum ,
    //         count = -1 ;
        
    //     if( currentRow == this.goldBox.getRowNum() && currentcolumn == this.goldBox.getColumn() ){
    //         return 0 ; 
    //     }
    //     do{
    //         count = count + 1 ;
    //         if( currentRow < this.goldBox.getRowNum() && currentRow < this.rowLength ){
    //           currentRow = currentRow + 1;
    //         }
    //         else if( currentRow > this.goldBox.getRowNum() && currentRow >= 0  ){
    //             currentRow = currentRow - 1;
    //         }
    //         else if( currentRow == this.goldBox.getRowNum() ) {      
    //             if( currentcolumn > this.goldBox.getColumn() && currentcolumn >= 0 ){
    //                 currentcolumn = currentcolumn - 1;

    //             }
    //             else if( currentcolumn < this.goldBox.getColumn() && currentcolumn < this.columnLenght ){
    //                 currentcolumn = currentcolumn + 1;
    //             }
    //             // else if ( currentcolumn == this.goldBox.getColumn() ){
    //             //     return count ;
    //             // }
    //         }

    //         this.path.add( "(" + (currentRow +1 ) + "," + (currentcolumn + 1 ) + ")->" )   ;
    //         currentDungeonBox = this.dungeon.get( currentRow ).get( currentcolumn ) ;
    //     }while( currentDungeonBox != this.goldBox );

    //     return count + 1 ;
    // }
    



}