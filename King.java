
public class King extends Pieces
{
    protected String name;
    protected int row;
    protected String column;
    protected String color;

    Functions function = new Functions();
    public King(String name, String color)
    {
        super(name,color);
        this.name = name;
        this.color = color;
    }

    public boolean checkMove(Pieces [][] board, String iniPos, String finalPos, int counter)
    {
        int iniColumn = convertColumn(iniPos);
        int iniRow = convertRow(Integer.parseInt(iniPos.substring(1)) );

        int finalColumn = convertColumn(finalPos);
        int finalRow = convertRow(Integer.parseInt(finalPos.substring(1)));  

        if ( (iniRow + 1 == finalRow && iniColumn == finalColumn) && !board[finalRow][finalColumn].getColor().equalsIgnoreCase(color))
        {
            return true;
        }
        else if ( (iniRow - 1 == finalRow && iniColumn == finalColumn) && !board[finalRow][finalColumn].getColor().equalsIgnoreCase(color) )
        {
            return true;
        }
        else if ( (iniRow == finalRow && iniColumn + 1 == finalColumn) && !board[finalRow][finalColumn].getColor().equalsIgnoreCase(color) )
        {
            return true;
        }
        else if ( (iniRow == finalRow && iniColumn - 1 == finalColumn) && !board[finalRow][finalColumn].getColor().equalsIgnoreCase(color) )
        {
            return true;
        }
        else if ( (iniRow + 1 == finalRow && iniColumn + 1 == finalColumn) && !board[finalRow][finalColumn].getColor().equalsIgnoreCase(color) )
        {
            return true;
        }
        else if ( (iniRow + 1 == finalRow && iniColumn - 1 == finalColumn) && !board[finalRow][finalColumn].getColor().equalsIgnoreCase(color) )
        {
            return true;
        }
        else if ( (iniRow - 1 == finalRow && iniColumn + 1 == finalColumn) && !board[finalRow][finalColumn].getColor().equalsIgnoreCase(color) )
        {
            return true;
        }
        else if ( (iniRow - 1 == finalRow && iniColumn - 1 == finalColumn) && !board[finalRow][finalColumn].getColor().equalsIgnoreCase(color) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getColor()
    {
        return color;
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

    public void setColor(String color)
    {
        this.color = color;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
