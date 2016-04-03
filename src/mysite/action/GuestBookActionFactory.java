package mysite.action;

import web.action.Action;
import web.action.ActionFactory;

public class GuestBookActionFactory extends ActionFactory{
    @Override
    public Action getAction(String actionName) {
        Action action = null;

        if ("insert".equals(actionName)) {
            action = new InsertAction();
        }
        else if ("delete".equals(actionName)) {
            action = new DeleteAction();
        }
        else {
            action = new GuestListAction();
        }
        return action;
    }
}
