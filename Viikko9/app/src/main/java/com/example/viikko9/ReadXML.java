package com.example.viikko9;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ReadXML {
    private static ReadXML readXML;
    ArrayList<Theater> Theaters = new ArrayList<Theater>();
    ArrayList<String> Titles = new ArrayList<String>();
    ArrayList<String> Times = new ArrayList<String>();
    ArrayList<String> Areas = new ArrayList<String>();

    private ReadXML() {
    }

    public static ReadXML getInstance() {
        if (readXML == null) {
            readXML = new ReadXML();
        }
        return readXML;
    }

    public static ArrayList<String>  getNames() {
        ArrayList<String> Theatre_areas = new ArrayList<String>();
        for (int i = 0; i < ReadXML.getInstance().Theaters.size(); i++) {
            Theatre_areas.add(ReadXML.getInstance().Theaters.get(i).getName());
        }
        return Theatre_areas;
    }


    public void Read(){
        try{
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlAreasString = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document areadoc = builder.parse(urlAreasString);
            areadoc.getDocumentElement().normalize();
            NodeList nList = areadoc.getDocumentElement().getElementsByTagName("TheatreArea");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Theater temp = new Theater();
                    temp.setId(element.getElementsByTagName("ID").item(0).getTextContent());
                    temp.setName(element.getElementsByTagName("Name").item(0).getTextContent());
                    Theaters.add(temp);
                }

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            System.out.println("&&&&&&&&&&VALMIS&&&&&&&&&&&");
        }
    }
    public void Movies(String name, String id, String date, int stime, int etime) {
        try {
            if (Titles != null) Titles.clear();
            if (Times != null) Times.clear();
            if (Areas != null) Areas.clear();
            DocumentBuilder movie_builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            if (date.equals("")) {
                    date = (Calendar.getInstance().getTime()).toString();
                }
            if ((!name.equals("")) && (id.equals("1029"))) {
                ArrayList<String> idlist = new ArrayList<String>();
                String[] ids = {"1014", "1015", "1016", "1017", "1041", "1018", "1019", "1021", "1022"};
                for (int a = 0; a < 9; a++) {
                    idlist.add(ids[a]);
                }
                for (int b = 0; b < idlist.size(); b++) {
                    String urlMovieString = "https://www.finnkino.fi/xml/Schedule/?area=" + idlist.get(b) + "&dt=" + date;
                    Document moviedoc = movie_builder.parse(urlMovieString);
                    moviedoc.getDocumentElement().normalize();
                    System.out.println("Root element: " + moviedoc.getDocumentElement().getNodeName());

                    NodeList nList = moviedoc.getDocumentElement().getElementsByTagName("Show");
                    for (int i = 0; i < nList.getLength(); i++) {
                        Node node = nList.item(i);
                        System.out.println("Element is this: " + node.getNodeName());
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;
                            String area = element.getElementsByTagName("Theatre").item(0).getTextContent();
                            String mst = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                            String title = element.getElementsByTagName("Title").item(0).getTextContent();
                            int movie_time = Integer.parseInt(mst.substring(mst.lastIndexOf('T') + 1).replaceAll(":", ""));
                            if ((movie_time >= stime) && (movie_time <= etime) && name.equals(title)) {
                                Areas.add(area);
                                Titles.add(title);
                                Times.add((mst.substring(mst.lastIndexOf('T') + 1)));
                            }
                        }
                    }
                }

            } else {
                String urlMovieString = "https://www.finnkino.fi/xml/Schedule/?area=" + id + "&dt=" + date;
                Document moviedoc = movie_builder.parse(urlMovieString);
                moviedoc.getDocumentElement().normalize();
                NodeList nList = moviedoc.getDocumentElement().getElementsByTagName("Show");
                if (name.equals("")) {
                    for (int i = 0; i < nList.getLength(); i++) {
                        Node node = nList.item(i);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;
                            String area = element.getElementsByTagName("Theatre").item(0).getTextContent();
                            String title = element.getElementsByTagName("Title").item(0).getTextContent();
                            String mst = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                            int movie_time = Integer.parseInt(mst.substring(mst.lastIndexOf('T') + 1).replaceAll(":", ""));
                            if ((movie_time >= stime) && (movie_time <= etime)) {
                                Areas.add(area);
                                Titles.add(title);
                                Times.add((mst.substring(mst.lastIndexOf('T') + 1)));
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < nList.getLength(); i++) {
                        Node node = nList.item(i);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;
                            String area = element.getElementsByTagName("Theatre").item(0).getTextContent();
                            String title = element.getElementsByTagName("Title").item(0).getTextContent();
                            String mst = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                            int movie_time = Integer.parseInt(mst.substring(mst.lastIndexOf('T') + 1).replaceAll(":", ""));
                            if ((movie_time >= stime) && (movie_time <= etime) && (name.equals(title))) {
                                Areas.add(area);
                                Titles.add(title);
                                Times.add((mst.substring(mst.lastIndexOf('T') + 1)));
                            }
                        }
                    }
                }

            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            System.out.println("!!!!!!!!!!!!!VALMIS!!!!!!!!");
        }
    }
}

class Theater {

    private String name;
    private String Id;

    public void setId(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
