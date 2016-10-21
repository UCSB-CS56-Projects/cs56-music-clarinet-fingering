package edu.ucsb.cs56.W12.jesse_katsumata.issue452;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;
import java.net.URL;
import java.util.*;
import java.io.*;

/** a GUI for Clarinet Fingering Chart
@author Jesse Katsumata
@version CS56 W12 issue 452
*/

public class FingerChart extends JFrame implements ActionListener{

    /** Constructor
     *
     */
    
    public FingerChart(){
	super("Clarinet Fingering Chart");
    };

    JLabelMessageDestination InfoLabel;
    JLabelMessageDestination image;
    JComboBox List;
    JRadioButton rb1;
    JRadioButton rb2;
    ButtonGroup bg;
    String Note;
    String Info;
    ArrayList<String> NList = new ArrayList<String>();

    /** main
    @param  String[] args
    */

    public static void main(String[] args){
	FingerChart frame = new FingerChart();
	frame.go();
	frame.setBounds(100,100,600,400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	frame.setVisible(true);

    }
    
    /**Brings up the gui with the fingering chart
     */

    public void go(){
	//get the list of notes from List.txt
	URL nl = getClass().getResource("/text/List.txt");
	//put each line of List.txt to an arraylist
	urlToArrayList(nl);

	//ComboBox: List of notes
	List = new JComboBox(NList.toArray());
	List.addActionListener(this);
	JLabel Label1 = new JLabel("Select a Note:");

	//RadioButton: to switch between Standard and Alternate Fingering
	rb1 = new JRadioButton("Standard Fingering",true);
	rb2 = new JRadioButton("Alternate Fingering");
	bg = new ButtonGroup();
	bg.add(rb1);
	bg.add(rb2);
       	rb1.addActionListener(this);
	rb2.addActionListener(this);

	JPanel p1 = new JPanel();
	FlowLayout layout = new FlowLayout();
	layout.setAlignment(FlowLayout.LEFT);
	p1.setLayout(layout);
	p1.add(Label1);
	p1.add(List);
	p1.add(rb1);
	p1.add(rb2);

	//add info about the Note
	
	JPanel p2 = new JPanel();
	InfoLabel = new JLabelMessageDestination();
	p2.add(InfoLabel);

	//add picture of the fingering

	JPanel p3 = new JPanel();
	image = new JLabelMessageDestination();

	p3.add(image);

	getContentPane().add(p1,BorderLayout.NORTH);
	getContentPane().add(p2,BorderLayout.SOUTH);
	getContentPane().add(p3,BorderLayout.CENTER);
    }



    /** Action listener for the combobox; shows the fingering for the selected note.

       @param ActionEvent e
     */
    public void actionPerformed(ActionEvent e){
	

	if (List.getSelectedIndex() == -1)
	    this.Note = "Select A Note";
	else {
	    this.Note = (String)List.getSelectedItem();
	    this.Info = Note;
	    if(rb1.isSelected())
		this.Info += ":Standard Fingering";
	    if(rb2.isSelected())
		this.Info += ":No Alternate Fingering Available(yet)";
	}
		    
	InfoLabel.append(Info);
	URL im = getClass().getResource("/Pic/"+Note+".png");
	ImageIcon icon=new ImageIcon(im);
	image.appendPic(icon);
    }

    /** Reads a txt file in URL and adds them to an ArrayList
	@param URL url
    */

    public void urlToArrayList(URL url){
	BufferedReader br = null;
	try {
	    InputStreamReader in = new InputStreamReader(url.openStream());
	    br = new BufferedReader(in);
	    
	    String line;
	    while ((line = br.readLine()) != null){
		NList.add(line);
	    }
	    br.close();
	    in.close();
	}catch(IOException e){}   
    }

}


