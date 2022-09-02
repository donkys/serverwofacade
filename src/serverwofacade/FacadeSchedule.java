package serverwofacade;


public class FacadeSchedule {
    private static FacadeSchedule myFacadeObj = null;

    private FacadeSchedule() {}

    public static FacadeSchedule getMyFacadeObj() {
        if (myFacadeObj == null) {
            myFacadeObj = new FacadeSchedule();
        }
        return myFacadeObj;
    }

    public void startProcess() {
        ScheduleServer obj = new ScheduleServer();
        obj.startBooting();
        obj.readSystemConfigFile();
        obj.init();
        obj.initializeContext();
        obj.initializeListeners();
        obj.createSystemObjects();
    }

    public void stopProcess() {
        ScheduleServer obj = new ScheduleServer();
        obj.releaseProcesses();
        obj.destory();
        obj.destroySystemObjects();
        obj.destoryListeners();
        obj.destoryContext();
        obj.shutdown();
    }

}
