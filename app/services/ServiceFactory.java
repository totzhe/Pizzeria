package services;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 17.04.13
 * Time: 18:28
 * To change this template use File | Settings | File Templates.
 */
public class ServiceFactory {
    private static ServiceFactory instance;
    private IShowMenuService showMenuService;
    private IMakeOrderService makeOrderService;

    private ServiceFactory()
    {
    }

    public static ServiceFactory getInstance()
    {
        if (instance == null)
            instance = new ServiceFactory();
        return instance;
    }

    public IShowMenuService getShowMenuService()
    {
        if(showMenuService == null)
            showMenuService = new ShowMenuService();
        return showMenuService;
    }

    public IMakeOrderService getMakeOrderService()
    {
        if(makeOrderService == null)
            makeOrderService = new MakeOrderService();
        return makeOrderService;
    }
}

