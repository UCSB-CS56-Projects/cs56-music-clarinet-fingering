package edu.ucsb.cs56.W12.jesse_katsumata.issue452;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
/**
 A JTextArea object that implements the MessageDestination interface.
 Used in TicTacToeComponent.
  
   @author Phill Conrad, Jesse Katsumata
   @version CS56 lecture notes 02.02.2011
   @see TicTacToeComponent
 */
public class JLabelMessageDestination extends JLabel implements MessageDestination
{
    /** 
	Create a JLabel that implements the MessageDestination interface.  This is a direct
	pass-thru to the JTextArea constructor.

	@param rows (see documentation for javax.swing.JTextArea)
	@param cols (see documentation for javax.swing.JTextArea)
	@see javax.swing.JLabel
    */
	
    public JLabelMessageDestination(){
	super();
    }
    public JLabelMessageDestination(String text) {
	super(text);
    }

    public void append(String msg){
	this.setText(msg);
    };
    public void appendPic(ImageIcon icon){
	this.setIcon(icon);
    };

}

