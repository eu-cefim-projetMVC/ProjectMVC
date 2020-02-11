package eu.cefim.java.vue.administrateurs;

import javax.swing.*;
import java.awt.*;

public class WindowQrCodeBillet extends JFrame {

    public JLabel idLabel;
    public JTextField idTextField;
    public JLabel qrCode;
    public JButton validateButton;

    public WindowQrCodeBillet() {
        setTitle("Génération QrCode Billet");
        setMinimumSize(new Dimension(550, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        idLabel = new JLabel("Numéro du billet :");
        idLabel.setMaximumSize(new Dimension(100, 25));
        idTextField = new JTextField();
        idTextField.setMinimumSize(new Dimension(100, 25));
        idTextField.setMaximumSize(new Dimension(100, 25));

        qrCode = new JLabel();
        qrCode.setMinimumSize(new Dimension(400, 400));

        validateButton = new JButton("Génération QrCode du billet");
        validateButton.setMinimumSize(new Dimension(200, 25));
        validateButton.setMaximumSize(new Dimension(200, 25));

        defineLayout();
    }

    private void defineLayout() {
        JPanel pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addGroup(gl.createSequentialGroup()
                        .addComponent(idLabel)
                        .addComponent(idTextField)
                        .addComponent(validateButton)
                )
                .addGroup(gl.createParallelGroup()
                        .addComponent(qrCode))
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(idLabel)
                        .addComponent(idTextField)
                        .addComponent(validateButton)
                )
                .addGroup(gl.createSequentialGroup()
                        .addComponent(qrCode))
        );

        pack();
    }
}
