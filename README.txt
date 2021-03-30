every function or para have to be written in English

217, 154, 206
170, 137, 217
125, 94, 191
59, 58, 140
75, 81, 191

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        for (JInternalFrame frmChild : jDesktopPane1.getAllFrames()) {
        frmChild.dispose();
        }

        frmStaff newForm = new frmStaff();
        newForm.setTitle("Login to system");
        newForm.setSize(this.getWidth(),this.getHeight());
        newForm.setLocation(0,0);
        jDesktopPane1.add(newForm);
        newForm.setVisible(true);
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        // TODO add your handling code here:
        if(frmStaff == null || frmStaff.isClosed())
        {
            frmStaff = new frmStaff();
            jDesktopPane1.add(frmStaff);
            frmStaff.setSize(this.getWidth(),this.getHeight());
            frmStaff.setLocation(0,0);
            frmStaff.setVisible(true);
            }
            else
            {
            
                frmStaff.setSize(this.getWidth(),this.getHeight());
                frmStaff.setLocation(0,0);
                frmStaff.setVisible(true);
        }
    }                                        


205072 32, 80, 114
329d9c
56c596
7BE495
cff4d2