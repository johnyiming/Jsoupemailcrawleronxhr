package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstTestHTMLParse {

    public static void main(String[] args) {

        Integer x;
        Integer y;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter from x page\n");
        x = Integer.valueOf(myObj.nextLine());
        System.out.println("Enter to y page\n");
        y = Integer.valueOf(myObj.nextLine());

        Document doc;
        try {

            for (int i = x; i < y; i++) {



            doc = Jsoup.connect("https://xihua.es/forum.php?mod=forumdisplay&fid=25&page="+i).get();

            // get title of the page
            String title = doc.title();

            System.out.println("第: " + i+"页搜索结果\n");

            //Save to File output.txt
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\User\\Documents\\javaproject\\Jsoupemailcrawleronxhr\\outputurls.txt",true));
            bw.write("第: " + i + "页搜索结果\n");
            bw.close();




            Elements container = doc.getElementsByClass("bm_c");


            // get all links
            Elements links = container.select("td.icn a[href]");
            for (Element link : links) {

                String linkresult= link.attr("href");

                // get the value from href attribute
                System.out.println("\nhttps://xihua.es/"+linkresult+"\n");



                //Save to File output.txt
                BufferedWriter bw2 = new BufferedWriter(new FileWriter("C:\\Users\\User\\Documents\\javaproject\\Jsoupemailcrawleronxhr\\outputurls.txt",true));
                bw2.write("\nhttps://xihua.es/"+linkresult+"\n");
                bw2.close();

                                //Trim Email From linkresult
                String s = new Scanner(new URL("https://xihua.es/"+linkresult).openStream(), "UTF-8").useDelimiter("\\A").next();
                Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9_.+-]+\\.[a-zA-Z0-9_.+-]+", Pattern.CASE_INSENSITIVE).matcher(s);

                LinkedList nodeList = new LinkedList<>();

                while (m.find()) {
                        nodeList.add(m.group());
                        System.out.println(nodeList);

                        BufferedWriter bw3 = new BufferedWriter(new FileWriter("C:\\Users\\User\\Documents\\javaproject\\Jsoupemailcrawleronxhr\\outputemaillist.txt",true));

                        bw3.write(String.valueOf(nodeList));

                        bw3.close();

                }

            }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}