package wsns;

public class ExameServiceProxy implements wsns.ExameService {
  private String _endpoint = null;
  private wsns.ExameService exameService = null;
  
  public ExameServiceProxy() {
    _initExameServiceProxy();
  }
  
  public ExameServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initExameServiceProxy();
  }
  
  private void _initExameServiceProxy() {
    try {
      exameService = (new wsns.ExameServiceServiceLocator()).getExameService();
      if (exameService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)exameService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)exameService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (exameService != null)
      ((javax.xml.rpc.Stub)exameService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wsns.ExameService getExameService() {
    if (exameService == null)
      _initExameServiceProxy();
    return exameService;
  }
  
  public int deleteExames(int[] idsExames) throws java.rmi.RemoteException{
    if (exameService == null)
      _initExameServiceProxy();
    return exameService.deleteExames(idsExames);
  }
  
  public int mergeExames(wsns.Exame[] exames) throws java.rmi.RemoteException{
    if (exameService == null)
      _initExameServiceProxy();
    return exameService.mergeExames(exames);
  }
  
  public wsns.Exame[] getExames() throws java.rmi.RemoteException{
    if (exameService == null)
      _initExameServiceProxy();
    return exameService.getExames();
  }
  
  
}