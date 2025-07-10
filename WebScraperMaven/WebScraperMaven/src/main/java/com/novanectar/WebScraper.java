package com.novanectar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {
    public static void main(String[] args) {
        try {
            String url = "https://books.toscrape.com/";
            Document doc = Jsoup.connect(url).get();

            Elements books = doc.select(".product_pod");

            for (Element book : books) {
                String title = book.select("h3 a").attr("title");
                String price = book.select(".price_color").text();

                System.out.println("Title: " + title);
                System.out.println("Price: " + price);
                System.out.println("-------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
