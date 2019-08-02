package Question1;

public class VirtualCommandPrompt {

	Node currentDir;
	Node root;
	public VirtualCommandPrompt() {
		root = new Node(null, "R:\\");
		currentDir = root; 
	}
	public String vcp(String command) {
		String cmd = command.substring(0, command.indexOf(" "));
		String name = "";
		switch (cmd) {
			case "mkdir" :
				name = command.substring(command.indexOf(" "), command.length());
				Node newNode = new Node(currentDir, name);
				for (int i = 0; i < currentDir.childList.size(); i++) {
					if (currentDir.childList.get(i).getName().equals(name)) {
						currentDir.childList.add(newNode);
						return currentDir.getName();
					}
				}
				return "directory already exists";
			case "cd" :
				name = command.substring(command.indexOf(" "), command.length());
				if (!name.contains("/")) {
				 if(currentDir.getName().equals("R:\\")){
					for (int i = 0; i < currentDir.childList.size(); i++) {
						if (currentDir.childList.get(i).getName().equals(name)) {
							currentDir = currentDir.childList.get(i);
							return currentDir.getName();
						} 
					}
				    return "directory does not exists";

				} else
					return cd(name);
			  } 
			default :
				return " ";
		}
	}

	private String cd(String name) {
		String crtdir = name.substring(0, name.indexOf("\\"));
		if (!crtdir.equals("R:\\")){
			currentDir = root;
		}
		String newCmd = name.substring(name.indexOf("\\"),name.indexOf("\\"));
		for (int i = 0; i < currentDir.childList.size(); i++) {
			if (currentDir.childList.get(i).getName().equals(newCmd)) {
				currentDir = currentDir.childList.get(i);
				return currentDir.getName();
			} 
		}
		newCmd = name.substring(name.indexOf("\\"),name.length());
		return cd(newCmd);
		
	}
		
			
}
