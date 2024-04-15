package FormPratice1;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import javax.swing.JLabel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;

public class Extand_Frame extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private File CurrentFile;
	private int CurrentPosition=0;
	private float fontSize = 12.0f;
	/**
	 * Create the frame.
	 */
	public Extand_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 576);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu FileControl = new JMenu("File");
		menuBar.add(FileControl);
		
		JMenuItem CreateFile = new JMenuItem("New");
		FileControl.add(CreateFile);
		CreateFile.setIcon(new ImageIcon(".\\Image\\newFile.png"));
		CreateFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText(null);
			}
			
		});
		
		JMenuItem openFile = new JMenuItem("Open");
		FileControl.add(openFile);
		openFile.setIcon(new ImageIcon(".\\Image\\openFile.png"));
		openFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openFile();
			}
			
		});
		
		JMenuItem SaveFile = new JMenuItem("Save");
		FileControl.add(SaveFile);
		SaveFile.setIcon(new ImageIcon(".\\Image\\saveFile.png"));
		SaveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveFile();
				
			}
			
		});
		JMenuItem Saveas = new JMenuItem("Save As...");
		FileControl.add(Saveas);
		Saveas.setIcon(new ImageIcon(".\\Image\\saveFileAs.png"));
		Saveas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveFileAs();
				
			}
			
		});
		JMenuItem CloseWindow = new JMenuItem("Exit");
		CloseWindow.setIcon(new ImageIcon(".\\Image\\close.png"));
		CloseWindow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				closeApplication();
			}
			
		});
		
		JSeparator separator_1 = new JSeparator();
		FileControl.add(separator_1);
		
	
		FileControl.add(CloseWindow);
		
		JMenu EditControl = new JMenu("Edit");
		menuBar.add(EditControl);
		
		
		
		
		//cut
		JMenuItem CutA = new JMenuItem("Cut");
		EditControl.add(CutA);
		CutA.setIcon(new ImageIcon(".\\Image\\Cut.png"));
		CutA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cutText();
			}
		});
		
		
		JMenuItem CopyA = new JMenuItem("Copy");
		EditControl.add(CopyA);
		CopyA.setIcon(new ImageIcon(".\\Image\\copy.png"));
		CopyA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				copyText();
			}
			
		});
		
		JMenuItem PasteA = new JMenuItem("Paste");
		EditControl.add(PasteA);
		PasteA.setIcon(new ImageIcon(".\\Image\\Paste.png"));
		PasteA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pasteText();
			}
		});
		
		JMenuItem DeleteA = new JMenuItem("Delete");
		EditControl.add(DeleteA);
		DeleteA.setIcon(new ImageIcon(".\\Image\\Delete.png"));
		DeleteA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteText();
			}
		});
		
		
		
		JSeparator separator = new JSeparator();
		EditControl.add(separator);
		
		JMenuItem FindA = new JMenuItem("Find");
		EditControl.add(FindA);
		FindA.setIcon(new ImageIcon(".\\Image\\SearchIcon.png"));
		FindA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Find();
			}
			
		});
		
		JMenuItem FindNextA = new JMenuItem("Find Next");
		EditControl.add(FindNextA);	
		FindNextA.setIcon(new ImageIcon(".\\Image\\findNext.png"));
		FindNextA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FindNext();
			}
			
		});
		
		
	
		JLabel ViewRate = new JLabel("Scale: 100%");
		
		
		
		JMenu ViewMenu = new JMenu("View");
		menuBar.add(ViewMenu);
		
		JMenuItem ZoomIn_button = new JMenuItem("Zoom In");
		ViewMenu.add(ZoomIn_button);
		ZoomIn_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				   fontSize += 2.0f;
	                updateFontSize();
	                
	                int scalePercentage = (int) (fontSize / 12.0f * 100);
	                ViewRate.setText("Scale: " + scalePercentage + "%");
			}
			
		});
		
		JMenuItem ZoomOut_button = new JMenuItem("Zoom Out");
		ViewMenu.add(ZoomOut_button);
		ZoomOut_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				   fontSize -= 2.0f;
	                updateFontSize();
	                
	                int scalePercentage = (int) (fontSize / 12.0f * 100);
	                ViewRate.setText("Scale: " + scalePercentage + "%");
			}
			
		});
		
		JMenuItem Input_ScaleRate = new JMenuItem("Zoom Rate");
		ViewMenu.add(Input_ScaleRate);
        Input_ScaleRate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = Integer.valueOf(JOptionPane.showInputDialog(Extand_Frame.this,"input Scale Rate : "));
                try {
                    fontSize = 12.0f * input/ 100;
                    updateFontSize();
                    int scalePercentage = (int) (fontSize / 12.0f * 100);
	                ViewRate.setText("Scale: " + scalePercentage + "%");
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    JOptionPane.showMessageDialog(Extand_Frame.this,
                            "Invalid input. Please enter a valid scale rate.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
		
		
		JSeparator separator_2 = new JSeparator();
		ViewMenu.add(separator_2);
		JMenuItem Default_ViewButton = new JMenuItem("Default");
		ViewMenu.add(Default_ViewButton);
		Default_ViewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 fontSize = 12.0f;
	                updateFontSize();
	                int scalePercentage = (int) (fontSize / 12.0f * 100);
	                ViewRate.setText("Scale: " + scalePercentage + "%");
			}
			
		});
		
		JMenu Help = new JMenu("Help");
		menuBar.add(Help);
		
		JMenuItem About = new JMenuItem("About");
		Help.add(About);
		About.setIcon(new ImageIcon(".\\Image\\a.png"));
		About.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(About, "notepad v0.1","About notepad",JOptionPane.QUESTION_MESSAGE);
			}
			
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(textArea, popupMenu);
		
		JMenuItem CutR = new JMenuItem("Cut");
		popupMenu.add(CutR);
		CutR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cutText();
			}
			
		});
		
		JMenuItem CopyR = new JMenuItem("Copy");
		popupMenu.add(CopyR);
		CopyR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				copyText();
			}
			
		});
		
		JMenuItem PasteR = new JMenuItem("Paste");
		popupMenu.add(PasteR);
		PasteR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pasteText();
			}
			
		});
		
		JMenuItem DeleteR = new JMenuItem("Delete");
		popupMenu.add(DeleteR);
		
		JSeparator separator_3 = new JSeparator();
		popupMenu.add(separator_3);
		
		JMenuItem Find_NextR = new JMenuItem("Find Next");
		popupMenu.add(Find_NextR);
		Find_NextR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FindNext();
			}
			
		});
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel StatusLabel = new JLabel("行: 1 列: 1");
		panel.add(StatusLabel);
		
		JLabel encodingLabel = new JLabel("Encoding mode : " + Charset.defaultCharset().displayName());
		panel.add(encodingLabel);
		
	
		panel.add(ViewRate);
		
		
	    // 監聽文字編輯區域的變動，更新行數和列數
        textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
            	   int caretPosition = textArea.getCaretPosition();
            	    int currentLine = 0;
            	    int currentColumn = 0;
            	    try {
            	        currentLine = textArea.getLineOfOffset(caretPosition) + 1;
            	        currentColumn = caretPosition - textArea.getLineStartOffset(currentLine - 1) + 1;
            	    } catch (Exception ex) {
            	        ex.printStackTrace();
            	    }
            	    StatusLabel.setText("Row : " + currentLine + " Column : " + currentColumn );
            }

        });
		DeleteR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteText();
			}
			
		});
	}
    private void cutText() {
      textArea.cut();
    }
    private void copyText() {
      textArea.copy();
    }
    private void pasteText() {
    	textArea.paste();
    }	
    private void deleteText() {
        int start = textArea.getSelectionStart();
        int end = textArea.getSelectionEnd();
        if (start != end) {
            textArea.replaceRange("", start, end);
        }
    }
    private void openFile() {
    	JFileChooser f=new JFileChooser();
		int ret = f.showOpenDialog(null);
		if(ret == JFileChooser.APPROVE_OPTION) {
			File tmp=f.getSelectedFile();
			CurrentFile=tmp;
			if(tmp.isFile()) {
				try {
					FileReader fr = new FileReader(tmp);
					BufferedReader br=new BufferedReader(fr);
					String content="";
					/*
					String rtmp="";
					while((rtmp=br.readLine())!=null) {
						content=content+rtmp+"\n";
					}*/
					setTitle(tmp.toString()+" - Notepad v0.1");
					
					
					int rtmp=-1;
					while((rtmp=br.read())!=-1) {
						content=content+(char)rtmp;
					}
					br.close();
					fr.close();
					textArea.setText(content);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
    }
	    
   
    private void saveFile() {
    	
        if (CurrentFile !=null) {
        	try {
        	FileWriter FW=new FileWriter(CurrentFile);
        	String  content = textArea.getText();
        	FW.write(content);
        	FW.flush();
        	FW.close();
        	setTitle(CurrentFile.getAbsolutePath() + " - NotePad v0.1");
        	}
        	catch(IOException e1) {
        		
        	}
        }
    }
    private void saveFileAs() {
        File file = getFileToSave();
        String tmp=file.getName();
        if (file != null) {
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(textArea.getText());
                writer.close();
                setTitle(tmp + " - notepad v0.1");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "檔案儲存失敗");
            }
        }
    }   
    private File getFileToSave() {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }
    private void closeApplication() {
    	System.exit(0);
    }
    private String S_stringtemp="";
    private void Find() {
    	String S_string=JOptionPane.showInputDialog(Extand_Frame.this,"input Search Text : ");
    	if(S_string!=null && S_string.length()>0) {
    		String content=textArea.getText();
    		int position=content.indexOf(S_string,0);
    		if(position!=-1) {
    			textArea.setSelectionStart(position);
    			textArea.setSelectionEnd(position+S_string.length());
    			CurrentPosition=position + S_string.length();
    			S_stringtemp=S_string;
    		}
    	}
    }
    private void FindNext() {
    	
    	if(S_stringtemp!=null && S_stringtemp.length()>0) {
    		String content=textArea.getText();
    		int position=content.indexOf(S_stringtemp,CurrentPosition);
    		
    		if(position!=-1) {
    			textArea.setSelectionStart(position);
    			textArea.setSelectionEnd(position+S_stringtemp.length());
    			CurrentPosition=position + S_stringtemp.length();
    			
    		}
    		else if(position==-1) {
    			CurrentPosition=0;
    			position=content.indexOf(S_stringtemp,CurrentPosition);
    			textArea.setSelectionStart(position);
    			textArea.setSelectionEnd(position+S_stringtemp.length());
    			CurrentPosition=position + S_stringtemp.length();

			}
    	}
    }
    
    private void updateFontSize() {
        Font currentFont = textArea.getFont();
        Font newFont = currentFont.deriveFont(fontSize);
        textArea.setFont(newFont);
        
   
    }
  
    
    
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
