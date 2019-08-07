package question1;

public class VirtualCommandPrompt {

	private Node currentDir;
	private Node root;

	public Node getRoot() {
		return root;
	}

	public VirtualCommandPrompt() {
		root = new Node(null, "R:");
		currentDir = root;
	}

	/**
	 * @param command for execution
	 * @return current directory
	 */
	public String vcp(String command) {
		command += " ";
		String cmd = command.substring(0, command.indexOf(" "));
		switch (cmd) {
			case "mkdir" :
				return mkdir(command);
			case "cd" :
				return cd(command);
			case "bk" :
				return bk();
			case "ls" :
				return ls();
			case "find" :
				find(command);
				return printDir(currentDir);
//			case "tree" :
//				tree(currentDir);
//				return printDir(currentDir);
			default :
				return null;
		}
	}

	/**
	 * @param command for make new folder
	 * @return current directory
	 */
	private String mkdir(String command) {
		//split folder name 
		String folderName = command.substring((command.indexOf(" ") + 1), (command.length() - 1));
		//create new node
		Node newNode = new Node(currentDir, folderName);
		//check node existence in current directory
		for (int i = 0; i < currentDir.childList.size(); i++) {
			if (currentDir.childList.get(i).getName().equals(folderName)) {
				return "directory already exists\n" + printDir(currentDir);
			}
		}
		//add new node in current directory
		currentDir.childList.add(newNode);
		return printDir(currentDir);
	}

	/**
	 * @param command for execution
	 * @return directory after command execution
	 */
	private String cd(String command) {
		String name = command.substring((command.indexOf(" ") + 1), (command.length() - 1));
		//check input directory is a path or not
		if (!name.contains("\\")) {
			for (int i = 0; i < currentDir.childList.size(); i++) {
				//find in current directory
				if (currentDir.childList.get(i).getName().equals(name)) {
					currentDir = currentDir.childList.get(i);
					return printDir(currentDir);
				}
			}
			return "directory does not exists\n" + printDir(currentDir);
		}
		//if input directory is in path form
		if (name.charAt(0) == 'R') {
			//check if input is only for root directory
			if (name.indexOf("\\") == (name.length() - 1)){
				return root.getName();
			}
			String remainingDir = name.substring((name.indexOf("\\") + 1), name.length());
			currentDir = root;
			//process remaining directory
			return root.getName() + "\\" + cdWithPath(remainingDir);
		}
		return "directory does not exists\n" + printDir(currentDir);
	}

	/**
	 * @param remaining directory for cd command execution
	 * @return directory after command execution
	 */
	private String cdWithPath(String remainingDir) {
		//if remaining directory has no path
		if (remainingDir.charAt(remainingDir.length() - 1) != '\\'){
			return "invalid path\n" + printDir(currentDir);
		}
		//if remaining directory is finish
		if (remainingDir.length() <= 1){
			return "";
		}
		//split child in remaining directory
		String child = remainingDir.substring(0, remainingDir.indexOf("\\"));
		for (int i = 0; i < currentDir.childList.size(); i++) {
			//check in child list of current directory
			if (currentDir.childList.get(i).getName().equals(child)) {
				currentDir = currentDir.childList.get(i);
				remainingDir = remainingDir.substring((remainingDir.indexOf("\\") + 1), remainingDir.length());
				return child + "\\" + cdWithPath(remainingDir);
			}
		}
		return "directory does not exists";
	}

	/**
	 * @return parent directory of current directory
	 */
	private String bk() {
		//if current directory is not root
		if (!currentDir.getName().equals(root.getName())) {
			currentDir = currentDir.getParent();
			return printDir(currentDir);
		}
		return root.getName() + "\\";
	}

	/**
	 * @return print list of folders and subfolder(s) of current directory
	 */
	private String ls() {
		for (int i = 0; i < currentDir.childList.size(); i++) {
			//print folder(s) of current directory
			System.out.println(currentDir.childList.get(i).getName() + "\t" + currentDir.childList.get(i).getDate());
			for (int j = 0; j < currentDir.childList.get(i).childList.size(); j++)
				System.out.println("\u2500" + currentDir.childList.get(i).childList.get(j).getName() + "\t" + currentDir.childList.get(i).childList.get(j).getDate());
		}
		return currentDir.childList.size() + " folder(s)";
	}

	/**
	 * @param command for find folder
	 */
	private boolean find(String command) {
		String nameOfFolder = command.substring((command.indexOf(" ") + 1), (command.length() - 1));
		for (int i = 0; i < currentDir.childList.size(); i++) {
			//check in current directory
			if (currentDir.childList.get(i).getName().equals(nameOfFolder)){
				System.out.println("\t" + printDir(currentDir));
				return true;
			}
			else {
				//check in subfolders
				for (int j = 0; j < currentDir.childList.get(i).childList.size(); j++) {
					if (currentDir.childList.get(i).childList.get(j).getName().equals(nameOfFolder)) {
						System.out.println("\t" + printDir(currentDir.childList.get(i)));
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * @param current directory 
	 * print path of folder if find
	 */
	private void tree(Node currentDir) {
		//if current directory has no folder
		if (currentDir.childList.size() == 0)
			return;
		for (int i = 0; i < currentDir.childList.size(); i++) {
			System.out.println("\u2514" + currentDir.childList.get(i).getName());
			tree(currentDir.childList.get(i));
		}
	}
	
	/**
	 * @param current Directory
	 * @return path of current directory
	 */
	private String printDir(Node currentDir) {
		Node child = currentDir;
		String dir = child.getName();
		while (child.getParent() != null) {
			child = child.getParent();
			dir = child.getName() + "\\" + dir;
		}
		return dir;
	}
}
