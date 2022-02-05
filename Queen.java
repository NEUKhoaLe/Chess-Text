
/**
 * Write a description of class Piece here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Queen extends Pieces
{   
    protected String name;
    protected int row;
    protected String column;
    protected String color;

    public Queen(String name,String color)
    {
        super(name,color);
        this.name = name;
        this.color = color;
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
        
        if (counter == 0)
        {
            counter = counter + 1;
            if (iniRow > finalRow && iniColumn == finalColumn)
            {
                if (iniRow -1 < 0)
                {
                    return false;
                }
                else
                {
                    iniRow = iniRow-1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
            }
            else if (iniRow < finalRow && iniColumn == finalColumn)
            {
                if (iniRow +1 > 7)
                {
                    return false;
                }
                else
                {
                    iniRow = iniRow+1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
            }
            else if (iniColumn > finalColumn && iniRow == finalRow)
            {
                if (iniColumn -1 < 0)
                {
                    return false;
                }
                else
                {
                    iniColumn = iniColumn - 1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
            }
            else if (iniColumn < finalColumn && iniRow == finalRow)
            {
                if (iniColumn + 1 > 7)
                {
                    return false;
                }
                else
                {
                    iniColumn = iniColumn+1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
            }
            else if ((iniRow > finalRow && iniColumn > finalColumn)  && (iniRow - finalRow) == (iniColumn-finalColumn) )
            {
                if ((iniRow - 1 < 0) || (iniColumn - 1 < 0))
                {
                    return false;
                }
                else
                {
                    iniRow = iniRow-1;
                    iniColumn = iniColumn - 1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
            }
            else if ((iniRow < finalRow && iniColumn < finalColumn)  && (finalRow - iniRow) == (finalColumn-iniColumn))
            {
                if ((iniRow + 1 > 7) || (iniColumn + 1 > 7))
                {
                    return false;
                }
                else
                {
                    iniRow = iniRow+1;
                    iniColumn = iniColumn + 1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
            }
            else if ((iniColumn > finalColumn && iniRow < finalRow) && (finalRow - iniRow) == (iniColumn-finalColumn))
            {
                if ((iniRow + 1 > 7) || (iniColumn - 1 < 0))
                {
                    return false;
                }
                else
                {
                    iniRow = iniRow+1;
                    iniColumn = iniColumn - 1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
            }
            else
            {
                if ((iniRow - 1 < 0) || (iniColumn + 1 > 7))
                {
                    return false;
                }
                else
                {
                    iniColumn = iniColumn+1;
                    iniRow = iniRow - 1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
            }
        }

        else if (iniColumn == finalColumn && iniRow == finalRow)
        {
            if (!board[iniRow][iniColumn].getColor().equalsIgnoreCase(color))
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
            if (iniRow > finalRow && iniColumn == finalColumn)
            {
                if (iniRow -1 < 0)
                {
                    return false;
                }
                else if ( board[iniRow][iniColumn].getColor().equalsIgnoreCase("Blank"))
                {
                    iniRow = iniRow-1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
                else
                {
                    return false;
                }
            }
            else if (iniRow < finalRow && iniColumn == finalColumn)
            {
                if (iniRow +1 > 7)
                {
                    return false;
                }
                else if ( board[iniRow][iniColumn].getColor().equalsIgnoreCase("Blank"))
                {
                    iniRow = iniRow+1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
                else
                {
                    return false;
                }
            }
            else if (iniColumn > finalColumn && iniRow == finalRow)
            {
                if (iniColumn -1 < 0)
                {
                    return false;
                }
                else if ( board[iniRow][iniColumn].getColor().equalsIgnoreCase("Blank"))
                {
                    iniColumn = iniColumn-1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
                else
                {
                    return false;
                }
            }
            else if (iniColumn < finalColumn && iniRow == finalRow)
            {

                if (iniColumn + 1 > 7)
                {
                    return false;
                }
                else if ( board[iniRow][iniColumn].getColor().equalsIgnoreCase("Blank"))
                {
                    iniColumn = iniColumn+1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
                else
                {
                    return false;
                }
            }
            if ((iniRow > finalRow && iniColumn > finalColumn)  && (iniRow - finalRow) == (iniColumn-finalColumn) )
            {
                if ((iniRow - 1 < 0) || (iniColumn - 1 < 0))
                {
                    return false;
                }
                else if ( board[iniRow][iniColumn].getColor().equalsIgnoreCase("Blank"))
                {
                    iniRow = iniRow-1;
                    iniColumn = iniColumn - 1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
                else
                {
                    return false;
                }
            }
            else if ((iniRow < finalRow && iniColumn < finalColumn)  && (finalRow - iniRow) == (finalColumn-iniColumn))
            {
                if ((iniRow + 1 > 7) || (iniColumn + 1 > 7))
                {
                    return false;
                }
                else if (board[iniRow][iniColumn].getColor().equalsIgnoreCase("Blank"))
                {
                    iniRow = iniRow+1;
                    iniColumn = iniColumn + 1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
                else
                {
                    return false;
                }
            }
            else if ((iniColumn > finalColumn && iniRow < finalRow) && (finalRow - iniRow) == (iniColumn-finalColumn))
            {
                if ((iniRow + 1 > 7) || (iniColumn - 1 < 0))
                {
                    return false;
                }
                else if (board[iniRow][iniColumn].getColor().equalsIgnoreCase("Blank"))
                {
                    iniColumn = iniColumn-1;
                    iniRow = iniRow +1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
                }
                else
                {
                    return false;
                }
            }
            else if ((iniColumn < finalColumn && iniRow > finalRow) && (iniRow - finalRow) == (finalColumn-iniColumn))
            {
                if ((iniRow - 1 < 0) || (iniColumn + 1 > 7))
                {
                    return false;
                }
                else if ( board[iniRow][iniColumn].getColor().equalsIgnoreCase("Blank"))
                {
                    iniColumn = iniColumn+1;
                    iniRow = iniRow - 1;

                    return checkMove(board, "" + unConvertColumn(iniColumn)+unConvertRow(iniRow),finalPos,counter);
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
    
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
}
