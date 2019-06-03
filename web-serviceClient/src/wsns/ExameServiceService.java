/**
 * ExameServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsns;

public interface ExameServiceService extends javax.xml.rpc.Service {
    public java.lang.String getExameServiceAddress();

    public wsns.ExameService getExameService() throws javax.xml.rpc.ServiceException;

    public wsns.ExameService getExameService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
