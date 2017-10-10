/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BankManagerRole;

import Business.Person.Person;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amitha.murali
 */
public class ManageEmployeeJPanel extends javax.swing.JPanel {

    private OrganizationDirectory organizationDir;
    private JPanel userProcessContainer;
    
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageEmployeeJPanel(JPanel userProcessContainer,OrganizationDirectory organizationDir) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDir = organizationDir;
        
        populateOrganizationComboBox();
        
    }
    
    public void populateOrganizationComboBox(){
        organizationJComboBox.removeAllItems();
        
        for (Organization organization : organizationDir.getOrganizationList()){
            organizationJComboBox.addItem(organization);
        }
    }
  
    private void populateTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Person person : organization.getPersonDirectory().getPersonList()){
            if(person.getPersonType().toString().equals(Person.Type.Employee.getValue()))
            {
            Object[] row = new Object[2];
            row[0] = person.getPersonID();
            row[1] = person.getPersonName();
            model.addRow(row);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EmployeeListJScrollPane = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        lblOrganization = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        lblEmployeeName = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JTextField();
        lblHeading = new javax.swing.JLabel();
        lblEmployeeAge = new javax.swing.JLabel();
        txtEmployeeAge = new javax.swing.JTextField();
        lblEmployeeAddress = new javax.swing.JLabel();
        txtEmployeeAddress = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeListJScrollPane.setViewportView(organizationJTable);
        if (organizationJTable.getColumnModel().getColumnCount() > 0) {
            organizationJTable.getColumnModel().getColumn(0).setResizable(false);
            organizationJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(EmployeeListJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 530, 92));

        addJButton.setText("Create Employee");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 120, -1));

        lblOrganization.setText("Organization");
        add(lblOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, -1, -1));

        lblEmployeeName.setText("Employee Name");
        add(lblEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));
        add(txtEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 126, -1));

        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeading.setText("Manage Employee");
        add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        lblEmployeeAge.setText("Employee Age");
        add(lblEmployeeAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));
        add(txtEmployeeAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 126, -1));

        lblEmployeeAddress.setText("Employee Address");
        add(lblEmployeeAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));
        add(txtEmployeeAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        
        try
        {
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        
       
        if(organization == null || txtEmployeeName.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Employee name and Organization type are mandatory!!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
             String name = txtEmployeeName.getText();
        Person employeePerson = organization.getPersonDirectory().createPerson(Person.Type.Employee,name);
        if(null != employeePerson)
        {
             employeePerson.setPersonAge(Integer.parseInt(txtEmployeeAge.getText()));
        employeePerson.setPersonAddress(txtEmployeeAddress.getText());
        
        populateTable(organization);        
        JOptionPane.showMessageDialog(null, "Employee Record created successfully!!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        }
        }
        catch(Exception ex)
        {
             JOptionPane.showMessageDialog(this, "Please enter valid values", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateTable(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane EmployeeListJScrollPane;
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel lblEmployeeAddress;
    private javax.swing.JLabel lblEmployeeAge;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JTextField txtEmployeeAddress;
    private javax.swing.JTextField txtEmployeeAge;
    private javax.swing.JTextField txtEmployeeName;
    // End of variables declaration//GEN-END:variables
}
