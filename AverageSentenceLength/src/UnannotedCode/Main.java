import java.util.HashSet;
public class Main {

	public static void main(String[] args) {
		int i = 0;
		String file = args[i++];
		String wordLength = null;
		HashSet<String> delimiters = new HashSet<>();
		for(int j = 0;j<2;j++) {
			if(i == args.length) {
				//do nothing
			}
			else if(args[i].equals("-l")) {
				i++;
				wordLength = args[i++];
			}
			else if(args[i].equals("-d")){
				i++;
				while((i < args.length) && !(args[i].equals("-l")) && !(args[i].equals("-i"))) {
					delimiters.add(args[i++]);
				}
			}
			else {
				;
			}
		}
		System.out.printf("%.2f",Validate.validateInput(file,wordLength,delimiters));
		}
	}
