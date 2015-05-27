/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import generated.ActivitiesT;
import generated.ActivityT;
import generated.DistributionFieldT;
import generated.FieldsT;
import generated.Group;
import generated.Groups;
import generated.ObjectFactory;
import java.awt.Component;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author s124392
 */
public abstract class Controller {
    //<editor-fold defaultstate="collapsed" desc="Instance Variables">
    protected List<Group> groups;
    protected List<DistributionFieldT> fields;
    protected List<ActivityT> activities;
    protected List<String> selection;
    //</editor-fold>
   
    public Controller() {
        
    }
    
    protected int getDuplicateActivityIndex(String name) {
        int index = 0;
        for (ActivityT activity : activities) {
            if (activity.getName().contains(name)) {
                String[] words = activity.getName().split(" ");
                String word = words[words.length - 1];
                word = word.replace("(", "");
                word = word.replace(")", "");
                try {
                    int aux = Integer.parseInt(word);
                    if (aux > index) {
                        index = aux;
                    }
                } catch (NumberFormatException e) {
                    // Do nothing.
                }
            }
        }
        return index + 1;
    }
    
    protected int getDuplicateFieldIndex(String name) {
        int index = 0;
        for (DistributionFieldT field : fields) {
            if (field.getName().contains(name)) {
                String[] words = field.getName().split(" ");
                String word = words[words.length - 1];
                word = word.replace("(", "");
                word = word.replace(")", "");
                try {
                    int aux = Integer.parseInt(word);
                    if (aux > index) {
                        index = aux;
                    }
                } catch (NumberFormatException e) {
                    // Do nothing.
                }
            }
        }
        return index + 1;
    }
    
    protected int getDuplicateGroupIndex(String name) {
        int index = 0;
        for (Group group : groups) {
            if (group.getName().contains(name)) {
                String[] words = group.getName().split(" ");
                String word = words[words.length - 1];
                word = word.replace("(", "");
                word = word.replace(")", "");
                try {
                    int aux = Integer.parseInt(word);
                    if (aux > index) {
                        index = aux;
                    }
                } catch (NumberFormatException e) {
                    // Do nothing.
                }
            }
        }
        return index + 1;
    }
    
    protected void unmarshallGroups(String file) {
        Unmarshaller unmarshaller;
        try {
            unmarshaller = getUnmarshaller(getClass().getResource(
                    "/schemas/groupSchema.xsd"));
            Source source = new StreamSource(file);
            JAXBElement<Groups> unmarshalledObject = unmarshaller.unmarshal(
                    source, Groups.class);
            groups = unmarshalledObject.getValue().getGroup();
        } catch (JAXBException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }
    
    protected void unmarshallFields(String file) {
        Unmarshaller unmarshaller;
        try {
            unmarshaller = getUnmarshaller(getClass().getResource(
                    "/schemas/fieldSchema.xsd"));
            Source source = new StreamSource(file);
            JAXBElement<FieldsT> unmarshalledObject = unmarshaller.unmarshal(
                    source, FieldsT.class);
            fields = unmarshalledObject.getValue().getField();
        } catch (JAXBException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }
    
    protected void unmarshallActivities(String file) {
        Unmarshaller unmarshaller;
        try {
            unmarshaller = getUnmarshaller(getClass().getResource(
                    "/schemas/activitySchema.xsd"));
            Source source = new StreamSource(file);
            JAXBElement<ActivitiesT> unmarshalledObject =
                    unmarshaller.unmarshal(source, ActivitiesT.class);
            activities = unmarshalledObject.getValue().getActivity();
        } catch (JAXBException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }
    
    protected void marshallActivities(String f) throws JAXBException {
        Marshaller marshaller;
        try {
            marshaller = getMarshaller(getClass().getResource(
                    "/schemas/activitySchema.xsd"));
            OutputStream os = new FileOutputStream(f);
            ActivitiesT activitiesT = new ActivitiesT();
            for (ActivityT activity : activities) {
                activitiesT.getActivity().add(activity);
            }
            ObjectFactory objectFactory = new ObjectFactory();
            JAXBElement<ActivitiesT> jaxbElement = objectFactory.createActivities(activitiesT);
            marshaller.marshal(jaxbElement, os);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void marshallFields(String f) throws JAXBException {
        Marshaller marshaller;
        try {
            marshaller = getMarshaller(getClass().getResource(
                    "/schemas/fieldSchema.xsd"));
            OutputStream os = new FileOutputStream(f);
            FieldsT fieldsT = new FieldsT();
            for (DistributionFieldT field : fields) {
                fieldsT.getField().add(field);
            }
            ObjectFactory objectFactory = new ObjectFactory();
            JAXBElement<FieldsT> jaxbElement = objectFactory.createFields(fieldsT);
            marshaller.marshal(jaxbElement, os);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void marshallGroups(String f) throws JAXBException {
        Marshaller marshaller;
        try {
            marshaller = getMarshaller(getClass().getResource(
                    "/schemas/groupSchema.xsd"));
            OutputStream os = new FileOutputStream(f);
            Groups groupsT = new Groups();
            for (Group group : groups) {
                groupsT.getGroup().add(group);
            }
            ObjectFactory objectFactory = new ObjectFactory();
            JAXBElement<Groups> jaxbElement = objectFactory.createGroups(groupsT);
            marshaller.marshal(jaxbElement, os);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected Group getGroupByName(String name) {
        Group result = null;
        for (Group group: groups) {
            if (group.getName().equals(name)) {
                result = group;
                break;
            }
        }
        return result;
    }
    
    protected DistributionFieldT getFieldByName(String name) {
        DistributionFieldT result = null;
        for (DistributionFieldT field : fields) {
            if (field.getName().equals(name)) {
                result = field;
                break;
            }
        }
        return result;
    }
    
    protected ActivityT getActivityByName(String name) {
        ActivityT result = null;
        for (ActivityT activity : activities) {
            if (activity.getName().equals(name)) {
                result = activity;
                break;
            }
        }
        return result;
    }
    
    protected void toggleInnerComponents(Component component, boolean enabled) {
        if (component instanceof Container) {
            for (Component inner : ((Container) component).getComponents()) {
                toggleInnerComponents(inner, enabled);
            }
        }
        component.setEnabled(enabled);
    }
    
    
    
    private Unmarshaller getUnmarshaller(URL url) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SchemaFactory schemaFactory = SchemaFactory.newInstance(
                XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema; 
        try {
            schema = schemaFactory.newSchema(url);
            unmarshaller.setSchema(schema);
        return jaxbContext.createUnmarshaller();
        } catch (SAXException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
            return null;
        }
    }
    
    private Marshaller getMarshaller(URL url) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        SchemaFactory schemaFactory = SchemaFactory.newInstance(
                XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema;
        try {
            schema = schemaFactory.newSchema(url);
            marshaller.setSchema(schema);
        } catch (SAXException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return marshaller;
    }
}
