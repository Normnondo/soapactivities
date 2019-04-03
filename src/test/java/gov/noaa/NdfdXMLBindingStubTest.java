package gov.noaa;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class NdfdXMLBindingStubTest {

    @Test
    void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();
        String result = binding.latLonListZipCode("53711");

        try {

            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // specify the location and name of xml file to be read
            String response = ("/response.xml");

            // this will create Java object - country from the XML file
            DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(response));
            assertEquals("43.0798,-89.3875", dwml);


        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        }


    }
}