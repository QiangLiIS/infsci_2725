import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class movies {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
				new FileReader("/Users/liqiang/Desktop/UPitt/2016 Spring/DA/Assignment/Mongo_assignment_1_25_16/movies.dat"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/liqiang/Desktop/UPitt/2016 Spring/DA/Assignment/Mongo_assignment_1_25_16/movies.json"));
		String line=null;
		while((line=br.readLine())!=null){
			String newline = line.replaceAll("\\|", "::");
			newline = newline.replace("\"","\'");
			String[] a = newline.split("\\::");
			String[] b = new String[a.length-2] ;
			for(int i = 2 ;i <a.length;i++)
			{
				b[i-2] = a[i];
			}
			bw.write("{");
			bw.write("\"MovieID\""+":"+"\""+a[0]+"\""+",");
			bw.write("\"Title\""+":"+"\""+a[1]+"\""+",");
			bw.write("\"Genres\""+":"+"[");
			for(int j = 0 ;j < b.length ;j++)
			{
				if(j!=b.length -1)
					bw.write("\""+b[j]+"\""+",");
				else
					bw.write("\""+b[j]+"\"");
			}
			bw.write("]");
			bw.write("}");
			bw.newLine();
		}
		br.close();
		bw.close();
		System.out.println("FINISH!");
		
	}
}
