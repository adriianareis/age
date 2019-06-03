/**
 * ExameService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsns;

public interface ExameService extends java.rmi.Remote {
    public int deleteExames(int[] idsExames) throws java.rmi.RemoteException;
    public int mergeExames(wsns.Exame[] exames) throws java.rmi.RemoteException;
    public wsns.Exame[] getExames() throws java.rmi.RemoteException;
}
