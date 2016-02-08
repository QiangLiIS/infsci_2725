
public class ratings {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
				new FileReader("/Users/victorzhao/Desktop/ratings.dat"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/victorzhao/Desktop/ratings.json"));
		String line=null;
		while((line=br.readLine())!=null){
			//System.out.println(line);
			String[] a = line.split("\\::");
			int b = Integer.parseInt(a[0]);
			int c = Integer.parseInt(a[1]);
			float d = Float.parseFloat(a[2]);
			int e = Integer.parseInt(a[3]);	
			bw.write("{");
			bw.write("\"UserID\""+":"+b+",");
			bw.write("\"MovieID\""+":"+c+",");
			bw.write("\"Rating\""+":"+d+",");
			bw.write("\"Timestamp\""+":"+e);
			bw.write("}");
			bw.newLine();
		}
		br.close();
		bw.close();
		System.out.println("FINISH!");
		
	}
}
