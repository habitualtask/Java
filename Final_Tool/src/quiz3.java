import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.*;
import java.awt.event.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 

class quiz3 implements ActionListener{
	private JFileChooser chooser;
	private JLabel imageLabel = new JLabel();

	public quiz3() {
			chooser = new JFileChooser(); }
	public void actionPerformed(ActionEvent e) {
	FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
	chooser.setFileFilter(filter);
	int ret = chooser.showOpenDialog(null);
	if(ret != JFileChooser.APPROVE_OPTION) {
		JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다", "경고",JOptionPane.WARNING_MESSAGE);
		return;	}
	String filePath = chooser.getSelectedFile().getPath(); 
	imageLabel.setIcon(new ImageIcon(filePath)); 
	//pack(); // 이미지의 크기에 맞추어 프레임 크기 조절
	}
}