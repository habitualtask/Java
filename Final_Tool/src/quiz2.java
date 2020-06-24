import java.awt.Color;
import java.awt.FileDialog;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import javax.swing.*;

public class quiz2 extends JFrame implements ActionListener{
 JTextArea txtMemo = new JTextArea("", 10, 40);
 String copyText;
 
 // �׷��Ƿ� �޴��������� ����ٰ�  �޴�
 JMenuItem mnuNew, mnuSave, mnuOpen, mnuSaveus;
 
 // �˾� �޴�
 JPopupMenu popup;
 JMenuItem m_white, m_blue, m_yellow;
 
 public quiz2() {
  super("������� - �޸���");
  
 initLayout();
  menuLayout();
  setBounds(200, 200, 400, 350);
  setVisible(true);
  //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 
 private void initLayout() {
  JPanel panel = new JPanel();
  add("Center", txtMemo);
 }
 
 private void menuLayout() {        // �޴��������� ���⼭ �����
  JMenuBar menuBar = new JMenuBar();
  
  JMenu mnuFile = new JMenu("File");     	// �ָ޴�
  mnuNew = new JMenuItem("New");     		// �θ޴�
  mnuOpen  = new JMenuItem("Open");
  mnuSave = new JMenuItem("Save");
  mnuSaveus = new JMenuItem("Saveus");
  
  mnuFile.add(mnuNew);
  mnuFile.add(mnuOpen);
  mnuFile.add(mnuSave);
  mnuFile.add(mnuSaveus);
  
  menuBar.add(mnuFile);
  setJMenuBar(menuBar);       			// Frame�� �޴��� ����
  
  mnuNew.addActionListener(this);      	// �޴��� ������ ����
  mnuSave.addActionListener(this);
  mnuOpen.addActionListener(this);
  mnuSaveus.addActionListener(this);
  
  // �˾� �޴�(��Ŭ���� ����)
  popup = new JPopupMenu();
  JMenu m_col = new JMenu("���� ����");
  m_white = new JMenuItem("�Ͼ�");
  m_blue = new JMenuItem("�Ķ�");
  m_yellow = new JMenuItem("���");
  m_col.add(m_white);
  m_col.add(m_blue);
  m_col.add(m_yellow);
  m_white.addActionListener(this);
  m_blue.addActionListener(this);
  m_yellow.addActionListener(this);
  popup.add(m_col);  				// �˾��� �ִ°�
  txtMemo.add(popup);   			// �˾� �޴� �߰�
  
  txtMemo.addMouseListener(new MouseAdapter() {
   @Override
   public void mousePressed(MouseEvent e) {
    // ������ ��ư Ŭ�� �� ...
    if(e.getModifiers() == MouseEvent.BUTTON3_MASK) { // ������ 1 ����� 2 �������� 3   BUTTON3_MASK - ������ ��ư
     popup.show(txtMemo, e.getX(), e.getY());
    }
   }
  });
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {   // �޴������� ������ ����
 
  //������
  if(e.getSource() == mnuNew) {   
   txtMemo.setText("");
   setTitle("������� - �޸���");
  
  //����
  } else if(e.getSource() == mnuOpen) {    // ����
   FileDialog dialog = new FileDialog(this, "����", FileDialog.LOAD);
   dialog.setDirectory(".");  						// .�� ��������
   dialog.setVisible(true);   						// �ڽ��� �׳� Ʋ�̰�
   if(dialog.getFile() == null) return;
   String dfName = dialog.getDirectory() + dialog.getFile();  // ��θ� ���ϸ�
   
   try {
    BufferedReader reader = new BufferedReader(new FileReader(dfName));
    txtMemo.setText("");
    String line;
    while((line = reader.readLine()) != null) {     // �о�� ������ ���� ��������
     txtMemo.append(line + "\n");       			// txtMemo�� �߰�
    }
    reader.close();
    
    setTitle(dialog.getFile() + " - �޸���" );
   } catch (Exception e2) {
    JOptionPane.showMessageDialog(this, "���� ����");
   }
   
 //����
   } else if(e.getSource() == mnuSave) {    
    // ���� �۾��� ���� ��θ� �� ���ϸ� ���
    FileDialog dialog = new FileDialog(this, "����", FileDialog.SAVE);
    dialog.setDirectory("."); 				// .�� ��������
    dialog.setVisible(true);   				// �ڽ��� �׳� Ʋ�̰�
    if(dialog.getFile() == null) return; 	// �̰ɻ��� ��Ҹ� �ص� �����̵�
    String dfName = "txt";					// ��θ� ���ϸ�
    // System.out.println(dfName);
    // ���� ������ ���⿡��
    try {
     BufferedWriter writer = new BufferedWriter(new FileWriter(dfName));
     writer.write(txtMemo.getText());
     writer.close();
     
     setTitle(dialog.getFile() + " - �޸���" );
    } catch (Exception e2) {
     JOptionPane.showMessageDialog(this, "���� ����");
    }
   
  //�ٸ��̸���������
  } else if(e.getSource() == mnuSaveus) {    
// ���� �۾��� ���� ��θ� �� ���ϸ� ���
   FileDialog dialog = new FileDialog(this, "�ٸ��̸����� ����", FileDialog.SAVE);
   dialog.setDirectory(".");   				// .�� ��������
   dialog.setVisible(true);   				// �ڽ��� �׳� Ʋ�̰�
   if(dialog.getFile() == null) return;		// �̰ɻ��� ��Ҹ� �ص� �����̵�
   String dfName = dialog.getDirectory() + dialog.getFile();  // ��θ� ���ϸ�
   // System.out.println(dfName);
   // ���� ������ ���⿡��
   try {
    BufferedWriter writer = new BufferedWriter(new FileWriter(dfName));
    writer.write(txtMemo.getText());
    writer.close();
    
    setTitle(dialog.getFile() + " - �޸���" );
   } catch (Exception e2) {
    JOptionPane.showMessageDialog(this, "���� ����");
   }
   
  //��Ŭ���ÿ� ��Ÿ���� �˾��޴��� ���� ����
  } else if(e.getSource() == m_white) {   // �˾��޴�
   txtMemo.setBackground(Color.WHITE);
  } else if(e.getSource() == m_blue) {   // �˾��޴�
   txtMemo.setBackground(Color.BLUE);
  } else if(e.getSource() == m_yellow) {   // �˾��޴�
   txtMemo.setBackground(Color.YELLOW);
  } 
  txtMemo.requestFocus();
 }
 
 public static void main(String[] args) {
  new quiz2();
 }

}