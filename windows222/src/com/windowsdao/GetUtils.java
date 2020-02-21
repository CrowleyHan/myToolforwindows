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

	// static //获取路径
	// 获取名字
	File resultFile;
	int result = 0;
	String result1;
//	 FileReader fr;
	final static String listAll = "D:\\SoftText\\list\\";
	final static String ini = ".ini";
	final static File config = new File("D:\\SoftText\\config\\config.ini");

	/**
	 * 执行Bat文件的方法
	 * 
	 * @throws IOException
	 * 
	 * 
	 */
	public boolean StartFile(File newpath) throws IOException {
//		windows：
//		Runtime.getRuntime().exec("explorer 文件路径“);
//		Linux：
//		Runtime.getRuntime().exec("nautilus 文件路径“);

		// 开始
		if (!newpath.isFile() && !newpath.isDirectory()) {
			System.out.println("不是是是");
			return false;
		} else {

			Process po = Runtime.getRuntime().exec("explorer " + newpath);
			// 执行完成后，终止该进程
//			po.destroy();立即终止会导致启动失败
			return po.isAlive();
		}

	}

	/**
	 * 将选择的目标程序写入文件,传入文件选择器获取的路径，并存储为默认的名字信息 添加文件夹返回值2，添加文件返回值1，添加系统图标，返回值3
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

		// 获取对应的分类文件
		File files = new File(listAll + category + ".ini");
		if (!files.exists()) {

		}
		try {
			files.createNewFile();
			FileWriter fw = new FileWriter(files, true);
			// 判断要存入的文件路径
			if (path.isFile()) {
				// 如果是文件，则按照文件编辑的规则生成新的String存入files，
				int ass = path.getName().lastIndexOf(".");
				String name1 = path.getName().substring(0, ass);
				fw.write(name1 + ":" + path.getPath());
				a = 1;
			} else if (path.isDirectory()) {
				// 如果是文件夹则按照文件夹的规则存储
				String s0 = path.getPath().substring(0, 1);

				String name2 = s0 + "盘" + path.getName();
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
	 * 通过name获取文件中需要的目标路径 传入软件名,返回启动路径
	 * 
	 * @throws IOException
	 * 
	 */
	public File getTextPath(String name, String category) {
		// path="微信";
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
	 * @param pathl:文件路径： 通过路径获取小图标
	 * @return 图标
	 */
	public Icon getSmallIcon(File file) {
//		Image aa= ((ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(file)).getImage();
//		Icon cc=new ImageIcon(aa);
		FileSystemView fsv = FileSystemView.getFileSystemView();
		return fsv.getSystemIcon(file);
	}

	/**
	 * 获取大图标
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
	 * 返回所有的分类的集合
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
	 * 返回程序的名称结果集
	 * 
	 * @param name,返回程序的名称结果集
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
	 * @param name 创建分类
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
					fw.write("[-----------【系统文件:请勿删除修改】----------]");
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
	 * 删除f分类
	 * 
	 * @param name要删除的文件名
	 * @return true删除成功false删除失败
	 */

	public boolean removeCategory(String name) {
		boolean res = true;
		File files = new File(listAll + name + ".ini");
		if (!files.exists()) {
			res = false;
		} else {
			res = files.delete();
			System.out.println("删除分类=" + res);

		}

		return res;

	}

	/**
	 * 删除程序快内容行
	 * 
	 * @param name图标名字
	 * @param cate图标分类
	 * @return 返回所有未删除内容
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
	 * @param list重新写入的内容
	 * @param file重写的文件
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
	 * 删除指定程序
	 * 
	 * @param category 程序所在分类
	 * @param oldName  / 程序名字
	 */
	public boolean RemoveName(String category, String oldName) {
		File files = new File(listAll + category + ".ini");

		boolean resR = true;
		try {
			// 传入所属分类category 和要删除的名字
			ArrayList<String> list = this.getRemove(oldName, files);
			resR = this.setRemove(list, files);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resR;
	}

	/**
	 * 删除程序快内容行
	 * 
	 * @param name 图标/程序的名字
	 * @param cate 图标/程序所属分类
	 * @return 返回更改后的所有未删除内容
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
	 * 重命名 /更新名字
	 * 
	 * @param name    原名
	 * @param cate    所在分类
	 * @param newName 新名字
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
			// 删除旧的cate，ini创建一个新的
		}
		return true;
	}

	/**
	 * 重命名：修改分类的名字
	 * 
	 * @param name    原名
	 * @param newName 新名字
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
	 * 处理ink文件，先用文件选择器方法返回一个File，辨别这个File是文件还是目录,如果是文件夹，则文件选择器会直接返回一个文件夹路径
	 * 如果是文件，则会返回一个ink路径，
	 * 如果返回的是ink路径，则调用GetInk中的方法，将这个File传入parse方法处理，返回一个String/或者处理成File
	 * 判断返回的结果，如果为null则是系统程序的快捷方式，没有目标路径，此时，返回文件选择器所反回的.ink路径， 否则，返回的是目标路径。 此时
	 * →1：调用文件选择器，返回File →2：判断File是否为文件夹，3：是文件夹，直接返回该File
	 * 4：不是文件夹：判断是否为快捷方式.Ink文件，不是，则直接返回该File。 5：是.ink文件 →
	 * 调用GetInk的parse方法，处理File，看返回值。 6：返回值为null，直接反回该File,若不为null，转成File返回
	 * 
	 * @param method
	 * @param category
	 * @return
	 * @throws Exception
	 */
	public File getInk(int method) {
		File file1 = null;
		try {
			// 调用getpath文件选择器，获取返回的路径file1，
			file1 = getPath(method);

			if (file1.isFile()) {
				// 如果是文件，则先判断文件类型
				String nameF = file1.getName();
				// 获取文件后缀
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
		// 过滤文件类型

		FileSystemView fsv = FileSystemView.getFileSystemView();
		jfc.setCurrentDirectory(fsv.getHomeDirectory());
		jfc.setDialogType(0);
		;
		// 使用系统中的图标
		jfc.setFileView(new FileView() {

			public Icon getIcon(File f) {
				return jfc.getFileSystemView().getSystemIcon(f);
			}
		});
		jfc.setApproveButtonText("确定");

		if (a == 0) {
			jfc.setDialogTitle("请选择文件");
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

		} else {
			jfc.setDialogTitle("请选择文件夹");

			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		}
		jfc.showOpenDialog(jfc);
		File resultFile = new File(jfc.getSelectedFile().getPath());

		return resultFile;
	}

	/**
	 * 内部方法，加载配置文件并获取上次浏览时候的地址
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
				System.out.println("上次打开路径：" + result1);
				f = new File(result1.substring(a + 1, result1.length()));
				System.out.println(f);
			}
		}
		br.close();
		fr.close();
		return f;
	}

	/**
	 * 将配置文件的路径读出来并修改新的路径，返回
	 * 
	 * @param path
	 * @return
	 */
	static ArrayList<String> ConfigGet(String path) {

//		File f1=new File("E:\\java课件\\强小辉备忘文档");
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
					// 将新的地址写入
					String newPath1 = "defaultPath=" + path;
					System.out.println("oldpath：==" + result1);
					System.out.println("newpath：==" + newPath1);
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
			// 删除旧的cate，ini创建一个新的
		}

		return strl;

	}

	static void ConfigSet(ArrayList<String> list) {

		File files = new File("D:\\SoftText\\config\\config.ini");

	}

	/**
	 * 加载配置文件的方式
	 * @throws Exception 
	 * 
	 */
	public ArrayList<String> ConfigFile() throws Exception {

		File files = new File("D:\\SoftText\\config\\config.ini");
		File listFile=new File(listAll);
		ArrayList<String> namelist = new ArrayList<String>();
		FileReader fr = null; BufferedReader bf=null;
		int listSize=this.getCategory().size();
		// 加载配置文件的方式：1： 先判断是否存在，如果不存在，先扫描list目录并生成一个默认的配置文件。
		// 2 ： 如果文件已经存在，
		// 2.1 ： 判断配置文件中，分类的数量，和list目录下，list。size的长度是否相同，如果不同则重新生成一个新的配置文件。
		// 2.2 ： 如果判断相同，则将文件内容读取出来放到数组中，并返回
		if (!files.exists()) {
			files.getParentFile().mkdirs();
			try {
				files.createNewFile();
				//获取f分类的长度和名字同时写入一段默认配置
				FileWriter fw = new FileWriter(files, true);
				fw.write("[-----------【系统文件:请勿删除修改】----------]"); 
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
			//如果已经存在，判断长度是否相符合，如果不符合则重新生成。
			//先获取文件行数

			fr = new FileReader(files);
			bf = new BufferedReader(fr);
			result1 = bf.readLine();
				int countl=0;
			while (null != (result1 = bf.readLine())) {
				// 获取第一个字符
				String head = result1.substring(0, 1);
				String tail = result1.substring(result1.length() - 1, result1.length());
				boolean headtrue = head.equals("[") && tail.equals("]");
				// 如果为空或者空格或者换行符，则不加载，或者如果首字母为‘[’且结尾为‘]’也不加载
				if (result1.equals("") || result1.equals(" ") || result1.equals("\r\n") || headtrue == true) {

				} else {
					countl++;
				}
			}
			fr.close();
			bf.close();
			if(!(countl==listSize)) {
				//如果配置文件内配置数量不一样，则新建一个配置文件
			boolean delet	=files.delete();
				if(delet) {
				if (!files.exists()) {
					files.getParentFile().mkdirs();
					try {
						files.createNewFile();
						//获取f分类的长度和名字同时写入一段默认配置
						FileWriter fw = new FileWriter(files, true);
						fw.write("[-----------【系统文件:请勿删除修改】----------]"); 
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
		//读取配置文件并返回一个集合或者数组
		
			//读取配置文件

			fr = new FileReader(files);
			bf = new BufferedReader(fr);
			
			// 如果为空或者空格或者换行符，则不加载，或者如果首字母为‘[’且结尾为‘]’也不加载
			while((result1 = bf.readLine())!=null ) {

				// 获取第一个字符
				String head = result1.substring(0, 1);
				String tail = result1.substring(result1.length() - 1, result1.length());
				System.out.println("开头" + head);
				System.out.println("结尾" + tail);
				boolean headtrue = head.equals("[") && tail.equals("]");
			if (result1.equals("") || result1.equals(" ") || result1.equals("\r\n")||headtrue==true ) {
			} else {
				//满足条件的一行一个String的形式插入到list
					namelist.add(result1);
					System.out.println("放入配置文件");
						}
			}
					
		
		fr.close();
		bf.close();
		return namelist;
		
	}
	//解析配置文件的方法
	
	public ArrayList<ConfigFileReader> ReaderConfigFile() throws Exception {
		
		ArrayList<String>config=this.ConfigFile();
		ArrayList<ConfigFileReader>values=new ArrayList<ConfigFileReader>();
		//将文件解析成key：value的形式存在value里
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
