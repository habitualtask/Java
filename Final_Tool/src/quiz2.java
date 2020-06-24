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
 
 // 그러므로 메뉴아이템을 여기다가  메뉴
 JMenuItem mnuNew, mnuSave, mnuOpen, mnuSaveus;
 
 // 팝업 메뉴
 JPopupMenu popup;
 JMenuItem m_white, m_blue, m_yellow;
 
 public quiz2() {
  super("제목없음 - 메모장");
  
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
 
 private void menuLayout() {        // 메뉴아이템은 여기서 만들고
  JMenuBar menuBar = new JMenuBar();
  
  JMenu mnuFile = new JMenu("File");     	// 주메뉴
  mnuNew = new JMenuItem("New");     		// 부메뉴
  mnuOpen  = new JMenuItem("Open");
  mnuSave = new JMenuItem("Save");
  mnuSaveus = new JMenuItem("Saveus");
  
  mnuFile.add(mnuNew);
  mnuFile.add(mnuOpen);
  mnuFile.add(mnuSave);
  mnuFile.add(mnuSaveus);
  
  menuBar.add(mnuFile);
  setJMenuBar(menuBar);       			// Frame에 메뉴바 장착
  
  mnuNew.addActionListener(this);      	// 메뉴에 리스너 장착
  mnuSave.addActionListener(this);
  mnuOpen.addActionListener(this);
  mnuSaveus.addActionListener(this);
  
  // 팝업 메뉴(우클릭시 출현)
  popup = new JPopupMenu();
  JMenu m_col = new JMenu("색상 선택");
  m_white = new JMenuItem("하양");
  m_blue = new JMenuItem("파랑");
  m_yellow = new JMenuItem("노랑");
  m_col.add(m_white);
  m_col.add(m_blue);
  m_col.add(m_yellow);
  m_white.addActionListener(this);
  m_blue.addActionListener(this);
  m_yellow.addActionListener(this);
  popup.add(m_col);  				// 팝업에 주는것
  txtMemo.add(popup);   			// 팝업 메뉴 추가
  
  txtMemo.addMouseListener(new MouseAdapter() {
   @Override
   public void mousePressed(MouseEvent e) {
    // 오른쪽 버튼 클릭 시 ...
    if(e.getModifiers() == MouseEvent.BUTTON3_MASK) { // 왼쪽이 1 가운데가 2 오른쪽이 3   BUTTON3_MASK - 오른쪽 버튼
     popup.show(txtMemo, e.getX(), e.getY());
    }
   }
  });
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {   // 메뉴아이템 실행은 여기
 
  //새문서
  if(e.getSource() == mnuNew) {   
   txtMemo.setText("");
   setTitle("제목없음 - 메모장");
  
  //열기
  } else if(e.getSource() == mnuOpen) {    // 열기
   FileDialog dialog = new FileDialog(this, "열기", FileDialog.LOAD);
   dialog.setDirectory(".");  						// .은 지금폴더
   dialog.setVisible(true);   						// 박스는 그냥 틀이고
   if(dialog.getFile() == null) return;
   String dfName = dialog.getDirectory() + dialog.getFile();  // 경로명 파일명
   
   try {
    BufferedReader reader = new BufferedReader(new FileReader(dfName));
    txtMemo.setText("");
    String line;
    while((line = reader.readLine()) != null) {     // 읽어온 문서의 줄이 없어지면
     txtMemo.append(line + "\n");       			// txtMemo에 추가
    }
    reader.close();
    
    setTitle(dialog.getFile() + " - 메모장" );
   } catch (Exception e2) {
    JOptionPane.showMessageDialog(this, "열기 오류");
   }
   
 //저장
   } else if(e.getSource() == mnuSave) {    
    // 파일 작업을 위한 경로명 및 파일명 얻기
    FileDialog dialog = new FileDialog(this, "저장", FileDialog.SAVE);
    dialog.setDirectory("."); 				// .은 지금폴더
    dialog.setVisible(true);   				// 박스는 그냥 틀이고
    if(dialog.getFile() == null) return; 	// 이걸빼면 취소를 해도 저장이됨
    String dfName = "txt";					// 경로명 파일명
    // System.out.println(dfName);
    // 실제 저장은 여기에서
    try {
     BufferedWriter writer = new BufferedWriter(new FileWriter(dfName));
     writer.write(txtMemo.getText());
     writer.close();
     
     setTitle(dialog.getFile() + " - 메모장" );
    } catch (Exception e2) {
     JOptionPane.showMessageDialog(this, "저장 오류");
    }
   
  //다른이름으로저장
  } else if(e.getSource() == mnuSaveus) {    
// 파일 작업을 위한 경로명 및 파일명 얻기
   FileDialog dialog = new FileDialog(this, "다른이름으로 저장", FileDialog.SAVE);
   dialog.setDirectory(".");   				// .은 지금폴더
   dialog.setVisible(true);   				// 박스는 그냥 틀이고
   if(dialog.getFile() == null) return;		// 이걸빼면 취소를 해도 저장이됨
   String dfName = dialog.getDirectory() + dialog.getFile();  // 경로명 파일명
   // System.out.println(dfName);
   // 실제 저장은 여기에서
   try {
    BufferedWriter writer = new BufferedWriter(new FileWriter(dfName));
    writer.write(txtMemo.getText());
    writer.close();
    
    setTitle(dialog.getFile() + " - 메모장" );
   } catch (Exception e2) {
    JOptionPane.showMessageDialog(this, "저장 오류");
   }
   
  //우클릭시에 나타나는 팝업메뉴에 대한 설정
  } else if(e.getSource() == m_white) {   // 팝업메뉴
   txtMemo.setBackground(Color.WHITE);
  } else if(e.getSource() == m_blue) {   // 팝업메뉴
   txtMemo.setBackground(Color.BLUE);
  } else if(e.getSource() == m_yellow) {   // 팝업메뉴
   txtMemo.setBackground(Color.YELLOW);
  } 
  txtMemo.requestFocus();
 }
 
 public static void main(String[] args) {
  new quiz2();
 }

}