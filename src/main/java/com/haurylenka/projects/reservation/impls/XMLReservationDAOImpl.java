package com.haurylenka.projects.reservation.impls;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

import com.haurylenka.projects.reservation.beans.ResComponent;
import com.haurylenka.projects.reservation.beans.Reservation;
import com.haurylenka.projects.reservation.exceptions.ReservationDAOException;
import com.haurylenka.projects.reservation.interfaces.ReservationDAO;
import com.haurylenka.projects.reservation.utils.ReservationUtil;

import antlr.NameSpace;

public class XMLReservationDAOImpl implements ReservationDAO {
	
	private static final String TARGET = "reservationXMLFileName";

	@Override
	public Reservation getReaservation(String login) 
			throws ReservationDAOException {
		SAXBuilder builder = new SAXBuilder();
		String fileName = null;
		InputStream is = null;
		try {
			fileName = ReservationUtil.getProperty(TARGET);
			is = XMLReservationDAOImpl.class.getClassLoader()
					.getResourceAsStream(fileName);
			Document document = builder.build(is);
			Element rootNode = document.getRootElement();
			Reservation reservation = new Reservation();
			reservation.setCode(rootNode.getAttributeValue("Code"));
			reservation.setDescription(rootNode.getAttributeValue("Description"));
			reservation.setComponents(getComponents(rootNode));
			return reservation;
		} catch (Exception e) {
			throw new ReservationDAOException("XML parse exception", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// there is not much to do with this
				}
			}
		}
	}

	private List<ResComponent> getComponents(Element rootNode) {
		List<ResComponent> components = new ArrayList<>();
		List<Element> compElements = rootNode.getChildren("ResComponent", rootNode.getNamespace());
		if (compElements != null) {
			for (Element component : compElements) {
				ResComponent resComponent = new ResComponent();
				resComponent.setComponentTypeCode(component.getAttributeValue("ComponentTypeCode"));
				resComponent.setCreateDateTime(component.getAttributeValue("CreateDateTime"));
				resComponent.setInternalStatus(component.getAttributeValue("InternalStatus"));
				String sequenceStr = component.getAttributeValue("Sequence");
				int sequence = Integer.parseInt(sequenceStr);
				resComponent.setSequence(sequence);
				components.add(resComponent);
			}
		}
		
		return components;
	}

}
