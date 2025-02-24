package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Decrypt extends  JFrame implements ActionListener {
  String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  JPanel keyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
  JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


  JLabel title = new JLabel("Sifre Cozme(decrypt)");

  JLabel messageLabel = new JLabel("sifre(mesaj)");


  JTextField messageText = new JTextField(10);

  JButton encryptButton = new JButton("Decrypt");


  Decrypt(){
    this.setTitle("Decrypt");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(4,1,10,10));
    this.setSize(500, 500);

    title.setFont(new Font("Serif", Font.BOLD, 20));
    this.add(title);



    messageLabel.setFont(new Font("Serif", Font.BOLD, 20));
    messageLabel.setBorder(BorderFactory.createLineBorder(Color.RED,2));


    messageText.setFont(new Font("Segoe Script", Font.ITALIC, 15));



    messagePanel.add(messageLabel);
    messagePanel.add(messageText);

    encryptButton.setFont(new Font("Serif", Font.BOLD, 20));
    encryptButton.addActionListener(this);

    this.add(keyPanel);
    this.add(messagePanel);
    this.add(encryptButton);
    this.setVisible(true);
  }
  @Override
  public void actionPerformed(ActionEvent e) {







    String message = messageText.getText().toUpperCase();

    for (int key = 0; key <= SYMBOLS.length(); key++) {
      String result = "";

      for (char letter : message.toCharArray()) {
        int index = SYMBOLS.indexOf(letter);

        if (index != -1) {
          for (int i = 0; i < key; i++) {
            if (index == 0) {
              index = SYMBOLS.length() - 1;
            } else {
              index--;
            }

          }
          result += SYMBOLS.charAt(index);
        }
        else {
            result += letter;
          }


    }
      System.out.println("Key #" + key + ": " + result);
      System.out.println("-----------------------");

      }



  }
}
