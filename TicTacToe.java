// ICS 4U1
// TicTacToe
// Written by: Rameen Azmee
// Written for: Mrs. Ganesan
// Due date: April 12, 2021
// Submission date: April 12, 2021
// This program is a 1 versus 1 TicTacToe Game. There is a main menu where both players enter their names
// After the user presses start game it will use their names to indicate whose turn it is
// All rules are the same, i have also implemented tie
// There is a scoreboard at the bottom of the game frame
// A red line shows the path of X's or O's when someone wins
// Some important variables:
// nameone,nametwo:names of players
// restartchecker: equals 1 when someone wins, this way all functions are stopped until restart is clicked
// one,two...nine: these buttons names indicade the position on the tictactoe board
//

//*****EVERYTHING THAT WAS NOT TAUGHT IN CLASS******
//setIcon, sets a icon to a button, I figured it out by myself
//BUTTON BORDERS, changes borders of buttons website:https://www.tutorialspoint.com/how-can-we-apply-different-borders-to-jbutton-in-java#:~:text=We%20can%20set%20different%20borders,()%20method%20of%20JComponent%20class.
//
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener
{
    String nameone = "", nametwo = "";
    String name1, name2;
    int p1score = 0, p2score = 0, playerswitcher = 1, winner = 0, ties = 0, tiecounter = 0, restartchecker = 0;
    //COMPONENTS
    JLabel Prompting;
    JLabel P1win;
    JLabel P2win;
    JLabel tie;
    JTextField player1name = new JTextField (15);
    JTextField player2name = new JTextField (15);
    JButton one;
    JButton two;
    JButton three;
    JButton four;
    JButton five;
    JButton six;
    JButton seven;
    JButton eight;
    JButton nine;
    JButton submit = new JButton ("Start Game");
    ImageIcon x = new ImageIcon ("x.png");
    ImageIcon xvert = new ImageIcon ("xvertical.png");
    ImageIcon xhori = new ImageIcon ("xhorizontal.png");
    ImageIcon xdiagright = new ImageIcon ("xdiagonalright.png");
    ImageIcon xdiagleft = new ImageIcon ("xdiagonalleft.png");
    ImageIcon o = new ImageIcon ("o.png");
    ImageIcon overt = new ImageIcon ("overtical.png");
    ImageIcon ohori = new ImageIcon ("ohorizontal.png");
    ImageIcon odiagright = new ImageIcon ("odiagonalright.png");
    ImageIcon odiagleft = new ImageIcon ("odiagonalleft.png");
    ImageIcon tictactoe = new ImageIcon ("tictactoe.png");
    JLabel tictactoeimage = new JLabel (tictactoe);

    public TicTacToe (String title, int namingcheck, String name1, String name2)  // constructor
    {
	super (title);
	nameone = name1;
	nametwo = name2;
	if (namingcheck == 0) //This if statement will take it to the menu screen
	{
	    //INSTRUCTIONS:
	    JLabel firstline = new JLabel ("RULES FOR TIC-TAC-TOE:");
	    JLabel secondline = new JLabel ("•The game is played on a grid that's 3 by 3 squares");
	    JLabel thirdline = new JLabel ("•Player 1 is X, Player 2 is O");
	    JLabel fourthline = new JLabel ("•First Player to get 3 of their marks in a row(horizontally,vertically, or diagonally), wins!");
	    JLabel fifthline = new JLabel ("•When 9 squares is full, its a tie and game over");
	    JLabel sixthline = new JLabel ("•Press 'RESTART' to restart");
	    JPanel p1name = new JPanel (); //player 1 Name
	    JPanel p2name = new JPanel (); //player 2 name
	    JPanel names = new JPanel (); //both names in a panel
	    JPanel picture = new JPanel (); //for the picture
	    JPanel instructions = new JPanel (); //instructions
	    JLabel prompt1 = new JLabel ("PLAYER 1, enter your name here:");
	    JLabel prompt2 = new JLabel ("PLAYER 2, enter your name here:");
	    //layouts
	    instructions.setLayout (new BoxLayout (instructions, BoxLayout.Y_AXIS));
	    names.setLayout (new BoxLayout (names, BoxLayout.Y_AXIS));
	    picture.setLayout (new GridLayout (2, 0, 10, 10));
	    //FONTS
	    prompt1.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 27));
	    prompt2.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 27));
	    firstline.setFont (new Font ("Comic Sans", Font.BOLD, 30));
	    secondline.setFont (new Font ("Comic Sans", Font.BOLD, 18));
	    thirdline.setFont (new Font ("Comic Sans", Font.BOLD, 18));
	    fourthline.setFont (new Font ("Comic Sans", Font.BOLD, 18));
	    fifthline.setFont (new Font ("Comic Sans", Font.BOLD, 18));
	    sixthline.setFont (new Font ("Comic Sans", Font.BOLD, 18));
	    submit.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 100));
	    player1name.setFont (new Font ("Sanford", Font.BOLD, 25));
	    player2name.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 25));
	    //panel colour
	    instructions.setBackground (new Color (30, 60, 90));
	    p1name.setBackground (new Color (30, 60, 90));
	    p2name.setBackground (new Color (30, 60, 90));
	    names.setBackground (new Color (30, 60, 90));
	    picture.setBackground (new Color (30, 60, 90));
	    submit.setBackground (new Color (255, 128, 128));
	    //text colour
	    firstline.setForeground (new Color (255, 128, 128));
	    secondline.setForeground (new Color (255, 128, 128));
	    thirdline.setForeground (new Color (255, 128, 128));
	    fourthline.setForeground (new Color (255, 128, 128));
	    fifthline.setForeground (new Color (255, 128, 128));
	    sixthline.setForeground (new Color (255, 128, 128));
	    prompt1.setForeground (new Color (255, 128, 128));
	    prompt2.setForeground (new Color (255, 128, 128));
	    //Adding components
	    instructions.add (firstline);
	    instructions.add (secondline);
	    instructions.add (thirdline);
	    instructions.add (fourthline);
	    instructions.add (fifthline);
	    instructions.add (sixthline);
	    //instructions.add (submit);
	    names.add (p1name);
	    names.add (p2name);
	    //enter names panel
	    p1name.add (prompt1);
	    p1name.add (player1name);
	    p2name.add (prompt2);
	    p2name.add (player2name);
	    //Image panel
	    picture.add (tictactoeimage);
	    picture.add (submit);
	    //Output
	    getContentPane ().setLayout (new BorderLayout ());
	    getContentPane ().add (names, BorderLayout.NORTH);
	    getContentPane ().add (instructions, BorderLayout.CENTER);
	    getContentPane ().add (picture, BorderLayout.SOUTH);

	    getContentPane ().setBackground (new Color (30, 60, 90));
	    submit.addActionListener (this); //ActionListener
	}
	else   //This is the main game screen
	{
	    //setting numbers
	    one = new JButton ("1");
	    two = new JButton ("2");
	    three = new JButton ("3");
	    four = new JButton ("4");
	    five = new JButton ("5");
	    six = new JButton ("6");
	    seven = new JButton ("7");
	    eight = new JButton ("8");
	    nine = new JButton ("9");
	    // Button colours
	    one.setBackground (new Color (255, 255, 204));
	    two.setBackground (new Color (255, 255, 204));
	    three.setBackground (new Color (255, 255, 204));
	    four.setBackground (new Color (255, 255, 204));
	    five.setBackground (new Color (255, 255, 204));
	    six.setBackground (new Color (255, 255, 204));
	    seven.setBackground (new Color (255, 255, 204));
	    eight.setBackground (new Color (255, 255, 204));
	    nine.setBackground (new Color (255, 255, 204));
	    //PANELS
	    Prompting = new JLabel (name1 + ", it is your turn"); //Indicates whose turn it is
	    JButton restart = new JButton ("RESTART"); //restart
	    JPanel promptingPanel = new JPanel ();
	    promptingPanel.add (Prompting);
	    promptingPanel.add (restart);

	    JLabel pcehold2 = new JLabel (" "); //Place Holder
	    JPanel PlaceHolder2 = new JPanel ();
	    PlaceHolder2.add (pcehold2);

	    JLabel pcehold3 = new JLabel (" "); //Place Holder
	    JPanel PlaceHolder3 = new JPanel ();
	    PlaceHolder3.add (pcehold3);
	    //ScoreBoard--------------
	    JLabel P1textwin = new JLabel (name1 + "'s Wins:"); //ScoreBoard
	    JLabel P2textwin = new JLabel (name2 + "'s Wins:");
	    JLabel tietext = new JLabel ("Ties:");
	    String tempstr = "";
	    tempstr += p1score;
	    P1win = new JLabel (tempstr);
	    tempstr = "";
	    tempstr += p2score;
	    P2win = new JLabel (tempstr);
	    tempstr = "";
	    tempstr += ties;
	    tie = new JLabel (tempstr);
	    JPanel scoreboard = new JPanel ();
	    scoreboard.add (P1textwin);
	    scoreboard.add (P2textwin);
	    scoreboard.add (tietext);
	    scoreboard.add (P1win);
	    scoreboard.add (P2win);
	    scoreboard.add (tie);
	    //----------
	    JPanel panel = new JPanel (); //panel for the tictactoe tiles
	    //setting layouts
	    promptingPanel.setLayout (new FlowLayout ());
	    panel.setLayout (new GridLayout (3, 3, 15, 15));
	    scoreboard.setLayout (new GridLayout (0, 3, 20, 20));
	    //restart button colour
	    restart.setBackground (new Color (255, 13, 8));
	    //Tictactoe tiles
	    panel.add (one);
	    panel.add (two);
	    panel.add (three);
	    panel.add (four);
	    panel.add (five);
	    panel.add (six);
	    panel.add (seven);
	    panel.add (eight);
	    panel.add (nine);
	    //Background colour
	    promptingPanel.setBackground (new Color (255, 255, 204)); //Panel colour
	    PlaceHolder2.setBackground (new Color (255, 255, 204)); //Panel colour
	    PlaceHolder3.setBackground (new Color (255, 255, 204)); //Panel colour
	    scoreboard.setBackground (new Color (255, 255, 204)); //Panel colour
	    panel.setBackground (new Color (0, 8, 20)); //Panel colour
	    //FONTs
	    Prompting.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 50));
	    P1textwin.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 18));
	    P2textwin.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 18));
	    tietext.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 18));
	    P1win.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 18));
	    P2win.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 18));
	    tie.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 18));
	    restart.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 18));
	    one.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 1));
	    two.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 1));
	    three.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 1));
	    four.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 1));
	    five.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 1));
	    six.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 1));
	    seven.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 1));
	    eight.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 1));
	    nine.setFont (new Font ("HelveticaNeue-CondensedBlack", Font.BOLD, 1));
	    //Button borders, Found on internet, link is at top of program
	    one.setBorder (BorderFactory.createLineBorder (new Color (255, 255, 204)));
	    two.setBorder (BorderFactory.createLineBorder (new Color (255, 255, 204)));
	    three.setBorder (BorderFactory.createLineBorder (new Color (255, 255, 204)));
	    four.setBorder (BorderFactory.createLineBorder (new Color (255, 255, 204)));
	    five.setBorder (BorderFactory.createLineBorder (new Color (255, 255, 204)));
	    six.setBorder (BorderFactory.createLineBorder (new Color (255, 255, 204)));
	    seven.setBorder (BorderFactory.createLineBorder (new Color (255, 255, 204)));
	    eight.setBorder (BorderFactory.createLineBorder (new Color (255, 255, 204)));
	    nine.setBorder (BorderFactory.createLineBorder (new Color (255, 255, 204)));
	    //Output
	    getContentPane ().setLayout (new BorderLayout ());
	    getContentPane ().add (promptingPanel, BorderLayout.NORTH);
	    getContentPane ().add (panel, BorderLayout.CENTER);
	    getContentPane ().add (PlaceHolder2, BorderLayout.EAST);
	    getContentPane ().add (PlaceHolder3, BorderLayout.WEST);
	    getContentPane ().add (scoreboard, BorderLayout.SOUTH);
	    //ActionListeners
	    one.addActionListener (this);
	    two.addActionListener (this);
	    three.addActionListener (this);
	    four.addActionListener (this);
	    five.addActionListener (this);
	    six.addActionListener (this);
	    seven.addActionListener (this);
	    eight.addActionListener (this);
	    nine.addActionListener (this);
	    restart.addActionListener (this);
	}
	//exit on close
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed (ActionEvent evt)
    {
	if (evt.getActionCommand ().equals ("Start Game"))
	{
	    name1 = player1name.getText (); //names to be sent
	    name2 = player2name.getText ();
	    repaint ();
	    dispose ();
	    TicTacToe game = new TicTacToe ("TicTacToe", 1, name1, name2); //Creates a new frame with the saved names and begins game
	    game.setSize (900, 900);
	    game.setVisible (true);
	}
	else if (evt.getActionCommand ().equals ("RESTART")) //If user selects Restart
	{
	    Prompting.setText (nameone + ", it is your turn");
	    restartchecker = 0;
	    playerswitcher = 1;
	    winner = 0;
	    tiecounter = 0;
	    one.setIcon (null);
	    two.setIcon (null);
	    three.setIcon (null);
	    four.setIcon (null);
	    five.setIcon (null);
	    six.setIcon (null);
	    seven.setIcon (null);
	    eight.setIcon (null);
	    nine.setIcon (null);
	}
	else   //when selecting tiles on the tictactoe
	{
	    if (playerswitcher == 1) //when first player is playing
	    {
		playerswitcher = 2;

		if (evt.getActionCommand ().equals ("1")) //1st tile
		{
		    try
		    {
			if (one.getIcon ().equals (x) || one.getIcon ().equals (o)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 3;
			}
		    }
		    catch (NullPointerException exc)
		    {
			one.setIcon (x);
		    }
		}
		else if (evt.getActionCommand ().equals ("2")) //2nd tile
		{
		    try
		    {
			if (two.getIcon ().equals (x) || two.getIcon ().equals (o)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 3;

			}
		    }
		    catch (NullPointerException exc)
		    {
			two.setIcon (x);
		    }
		}
		else if (evt.getActionCommand ().equals ("3")) //third tile
		{
		    try
		    {
			if (three.getIcon ().equals (x) || three.getIcon ().equals (o)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 3;
			}
		    }
		    catch (NullPointerException exc)
		    {
			three.setIcon (x);
		    }
		}
		else if (evt.getActionCommand ().equals ("4")) //fourth tile
		{
		    try
		    {
			if (four.getIcon ().equals (x) || four.getIcon ().equals (o)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 3;
			}
		    }
		    catch (NullPointerException exc)
		    {
			four.setIcon (x);
		    }
		}
		else if (evt.getActionCommand ().equals ("5")) //fifth tile
		{
		    try
		    {
			if (five.getIcon ().equals (x) || five.getIcon ().equals (o)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 3;
			}
		    }
		    catch (NullPointerException exc)
		    {
			five.setIcon (x);
		    }
		}
		else if (evt.getActionCommand ().equals ("6")) //sixth tile
		{
		    try
		    {
			if (six.getIcon ().equals (x) || six.getIcon ().equals (o)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 3;
			}
		    }
		    catch (NullPointerException exc)
		    {
			six.setIcon (x);
		    }
		}
		else if (evt.getActionCommand ().equals ("7")) //seventh tile
		{
		    try
		    {
			if (seven.getIcon ().equals (x) || seven.getIcon ().equals (o)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 3;
			}
		    }
		    catch (NullPointerException exc)
		    {
			seven.setIcon (x);
		    }
		}
		else if (evt.getActionCommand ().equals ("8")) //eigth tile
		{
		    try
		    {
			if (eight.getIcon ().equals (x) || eight.getIcon ().equals (o)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 3;
			}
		    }
		    catch (NullPointerException exc)
		    {
			eight.setIcon (x);
		    }
		}
		else if (evt.getActionCommand ().equals ("9")) //ninth tile
		{
		    try
		    {
			if (nine.getIcon ().equals (x) || nine.getIcon ().equals (o)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 3;
			}
		    }
		    catch (NullPointerException exc)
		    {
			nine.setIcon (x);
		    }
		}
	    }
	    else if (playerswitcher == 2)
	    {
		playerswitcher = 1;
		if (evt.getActionCommand ().equals ("1")) //first tile
		{
		    try
		    {
			if (one.getIcon ().equals (o) || one.getIcon ().equals (x)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 4;
			}
		    }
		    catch (NullPointerException exc)
		    {
			one.setIcon (o);
		    }
		}
		else if (evt.getActionCommand ().equals ("2")) //second tile
		{
		    try
		    {
			if (two.getIcon ().equals (o) || two.getIcon ().equals (x)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 4;
			}
		    }
		    catch (NullPointerException exc)
		    {
			two.setIcon (o);
		    }
		}
		else if (evt.getActionCommand ().equals ("3")) //third tile
		{
		    try
		    {
			if (three.getIcon ().equals (o) || three.getIcon ().equals (x)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 4;
			}
		    }
		    catch (NullPointerException exc)
		    {
			three.setIcon (o);
		    }
		}
		else if (evt.getActionCommand ().equals ("4")) //fourth tile
		{
		    try
		    {
			if (four.getIcon ().equals (o) || four.getIcon ().equals (x)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 4;
			}
		    }
		    catch (NullPointerException exc)
		    {
			four.setIcon (o);
		    }
		}
		else if (evt.getActionCommand ().equals ("5")) //fifth tile
		{
		    try
		    {
			if (five.getIcon ().equals (o) || five.getIcon ().equals (x)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 4;
			}
		    }
		    catch (NullPointerException exc)
		    {
			five.setIcon (o);
		    }
		}
		else if (evt.getActionCommand ().equals ("6")) //sixth tile
		{
		    try
		    {
			if (six.getIcon ().equals (o) || six.getIcon ().equals (x)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 4;
			}
		    }
		    catch (NullPointerException exc)
		    {
			six.setIcon (o);
		    }
		}
		else if (evt.getActionCommand ().equals ("7")) //seventh tile
		{
		    try
		    {
			if (seven.getIcon ().equals (o) || seven.getIcon ().equals (x)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 4;
			}
		    }
		    catch (NullPointerException exc)
		    {
			seven.setIcon (o);
		    }
		}
		else if (evt.getActionCommand ().equals ("8")) //eigth tile
		{
		    try
		    {
			if (eight.getIcon ().equals (o) || eight.getIcon ().equals (x)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 4;
			}
		    }
		    catch (NullPointerException exc)
		    {
			eight.setIcon (o);
		    }
		}
		else if (evt.getActionCommand ().equals ("9")) //ninth tile
		{
		    try
		    {
			if (nine.getIcon ().equals (o) || nine.getIcon ().equals (x)) //If the that spot has already been taken, other wise the catch will let you select it
			{
			    playerswitcher = 4;
			}
		    }
		    catch (NullPointerException exc)
		    {
			nine.setIcon (o);
		    }
		}
	    }
	    if (playerswitcher == 1 && restartchecker == 0)
	    {
		tiecounter++;
		Prompting.setText (nameone + ", it's your turn");
	    }
	    else if (playerswitcher == 2 && restartchecker == 0)
	    {
		tiecounter++;
		Prompting.setText (nametwo + ", it's your turn");
	    }
	    else if (playerswitcher == 3 && restartchecker == 0)
	    {
		playerswitcher = 1;
		Prompting.setText ("Spot Already taken");

	    }
	    else if (playerswitcher == 4 && restartchecker == 0)
	    {
		playerswitcher = 2;
		Prompting.setText ("Spot Already taken");
	    }
	}
	winnerdetector ();
	repaint ();
    }


    public void winnerdetector ()  //DETECTS IF ONE OF THE PLAYERS HAVE WON
	//The detection happens by comparing the images(X and O), by rows, columns, and diagonals
    {
	//HORIZONTAL ROWS---------------------------(for X (player 1))
	try
	{
	    if (one.getIcon ().equals (x) && two.getIcon ().equals (x) && three.getIcon ().equals (x) && restartchecker == 0) //Top row is equal
	    {
		one.setIcon (xhori);
		two.setIcon (xhori);
		three.setIcon (xhori);
		winner = 1;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	try
	{
	    if (four.getIcon ().equals (x) && five.getIcon ().equals (x) && six.getIcon ().equals (x) && restartchecker == 0) //Mid row is equal
	    {
		four.setIcon (xhori);
		five.setIcon (xhori);
		six.setIcon (xhori);
		winner = 1;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	try
	{
	    if (seven.getIcon ().equals (x) && eight.getIcon ().equals (x) && nine.getIcon ().equals (x) && restartchecker == 0) //Bottom row is equal
	    {
		seven.setIcon (xhori);
		eight.setIcon (xhori);
		nine.setIcon (xhori);
		winner = 1;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	//VERTICAL ROWS---------------------------(for X (player 1))
	try
	{
	    if (one.getIcon ().equals (x) && four.getIcon ().equals (x) && seven.getIcon ().equals (x) && restartchecker == 0) //Left Column is equal
	    {
		one.setIcon (xvert);
		four.setIcon (xvert);
		seven.setIcon (xvert);
		winner = 1;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	try
	{
	    if (two.getIcon ().equals (x) && five.getIcon ().equals (x) && eight.getIcon ().equals (x) && restartchecker == 0) //Mid Column is equal
	    {
		two.setIcon (xvert);
		five.setIcon (xvert);
		eight.setIcon (xvert);
		winner = 1;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	try
	{
	    if (three.getIcon ().equals (x) && six.getIcon ().equals (x) && nine.getIcon ().equals (x) && restartchecker == 0) //Right Column is equal
	    {
		three.setIcon (xvert);
		six.setIcon (xvert);
		nine.setIcon (xvert);
		winner = 1;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	//DIAGONAL ROWS---------------------------(for X (player 1))
	try
	{
	    if (one.getIcon ().equals (x) && five.getIcon ().equals (x) && nine.getIcon ().equals (x) && restartchecker == 0) //Left Column is equal
	    {
		one.setIcon (xdiagleft);
		five.setIcon (xdiagleft);
		nine.setIcon (xdiagleft);
		winner = 1;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	try
	{
	    if (seven.getIcon ().equals (x) && five.getIcon ().equals (x) && three.getIcon ().equals (x) && restartchecker == 0) //Mid Column is equal
	    {
		seven.setIcon (xdiagright);
		five.setIcon (xdiagright);
		three.setIcon (xdiagright);
		winner = 1;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	//PLAYER 2---------------------------------------------------------------------------------------
	//HORIZONTAL ROWS---------------------------(for X (player 2))
	try
	{
	    if (one.getIcon ().equals (o) && two.getIcon ().equals (o) && three.getIcon ().equals (o) && restartchecker == 0) //Top row is equal
	    {
		one.setIcon (ohori);
		two.setIcon (ohori);
		three.setIcon (ohori);
		winner = 2;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	try
	{
	    if (four.getIcon ().equals (o) && five.getIcon ().equals (o) && six.getIcon ().equals (o) && restartchecker == 0) //Mid row is equal
	    {
		four.setIcon (ohori);
		five.setIcon (ohori);
		six.setIcon (ohori);
		winner = 2;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	try
	{
	    if (seven.getIcon ().equals (o) && eight.getIcon ().equals (o) && nine.getIcon ().equals (o) && restartchecker == 0) //Bottom row is equal
	    {
		seven.setIcon (ohori);
		eight.setIcon (ohori);
		nine.setIcon (ohori);
		winner = 2;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	//VERTICAL ROWS---------------------------(for X (player 2))
	try
	{
	    if (one.getIcon ().equals (o) && four.getIcon ().equals (o) && seven.getIcon ().equals (o) && restartchecker == 0) //Left Column is equal
	    {
		one.setIcon (overt);
		four.setIcon (overt);
		seven.setIcon (overt);
		winner = 2;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	try
	{
	    if (two.getIcon ().equals (o) && five.getIcon ().equals (o) && eight.getIcon ().equals (o) && restartchecker == 0) //Mid Column is equal
	    {
		two.setIcon (overt);
		five.setIcon (overt);
		eight.setIcon (overt);
		winner = 2;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	try
	{
	    if (three.getIcon ().equals (o) && six.getIcon ().equals (o) && nine.getIcon ().equals (o) && restartchecker == 0) //Right Column is equal
	    {
		three.setIcon (overt);
		six.setIcon (overt);
		nine.setIcon (overt);
		winner = 2;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	//DIAGONAL ROWS---------------------------(for X (player 2))
	try
	{
	    if (one.getIcon ().equals (o) && five.getIcon ().equals (o) && nine.getIcon ().equals (o) && restartchecker == 0) //Left Column is equal
	    {
		one.setIcon (odiagleft);
		five.setIcon (odiagleft);
		nine.setIcon (odiagleft);
		winner = 2;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	try
	{
	    if (seven.getIcon ().equals (o) && five.getIcon ().equals (o) && three.getIcon ().equals (o) && restartchecker == 0) //Mid Column is equal
	    {
		seven.setIcon (odiagright);
		five.setIcon (odiagright);
		three.setIcon (odiagright);
		winner = 2;
	    }
	}
	catch (NullPointerException exc)    //Occurs when a spot is not filled
	{
	}
	if (winner == 1 && restartchecker == 0)
	{
	    restartchecker = 1; //this means restart button needs to be clicked
	    Prompting.setText (nameone + " HAS WON");
	    p1score++;
	    String tempstr = "";
	    tempstr += p1score;
	    P1win.setText (tempstr);
	}
	else if (winner == 2 && restartchecker == 0)
	{
	    restartchecker = 1; //this means restart button needs to be clicked
	    Prompting.setText (nametwo + " HAS WON");
	    p2score++;
	    String tempstr = "";
	    tempstr += p2score;
	    P2win.setText (tempstr);
	}
	else if (tiecounter == 9 && restartchecker == 0)     //checks if it is a tie
	{
	    restartchecker = 1; //this means restart button needs to be clicked
	    Prompting.setText ("IT'S A TIE!");
	    try
	    {
		ties++;
		String tempstr = "";
		tempstr += ties;
		tie.setText (tempstr);
	    }
	    catch (NullPointerException exc)    //Occurs when a spot is not filled
	    {
	    }
	}
	winner = 0;

    }



    public static void main (String[] args)  //MAIN
    {
	TicTacToe game = new TicTacToe ("Setting Names", 0, "", ""); //This creates a frame where the the users names are asked
	game.setSize (900, 900);
	game.setVisible (true);
    }
}


