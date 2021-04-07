every function or para have to be written in English

#fffdb8	(255,253,184)
#fdf68c	(253,246,140)
#f4cd2a	(244,205,42)
#eda323	(237,163,35)
#d28d0d	(210,141,13)

///init boolean full_screen = frmLogIn.full_screen;

private void formWindowStateChanged(java.awt.event.WindowEvent evt) {                                        
        // TODO add your handling code here:
        if (full_screen == true)
        {
            full_screen = false;
        }
        else
        {
            full_screen = true;
        }
        
        frmLogIn.full_screen = full_screen;
    } 



	if (full_screen == true)
        {  
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        else
        {
            setSize(794,612);
        }