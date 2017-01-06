import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;


public class TextInputGUI extends JFrame {
	
	private static final long serialVersionUID = -4024381676778839713L;

	JTextArea 	systemOutput = new JTextArea();
	JTextArea 	textToTalk = new JTextArea();		
	JButton 	talkButton = new JButton("Talk");
	
	TalkListener buttonPressedListener;
	
	public TextInputGUI(){
		
		setTitle("FreeTTS Text Input.");
		setBounds(0, 0, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(textToTalk, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(talkButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
							.addComponent(talkButton)
							.addGap(35))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(textToTalk, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		systemOutput.setEditable(false);
		scrollPane.setViewportView(systemOutput);
		getContentPane().setLayout(groupLayout);
		
		talkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt = textToTalk.getText();
				textToTalk.setText("");
				
				systemOutput.append(txt+"\n");
				textToTalk.requestFocus();
				
				if(buttonPressedListener!=null) 
					buttonPressedListener.actionPerformed(txt);
			}
		});
		
		textToTalk.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
				    talkButton.doClick();
				};	
			}
		});
		
		setVisible(true);
	}
	
	public void setTalkListener(TalkListener talkListener){
		this.buttonPressedListener = talkListener;
	}
	
	public static interface TalkListener{
		public void actionPerformed(String s);
	}
	
	
}
