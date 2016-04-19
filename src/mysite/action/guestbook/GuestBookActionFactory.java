package mysite.action.guestbook;

import mysite.web.action.Action;
import mysite.web.action.ActionFactory;

public class GuestBookActionFactory extends ActionFactory {
    @Override
    public Action getAction(String actionName) {
        Action action = null;

        if ("insert".equals(actionName)) {
            action = new GuestBookInsertAction();
        }
        else if ("delete".equals(actionName)) {
            action = new GuestBookDeleteAction();
        }
        else if ("ajax".equals(actionName)) {
            action = new GuestBookAjaxAction();
        }
        else if ("ajax-list".equals(actionName)) {
            action = new GuestBookAjaxListAction();
        }
        else if ("ajax-insert".equals(actionName)) {
            action = new GuestBookAjaxInsertAction();
        }
        else if ("ajax-delete".equals(actionName)) {
            action = new GuestBookAjaxDeleteAction();
        }
        else {
            action = new GuestBookListAction();
        }
        return action;
    }
}
