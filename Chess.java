
import java.util.*;
public class Chess
{

    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);

        Pieces [][] board = new Pieces [8][8]; // initiate global chess board

        sopln("Today you will be playing chess. Enter your name.");

        Functions function = new Functions();

        String player1 = scan.nextLine();
        String input = null;

        int iniRow = 0;
        int iniColumn  = 0;

        int finalRow = 0;
        int finalColumn  = 0;
        boolean gameEnd = false;
        boolean legal = false;

        boolean BQRook = false;
        boolean BKRook = false;
        boolean WQRook = false;
        boolean WKRook = false;

        boolean BKing = false;
        boolean WKing = false;

        boolean WPromotion  = false;
        boolean BPromotion = false;

        boolean [] enPassantW = new boolean [8];
        boolean [] enPassantB = new boolean [8];

        int [] enCounterW = new int [8];
        int [] enCounterB = new int [8];

        for (int x = 0; x < 8; x++)
        {
            enPassantW[x] = false;
            enPassantB[x] = false;
        }

        for (int x = 0; x < 8; x++)
        {
            enCounterW[x] = 0;
            enCounterB[x] = 0;
        }

        sopln("Enter the other person's name.");

        String player2 = scan.nextLine();

        function.setUp(board); // call the class that sets up the board.

        int counter = 0;

        int turn = (int)(Math.random()*2+1); // determines who go first as white.

        if (turn % 2 == 1)
        {
            String temp = player1;
            player1 = player2;
            player2 = temp;
        }

        while (gameEnd == false) // if gameEnd is false, the game will continue. After every legal move, the board will check for mates and stalemates, or also a
        {                        // resign, then gameEnd will be true;

            sopln(player1 + " will play white, and " + player2 + " will play black.");

            function.printBoard(board); // prints the board

            if (counter%2 == 0) // begins the counter. When counter is divisible by 2, it is white's turn.
            {
                while (legal == false) // if the move is illegal, it loops back through to the beginning, asking them for inputs.
                {
                    sopln("Move a piece. For example, A2, 'enter' then A4. For Castling, do O-O for King side castling or O-O-O for queen side castling. 'Resign' for resign.");

                    input = scan.nextLine();

                    if (input.equalsIgnoreCase("Resign"))
                    {
                        counter = counter + 1;
                        legal = true;
                        gameEnd = true;
                    }
                    else if (input.equalsIgnoreCase("O-O"))
                    {
                        if (function.check(board, counter))
                        {
                            sopln("you are currently in check. You can't castle.");
                            legal = false;
                        }
                        else if (function.castleCheck(board, "O-O", counter) == false)
                        {
                            sopln("you will be in check. You can't castle.");
                            legal = false;
                        }
                        else if (WKRook == true || WKing == true)
                        {
                            sopln("You already Move your King/Rook.");
                            legal = false;
                        }
                        else
                        {
                            legal = true;
                        }
                    }

                    else if (input.equalsIgnoreCase("O-O-O"))
                    {
                        if (function.check(board, counter))
                        {
                            sopln("you are currently in check. You can't castle.");
                            legal = false;
                        }
                        else if (function.castleCheck(board, "O-O-O", counter) == false)
                        {
                            sopln("you will be in check. You can't castle.");
                            legal = false;
                        }
                        else if (WQRook == true || WKing == true)
                        {
                            sopln("You already Move your King/Rook.");
                            legal = false;
                        }
                        else
                        {
                            legal = true;
                        }
                    }

                    else
                    {
                        iniColumn = function.convertColumn(input.substring(0,1));
                        iniRow = function.convertRow(Integer.parseInt(input.substring(1)));

                        while(iniColumn > 7 || iniRow > 7 || iniColumn < 0 || iniRow < 0 || !board[iniRow][iniColumn].getColor().equalsIgnoreCase("W"))
                        {   // if the input is out of bounds or is not a white color piece, loops back through.
                            sopln("No piece exists, out of bounds, or wrong color. Try again.");
                            input = scan.nextLine();

                            iniColumn = function.convertColumn(input.substring(0,1));
                            iniRow = function.convertRow(Integer.parseInt(input.substring(1)));

                        }

                        sopln("Now do the second move.");

                        input = scan.nextLine();
                        finalColumn = function.convertColumn(input.substring(0,1));
                        finalRow = function.convertRow(Integer.parseInt(input.substring(1)));

                        while(finalColumn > 7 || finalRow > 7 || finalColumn < 0 || finalRow < 0) // does not check for color this time because function.checkMove
                        {                                                                         // covers for this.
                            sopln("No piece exists or out of bounds. Try again.");
                            input = scan.nextLine();

                            finalColumn = function.convertColumn(input.substring(0,1));
                            finalRow = function.convertRow(Integer.parseInt(input.substring(1)));
                        }

                        if (board[iniRow][iniColumn].getName().equalsIgnoreCase("\u2659") 
                        && board[finalRow+1][finalColumn].getName().equalsIgnoreCase("\u265F") && (iniColumn + 1 == finalColumn || iniColumn - 1 == finalColumn)
                        && iniRow - 1 == finalRow)
                        {
                            if (enPassantB[finalColumn] == true && enCounterB[finalColumn] == 0)
                            {
                                legal = true;

                                board[finalRow][finalColumn] = board[iniRow][iniColumn];
                                board[finalRow+1][finalColumn] = new Pieces (" ", "Blank");

                            }
                            else
                            {
                                sopln("You can't en passant.");
                                legal = false;
                            }
                        }
                        else if (board[iniRow][iniColumn].checkMove(board, "" + function.unConvertColumn(iniColumn)+function.unConvertRow(iniRow),
                            "" + function.unConvertColumn(finalColumn)+function.unConvertRow(finalRow), 0)) // check whether it is a legal move.
                        {
                            Pieces [][] tempBoard = function.copyBoard(board); //copies board onto a temporary board.

                            tempBoard = function.makeMove(tempBoard, "" + function.unConvertColumn(iniColumn)+function.unConvertRow(iniRow),
                                "" + function.unConvertColumn(finalColumn)+function.unConvertRow(finalRow) );

                            if (function.check(board,counter) == true && function.check(tempBoard,counter) == true)
                            {
                                sopln("You are in check, try again.");
                                legal = false;
                            }
                            else
                            {
                                legal = true;

                                if (enPassantW[iniColumn] == true)
                                {
                                    enCounterW[iniColumn] = 1;
                                }

                                if (board[iniRow][iniColumn].getName().equalsIgnoreCase("\u2659") && iniRow == 6)
                                {
                                    enPassantW[iniColumn] = true;
                                }

                                else if (board[iniRow][iniColumn].getName().equalsIgnoreCase("\u2656") )
                                {
                                    if (iniColumn == 8)
                                    {
                                        WKRook = true;
                                    }
                                    else if (iniColumn == 0)
                                    {
                                        WQRook = true;
                                    }
                                }
                                else if (board[iniRow][iniColumn].getName().equalsIgnoreCase("\u2654") )
                                {
                                    if (iniColumn == 4)
                                    {
                                        WKing = true;
                                    }
                                }
                            }
                        }
                        else
                        {
                            sopln("Illegal move. Try again.");
                            legal = false;
                        }
                    }
                }

                if (input.equalsIgnoreCase("Resign"))
                {
                    sopln(player2 + " wins by resign!");
                }
                else if (input.equalsIgnoreCase("O-O") || input.equalsIgnoreCase("O-O-O"))
                {
                    if (input.equalsIgnoreCase("O-O"))
                    {
                        board = function.makeMove(board, ""+ function.unConvertColumn(4)+function.unConvertRow(7),
                            ""+function.unConvertColumn(6)+function.unConvertRow(7));

                        board = function.makeMove(board, ""+ function.unConvertColumn(7)+function.unConvertRow(7),
                            ""+function.unConvertColumn(5)+function.unConvertRow(7));

                        WKing = true;
                        WKRook = true;
                    }
                    else
                    {
                        board = function.makeMove(board, ""+ function.unConvertColumn(4)+function.unConvertRow(7),
                            ""+function.unConvertColumn(2)+function.unConvertRow(7));

                        board = function.makeMove(board, ""+ function.unConvertColumn(0)+function.unConvertRow(7),
                            ""+function.unConvertColumn(3)+function.unConvertRow(7));

                        WKing = true;
                        WQRook = true;
                    }
                }
                else
                {
                    board = function.makeMove(board, "" + function.unConvertColumn(iniColumn)+function.unConvertRow(iniRow),
                        "" + function.unConvertColumn(finalColumn)+function.unConvertRow(finalRow) );

                    if (board[finalRow][finalColumn].getName().equalsIgnoreCase("\u2659") && finalRow == 0)
                    {
                        WPromotion = true;
                    }
                }

                function.printBoard(board);

                while (WPromotion == true)
                {
                    sopln("You have to promote your pawn.");
                    sopln("Enter 'Rook' if you want to promote to a Rook.");
                    sopln("Enter 'Bishop' if you want to promote to a Bishop.");
                    sopln("Enter 'Knight' if you want to promote to a Knight.");
                    sopln("Enter 'Queen' if you want to promote to a Queen.");

                    input = scan.nextLine();

                    if (input.equalsIgnoreCase("Rook"))
                    {
                        board[finalRow][finalColumn] = new Rook ("u\2656", "W");
                        WPromotion = false;
                        function.printBoard(board);
                    }
                    else if (input.equalsIgnoreCase("Bishop"))
                    {
                        board[finalRow][finalColumn] = new Bishop ("u\2657", "W");
                        WPromotion = false;
                        function.printBoard(board);
                    }
                    else if (input.equalsIgnoreCase("Knight"))
                    {
                        board[finalRow][finalColumn] = new Knight ("u\2658", "W");
                        WPromotion = false;
                        function.printBoard(board);
                    }
                    else if (input.equalsIgnoreCase("Queen"))
                    {
                        board[finalRow][finalColumn] = new Queen ("u\2655", "W");
                        WPromotion = false;
                        function.printBoard(board);
                    }
                    else
                    {
                        sopln("You have not enter a viable piece. Try again.");
                        function.printBoard(board);
                    }
                }
                legal = false;
                counter++;

                if (function.checkMate(board, counter) == true && function.check(board,counter) == true )
                {
                    sopln("You mated " + player2 + "!");
                    counter = counter + 1;

                    sopln("Do you want to play again? Enter 'Yes' for yes and 'No' for no. ");

                    input = scan.nextLine();

                    if (input.equalsIgnoreCase("Yes"))
                    {
                        function.setUp(board);
                    }

                    else
                    {
                        gameEnd = true;
                    }
                }
                else if (function.checkMate(board, counter) == true && !function.check(board,counter) == true )
                {
                    sopln("It is a stalemate.");
                    counter = counter + 1;

                    sopln("Do you want to play again? Enter 'Yes' for yes and 'No' for no. ");

                    input = scan.nextLine();

                    if (input.equalsIgnoreCase("Yes"))
                    {
                        board = function.setUp(board);
                    }

                    else
                    {
                        gameEnd = true;
                    }
                }
            }
            else
            {
                while (legal == false)
                {
                    sopln("Move a piece. For example, A2, 'enter' then A4. For Castling, do O-O for King side castling or O-O-O for queen side castling. 'Resign' to resign.");

                    input = scan.nextLine();

                    if (input.equalsIgnoreCase("Resign"))
                    {
                        counter = counter + 1;
                        legal = true;
                        gameEnd = true;
                    }

                    else if (input.equalsIgnoreCase("O-O"))
                    {
                        if (function.check(board, counter))
                        {
                            sopln("you are currently in check. You can't castle.");
                            legal = false;
                        }
                        else if (function.castleCheck(board, "O-O", counter) == false)
                        {
                            sopln("you will be in check. You can't castle.");
                            legal = false;
                        }
                        else if (BKRook == true || BKing == true)
                        {
                            sopln("You already move your Rook/King.");
                            legal = false;
                        }
                        else
                        {
                            legal = true;
                        }
                    }

                    else if (input.equalsIgnoreCase("O-O-O"))
                    {
                        if (function.check(board, counter))
                        {
                            sopln("you are currently in check. You can't castle.");
                            legal = false;
                        }
                        else if (function.castleCheck(board, "O-O-O", counter) == false)
                        {
                            sopln("you will be in check. You can't castle.");
                            legal = false;
                        }
                        else if (BQRook == true || BKing == true)
                        {
                            sopln("You already move your Rook/King.");
                            legal = false;
                        }
                        else
                        {
                            legal = true;
                        }
                    }
                    else
                    {
                        iniColumn = function.convertColumn(input.substring(0,1));
                        iniRow = function.convertRow(Integer.parseInt(input.substring(1)));

                        while(iniColumn > 7 || iniRow > 7 || iniColumn < 0 || iniRow < 0 ||!board[iniRow][iniColumn].getColor().equalsIgnoreCase("B"))
                        {
                            sopln("No piece exists, out of bounds, or wrong color. Try again.");
                            input = scan.nextLine();

                            iniColumn = function.convertColumn(input.substring(0,1));
                            iniRow = function.convertRow(Integer.parseInt(input.substring(1)));

                        }

                        sopln("Now do the second move.");

                        input = scan.nextLine();
                        finalColumn = function.convertColumn(input.substring(0,1));
                        finalRow = function.convertRow(Integer.parseInt(input.substring(1)));

                        while(finalColumn > 7 || finalRow > 7 || finalColumn < 0 || finalRow < 0)
                        {
                            sopln("No piece exists or out of bounds. Try again.");
                            input = scan.nextLine();

                            finalColumn = function.convertColumn(input.substring(0,1));
                            finalRow = function.convertRow(Integer.parseInt(input.substring(1)));
                        }

                        if (board[iniRow][iniColumn].getName().equalsIgnoreCase("\u265F") 
                        && board[finalRow-1][finalColumn].getName().equalsIgnoreCase("\u2659") && (iniColumn + 1 == finalColumn || iniColumn - 1 == finalColumn)
                        && iniRow + 1 == finalRow)
                        {
                            if (enPassantW[finalColumn] == true && enCounterW[finalColumn] == 0)
                            {
                                legal = true;

                                board = function.makeMove(board, "" + function.unConvertColumn(iniColumn)+function.unConvertRow(iniRow),
                                    "" + function.unConvertColumn(finalColumn)+function.unConvertRow(finalRow) );

                                board[finalRow][finalColumn] = board[iniRow][iniColumn];
                                board[finalRow-1][finalColumn] = new Pieces (" ", "Blank");

                            }
                            else
                            {
                                sopln("You can't en passant.");
                                legal = false;
                            }
                        }
                        else if (board[iniRow][iniColumn].checkMove(board, "" + function.unConvertColumn(iniColumn)+function.unConvertRow(iniRow),
                            "" + function.unConvertColumn(finalColumn)+function.unConvertRow(finalRow), 0))
                        {
                            Pieces [][] tempBoard = function.copyBoard(board);
                            tempBoard = function.makeMove(tempBoard, "" + function.unConvertColumn(iniColumn)+function.unConvertRow(iniRow),
                                "" + function.unConvertColumn(finalColumn)+function.unConvertRow(finalRow) );

                            if (function.check(board,counter) == true && function.check(tempBoard,counter) == true)
                            {
                                sopln("You are in check, try again.");
                                legal = false;
                            }
                            else
                            {
                                legal = true;

                                if (enPassantB[iniColumn] == true)
                                {
                                    enCounterB[iniColumn] = 1;
                                }

                                if (board[iniRow][iniColumn].getName().equalsIgnoreCase("\u265F") && iniRow == 1)
                                {
                                    enPassantB[iniColumn] = true;
                                }
                                else if (board[iniRow][iniColumn].getName().equalsIgnoreCase("\u265C") )
                                {
                                    if (iniColumn == 8)
                                    {
                                        BKRook = true;
                                    }
                                    else if (iniColumn == 0)
                                    {
                                        BQRook = true;
                                    }
                                }
                                else if (board[iniRow][iniColumn].getName().equalsIgnoreCase("\u265A") )
                                {
                                    if (iniColumn == 4)
                                    {
                                        BKing = true;
                                    }
                                }
                            }
                        }
                        else
                        {
                            sopln("Illegal move. Try again.");
                            legal = false;
                        }
                    }
                }

                if (input.equalsIgnoreCase("Resign"))
                {
                    sopln(player1 + " wins by resign!");
                }
                else if (input.equalsIgnoreCase("O-O") || input.equalsIgnoreCase("O-O-O"))
                {
                    if (input.equalsIgnoreCase("O-O"))
                    {
                        board = function.makeMove(board, ""+ function.unConvertColumn(4)+function.unConvertRow(0),
                            ""+function.unConvertColumn(6)+function.unConvertRow(0));

                        board = function.makeMove(board, ""+ function.unConvertColumn(7)+function.unConvertRow(0),
                            ""+function.unConvertColumn(5)+function.unConvertRow(0));

                        BKRook = true;
                        BKing = true;
                    }
                    else
                    {
                        board = function.makeMove(board, ""+ function.unConvertColumn(4)+function.unConvertRow(0),
                            ""+function.unConvertColumn(2)+function.unConvertRow(0));

                        board = function.makeMove(board, ""+ function.unConvertColumn(0)+function.unConvertRow(0),
                            ""+function.unConvertColumn(3)+function.unConvertRow(0));

                        BQRook = true;
                        BKing = true;
                    }
                }
                else
                {
                    board = function.makeMove(board, "" + function.unConvertColumn(iniColumn)+function.unConvertRow(iniRow),
                        "" + function.unConvertColumn(finalColumn)+function.unConvertRow(finalRow) );

                    if (board[finalRow][finalColumn].getName().equalsIgnoreCase("\u265F") && finalRow == 7)
                    {
                        BPromotion = true;
                    }
                }

                function.printBoard(board);
                
                while (BPromotion == true)
                {
                    sopln("You have to promote your pawn.");
                    sopln("Enter 'Rook' if you want to promote to a Rook.");
                    sopln("Enter 'Bishop' if you want to promote to a Bishop.");
                    sopln("Enter 'Knight' if you want to promote to a Knight.");
                    sopln("Enter 'Queen' if you want to promote to a Queen.");

                    input = scan.nextLine();

                    if (input.equalsIgnoreCase("Rook"))
                    {
                        board[finalRow][finalColumn] = new Rook ("u\265C", "B");
                        WPromotion = false;
                        function.printBoard(board);
                    }
                    else if (input.equalsIgnoreCase("Bishop"))
                    {
                        board[finalRow][finalColumn] = new Bishop ("u\265D", "B");
                        WPromotion = false;
                        function.printBoard(board);
                    }
                    else if (input.equalsIgnoreCase("Knight"))
                    {
                        board[finalRow][finalColumn] = new Knight ("u\265E", "B");
                        WPromotion = false;
                        function.printBoard(board);
                    }
                    else if (input.equalsIgnoreCase("Queen"))
                    {
                        board[finalRow][finalColumn] = new Queen ("u\265B", "B");
                        WPromotion = false;
                        function.printBoard(board);
                    }
                    else
                    {
                        sopln("You have not enter a viable piece. Try again.");
                        function.printBoard(board);
                    }
                }
                
                legal = false;
                counter++;

                if (function.checkMate(board, counter) == true && function.check(board,counter) == true )
                {
                    sopln("You mated " + player1 + "!");
                    counter = counter + 1;

                    sopln("Do you want to play again? Enter 'Yes' for yes and 'No' for no. ");

                    input = scan.nextLine();

                    if (input.equalsIgnoreCase("Yes"))
                    {
                        function.setUp(board);
                    }

                    else
                    {
                        gameEnd = true;
                    }
                }
                else if (function.checkMate(board, counter) == true && !function.check(board,counter) == true )
                {
                    sopln("It is a stalemate.");
                    counter = counter + 1;

                    sopln("Do you want to play again? Enter 'Yes' for yes and 'No' for no. ");

                    input = scan.nextLine();

                    if (input.equalsIgnoreCase("Yes"))
                    {
                        function.setUp(board);
                    }

                    else
                    {
                        gameEnd = true;
                    }
                }
            }
        }

    }

    public static void sop(String x)
    {
        System.out.print(x);
    }

    public static void sopln(String x)
    {
        System.out.println(x);
    }

}

