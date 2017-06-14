// This class was generated by 172 StubGenerator.
// Contents subject to change without notice.
// @generated

package org.azri.estore.mobile;

import javax.xml.rpc.JAXRPCException;
import javax.xml.namespace.QName;
import javax.microedition.xml.rpc.Operation;
import javax.microedition.xml.rpc.Type;
import javax.microedition.xml.rpc.ComplexType;
import javax.microedition.xml.rpc.Element;

public class OrderStatusSEI_Stub implements org.azri.estore.mobile.OrderStatusSEI, javax.xml.rpc.Stub {
	private String[] _propertyNames;
	private Object[] _propertyValues;

	public OrderStatusSEI_Stub() {
		_propertyNames = new String[] {ENDPOINT_ADDRESS_PROPERTY};
		_propertyValues = new Object[] {"http://azri:8080/eStore-Web/OrderStatus"};
	}

	public void _setProperty(String name, Object value) {
		int size = _propertyNames.length;
		for (int i = 0; i < size; ++i) {
			if (_propertyNames[i].equals(name)) {
				_propertyValues[i] = value;
				return;
			}
		}
		// Need to expand our array for a new property
		String[] newPropNames = new String[size + 1];
		System.arraycopy(_propertyNames, 0, newPropNames, 0, size);
		_propertyNames = newPropNames;
		Object[] newPropValues = new Object[size + 1];
		System.arraycopy(_propertyValues, 0, newPropValues, 0, size);
		_propertyValues = newPropValues;

		_propertyNames[size] = name;
		_propertyValues[size] = value;
	}

	public Object _getProperty(String name) {
		for (int i = 0; i < _propertyNames.length; ++i) {
			if (_propertyNames[i].equals(name)) {
				return _propertyValues[i];
			}
		}
		if (ENDPOINT_ADDRESS_PROPERTY.equals(name) || USERNAME_PROPERTY.equals(name) || PASSWORD_PROPERTY.equals(name)) {
			return null;
		}
		if (SESSION_MAINTAIN_PROPERTY.equals(name)) {
			return new java.lang.Boolean(false);
		}
		throw new JAXRPCException("Stub does not recognize property: "+name);
	}

	protected void _prepOperation(Operation op) {
		for (int i = 0; i < _propertyNames.length; ++i) {
			op.setProperty(_propertyNames[i], _propertyValues[i].toString());
		}
	}

	// 
	//  Begin user methods
	// 

	public java.lang.String getOrderStatus(java.lang.String string_1) throws java.rmi.RemoteException {
		// Copy the incoming values into an Object array if needed.
		Object[] inputObject = new Object[1];
		inputObject[0] = string_1;

		Operation op = Operation.newInstance(_qname_wsdl_getOrderStatus, _type_getOrderStatus, _type_getOrderStatusResponse);
		_prepOperation(op);
		op.setProperty(Operation.SOAPACTION_URI_PROPERTY, "");
		Object resultObj;
		try {
			resultObj = op.invoke(inputObject);
		} catch (JAXRPCException e) {
			Throwable cause = e.getLinkedCause();
			if (cause instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) cause;
			}
			throw e;
		}
		java.lang.String result;
		// Convert the result into the right Java type.
		// Unwrapped return value
		Object resultObj2 = ((Object[])resultObj)[0];
		result = (java.lang.String)resultObj2;
		return result;
	}
	// 
	//  End user methods
	// 

	protected static final QName _qname_String_1 = new QName("", "String_1");
	protected static final QName _qname_result = new QName("", "result");
	protected static final QName _qname_getOrderStatus = new QName("urn:OrderStatus/types", "getOrderStatus");
	protected static final QName _qname_getOrderStatusResponse = new QName("urn:OrderStatus/types", "getOrderStatusResponse");
	protected static final QName _qname_wsdl_getOrderStatus = new QName("urn:OrderStatus/wsdl", "getOrderStatus");
	protected static final Element _type_getOrderStatus;
	protected static final Element _type_getOrderStatusResponse;
	static {
		// Create all of the Type's that this stub uses, once.
		Element _type_String_1;
		_type_String_1 = new Element(_qname_String_1, Type.STRING, 1, 1, true);
		ComplexType _complexType_getOrderStatus;
		_complexType_getOrderStatus = new ComplexType();
		_complexType_getOrderStatus.elements = new Element[1];
		_complexType_getOrderStatus.elements[0] = _type_String_1;
		_type_getOrderStatus = new Element(_qname_getOrderStatus, _complexType_getOrderStatus);
		Element _type_result;
		_type_result = new Element(_qname_result, Type.STRING, 1, 1, true);
		ComplexType _complexType_getOrderStatusResponse;
		_complexType_getOrderStatusResponse = new ComplexType();
		_complexType_getOrderStatusResponse.elements = new Element[1];
		_complexType_getOrderStatusResponse.elements[0] = _type_result;
		_type_getOrderStatusResponse = new Element(_qname_getOrderStatusResponse, _complexType_getOrderStatusResponse);
	}

}