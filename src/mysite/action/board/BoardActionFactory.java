package mysite.action.board;

import mysite.web.action.Action;
import mysite.web.action.ActionFactory;

public class BoardActionFactory extends ActionFactory {
    @Override
    public Action getAction(String actionName) {
        Action action = null;

        if ("modify".equals(actionName)) {
            action = new BoardModifyAction();
        }
        else if ("modifyform".equals(actionName)) {
            action = new BoardModifyFormAction();
        }
        else if ("view".equals(actionName)) {
            action = new BoardViewAction();
        }
        else if ("write".equals(actionName)) {
            action = new BoardWriteAction();
        }
        else if ("writeform".equals(actionName)) {
            action = new BoardWriteFormAction();
        }
        else if ("reply".equals(actionName)) {
            action = new BoardReplyAction();
        }
        else if ("replyform".equals(actionName)) {
            action = new BoardReplyFormAction();
        }
        else if ("delete".equals(actionName)) {
            action = new BoardDeleteAction();
        }
        else {
            action = new BoardListAction();
        }
        return action;
    }
}