import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

public class ebook<Items> extends JFrame {
	private static Process process;
	private static String str;
	private static InputStream in;
	private static Reader reader;
	private static BufferedReader bReader;
	private static String res;
	private static StringBuffer resStr;
	private Button SelectFile = new Button("����ɮ׸��|");
	private Button init = new Button("gitbook init");
	private Button epub = new Button("gitbook epub");
	private Button pdf = new Button("gitbook pdf");
	private Button web = new Button("gitbook web");
	private Button mobi = new Button("gitbook mobi");
	private Button pandoc = new Button("gitbook pandoc");
	private GridLayout Features;
	private Container Feature;
	private String[] data = new String[10];
	private String selectedFile = new String();
	private JPanel pan = new JPanel(null);
	private JComboBox box = new JComboBox();
	private Boolean b;

	public ebook() {
		intcomp();
	}

	public void intcomp() {
		// TODO Auto-generated method stub
		this.setBounds(50, 50, 800, 600);
		this.setLayout(new BorderLayout());
		Features = new GridLayout(7, 1);
		Feature = new Container();
		this.add(Feature, BorderLayout.WEST);
		Feature.setLayout(Features);
		Font f = new Font("�з���", Font.BOLD, 30);
		init.setFont(f);
		epub.setFont(f);
		pdf.setFont(f);
		web.setFont(f);
		mobi.setFont(f);
		pandoc.setFont(f);
		SelectFile.setFont(f);
		Feature.add(SelectFile);
		Feature.add(init);
		Feature.add(epub);
		Feature.add(pdf);
		Feature.add(web);
		Feature.add(mobi);
		Feature.add(pandoc);

		SelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				JFileChooser fileChooser = new JFileChooser();// �ŧifilechooser
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// �u���ܥؿ�
				int returnValue = fileChooser.showOpenDialog(null);// �s�Xfilechooser
				if (returnValue == JFileChooser.APPROVE_OPTION) // �P�_�O�_����ɮ�
				{
					selectedFile = fileChooser.getSelectedFile().getPath();// ������File
					System.out.println(selectedFile); // �L�X�ɦW
					File file = new File(selectedFile + "\\gitbook.txt"); // �Q�P�_�ɮ׬O�_�s�b���ɮצ�m
					b = file.exists();
					System.out.println(file.exists());// �P�_�ɮ׬O�_�s�b�^�ǥ��L��
					if (!file.exists()) {
						System.out.println("no");
					} else {
						System.out.println("yes");
					}
					/*
					 * data[0] = selectedFile;
					 * 
					 * 
					 * for (int i = 0; i < 10; i++) { data[i + 1] = data[0]; }
					 * 
					 * } System.out.println(data[0]);
					 */
				}
			}
		});
		if (b == false) {
			init.disable();
		} else {
			init.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("gitbook init " + selectedFile);
					try {
						str = "cmd /c gitbook init " + selectedFile;
						process = Runtime.getRuntime().exec(str);

						/*
						 * in = process.getInputStream(); reader = new
						 * InputStreamReader(in); bReader = new
						 * BufferedReader(reader); for (res = ""; (res =
						 * bReader.readLine()) != null;) { // resStr.append(res
						 * + "\n"); } bReader.close(); reader.close(); //
						 * System.out.println(resStr.toString());
						 */
					} catch (IOException ae)

					{

					}
				}
			});
		}

		epub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("gitbook epub " + selectedFile);
				try {
					str = "gitbook epub " + selectedFile;
					process = Runtime.getRuntime().exec(str);

					in = process.getInputStream();
					reader = new InputStreamReader(in);
					bReader = new BufferedReader(reader);
					for (res = ""; (res = bReader.readLine()) != null;) {
						resStr.append(res + "\n");
					}
					bReader.close();
					reader.close();
					System.out.println(resStr.toString());

				} catch (IOException ae)

				{

				}
			}
		});
		pdf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("gitbook pdf " + selectedFile);
				try {
					str = "cmd /c gitbook pdf" + " " + selectedFile;
					process = Runtime.getRuntime().exec(str);
					in = process.getInputStream();
					reader = new InputStreamReader(in);
					bReader = new BufferedReader(reader);
					/*
					 * for (res = ""; (res = bReader.readLine()) != null;) {
					 * resStr.append(res + "\n"); }
					 */
					bReader.close();
					reader.close();
					// System.out.println(resStr.toString());

				} catch (IOException ae)

				{

				}
			}
		});

		/*
		 * box.setBounds(50, 50, 400, 30);
		 * 
		 * for (int i = 0; i < 10; i++) { box.addItem(data[0]); }
		 * 
		 * box.addItem(data[0]); pan.add(box); this.add(pan);
		 */

	}

}