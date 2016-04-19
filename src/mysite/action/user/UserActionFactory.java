package mysite.action.user;

import mysite.action.board.BoardDefaultAction;
import mysite.web.action.Action;
import mysite.web.action.ActionFactory;

public class UserActionFactory extends ActionFactory {
    @Override
    public Action getAction(String actionName) {
        Action action = null;

        if ("joinform".equals(actionName)) {
            action = new UserJoinFormAction();
        }
        else if ("join".equals(actionName)) {
            action = new UserJoinAction();
        }
        else if ("joinsuccess".equals(actionName)) {
            action = new UserJoinSuccessAction();
        }
        else if ("loginform".equals(actionName)) {
            action = new UserLoginFormAction();
        }
        else if ("login".equals(actionName)) {
            action = new UserLoginAction();
        }
        else if ("logout".equals(actionName)) {
            action = new UserLogoutAction();
        }
        else if ("modifyform".equals(actionName)) {
            action = new UserModifyFormAction();
        }
        else if ("modify".equals(actionName)) {
            action = new UserModifyAction();
        }
        else if ("checkemail".equals(actionName)) {
            action = new UserCheckEmailAction();
        }
        else {
            action = new BoardDefaultAction();
        }
        return action;
    }
}
