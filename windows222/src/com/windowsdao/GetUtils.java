package com.windowsdao;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileView;

import com.sun.istack.internal.FinalArrayList;

public class GetUtils {

	// static //��ȡ·��
	// ��ȡ����
	File resultFile;
	int result = 0;
	String result1;
//	 FileReader fr;
	final static String listAll = "D:\\SoftText\\list\\";
	final static String ini = ".ini";
	final static File config = new File("D:\\SoftText\\config\\config.ini");

	/**
	 * ִ��Bat�ļ��ķ���
	 * 
	 * @throws IOException
	 * 
	 * 
	 */
	public boolean StartFile(File newpath) throws IOException {
//		windows��
//		Runtime.getRuntime().exec("explorer �ļ�·����);
//		Linux��
//		Runtime.getRuntime().exec("nautilus �ļ�·����);

		// ��ʼ
		if (!newpath.isFile() && !newpath.isDirectory()) {
			System.out.println("��������");
			return false;
		} else {

			Process po = Runtime.getRuntime().exec("explorer " + newpath);
			// ִ����ɺ���ֹ�ý���
//			po.destroy();������ֹ�ᵼ������ʧ��
			return po.isAlive();
		}

	}

	/**
	 * ��ѡ���Ŀ�����д���ļ�,�����ļ�ѡ������ȡ��·�������洢ΪĬ�ϵ�������Ϣ ����ļ��з���ֵ2������ļ�����ֵ1�����ϵͳͼ�꣬����ֵ3
	 * 
	 */
	public int setText(File path, String category) {

		int a = 0;
		int b = 0;
		String par = path.getParent().substring(0, 1);
		if (par.equals("1")) {
			String paths = path.getPath();
			path = new File(paths.substring(1, paths.length()));
			b = 1;
		}

		// ��ȡ��Ӧ�ķ����ļ�
		File files = new File(listAll + category + ".ini");
		if (!files.exists()) {

		}
		try {
			files.createNewFile();
			FileWriter fw = new FileWriter(files, true);
			// �ж�Ҫ������ļ�·��
			if (path.isFile()) {
				// ������ļ��������ļ��༭�Ĺ��������µ�String����files��
				int ass = path.getName().lastIndexOf(".");
				String name1 = path.getName().substring(0, ass);
				fw.write(name1 + ":" + path.getPath());
				a = 1;
			} else if (path.isDirectory()) {
				// ������ļ��������ļ��еĹ���洢
				String s0 = path.getPath().substring(0, 1);

				String name2 = s0 + "��" + path.getName();
				fw.write(name2 + ":" + path.getPath());
				a = 2;
			}

			fw.write("\r\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b == 0) {

			return a;
		} else {
			return 3;

		}
	}

	/**
	 * ͨ��name��ȡ�ļ�����Ҫ��Ŀ��·�� ���������,��������·��
	 * 
	 * @throws IOException
	 * 
	 */
	public File getTextPath(String name, String category) {
		// path="΢��";
		File files = new File(listAll + category + ".ini");
		FileReader fr = null;
		BufferedReader br = null;
		if (!files.exists()) {
			files.getParentFile().mkdir();
		}
		try {
			files.createNewFile();
			fr = new FileReader(files);
			br = new BufferedReader(fr);
			result1 = br.readLine();

			while (null != (result1 = br.readLine())) {
				int a = result1.indexOf(":");
				if (result1.equals("") || result1.equals(" ") || result1.equals("\r\n")) {
				} else {
					String name1 = result1.substring(0, a);
					if (name1.equals(name)) {
						resultFile = new File(result1.substring(a + 1, result1.length()));
						return resultFile;
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return resultFile;

	}

	/**
	 * 
	 * @param pathl:�ļ�·���� ͨ��·����ȡСͼ��
	 * @return ͼ��
	 */
	public Icon getSmallIcon(File file) {
//		Image aa= ((ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(file)).getImage();
//		Icon cc=new ImageIcon(aa);
		FileSystemView fsv = FileSystemView.getFileSystemView();
		return fsv.getSystemIcon(file);
	}

	/**
	 * ��ȡ��ͼ��
	 * 
	 * @param file
	 * @return
	 */
	public Icon getBigIcon(File file) {

		if (file != null && file.exists()) {
			try {
				sun.awt.shell.ShellFolder sf = sun.awt.shell.ShellFolder.getShellFolder(file);
				return new ImageIcon(sf.getIcon(true));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	// getCategory
	/**
	 * �������еķ���ļ���
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> getCategory()  {
		// String result1=null;
		File fff = new File(listAll);
		String[] ac = fff.list();
		String name = new String();
		ArrayList<String> namelist = new ArrayList<String>();
		for (int a = 0; a < ac.length; a++) {
			int s = ac[a].indexOf(".");
			name = ac[a].substring(0, s);

			namelist.add(name);

		}

		return namelist;
	}
	
	public Dimension getWindowsSize() {
		
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		int w=dim.width;
		int h=dim.height;
		
		return dim;
		
	}

	/**
	 * ���س�������ƽ����
	 * 
	 * @param name,���س�������ƽ����
	 * @return
	 */
	public ArrayList<String> getExEnames(String name) {
		ArrayList<String> namelist = new ArrayList<String>();
		File files = new File(listAll + name + ".ini");
		FileReader fr = null;
		BufferedReader br = null;

		if (!files.exists()) {
			files.getParentFile().mkdir();
		}
		try {
			files.createNewFile();
			fr = new FileReader(files);
			br = new BufferedReader(fr);
			result1 = br.readLine();

			while (null != (result1 = br.readLine())) {
				if (result1.equals("") || result1.equals(" ")) {

				} else {
					int a = result1.indexOf(":");
					// int a=result.lastIndexOf(":");
					String name1 = result1.substring(0, a);
					namelist.add(name1);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return namelist;

	}

	/**
	 * 
	 * @param name ��������
	 */
	public boolean setFileName(String name) {
		boolean res = false;
		File files = new File(listAll + name + ".ini");
		FileReader fr = null;
		BufferedReader bufr = null;
		if (!files.exists()) {
			files.getParentFile().mkdir();
			try {
				files.createNewFile();
				fr = new FileReader(files);
				bufr = new BufferedReader(fr);
				result1 = bufr.readLine();
				if (result1 == null) {
					FileWriter fw = new FileWriter(files, true);
					fw.write("[-----------��ϵͳ�ļ�:����ɾ���޸ġ�----------]");
					fw.write("\r\n");
					fw.flush();
					fw.close();

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fr.close();
					bufr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			res = true;

		} else {
			res = false;
			// return res;

		}
		return res;
	}

	/**
	 * ɾ��f����
	 * 
	 * @param nameҪɾ�����ļ���
	 * @return trueɾ���ɹ�falseɾ��ʧ��
	 */

	public boolean removeCategory(String name) {
		boolean res = true;
		File files = new File(listAll + name + ".ini");
		if (!files.exists()) {
			res = false;
		} else {
			res = files.delete();
			System.out.println("ɾ������=" + res);

		}

		return res;

	}

	/**
	 * ɾ�������������
	 * 
	 * @param nameͼ������
	 * @param cateͼ�����
	 * @return ��������δɾ������
	 * @throws IOException
	 */
	ArrayList<String> getRemove(String name, File files) throws IOException {
		boolean resb = false;
		ArrayList<String> strl = new ArrayList<String>();
		BufferedReader bfr = null;
		FileReader fr = null;
		try {
			fr = new FileReader(files);
			bfr = new BufferedReader(fr);

			while ((result1 = bfr.readLine()) != null) {
				int a = result1.indexOf(":");

				String name1 = result1.substring(0, a);
				if (name1.equals(name)) {

				} else {
					strl.add(result1);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bfr.close();
			fr.close();
			resb = files.delete();
			System.gc();
		}

		if (resb) {
			return strl;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param list����д�������
	 * @param file��д���ļ�
	 * @throws IOException
	 * @throws Exception
	 */
	boolean setRemove(ArrayList<String> list, File files) throws Exception {

		if (list != null) {
			if (files.exists()) {
				files.delete();

			} else if (!files.exists()) {
				files.getParentFile().mkdir();
				files.createNewFile();
			}
			FileWriter fw = new FileWriter(files, true);

			for (String st : list) {
				fw.write(st);
				fw.write("\r\n");
				fw.flush();
			}
			fw.close();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ɾ��ָ������
	 * 
	 * @param category �������ڷ���
	 * @param oldName  / ��������
	 */
	public boolean RemoveName(String category, String oldName) {
		File files = new File(listAll + category + ".ini");

		boolean resR = true;
		try {
			// ������������category ��Ҫɾ��������
			ArrayList<String> list = this.getRemove(oldName, files);
			resR = this.setRemove(list, files);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resR;
	}

	/**
	 * ɾ�������������
	 * 
	 * @param name ͼ��/���������
	 * @param cate ͼ��/������������
	 * @return ���ظ��ĺ������δɾ������
	 * @throws IOException
	 */
	ArrayList<String> getNewName(String name, File files, String newName) throws IOException {
		ArrayList<String> strl = new ArrayList<String>();
		BufferedReader bfr = null;
		FileReader fr = null;
		try {
			fr = new FileReader(files);
			bfr = new BufferedReader(fr);

			while ((result1 = bfr.readLine()) != null) {
				int a = result1.indexOf(":");
				String name1 = result1.substring(0, a);
				if (name1.equals(name)) {
					String result11 = newName + result1.substring(a);
					System.out.println(result11);
					strl.add(result11);
				} else {
					strl.add(result1);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bfr.close();
			fr.close();
			files.delete();
		}
		return strl;
	}

	/**
	 * ������ /��������
	 * 
	 * @param name    ԭ��
	 * @param cate    ���ڷ���
	 * @param newName ������
	 */
	public void upDateName(String name, String cate, String newName) {
		File files = new File(listAll + cate + ".ini");

		if (name == null) {

		} else {

			try {
				this.setRemove(this.getNewName(name, files, newName), files);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean findName(String name, String cate) {
		ArrayList<String> strl = new ArrayList<String>();
		File files = new File(listAll + cate + ".ini");
		BufferedReader bfr = null;
		FileReader fr = null;
		int yss = 0, noo = 0;
		try {
			fr = new FileReader(files);
			bfr = new BufferedReader(fr);

			while ((result1 = bfr.readLine()) != null) {
				int a = result1.indexOf(":");
				String name1 = result1.substring(0, a);
				if (name1.equals(name)) {
					return false;
				} else {
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bfr.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ɾ���ɵ�cate��ini����һ���µ�
		}
		return true;
	}

	/**
	 * ���������޸ķ��������
	 * 
	 * @param name    ԭ��
	 * @param newName ������
	 */
//	public void UpdateName(String name, String newName) {
//		File files = new File(listAll+ name + ".ini");
//
//
//		try {
//			this.setRemove(this.getRemove(null, name), files);
//			this.removeCategory(name);
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	/**
	 * ����ink�ļ��������ļ�ѡ������������һ��File��������File���ļ�����Ŀ¼,������ļ��У����ļ�ѡ������ֱ�ӷ���һ���ļ���·��
	 * ������ļ�����᷵��һ��ink·����
	 * ������ص���ink·���������GetInk�еķ����������File����parse������������һ��String/���ߴ����File
	 * �жϷ��صĽ�������Ϊnull����ϵͳ����Ŀ�ݷ�ʽ��û��Ŀ��·������ʱ�������ļ�ѡ���������ص�.ink·���� ���򣬷��ص���Ŀ��·���� ��ʱ
	 * ��1�������ļ�ѡ����������File ��2���ж�File�Ƿ�Ϊ�ļ��У�3�����ļ��У�ֱ�ӷ��ظ�File
	 * 4�������ļ��У��ж��Ƿ�Ϊ��ݷ�ʽ.Ink�ļ������ǣ���ֱ�ӷ��ظ�File�� 5����.ink�ļ� ��
	 * ����GetInk��parse����������File��������ֵ�� 6������ֵΪnull��ֱ�ӷ��ظ�File,����Ϊnull��ת��File����
	 * 
	 * @param method
	 * @param category
	 * @return
	 * @throws Exception
	 */
	public File getInk(int method) {
		File file1 = null;
		try {
			// ����getpath�ļ�ѡ��������ȡ���ص�·��file1��
			file1 = getPath(method);

			if (file1.isFile()) {
				// ������ļ��������ж��ļ�����
				String nameF = file1.getName();
				// ��ȡ�ļ���׺
				int ccs = nameF.lastIndexOf(".");
				String fnk = nameF.substring((ccs + 1), nameF.length());
				if (fnk.equals("lnk")) {
					String resu = new GetInk().parse(file1);

					if (!resu.equals("l")) {
						file1 = new File(resu);
					} else {
						String filepath1 = "1" + file1.getPath();
						file1 = new File(filepath1);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ink==" + file1);
		return file1;

	}

	public boolean deleteCategory(String name) {
		File file = new File(listAll + name + ".ini");

		return file.delete();

	}

	static File getPath(int a) throws IOException {
		JFileChooser jfc = new JFileChooser();
		// �����ļ�����

		FileSystemView fsv = FileSystemView.getFileSystemView();
		jfc.setCurrentDirectory(fsv.getHomeDirectory());
		jfc.setDialogType(0);
		;
		// ʹ��ϵͳ�е�ͼ��
		jfc.setFileView(new FileView() {

			public Icon getIcon(File f) {
				return jfc.getFileSystemView().getSystemIcon(f);
			}
		});
		jfc.setApproveButtonText("ȷ��");

		if (a == 0) {
			jfc.setDialogTitle("��ѡ���ļ�");
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

		} else {
			jfc.setDialogTitle("��ѡ���ļ���");

			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		}
		jfc.showOpenDialog(jfc);
		File resultFile = new File(jfc.getSelectedFile().getPath());

		return resultFile;
	}

	/**
	 * �ڲ����������������ļ�����ȡ�ϴ����ʱ��ĵ�ַ
	 * 
	 * @param ff
	 * @return
	 * @throws IOException
	 */

	static File getfilepath() throws IOException {

		String result1;
		File f = null;

		FileReader fr = new FileReader(config);
		BufferedReader br = new BufferedReader(fr);
		result1 = br.readLine();

		while (null != (result1 = br.readLine())) {
			int a = result1.indexOf(":");
			// int a=result.lastIndexOf(":");
			String name1 = result1.substring(0, a);
			if (name1.equals("defaultPath")) {
				System.out.println("�ϴδ�·����" + result1);
				f = new File(result1.substring(a + 1, result1.length()));
				System.out.println(f);
			}
		}
		br.close();
		fr.close();
		return f;
	}

	/**
	 * �������ļ���·�����������޸��µ�·��������
	 * 
	 * @param path
	 * @return
	 */
	static ArrayList<String> ConfigGet(String path) {

//		File f1=new File("E:\\java�μ�\\ǿС�Ա����ĵ�");
		String result1;
		ArrayList<String> strl = new ArrayList<String>();
		BufferedReader bfr = null;
		FileReader fr = null;
		try {
			fr = new FileReader(config);
			bfr = new BufferedReader(fr);
			while ((result1 = bfr.readLine()) != null) {
				int a = result1.indexOf("=");
				String name1 = result1.substring(0, a);
				if (name1.equals("defaultPath")) {
					// ���µĵ�ַд��
					String newPath1 = "defaultPath=" + path;
					System.out.println("oldpath��==" + result1);
					System.out.println("newpath��==" + newPath1);
					strl.add(newPath1);

				} else {
					strl.add(result1);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bfr.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ɾ���ɵ�cate��ini����һ���µ�
		}

		return strl;

	}

	static void ConfigSet(ArrayList<String> list) {

		File files = new File("D:\\SoftText\\config\\config.ini");

	}

	/**
	 * ���������ļ��ķ�ʽ
	 * @throws Exception 
	 * 
	 */
	public ArrayList<String> ConfigFile() throws Exception {

		File files = new File("D:\\SoftText\\config\\config.ini");
		File listFile=new File(listAll);
		ArrayList<String> namelist = new ArrayList<String>();
		FileReader fr = null; BufferedReader bf=null;
		int listSize=this.getCategory().size();
		// ���������ļ��ķ�ʽ��1�� ���ж��Ƿ���ڣ���������ڣ���ɨ��listĿ¼������һ��Ĭ�ϵ������ļ���
		// 2 �� ����ļ��Ѿ����ڣ�
		// 2.1 �� �ж������ļ��У��������������listĿ¼�£�list��size�ĳ����Ƿ���ͬ�������ͬ����������һ���µ������ļ���
		// 2.2 �� ����ж���ͬ�����ļ����ݶ�ȡ�����ŵ������У�������
		if (!files.exists()) {
			files.getParentFile().mkdirs();
			try {
				files.createNewFile();
				//��ȡf����ĳ��Ⱥ�����ͬʱд��һ��Ĭ������
				FileWriter fw = new FileWriter(files, true);
				fw.write("[-----------��ϵͳ�ļ�:����ɾ���޸ġ�----------]"); 
				fw.write("\r\n"); fw.flush();
				ArrayList<String> lista=this.getCategory();
				for (String sl : lista) {
					fw.write(sl+":1,0"); 
					fw.write("\r\n"); 
					fw.flush();
				}
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(files.exists()) {
			//����Ѿ����ڣ��жϳ����Ƿ�����ϣ�������������������ɡ�
			//�Ȼ�ȡ�ļ�����

			fr = new FileReader(files);
			bf = new BufferedReader(fr);
			result1 = bf.readLine();
				int countl=0;
			while (null != (result1 = bf.readLine())) {
				// ��ȡ��һ���ַ�
				String head = result1.substring(0, 1);
				String tail = result1.substring(result1.length() - 1, result1.length());
				boolean headtrue = head.equals("[") && tail.equals("]");
				// ���Ϊ�ջ��߿ո���߻��з����򲻼��أ������������ĸΪ��[���ҽ�βΪ��]��Ҳ������
				if (result1.equals("") || result1.equals(" ") || result1.equals("\r\n") || headtrue == true) {

				} else {
					countl++;
				}
			}
			fr.close();
			bf.close();
			if(!(countl==listSize)) {
				//��������ļ�������������һ�������½�һ�������ļ�
			boolean delet	=files.delete();
				if(delet) {
				if (!files.exists()) {
					files.getParentFile().mkdirs();
					try {
						files.createNewFile();
						//��ȡf����ĳ��Ⱥ�����ͬʱд��һ��Ĭ������
						FileWriter fw = new FileWriter(files, true);
						fw.write("[-----------��ϵͳ�ļ�:����ɾ���޸ġ�----------]"); 
						fw.write("\r\n"); fw.flush();
						ArrayList<String> lista=this.getCategory();
						for (String sl : lista) {
							fw.write(sl+":1,0"); 
							fw.write("\r\n"); 
							fw.flush();
						}
						fw.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				};
				
			}}
			
		}
		//��ȡ�����ļ�������һ�����ϻ�������
		
			//��ȡ�����ļ�

			fr = new FileReader(files);
			bf = new BufferedReader(fr);
			
			// ���Ϊ�ջ��߿ո���߻��з����򲻼��أ������������ĸΪ��[���ҽ�βΪ��]��Ҳ������
			while((result1 = bf.readLine())!=null ) {

				// ��ȡ��һ���ַ�
				String head = result1.substring(0, 1);
				String tail = result1.substring(result1.length() - 1, result1.length());
				System.out.println("��ͷ" + head);
				System.out.println("��β" + tail);
				boolean headtrue = head.equals("[") && tail.equals("]");
			if (result1.equals("") || result1.equals(" ") || result1.equals("\r\n")||headtrue==true ) {
			} else {
				//����������һ��һ��String����ʽ���뵽list
					namelist.add(result1);
					System.out.println("���������ļ�");
						}
			}
					
		
		fr.close();
		bf.close();
		return namelist;
		
	}
	//���������ļ��ķ���
	
	public ArrayList<ConfigFileReader> ReaderConfigFile() throws Exception {
		
		ArrayList<String>config=this.ConfigFile();
		ArrayList<ConfigFileReader>values=new ArrayList<ConfigFileReader>();
		//���ļ�������key��value����ʽ����value��
		for (String s : config) {
			
			ConfigFileReader nameA=new ConfigFileReader() ;
			
			String keyname=s.substring(0,s.indexOf(":"));
			nameA.setName(keyname);
			
			String knumber=s.substring(s.length()-3,s.length()-2);
			nameA.setKeynumber(knumber);
			
			String Vnumber=s.substring(s.length()-1);
			nameA.setValuenumber(Vnumber);
			
			
			values.add(nameA);
		}
		return values;
		
		
	}
	
	
	
	
	

}
