package xml;

import com.google.gson.Gson;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlRegistry;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRegistry
public class Ap {

    private static final String PACKAGE = JaxBTest.class.getPackage().getName();

    public static void main(String[] args) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(PACKAGE);
        List<CustomObject> myList = new ArrayList<>();
        myList.add(new CustomObject(1, "One"));
        myList.add(new CustomObject(2, "Two"));
        myList.add(new CustomObject(3, "Three"));

        JaxBTest jaxB = new JaxBTest(8, myList);
        File file = new File("C:\\Users\\Oleksandr_Kalinin\\IdeaProjects\\pdf_test\\src\\xml\\new.xml");

        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Unmarshaller um = jc.createUnmarshaller();

        m.marshal(jaxB, file);
        JaxBTest jax = (JaxBTest) um.unmarshal(file);

        m.getClass();
        System.out.println(jax.toString());
        Gson gson = new Gson();
        String json = gson.toJson(jaxB);
        System.out.println(json);
        JaxBTest fromGson = gson.fromJson(json, JaxBTest.class);
        System.out.println(fromGson);
    }
}
