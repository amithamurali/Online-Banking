package UserInterface.BankEmployeeRole;


import Business.Enterprise.Enterprise;
import Business.Person.Person;
import Business.Role.CustomerRole;
import Business.UserAccount.UserAccount;
import Business.Utilities.Utilities;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author  amitha.murali
 */
public class AddNewCustomerJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    
    public AddNewCustomerJPanel(JPanel upc, Enterprise enterprise) {
        initComponents();
        userProcessContainer = upc;
        this.enterprise = enterprise;
        populateSecurityQuestionComboBox();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeading = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblCustomerName = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        lblCustomerAge = new javax.swing.JLabel();
        txtCustomerAge = new javax.swing.JTextField();
        lblCustomerAddress = new javax.swing.JLabel();
        txtCustomerAddress = new javax.swing.JTextField();
        lblSecurityQuestion = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JTextField();
        lblSecurityAnswer = new javax.swing.JLabel();
        txtSecurityAnswer = new javax.swing.JTextField();
        lblSubHeading = new javax.swing.JLabel();
        comboSecurityQuestion = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeading.setText("New Customer");
        add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        btnAdd.setText("Add Customer");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 590, -1, -1));

        btnBack.setText("<<BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, -1, -1));

        lblCustomerName.setText("Customer Name");
        add(lblCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));
        add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 150, -1));

        lblCustomerAge.setText("Customer Age");
        add(lblCustomerAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));
        add(txtCustomerAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 150, -1));

        lblCustomerAddress.setText("Customer Address");
        add(lblCustomerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));
        add(txtCustomerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 150, -1));

        lblSecurityQuestion.setText("Security Question");
        add(lblSecurityQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 150, -1));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 150, -1));

        lblUserName.setText("User Name");
        add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        lblPassword.setText("Password");
        add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));
        add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 150, -1));

        lblSecurityAnswer.setText("Security Answer");
        add(lblSecurityAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 140, -1));
        add(txtSecurityAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 300, -1));

        lblSubHeading.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblSubHeading.setText("Customer Account Details");
        add(lblSubHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 250, -1));

        comboSecurityQuestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboSecurityQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 300, -1));
    }// </editor-fold>//GEN-END:initComponents
 private void populateSecurityQuestionComboBox(){
        comboSecurityQuestion.removeAllItems();
        
        for (String question : enterprise.getSecurityQuestion()){
            comboSecurityQuestion.addItem(question);
        }        
    }
 
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
try{
    
    if(txtCustomerName.getText().isEmpty() || nameJTextField.getText().isEmpty() || passwordJTextField.getText().isEmpty())
    {
        JOptionPane.showMessageDialog(null, "Customer name, user name and password are mandatory fields", "Info", JOptionPane.INFORMATION_MESSAGE); 
    }else
    {
        String customerName = txtCustomerName.getText();
    String userName = nameJTextField.getText();
    String password = passwordJTextField.getText();
     String securityQuestion = (String) comboSecurityQuestion.getSelectedItem();
    String securityAnswer = txtSecurityAnswer.getText();
     if(Utilities.passwordvalidation(password))
    {
        Person person = enterprise.getPersonDirectory().createPerson(Person.Type.Customer,customerName );       
        if(null != person)
        {
        person.setPersonAge(Integer.parseInt(txtCustomerAge.getText()));
        person.setPersonAddress(txtCustomerAddress.getText());        
        UserAccount ua = enterprise.getUserAccountDirectory().createUserAccount(userName, password, person, new CustomerRole(),securityQuestion,securityAnswer);   
        JOptionPane.showMessageDialog(null, "Customer added successfully!!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
     else
     {
         JOptionPane.showMessageDialog(null, "The password has to be atleast 8 characters, with no whitespace, atleast one upper case letter,one lower"
                 + "case letter, one digit and one special character", "Info", JOptionPane.INFORMATION_MESSAGE);
     }
    }
            
    
}
         catch(Exception ex)
{
    JOptionPane.showMessageDialog(this, "Error occured.. Please try later", "Warning", JOptionPane.WARNING_MESSAGE);
    
}
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        backAction();
    }//GEN-LAST:event_btnBackActionPerformed

    private void backAction(){
        userProcessContainer.remove(this);
        Component [] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length-1];
        ManageCustomerJPanel manageCustomerJPanel = (ManageCustomerJPanel) component;
        manageCustomerJPanel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> comboSecurityQuestion;
    private javax.swing.JLabel lblCustomerAddress;
    private javax.swing.JLabel lblCustomerAge;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSecurityAnswer;
    private javax.swing.JLabel lblSecurityQuestion;
    private javax.swing.JLabel lblSubHeading;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerAge;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtSecurityAnswer;
    // End of variables declaration//GEN-END:variables

}
