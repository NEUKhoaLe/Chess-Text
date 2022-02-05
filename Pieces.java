public class Pieces
{
    protected String name;
    protected int row;
    protected String column;
    protected String color;

    public Pieces(String name, String color)
    {
        this.name = name;
        this.color = color;
    }

    public String getName()
    {
        return name;
    }
    
    public boolean checkMove(Pieces [][] array, String iniPos, String finalPos, int counter)
    {
        return true;
    }

    public String getColor()
    {
        return color;
    }
    
    public boolean legalMove(Pieces [][] array)
    {
        return true;
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
