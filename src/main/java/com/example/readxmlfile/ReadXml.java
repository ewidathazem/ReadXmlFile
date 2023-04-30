package com.example.readxmlfile;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.Scanner;

public class ReadXml {

    public static void main(String[] args) {
        try {
            while (true) {
                File inputFile = new File("Book.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document document = dBuilder.parse(inputFile);
                document.getDocumentElement().normalize();
                NodeList bookList = document.getElementsByTagName("book");
                System.out.println("please enter Book id : ");
                Scanner scanner = new Scanner(System.in);
                String bookId = scanner.nextLine();
                boolean bookFound = false;
                for (int i = 0; i < bookList.getLength(); i++) {
                    Element elementBook = (Element) bookList.item(i);
                    System.out.println(elementBook.getAttribute("author"));
                    if (bookId.equals(elementBook.getAttribute("id"))) {
                        String author = elementBook.getElementsByTagName("author").item(0).getTextContent();
                        String title = elementBook.getElementsByTagName("title").item(0).getTextContent();
                        String genre = elementBook.getElementsByTagName("genre").item(0).getTextContent();
                        String price = elementBook.getElementsByTagName("price").item(0).getTextContent();
                        String publishDate = elementBook.getElementsByTagName("publish_date").item(0).getTextContent();
                        String description = elementBook.getElementsByTagName("description").item(0).getTextContent();
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("Author: " + author);
                        System.out.println("Title: " + title);
                        System.out.println("Genre: " + genre);
                        System.out.println("Price: " + price);
                        System.out.println("Publish Date: " + publishDate);
                        System.out.println("Description: " + description);
                        System.out.println("--------------------------------------------------------------------------------");
                        bookFound = true;
                        break;
                    }
                }
                if (bookFound == false) {
                    System.out.println("book with id = " + bookId + " not found  try again. ");
                    System.out.println("--------------------------------------------------------------------------------");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}