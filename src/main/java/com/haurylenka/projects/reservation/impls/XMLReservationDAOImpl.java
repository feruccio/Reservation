package com.haurylenka.projects.reservation.impls;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.haurylenka.projects.reservation.beans.AncillaryAirComponent;
import com.haurylenka.projects.reservation.beans.Customer;
import com.haurylenka.projects.reservation.beans.FareFamily;
import com.haurylenka.projects.reservation.beans.Payment;
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
			reservation.setCustomer(getCustomer(rootNode));
			reservation.setFareFamily(getFareFamily(rootNode));
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

	private FareFamily getFareFamily(Element rootNode) {
		FareFamily fare = null;
		Element fElement = 
				rootNode.getChild("FareFamily", rootNode.getNamespace());
		if (fElement != null) {
			fare = new FareFamily();
			fare.setFareFamilyCode(
					fElement.getAttributeValue("FareFamilyCode"));
			fare.setComponents(getFareComponents(fElement));
		}
		return fare;
	}

	private List<AncillaryAirComponent> getFareComponents(Element fElement) {
		List<AncillaryAirComponent> components = new ArrayList<>();
		List<Element> cElements = fElement.getChildren(
				"AncillaryAirComponent", fElement.getNamespace());
		if (cElements != null) {
			for (Element cEl : cElements) {
				AncillaryAirComponent c = new AncillaryAirComponent();
				c.setAncillaryAirComponentCode(
						cEl.getAttributeValue("AncillaryAirComponentCode"));
				components.add(c);
			}
		}
		return components;
	}

	private Customer getCustomer(Element rootNode) {
		Customer customer = null;
		Element custElement = 
				rootNode.getChild("Customer", rootNode.getNamespace());
		if (custElement != null) {
			customer = new Customer();
			Element email = 
					custElement.getChild("Email", custElement.getNamespace());
			customer.setEmail(email.getAttributeValue("EmailAddress"));
			Element phone = 
					custElement.getChild("Phone", custElement.getNamespace());
			customer.setPhone(phone.getAttributeValue("PhoneNumber"));
			customer.setPayments(getPayments(custElement));
		}
		return customer;
	}

	private List<Payment> getPayments(Element custElement) {
		List<Payment> payments = new ArrayList<>();
		List<Element> paymentElements = 
				custElement.getChildren("Payment", custElement.getNamespace());
		if (paymentElements != null) {
			for (Element pElement : paymentElements) {
				Payment payment = new Payment();
				payment.setAmountPaid(
						pElement.getAttributeValue("AmountPaid"));
				payment.setFormOfPaymentTypeCode(
						pElement.getAttributeValue("FormOfPaymentTypeCode"));
				payment.setCurrencyCode(
						pElement.getAttributeValue("CurrencyCode"));
				payments.add(payment);
			}
		}
		return payments;
	}

	private List<ResComponent> getComponents(Element rootNode) {
		List<ResComponent> components = new ArrayList<>();
		List<Element> compElements = 
				rootNode.getChildren("ResComponent", rootNode.getNamespace());
		if (compElements != null) {
			for (Element component : compElements) {
				ResComponent resComponent = new ResComponent();
				resComponent.setComponentTypeCode(
						component.getAttributeValue("ComponentTypeCode"));
				resComponent.setCreateDateTime(
						component.getAttributeValue("CreateDateTime"));
				resComponent.setInternalStatus(
						component.getAttributeValue("InternalStatus"));
				String sequenceStr = component.getAttributeValue("Sequence");
				int sequence = Integer.parseInt(sequenceStr);
				resComponent.setSequence(sequence);
				components.add(resComponent);
			}
		}
		return components;
	}

}
