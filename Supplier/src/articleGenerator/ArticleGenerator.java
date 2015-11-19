package articleGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class ArticleGenerator {
	
	public static void main(String args[]) throws IOException {
		FileOutputStream fos = new FileOutputStream("articles.json");
		fos.write(generateArticles().getBytes());
		fos.close();
	}

	public static String generateArticles(){
		String s = "";
		for (int i=1; i<=100; i++){
			if (i>1) s += "\n";
			s += "{";
			//s += 	"\"id\":\"" + UUID.randomUUID() + "\",";
			s += 	"\"name\":\"Nom article " + i + "\",";
			s += 	"\"description\":\"Description article " + i + "\",";
			s += 	"\"quantity\":" + (int)(Math.random() * 100) + ",";
			s += 	"\"price\":" + ((int)(Math.random() * 10000))/100.0 + "";
			s+= "}";
			
		}				
		return s;
	}
}
