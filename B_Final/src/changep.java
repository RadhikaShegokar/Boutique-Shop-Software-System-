import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class changep extends JFrame implements ActionListener {
    
    // GUI components
    private JTextField oldPassword;
    private JTextField newPassword;
    private JTextField confirmPassword;
    private JButton changeButton;
    
    public changep() {
        super("Change Password");
        
        // Create GUI components
        oldPassword = new JPasswordField(10);
        newPassword = new JPasswordField(10);
        confirmPassword = new JPasswordField(10);
        changeButton = new JButton("Change Password");
        
        // Add components to the window
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Old Password:"));
        panel.add(oldPassword);
        panel.add(new JLabel("New Password:"));
        panel.add(newPassword);
        panel.add(new JLabel("Confirm Password:"));
        panel.add(confirmPassword);
        panel.add(new JLabel(""));
        panel.add(changeButton);
        add(panel);
        
        // Register event listener
        changeButton.addActionListener(this);
        
        // Set window properties
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    // Event handling method
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeButton) {
            String oldPass = oldPassword.getText();
            String newPass = newPassword.getText();
            String confirmPass = confirmPassword.getText();
            
            if (oldPass.equals("123")) {
                if (newPass.equals(confirmPass)) {
                    JOptionPane.showMessageDialog(null, "Password changed successfully!");
                    oldPassword.setText("");
                    newPassword.setText("");
                    confirmPassword.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "New password and confirm password do not match.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect old password.");
            }
        }
    }
    
    public static void main(String[] args) {
        new changep();
    }
}



/*import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class changep extends JFrame {
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmNewPasswordField;
    private JButton changeButton;
    private JButton cancelButton;

    public changep() {
        setTitle("Change Password");
        setSize(350, 200);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel oldPasswordLabel = new JLabel("Old Password:");
        JLabel newPasswordLabel = new JLabel("New Password:");
        JLabel confirmNewPasswordLabel = new JLabel("Confirm New Password:");

        oldPasswordField = new JPasswordField(10);
        newPasswordField = new JPasswordField(10);
        confirmNewPasswordField = new JPasswordField(10);

        panel.add(oldPasswordLabel);
        panel.add(oldPasswordField);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(confirmNewPasswordLabel);
        panel.add(confirmNewPasswordField);

        changeButton = new JButton("Change");
        cancelButton = new JButton("Cancel");

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPassword = new String(oldPasswordField.getPassword());
                String newPassword = new String(newPasswordField.getPassword());
                String confirmNewPassword = new String(confirmNewPasswordField.getPassword());

                // Validate old password
                if (!oldPassword.equals("current_password")) {
                    JOptionPane.showMessageDialog(changep.this, "Incorrect old password.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate new password
                if (!newPassword.equals(confirmNewPassword)) {
                    JOptionPane.showMessageDialog(changep.this, "New passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Perform password change
                // Change the current_password to newPassword

                JOptionPane.showMessageDialog(changep.this, "Password changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Close the window
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });

        JPanel buttonPanel = new JPanel();
        
        
        
        buttonPanel.add(changeButton);
        buttonPanel.add(cancelButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }


public static void main(String[] args) {
	new changep();

}
}

class LoginWindow extends JFrame implements ActionListener {

    private JLabel passwordLabel;
    private JTextField passwordField;
    private JButton loginButton;

    private String currentPassword;

    public LoginWindow(String currentPassword) {
        super("Login");

        this.currentPassword = currentPassword;

        passwordLabel = new JLabel("Password:");
        passwordField = new JTextField(20);
        loginButton = new JButton("Login");

        loginButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        this.add(panel);
        this.pack();
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String password = passwordField.getText();

            if (password.equals(currentPassword)) {
            	changep cp = new changep();
                cp.setVisible(true);
                this.dispose(); // Close the window
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect password.");
            }
        }
    }

}*/
