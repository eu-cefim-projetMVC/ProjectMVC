package eu.cefim.java.vue.organisateurs;

import javax.swing.*;
import java.awt.*;

public class OrganisateurLogin extends JFrame {
    public JLabel mailLabel;
    public JTextField mailTextField;

    public JLabel passwordLabel;
    public JPasswordField passwordPasswordField;

    public JButton loginButton;

    public  JLabel erreurLoginLabel;

    public OrganisateurLogin() {
        setTitle("OrganisateurLogin");
        setMinimumSize(new Dimension(312, 387));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mailLabel = new JLabel("Mail :");
        mailLabel.setMaximumSize(new Dimension(100, 25));
        mailTextField = new JTextField();
        mailTextField.setMinimumSize(new Dimension(100, 25));
        mailTextField.setMaximumSize(new Dimension(100, 25));

        passwordLabel = new JLabel("Mot de passe :");
        passwordLabel.setMaximumSize(new Dimension(100, 25));
        passwordPasswordField = new JPasswordField();
        passwordPasswordField.setMinimumSize(new Dimension(100, 25));
        passwordPasswordField.setMaximumSize(new Dimension(100, 25));

        loginButton = new JButton("Se connecter");
        loginButton.setMinimumSize(new Dimension(125, 25));
        loginButton.setMaximumSize(new Dimension(125, 25));

        erreurLoginLabel = new JLabel("");

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
                        .addComponent(mailLabel)
                        .addComponent(mailTextField)
                        .addComponent(passwordLabel)
                        .addComponent(passwordPasswordField)
                )
                .addGroup(gl.createSequentialGroup()
                        .addComponent(loginButton)
                ).addGroup(gl.createSequentialGroup()
                        .addComponent(erreurLoginLabel)
                )
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(mailLabel)
                        .addComponent(mailTextField)
                        .addComponent(passwordLabel)
                        .addComponent(passwordPasswordField)
                )
                .addGroup(gl.createParallelGroup()
                        .addComponent(loginButton)
                ).addGroup(gl.createParallelGroup()
                        .addComponent(erreurLoginLabel)
                )
        );

        pack();
    }
}
