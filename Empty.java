

/**
 * Write a description of class Piece here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Empty extends Pieces
{   
    protected String name;
    protected int row;
    protected String column;
    protected String color;
    public Empty(String name, String color)
    {
        super(name,color);
        this.name = name;
        this.color = color;
    }

        public String getColor()
    {
        return color;
    }
    
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public void setName(String name)
    {
        this.name = name;
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
}
