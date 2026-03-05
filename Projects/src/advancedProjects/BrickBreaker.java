package advancedProjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*; // for handling input events

import javax.swing.JFrame;
import javax.swing.JOptionPane;
// graphic components
import javax.swing.JPanel;
import javax.swing.Timer;

// create a panel where i can paint, implements event listener for click and reply to game loop
public class BrickBreaker extends JPanel implements KeyListener, ActionListener {

//	Game settings
	private boolean inGame = true; // if false game stops
	private int score = 0; // variable for the score
	private int level = 1; // variable for levels
	private int totalBricks = 21; // 3 rows * 7 columns
	
//	Timer for the game loop
	private Timer timer;
	private int delay = 8; // timer speed
	
//	Position and movement
	private int paddleX = 310; // horizontal paddle position 
	private int ballX = paddleX + 40; // position x of the ball at the center of the paddle
	private int ballY = 530; // position y of the ball on the paddle
	private int ballDX = -1; // horizontal direction (-1 left, 1 right)
	private int ballDY = -2; // vertical direction (-2 up, 2 down)
	
	private int[][] map; // blocks grid
	private final int rows = 3; // starter rows of bricks
	private final int columns = 7; // columns of bricks
	
	private boolean gameBegin = false;
	
//	Constructor
	public BrickBreaker() {
		initLevel(); // Initialize the first level
		addKeyListener(this); // tell the panel to watch for key presses
		setFocusable(true); // let the panel capture keyboard focus
		setFocusTraversalKeysEnabled(false); // stop the tab key from changing focus
		timer = new Timer(delay, this); // create the timer that triggers actionPerformed
		timer.start(); // start the game loop
	}
	
//	Initialize the first level
	private void initLevel() {
		int currentRows = rows + (level - 1); // add one row for each level
		map = new int[currentRows][columns]; // Initialize the grid
		totalBricks = currentRows * columns;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = 1; // 1 means the brick is visible
			}
		}	
	}
	
//	Restart method
	public void restartGame(boolean win) {
		if (win) {
			level++;
//			increment ball speed
			ballDX = (ballDX > 0) ? ballDX + 1 : ballDX - 1;
			ballDY = (ballDY > 0) ? ballDY + 1 : ballDY - 1;
		} else {
//			if user loses, reset to level one conditions
			level = 1; 
			score = 0;
			ballDX = -1;
			ballDY = -2;
		}
		
		initLevel();
		paddleX = 310;
		ballX = paddleX + 40;
		ballY = 530;
		gameBegin = false;
		inGame = true;
		timer.start();
	}

//	Drawing method
	public void paint(Graphics g) {
		g.setColor(Color.black); // choose the black color for the background
		g.fillRect(1, 1, 692, 592); // color the entire background
		
//		Drawing bricks
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < columns; j++) {
				if (map[i][j] > 0) { // if brick value is 1 then draw it
					if (i == 0) g.setColor(Color.red);
					else if (i == 1) g.setColor(Color.orange);
					else if (i == 1) g.setColor(Color.yellow);
					else g.setColor(Color.white);
//					Position: spacing of 80px horizzontally and 50px vertically
//					75px of length; 30px of height; j is the index of the column, * 80 means that every new block starts 80px next the previously, + 70 is the left offset; i is the row index, * 35 means that every next line goes down by 50px, + 50 is the upper offset
					g.fillRect(j * 80 + 70, i * 35 + 50, 75, 30);
				}
			}
		}
		
//		Paddle = green, ball = yellow
		g.setColor(Color.green);
		g.fillRect(paddleX, 550, 100, 8);
		
		g.setColor(Color.yellow);
		g.fillOval(ballX, ballY, 20, 20);
		
//		Score, Game over and win messages
		g.setColor(Color.white);
		g.setFont(new Font("Quantico", Font.BOLD, 20));
		g.drawString("Score: " + score, 590, 30);
		
//		end-of-game control
		if (ballY > 570 || totalBricks <= 0) {
			checkGameOver(g);
		}
		
		g.dispose(); // clean graphic resources
		
	}
		
	private void checkGameOver(Graphics g) {
		timer.stop();
		inGame = false;
		String msg = (totalBricks <= 0) ? "LEVEL COMPLETED!!" : "GAME OVER";
		
		int choice = JOptionPane.showConfirmDialog(this, msg + "\nDo you want to keep playing?", "End game", JOptionPane.YES_NO_OPTION);
		
		if (choice == JOptionPane.YES_OPTION) {
			restartGame(totalBricks <= 0);
		} else {
			System.exit(0);
		}
	}

//	Game logic
	@Override
	public void actionPerformed(ActionEvent e) {
		if (inGame) {
			
			if (gameBegin) {
				ballX += ballDX;
				ballY += ballDY;
				
//				paddle collision: check if the ball rectangle touches the paddle rectangle
				if (new Rectangle(ballX, ballY, 20, 20).intersects(new Rectangle(paddleX, 550, 100, 8))) {
					ballDY = -ballDY; // bounce up
				}
				
//				brick collision
				A: for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < columns; j++) {
						if (map[i][j] > 0) {
							Rectangle rect = new Rectangle(j * 80 + 70, i * 35 + 50, 75, 30);
	                        Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);
	                        if (ballRect.intersects(rect)) { // if the ball touches a brick
								map[i][j] = 0; // destroy the brick
								totalBricks--;
								score += 5;
								ballDY = -ballDY; // bounce up the ball
								break A; // stop checking other bricks for this frame
							}
						}
					}
				}
				
//				Side walls
				if (ballX < 0 || ballX > 670) {
					ballDX = -ballDX;
				}
//				Ceiling
				if (ballY < 0) {
					ballDY = -ballDY;
				}
		
			} else {
				ballX = paddleX + 40;
				ballY = 530;
			}
			
		}
		repaint(); // Re-trigger the paint method to update the screen
	}
	
//	User input and main window
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // the right arrow
			if (paddleX < 580) {
				paddleX += 20;
			}
			gameBegin = true; // game starts as soon as user moves
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) { // the left arrow
			if (paddleX > 10) {
				paddleX -= 20;
			}
			gameBegin = true; // game starts as soon as user moves
		}
	}
	
//	Required by KeyListener but not used
	@Override public void keyReleased(KeyEvent e) {}
	@Override public void keyTyped(KeyEvent e) {}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame(); // create the actual window
		frame.add(new BrickBreaker()); // add the game in the frame
		frame.setBounds(10, 10, 700, 600); // configure the window
		frame.setTitle("Brick Breaker Game");
		frame.setResizable(false); // user can't resize the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the program when user press the X of the window
		frame.setVisible(true); // makes the window visible on the screen
	}
}
