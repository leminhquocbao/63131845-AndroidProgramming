package ntu.MSSV63131845;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TinhToan extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCangNang;
    private JTextField txtChieuCao;
    private JTextArea txtThongBao;
    private JComboBox<String> unitComboBox;

    public TinhToan() {
        setTitle("Tính chỉ số BMI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1095, 523);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.CYAN);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nhập Cân nặng của bạn:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel.setBounds(17, 134, 188, 41);
        contentPane.add(lblNewLabel);

        txtCangNang = new JTextField();
        txtCangNang.setBounds(215, 134, 191, 42);
        contentPane.add(txtCangNang);
        txtCangNang.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Nhập Chiều cao của bạn:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_1.setBounds(17, 199, 188, 41);
        contentPane.add(lblNewLabel_1);

        txtChieuCao = new JTextField();
        txtChieuCao.setColumns(10);
        txtChieuCao.setBounds(215, 200, 191, 42);
        contentPane.add(txtChieuCao);

        unitComboBox = new JComboBox<>();
        unitComboBox.addItem("Kilogram & Meter");
        unitComboBox.addItem("Pound & Inch");
        unitComboBox.addItem("Gram & Centimeter");
        unitComboBox.setBounds(17, 263, 180, 50);
        contentPane.add(unitComboBox);

        JButton btnTinhToan = new JButton("Tính Toán");
        btnTinhToan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TinhToanBMI();
            }
        });
        btnTinhToan.setBounds(215, 263, 120, 50);
        contentPane.add(btnTinhToan);

        ImageIcon icon = new ImageIcon("D:\\study\\BMI.png");
        JLabel label = new JLabel(icon);
        label.setBounds(428, 28, 647, 312); 
        contentPane.add(label);
        
        JLabel lblBmiCn = new JLabel("Công thức: BMI = cân nặng (kg) / chiều cao² (m)");
        lblBmiCn.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblBmiCn.setBounds(17, 37, 389, 67);
        contentPane.add(lblBmiCn);

        txtThongBao = new JTextArea();
        txtThongBao.setBounds(17, 323, 389, 152);
        txtThongBao.setLineWrap(true);
        txtThongBao.setWrapStyleWord(true);
        txtThongBao.setFont(new Font("Times New Roman", Font.BOLD, 16));
        contentPane.add(txtThongBao);
    }

    void TinhToanBMI() {
        String str_CN = txtCangNang.getText();
        String str_CC = txtChieuCao.getText();

        double cannang = Double.parseDouble(str_CN);
        double chieucao = Double.parseDouble(str_CC);
        double mincandoi = 18.5;
        double maxcandoi = 25;
        DecimalFormat df = new DecimalFormat("#.##");
        double BMI;

        if (unitComboBox.getSelectedItem().equals("Pound & Inch")) {
            cannang = Pound(cannang);
            chieucao = Met(chieucao);
        } else if (unitComboBox.getSelectedItem().equals("Gram & Centimeter")) { 
            cannang = gam(cannang);
            chieucao = cm(chieucao);
        }

        BMI = BMI(cannang, chieucao);

        if (BMI < 18.5) {
            double candoi = mincandoi - BMI;
            txtThongBao.setText("Bạn đang bị suy dinh dưỡng: " + df.format(BMI) + ".\nBạn cần thêm " + df.format(candoi)
                    + " để được cân đối" + ".\nBạn cần ăn uống đầy đủ hơn để cân đối hơn."
                    + "\nLưu ý công thức và hiện chỉ số BMI đều được áp dụng bằng công thức của WHO");
        } else if (BMI >= 18.5 && BMI < 25) {
            txtThongBao.setText("Thân hình của bạn đã rất cân đối, yêu cầu bạn tiếp tục duy trì: " + df.format(BMI));
        } else if (BMI >= 25 && BMI < 30) {
            double candoi = BMI - maxcandoi;
            txtThongBao.setText("Bạn đang thừa cân: " + df.format(BMI) + ".\nBạn cần giảm " + df.format(candoi)
                    + " để có thân hình cân đối."
                    + ".\nLưu ý công thức và hiện chỉ số BMI đều được áp dụng bằng công thức của WHO");
        } else if (BMI >= 30 && BMI < 35) {
            double candoi = BMI - maxcandoi;
            txtThongBao.setText("Bạn đang thừa cân Cấp độ I: " + df.format(BMI) + ".\nBạn cần giảm "
                    + df.format(candoi) + " để có thân hình cân đối"
                    + ".\nLưu ý công thức và hiện chỉ số BMI đều được áp dụng bằng công thức của WHO");
        } else if (BMI >= 35 && BMI < 40) {
            double candoi = BMI - maxcandoi;
            txtThongBao.setText("Bạn đang thừa cân Cấp độ II: " + df.format(BMI) + ".\nBạn cần giảm "
                    + df.format(candoi) + " để có thân hình cân đối."
                    + "\nLưu ý công thức và hiện chỉ số BMI đều được áp dụng bằng công thức của WHO");
        } else if (BMI >= 40) {
            double candoi = BMI - maxcandoi;
            txtThongBao.setText("Bạn đang thừa cân Cấp độ III: " + df.format(BMI) + ".\nBạn cần giảm "
                    + df.format(candoi) + " để có thân hình cân đối."
                    + ".\nLưu ý công thức và hiện chỉ số BMI đều được áp dụng bằng công thức của WHO");
        }
    }

    double BMI(double chieucao, double cannang) {
        return chieucao / (cannang * cannang);
    }

    double Pound(double cannang) {
        return cannang * 0.453592;
    }

    double Met(double chieucao) {
        return chieucao * 0.0254;
    }

    double gam(double cannang) {
        return cannang / 1000.0;
    }

    double cm(double chieucao) {
        return chieucao / 100.0;
    }

}

