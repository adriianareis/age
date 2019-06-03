/**
 * ExameServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsns;

public class ExameServiceServiceLocator extends org.apache.axis.client.Service implements wsns.ExameServiceService {

    public ExameServiceServiceLocator() {
    }


    public ExameServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ExameServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ExameService
    private java.lang.String ExameService_address = "http://localhost:8080/web-service/services/ExameService";

    public java.lang.String getExameServiceAddress() {
        return ExameService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ExameServiceWSDDServiceName = "ExameService";

    public java.lang.String getExameServiceWSDDServiceName() {
        return ExameServiceWSDDServiceName;
    }

    public void setExameServiceWSDDServiceName(java.lang.String name) {
        ExameServiceWSDDServiceName = name;
    }

    public wsns.ExameService getExameService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ExameService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getExameService(endpoint);
    }

    public wsns.ExameService getExameService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            wsns.ExameServiceSoapBindingStub _stub = new wsns.ExameServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getExameServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setExameServiceEndpointAddress(java.lang.String address) {
        ExameService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wsns.ExameService.class.isAssignableFrom(serviceEndpointInterface)) {
                wsns.ExameServiceSoapBindingStub _stub = new wsns.ExameServiceSoapBindingStub(new java.net.URL(ExameService_address), this);
                _stub.setPortName(getExameServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ExameService".equals(inputPortName)) {
            return getExameService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wsns", "ExameServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wsns", "ExameService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ExameService".equals(portName)) {
            setExameServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
