
public class Functions
{

    public Functions()
    {

    }

    public Pieces [][] setUp(Pieces [][] board)
    {

        board[7][0] = new Rook("\u2656","W");
        board[7][7] = new Rook("\u2656","W");

        board[0][0] = new Rook("\u265C", "B");
        board[0][7] = new Rook("\u265C","B");

        board[7][1] = new Knight("\u2658","W");
        board[7][6] = new Knight("\u2658","W");

        board[0][1] = new Knight("\u265E","B");
        board[0][6] = new Knight("\u265E","B");

        board[7][2] = new Bishop("\u2657","W");
        board[7][5] = new Bishop("\u2657","W");

        board[0][2] = new Bishop("\u265D","B");
        board[0][5] = new Bishop("\u265D","B");

        board[7][3] = new Queen("\u2655","W");
        board[7][4] = new King("\u2654","W");

        board[0][3] = new Queen("\u265B","B");
        board[0][4] = new King("\u265A","B");

        for (int x  = 0; x < 8 ; x++)
        {
            board[1][x] = new Pawn("\u265F","B");
            board[6][x] = new Pawn("\u2659","W");
        }

        for (int x = 2; x < 6; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                board[x][y] = new Pieces(" ","blank");
            }
        }

        return board;
    }

    public void swapBoard()
    {
        Pieces temp;
    }

    public void printBoard(Pieces [][] board)
    {
        sopln("         A \t         B \t         C \t         D \t         E \t         F \t         G \t         H \t");
        sopln("  ------------------------------------------------------------------------------------------------------------------------------"); 

        for (int row = 0; row < 8; row++)
        {
            sop(""+(8-row) );
            for (int col = 0; col < 8; col++)
            {
                if (col != 0)
                {
                    sop("\t");
                }
                System.out.print("|\t" + board[row][col].getName());
            }
            sop("\t|");
            sopln("");
            sopln("");
            sopln("  ------------------------------------------------------------------------------------------------------------------------------");
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

    public int convertRow(int pos)
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

    public int unConvertRow(int pos)
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

    public Pieces [][] makeMove(Pieces [][] board, String iniPos, String finalPos)
    {
        int iniColumn = convertColumn(iniPos.substring(0,1));
        int iniRow = convertRow(Integer.parseInt(iniPos.substring(1)));

        int finalColumn = convertColumn(finalPos.substring(0,1));
        int finalRow = convertRow(Integer.parseInt(finalPos.substring(1)));

        if(board[finalRow][finalColumn].getName().equalsIgnoreCase("\u2654") || board[finalRow][finalColumn].getName().equalsIgnoreCase("\u265A") )
        {

        }
        else if (board[finalRow][finalColumn].getColor().equalsIgnoreCase("Blank"))
        {
            Pieces temp = board[finalRow][finalColumn];
            board[finalRow][finalColumn] = board[iniRow][iniColumn];
            board[iniRow][iniColumn] = temp;
        }   
        else
        {
            Pieces temp = new Pieces(" ", "Blank");
            board[finalRow][finalColumn] = board[iniRow][iniColumn];
            board[iniRow][iniColumn] = temp;
        }

        return board;
    }

    public boolean check(Pieces [][] board, int turn)
    {
        int iniRow  = 0;
        String iniColumn = "";
        String finalPos = "";
        for (int x  = 0; x < 8; x++)
        {
            for (int y  = 0; y < 8; y++)
            {
                if (turn % 2 == 0)
                {
                    if (board [x][y].getName().equalsIgnoreCase("\u2654"))
                    {
                        iniRow = unConvertRow(x);
                        iniColumn = unConvertColumn(y);
                    }
                }
                if (turn % 2  == 1)
                {
                    if (board [x][y].getName().equalsIgnoreCase("\u265A"))
                    {
                        iniRow = unConvertRow(x);
                        iniColumn = unConvertColumn(y);
                    }
                }
            }
        }

        finalPos = "" + iniColumn + iniRow;

        for (int x  = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (turn % 2 == 0)
                {
                    if (!board[x][y].getColor().equalsIgnoreCase("W") && !board[x][y].getColor().equalsIgnoreCase("blank"))
                    {
                        if (board[x][y].checkMove(board, "" + unConvertColumn(y)+ unConvertRow(x), finalPos,0) )
                        {
                            return true; 
                        }
                    }
                }
                else
                {
                    if (!board[x][y].getColor().equalsIgnoreCase("B") && !board[x][y].getColor().equalsIgnoreCase("blank"))
                    {
                        if (board[x][y].checkMove(board, "" + unConvertColumn(y)+ unConvertRow(x), finalPos,0) )
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean checkMate (Pieces [][] board, int turn)
    {
        if (validMove(board, turn) )
        {
            return false;
        }        
        else
        {
            return true;
        }
    }

    public boolean validMove (Pieces [][]board, int turn)
    {
        int iniRow  = 0;
        String iniColumn = "";
        String iniPos = "";

        int finalRow  = 0;
        String finalColumn = "";
        String finalPos = "";

        if (turn % 2  == 0)
        {
            for (int x  = 0; x < 8; x++)
            {
                for (int y = 0; y < 8; y++)
                {
                    if (board[x][y].getColor().equalsIgnoreCase("W")  )
                    {
                        iniRow = unConvertRow(x);
                        iniColumn = unConvertColumn(y);

                        iniPos = "" + iniColumn + iniRow;

                        for (int a = 0; a < 8; a++)
                        {
                            for (int b = 0; b < 8; b++)
                            {
                                finalRow = unConvertRow(a);
                                finalColumn = unConvertColumn(b);

                                finalPos = "" + finalColumn + finalRow;

                                Pieces [][] tempBoard = copyBoard(board); //copies board onto a temporary board.
                                tempBoard = makeMove(tempBoard,iniPos,
                                    finalPos );

                                if (a == x && b == y)
                                {
                                }
                                else if (check(board,turn) == true && check(tempBoard,turn) == true)
                                {
                                }
                                else if (board[x][y].checkMove(board, iniPos,
                                    "" + finalPos, 0)) // check whether it is a legal move.
                                {
                                    return true;
                                }
                                else
                                {
                                }                          

                            }
                        }

                    }
                    else
                    {
                    }
                }
            }
        }

        else
        {
            for (int x  = 0; x < 8; x++)
            {
                for (int y = 0; y < 8; y++)
                {
                    if (board[x][y].getColor().equalsIgnoreCase("B") )
                    {
                        iniRow = unConvertRow(x);
                        iniColumn = unConvertColumn(y);

                        iniPos = "" + iniColumn + iniRow;

                        for (int a = 0; a < 8; a++)
                        {
                            for (int b = 0; b < 8; b++)
                            {
                                finalRow = unConvertRow(a);
                                finalColumn = unConvertColumn(b);

                                finalPos = "" + finalColumn + finalRow;

                                Pieces [][] tempBoard = copyBoard(board); //copies board onto a temporary board.
                                tempBoard = makeMove(tempBoard,iniPos,
                                    finalPos );

                                if (a == x && b == y)
                                {
                                }
                                else if (check(board,turn) == true && check(tempBoard,turn) == true)
                                {
                                }
                                else if (board[x][y].checkMove(board, iniPos,
                                    "" + finalPos, 0)) // check whether it is a legal move.
                                {
                                    return true;
                                }
                                else
                                {
                                }      
                            }
                        }
                    }
                    else
                    {
                    }
                }
            }
        }
        return false;
    }

    public boolean castleCheck(Pieces [][] board,String kind, int counter)
    {
        Pieces [][] tempBoard = board;

        if (counter % 2 == 0)
        {
            if (kind.equalsIgnoreCase("O-O"))
            {
                if (!tempBoard[7][4].checkMove(tempBoard, "" + unConvertColumn(4) + unConvertRow(7), "" + unConvertColumn(5) + unConvertRow(7), 0))
                {
                    return false;
                }

                tempBoard = makeMove(tempBoard,"" + unConvertColumn(4) + unConvertRow(7), "" + unConvertColumn(5) + unConvertRow(7));

                if (check(tempBoard, counter) == true)
                {                
                    return false;
                }

                if (!tempBoard[7][5].checkMove(tempBoard, "" + unConvertColumn(5) + unConvertRow(7), "" + unConvertColumn(6) + unConvertRow(7), 0))
                {
                    return false;
                }

                tempBoard = makeMove(tempBoard,"" + unConvertColumn(5) + unConvertRow(7), "" + unConvertColumn(6) + unConvertRow(7));

                if (check(tempBoard, counter) == true)
                {
                    return false;
                }

                return true;
            }
            else if (kind.equalsIgnoreCase("O-O-O"))
            {
                if (!tempBoard[7][4].checkMove(tempBoard, "" + unConvertColumn(4) + unConvertRow(7), "" + unConvertColumn(3) + unConvertRow(7), 0))
                {
                    return false;
                }

                tempBoard = makeMove(tempBoard,"" + unConvertColumn(4) + unConvertRow(7), "" + unConvertColumn(3) + unConvertRow(7));

                if (check(tempBoard, counter) == true)
                {                
                    return false;
                }

                if (!tempBoard[7][3].checkMove(tempBoard, "" + unConvertColumn(3) + unConvertRow(7), "" + unConvertColumn(2) + unConvertRow(7), 0))
                {
                    return false;
                }

                tempBoard = makeMove(tempBoard,"" + unConvertColumn(3) + unConvertRow(7), "" + unConvertColumn(2) + unConvertRow(7));

                if (check(tempBoard, counter) == true)
                {
                    return false;
                }
                return true;
            }
            else
            {
                return false;
            }
        }        
        else 
        {
            if (kind.equalsIgnoreCase("O-O"))
            {
                if (!tempBoard[0][4].checkMove(tempBoard, "" + unConvertColumn(4) + unConvertRow(0), "" + unConvertColumn(5) + unConvertRow(0), 0))
                {
                    return false;
                }

                tempBoard = makeMove(tempBoard,"" + unConvertColumn(4) + unConvertRow(0), "" + unConvertColumn(5) + unConvertRow(0));

                if (check(tempBoard, counter) == true)
                {                
                    return false;
                }

                if (!tempBoard[0][5].checkMove(tempBoard, "" + unConvertColumn(5) + unConvertRow(0), "" + unConvertColumn(6) + unConvertRow(0), 0))
                {
                    return false;
                }

                tempBoard = makeMove(tempBoard,"" + unConvertColumn(5) + unConvertRow(0), "" + unConvertColumn(6) + unConvertRow(0));

                if (check(tempBoard, counter) == true)
                {
                    return false;
                }

                return true;
            }
            else if (kind.equalsIgnoreCase("O-O-O"))
            {
                if (!tempBoard[0][4].checkMove(tempBoard, "" + unConvertColumn(4) + unConvertRow(0), "" + unConvertColumn(3) + unConvertRow(0), 0))
                {
                    return false;
                }

                tempBoard = makeMove(tempBoard,"" + unConvertColumn(4) + unConvertRow(0), "" + unConvertColumn(3) + unConvertRow(0));

                if (check(tempBoard, counter) == true)
                {                
                    return false;
                }

                if (!tempBoard[0][3].checkMove(tempBoard, "" + unConvertColumn(3) + unConvertRow(0), "" + unConvertColumn(2) + unConvertRow(0), 0))
                {
                    return false;
                }

                tempBoard = makeMove(tempBoard,"" + unConvertColumn(3) + unConvertRow(0), "" + unConvertColumn(2) + unConvertRow(0));

                if (check(tempBoard, counter) == true)
                {
                    return false;
                }
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    
    public Pieces [][] copyBoard(Pieces [][] board)
    {
        Pieces [][] tempBoard = new Pieces[8][8];

        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                tempBoard [x][y] = board [x][y];
            }
        }

        return tempBoard;
    }

    public void sop(String x)
    {
        System.out.print(x);
    }

    public void sopln(String x)
    {
        System.out.println(x);
    }
}
