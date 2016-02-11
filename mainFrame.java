

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class mainFrame extends javax.swing.JFrame {

    private final ArrayList<currency> currencies = new ArrayList();

    public mainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setThreads();
        currency currencyObjectTemp = new currency();
        currencyObjectTemp.setCurrencyName(null);
        currencies.add(currencyObjectTemp);

    }

    public final void setThreads() {
        Thread t;
        t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    printCurrencyValues();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t.start();
    }

    public synchronized void performCurrencyActions() {
        try {
            String[] currencyListArray = input.getText().toUpperCase().split("\\n");
            for (String currency : currencyListArray) {
                if (currency.equals("quit")){
                    System.exit(1);
                }
                currency currencyObject = new currency();
                String[] temp = currency.split(" ");
                for (int x = 0; x < currencies.size(); x++) {
                    if(temp[0].length() > 3 || temp[0].length() < 3){
                        JOptionPane.showMessageDialog(null,"Currency must have 3 letters.");
                        break;
                    }
                    if (currencies.get(x).getCurrencyName() == null) {
                        currencies.get(x).setCurrencyName(temp[0].toUpperCase());
                        currencies.get(x).setCurrencyValue(Double.parseDouble(temp[1]));
                        break;
                    } else if (currencies.get(x).getCurrencyName().equals(temp[0])) {
                        currencies.get(x).setCurrencyName(temp[0].toUpperCase());
                        currencies.get(x).setCurrencyValue(Double.parseDouble(temp[1]));
                        break;
                    } else {
                        //do nothing
                        
                    }
                    if (x == currencies.size() - 1) {
                        currencies.add(currencyObject);
                    }
                }
            }
            currencies.stream().forEach((a) -> {
                System.out.println(a.getCurrencyName() + " " + a.getCurrencyValue());
            });
            System.out.println("----");

            currencyList.removeAllItems();
            currencies.stream().forEach((a) -> {
                if (!a.getCurrencyName().equals("USD")) {
                    currencyList.addItem(a.getCurrencyName());
                }
            });
            currencyList.setEnabled(true);
            ratio.setEnabled(true);
            conversionRate.setEnabled(true);
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Invalid format, please try again.");
        }
    }

    public void performRatioActions() {
        for (int x = 0; x < currencies.size(); x++) {
            if (currencies.get(x).getCurrencyName().equals(currencyList.getSelectedItem().toString())) {
                currencies.get(x).setConversionRatio(Double.parseDouble(conversionRate.getText()));
            }
        }
    }

    public void printCurrencyValues() {
        if (currencies.size() > 0) {
            output.setText("");
            output.setText("CURRENT CURRENCY VALUES\n");
            String printStr = "";
            for (int i = 0; i < currencies.size(); i++) {
                if (currencies.get(i).getCurrencyValue() > 0) {
                    if (currencies.get(i).getConversionRatio() != 0) {
                        printStr += currencies.get(i).getCurrencyName() + " " + currencies.get(i).getCurrencyValue() + " " + "(USD " + currencies.get(i).getCurrencyValue() * currencies.get(i).getConversionRatio() + ")" + "\n";
                    } else {
                        printStr += currencies.get(i).getCurrencyName() + " " + currencies.get(i).getCurrencyValue() + "\n";
                    }
                }
            }
            output.setText(output.getText() + printStr + "\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();
        addFromConsole = new javax.swing.JButton();
        currencyList = new javax.swing.JComboBox<>();
        conversionRate = new javax.swing.JTextField();
        ratio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addFromFile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        output.setEditable(false);
        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        input.setColumns(20);
        input.setRows(5);
        jScrollPane2.setViewportView(input);

        addFromConsole.setText("ADD FROM CONSOLE");
        addFromConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFromConsoleActionPerformed(evt);
            }
        });

        currencyList.setEnabled(false);

        conversionRate.setEnabled(false);

        ratio.setText("ADD USD EXCHANGE RATE");
        ratio.setEnabled(false);
        ratio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INPUT");

        addFromFile.setText("ADD FROM FILE");
        addFromFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFromFileActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("OUTPUT");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("/USD:");

        jMenu1.setText("Program");

        jMenuItem2.setText("Restart");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currencyList, 0, 83, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(conversionRate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addFromConsole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ratio, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(addFromFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addFromConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(addFromFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ratio, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(conversionRate)
                    .addComponent(currencyList)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ratioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratioActionPerformed
        this.performRatioActions();
    }//GEN-LAST:event_ratioActionPerformed

    private void addFromConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFromConsoleActionPerformed
        this.performCurrencyActions();
    }//GEN-LAST:event_addFromConsoleActionPerformed

    private void addFromFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFromFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fullString = null;
            try {
                fullString = new String(Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath())));
            } catch (IOException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            input.setText(fullString);
        }
        this.performCurrencyActions();
    }//GEN-LAST:event_addFromFileActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        currencies.clear();
        currency currencyObjectTemp = new currency();
        currencyObjectTemp.setCurrencyName(null);
        currencies.add(currencyObjectTemp);
        output.setText("");
        input.setText("");
        currencyList.setEnabled(false);
        ratio.setEnabled(false);
        conversionRate.setEnabled(false);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new mainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFromConsole;
    private javax.swing.JButton addFromFile;
    private javax.swing.JTextField conversionRate;
    private javax.swing.JComboBox<String> currencyList;
    private javax.swing.JTextArea input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea output;
    private javax.swing.JButton ratio;
    // End of variables declaration//GEN-END:variables
}
