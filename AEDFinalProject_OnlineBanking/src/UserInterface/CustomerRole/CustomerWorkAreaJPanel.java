/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerRole;

import Business.BankAccount.BankAccount;
import Business.Beneficiary.Beneficiary;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.SecurityManagementOrganization;
import Business.Person.Person;
import Business.Person.Customer;
import Business.Transaction.Transaction;
import Business.UserAccount.UserAccount;
import Business.Utilities.SendEmail;
import Business.WorkQueue.SecurityConcernRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amitha.murali
 */
public class CustomerWorkAreaJPanel extends javax.swing.JPanel {
 int emailedOTP = 0;
    /**
     * Creates new form CustomerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Customer customer ;
    private UserAccount userAccount;
    
    /** Creates new form AdminWorkAreaJPanel */
    public CustomerWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise, Person person,UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.customer = (Customer) person;
        this.userAccount = userAccount;
      //  customer.setBankAccountDirectory(new BankAccountDirectory());
       // customer.setBeneficiaryDirectory(new BeneficiaryDirectory());                                     
        
       lblPasscode.setVisible(false);
       txtPasscode.setVisible(false);
       lblBankName.setText(enterprise.getName());
       lblCustomerName.setText("Welcome " + person.getPersonName());
       
       
       populateBankAccountComboBox();
       populateApprovedBeneficiaryTable();
       populateBeneficiaryTable();
       populateBankAccountsTable();
       populateMyBankAccountsTable();
       populateSecurityConcernTable();
       populateReportSeverityComboBox();
    }

     private void populateBankAccountComboBox(){
        JComboBoxBankAccounts.removeAllItems();
        
        for (BankAccount bankAccount : customer.getBankAccountDirectory().getBankAccountList()){
            JComboBoxBankAccounts.addItem(bankAccount);
        }
        
    }
     
      private void populateReportSeverityComboBox(){
        comboSeverity.removeAllItems();
        comboSeverity.addItem(SecurityConcernRequest.Type.High);
        comboSeverity.addItem(SecurityConcernRequest.Type.Medium);
        comboSeverity.addItem(SecurityConcernRequest.Type.Low);
    }
     
          public void populateBankAccountsTable(){
        DefaultTableModel model = (DefaultTableModel) tblAccounts.getModel();
        
        model.setRowCount(0);
        
        for (BankAccount bankAccount : customer.getBankAccountDirectory().getBankAccountList()){
            
            //TODO - Customer has to move to network level and enterprise IFSC code has to be added to Bank Account
            Object[] row = new Object[4];
            row[0] = bankAccount.getAccountNumber();
            row[1] = bankAccount.getBankAccountType();
            row[2] = bankAccount;
            row[3] = bankAccount.getAvailableBalance();
            model.addRow(row);
            
        }
    }
      public void populateMyBankAccountsTable(){
          DefaultTableModel model = (DefaultTableModel) tblMyBankAccounts.getModel();
        
        model.setRowCount(0);
        
        for (BankAccount bankAccount : customer.getBankAccountDirectory().getBankAccountList()){
            
            //TODO - Customer has to move to network level and enterprise IFSC code has to be added to Bank Account
            Object[] row = new Object[4];
            row[0] = bankAccount.getAccountNumber();
            row[1] = bankAccount.getBankAccountType();
            row[2] = bankAccount;
            row[3] = bankAccount.getAvailableBalance();
            model.addRow(row);
            
        }
    }
     
     
     public void populateBeneficiaryTable(){
        DefaultTableModel model = (DefaultTableModel) jTableBeneficiary.getModel();
        
        model.setRowCount(0);
        
        for (Beneficiary beneficiary : customer.getBeneficiaryDirectory().getBeneficiaryList()){
            
            
            Object[] row = new Object[5];
            row[0] = beneficiary;
            row[1] = String.valueOf(beneficiary.getBankAccount().getAccountNumber());
            row[2] = String.valueOf(beneficiary.getBankAccount().getRoutingNumber());
            row[3] = beneficiary.getStatus();
            row[4] = beneficiary.getAddedDate();
            model.addRow(row);
            
        }
    }
     
      public void populateApprovedBeneficiaryTable(){
        DefaultTableModel model = (DefaultTableModel) tblTransferBeneficiary.getModel();
        
        model.setRowCount(0);
        
        for (Beneficiary beneficiary : customer.getBeneficiaryDirectory().getBeneficiaryList()){
            
            if(beneficiary.getStatus().equals(Beneficiary.BENEFICIARY_APPROVED))
                {
            Object[] row = new Object[4];
            row[0] = beneficiary;
           row[1] = String.valueOf(beneficiary.getBankAccount().getAccountNumber());
            row[2] = String.valueOf(beneficiary.getBankAccount().getRoutingNumber());
            row[3] = beneficiary.getAddedDate();
            model.addRow(row);
                }
            
        }
    }
      
     
      public void populateTransactionHistoryTable(BankAccount bankAccount){
        DefaultTableModel model = (DefaultTableModel) jTableTransactionHistory.getModel();
        
        model.setRowCount(0);
        
     //  int accountNumber = (int) JComboBoxBankAccounts.getSelectedItem();
     //  int routingNumber = enterprise.getBranchRoutingNumber();
     //  if(accountNumber > 0 && routingNumber > 0)
     //  {
    //   BankAccount selectedAccount = customer.getBankAccountDirectory().searchBankAccount(accountNumber, routingNumber);
     //   if(selectedAccount != null)
     //   {
     BankAccount selectedAccount = (BankAccount) JComboBoxBankAccounts.getSelectedItem();
        for (Transaction transaction : selectedAccount.getTransactionHistory().getTransactionHistory()){
            
            Object[] row = new Object[6];
            row[0] = transaction.getTransactionDate();
            row[1] = transaction.getTransactionNumber();
            row[2] = transaction.getDescription();
            row[3] = transaction.getTransactionType();
            row[4] = transaction.getAmount();
            row[5] = transaction.getSenderOrPayee();
            model.addRow(row);
      //  }
     //   }
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

        CustomerPanel = new javax.swing.JTabbedPane();
        accountsPanel = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        EmployeeListJScrollPane4 = new javax.swing.JScrollPane();
        tblMyBankAccounts = new javax.swing.JTable();
        TransferPanel = new javax.swing.JPanel();
        lblHeading3 = new javax.swing.JLabel();
        lblToAccount = new javax.swing.JLabel();
        EmployeeListJScrollPane2 = new javax.swing.JScrollPane();
        tblAccounts = new javax.swing.JTable();
        lblFromAccount = new javax.swing.JLabel();
        btnSumbmit = new javax.swing.JButton();
        EmployeeListJScrollPane3 = new javax.swing.JScrollPane();
        tblTransferBeneficiary = new javax.swing.JTable();
        lblAmount = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        lblPasscode = new javax.swing.JLabel();
        txtPasscode = new javax.swing.JTextField();
        ManageBeneficiaryPanel = new javax.swing.JPanel();
        btnDeleteBeneficiary = new javax.swing.JButton();
        EmployeeListJScrollPane = new javax.swing.JScrollPane();
        jTableBeneficiary = new javax.swing.JTable();
        btnAddBeneficiary = new javax.swing.JButton();
        lblHeading1 = new javax.swing.JLabel();
        TransactionHistoryPanel = new javax.swing.JPanel();
        EmployeeListJScrollPane1 = new javax.swing.JScrollPane();
        jTableTransactionHistory = new javax.swing.JTable();
        lblHeading2 = new javax.swing.JLabel();
        JComboBoxBankAccounts = new javax.swing.JComboBox();
        lblBankAccount = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableSecurityConcerns3 = new javax.swing.JTable();
        btnReportSecurityIssues = new javax.swing.JButton();
        lblMainHeading3 = new javax.swing.JLabel();
        lblSecurityConcern3 = new javax.swing.JLabel();
        txtSecurityConcern3 = new javax.swing.JTextField();
        lblSeverity3 = new javax.swing.JLabel();
        comboSeverity = new javax.swing.JComboBox();
        lblCustomerName = new javax.swing.JLabel();
        lblBankName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        accountsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblHeading.setText("Bank Accounts");
        accountsPanel.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 240, 50));

        tblMyBankAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Account no.", "Account Type", "Branch", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeListJScrollPane4.setViewportView(tblMyBankAccounts);

        accountsPanel.add(EmployeeListJScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 740, 110));

        CustomerPanel.addTab(" My Accounts ", accountsPanel);

        TransferPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeading3.setText("Funds Transafer");
        TransferPanel.add(lblHeading3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        lblToAccount.setText("To Account : ");
        TransferPanel.add(lblToAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        tblAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Account no.", "Account Type", "Branch", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeListJScrollPane2.setViewportView(tblAccounts);

        TransferPanel.add(EmployeeListJScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 740, 110));

        lblFromAccount.setText("From Account : ");
        TransferPanel.add(lblFromAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        btnSumbmit.setText("Submit");
        btnSumbmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumbmitActionPerformed(evt);
            }
        });
        TransferPanel.add(btnSumbmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 560, -1, -1));

        tblTransferBeneficiary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Beneficiary Name", "Account Number", "Routing Number", "Added Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeListJScrollPane3.setViewportView(tblTransferBeneficiary);

        TransferPanel.add(EmployeeListJScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 740, 110));

        lblAmount.setText("Amount");
        TransferPanel.add(lblAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, -1));
        TransferPanel.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 150, -1));

        lblDescription.setText("Description");
        TransferPanel.add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, -1));
        TransferPanel.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 140, -1));

        lblPasscode.setText("Passcode");
        TransferPanel.add(lblPasscode, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 560, -1, -1));
        TransferPanel.add(txtPasscode, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, 140, -1));

        CustomerPanel.addTab(" Fund Transfers ", TransferPanel);

        ManageBeneficiaryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteBeneficiary.setText("Delete Beneficiary");
        btnDeleteBeneficiary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBeneficiaryActionPerformed(evt);
            }
        });
        ManageBeneficiaryPanel.add(btnDeleteBeneficiary, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 210, -1));

        jTableBeneficiary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Beneficiary Name", "Account Number", "Routing Number", "Status", "Added Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeListJScrollPane.setViewportView(jTableBeneficiary);

        ManageBeneficiaryPanel.add(EmployeeListJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 710, 110));

        btnAddBeneficiary.setText("Add New Beneficiary");
        btnAddBeneficiary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBeneficiaryActionPerformed(evt);
            }
        });
        ManageBeneficiaryPanel.add(btnAddBeneficiary, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 200, -1));

        lblHeading1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeading1.setText("Manage Beneficiaries");
        ManageBeneficiaryPanel.add(lblHeading1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        CustomerPanel.addTab("Manage Beneficiary", ManageBeneficiaryPanel);

        jTableTransactionHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Transaction Date", "Transaction ID", "Description", "Type", "Amount", "Sender/Payee"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeListJScrollPane1.setViewportView(jTableTransactionHistory);

        lblHeading2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeading2.setText("Transaction History");

        JComboBoxBankAccounts.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JComboBoxBankAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxBankAccountsActionPerformed(evt);
            }
        });

        lblBankAccount.setText("Bank Account");

        javax.swing.GroupLayout TransactionHistoryPanelLayout = new javax.swing.GroupLayout(TransactionHistoryPanel);
        TransactionHistoryPanel.setLayout(TransactionHistoryPanelLayout);
        TransactionHistoryPanelLayout.setHorizontalGroup(
            TransactionHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionHistoryPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(TransactionHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmployeeListJScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TransactionHistoryPanelLayout.createSequentialGroup()
                        .addComponent(lblBankAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(JComboBoxBankAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHeading2))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        TransactionHistoryPanelLayout.setVerticalGroup(
            TransactionHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionHistoryPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lblHeading2)
                .addGap(37, 37, 37)
                .addGroup(TransactionHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBankAccount)
                    .addComponent(JComboBoxBankAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(EmployeeListJScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );

        CustomerPanel.addTab(" TransactionHistory ", TransactionHistoryPanel);

        tableSecurityConcerns3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Security Concern", "Severity", "Status", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableSecurityConcerns3);

        btnReportSecurityIssues.setText("Report Security Concern");
        btnReportSecurityIssues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportSecurityIssuesbtnSecurityIssueActionPerformed(evt);
            }
        });

        lblMainHeading3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMainHeading3.setText("Security Centre");

        lblSecurityConcern3.setText("Security Concern:");

        lblSeverity3.setText("Severity");

        comboSeverity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSeverity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSeveritycomboboxSeverityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMainHeading3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSecurityConcern3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSeverity3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(123, 123, 123)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSecurityConcern3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboSeverity, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReportSecurityIssues)
                .addGap(341, 341, 341))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblMainHeading3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSecurityConcern3)
                            .addComponent(txtSecurityConcern3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(lblSeverity3))
                    .addComponent(comboSeverity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(btnReportSecurityIssues)
                .addGap(66, 66, 66)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1134, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 60, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 61, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        CustomerPanel.addTab(" Security Centre ", jPanel3);

        lblCustomerName.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblCustomerName.setText("Customer Name");

        lblBankName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblBankName.setText("Bank Name");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Main/bank-icon.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addComponent(CustomerPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblBankName))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(CustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JComboBoxBankAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxBankAccountsActionPerformed
        // TODO add your handling code here:

        BankAccount bankAccount = (BankAccount) JComboBoxBankAccounts.getSelectedItem();
        if (bankAccount != null){
            populateTransactionHistoryTable(bankAccount);
        }
    }//GEN-LAST:event_JComboBoxBankAccountsActionPerformed

    private void btnAddBeneficiaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBeneficiaryActionPerformed

        AddNewBeneficiaryJPanel addNewBeneficiaryJPanel = new AddNewBeneficiaryJPanel(userProcessContainer,enterprise, customer,userAccount);
        userProcessContainer.add("addNewBeneficiaryJPanel", addNewBeneficiaryJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddBeneficiaryActionPerformed

    private void btnDeleteBeneficiaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBeneficiaryActionPerformed
        try{
            int row = jTableBeneficiary.getSelectedRow();
            if(row<0){
                JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Beneficiary beneficiary = (Beneficiary) jTableBeneficiary.getValueAt(row, 0);
            if(beneficiary != null)
            {

                customer.getBeneficiaryDirectory().removeBeneficiary(beneficiary);
                populateApprovedBeneficiaryTable();
                populateBeneficiaryTable();
                JOptionPane.showMessageDialog(null, "Beneficiary deleted successfully!!", "Info", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error.. Please try later", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteBeneficiaryActionPerformed

    private void btnSumbmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumbmitActionPerformed
        // TODO add your handling code here:
        SendEmail se = null;
        
        try{
            if(txtAmount.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter the amount to be transferred!!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            
            int amount = Integer.parseInt(txtAmount.getText());

            int accountRow = tblAccounts.getSelectedRow();
            if(accountRow<0){
                JOptionPane.showMessageDialog(null, "Please select Sender's account!!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int beneficiaryRow = tblTransferBeneficiary.getSelectedRow();
            if(beneficiaryRow<0){
                JOptionPane.showMessageDialog(null, "Please select Receiver's account!!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            
            if(txtPasscode.getText() != null && !"".equals(txtPasscode.getText()) )
            {           
            if( !txtPasscode.getText().equals( String.valueOf(emailedOTP)))
            {
                JOptionPane.showMessageDialog(null, "Sorry.. The OTP you entered does not match with the OTP we sent you.. Please try again", "Info", JOptionPane.INFORMATION_MESSAGE);
            }else
            {
                String description = txtDescription.getText();
                BankAccount senderBankAccount = (BankAccount) tblAccounts.getValueAt(accountRow, 2);
                Beneficiary beneficiary = (Beneficiary) tblTransferBeneficiary.getValueAt(beneficiaryRow, 0);
                if(senderBankAccount != null && beneficiary != null && amount > 0)
                {
                    if(senderBankAccount.getAccountNumber() == beneficiary.getBankAccount().getAccountNumber())
                    {
                        JOptionPane.showMessageDialog(null, "Please validate the account number you have entered", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if(senderBankAccount.getAvailableBalance() < amount)
                    {
                        JOptionPane.showMessageDialog(null, "Please an amount less than the available balance in your account!!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    Transaction transaction = senderBankAccount.getTransactionHistory().createTransaction();
                    if(null != transaction)
                    {
                        //Debit the amount from sender's balance and then add transactiondetails
                        int senderBalance = senderBankAccount.getAvailableBalance();
                        if(senderBalance > 0)
                        {
                            senderBankAccount.setAvailableBalance(senderBalance - amount);
                            
                            Date dNow = new Date();
                            SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");
                            String todayDate = ft.format(dNow);
                            transaction.setTransactionDate(todayDate);
                            
                            transaction.setAmount(amount);
                            transaction.setAssociatedBeneficiary(beneficiary);
                            transaction.setDescription(description);
                            transaction.setSenderOrPayee(senderBankAccount.getAccountHolderName());
                            transaction.setTransactionType(Transaction.Type.Debit);
                            
                            //Credit the amount to receiver's balance and then add transactiondetails
                            
                            Transaction receiverTransaction = beneficiary.getBankAccount().getTransactionHistory().createTransaction(transaction.getTransactionNumber());
                            if(null != receiverTransaction)
                            {
                                int receiverBalance = beneficiary.getBankAccount().getAvailableBalance();
                                
                                beneficiary.getBankAccount().setAvailableBalance(receiverBalance + amount);
                                receiverTransaction.setAmount(amount);
                                //receiverTransaction.setAssociatedBeneficiary(beneficiary);
                                receiverTransaction.setDescription(description);
                                receiverTransaction.setSenderOrPayee(senderBankAccount.getAccountHolderName());
                                receiverTransaction.setTransactionDate(todayDate);
                                receiverTransaction.setTransactionType(Transaction.Type.credit);
                                
                                JOptionPane.showMessageDialog(null, "Transaction got completed successfully!!", "Info", JOptionPane.INFORMATION_MESSAGE);
                                populateBankAccountsTable();
                                populateApprovedBeneficiaryTable();
                            }
                        }
                        
                    }
                }
            }
            
            }
            else
            {  
             lblPasscode.setVisible(true);
             txtPasscode.setVisible(true);
             se = new SendEmail();
             if(se == null){
             } else {
                 emailedOTP = se.generateOTP();
                 JOptionPane.showMessageDialog(null, "Please enter the passcode sent to your registered email id", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error.. Please try later", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSumbmitActionPerformed

    private void btnReportSecurityIssuesbtnSecurityIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportSecurityIssuesbtnSecurityIssueActionPerformed
        // TODO add your handling code here:
        try{
            
          String severity = comboSeverity.getSelectedItem().toString();
           
    if(!txtSecurityConcern3.getText().isEmpty() && severity != null)    
    {
        String securityConcern = txtSecurityConcern3.getText(); 
        SecurityConcernRequest.Type reportType;
        if(severity.equals("High") )
            reportType = SecurityConcernRequest.Type.High;
        else if(severity.equals("Medium") )
            reportType = SecurityConcernRequest.Type.Medium;
        else 
            reportType = SecurityConcernRequest.Type.Low;
        
        SecurityConcernRequest request = new SecurityConcernRequest(reportType);
                   
                 request.setMessage(securityConcern);
                 request.setSender(userAccount);
                 request.setStatus(SecurityConcernRequest.OPEN);
                Organization org = null;
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                    if (organization instanceof SecurityManagementOrganization){
                        org = organization;
                        break;
                    }
                }
                if (org!=null){
                    org.getWorkQueue().getWorkRequestList().add(request);
                    JOptionPane.showMessageDialog(null, "Security issue added successfully!!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    populateSecurityConcernTable();
                }
        
                }
                else
                {
                     JOptionPane.showMessageDialog(null, "Please fill the fields as they are mandatory", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
           
        } 
         catch(Exception ex)
{
    JOptionPane.showMessageDialog(this, "Error occured.. Please try later", "Warning", JOptionPane.WARNING_MESSAGE);
    
}
    }//GEN-LAST:event_btnReportSecurityIssuesbtnSecurityIssueActionPerformed

    private void comboSeveritycomboboxSeverityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSeveritycomboboxSeverityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSeveritycomboboxSeverityActionPerformed

      
     public void populateSecurityConcernTable(){
        DefaultTableModel model = (DefaultTableModel)tableSecurityConcerns3.getModel();
        
        model.setRowCount(0);
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof SecurityManagementOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
        for(WorkRequest request :  org.getWorkQueue().getWorkRequestList()){
            
            SecurityConcernRequest workRequest = (SecurityConcernRequest) request;
            if(workRequest != null)
            {
            Object[] row = new Object[4];
            row[0] = workRequest.getMessage();
            row[1] = workRequest.getSecuritySeverity().getValue();            
            row[2] = workRequest;
            row[3] = workRequest.getAction();
            
            model.addRow(row);
                
            }
        }
        }
    }
    
   // private javax.swing.ButtonGroup buttonGroup;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane CustomerPanel;
    private javax.swing.JScrollPane EmployeeListJScrollPane;
    private javax.swing.JScrollPane EmployeeListJScrollPane1;
    private javax.swing.JScrollPane EmployeeListJScrollPane2;
    private javax.swing.JScrollPane EmployeeListJScrollPane3;
    private javax.swing.JScrollPane EmployeeListJScrollPane4;
    private javax.swing.JComboBox JComboBoxBankAccounts;
    private javax.swing.JPanel ManageBeneficiaryPanel;
    private javax.swing.JPanel TransactionHistoryPanel;
    private javax.swing.JPanel TransferPanel;
    private javax.swing.JPanel accountsPanel;
    private javax.swing.JButton btnAddBeneficiary;
    private javax.swing.JButton btnDeleteBeneficiary;
    private javax.swing.JButton btnReportSecurityIssues;
    private javax.swing.JButton btnSecurityIssue;
    private javax.swing.JButton btnSecurityIssue1;
    private javax.swing.JButton btnSumbmit;
    private javax.swing.JComboBox comboSeverity;
    private javax.swing.JComboBox comboboxSeverity;
    private javax.swing.JComboBox comboboxSeverity1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTableBeneficiary;
    private javax.swing.JTable jTableTransactionHistory;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBankAccount;
    private javax.swing.JLabel lblBankName;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblFromAccount;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblHeading1;
    private javax.swing.JLabel lblHeading2;
    private javax.swing.JLabel lblHeading3;
    private javax.swing.JLabel lblMainHeading;
    private javax.swing.JLabel lblMainHeading1;
    private javax.swing.JLabel lblMainHeading3;
    private javax.swing.JLabel lblPasscode;
    private javax.swing.JLabel lblSecurityConcern;
    private javax.swing.JLabel lblSecurityConcern1;
    private javax.swing.JLabel lblSecurityConcern3;
    private javax.swing.JLabel lblSeverity;
    private javax.swing.JLabel lblSeverity1;
    private javax.swing.JLabel lblSeverity3;
    private javax.swing.JLabel lblToAccount;
    private javax.swing.JTable tableSecurityConcerns;
    private javax.swing.JTable tableSecurityConcerns1;
    private javax.swing.JTable tableSecurityConcerns3;
    private javax.swing.JTable tblAccounts;
    private javax.swing.JTable tblMyBankAccounts;
    private javax.swing.JTable tblTransferBeneficiary;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtPasscode;
    private javax.swing.JTextField txtSecurityConcern;
    private javax.swing.JTextField txtSecurityConcern1;
    private javax.swing.JTextField txtSecurityConcern3;
    // End of variables declaration//GEN-END:variables
}
