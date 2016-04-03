package mysite.action;

import web.action.Action;
import web.action.ActionFactory;

public class BoardActionFactory extends ActionFactory {
    @Override
    public Action getAction(String actionName) {
        Action action = null;

        if ("modify".equals(actionName)) {

        }
        else if ("view".equals(actionName)) {

        }
        else if ("write".equals(actionName)) {

        }
        else {
            action = new BoardListAction();
        }
        return action;
    }
}