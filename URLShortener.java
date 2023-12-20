import java.util.*;
import java.util.Base64;


public class URLShortener {
    private HashMap<String, String> urlMap; 

    public URLShortener() {
        urlMap = new HashMap<>();
    }

    
    public String shortenURL(String longURL) {
        String shortURL = generateShortURL(longURL);
        urlMap.put(shortURL, longURL);
        return shortURL;
    }

   
    public String getOriginalURL(String shortURL) {
        return urlMap.getOrDefault(shortURL, "Shortened URL not found.");
    }

    
    private String generateShortURL(String longURL) {
        byte[] bytes = longURL.getBytes();
        String encodedURL = Base64.getUrlEncoder().encodeToString(bytes);
        return encodedURL.substring(0, 8); 
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();
        Scanner in=new Scanner(System.in);
         System.out.println("ENTER THE URL TO CONVER SHORT URL:");
        String longURL = in.nextLine(); 

      
        String shortenedURL = shortener.shortenURL(longURL);
        System.out.println("Shortened URL: " + shortenedURL);

      
        String originalURL = shortener.getOriginalURL(shortenedURL);
        System.out.println("Original URL: " + originalURL);
    }
}

