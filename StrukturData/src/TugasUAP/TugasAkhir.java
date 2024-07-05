package TugasUAP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TugasAkhir extends JFrame {
    private JTextField loanAmountField;
    private JComboBox<String> loanTypeCombo;
    private JTextField interestRateField;
    private JTextField resultField;
    private JButton calculateButton;
    private JButton sortButton;

    private ArrayList<Loan> loans;
    private HashMap<String, Double> interestRates;

    public TugasAkhir() {
        setTitle("Kalkulator Peminjaman Bank");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        loans = new ArrayList<>();
        interestRates = new HashMap<>();
        interestRates.put("Pinjaman Pribadi", 5.0);
        interestRates.put("Pinjaman Rumah", 3.5);
        interestRates.put("Pinjaman Mobil", 4.0);

        JLabel loanAmountLabel = new JLabel("Jumlah Peminjaman Rp:");
        loanAmountField = new JTextField();
        JLabel loanTypeLabel = new JLabel("Jenis Peminjaman:");
        loanTypeCombo = new JComboBox<>(new String[]{"Pinjaman Pribadi", "Pinjaman Rumah", "Pinjaman Mobil"});
        JLabel interestRateLabel = new JLabel("Suku Bunga:");
        interestRateField = new JTextField();
        interestRateField.setEditable(false);
        JLabel resultLabel = new JLabel("Jumlah Pembayaran Rp:");
        resultField = new JTextField();
        resultField.setEditable(false);

        calculateButton = new JButton("Hitung");
        sortButton = new JButton("Urutkan");

        add(loanAmountLabel);
        add(loanAmountField);
        add(loanTypeLabel);
        add(loanTypeCombo);
        add(interestRateLabel);
        add(interestRateField);
        add(resultLabel);
        add(resultField);
        add(calculateButton);
        add(sortButton);

        loanTypeCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) loanTypeCombo.getSelectedItem();
                Double rate = interestRates.get(selectedType);
                interestRateField.setText(rate.toString());
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(loanAmountField.getText());
                    String type = (String) loanTypeCombo.getSelectedItem();
                    double rate = interestRates.get(type);
                    double totalPayment = amount + (amount * rate / 100);
                    resultField.setText(String.format("%.2f", totalPayment));
                    loans.add(new Loan(amount, type, totalPayment));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Masukkan Jumlah yang Valid");
                }
            }
        });

        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loans.sort(Comparator.comparingDouble(Loan::getAmount));
                StringBuilder sortedLoans = new StringBuilder("Urutan Peminjaman:\n");
                for (Loan loan : loans) {
                    sortedLoans.append(loan).append("\n");
                }
                JOptionPane.showMessageDialog(null, sortedLoans.toString());
            }
        });
    }

    private class Loan {
        private double amount;
        private String type;
        private double totalPayment;

        public Loan(double amount, String type, double totalPayment) {
            this.amount = amount;
            this.type = type;
            this.totalPayment = totalPayment;
        }

        public double getAmount() {
            return amount;
        }

        public String getType() {
            return type;
        }

        public double getTotalPayment() {
            return totalPayment;
        }

        @Override
        public String toString() {
            return "Pinjaman{" +
                    "Jumlah=" + amount +
                    ", Jenis='" + type + '\'' +
                    ", Jumlah=" + totalPayment +
                    '}';
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TugasAkhir().setVisible(true);
            }
        });
    }
}
