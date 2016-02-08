
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class tags {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
				new FileReader("/Users/liqiang/Desktop/UPitt/2016 Spring/DA/Assignment/Mongo_assignment_1_25_16/tags.dat"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/liqiang/Desktop/UPitt/2016 Spring/DA/Assignment/Mongo_assignment_1_25_16/tags.json"));
		String line=null;
		while((line=br.readLine())!=null){
			//System.out.println(line);
			line = line.replace("\"","\'");
			String[] a = line.split("\\::");
			bw.write("{");
			bw.write("\"UserID\""+":"+"\""+a[0]+"\""+",");
			bw.write("\"MovieID\""+":"+"\""+a[1]+"\""+",");
			bw.write("\"Tag\""+":"+"\""+a[2]+"\""+",");
			bw.write("\"Timestamp\""+":"+"\""+a[3]+"\"");
			bw.write("}");
			bw.newLine();
		}
		br.close();
		bw.close();
		System.out.println("FINISH!");
		
	}
}
