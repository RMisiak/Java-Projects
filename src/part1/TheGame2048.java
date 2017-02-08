/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part1;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Ryan
 */
public class TheGame2048 extends javax.swing.JFrame {

    int score = 0;
    JLabel[][] boxes = new JLabel[4][4];
    int values[][] = new int[4][4];
    Color[] colours = new Color[4];
    boolean gameWon;
    boolean gameContinues = true;

    // ASSIGN COLOURS PER NUMBER IN GAME (12 total)
    static {
        Color[] colours = {
            new Color(60, 186, 84), //0     0
            new Color(20, 186, 84), //1     2
            new Color(60, 90, 84), //2     4
            new Color(10, 186, 84), //3     8
            new Color(60, 186, 106), //4     16
            new Color(60, 5, 200), //5     32
            new Color(60, 7, 84),
            new Color(2, 4, 84),
            new Color(200, 186, 200),
            new Color(216, 186, 84),
            new Color(234, 186, 67),
            new Color(33, 33, 33)
        };
    }

    /**
     * Creates new form Game2048
     */
    public TheGame2048() {
        initComponents();
        boxes[0][0] = box00;
        boxes[0][1] = box01;
        boxes[0][2] = box02;
        boxes[0][3] = box03;

        boxes[1][0] = box10;
        boxes[1][1] = box11;
        boxes[1][2] = box12;
        boxes[1][3] = box13;

        boxes[2][0] = box20;
        boxes[2][1] = box21;
        boxes[2][2] = box22;
        boxes[2][3] = box23;

        boxes[3][0] = box30;
        boxes[3][1] = box31;
        boxes[3][2] = box32;
        boxes[3][3] = box33;

        //  PLACE TWO RANDOM 2's
        placeRandomTwo();
        placeRandomTwo();
        updateDisplay();
    }

    private void placeRandomTwo() {
        int r, c;
        boolean placed = false;

        do {
            r = (int) (Math.random() * 4);
            c = (int) (Math.random() * 4);

            //EMPTY!
            if (values[r][c] == 0) {
                values[r][c] = 2;
                placed = true;
            }
        } while (!placed);
    }

    private void updateDisplay() {
        for (int r = 0; r < values.length; r++) {
            for (int c = 0; c < values[r].length; c++) {
                if (values[r][c] == 0) {
                    boxes[r][c].setText("");
                } else {
                    boxes[r][c].setText(values[r][c] + "");
                }
            }
        }
        scoreLabel.setText("Score: " + score);
    }

    private void shiftRight() {
        for (int row = 0; row < values.length; row++) {
            for (int pass = 0; pass < values[row].length - 1; pass++) {
                // LOOK LEFT
                for (int col = 0; col < values[row].length - pass - 1; col++) {
                    if (values[row][col + 1] == 0) {
                        values[row][col + 1] = values[row][col];
                        values[row][col] = 0;
                    }
                }
            }
        }
    }

    private void shiftLeft() {
        for (int row = 0; row < values.length; row++) {
            for (int pass = values[row].length; pass > 1; pass--) {
                // LOOK RIGHT
                for (int col = values[row].length - 1; col > 0; col--) {
                    if (values[row][col - 1] == 0) {
                        values[row][col - 1] = values[row][col];
                        values[row][col] = 0;
                    }
                }
            }
        }
    }

    private void shiftUp() {
        for (int pass = 0; pass < values.length; pass++) {
            for (int col = 0; col < values[pass].length; col++) {
                // LOOK DOWN
                for (int row = values[pass].length - 1; row > 0; row--) {
                    if (values[row - 1][col] == 0) {
                        values[row - 1][col] = values[row][col];
                        values[row][col] = 0;
                    }
                }
            }
        }
    }

    private void shiftDown() {
        for (int pass = 0; pass < values.length; pass++) {
            for (int col = values[pass].length - 1; col > 0; col--) {
                // LOOK DOWN
                for (int row = 0; row < values[pass].length - 1; row++) {
                    if (values[row + 1][col] == 0) {
                        values[row + 1][col] = values[row][col];
                        values[row][col] = 0;
                    }
                }
            }
        }
    }

    private void compressRight() {

        // FOR EACH ROW
        for (int row = 0; row < values.length; row++) {
            // LOOK RIGHT
            for (int col = values[row].length - 1; col > 0; col--) {
                if (values[row][col] == values[row][col - 1]) {
                    values[row][col] = values[row][col] * 2;
                    values[row][col - 1] = 0;
                    score = score + values[row][col];
                }
                if (values[row][col] == 2048) {
                    gameWon = true;
                }
            }
        }
    }

    private void compressLeft() {
        // FOR EACH ROW
        for (int row = 0; row < values.length; row++) {
            // LOOK RIGHT
            for (int col = 0; col < values[row].length - 1; col++) {
                if (values[row][col] == values[row][col + 1]) {
                    values[row][col] = values[row][col] * 2;
                    values[row][col + 1] = 0;
                    score = score + values[row][col];
                }
                if (values[row][col] == 2048) {
                    gameWon = true;
                }
            }
        }
    }

    private void compressUp() {
        // FOR EACH COLUMN
        for (int col = 0; col < values.length; col++) {
            // LOOK DOWN
            for (int row = values[col].length - 1; row > 0; row--) {
                if (values[row - 1][col] == values[row][col]) {
                    values[row - 1][col] = values[row - 1][col] * 2;
                    values[row][col] = 0;
                    score = score + values[row][col];
                }
                if (values[row][col] == 2048) {
                    gameWon = true;
                }
            }
        }
    }

    private void compressDown() {
        // FOR EACH COLUMN
        for (int col = values.length - 1; col > 0; col--) {
            // LOOK DOWN
            for (int row = 0; row < values[col].length - 1; row++) {
                if (values[row + 1][col] == values[row][col]) {
                    values[row + 1][col] = values[row + 1][col] * 2;
                    values[row][col] = 0;
                }
                if (values[row][col] == 2048) {
                    gameWon = true;
                }
            }
        }

    }

    private void canShift() {

        int fullCount = 0;
        int cannotShiftCount = 0;

        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length - 1; col++) {
                if (values[row][col] != 0) {
                    fullCount++;
                }
            }
        }

        if (fullCount == (int) Math.pow(values.length, values.length)) {
            for (int row = 0; row < values.length; row++) {
                for (int col = 0; col < values[row].length - 1; col++) {
                    if (values[row][col + 1] != values[row][col]) {
                        cannotShiftCount++;
                    }
                }
            }
            if (cannotShiftCount == 16) {
                gameWon = false;
            }

        }

    }

    private void gameOver() {

        System.out.println("Game Over! Your final score is: " + score + "\n Please"
                + " try again!");

        upButton.enableInputMethods(false);
        downButton.enableInputMethods(false);
        leftButton.enableInputMethods(false);
        rightButton.enableInputMethods(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        box01 = new javax.swing.JLabel();
        box00 = new javax.swing.JLabel();
        box02 = new javax.swing.JLabel();
        box03 = new javax.swing.JLabel();
        box13 = new javax.swing.JLabel();
        box11 = new javax.swing.JLabel();
        box10 = new javax.swing.JLabel();
        box12 = new javax.swing.JLabel();
        box20 = new javax.swing.JLabel();
        box22 = new javax.swing.JLabel();
        box23 = new javax.swing.JLabel();
        box21 = new javax.swing.JLabel();
        box30 = new javax.swing.JLabel();
        box31 = new javax.swing.JLabel();
        box32 = new javax.swing.JLabel();
        box33 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rightButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        scoreLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        box01.setBackground(new java.awt.Color(153, 153, 153));
        box01.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box01.setText("2");
        box01.setAutoscrolls(true);
        box01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box00.setBackground(new java.awt.Color(153, 153, 153));
        box00.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box00.setText("2");
        box00.setAutoscrolls(true);
        box00.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box02.setBackground(new java.awt.Color(153, 153, 153));
        box02.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box02.setText("2");
        box02.setAutoscrolls(true);
        box02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box03.setBackground(new java.awt.Color(153, 153, 153));
        box03.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box03.setText("2");
        box03.setAutoscrolls(true);
        box03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box13.setBackground(new java.awt.Color(153, 153, 153));
        box13.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box13.setText("2");
        box13.setAutoscrolls(true);
        box13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box11.setBackground(new java.awt.Color(153, 153, 153));
        box11.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box11.setText("2");
        box11.setAutoscrolls(true);
        box11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box10.setBackground(new java.awt.Color(153, 153, 153));
        box10.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box10.setText("2");
        box10.setAutoscrolls(true);
        box10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box12.setBackground(new java.awt.Color(153, 153, 153));
        box12.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box12.setText("2");
        box12.setAutoscrolls(true);
        box12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box20.setBackground(new java.awt.Color(153, 153, 153));
        box20.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box20.setText("2");
        box20.setAutoscrolls(true);
        box20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box22.setBackground(new java.awt.Color(153, 153, 153));
        box22.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box22.setText("2");
        box22.setAutoscrolls(true);
        box22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box23.setBackground(new java.awt.Color(153, 153, 153));
        box23.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box23.setText("2");
        box23.setAutoscrolls(true);
        box23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box21.setBackground(new java.awt.Color(153, 153, 153));
        box21.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box21.setText("2");
        box21.setAutoscrolls(true);
        box21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box30.setBackground(new java.awt.Color(153, 153, 153));
        box30.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box30.setText("2");
        box30.setAutoscrolls(true);
        box30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box31.setBackground(new java.awt.Color(153, 153, 153));
        box31.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box31.setText("2");
        box31.setAutoscrolls(true);
        box31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box32.setBackground(new java.awt.Color(153, 153, 153));
        box32.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box32.setText("2");
        box32.setAutoscrolls(true);
        box32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        box33.setBackground(new java.awt.Color(153, 153, 153));
        box33.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        box33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box33.setText("2");
        box33.setAutoscrolls(true);
        box33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(box20, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box00, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box30, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(box01, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box02, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box03, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(box11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(box21, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(box22, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(box23, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(box31, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box32, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box33, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box01, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box00, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box02, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box03, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box13, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box20, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box21, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box22, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box23, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box30, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box31, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box32, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box33, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Wide Latin", 3, 24)); // NOI18N
        jLabel1.setText("The Game 2048");

        rightButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rightButton.setText("Right");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        leftButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        leftButton.setText("Left");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        downButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        downButton.setText("Down");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        upButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        upButton.setText("Up");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        scoreLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        scoreLabel.setText("Score: 0");
        scoreLabel.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        canShift();
        if (gameContinues) {
            shiftRight();
            placeRandomTwo();
            compressRight();
            updateDisplay();
        } else {
            gameOver();
        }
    }//GEN-LAST:event_rightButtonActionPerformed

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        canShift();
        if (gameContinues) {
            shiftLeft();
            placeRandomTwo();
            compressLeft();
            updateDisplay();
        } else {
            gameOver();
        }
    }//GEN-LAST:event_leftButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        canShift();
        if (gameContinues) {
            shiftDown();
            placeRandomTwo();
            compressDown();
            updateDisplay();
        } else {
            gameOver();
        }
    }//GEN-LAST:event_downButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        canShift();
        if (gameContinues) {
            shiftUp();
            placeRandomTwo();
            compressUp();
            updateDisplay();
        } else {
            gameOver();
        }
    }//GEN-LAST:event_upButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TheGame2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TheGame2048().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel box00;
    private javax.swing.JLabel box01;
    private javax.swing.JLabel box02;
    private javax.swing.JLabel box03;
    private javax.swing.JLabel box10;
    private javax.swing.JLabel box11;
    private javax.swing.JLabel box12;
    private javax.swing.JLabel box13;
    private javax.swing.JLabel box20;
    private javax.swing.JLabel box21;
    private javax.swing.JLabel box22;
    private javax.swing.JLabel box23;
    private javax.swing.JLabel box30;
    private javax.swing.JLabel box31;
    private javax.swing.JLabel box32;
    private javax.swing.JLabel box33;
    private javax.swing.JButton downButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton leftButton;
    private javax.swing.JButton rightButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
}
