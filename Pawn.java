
/**
 * Write a description of class Piece here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pawn extends Pieces
{   
    protected String name;
    protected int row;
    protected String column;
    protected String color;

    public Pawn(String name,String color)
    {
        super(name,color);
        this.name = name;
        this.color = color;
    }
    
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getColor()
    {
        return color;
    }

    public boolean checkMove(Pieces [][] board, String iniPos, String finalPos, int counter)
    {
        int iniColumn = convertColumn(iniPos);
        int iniRow = convertRow(Integer.parseInt(iniPos.substring(1)));

        int finalColumn = convertColumn(finalPos);
        int finalRow = convertRow(Integer.parseInt(finalPos.substring(1)));  

        if ((iniPos.substring(1).equalsIgnoreCase("2") && color.equalsIgnoreCase("W")) )
        {
            if ( ((finalColumn- iniColumn == 1 && iniRow - finalRow == 1) && board[finalRow][finalColumn].getColor().equalsIgnoreCase("B" )  )
                    || ((iniColumn - finalColumn == 1 && iniRow - finalRow == 1) && board[finalRow][finalColumn].getColor().equalsIgnoreCase("B" ) ) )
            {
                return true;
            }
            else if (iniRow - finalRow == 2 && board[iniRow-1][finalColumn].getColor().equalsIgnoreCase("Blank") 
            && board[iniRow-2][finalColumn].getColor().equalsIgnoreCase("Blank") && !((finalColumn- iniColumn == 1 && iniRow - finalRow == 1)) 
            && !((iniColumn - finalColumn == 1 && iniRow - finalRow == 1)) )
            {
                return true;
            }
            else if (iniRow - finalRow == 1 && board[iniRow-1][finalColumn].getColor().equalsIgnoreCase("Blank") 
                && !((finalColumn- iniColumn == 1 && iniRow - finalRow == 1)) && !((iniColumn - finalColumn == 1 && iniRow - finalRow == 1)) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if((iniPos.substring(1).equalsIgnoreCase("7")  && color.equalsIgnoreCase("B")) ) 
        {
            if (( ((finalColumn- iniColumn == 1 && finalRow - iniRow == 1) && board[finalRow][finalColumn].getColor().equalsIgnoreCase("W" ) )
                || ((iniColumn - finalColumn == 1 && finalRow - iniRow == 1)) && board[finalRow][finalColumn].getColor().equalsIgnoreCase("W" ) ) )
            {
                return true;
            }
            else if (finalRow - iniRow == 2 && board[iniRow+1][finalColumn].getColor().equalsIgnoreCase("Blank") 
            && board[iniRow+2][finalColumn].getColor().equalsIgnoreCase("Blank") &&  !((finalColumn- iniColumn == 1 && finalRow - iniRow == 1))
            && !((iniColumn - finalColumn == 1 && finalRow - iniRow == 1)) )
            {
                return true;
            }
            else if (finalRow - iniRow == 1 && board[iniRow+1][finalColumn].getColor().equalsIgnoreCase("Blank") 
                &&  !((finalColumn- iniColumn == 1 && finalRow - iniRow == 1)) && !((iniColumn - finalColumn == 1 && finalRow - iniRow == 1)) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (board[iniRow][iniColumn].getColor().equalsIgnoreCase("W"))
        {
            if (( ((finalColumn- iniColumn == 1 && iniRow - finalRow == 1) && board[finalRow][finalColumn].getColor().equalsIgnoreCase("B" )
                    || ((iniColumn - finalColumn == 1 && iniRow - finalRow == 1)) && board[finalRow][finalColumn].getColor().equalsIgnoreCase("B" ) ) ) )
            {
                return true;
            }
            else if (iniRow - finalRow == 1 && board[iniRow-1][finalColumn].getColor().equalsIgnoreCase("Blank") 
                &&  !((finalColumn- iniColumn == 1 && iniRow - finalRow == 1)) && !((iniColumn - finalColumn == 1 && iniRow - finalRow == 1)) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (board[iniRow][iniColumn].getColor().equalsIgnoreCase("B"))
        {
            if (( ((finalColumn- iniColumn == 1 && finalRow - iniRow == 1) && board[finalRow][finalColumn].getColor().equalsIgnoreCase("W" ) )
                || ((iniColumn - finalColumn == 1 && finalRow - iniRow == 1)) && board[finalRow][finalColumn].getColor().equalsIgnoreCase("W" ) ) )
            {
                return true;
            }
            else if (finalRow - iniRow == 1 && board[iniRow+1][finalColumn].getColor().equalsIgnoreCase("Blank") 
                &&  !((finalColumn- iniColumn == 1 && finalRow - iniRow == 1)) && !((iniColumn - finalColumn == 1 && finalRow - iniRow == 1)) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public int convertColumn(String pos)
    {
        if (pos.substring(0,1).equalsIgnoreCase("A"))
        {
            return 0;
        }
        else if (pos.substring(0,1).equalsIgnoreCase("B"))
        {
            return 1;
        }
        else if (pos.substring(0,1).equalsIgnoreCase("C"))
        {
            return 2;
        }
        else if (pos.substring(0,1).equalsIgnoreCase("D"))
        {
            return 3;
        }
        else if (pos.substring(0,1).equalsIgnoreCase("E"))
        {
            return 4;
        }
        else if (pos.substring(0,1).equalsIgnoreCase("F"))
        {
            return 5;
        }
        else if (pos.substring(0,1).equalsIgnoreCase("G"))
        {
            return 6;
        }
        else
        {
            return 7;
        }        
    }

    public String unConvertColumn(int pos)
    {
        if (pos == 0)
        {
            return "A";
        }
        else if (pos == 1)
        {
            return "B";
        }
        else if (pos == 2)
        {
            return "C";
        }
        else if (pos == 3)
        {
            return "D";
        }
        else if (pos == 4)
        {
            return "E";
        }
        else if (pos == 5)
        {
            return "F";
        }
        else if (pos == 6)
        {
            return "G";
        }
        else
        {
            return "H";
        }        
    }

    public static int convertRow(int pos)
    {
        if (pos == 1)
        {
            return 7;
        }
        else if (pos == 2)
        {
            return 6;
        }
        else if (pos == 3)
        {
            return 5;
        }
        else if (pos == 4)
        {
            return 4;
        }
        else if (pos == 5)
        {
            return 3;
        }
        else if (pos == 6)
        {
            return 2;
        }
        else if (pos == 7)
        {
            return 1;
        }
        else
        {
            return 0;
        }        
    }

    public static int unConvertRow(int pos)
    {
        if (pos == 7)
        {
            return 1;
        }
        else if (pos == 6)
        {
            return 2;
        }
        else if (pos == 5)
        {
            return 3;
        }
        else if (pos == 4)
        {
            return 4;
        }
        else if (pos == 3)
        {
            return 5;
        }
        else if (pos == 2)
        {
            return 6;
        }
        else if (pos == 1)
        {
            return 7;
        }
        else
        {
            return 8;
        }        
    }
}
