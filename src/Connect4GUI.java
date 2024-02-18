import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Connect4GUI extends JFrame {

    public Connect4GUI() {
        setTitle("Connect Four Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        JPanel mainPanel = new JPanel(new BorderLayout());

        createMenu(mainPanel);
        createPlayerInfoPanel(mainPanel);
        createBackgroundPanel(mainPanel);
        createMessageBoxPanel(mainPanel);

        getContentPane().add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    

    private void createMenu(JPanel mainPanel) {
        JMenuBar menuBar = new JMenuBar();

        // Game menu
        JMenu gameMenu = new JMenu("Game");
        JMenuItem startItem = new JMenuItem("Start");
        JMenuItem restartItem = new JMenuItem("Restart");
        JMenuItem quitItem = new JMenuItem("Quit");

        // Add ActionListener for Game submenu items
        startItem.addActionListener(e -> {
            // Handle Start game action
            JOptionPane.showMessageDialog(null, "Game started");
        });
        restartItem.addActionListener(e -> {
            // Handle Restart game action
            JOptionPane.showMessageDialog(null, "Game restarted");
        });
        quitItem.addActionListener(e -> {
            // Handle Quit game action
            JOptionPane.showMessageDialog(null, "Game quit");
        });

        gameMenu.add(startItem);
        gameMenu.add(restartItem);
        gameMenu.add(quitItem);
        menuBar.add(gameMenu);
        
     // Language menu
        JMenu languageMenu = new JMenu("Language");
        JMenuItem englishItem = new JMenuItem("English");
        JMenuItem frenchItem = new JMenuItem("French");
        JMenuItem hindiItem = new JMenuItem("Hindi");

        // Add ActionListener for Language submenu items
        englishItem.addActionListener(e -> {
            // Handle English language selection
            JOptionPane.showMessageDialog(null, "Language: English");
        });
        frenchItem.addActionListener(e -> {
            // Handle French language selection
            JOptionPane.showMessageDialog(null, "Language: French");
        });

        languageMenu.add(englishItem);
        languageMenu.add(frenchItem);
        menuBar.add(languageMenu);

        // Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem helpItem = new JMenuItem("Help");

        // Add ActionListener for Help menu item
        helpItem.addActionListener(e -> {
            // Handle Help menu item click
            JOptionPane.showMessageDialog(null, "Help contents...");
        });

        helpMenu.add(helpItem);
        menuBar.add(helpMenu);

        // Player menu
        JMenu playerMenu = new JMenu("Player");
        JMenuItem playerNameItem = new JMenuItem("Player's Name");

        // Add ActionListener for Player menu item
        playerNameItem.addActionListener(e -> {
            // Handle Player's Name menu item click
            JOptionPane.showMessageDialog(null, "Player's Name");
        });

        playerMenu.add(playerNameItem);
        menuBar.add(playerMenu);

        mainPanel.add(menuBar, BorderLayout.NORTH);
    }
    

    private void createPlayerInfoPanel(JPanel mainPanel) {
        JPanel rightPanel = new JPanel();
        JPanel additionalLabelsPanel = new JPanel();
        
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        additionalLabelsPanel.setLayout(new BoxLayout(additionalLabelsPanel, BoxLayout.Y_AXIS));
        
        JLabel turnLabel = new JLabel("Jeet's Turn");
        turnLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        turnLabel.setFont(new Font(turnLabel.getFont().getName(), Font.PLAIN, 25));
        turnLabel.setBorder(BorderFactory.createEmptyBorder(0, 70, 60, 20));
        
        JLabel timerLabel = new JLabel("Timer: 22s");
        timerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        timerLabel.setFont(new Font(timerLabel.getFont().getName(), Font.PLAIN, 15));
        timerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        
        JLabel gameTimerLabel = new JLabel("Game Timer: 2m 3s ");
        gameTimerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        gameTimerLabel.setFont(new Font(gameTimerLabel.getFont().getName(), Font.PLAIN, 15));
        gameTimerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        
        JLabel roundLabel =  new JLabel("Move Played ");
        roundLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        roundLabel.setFont(new Font(roundLabel.getFont().getName(), Font.PLAIN, 15));
        roundLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 3, 0));
        
        JLabel playerMsgLabel =  new JLabel("Jeet Has Played Column 2. ");
        playerMsgLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerMsgLabel.setFont(new Font(playerMsgLabel.getFont().getName(), Font.PLAIN, 13));
        playerMsgLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Create a message box Panel where all the sent messages will be displayed
        JPanel messageDisplayBox = new JPanel();
        messageDisplayBox.setBackground(Color.GRAY);
        messageDisplayBox.setPreferredSize(new Dimension(200, 5));
        
        JLabel additionalLabel1 = new JLabel("Jeet");
        additionalLabel1.setAlignmentX(Component.LEFT_ALIGNMENT);
        additionalLabel1.setFont(new Font(additionalLabel1.getFont().getName(), Font.PLAIN, 15));
        additionalLabel1.setBorder(BorderFactory.createEmptyBorder(90, 0, 10, 0));
        
        // Adding disc in front of Jeet
        JLabel redCircleLabel1 = createFilledCircleLabel(Color.RED);
        additionalLabel1.setIcon(new ImageIcon(createFilledCircleImage(Color.RED)));
        additionalLabel1.setHorizontalTextPosition(SwingConstants.RIGHT);
        additionalLabel1.setIconTextGap(5);

        JLabel additionalLabel2 = new JLabel("Aman");
        additionalLabel2.setAlignmentX(Component.LEFT_ALIGNMENT);
        additionalLabel2.setFont(new Font(additionalLabel2.getFont().getName(), Font.PLAIN, 15));
        additionalLabel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        
        // adding disc in front of Aman
        JLabel yellowCircleLabel2 = createFilledCircleLabel(Color.YELLOW);
        additionalLabel2.setIcon(new ImageIcon(createFilledCircleImage(Color.YELLOW)));
        additionalLabel2.setHorizontalTextPosition(SwingConstants.RIGHT);
        additionalLabel2.setIconTextGap(5);
        
        rightPanel.add(turnLabel);
        rightPanel.add(timerLabel);
        rightPanel.add(gameTimerLabel);
        rightPanel.add(roundLabel);
        rightPanel.add(playerMsgLabel);
        rightPanel.add(messageDisplayBox); 
        
        additionalLabelsPanel.add(additionalLabel1);
        additionalLabelsPanel.add(additionalLabel2);
        
        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BorderLayout());
        combinedPanel.add(rightPanel, BorderLayout.WEST);
        combinedPanel.add(additionalLabelsPanel, BorderLayout.EAST);
        
        mainPanel.add(combinedPanel, BorderLayout.EAST);
    }

  
    private static JLabel createFilledCircleLabel(Color color) {
        JLabel circleLabel = new JLabel();
        circleLabel.setPreferredSize(new Dimension(10, 10));
        circleLabel.setOpaque(true);
        circleLabel.setBackground(color);
        return circleLabel;
    }


    private Image createFilledCircleImage(Color color) {
        BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(color);
        g2d.fillOval(0, 0, 10, 10);
        g2d.dispose();
        return image;
    }


    private void createBackgroundPanel(JPanel mainPanel) {	
        // Create the background panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawText(g);
            }
        };
        backgroundPanel.setPreferredSize(new Dimension(450, 400));
        mainPanel.add(backgroundPanel, BorderLayout.WEST);

        // Create the game board panel
        JPanel gameBoardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                createGameBoard(g);
            }
        };
        
     // Make the game board panel transparent
        gameBoardPanel.setOpaque(false);  
        gameBoardPanel.setPreferredSize(new Dimension(250, 250)); 

        // Add the game board panel to the background panel
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(gameBoardPanel, BorderLayout.SOUTH);
     // Adjust the layout and margins of the background panel to reduce the size from the right side
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(gameBoardPanel, BorderLayout.SOUTH);
        
        // Ensure the background panel is visible
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    

    private void createGameBoard(Graphics g) {
        int cellSize = 40; 
        int rows = 6;
        int cols = 7;

       //Array to represent game state
        int[][] gameState = {
            {0, 0, 0, 0, 0, 0, 0},  
            {0, 0, 0, 0, 0, 0, 0},  
            {0, 0, 0, 0, 0, 0, 0}, 
            {0, 0, 1, 0, 0, 0, 2},  
            {0, 0, 2, 2, 1, 2, 1},  
            {0, 1, 2, 1, 2, 1, 1}   
        };

        // Draw circles and color them based on the gameState
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * cellSize + (cellSize / 2) - 20;  
                int y = row * cellSize + (cellSize / 2) - 20;
                
                //if gameState[row][col] == 1, fill the circle with red, if it's 2, fill it with yellow
                if (gameState[row][col] == 1) {
                    g.setColor(Color.RED);
                    g.fillOval(x, y, 40, 40);
                } else if (gameState[row][col] == 2) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x, y, 40, 40);
                } else {
                    // If no token in this position, fill it with white
                    g.setColor(Color.WHITE);
                    g.fillOval(x, y, 40, 40);
                }
            }
        }
    }


    private void drawText(Graphics g) {
    	
        g.setColor(Color.BLUE.darker());
        int backgroundWidth = 500;
        int backgroundHeight = 450;
        g.fillRect(0, 0, backgroundWidth, backgroundHeight);

        // Draw "Connect" text with filled "O"
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 35));
        String text1 = "Connect";
        int textWidth1 = g.getFontMetrics().stringWidth(text1);
        int x1 = 50;
        int y1 = 50 + g.getFontMetrics().getAscent();
        g.drawString(text1.substring(0, 1), x1, y1);
        g.fillOval(x1 + g.getFontMetrics().charWidth('C'), y1 - g.getFontMetrics().getAscent() + g.getFontMetrics().getDescent(), 30, 30);
        g.drawString(text1.substring(2, text1.length()), x1 + g.getFontMetrics().charWidth('C') + 30, y1);

        // Draw "Four" text with filled "O"
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        String text2 = "Four";
        int textWidth2 = g.getFontMetrics().stringWidth(text2);
        int x2 = 50;
        int y2 = y1 + g.getFontMetrics().getHeight();
        g.drawString(text2.substring(0, 1), x2, y2);
        g.fillOval(x2 + g.getFontMetrics().charWidth('F'), y2 - g.getFontMetrics().getAscent() + g.getFontMetrics().getDescent(), 25, 25);
        g.drawString(text2.substring(2, text2.length()), x2 + g.getFontMetrics().charWidth('F') + 25, y2);
    }
    
    private void createMessageBoxPanel(JPanel mainPanel) {
        JPanel messageBoxPanel = new JPanel(new BorderLayout());
        JTextField messageField = new JTextField();
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(e -> {
            // Handle sending message action
            String message = messageField.getText();
            // Process the message send it to the other player or display it in some way
            JOptionPane.showMessageDialog(null, "Message sent: " + message);
            messageField.setText(""); // Clear the message field after sending
        });

        messageBoxPanel.add(messageField, BorderLayout.CENTER);
        messageBoxPanel.add(sendButton, BorderLayout.EAST);

        mainPanel.add(messageBoxPanel, BorderLayout.SOUTH);
    }

}
